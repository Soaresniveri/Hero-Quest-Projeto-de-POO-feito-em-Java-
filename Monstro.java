
public class Monstro extends Entidade {
	private int xp;
	private Equipamento drop;
	
	public Monstro (String nome, int vida, int atkFisico, int atkMagico, int defFisica, int defMagica, int xp, Equipamento drop){
		super (nome, vida, atkFisico, atkMagico, defFisica, defMagica );
		this.xp = xp;
		this.drop = drop;
		}
	
	// Dano monstro
	
	@Override
		public void atacar(Entidade alvo){
		System.out.printf("%s atacou com furia!", nome);
		alvo.receberDanoFisico(atkFisico);
	}
	
	// Getters classe monstro
	
	public int getVida(){
		return vida;
		}
		
	public int getAtkFisico(){
		return atkFisico;
		}
		
	public String getNome(){
		return nome;
		}
		
	public int getXp(){
		return xp;
		}
		
	public Equipamento getDrop() {
    return drop;
	}
}

