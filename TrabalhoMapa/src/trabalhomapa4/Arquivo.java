package trabalhomapa4;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonat
 */
public class Arquivo {
    
    public static String Read(String Caminho) throws FileNotFoundException{
        String conteudo = "";
        try{
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            try {
                linha = lerArq.readLine();
                while(linha != null){
                    conteudo += linha+"\n";
                    linha = lerArq.readLine();                
                }
                arq.close();
                return conteudo;
            }catch(IOException ex){
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "001";
            }
        }catch(FileNotFoundException ex){
            System.out.println("Erro: Arquivo não encontrado!");
            return "002";
        }
        
    }
    
    public static boolean Write(String Caminho, String Texto){
        try{
            FileWriter arq = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}