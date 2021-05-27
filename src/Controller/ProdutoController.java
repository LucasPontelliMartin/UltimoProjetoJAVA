/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProdutoDAO;
import Model.ProdutoModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;

/**
 *
 * @author Pc
 */
public class ProdutoController {
    
    public void Salvar (ProdutoModel produto, String tipo) throws IOException
    {
        ProdutoDAO prodDAO = new ProdutoDAO();
    
        switch (tipo) {
                    case "Cliente":
                        {
                            String conteudo = "\n" + produto.getId() + " - " + produto.getCategoria() + " - " + produto.getProduto() + " - " + produto.getQuantidade() + " - " + produto.getValorCusto() + " - " + produto.getValorVenda();
                            prodDAO.SalvarCliente(produto,conteudo);
                            break;
                        }
                    case "Insumos":
                        {
                            String conteudo = "\n" + produto.getId() + " - " + produto.getCategoria() + " - " + produto.getProduto() + " - " + produto.getQuantidade() + " - " + produto.getValorCusto() + " - " + produto.getValorVenda();
                            prodDAO.SalvarInsumos(produto,conteudo);
                            break;
                        }
                    default:
                       
                        break;
                }
        
    }
    
    public List<ProdutoModel> Buscar () throws IOException
    {
       List<ProdutoModel> dados = new ArrayList<>();
       ProdutoDAO dao = new ProdutoDAO();
       List<String> dadosString = dao.LerDadosCliente();
       
        
        if (dadosString.size() > 0) {
            String dadosConta[] = new String[6];
            
                int n = dadosString.size();
                for (int i=0; i<n; i++) {
                dadosConta = dadosString.get(i).split(Pattern.quote(" - "));
      
                ProdutoModel prod = new ProdutoModel();
                prod.setId("        " + dadosConta[0]);
                prod.setCategoria("    " + dadosConta[1]);
                prod.setProduto("      " + dadosConta[2]);
                prod.setQuantidade("        " + dadosConta[3]);
                prod.setValorCusto("        " + dadosConta[4]);
                prod.setValorVenda("        " + dadosConta[5]);
                dados.add(prod);
                }
                
        }
        return dados;
    }
}
