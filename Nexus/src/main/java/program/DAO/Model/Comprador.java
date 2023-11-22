package program.DAO.Model;

public class Comprador {

    private String email;
    private String nome;
    private int senha;
    private int saldo;

    public Comprador(String email, String nome, int senha, int saldo) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.saldo = saldo;
    }

    // Getter
    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public int getSenha() {
        return senha;
    }

    public int getSaldo() {
        return saldo;
    }
}