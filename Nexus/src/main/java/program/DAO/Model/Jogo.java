package program.DAO.Model;

public class Jogo {
    private String Nome;
    private int idJogo;
    private double Preco;
    private int qtd_jogadores;
    private int ano_de_lancamento;
    private String Genero_nome;

    public Jogo(int idJogo, String Nome, String Genero_nome, double Preco, int ano_de_lancamento, int qtd_jogadores) {
        this.idJogo = idJogo;
        this.Nome = Nome;
        this.Preco = Preco;
        this.qtd_jogadores = qtd_jogadores;
        this.ano_de_lancamento = ano_de_lancamento;
        this.Genero_nome = Genero_nome;
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

    public int getAno_de_lancamento() {
        return ano_de_lancamento;
    }

    public String getGenero_nome() {
        return Genero_nome;
    }

    public double getPreco() {
        return Preco;
    }

    public int getidJogo() {
        return idJogo;
    }
}

