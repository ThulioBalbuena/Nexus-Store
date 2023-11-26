package DAO;

import program.DAO.Model.Compra;
import java.sql.SQLException;


public class CompraDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertCompra(Compra compra) {
        connectToDB();
        // Insere o valor, data e FK do usuário que realizou a compra na tabela
        String sql = "INSERT INTO Compra (idCompra, valor, Comprador_cpf) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, compra.getIdCompra());
            pst.setDouble(2, compra.getValor());
            pst.setInt(3, compra.getComprador_cpf());
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


    public double verCustoDeCompraAtual (int idCompra) {
        connectToDB();
        // Mostra o valor da compra
        String sql = "SELECT valor FROM Compra WHERE idCompra=?";
        double valor = 0;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCompra);
            rs = pst.executeQuery();
            if(rs.next()){
                valor = rs.getDouble("valor");
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
        return valor;
    }

}