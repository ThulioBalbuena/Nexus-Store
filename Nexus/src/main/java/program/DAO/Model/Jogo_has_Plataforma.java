package program.DAO.Model;

public class Jogo_has_Plataforma {
    private int Jogo_idJogo;
    private String Plataforma_nome;

    public Jogo_has_Plataforma(int Jogo_idJogo, String Plataforma_nome) {
        this.Jogo_idJogo = Jogo_idJogo;
        this.Plataforma_nome = Plataforma_nome;
    }

    // Getter
    public int getJogo_idJogo() {
        return Jogo_idJogo;
    }

    public String getPlataforma_nome() {
        return Plataforma_nome;
    }
}
