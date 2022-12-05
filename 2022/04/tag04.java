import java.io.*;
import java.util.ArrayList;

public class tag04
{
    ArrayList<String> liste = new ArrayList<String>();
    
    public tag04()
    {
        
        try
        {
            einlesen();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        starone();
        startwo();
        

    }
    void starone(){
        int gesamtwert = 0;
        int wert = 0;
        String[] paare, vorne, hinten, temp;
        for (String element : liste){
            paare =   element.split(",");
            vorne =  paare[0].split("-");
            hinten = paare[1].split("-");
            if(Integer.parseInt(vorne[0]) >= Integer.parseInt(hinten[0]))
            {
                if(Integer.parseInt(hinten[0]) == Integer.parseInt(vorne[0])) { 
                    if((Integer.parseInt(hinten[1]) - Integer.parseInt(hinten[0]))  >  (Integer.parseInt(vorne[1]) - Integer.parseInt(vorne[0]))) {
                        temp =vorne;
                        vorne=hinten;
                        hinten=temp;
                    }
                }
                else {
                        temp =vorne;
                        vorne=hinten;
                        hinten=temp;
                }
            }
            if((Integer.parseInt(vorne[0])<=Integer.parseInt(hinten[0])))
            {
                if((Integer.parseInt(vorne[1])>=Integer.parseInt(hinten[1]))) {
                        gesamtwert++;
                }
            }
        }
        System.out.println("Stern Eins: "+gesamtwert);
    }
    
    
    void startwo(){
        int gesamtwert = 0;
        int wert = 0;
        String[] paare, vorne, hinten, temp;
        for (String element : liste){
            paare = element.split(",");
            vorne=paare[0].split("-");
            hinten=paare[1].split("-");
            
            if(Integer.parseInt(vorne[0]) >= Integer.parseInt(hinten[0]))
            {
                if(Integer.parseInt(hinten[0]) == Integer.parseInt(vorne[0])){ 
                    if((Integer.parseInt(hinten[1]) - Integer.parseInt(hinten[0]))  >  (Integer.parseInt(vorne[1]) - Integer.parseInt(vorne[0])))
                    {
                        temp =vorne;
                        vorne=hinten;
                        hinten=temp;
                    }
                }
                else
                {
                        temp =vorne;
                        vorne=hinten;
                        hinten=temp;
                }
            }
           
            if((Integer.parseInt(hinten[0])>=Integer.parseInt(vorne[0])))
            {
                if((Integer.parseInt(hinten[0])<=Integer.parseInt(vorne[1])))
                {
                        gesamtwert++;
                }
            }
        }
        System.out.println("Stern zwei: "+gesamtwert);    
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
