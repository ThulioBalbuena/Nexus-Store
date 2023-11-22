package program.DAO.Model;

public class Jogo_has_Plataforma {
    private int Jogo_idJogo;
    private int Plataforma_idPlataforma;

    public Jogo_has_Plataforma(int Jogo_idJogo, int Plataforma_idPlataforma) {
        this.Jogo_idJogo = Jogo_idJogo;
        this.Plataforma_idPlataforma = Plataforma_idPlataforma;
    }

    // Getter
    public int getJogo_idJogo() {
        return Jogo_idJogo;
    }

    public int getPlataforma_idPlataforma() {
        return Plataforma_idPlataforma;
    }
}
