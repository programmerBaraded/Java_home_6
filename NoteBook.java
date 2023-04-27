import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteBook {
    public NoteBook(String name, int RAM, String operationSys, int HDD, String model, String color) {
        this.name = name;
        this.HDD = HDD;
        this.RAM = RAM;
        this.model = model;
        this.color = color;
        this.operationSys = operationSys;
    
    }

    private String name;
    private String model;
    private String color;
    private String operationSys;
    private int RAM;
    private int HDD;

    public static List<String> Filter(){
        List<String> list = new ArrayList<>();
        list.add("RAM");
        list.add("color");
        list.add("model");
        list.add("operationSys");
        
    }

}
