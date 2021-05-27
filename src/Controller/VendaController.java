/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProdutoDAO;
import DAO.VendaDAO;
import Model.ProdutoModel;
import Model.VendaModel;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Pc
 */
public class VendaController {
    
    public void Salvar (VendaModel venda) throws IOException
    {
        VendaDAO prodDAO = new VendaDAO();
    
       String conteudo = "\n" + venda.getId() + " | " +  venda.getProduto() + " | " + venda.getQuantidade() + " | " + venda.getValorUnidade()+ " | " + venda.getValorVenda();
       prodDAO.SalvarVenda(venda,conteudo);     
        
    }
    
    
    public String ValorVenda (){
        
        VendaDAO dao = new VendaDAO();
        
        List<String> dadosString = dao.LerDadosVenda();
        String valor = "";
        double valores = 0;
        if (dadosString.size() > 0) {
            String dadosConta[] = new String[6];
            
                int n = dadosString.size();
                for (int i=0; i<n; i++) {
                dadosConta = dadosString.get(i).split(Pattern.quote(" | "));
                valores += Double.valueOf(dadosConta[3]);
                
                }
                
        }
        DecimalFormat df = new DecimalFormat("#,###.00");
        valor =  df.format(valores); 
        return valor;
    } 
    
    
    public List<VendaModel> Buscar () throws IOException
    {
       List<VendaModel> dados = new ArrayList<>();
       VendaDAO dao = new VendaDAO();
       List<String> dadosString = dao.LerDadosCliente();
       
        
        if (dadosString.size() > 0) {
            String dadosConta[] = new String[6];
            
                int n = dadosString.size();
                for (int i=0; i<n; i++) {
                dadosConta = dadosString.get(i).split(Pattern.quote(" | "));
      
                VendaModel prod = new VendaModel();
                prod.setId("        " + dadosConta[0]);
                prod.setProduto("      " + dadosConta[1]);
                prod.setQuantidade("        " + dadosConta[2]);
                prod.setValorUnidade("        " + dadosConta[3]);
                prod.setValorVenda("        " + dadosConta[4]);
                dados.add(prod);
                }
                
        }
        return dados;
    }
    
    public String BuscarUltimoId () throws IOException
    {
       String dados = "";
       VendaDAO dao = new VendaDAO();
       List<String> dadosString = dao.LerDadosCliente();
       
        
        if (dadosString.size() > 0) {
            String dadosConta[] = new String[6];

                
                dadosConta = dadosString.get(dadosString.size() - 1).split(Pattern.quote(" | "));
      
                
                
                 int numeroConvertido = Integer.parseInt(dadosConta[0]) + 1;
                 dados = Integer.toString(numeroConvertido);
        }
        return dados;
    }
}
