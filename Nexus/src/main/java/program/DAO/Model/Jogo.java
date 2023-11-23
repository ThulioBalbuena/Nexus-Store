package program.DAO.Model;

public class Jogo {


    private int idJogo;
    private String Nome;
    private double Preco;
    private int qtd_jogadores;
    private int ano_de_lancamento;
    private int Genero_idGenero;


    public Jogo(int idJogo, String nome, double preco, int ano_de_lancamento, int qtdJogadores) {
        this.idJogo = idJogo;
        this.Nome = Nome;
        this.Preco = Preco;
        this.qtd_jogadores = qtd_jogadores;
        this.ano_de_lancamento = ano_de_lancamento;
        this.Genero_idGenero = Genero_idGenero;

    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getQtd_jogadores() {
        return qtd_jogadores;
    }

    public void setQtd_jogadores(int qtd_jogadores) {
        this.qtd_jogadores = qtd_jogadores;
    }

    public int getAno_de_lancamento() {
        return ano_de_lancamento;
    }

    public void setAno_de_lancamento(int ano_de_lancamento) {
        this.ano_de_lancamento = ano_de_lancamento;
    }

    public int getGenero_idGenero() {
        return Genero_idGenero;
    }

    public void setGenero_idGenero(int genero_idGenero) {
        Genero_idGenero = genero_idGenero;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }
}

