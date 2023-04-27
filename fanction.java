import java.util.*;

public class Fanction {
    private Set<NoteBook> noteBooks = new HashSet<>();
    private List<Criteria> criterias = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    public void outList (){
        for (NoteBook noteBook : noteBooks) {
            if (noteIsCorrect(noteBook)) {
                System.out.println(noteBook);
            }
        }
    }
    public boolean noteIsCorrect (NoteBook noteBook){
        for (Criteria criteria : criterias) {
            Object valNB = null;

            if () {
                
            }
        }
    }
    public Fanction(Set<NoteBook> noteBooks, List<Criteria> criterias){
        this.scan = new Scanner(System.in);
        this.noteBooks = noteBooks;
        this.criterias = criterias;
    }
}

public class Criteria {
    Object value;
    Double minValue;
    Double maxValue;
    boolean isNum;
    String property;

    public Criteria(String property, boolean isNum, Object value, Double minValue, Double maxValue){
        this.property = property;
        this.isNum = isNum;
        this.value = value;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
    

    
}
