import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class tag06
{
    ArrayList<String> liste = new ArrayList<String>();
    ArrayList<Stack>  stapel = new ArrayList<Stack>();
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
        String[] paare, vorne, hinten, temp;
        for (String element : liste){
            paare =   element.split(" ");

		}

        System.out.print("Stern Eins: ");        


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
       while ((st = br.readLine()) != null)
           liste.add(st);
    }
}
