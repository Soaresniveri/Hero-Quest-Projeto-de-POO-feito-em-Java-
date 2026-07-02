
public abstract class Entidade {
		protected String nome;
		protected int vida;
		protected int atkFisico;
		protected int atkMagico;
		protected int defFisica;
		protected int defMagica;

	public Entidade(String nome, int vida, int atkFisico, int atkMagico, int defFisica, int defMagica ){
		this.vida = vida;
		this.atkFisico = atkFisico;
		this.atkMagico = atkMagico;
		this.defFisica = defFisica;
		this.defMagica = defMagica;
		this.nome = nome;
		}

	public void receberDanoFisico(int dano){
		int danoFinal = Math.max(dano - defFisica, 1);
		vida -= danoFinal;
		}
		
		public void receberDanoMagico(int dano){
		int danoFinal = Math.max(dano - defMagica, 1);
		vida -= danoFinal;
		}
	
	public void atacar(Entidade alvo){
        System.out.println("Ataque genérico");
        alvo.receberDanoFisico(atkFisico);
    }

	public int getVida(){
		return vida;
		}

	public String getNome(){
		return nome;
	}
}
