import java.io.*;
import java.util.ArrayList;

public class tag03
{
    ArrayList<String> liste = new ArrayList<String>();
    
    public tag03()
    {
        
        try
        {
            einlesen();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        // starone();
        startwo();
        

    }
    void starone(){
        String teil1, teil2;
        int treffer = -1;
        int wert =0;
        int gesamtwert=0;
        
        for (String element : liste){
            teil1 = element.substring(0,element.length()/2);        
            teil2 = element.substring(element.length()/2);
            
            for(int i=0;i<teil1.length();i++){
                for(int j=0;j<teil2.length();j++){
                  treffer=teil2.indexOf(teil1.substring(i,i+1));  
                  if(treffer>=0){break;}
                }
                if(treffer>=0){
                    if(Character.isLowerCase(teil2.charAt(treffer)))
                    {
                        wert =  (int) teil2.charAt(treffer)-96;
                    }
                    else
                    {
                        wert =  (int) teil2.charAt(treffer)-38;
                    };
                    // System.out.println(teil2.substring(treffer,treffer+1) + "="+wert +" Gesamtwert:"+gesamtwert);
                    gesamtwert += wert;
                    treffer=-1;
                    break;
                }
            }
        }
        System.out.println("Gesamtwert:"+gesamtwert);
    }
    
    
    void startwo(){
        int wert = 0;
        int gesamtwert=0;
        boolean treffer=false ;
        char badge='\0';
        for(int v=0;v<liste.size();v=v+3)
        {
            System.out.println(v+" "+liste.get(v));
            System.out.println((v+1)+" "+liste.get(v+1));
            System.out.println((v+2)+" "+liste.get(v+2));
            
            for (int j=0;j<liste.get(v).length();j++)
            {
                for (int k=0;k<liste.get(v+1).length();k++)
                {
                    if(liste.get(v).charAt(j)==liste.get(v+1).charAt(k))
                    {
                        // Buchtabe in erstem und zweitem
                        for (int l=0;l<liste.get(v+2).length();l++)
                        {
                            if(liste.get(v+1).charAt(k)==liste.get(v+2).charAt(l))
                            {
                                // Buchtabe in erstem und zweitem
                                treffer = true;
                                badge = liste.get(v+1).charAt(k);
                                break;
                            }
                        }       
                    }
                    if(treffer) {
                        break;
                    }
                }
                if(treffer) {
                   if(Character.isLowerCase(badge))
                   {
                       wert =  (int) badge-96;
                   }
                   else
                   {
                       wert =  (int) badge-38;
                   };
                   gesamtwert += wert;
                   treffer=false;                   
                   break;
                }

            }
            System.out.println();
        }
        
        System.out.println("Gesamtwert:"+gesamtwert);
    }
    
    
    void einlesen() throws IOException
    {
       File file = new File("input.txt"); 
       String st;
       BufferedReader br = new BufferedReader(new FileReader(file));
 
       while ((st = br.readLine()) != null)
           liste.add(st);
            
    }

}
