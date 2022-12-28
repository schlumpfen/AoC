import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import java.io.IOException;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class tag25
{
    ArrayList<String> liste = new ArrayList<String>();
    public tag25()
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
        long summe = 0;
        for(int ii=0;ii<liste.size();ii++) 
        {
            String number = new StringBuilder(liste.get(ii)).reverse().toString();
            long num = 0;
            for(int i = 0; i < number.length(); i++) {
                double place = Math.pow(5,i);
                switch (number.charAt(i)) {
                    case '=' -> num += -2L * place;
                    case '-' -> num += -1L * place;
                    case '1' -> num += place;
                    case '2' -> num += 2L * place;
                }
            }
            summe += num;
        }
        System.out.println("Teil Eins:" +  getSNAFU(summe));    
    }
    
    
    void startwo(){
    }
    
    
    void einlesen() throws IOException {
       File file = new File("input.txt"); 
       // File file = new File("test.txt");
       String st;
       BufferedReader br = new BufferedReader(new FileReader(file));
       while ((st = br.readLine()) != null){
           liste.add(st);
        }
    }
    
    public String getSNAFU(long zahl) {
        if(zahl == 0) return "";
        
        return switch ((int) (zahl % 5)) {
            case 0 -> getSNAFU(zahl / 5) + "0";
            case 1 -> getSNAFU(zahl / 5) + "1";
            case 2 -> getSNAFU(zahl / 5) + "2";
            case 3 -> getSNAFU((zahl + 2) / 5) + "=";
            case 4 -> getSNAFU((zahl + 1) / 5) + "-";
            default -> null;
        };
    }
    
}
