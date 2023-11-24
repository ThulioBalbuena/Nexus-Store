import DAO.JogoDAO;
import program.DAO.Model.Comprador;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Olá, seja bem vindo a nossa loja de jogos: a Nexus Store!");
        System.out.println("Antes de você poder acessar a loja precisamos que você insira suas informações.");

        System.out.println("\nNome: ");
        String nomeUsuario = entrada.nextLine();
        System.out.println("E-mail: ");
        String emailUsuario = entrada.nextLine();
        System.out.println("Senha: ");
        int senhaUsuario = entrada.nextInt();
        System.out.println("Saldo: ");
        int saldoUsuario = entrada.nextInt();

        Comprador usuario = new Comprador(nomeUsuario, emailUsuario, senhaUsuario, saldoUsuario);

        System.out.println("\nAgora que você já inseriu as suas informações, fique à vontade para explorar a nossa loja!");

        boolean menu = true;
        int opcao;

        while(menu) {

            System.out.println("1 - Listar todos os jogos disponíveis");
            System.out.println("2 - Escolher um gênero e listar todos os jogos disponíveis desse gênero");
            System.out.println("3 - Adicionar jogo ao carrinho");
            System.out.println("4 - Retirar jogo do carrinho");
            System.out.println("5 - Mostrar quais jogos estão no carrinho");
            System.out.println("6 - Mostrar custo total atual do carrinho");
            System.out.println("7 - Finalizar compra e encerrar o programa\n");

            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    menu = false;
                    break;
            }

        }

    }
}
