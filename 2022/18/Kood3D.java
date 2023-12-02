import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Kood3D {
    public int x,y,z;
    
    public Kood3D() {
        x = 0;
        y = 0;
        z = 0;
    }
    
    public Kood3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public void dazu(Kood3D o) {
        x += o.x;
        y += o.y;
        z += o.z;
    }
    
    public Kood3D addzurueck(Kood3D o) {
        return new Kood3D(x + o.x, y+o.y, z+o.z);
    }
    
    public Kood3D subzurueck(Kood3D o) {
        return new Kood3D(x-o.x,y-o.y,z-o.z);
    }
    
    public ArrayList<Kood3D> allenachbarn() {
        ArrayList<Kood3D> nachbarn = new ArrayList<Kood3D>();
        for(int zOff = -1; zOff < 2; zOff++) {
            for(int xOff = -1; xOff < 2; xOff++) {
                for(int yOff = -1; yOff < 2; yOff++) {
                    if(!(zOff == 0 && xOff == 0 && yOff == 0)) {
                        nachbarn.add(new Kood3D(x+xOff,y+yOff,z+zOff));
                    }
                }
            }
        }
        return nachbarn;
    }

    public ArrayList<Kood3D> direktenachbarn() {
        ArrayList<Kood3D> nachbarn = new ArrayList<Kood3D>();
        for(int zOff = -1; zOff < 2; zOff++) {
            for(int xOff = -1; xOff < 2; xOff++) {
                for(int yOff = -1; yOff < 2; yOff++) {
                    if(!(zOff == 0 && xOff == 0 && yOff == 0) && (Math.abs(xOff) + Math.abs(yOff) + Math.abs(zOff) < 2)) {
                        nachbarn.add(new Kood3D(x+xOff,y+yOff,z+zOff));
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
        Kood3D other = (Kood3D) obj;
        return x == other.x && y == other.y && z == other.z;
    }
    
    public Kood3D copy() {
        return new Kood3D(x,y,z);
    }
    
    public int dist(Kood3D o) {
        return Math.abs(o.x - x) + Math.abs(o.y - y) + Math.abs(o.z - z);
    }
}