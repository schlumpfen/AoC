import java.io.*;
import java.util.*;

public class tag07
{
    ArrayList<String> liste = new ArrayList<String>();
    // ArrayList<Stack>  stapel = new ArrayList<Stack>();
    //Hashtable<Character, Character> ht1 = new Hashtable<>();
    
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
        dir meins = null;
        dir pos =null;
        String[] paare;
        for (String element : liste){
            paare = element.split(" ");
            if(paare[0].equals("$")){
                // cd oder ls
                if(paare[1].equals("cd")){
                    // cd Verzeichniswechsel
                    if(paare[2].equals("/")) { 
                        //root
                        meins = new dir(paare[2]);
                        pos = meins;            
                    }
                    else {
                        if(paare[2].equals("..")){
                            // Verzeichnis hoch
                            pos = pos.gettop();
                        }
                        else {
                            // cd paare[2] -> Verzeichnis runter
                            pos = pos.getdir(paare[2]);
                        }
                    }
                    
                }
                else {
                    // ls
                    // Was jetzt kommt listet auf, bis zum nächsten $
                    // 
                }
            }
            else {
                // dir oder ZAHL
                if(paare[0].equals("dir")){
                    pos.adddir(paare[1]);
                }
                else {
                    pos.addsize(Integer.parseInt(paare[0]));
                }
                
                // System.out.println(paare[0]);    
            }
            
        }
        System.out.println(meins.checksize(3313415));
        // starone();
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
