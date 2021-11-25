//TESTEEEEEEE
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
   public static void main(String[] args) {
        Path path1 = Paths.get("caso10c.txt");
        GeneralTreeOfInteger arv = new GeneralTreeOfInteger();
        int inicio_terras = 0;
        int conta_linhas = 0;
        String raiz = "";
        
        
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {
            String aux[];
            String s = reader.readLine();
            if (s != null)
            {
                System.out.println(Integer.parseInt(s));
                inicio_terras = Integer.parseInt(s);                
            }
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                if(conta_linhas==0)
                {
                    aux = line.split(" ");
                    System.out.println(aux[0] + " " + aux[1] + " " + Integer.parseInt(aux[2]));
                    arv.add(aux[0],inicio_terras,null); //Cria root com o valor inicial de terras
                    arv.add(aux[1],Integer.parseInt(aux[2]),aux[0]);
                    conta_linhas++;
                }
                else
                {
                    aux = line.split(" ");
                    System.out.println(aux[0] + " " + aux[1] + " " + Integer.parseInt(aux[2]));
                    arv.add(aux[1],Integer.parseInt(aux[2]),aux[0]);
                    conta_linhas++;
                }
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }  
        
        System.out.println(conta_linhas);
        System.out.println(arv.size());
        
        
        //Gera código DOT
        System.out.println("\n--- DOT ---");
        arv.geraDOT();
        
        
        
    }
}
