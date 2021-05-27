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
public class VendaModel {
    
    private String id;
    private String produto;
    private String quantidade;
    private String valorUnidade;
    private String valorVenda;

    public void setId(String id) {
        this.id = id;
    }

   
    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorUnidade(String valorUnidade) {
        this.valorUnidade = valorUnidade;
    }
    
    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
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

    public String getValorUnidade() {
        return valorUnidade;
    }
    
    public String getValorVenda() {
        return valorVenda;
    }

    public void Salvar(VendaModel prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
