/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc
 */
public class UsuarioDAO {
    public void SalvarUsuario (String conteudo) throws IOException{
         
        FileWriter file = new FileWriter("./src/Usuarios.txt", true);
        file.write( conteudo);
        file.close();
    }
   
   public  List<String> LerDadosUsuario () throws FileNotFoundException, IOException
    {
        List<String> dados = new ArrayList<>();

        File arquivo = new File("./src/Usuarios.txt" );
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
