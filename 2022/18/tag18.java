import java.io.*;
import java.util.*;

public class tag18
{
    ArrayList<String> liste = new ArrayList<String>();
   
    public tag18()
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
        HashSet<Koord3D> droplets = new HashSet<>();
        for(int ii=0;ii<liste.size();ii++)
        {
            String[] nums = liste.get(ii).split(",");
            droplets.add(new Koord3D(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2])));
        }
        int surfaceArea = 0;
        for(Koord3D c : droplets) {
            int startingSurface = 6;                // Wuerfel
            for(Koord3D d : c.direktenachbarn())
            {
                if(droplets.contains(d)) {
                    startingSurface--;
                }
            }
            surfaceArea += startingSurface;
        }
        System.out.println("Teil 1:"+ surfaceArea);     
    }
    
    void startwo(){
        System.out.println("Teil 2: " + ""); 
    }
    
    
    void einlesen() throws IOException {
       File file = new File("input.txt"); 
       String st;
       BufferedReader br = new BufferedReader(new FileReader(file));
       while ((st = br.readLine()) != null){
           liste.add(st);
        }
    }
}
