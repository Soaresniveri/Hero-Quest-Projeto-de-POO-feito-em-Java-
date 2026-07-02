	
	public class Equipamento {
		private String nome;
		private String classePermitida;
		private int bonusAtkFisico;
		private int bonusAtkMagico;
		private int bonusDefFisica;
		private int bonusDefMagica;

		public Equipamento(String nome, String classePermitida, int bonusAtkFisico, int bonusAtkMagico, int bonusDefFisica, int bonusDefMagica) {
			this.nome = nome;
			this.classePermitida = classePermitida;
			this.bonusAtkFisico = bonusAtkFisico;
			this.bonusAtkMagico = bonusAtkMagico;
			this.bonusDefFisica = bonusDefFisica;
			this.bonusDefMagica = bonusDefMagica;
		}

		public String getNome() {
			return nome;
		}

		public String getClassePermitida() {
			return classePermitida;
		}

		public int getBonusAtkFisico() {
			return bonusAtkFisico;
		}

		public int getBonusAtkMagico() {
			return bonusAtkMagico;
		}

		public int getBonusDefFisica() {
			return bonusDefFisica;
		}

		public int getBonusDefMagica() {
			return bonusDefMagica;
		}
	}
