import java.util.ArrayList;

public class affe
{
    private ArrayList<Long> items;

    private boolean add;
    private boolean quadrat;

    private int opwert;
    
    private int mod;

    private int zielwahr;
    private int zielfalsch;

    public affe() {}
    
    public void setitems(ArrayList<Long> items){ this.items = items; }
    public ArrayList<Long> getitems(){return items;}
    
    public int getitemssize(){return items.size();}
    
    public long itemsremove(int i){return items.remove(i);}
    public void itemsadd(long i){items.add(i);}
    
    
    public void setzielwahr(int zielwahr) { this.zielwahr = zielwahr; }
    public int getzielwahr() { return this.zielwahr; }
    
    public void setzielfalsch(int zielfalsch) { this.zielfalsch = zielfalsch; }
    public int getzielfalsch() { return this.zielfalsch; }
    
    public void setmod(int mod) { this.mod = mod; }
    public int getmod() { return mod; }
    
    public void setopwert(int opwert) { this.opwert = opwert; }
    public int getopwert() { return opwert; }
    
    public void setadd(boolean add) { this.add = add; }
    public boolean getadd() { return add; }
    
    public void setquadrat(boolean quadrat) { this.quadrat = quadrat; }
    public boolean getquadrat() { return quadrat; }
}
