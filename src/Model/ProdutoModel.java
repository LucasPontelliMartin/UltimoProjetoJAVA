/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Pc
 */
public class ProdutoModel {
    private String id;
    private String categoria;
    private String produto;
    private String quantidade;
    private String valorCusto;
    private String valorVenda;

    public void setId(String id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorCusto(String valorCusto) {
        this.valorCusto = valorCusto;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getId() {
        return id;
    }

    public String getProduto() {
        return produto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public String getValorCusto() {
        return valorCusto;
    }

    public String getValorVenda() {
        return valorVenda;
    }
    
    
    
    
}
