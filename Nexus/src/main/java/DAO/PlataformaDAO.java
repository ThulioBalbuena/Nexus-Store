package DAO;
import program.DAO.Model.Plataforma;
import java.sql.SQLException;

public class PlataformaDAO extends ConnectionDAO {
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertPlataforma(Plataforma Plataforma) {
        connectToDB();
        // Adiciona um novo usuário na tabela
        String sql = "INSERT INTO Plataforma (nome) values (?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Plataforma.getNomePlataforma());
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
