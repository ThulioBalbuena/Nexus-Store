package DAO;

import program.DAO.Model.Jogo;
import java.sql.SQLException;
import java.util.ArrayList;

public class JogoDAO extends ConnectionDAO {
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertJogo(Jogo Jogo) {
        connectToDB();
        // Insere as informações do Jogo na tabela
        String sql = "INSERT INTO Jogo (Nome, Preco, ano_de_lancamento, qtd_jogadores) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Jogo.getNome());
            pst.setDouble(2, Jogo.getPreco());
            pst.setInt(3, Jogo.getAno_de_lancamento());
            pst.setInt(4, Jogo.getQtd_jogadores());
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

    //UPDATE
    public boolean updateJogo(int id, Jogo Jogo) {
        connectToDB();
        // Atualiza as informações de um Jogo específico
        String sql = "UPDATE Jogo SET Nome=?, preco=?, ano_de_lancamento=?, qtd_jogadores=? where idJogo=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Jogo.getNome());
            pst.setDouble(2, Jogo.getPreco());
            pst.setInt(3, Jogo.getAno_de_lancamento());
            pst.setInt(4, Jogo.getQtd_jogadores());
            pst.setInt(5, id);
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

    //DELETE
    public boolean deleteJogo(int id) {
        connectToDB();
        // Remove um Jogo da tabela
        String sql = "DELETE FROM Jogo where idJogo=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
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

    //SELECT
    public ArrayList<Jogo> selectJogo() {
        ArrayList<Jogo> Jogos = new ArrayList<>();
        connectToDB();
        // Exibe todos os Jogos cadastrados
        String sql = "SELECT * FROM Jogo";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Jogos: ");
            while (rs.next()) {
                Jogo JogoAux = new Jogo(rs.getInt("idJogo"), rs.getString("Nome"), rs.getDouble("Preco"), rs.getInt("ano_de_lancamento"), rs.getInt("qtd_jogadores"));
                System.out.println("ID = " + JogoAux.getIdJogo());
                System.out.println("Nome = " + JogoAux.getNome());
                System.out.println("Valor = R$ " + String.format("%.2f", JogoAux.getPreco()));
                System.out.println("Quantidade de jogadores = " + JogoAux.getQtd_jogadores());
                System.out.println("Ano de lançamento= " + JogoAux.getAno_de_lancamento());
                System.out.println("--------------------------------");
                Jogos.add(JogoAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return Jogos;
    }

    // Mostra todas as informações referentes a um único Jogo
    public Jogo selectJogoEspecifico(int idJogo) {
        Jogo JogoAux = null;
        connectToDB();
        String sql = "SELECT * FROM Jogo WHERE idJogo = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idJogo);
            rs = pst.executeQuery();
            System.out.println("Informações do Jogo " + idJogo + " :");
            if (rs.next()) {
                JogoAux = new Jogo(rs.getInt("idJogo"), rs.getString("Nome"), rs.getDouble("Preco"), rs.getInt("ano_de_lancamento"), rs.getInt("qtd_jogadores"));
                System.out.println("Nome = " + JogoAux.getNome());
                System.out.println("Valor = R$ " + String.format("%.2f", JogoAux.getPreco()));
                System.out.println("Quantidade de Jogadores = " + JogoAux.getQtd_jogadores ());
                System.out.println("Ano_de_lançamento = " + JogoAux.getAno_de_lancamento());
                System.out.println("--------------------------------");
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
        return JogoAux;
    }
}
/*
    // Diminui 1 unidade do estoque do Jogo ao realizar uma compra
    public boolean diminuirEstoque(int idJogo) {
        connectToDB();
        String sql = "UPDATE Jogo SET qtd_disponivel= qtd_disponivel - 1 WHERE idJogo=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idJogo);
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
}*/
