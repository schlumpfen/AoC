import java.io.*;
import java.util.*;

public class tag06
{
    ArrayList<String> liste = new ArrayList<String>();
    ArrayList<Stack>  stapel = new ArrayList<Stack>();
    
    Hashtable<Character, Character> ht1 = new Hashtable<>();
    
    public tag06()
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
            paare =   element.split(" ");
            temp = paare[0];
        }
        
       // temp="bvwbjplbgvbhsrlpgdmjqwftvncz";
        
        int j=0;
    for(int i = 0; i < temp.length()-5; i++) {    
            teil= temp.substring(i, i+4);
            ht1.clear();
            j=0;
            for(int k=0;k<teil.length();k++){
                System.out.println(k+" "+ teil.charAt(k));
                if (!ht1.containsValue(teil.charAt(k))){
                    ht1.put(teil.charAt(k), teil.charAt(k));
                    j++;
                }
                else {
                    System.out.println(k+" "+ teil.charAt(k));
                }
                
            }
            if(j==4) {
                wert = i+4;
                System.out.println(j+teil);
                break;
            }        
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
