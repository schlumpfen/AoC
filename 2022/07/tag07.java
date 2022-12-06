import java.io.*;
import java.util.*;

public class tag07
{
    ArrayList<String> liste = new ArrayList<String>();
    ArrayList<Stack>  stapel = new ArrayList<Stack>();
    
    Hashtable<Character, Character> ht1 = new Hashtable<>();
    
    public tag07()
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
        // startwo();
    }
    void starone(){
        int gesamtwert = 0;
        int wert = 0;
        String[] paare, vorne, hinten;
        String temp="",teil="";
        for (String element : liste){
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
           // System.out.println(st);      
        }
    }
}
