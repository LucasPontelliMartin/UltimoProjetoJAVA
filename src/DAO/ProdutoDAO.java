/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ProdutoModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Pc
 */
public class ProdutoDAO 
{
    public void SalvarCliente (ProdutoModel produto, String conteudo) throws IOException{
         
        FileWriter file = new FileWriter("./src/Produtos.txt", true);
        file.write( conteudo);
        file.close();
    }
    
    public void SalvarInsumos (ProdutoModel produto, String conteudo) throws IOException{
         
        FileWriter file = new FileWriter("./src/ProdutosInsumo.txt", true);
        file.write( conteudo);
        file.close();
    }
    
    public  List<String> LerDadosCliente () throws FileNotFoundException, IOException
    {
        List<String> dados = new ArrayList<>();

        File arquivo = new File("./src/Produtos.txt" );
        if (arquivo.exists()) {
            String dadosContass = "";
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivo));

                while (in.ready()) {
                dadosContass = in.readLine();  
               
                dados.add(dadosContass);
                }
                in.close();
            } catch (IOException ex) {
            
        }
       
        }
         return dados;  
    }
}
