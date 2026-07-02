
import java.util.ArrayList;

public class Fase {
    private String nome;
    private ArrayList<Monstro> monstros;

    public Fase(String nome) {
        this.nome = nome;
        this.monstros = new ArrayList<>();
    }

    public void adicionarMonstro(Monstro monstro) {
        monstros.add(monstro);
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Monstro> getMonstros() {
        return monstros;
    }

    public boolean foiConcluida() {
        return monstros.isEmpty();
    }
}
