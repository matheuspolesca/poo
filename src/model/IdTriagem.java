package model;

/**
 * Enum responsável por definir as cores de triagem
 * @author Brenda Orlandi, Matheus Polesca, Túlio Alves e Gabriel Augusto
 */
public enum IdTriagem {

    /**
     * Define a prioridade como alta
     */
    VERMELHO("Vermelho - Alta"),

    /**
     * Define a prioridade como média
     */
    AMARELO("Amarelo - Media"),

    /**
     * Define a prioridade como baixa
     */
    VERDE("Verde - Baixa");

    private String descricao;

    IdTriagem(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Método que capta a descrição da triagem
     * @return
     */
    public String getDescricao() {
        return descricao;
    }
}
