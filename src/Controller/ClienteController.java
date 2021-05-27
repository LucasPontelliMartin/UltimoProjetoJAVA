/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAO;
import DAO.ProdutoDAO;
import Model.ClienteModel;
import Model.ProdutoModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Pc
 */
public class ClienteController {
    
    public void Salvar (ClienteModel cliente) throws IOException
    {
        ClienteDAO dao = new ClienteDAO();
        
        String conteudo = "\n" + cliente.getNome() + " - " + cliente.getCpf() + " - " + cliente.getEmail() + " - " + cliente.getTelefone();
        dao.SalvarCliente(conteudo);
    }
    
    public List<ClienteModel> Buscar ()
    {
       List<ClienteModel> dados = new ArrayList<>();

        File arquivo = new File("./src/Clientes.txt" );
        if (arquivo.exists()) {
            String dadosConta[] = new String[4];
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivo));

                while (in.ready()) {
                    
                dadosConta = (in.readLine().split(Pattern.quote(" - ")));
                    
                ClienteModel cliente = new ClienteModel();
                cliente.setNome("        " + dadosConta[0]);
                cliente.setCpf("      " + dadosConta[1]);
                cliente.setEmail("        " + dadosConta[2]);
                cliente.setTelefone("        " + dadosConta[3]);
                
                }
                in.close();
            } catch (IOException ex) {
            
        }
        }
        return dados;
    }
}
