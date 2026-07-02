import java.util.*;

public class Heroquest {
	
	public static void main (String[] args) {
		Scanner leia = new Scanner (System.in);
		Random random = new Random();
		
		Personagem heroi = null;

		System.out.println("1 - Novo jogo");
		System.out.println("2 - Carregar jogo");
		int escolhaInicial = leia.nextInt();
		leia.nextLine();

		if (escolhaInicial == 2) {
			heroi = SaveManager.carregarPersonagem();

			if (heroi == null) {
				System.out.println("Comecando novo jogo...");
			}
		}

		if (heroi == null) {
			System.out.printf("Digite o nome do heroi dessa jornada: ...");
			String nome = leia.nextLine();

			System.out.println("\nEscolha sua classe:");
			System.out.println("1 - Guerreiro");
			System.out.println("2 - Mago");
			System.out.println("3 - Arqueiro\n");

			int classe = leia.nextInt();
			leia.nextLine();

			if (classe == 1) {
				heroi = new Guerreiro(nome);
			} else if (classe == 2) {
				heroi = new Mago(nome);
			} else {
				heroi = new Arqueiro(nome);
			}
		}
		
		// Fases
		Fase floresta = new Fase("Floresta");
		Fase deserto = new Fase("Deserto");
		Fase montanha = new Fase("Montanha");
		
		// Equipamentos
		Equipamento espada = new Equipamento("Espada de Ferro", "Guerreiro", 3, 0, 2, 0);
		Equipamento cajado = new Equipamento("Cajado Arcano", "Mago", 0, 4, 0, 2);
		Equipamento arco = new Equipamento("Arco Longo", "Arqueiro", 3, 0, 1, 1);
		
		// Monstros
		ArrayList<Monstro> monstros = new ArrayList<>();
		monstros.add(new Monstro("Slime", 10, 2, 0, 0, 0, 25, null));
		monstros.add(new Monstro("Goblin", 15, 4, 0, 1, 0, 50, espada));
		monstros.add(new Monstro("Orc", 25, 6, 0, 2, 1, 75, arco));
		monstros.add(new Monstro("Dragao vermelho", 50, 10, 1, 2, 1, 100, cajado));
		
		// Escolhe monstro
		Monstro inimigo = null;
		if(monstros.size() > 0 && inimigo == null){
			int indice = random.nextInt(monstros.size());
			inimigo = monstros.get(indice);
		}
		
		// Menu do jogo ====== HERO QUEST ======= //
		while(monstros.size() > 0){

			// Status do heroi
			System.out.println("\n=== HEROQUEST ===\n");
			System.out.println("Heroi: " + heroi.getNome());
			System.out.println("Vida: " + heroi.getVida());
			System.out.println("Nivel: " + heroi.getNivel());
			System.out.println("XP: " + heroi.getXp());

			// Status do inimigo
			System.out.println("\nInimigo: " + inimigo.getNome());
			System.out.println("Vida do inimigo:" + inimigo.getVida() + "\n");

			// Menu do jogador
			System.out.println("1 - Ataque fisico");
			System.out.println("2 - Ataque magico");
			System.out.println("3 - Curar");
			System.out.println("4 - Salvar");
			System.out.println("5 - Sair");
			int opcao = leia.nextInt();

			// Opcao 01 - Ataque fisico
			if(opcao == 1){
				heroi.atacar(inimigo);
				if(inimigo.getVida() > 0){
					inimigo.atacar(heroi);
				}
			}
			
			// Opcao 02 - Ataque magico
			else if (opcao == 2){
				heroi.atacarMagico(inimigo);
				if(inimigo.getVida() > 0){
					inimigo.atacar(heroi);
				}
			}
			
			// Opcao 03 - Curar vida
			else if(opcao == 3){
				heroi.cura(5);
			}
			
			// Opcao 04 - Salvar jogo
			else if (opcao == 4) {
				SaveManager.salvar(heroi, "Floresta");
			}
			
			
			// Opcao 05 - Sair do jogo
			else if(opcao == 5){
				System.out.println("Fim de jogo!");
				break;
			}
			else{
				System.out.println("Opcao invalida!");
			}
			
			if (heroi.getVida() <= 0 ){
				System.out.println("Game over!");
				break;
			}

			if(inimigo.getVida() <= 0){
				System.out.println(inimigo.getNome() + " foi derrotado!");
				
				heroi.ganharXp(inimigo.getXp());
				
				Equipamento drop = inimigo.getDrop();
				
				if (drop != null) {
					System.out.println("O inimigo deixou cair: " + drop.getNome());
					heroi.equipar(drop);
				}
				monstros.remove(inimigo);
				inimigo = null;

				if(monstros.size() > 0){
					int indice = random.nextInt(monstros.size());
					inimigo = monstros.get(indice);

					System.out.println("\nUm novo inimigo apareceu: " + inimigo.getNome());
				}
			}
		}
	}
}

