//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;
import program.DAO.Model.Comprador;
import DAO.*;
import program.DAO.Model.Jogo_has_Plataforma;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Olá, seja bem vindo a nossa loja de jogos: a Nexus Store!");
        System.out.println("Antes de você poder acessar a loja precisamos que você insira suas informações.\n");
        System.out.print("CPF: ");
        String cpfUsuario = entrada.nextLine();
        System.out.print("Nome: ");
        String nomeUsuario = entrada.nextLine();
        System.out.print("E-mail: ");
        String emailUsuario = entrada.nextLine();
        //System.out.println("Senha: ");
        //int senhaUsuario = entrada.nextInt();
        System.out.print("Deposite um valor em sua conta: ");
        int saldoUsuario = entrada.nextInt();
        new Comprador(cpfUsuario, nomeUsuario, emailUsuario, saldoUsuario);
        System.out.println("\nAgora que você já inseriu as suas informações, fique à vontade para explorar a nossa loja!\n");

        boolean menu = true;

        JogoDAO jogoDAO = new JogoDAO();
        CompradorDAO compradorDAO = new CompradorDAO();
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        Carrinho_has_JogoDAO carrinhoHasJogoDAO = new Carrinho_has_JogoDAO();
        Jogo_has_PlataformaDAO jogoHasPlataformaDAO = new Jogo_has_PlataformaDAO();

        while(menu) {
            System.out.println("1 - Listar todos os jogos disponíveis");
            System.out.println("2 - Escolha um genero para ver todos os jogos disponíveis: ");
            System.out.println("3 - Adicionar jogo ao carrinho");
            System.out.println("4 - Retirar jogo do carrinho");
            System.out.println("5 - Mostrar quais jogos estão no carrinho");
            System.out.println("6 - Mostrar custo total atual do carrinho");
            System.out.println("7 - Finalizar compra e sair da loja");
            System.out.println("8 - Sair da loja\n");

            int opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Lista de jogos disponíveis: ");
                    jogoDAO.selectJogo();
                    System.out.println("\nPlataformas em que cada jogo esta disponível: ");
                    jogoHasPlataformaDAO.selectJogo_has_Plataforma();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    System.out.println("Obrigado por comprar na Nexus Store!");
                    menu = false;
                    break;
                case 8 :
                    menu = false;
                    break;
            }
        }

    }
}
