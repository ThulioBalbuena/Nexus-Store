package program.DAO.Model;

public class Carrinho {
    private int idCarrinho;
    private int Comprador_cpf;

    public Carrinho(int idCarrinho, int Comprador_cpf) {
        this.idCarrinho = idCarrinho;
        this.Comprador_cpf = Comprador_cpf;
    }

    // Getter
    public int getIdCarrinho() {
        return idCarrinho;
    }

    public int getComprador_cpf() {
        return Comprador_cpf;
    }
}