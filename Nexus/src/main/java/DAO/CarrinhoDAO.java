package DAO;

import program.DAO.Model.Carrinho;
import java.sql.SQLException;

public class CarrinhoDAO extends ConnectionDAO {
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertCarrinho(Carrinho Carrinho) {
        connectToDB();
        // Adiciona um novo carrinho na tabela
        String sql = "INSERT INTO Carrinho (idCarrinho, Comprador_cpf) values (?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, Carrinho.getComprador_cpf());
            pst.setInt(2, Carrinho.getIdCarrinho());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
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
    public int selectCarrinhoID(int Comprador_cpf) {
        connectToDB();
        // Pega o ID do Carrinho que pertence ao usuário do ID fornecido
        String sql = "SELECT idCarrinho FROM Carrinho, Comprador WHERE Carrinho.Comprador_cpf=?";
        int idCarrinho = 0;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, Comprador_cpf);
            rs = pst.executeQuery();
            if(rs.next()){
                idCarrinho = rs.getInt("idCarrinho");
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return idCarrinho;
    }

    //delete
    public boolean deleteCarrinho(int idCarrinho) {
        connectToDB();
        String sql = "DELETE FROM Carrinho where idCarrinho=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCarrinho);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
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