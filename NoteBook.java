import java.util.ArrayList;
import java.util.List;


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

    public boolean validateBook (){
        return true;
    }

    public static List<String> Filter(){
        List<String> list = new ArrayList<>();
        list.add("RAM");
        list.add("color");
        list.add("model");
        list.add("operationSys");
        list.add("HDD");

        return list;

    }

    @Override
    public String toString() {
        return "Ноутбук: (" + name + "): " +
        "с опретивной памятью:" + RAM + ", энергозависимой памятью: " 
        + HDD + ", операционная система: " + operationSys + '\'' +
        ", цвет: " + color + ", модель: " + model;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRAM(){
        return RAM;
    }
    public void setRAM(int RAM){
        this.RAM = RAM;
    }
    public String getOperationSys(){
        return operationSys;
    }
    public void setOperationSys(String operationSys){
        this.operationSys = operationSys;
    }
    public int getHDD(){
        return HDD;
    }
    public void setHDD(int HDD){
        this.HDD = HDD;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }

}
