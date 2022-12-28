import java.util.Arrays;
// import java.util.List;
import java.util.ArrayList;

import java.io.IOException;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class tag16
{
    ArrayList<String> liste = new ArrayList<String>();
    public tag16()
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
        ArrayList<ventil> ventile = new ArrayList<ventil>();
        for(int ii=0;ii<liste.size();ii++) 
        {
            String[] teile = liste.get(ii).split(", |; | ");
            ventil v = new ventil(teile[1]);
            v.setflow(Integer.parseInt(teile[4].split("=")[1]));
            v.addallverbindung(Arrays.asList(teile).subList(9, teile.length));
            ventile.add(v);
        }
        
        
        
        
        System.out.println("Teil Eins:" +  "");    
    }
    
    
    void startwo(){
            System.out.println("Teil Zwei:" +  "");    
    }
    
    
    void einlesen() throws IOException {
       // File file = new File("input.txt"); 
       File file = new File("test.txt");
       String st;
       BufferedReader br = new BufferedReader(new FileReader(file));
       while ((st = br.readLine()) != null){
           liste.add(st);
        }
    }
}
