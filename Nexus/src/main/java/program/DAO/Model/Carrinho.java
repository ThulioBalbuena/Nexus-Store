package Nexus;

public class Carrinho {
    private int idCarrinho;
    private int Comprador_email;

    public Carrinho(int idCarrinho, int Comprador_email) {
        this.idCarrinho = idCarrinho;
        this.Comprador_email = Comprador_email;
    }

    // Getter
    public int getIdCarrinho() {
        return idCarrinho;
    }

    public int getUsuario_idUsuario() {
        return Comprador_email;
    }
}