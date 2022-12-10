import java.io.*;
import java.util.*;

public class tag08
{
    ArrayList<String> liste = new ArrayList<String>();
    ArrayList<Stack>  stapel = new ArrayList<Stack>();
    int[][] forest = new int[5][5];
    Hashtable<Character, Character> ht1 = new Hashtable<>();
    
    public tag08()
    {
        try
        {
            einlesen();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        forest = new int[liste.size()][liste.size()];
        
        String[] paare, vorne, hinten;
        String temp="",teil="";
        int j=0;
        for (String element : liste){
            for(int i=0;i<element.length();i++)
            {
                forest[j][i] = Integer.parseInt(element.substring(i,i+1));            
            }
            j++;
        }

        
        
        starone();
        // startwo();
    }
    void starone(){
        int wert=forest[0].length*4-4;
        boolean found=false;
        for(int i=1;i < forest[0].length-1;i++)
        {
            for(int j=1;j < forest[i].length-1;j++)
            {
                // Alle Zeilen uns Spalten
                // Von hier nach oben/unten/rechts/links schauen
                // Wenn man bis zum Rand kommt dann zählen
                
                // nach oben 
                
                found=false;
                for(int o=j-1;o>=0;o--){
                    if(forest[i][j] <= forest[o][j])
                    {
                        found = false;
                        System.out.println("o  "+i+" "+j+ " " +forest[i][j]);
                        break;
                    }
                    found = true;
                }
                if(found){
                    wert++;    
                }
                else{
                    // nach unten
                    found=false;
                    for(int o=j;o<forest[i].length;o++){
                        if(forest[i][j] <= forest[o][j])
                        {
                            found = false;
                            System.out.println("u  "+i+" "+j+ " " +forest[i][j]);
                            break;
                        }
                        found = true;
                    }
                    if(found){
                        wert++;    
                    }
                    else{
                        // links
                        found=false;
                        for(int o=i;o<forest[i].length;o++){
                            if(forest[i][j] <= forest[i][o])
                            {
                                found = false;
                                System.out.println("l  "+i+" "+j+ " " +forest[i][j]);
                                break;
                            }
                            found = true;
                        }
                        if(found){
                            wert++;    
                        }
                        else{
                            // rechts
                            found=false;
                            for(int o=i-1;o>=0;o--){
                                if(forest[i][j] <= forest[i][o])
                                {
                                    found = false;
                                    System.out.println("r  "+i+" "+j+ " " +forest[i][j]);
                                    break;
                                }
                                found = true;
                            }
                            if(found){
                                wert++;    
                            }
                        }
                    }
                }
                
                // System.out.print(forest[i][j]);
                
                
            }   
            System.out.println();
        }        
        
        
        System.out.print("Stern Eins: "+wert);        
    }
    
    
    void startwo(){
        int gesamtwert = 0;
        int wert = 0;
        String[] paare, vorne, hinten, temp;
        for (String element : liste){
            paare =   element.split(" ");

        }
        System.out.print("Stern Zwei: ");        
    }
    
    
    void einlesen() throws IOException {
       File file = new File("input.txt"); 
       String st;
       BufferedReader br = new BufferedReader(new FileReader(file));
       while ((st = br.readLine()) != null){
           liste.add(st);
           System.out.println(st);      
        }
    }
}
