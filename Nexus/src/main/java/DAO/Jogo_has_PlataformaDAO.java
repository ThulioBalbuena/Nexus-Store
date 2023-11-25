package DAO;

import java.util.ArrayList;
import program.DAO.Model.Jogo_has_Plataforma;
import java.sql.SQLException;
public class Jogo_has_PlataformaDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertJogo_has_Plataforma(Jogo_has_Plataforma Jogo_has_Plataforma) {
        connectToDB();
        String sql = "INSERT INTO Jogo_has_Plataforma (Jogo_idJogo, Plataforma_nome) values (?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, Jogo_has_Plataforma.getJogo_idJogo());
            pst.setString(2, Jogo_has_Plataforma.getPlataforma_nome());
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
    public ArrayList<Jogo_has_Plataforma> selectJogo_has_Plataforma() {
        connectToDB();
        ArrayList<Jogo_has_Plataforma> listaJogo_has_Plataforma = new ArrayList<>();
        String sql = "SELECT * FROM Jogo_has_Plataforma";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Jogo_has_Plataforma Jogo_has_Plataforma = new Jogo_has_Plataforma(rs.getInt("Jogo_idJogo"), rs.getString("Plataforma_nome"));
                System.out.println(Jogo_has_Plataforma.getJogo_idJogo() + " <---> " + Jogo_has_Plataforma.getPlataforma_nome());
                listaJogo_has_Plataforma.add(Jogo_has_Plataforma);
            }
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            try {
                con.close();
                st.close();
                rs.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return listaJogo_has_Plataforma;
    }
}
