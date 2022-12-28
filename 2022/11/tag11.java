import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import java.io.IOException;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class tag11
{
    ArrayList<String> liste = new ArrayList<String>();
    public tag11()
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
        ArrayList<affe> affen = new ArrayList<affe>();
        for(int ii=0;ii<liste.size();ii=ii+7) 
        {
            affe a = new affe();
           
            String[] itemWoerter = liste.get(ii+1).trim().split(", | +");
            
            ArrayList<Long> items = new ArrayList<Long>();
            for(int i = 2; i < itemWoerter.length; i++){
                items.add(Long.parseLong(itemWoerter[i]));
            }
            
            a.setitems(items);
            
            String[] opWerte = liste.get(ii+2).trim().split(" ");
            a.setadd(opWerte[opWerte.length - 2].equals("+"));

            if(opWerte[opWerte.length - 1].equals("old"))
                a.setquadrat(true);
            else
                a.setopwert(Integer.parseInt(opWerte[opWerte.length - 1]));

            String[] testWords = liste.get(ii+3).trim().split(" ");
            a.setmod(Integer.parseInt(testWords[testWords.length - 1]));

            String[] trueWords = liste.get(ii+4).trim().split(" ");
            a.setzielwahr(Integer.parseInt(trueWords[trueWords.length-1]));
            
            String[] falseWords = liste.get(ii+5).trim().split(" ");
            a.setzielfalsch(Integer.parseInt(falseWords[falseWords.length-1]));
            
            affen.add(a);
        }
        
        long[] kontrollzaehler = new long[affen.size()];
        for(int lauf = 0; lauf < 20; lauf++) {
            for(int affennum = 0; affennum < affen.size(); affennum++) {
                affe derzeit = affen.get(affennum);
                if(derzeit.getitemssize() == 0)
                    continue;

                while(derzeit.getitemssize() > 0) {
                    long derzeititem = derzeit.itemsremove(0);
                    kontrollzaehler[affennum]++;
                    if(derzeit.getquadrat()) {
                        derzeititem *= derzeititem;
                    } else if (derzeit.getadd()) {
                        derzeititem += derzeit.getopwert();
                    } else {
                        derzeititem *= derzeit.getopwert();
                    }
                    derzeititem /= 3;
                    if (derzeititem % derzeit.getmod() == 0) {
                        affen.get(derzeit.getzielwahr()).itemsadd(derzeititem);
                    } else {
                        affen.get(derzeit.getzielfalsch()).itemsadd(derzeititem);
                    }
                }
            }
        }
        // Sortieren 
        Arrays.sort(kontrollzaehler);
        System.out.print("Stern Eins: "+ wert(kontrollzaehler));        
    }
    
    
    void startwo(){
        ArrayList<affe> affen = new ArrayList<affe>();
        for(int ii=0;ii<liste.size();ii=ii+7) 
        {
            affe a = new affe();
           
            String[] itemWoerter = liste.get(ii+1).trim().split(", | +");
            
            ArrayList<Long> items = new ArrayList<Long>();
            for(int i = 2; i < itemWoerter.length; i++){
                items.add(Long.parseLong(itemWoerter[i]));
            }
            
            a.setitems(items);
            
            String[] opWerte = liste.get(ii+2).trim().split(" ");
            a.setadd(opWerte[opWerte.length - 2].equals("+"));

            if(opWerte[opWerte.length - 1].equals("old"))
                a.setquadrat(true);
            else
                a.setopwert(Integer.parseInt(opWerte[opWerte.length - 1]));

            String[] testWords = liste.get(ii+3).trim().split(" ");
            a.setmod(Integer.parseInt(testWords[testWords.length - 1]));

            String[] trueWords = liste.get(ii+4).trim().split(" ");
            a.setzielwahr(Integer.parseInt(trueWords[trueWords.length-1]));
            
            String[] falseWords = liste.get(ii+5).trim().split(" ");
            a.setzielfalsch(Integer.parseInt(falseWords[falseWords.length-1]));
            
            affen.add(a);
        }
        
        List<Integer> pruefen = affen.stream().map(x -> x.getmod()).toList();
        int lcm = lcm(pruefen,0);
        
        long[] kontrollzaehler = new long[affen.size()];
        for(int lauf = 0; lauf < 10000; lauf++) {
            for(int affennum = 0; affennum < affen.size(); affennum++) {
                affe derzeit = affen.get(affennum);
                if(derzeit.getitemssize() == 0)
                    continue;

                while(derzeit.getitemssize() > 0) {
                    long derzeititem = derzeit.itemsremove(0);
                    kontrollzaehler[affennum]++;
                    if(derzeit.getquadrat()) {
                        derzeititem *= derzeititem;
                    } else if (derzeit.getadd()) {
                        derzeititem += derzeit.getopwert();
                    } else {
                        derzeititem *= derzeit.getopwert();
                    }
                    derzeititem %= lcm;
                    if (derzeititem % derzeit.getmod() == 0) {
                        affen.get(derzeit.getzielwahr()).itemsadd(derzeititem);
                    } else {
                        affen.get(derzeit.getzielfalsch()).itemsadd(derzeititem);
                    }
                }
            }
        }
        
        Arrays.sort(kontrollzaehler);
        System.out.print("Stern Zwei: "+ wert(kontrollzaehler));        
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
    
    
    // Standard (geklaut)
    private static int lcm(List<Integer> numbers, int i) {
        if(i == numbers.size() - 1) 
        {
            return numbers.get(i);
        }
        int a = numbers.get(i);
        int b = lcm(numbers,i+1);
        
        return (a * b)/gcd(a,b);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private String wert( long[] kontrollzaehler)
    {
        return Long.toString(kontrollzaehler[kontrollzaehler.length - 2] * kontrollzaehler[kontrollzaehler.length - 1]);
    }
}
