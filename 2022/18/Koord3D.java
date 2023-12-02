import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Koord3D {
    public int x,y,z;
    
    public Koord3D() {
        x = 0;
        y = 0;
        z = 0;
    }
    
    public Koord3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public void dazu(Koord3D o) {
        x += o.x;
        y += o.y;
        z += o.z;
    }
    
    public Koord3D addzurueck(Koord3D o) {
        return new Koord3D(x + o.x, y+o.y, z+o.z);
    }
    
    public Koord3D subzurueck(Koord3D o) {
        return new Koord3D(x-o.x,y-o.y,z-o.z);
    }
    
    public ArrayList<Koord3D> allenachbarn() {
        ArrayList<Koord3D> nachbarn = new ArrayList<Koord3D>();
        for(int zOff = -1; zOff < 2; zOff++) {
            for(int xOff = -1; xOff < 2; xOff++) {
                for(int yOff = -1; yOff < 2; yOff++) {
                    if(!(zOff == 0 && xOff == 0 && yOff == 0)) {
                        nachbarn.add(new Koord3D(x+xOff,y+yOff,z+zOff));
                    }
                }
            }
        }
        return nachbarn;
    }

    public ArrayList<Koord3D> direktenachbarn() {
        ArrayList<Koord3D> nachbarn = new ArrayList<Koord3D>();
        for(int zOff = -1; zOff < 2; zOff++) {
            for(int xOff = -1; xOff < 2; xOff++) {
                for(int yOff = -1; yOff < 2; yOff++) {
                    if(!(zOff == 0 && xOff == 0 && yOff == 0) && (Math.abs(xOff) + Math.abs(yOff) + Math.abs(zOff) < 2)) {
                        nachbarn.add(new Koord3D(x+xOff,y+yOff,z+zOff));
                    }
                }
            }
        }
        return nachbarn;
    }
    
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Koord3D other = (Koord3D) obj;
        return x == other.x && y == other.y && z == other.z;
    }
    
    public Koord3D copy() {
        return new Koord3D(x,y,z);
    }
    
    public int dist(Koord3D o) {
        return Math.abs(o.x - x) + Math.abs(o.y - y) + Math.abs(o.z - z);
    }
}