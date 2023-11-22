package program.DAO.Model;

public class Plataforma {
    
    private int idPlataforma;
    private String nomePlataforma;

    public Plataforma(int idPlataforma, String nomePlataforma) {
        this.idPlataforma = idPlataforma;
        this.nomePlataforma = nomePlataforma;
    }

    // Getter

    public int getIdPlataforma() {
        return idPlataforma;
    }

    public String getNomePlataforma() {
        return nomePlataforma;
    }
}
