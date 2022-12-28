import java.util.ArrayList;
import java.util.List;

public class ventil {

    private String name;
    private int flow;
    
    public ArrayList<String> verbíndungen = new ArrayList<String>();

    public ventil(){}
    
    public ventil(String name){
        this.name = name;
    }
    
    public String getname(){return name;}
    public void setname(String name){this.name=name;}
    
    public int getflow(){ return flow;}
    public void setflow(int flow){this.flow=flow;}

    public ArrayList<String> getverbindungen(){return verbíndungen;}    
    public void setverbindungen(ArrayList<String> verbindungen){this.verbíndungen=verbíndungen;}
    
    public void addverbindung(String verbindung){this.verbíndungen.add(verbindung);}
    public void addallverbindung(List<String> verbindung){this.verbíndungen.addAll((verbindung));}
    
}