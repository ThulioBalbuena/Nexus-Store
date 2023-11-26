package DAO;

import program.DAO.Model.Carrinho;
import program.DAO.Model.Carrinho_has_Jogo;
import program.DAO.Model.Jogo;
import java.sql.SQLException;
import java.util.ArrayList;

public class Carrinho_has_JogoDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public void insertCarrinho_has_Jogo(int Carrinho_idCarrinho, int Jogo_idjogo) {
        connectToDB();
        Carrinho_has_Jogo carrinhoHasJogo = new Carrinho_has_Jogo(Carrinho_idCarrinho, Jogo_idjogo);
        // Adiciona o Jogo ao carrinho na tabela N-M
        String sql = "INSERT INTO Carrinho_has_Jogo (Carrinho_idCarrinho, Jogo_idjogo) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, carrinhoHasJogo.getCarrinho_idCarrinho());
            pst.setInt(2, carrinhoHasJogo.getJogo_idjogo());
            pst.execute();
            System.out.println("Processando solicitação...");
        } catch (SQLException exc) {
            System.out.println("Erro: Jogo inexistente ou ja inserido, encerrando aplicação...");
            System.exit(0);
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
    }

    public boolean deleteCarrinho_Has_Jogo(int idCarrinho, int nome) {
        connectToDB();
        String sql = "DELETE FROM carrinho_has_Jogo where Carrinho_idCarrinho=? AND Jogo_idjogo=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCarrinho);
            pst.setInt(2, nome);
            pst.execute();
            System.out.println("Processando solicitação...");
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

}