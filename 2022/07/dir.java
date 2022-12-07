import java.io.*;
import java.util.*;

public class dir
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int size;
    private ArrayList<dir> unterdir;
    private dir oberdir;
    private String name;
    public dir()
    {
        // Verzeichnisgroesse
        size = 0;
        unterdir = new ArrayList<dir>();
        oberdir = null;
        name = "/";
    }
    public dir(String name)
    {
        this();
        this.name = name;
    }
    public dir(String name, dir ober)
    {
        this(name);
        oberdir = ober;
    }
    
    public void adddir(String name)
    {
        dir neuverz = new dir(name, this); 
        unterdir.add(neuverz);
    }
    public dir gettop()
    {
        return oberdir;
    }
    public dir getdir(String name)
    {
        for(int i=0;i<unterdir.size();i++){
            if(unterdir.get(i).name.equals(name)){
                return unterdir.get(i);
            }
        }
        
        return null;
    }
    public void addsize(int file)
    {
        size += file;
    }
    
    public int getsize()
    {
        return size;
    }
    public int checksize(int delete)
    {
       int nowsize = 0;
       for (int i=0; i<unterdir.size();i++){
           nowsize=nowsize+unterdir.get(i).checksize(delete);     
       }
       nowsize += size;
       if(nowsize>delete){
           System.out.println(name + " " + nowsize);    
       }
    
       return nowsize;
    }
}
