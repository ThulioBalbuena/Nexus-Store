package program.DAO.Model;

public class Plataforma {
    private String nomePlataforma;

    private int idPlataforma;

    public Plataforma(int idPlataforma, String nomePlataforma) {
        this.idPlataforma = idPlataforma;
        this.nomePlataforma = nomePlataforma;
    }
    public String getNomePlataforma() {
        return nomePlataforma;
    }


    public int getIdPlataforma() {
        return idPlataforma;
    }
}
