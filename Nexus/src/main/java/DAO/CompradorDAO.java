package DAO;

import program.DAO.Model.Comprador;
import java.sql.SQLException;

public class CompradorDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertComprador(Comprador Comprador) {
        connectToDB();
        // Adiciona um novo usuário na tabela
        String sql = "INSERT INTO Comprador (cpf, nome, email, saldo) values (?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, Comprador.getCpf());
            pst.setString(2, Comprador.getNome());
            pst.setString(3, Comprador.getEmail());
            pst.setInt(4, Comprador.getSaldo());
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
    public void removerSaldo(int cpf, double valorTotal) {
        connectToDB();
        // Diminui o saldo conforme o valor da compra
        String sql = "UPDATE Comprador SET saldo = saldo - ? where cpf=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setDouble(1, valorTotal);
            pst.setInt(2, cpf);
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
    }

    public double verSaldo (int cpf) {
        connectToDB();
        // Mostra o saldo do usuário
        double saldo = 0;
        String sql = "SELECT saldo FROM Comprador WHERE cpf=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cpf);
            rs = pst.executeQuery();
            if(rs.next()){
                saldo = rs.getDouble("saldo");
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
        return saldo;
    }

    public double adicionarSaldo (int cpf, double valor) {
        connectToDB();
        // Adiciona saldo ao usuário
        double saldo = 0;
        String sql = "UPDATE Comprador SET saldo = saldo + ? where cpf=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setDouble(1, valor);
            pst.setInt(2, cpf);
            pst.execute();
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return saldo;
    }
}