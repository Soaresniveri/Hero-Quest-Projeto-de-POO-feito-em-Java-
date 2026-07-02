
public abstract class Personagem extends Entidade {
		protected int xp;
		protected int nivel;
		protected Equipamento equipamento;
		
		// Construtor da classe Personagem
		public Personagem ( String nome, int vida, int atkFisico, int atkMagico, int defFisica, int defMagica, int xp, int nivel ){
			super(nome, vida, atkFisico, atkMagico, defFisica, defMagica );
			this.xp = xp;
			this.nivel = nivel;
			}
		
		// Vida do personagem 
		
		public void dano(int dano){
			this.vida -= dano;
			if (vida <= 0){
				System.out.println("O personagem morreu!");
				}
			}
		
		public void cura(int cura){
			this.vida += cura;
			System.out.printf("O heroi curou %d de vida", cura);
			}
			
		// Atacando
		
		@Override
		public void atacar(Entidade alvo) {
			alvo.receberDanoFisico(this.atkFisico);
			System.out.printf("O heroi atacou o %s e causou %d de dano%n", alvo.getNome(), atkFisico);
		}

		public void atacarMagico(Entidade alvo) {
			alvo.receberDanoMagico(this.atkMagico);
			System.out.printf("O heroi lancou magia em %s e causou %d de dano magico%n", alvo.getNome(), atkMagico);
		}
		
		// Subindo de nivel
		
		public void ganharXp (int quantidade){
			this.xp += quantidade;
			System.out.printf("O heroi ganhou %d de experiencia%n", quantidade);
			
			while(this.xp >= 100){
				SubirDeNivel();
				}
			}
			
		public void SubirDeNivel (){
			this.nivel++;
			this.atkFisico++;
			this.atkMagico++;
			this.defFisica++;
			this.defMagica++;
			this.vida++;
			
			this.xp -= 100;
			System.out.printf("O heroi subiu para o nivel %d%n", nivel);
			}
			
		// Equipamentos
		
			public void equipar(Equipamento equipamento) {
		if (equipamento.getClassePermitida().equals(getClasse())) {
			this.equipamento = equipamento;
			this.atkFisico += equipamento.getBonusAtkFisico();
			this.atkMagico += equipamento.getBonusAtkMagico();
			this.defFisica += equipamento.getBonusDefFisica();
			this.defMagica += equipamento.getBonusDefMagica();
			System.out.println("Equipado: " + equipamento.getNome());
		} else {
			System.out.println("Esse equipamento nao eh compatível com sua classe.");
		}
	}

	public abstract String getClasse();
		
		// Restaura progresso
		public void restaurarProgresso(int vida, int xp, int nivel) {
			this.vida = vida;
			this.xp = xp;
			this.nivel = nivel;
		}
		
		// Getters do Personagem
		
		public int getVida() {
			return vida;
		}

		public int getXp() {
			return xp;
		}

		public int getNivel() {
			return nivel;
		}

		public String getNome() {
			return nome;
		}
}


