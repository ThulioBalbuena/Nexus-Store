import program.DAO.Model.Genero;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Olá, seja bem vindo a nossa loja de jogos: a Nexus Store!");
        System.out.println("Antes de começarmos, precisamos cadastrar pelo menos um gênero de jogo.\nQuando se cansar, basta inserir a palavra ACABOU.");

        boolean inserirGenero = true;
        String nomeGenero;
        int idGenero;

        Scanner entrada = new Scanner(System.in);

        while(true) {
            nomeGenero = entrada.next();

            if (Objects.equals(nomeGenero, "ACABOU")) {
                break;
            }

            idGenero = entrada.nextInt();
            new Genero(nomeGenero, idGenero);
        }

    }
}
