import java.util.Scanner;

import exceptions.SemSaldoException;
import program.DAO.Model.Comprador;
import DAO.*;
import program.DAO.Model.Carrinho;
import program.DAO.Model.Compra;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("----------------------");
        System.out.println("Olá, seja bem vindo a nossa loja de jogos: a Nexus Store!");
        System.out.println("Antes de você poder acessar a loja precisamos que você insira suas informações abaixo: \n");
        System.out.print("CPF: ");
        int cpfUsuario = entrada.nextInt();
        System.out.print("Nome: ");
        String nomeUsuario = entrada.next();
        System.out.print("E-mail: ");
        String emailUsuario = entrada.next();
        System.out.print("Deposite um valor em sua conta: ");
        int saldoUsuario = entrada.nextInt();
        System.out.println("\nAgora que você já inseriu as suas informações, fique à vontade para explorar a nossa loja!\n");

        boolean menu = true;

        CompradorDAO compradorDAO = new CompradorDAO();
        Comprador comprador = new Comprador(cpfUsuario, nomeUsuario, emailUsuario, saldoUsuario);
        compradorDAO.insertComprador(comprador);
        JogoDAO jogoDAO = new JogoDAO();
        Carrinho carrinho = new Carrinho(cpfUsuario ,cpfUsuario);
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        carrinhoDAO.insertCarrinho(carrinho);
        Carrinho_has_JogoDAO carrinhoHasJogoDAO = new Carrinho_has_JogoDAO();
        Jogo_has_PlataformaDAO jogoHasPlataformaDAO = new Jogo_has_PlataformaDAO();
        CompraDAO CompraDAO = new CompraDAO();

        double valorTotal = 0;


        while(menu) {
            System.out.println("1 - Listar todos os jogos disponíveis");
            System.out.println("2 - Adicionar jogo ao carrinho");
            System.out.println("3 - Retirar jogo do carrinho");
            System.out.println("4 - Ver custo atual do carrinho");
            System.out.println("5 - Depositar saldo na conta");
            System.out.println("6 - Finalizar compra e sair da loja");
            System.out.println("7 - Sair da conta e encerrar o acesso\n");

            int opcao = entrada.nextInt();


            switch (opcao) {
                case 1:
                    System.out.println("----------------------");
                    System.out.println("Lista de jogos disponíveis: ");
                    jogoDAO.selectJogo();
                    System.out.println("\n Cada jogo so pode ser adquirido uma unica vez por usuario");
                    System.out.println("\nPlataformas em que cada jogo esta disponível: ");
                    jogoHasPlataformaDAO.selectJogo_has_Plataforma();
                    break;
                case 2:
                    System.out.println("----------------------");
                    System.out.println("Digite o id do jogo que você deseja adicionar ao carrinho: ");
                    int jogo = entrada.nextInt();
                    carrinhoHasJogoDAO.insertCarrinho_has_Jogo(carrinhoDAO.selectCarrinhoID(cpfUsuario), jogo);
                    try {
                        compradorDAO.removerSaldo(cpfUsuario, jogoDAO.selectJogoPreco(jogo));
                        double valorCheck = compradorDAO.verSaldo(cpfUsuario);
                        if( valorCheck <= 0.0) {
                            valorTotal -= jogoDAO.selectJogoPreco(jogo);
                        }
                        valorTotal += jogoDAO.selectJogoPreco(jogo);
                        if(compradorDAO.verSaldo(cpfUsuario) < 0.0) {
                            compradorDAO.adicionarSaldo(cpfUsuario, jogoDAO.selectJogoPreco(jogo));
                            valorTotal -= jogoDAO.selectJogoPreco(jogo);
                            throw new SemSaldoException();
                        }
                        else {
                            System.out.println("Jogo adicionado ao carrinho com sucesso!");
                            System.out.println("Seu saldo atual é de: " + compradorDAO.verSaldo(cpfUsuario));
                        }
                    }
                    catch (SemSaldoException e) {
                        System.out.println("Você não tem saldo suficiente para comprar esse jogo!");
                        System.out.println("Seu saldo atual é de: " + compradorDAO.verSaldo(cpfUsuario));
                    }
                    break;
                case 3:
                    System.out.println("----------------------");
                    System.out.println("Digite o id do jogo que você deseja retirar do carrinho: ");
                    int jogo2 = entrada.nextInt();
                    carrinhoHasJogoDAO.deleteCarrinho_Has_Jogo(carrinhoDAO.selectCarrinhoID(cpfUsuario), jogo2);
                    valorTotal -= jogoDAO.selectJogoPreco(jogo2);
                    compradorDAO.adicionarSaldo(cpfUsuario, jogoDAO.selectJogoPreco(jogo2));
                    System.out.println("Jogo removido do carrinho com sucesso!");
                    System.out.println("Seu saldo atual é de: " + compradorDAO.verSaldo(cpfUsuario));
                    break;
                case 4:
                    System.out.println("----------------------");
                    System.out.println("O custo atual do seu carrinho é de: " + valorTotal);
                    break;
                case 5:
                    System.out.println("----------------------");
                    System.out.println("Digite o valor que você deseja depositar: ");
                    int valor = entrada.nextInt();
                    compradorDAO.adicionarSaldo(cpfUsuario, valor);
                    System.out.println("Depósito realizado com sucesso! Seu saldo atual é de: " + compradorDAO.verSaldo(cpfUsuario));
                    break;
                    case 6:
                        System.out.println("----------------------");
                        System.out.println("Obrigado por comprar na Nexus Store!");
                        compradorDAO.verSaldo(cpfUsuario);
                        Compra compra = new Compra(cpfUsuario,valorTotal, carrinhoDAO.selectCarrinhoID(cpfUsuario));
                        CompraDAO compraDAO = new CompraDAO();
                        compraDAO.insertCompra(compra);
                        compradorDAO.removerSaldo(cpfUsuario, valorTotal);
                        System.out.println("Compra realizada com sucesso! Seu saldo atual é de: " + compradorDAO.verSaldo(cpfUsuario));
                        menu = false;
                        break;
                case 7:
                    System.out.println("----------------------");
                    System.out.println("Obrigado por visitar a Nexus Store!");
                    System.out.println("Saindo da conta e excluindo dados...");
                    carrinhoDAO.deleteCarrinho(cpfUsuario);
                    compradorDAO.deleteComprador(cpfUsuario);
                    menu = false;
                    break;
            }
        }

    }
}
