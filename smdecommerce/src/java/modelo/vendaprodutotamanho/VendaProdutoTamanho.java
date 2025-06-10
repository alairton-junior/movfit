package modelo.vendaprodutotamanho;

public class VendaProdutoTamanho {
    private int vendaId;
    private int produtoTamanhoId;
    private int quantidade;
    private double precoUnitario;

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    public int getProdutoTamanhoId() {
        return produtoTamanhoId;
    }

    public void setProdutoTamanhoId(int produtoTamanhoId) {
        this.produtoTamanhoId = produtoTamanhoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
