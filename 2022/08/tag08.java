import java.io.*;
import java.util.*;

public class tag08
{
    ArrayList<String> liste = new ArrayList<String>();
    ArrayList<Stack>  stapel = new ArrayList<Stack>();
    int[][] wald;
    Hashtable<Character, Character> ht1 = new Hashtable<>();
    
    public tag08()
    {
        try
        {
            einlesen();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        wald = new int[liste.size()][liste.size()];
        for(int i = 0; i < wald.length; i++) {
            String s = liste.get(i);
            for(int j = 0; j < s.length(); j++) {
                wald[i][j] = Integer.parseInt(s.substring(j,j+1));
            }
        }
        
        starone();
        startwo();
    }
    void starone(){
        int sichtbar = 0;
        Punkt[] RICHTUNG = new Punkt[] {Punkt.HOCH, Punkt.RUNTER, Punkt.LINKS, Punkt.RECHTS};
        for(int i = 0; i < wald.length; i++) {
            for(int j  = 0; j < wald[i].length; j++) {
                int aktuellHoehe = wald[i][j];
                // Teile am Rand immer sichtbar
                if(i == 0 || j == 0 || i == wald.length - 1 || j == wald[i].length - 1) {
                    sichtbar++;
                    continue;
                }
                
                sprung:
                for(Punkt richt : RICHTUNG) {
                    Punkt aktuell = new Punkt(i,j);
                    // In die erste Richtung
                    aktuell.dazu(richt);
                    // erste und letze Punkte ignorieren
                    while(aktuell.x > -1 && aktuell.y > -1 && aktuell.x < wald.length && aktuell.y < wald[i].length) {
                        // Wenn zu klein  dann nächste
                        if(wald[aktuell.x][aktuell.y] >= aktuellHoehe) {
                            continue sprung;
                        }
                        // weiter in die Richtung
                        aktuell.dazu(richt);
                    }
                    // groß genug, sichtbar!
                    sichtbar++;
                    break;
                }
            }
        }
        System.out.println("Teil 1:"+Integer.toString(sichtbar));     
    }
    
    void startwo(){
        long topschoen = 0;
        Punkt[] RICHTUNG = new Punkt[] {Punkt.HOCH, Punkt.RUNTER, Punkt.LINKS, Punkt.RECHTS};
        for(int i = 0; i < wald.length; i++) {
            for(int j  = 0; j < wald[i].length; j++) {
                int aktuellHoehe = wald[i][j];
                long schoen = 1;
                inner:
                for(Punkt richt : RICHTUNG) {
                    long dist = 0;
                    Punkt aktuell = new Punkt(i,j);
                     // In die erste Richtung
                    aktuell.dazu(richt);
                    // erste und letze Punkte ignorieren
                    while(aktuell.x > -1 && aktuell.y > -1 && aktuell.x < wald.length && aktuell.y < wald[i].length) {
                        dist++;
                        // abbruch wenn zu klein
                        if(wald[aktuell.x][aktuell.y] >= aktuellHoehe) {
                            break;
                        }
                        // move in direction
                        aktuell.dazu(richt);
                    }
                    schoen *= dist;
                }
                topschoen = Math.max(schoen,topschoen);
            }
        }
        System.out.println("Teil 2: " + Long.toString(topschoen)); 
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
