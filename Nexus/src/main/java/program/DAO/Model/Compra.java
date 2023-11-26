package program.DAO.Model;

public class Compra {
    private int idCompra;
    private double valor;
    private int Comprador_cpf;

    public Compra(int idCompra, double valor, int Comprador_cpf) {
        this.idCompra = idCompra;
        this.valor = valor;
        this.Comprador_cpf = Comprador_cpf;
    }
    public int getIdCompra() {
        return idCompra;
    }

    public double getValor() {
        return valor;
    }

    public int getComprador_cpf() {
        return Comprador_cpf;
    }
}