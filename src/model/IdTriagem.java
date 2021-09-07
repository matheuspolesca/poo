package model;

public enum IdTriagem {
    VERMELHO("Vermelho - Alta"),
    AMARELO("Amarelo - Media"),
    VERDE("Verde - Baixa");

    private String descricao;

    IdTriagem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
