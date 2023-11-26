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
        String sql = "INSERT INTO Jogo (idjogo, Nome, Preco, ano_de_lancamento, qtd_jogadores) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, Jogo.getidJogo());
            pst.setString(2, Jogo.getNome());
            pst.setDouble(3, Jogo.getPreco());
            pst.setInt(4, Jogo.getAno_de_lancamento());
            pst.setInt(5, Jogo.getQtd_jogadores());
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


    //SELECT
    public ArrayList<Jogo>selectJogo() {
        ArrayList<Jogo> Jogos = new ArrayList<>();
        connectToDB();
        // Exibe todos os Jogos cadastrados
        String sql = "SELECT * FROM Jogo";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Jogos: ");
            while (rs.next()) {
                Jogo JogoAux = new Jogo(rs.getInt("idjogo"),rs.getString("Nome"),rs.getString("Genero_nome"), rs.getDouble("Preco"), rs.getInt("ano_de_lancamento"), rs.getInt("qtd_jogadores"));
                System.out.println("Nome = " + JogoAux.getNome());
                System.out.println("Genero = " + JogoAux.getGenero_nome());
                System.out.println("Valor = R$ " + String.format("%.2f", JogoAux.getPreco()));
                System.out.println("Quantidade de jogadores = " + JogoAux.getQtd_jogadores());
                System.out.println("Ano de lançamento= " + JogoAux.getAno_de_lancamento());
                System.out.println("---------------------------------");
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

    public String selectJogoNome(int idJogo) {
        connectToDB();
        // Pega o nome de um Jogo específico
        String sql = "SELECT nome FROM Jogo WHERE idjogo=?";
        String nome = "";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idJogo);
            rs = pst.executeQuery();
            if(rs.next()){
                nome = rs.getString("Nome");
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
        return nome;
    }

    public double selectJogoPreco(int idJogo) {
        connectToDB();
        // Pega o valor de um Jogo específico
        String sql = "SELECT Preco FROM Jogo WHERE idjogo=?";
        double preco = 0;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idJogo);
            rs = pst.executeQuery();
            if(rs.next()){
                preco = rs.getDouble("Preco");
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
        return preco;
    }
}
