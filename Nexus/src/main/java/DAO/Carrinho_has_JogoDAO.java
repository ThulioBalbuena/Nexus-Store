package DAO;

import program.DAO.Model.Carrinho_has_Jogo;
import program.DAO.Model.Jogo;
import java.sql.SQLException;
import java.util.ArrayList;

public class Carrinho_has_JogoDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertCarrinho_has_Jogo(int carrinho_idCarrinho, int Jogo_idjogo) {
        connectToDB();
        Carrinho_has_Jogo carrinhoHasJogo = new Carrinho_has_Jogo(carrinho_idCarrinho, Jogo_idjogo);
        // Adiciona o Jogo ao carrinho na tabela N-M
        String sql = "INSERT INTO Carrinho_has_Jogo (Carrinho_idCarrinho, Jogo_idjogo) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, carrinhoHasJogo.getCarrinho_idCarrinho());
            pst.setInt(2, carrinhoHasJogo.getJogo_idjogo());
            pst.execute();
            System.out.println("Jogo adicionado ao Carrinho");
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: Jogo inexistente");
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean deleteCarrinho_Has_Jogo(int idCarrinho, int idjogo) {
        connectToDB();
        // Remove o Jogo do carrinho
        String sql = "DELETE FROM carrinho_has_Jogo where Carrinho_idCarrinho=? AND Jogo_idjogo=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCarrinho);
            pst.setInt(2, idjogo);
            pst.execute();
            System.out.println("Jogo removido do Carrinho");
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: Jogo não está no carrinho");
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
    public double exibirCarrinho(int cpf) {
        connectToDB();
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        int idCarrinho = carrinhoDAO.selectCarrinhoID(cpf);
        double precoAux = 0; // Armazena o valor total do carrinho
        // Mostra id, nome e valor dos Jogos que estão no carrinho
        String sql = "SELECT p.idjogo, p.nome, p.Preco FROM Jogo as p, Carrinho_has_Jogo as chp, Carrinho as c WHERE p.idjogo = chp.Jogo_idjogo AND chp.carrinho_idCarrinho = c.idCarrinho AND chp.carrinho_idCarrinho =?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,idCarrinho);
            rs = pst.executeQuery();
            System.out.println("Carrinho atual: ");
            while (rs.next()) {
                Jogo JogoAux = new Jogo(rs.getInt("idjogo"),rs.getString("Nome"),rs.getString("Genero_nome"),rs.getDouble("Preco"),rs.getInt("ano_de_lancamento"),rs.getInt("qtd_jogadores"));
                System.out.println("ID = " + JogoAux.getidjogo());
                System.out.println("Nome = " + JogoAux.getNome());
                System.out.println("Genero = " + JogoAux.getGenero_nome());
                System.out.println("Valor = R$ " + String.format("%.2f",JogoAux.getPreco()));
                System.out.println("--------------------------------");
                precoAux += JogoAux.getPreco(); // Soma o valor dos itens
            }
            System.out.println("Valor da Compra no Carrinho: R$ " + String.format("%.2f",precoAux));
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return precoAux; // Retorna o valor total dos itens do carrinho
    }

    public ArrayList<Integer> selectJogosCarrinho(int idCarrinho){
        connectToDB();
        ArrayList<Integer> Jogos = new ArrayList<>(); // Armazena os IDs de todos os Jogos que estão no carrinho
        String sql = "SELECT p.idjogo FROM Jogo as p, carrinho_has_Jogo as chp, carrinho as c WHERE p.idjogo = chp.Jogo_idjogo AND chp.carrinho_idCarrinho = c.idCarrinho AND chp.carrinho_idCarrinho =?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,idCarrinho);
            rs = pst.executeQuery();
            while (rs.next()) {
                Jogos.add(rs.getInt("idjogo")); // Adiciona no arraylist
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return Jogos; // Retorna os IDs de todos os Jogos do carrinho
    }

    public boolean removerItensCarrinho(int idCarrinho) {
        connectToDB();
        // Remove todos os itens do carrinho
        String sql = "DELETE FROM Carrinho_has_Jogo where Carrinho_idCarrinho=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCarrinho);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
}