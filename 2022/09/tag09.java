import java.io.*;
import java.util.*;

public class tag09
{
    ArrayList<String> liste = new ArrayList<String>();
    ArrayList<Stack>  stapel = new ArrayList<Stack>();
    
    public tag09()
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
        HashSet<Punkt> schwanzPositionen = new HashSet<Punkt>();
        Punkt kopfPos = new Punkt(0,0);
        Punkt schwanzPos = new Punkt(0,0);
        for(String s : liste) {
            String[] teile = s.split(" ");
            int weite = Integer.parseInt(teile[1]);
            Punkt dir = null;
            switch(teile[0]) {
                case "U":
                    dir = Punkt.HOCH;
                    break;
                case "D":
                    dir = Punkt.RUNTER;
                    break;
                case "L":
                    dir = Punkt.LINKS;
                    break;
                case "R":
                    dir = Punkt.RECHTS;
                    break;
            }
            for(int i = 0; i < weite; i++) {
                kopfPos.dazu(dir);
                schwanzPos = bewegSchwanz(kopfPos, schwanzPos);
                schwanzPositionen.add(schwanzPos.copy());
            }
        }
        
        System.out.println("Teil 1:"+schwanzPositionen.size());     
    }
    
    void startwo(){
        ArrayList<Punkt> schwaenze = new ArrayList<Punkt>();
        Punkt kopfPos = new Punkt(0,0);
        for(int i = 0; i < 9; i++)
            schwaenze.add(new Punkt(0,0));
        HashSet<Punkt> schwanzPositionen = new HashSet<Punkt>();
        for(String s : liste) {
            String[] teile = s.split(" ");
            int weite = Integer.parseInt(teile[1]);
            Punkt dir = null;
            switch(teile[0]) {
                case "U":
                    dir = Punkt.HOCH;
                    break;
                case "D":
                    dir = Punkt.RUNTER;
                    break;
                case "L":
                    dir = Punkt.LINKS;
                    break;
                case "R":
                    dir = Punkt.RECHTS;
                    break;
            }
            for(int i = 0; i < weite; i++) {
                //push head, then move each tail incrementally
                kopfPos.dazu(dir);
                for(int j = 0; j < 9; j++)
                    schwaenze.set(j,bewegSchwaenze((j > 0 ? schwaenze.get(j-1) : kopfPos),schwaenze.get(j)));
                schwanzPositionen.add(schwaenze.get(8).copy());
            }
        }
        
        System.out.println("Teil 2: "+ schwanzPositionen.size()); 
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
    
    public Punkt bewegSchwanz(Punkt kopf, Punkt schwanz) {
        if(kopf.dist(schwanz) == 0 || schwanz.alleNachbarn().contains(kopf)) {
            return schwanz;
        }
        if((kopf.x == schwanz.x || kopf.y == schwanz.y) && kopf.dist(schwanz) > 1) {
            if(kopf.x != schwanz.x) {
                schwanz.x += Math.signum(kopf.x - schwanz.x);
            } else {
                schwanz.y += Math.signum(kopf.y - schwanz.y);
            }
            return schwanz;
        }
        if(kopf.x != schwanz.x && kopf.y != schwanz.y) {
            ArrayList<Punkt> beweg = schwanz.alleNachbarn();
            beweg.retainAll(kopf.direkteNachbarn());
            return beweg.get(0);
        }
        return null;
    }
    
    public Punkt bewegSchwaenze(Punkt kopf, Punkt schwanz) {
        if(kopf.dist(schwanz) == 0 || schwanz.alleNachbarn().contains(kopf)) {
            return schwanz;
        }
        if((kopf.x == schwanz.x || kopf.y == schwanz.y) && kopf.dist(schwanz) > 1) {
            if(kopf.x != schwanz.x) {
                schwanz.x += Math.signum(kopf.x - schwanz.x);
            } else {
                schwanz.y += Math.signum(kopf.y - schwanz.y);
            }
            return schwanz;
        }
        if(kopf.x != schwanz.x && kopf.y != schwanz.y) {
            ArrayList<Punkt> beweg = schwanz.alleNachbarn();
            beweg.retainAll(kopf.alleNachbarn());
            beweg.sort(new Comparator<Punkt>() {
                @Override
                public int compare(Punkt o1, Punkt o2) {
                    return Integer.compare(o1.dist(kopf),o2.dist(kopf));
                }
            });
            return beweg.get(0);
        }
        return null;

    }
    
}
