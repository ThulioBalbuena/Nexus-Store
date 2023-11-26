package program.DAO.Model;

public class Jogo_has_Plataforma {
    private int Jogo_idjogo;
    private int Plataforma_idPlataforma;

    public Jogo_has_Plataforma(int Jogo_idjogo, int Plataforma_idPlataforma) {
        this.Jogo_idjogo = Jogo_idjogo;
        this.Plataforma_idPlataforma = Plataforma_idPlataforma;
    }

    public int getJogo_idjogo() {
        return Jogo_idjogo;
    }

    public int getPlataforma_idPlataforma() {
        return Plataforma_idPlataforma;
    }
}
