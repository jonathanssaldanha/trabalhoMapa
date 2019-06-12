package trabalhomapa4;


import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;


public class Mapa extends JPanel{
    
    List<Desenhavel> desenhaveis = new ArrayList<>();
    List<Desenhavel> desenhaRota = new ArrayList<>();
    List<Desenhavel> desenharOrigem = new ArrayList<>();
    List<Desenhavel> desenharDestino = new ArrayList<>();
    
    public Mapa(){
            
        setBackground(Color.WHITE);
        String linha;
        Cidade c;
        Rota r;
        String partes[];
        
        List<Cidade> cidades = new ArrayList<>();
        List<Rota> rotas = new ArrayList<>();
        List<Cidade> origem = new ArrayList<>();
        List<Cidade> destino = new ArrayList<>();
        HashMap<String, Cidade> indice = new HashMap<>();


        try{
            FileReader fr = new FileReader("mapa_rs.txt");
            BufferedReader in = new BufferedReader(fr);
            
//            CRIANDO AS CIDADES
            while((linha = in.readLine()) != null){
                if(linha.length() == 0){
                    break;
                }
                partes = linha.split(" ");
           
                c = new Cidade();
                c.setNome(partes[0]);
                c.setX(Integer.parseInt(partes[1]));
                c.setY(Integer.parseInt(partes[2]));
                cidades.add(c);

                indice.put(c.getNome(), c);
                desenhaveis.add(c);
            }
//            CRIANDO AS ROTAS
            while((linha = in.readLine()) != null){
                
                partes = linha.split(" ");
           
                r = new Rota();
                r.setA(indice.get(partes[0]));
                r.setB(indice.get(partes[1]));
                r.setDistancia(Integer.parseInt(partes[2]));
                rotas.add(r);
   
                desenhaveis.add(r);
            }

//          PINTAR O PONTO A            
            Cidade pontoA;
            pontoA = indice.get("gramado");
//          varre a lista de cidades, imprimindo cada objeto. utiliza foreach.
            for(Cidade orig:cidades){
                if(orig == pontoA){
                    System.out.println(orig);
                    Cidade o = new Cidade();
                    
                    o.setNome(orig.getNome());
                    o.setX(orig.getX());
                    o.setY(orig.getY());
                    
                    
                    origem.add(o);
//                    System.out.println(o.getNome());
//                    System.out.println(o.getX());
//                    System.out.println(o.getY());
                    desenharOrigem.add(o);
                    
                }
            }
            
            Cidade pontoB;
            pontoB = indice.get("livramento");
            for(Cidade dest:cidades){
                if(dest == pontoB){
                    System.out.println(dest);
                    Cidade d = new Cidade();
                    
                    d.setNome(dest.getNome());
                    d.setX(dest.getX());
                    d.setY(dest.getY());

                    destino.add(d);
                    desenharDestino.add(d);
                    }
            }
          
//            salvar o pontoA , pontoB e a distancia entre dois objeto
            int var1 = pontoA.x;
            int var2 = pontoA.y;
            int var3 = pontoB.x;
            int var4 = pontoB.y;
            
            
            
//            Graph g = new Graph();
            
            
           
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(Desenhavel d:desenhaveis){
            d.desenhar(g);
        }
        for(Desenhavel o:desenharOrigem){
            o.desenharOrigem(g);
        }
        for(Desenhavel d: desenharDestino){
            d.desenharDestino(g);
        }
    }
}
