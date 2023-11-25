package DAO;
import program.DAO.Model.Genero;
import java.sql.SQLException;

public class GeneroDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertGenero(Genero Genero) {
        connectToDB();
        String sql = "INSERT INTO Genero (nome) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Genero.getNome());
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
}