import java.util.*;

// geklaut 2019 hua rue jos ge + geh

public class Punkt implements Comparable<Punkt> {
	public int x = 0;
	public int y = 0;
	
	public static final Punkt HOCH   = new Punkt( 0,-1);
	public static final Punkt RUNTER = new Punkt( 0, 1);
	public static final Punkt RECHTS = new Punkt( 1, 0);
	public static final Punkt LINKS  = new Punkt(-1, 0);
	
	public Punkt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Punkt() {
		this(0,0);
	}	

	@Override
	public int hashCode() {
		return Objects.hash(y,x);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) 
        	        return true;
	    if (obj == null) 
    	        return false;
	    if (getClass() != obj.getClass()) 
	        return false;
		
	    Punkt other = (Punkt) obj;
		
	    if (x != other.x) 
	        return false;
	    if (y != other.y) 
	        return false;
	    
	    return true;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	// Punkt dazu addieren
	public void dazu(Punkt o) {
		x += o.x;
		y += o.y;
	}
	
	// Neuer Punkt verschoben um 
	public Punkt dazuzurueck(Punkt o) {
		return new Punkt(x + o.x, y + o.y);
	}
	
	// Manhattandistanz zu Punkt O
	public int dist(Punkt o) {
		return Math.abs(x - o.x) + Math.abs(y - o.y);
	}
	
	// Kopie vom Punkt
	public Punkt copy() {
		return new Punkt(x,y);
	}
	
	// x und Y vertauscht zurueck
	public Punkt invert() {
		return new Punkt(y,x);
	}
	
	// Direkte Nachbarn als Arraylist zurueck
	public ArrayList<Punkt> direkteNachbarn() {
		ArrayList<Punkt> list = new ArrayList<Punkt>();
		for(int yOff = -1; yOff < 2; yOff++) {
			for(int xOff = -1; xOff < 2; xOff++) {
				//if not diagonal or self
				if(xOff == 0 ^ yOff == 0) {
					list.add(new Punkt(x+xOff,y+yOff));
				}
			}
		}
		return list;
	}
	// Alle Nachbarn als Arraylist zurueck
	public ArrayList<Punkt> alleNachbarn() {
		ArrayList<Punkt> list = new ArrayList<Punkt>();
		for(int yOff = -1; yOff < 2; yOff++) {
			for(int xOff = -1; xOff < 2; xOff++) {
				//if not self
				if(!(xOff == 0 && yOff == 0)) {
					list.add(new Punkt(x+xOff,y+yOff));
				}
			}
		}
		return list;
	}

	// vergleiche Punkte
	@Override
	public int compareTo(Punkt o) {
		if(this.equals(o))
			return 0;
		else if(o.y > this.y)
			return -1;
		else if(o.y < this.y)
			return 1;
		else
			return (o.x > this.x ? -1 : 1);
	}
	
	// x negieren
	public Punkt links() {
		return new Punkt(y,-x);
	}
	// y negieren
	public Punkt rechts() {
		return new Punkt(-y,x);
	}
}