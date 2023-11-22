package program.DAO.Model;

public class Jogo {
    
    private String nomeJogo;
    private int preco;
    private int qtd_jogadores;
    private int ano_lancamento;
    private int Carrinho_idCarrinho;

    public Jogo(String nomeJogo, int preco, int qtd_jogadores, int ano_lancamento, int Carrinho_idCarrinho) {
        this.nomeJogo = nomeJogo;
        this.preco = preco;
        this.qtd_jogadores = qtd_jogadores;
        this.ano_lancamento = ano_lancamento;
        this.Carrinho_idCarrinho = Carrinho_idCarrinho;
    }

    // Getter
    public String getNomeJogo() {
        return nomeJogo;
    }

    public int getPreco() {
        return preco;
    }

    public int getQtd_jogadores() {
        return qtd_jogadores;
    }

    public int getAno_lancamento() {
        return ano_lancamento;
    }

    public int getCarrinho_idCarrinho() {
        return Carrinho_idCarrinho;
    }

}

