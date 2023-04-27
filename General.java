import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;


public class General {
        
    public static void main(String[] args) {
        
        Set<NoteBook> set = new HashSet<>();
        set.add(new NoteBook("NB_1", 8, "Windows10", 256, "HP Pavilion Gaming 15-ec", "black"));
        set.add(new NoteBook("NB_2", 8, "Mac OC", 320, "Apple MacBook Pro 17", "white"));
        set.add(new NoteBook("NB_3", 4, "Windows 7", 1000, "Dell Latitude E4310", "white"));
        set.add(new NoteBook("NB_4", 8, "Windows 10", 500, "Lenovo ThinkPad X270", "pearl"));

        Fanction fanctionNB = new Fanction(set);
        fanctionNB.start();
    }
}