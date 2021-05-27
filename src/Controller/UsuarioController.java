/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import Model.UsuarioModel;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Pc
 */
public class UsuarioController {
     public void Salvar (UsuarioModel cliente) throws IOException
    {
        UsuarioDAO dao = new UsuarioDAO();
        
        String conteudo = "\n" + cliente.getNome() + " | " + cliente.getCpf() + " | " + cliente.getEmail() + " | " + cliente.getTelefone()+ " | " + cliente.getSenha();
        dao.SalvarUsuario(conteudo);
    }
    
    public UsuarioModel Buscar (String email, String senha) throws IOException
    {
       UsuarioModel dados = new UsuarioModel();
       UsuarioDAO dao = new UsuarioDAO ();
       
       
        List<String> dadosString = dao.LerDadosUsuario();
       
        
        if (dadosString.size() > 0) {
            String dadosConta[] = new String[4];
            
                int n = dadosString.size();
                for (int i=0; i<n; i++) {
                dadosConta = dadosString.get(i).split(Pattern.quote(" | "));
      
                UsuarioModel prod = new UsuarioModel();
                prod.setNome(dadosConta[0]);
                prod.setCpf(dadosConta[1]);
                prod.setEmail(dadosConta[2]);
                prod.setTelefone(dadosConta[3]);
                prod.setSenha(dadosConta[4]);
                if(prod.getEmail().equals(email) && prod.getSenha().equals(senha)){
                dados = (prod);
                }
            }
                
        }
        return dados;
    }
}
