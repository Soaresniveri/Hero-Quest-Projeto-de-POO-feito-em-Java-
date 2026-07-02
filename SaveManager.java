import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SaveManager {

    public static void salvar(Personagem personagem, String faseAtual) {
        try {
            FileWriter writer = new FileWriter("save.txt");

            writer.write("nome=" + personagem.getNome() + "\n");
            writer.write("classe=" + personagem.getClasse() + "\n");
            writer.write("vida=" + personagem.getVida() + "\n");
            writer.write("nivel=" + personagem.getNivel() + "\n");
            writer.write("xp=" + personagem.getXp() + "\n");
            writer.write("fase=" + faseAtual + "\n");

            writer.close();

            System.out.println("Jogo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o jogo.");
        }
    }

    public static Personagem carregarPersonagem() {
        try {
            Map<String, String> dados = lerSave();

            String nome = dados.get("nome");
            String classe = dados.get("classe");
            int vida = Integer.parseInt(dados.get("vida"));
            int nivel = Integer.parseInt(dados.get("nivel"));
            int xp = Integer.parseInt(dados.get("xp"));

            Personagem personagem;

            if (classe.equals("Guerreiro")) {
                personagem = new Guerreiro(nome);
            } else if (classe.equals("Mago")) {
                personagem = new Mago(nome);
            } else {
                personagem = new Arqueiro(nome);
            }

            personagem.restaurarProgresso(vida, xp, nivel);

            System.out.println("Save carregado com sucesso!");
            return personagem;

        } catch (Exception e) {
            System.out.println("Nao foi possivel carregar o save.");
            return null;
        }
    }

    public static String carregarFase() {
        try {
            Map<String, String> dados = lerSave();
            return dados.get("fase");
        } catch (Exception e) {
            return "Floresta";
        }
    }

    private static Map<String, String> lerSave() throws IOException {
        Map<String, String> dados = new HashMap<>();
        File arquivo = new File("save.txt");
        Scanner leitor = new Scanner(arquivo);

        while (leitor.hasNextLine()) {
            String linha = leitor.nextLine();
            String[] partes = linha.split("=");

            if (partes.length == 2) {
                dados.put(partes[0], partes[1]);
            }
        }

        leitor.close();
        return dados;
    }
}
