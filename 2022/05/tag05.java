import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class tag05
{
    ArrayList<String> liste = new ArrayList<String>();
    ArrayList<Stack>  stapel = new ArrayList<Stack>();
    public tag05()
    {
        try
        {
            einlesen();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        //starone();
        startwo();
    }
    void starone(){
        int gesamtwert = 0;
        int wert = 0;
        String[] paare, vorne, hinten, temp;
        for (String element : liste){
            paare =   element.split(" ");
            // 1 , 3,5 count, fro, to
            int test = Integer.parseInt(paare[1]);
            for(int i=0; i < Integer.parseInt(paare[1]);i++){
                stapel.get(Integer.parseInt(paare[5])-1).push((stapel.get(Integer.parseInt(paare[3])-1).pop()));
            }
        }
        System.out.print("Stern Eins: ");        
        for(int i=0;i<9;i++){
            System.out.print(stapel.get(i).peek());
        }

    }
    
    
    void startwo(){
         int gesamtwert = 0;
        int wert = 0;
        String[] paare, vorne, hinten, temp;
        for (String element : liste){
            paare =   element.split(" ");
            // 1 , 3,5 count, fro, to
            int test = Integer.parseInt(paare[1]);
            for(int i=0; i < Integer.parseInt(paare[1]);i++){
                stapel.get(9).push(stapel.get(Integer.parseInt(paare[3])-1).pop());
            }
            for(int i=0; i < Integer.parseInt(paare[1]);i++){
                stapel.get(Integer.parseInt(paare[5])-1).push((stapel.get(9).pop()));
            }
        }
        System.out.print("Stern Zwei: ");        
        for(int i=0;i<9;i++){
            System.out.print(stapel.get(i).peek());
        }
    }
    
    
    void einlesen() throws IOException {
       File file = new File("input.txt"); 
       String st;
       BufferedReader br = new BufferedReader(new FileReader(file));
       while ((st = br.readLine()) != null)
           liste.add(st);
       
       for (int i = 0;i<10;i++){
           Stack<String> stack = new Stack<>();
           stapel.add(stack);
       }
       
       stapel.get(0).push("W");
       stapel.get(0).push("R");
       stapel.get(0).push("F");
       
       stapel.get(1).push("T");
       stapel.get(1).push("H");
       stapel.get(1).push("M");
       stapel.get(1).push("C");
       stapel.get(1).push("D");
       stapel.get(1).push("V");
       stapel.get(1).push("W");
       stapel.get(1).push("P");
       
       stapel.get(2).push("P");
       stapel.get(2).push("M");
       stapel.get(2).push("Z");
       stapel.get(2).push("N");
       stapel.get(2).push("L");
       
       stapel.get(3).push("J");
       stapel.get(3).push("C");
       stapel.get(3).push("H");
       stapel.get(3).push("R");
       
       stapel.get(4).push("C");
       stapel.get(4).push("P");
       stapel.get(4).push("G");
       stapel.get(4).push("H");
       stapel.get(4).push("Q");
       stapel.get(4).push("T");
       stapel.get(4).push("B");
       
       stapel.get(5).push("G");
       stapel.get(5).push("C");
       stapel.get(5).push("W");
       stapel.get(5).push("L");
       stapel.get(5).push("F");
       stapel.get(5).push("Z");
       
       stapel.get(6).push("W");
       stapel.get(6).push("V");
       stapel.get(6).push("L");
       stapel.get(6).push("Q");
       stapel.get(6).push("Z");
       stapel.get(6).push("J");
       stapel.get(6).push("G");
       stapel.get(6).push("C");
       
       stapel.get(7).push("P");
       stapel.get(7).push("N");
       stapel.get(7).push("R");
       stapel.get(7).push("F");
       stapel.get(7).push("W");
       stapel.get(7).push("T");
       stapel.get(7).push("V");
       stapel.get(7).push("C");
       
       stapel.get(8).push("J");
       stapel.get(8).push("W");
       stapel.get(8).push("H");
       stapel.get(8).push("G");
       stapel.get(8).push("R");
       stapel.get(8).push("S");
       stapel.get(8).push("V");
       
   
       
       /*
            [P]                 [C] [C]    
            [W]         [B]     [G] [V] [V]
            [V]         [T] [Z] [J] [T] [S]
            [D] [L]     [Q] [F] [Z] [W] [R]
            [C] [N] [R] [H] [L] [Q] [F] [G]
        [F] [M] [Z] [H] [G] [W] [L] [R] [H]
        [R] [H] [M] [C] [P] [C] [V] [N] [W]
        [W] [T] [P] [J] [C] [G] [W] [P] [J]
         1   2   3   4   5   6   7   8   9
       */

    }

}
