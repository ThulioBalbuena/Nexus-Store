package program.DAO.Model;

public class Comprador {

    private String cpf;
    private String email;
    private String nome;
    private int saldo;

    public Comprador(String cpf, String email, String nome, int saldo) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.saldo = saldo;
    }

    // Getter
    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    public int getSaldo() {
        return saldo;
    }
}