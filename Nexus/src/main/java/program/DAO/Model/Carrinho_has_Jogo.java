package program.DAO.Model;

public class Carrinho_has_Jogo {
    private int Carrinho_idCarrinho;
    private int Jogo_idjogo;

    public Carrinho_has_Jogo(int Carrinho_idCarrinho, int Jogo_idjogo) {
        this.Carrinho_idCarrinho = Carrinho_idCarrinho;
        this.Jogo_idjogo = Jogo_idjogo;
    }

    // Getter
    public int getCarrinho_idCarrinho() {
        return Carrinho_idCarrinho;
    }
    public int getJogo_idjogo() {
        return Jogo_idjogo;
    }
}