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

            if (criteria.property.equals("name")) {
                valNB = noteBook.getName();
            }else if (criteria.property.equals("RAM")) {
                valNB = noteBook.getRAM();
            }else if (criteria.property.equals("operationSys")) {
                valNB = noteBook.getOperationSys();
            }else if (criteria.property.equals("HDD")) {
                valNB = noteBook.getHDD();
            }else if (criteria.property.equals("color")){
                valNB = noteBook.getColor();
            }else if (criteria.property.equals("model")) {
                valNB = noteBook.getModel();
            }else{
                continue;
            }

            if (criteria.value != null && !criteria.value.equals(valNB)) {
                return false;
            }
            if (criteria.maxValue != null && criteria.maxValue < Double.parseDouble(Objects.toString(valNB))) {
                return false;
            }
            if (criteria.minValue != null && criteria.minValue > Double.parseDouble(Objects.toString(valNB))) {
                return false;
            }

        }
        return true;
    }
    public Fanction(Set<NoteBook> noteBooks, List<Criteria> criterias){
        this.scan = new Scanner(System.in);
        this.noteBooks = noteBooks;
        this.criterias = criterias;
    }

    public Fanction(Set<NoteBook> noteBooks){
        this.scan = new Scanner(System.in);
        this.noteBooks = noteBooks;
    }

    public int getCriteria(){
        String text = "Выберете пункт меню: ";
        List<String> choice = choiceFilter();

        for (int i = 0; i < choice.size(); i++) {
            text += "\n" + (i+1) + ". " + getChoiceSpec(choice.get(i));
        }
        System.out.println(text);
        int value = scan.nextInt();
        return value;
    }

    public String getChoiceSpec(String choise){
        Map<String, String> descriptionsChoise = descriptionsChoice();
        return descriptionsChoise.get(choise);
    }

    public Map<String, String> descriptionsChoice(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "Наименование");
        map.put("RAM", "Объем оперативной памяти RAM");
        map.put("HDD", "Объем энергозависимой памяти HDD");
        map.put("color", "Цвет ноутбука");
        map.put("model", "Модель ноутбука");
        map.put("operationSys", "Операционная система");
        return map;

    }

    public List<String> choiceFilter(){
        List<String> list = new ArrayList<>();
        list.add("name");
        list.add("RAM");
        list.add("HDD");
        list.add("color");
        list.add("model");
        list.add("operationSys");
        return list;
    }
    public void start(){
        boolean flag = true;
        while (flag) {
            String poll = getPoll();
            if (poll.equals("3")) {
                flag = false;
                scan.close();
                continue;
            }else if (poll.equals("1")) {
                int criteria = getCriteria();
                List<String> choice = choiceFilter();
                if (criteria - 1 < 0 || criteria -1 > choice.size() - 1) {
                    System.out.println("Сделан некорректный выбор параметров: ");
                    continue;
                }
                String str = choice.get(criteria - 1);
                Criteria crObject = null;
                try {
                    if (quantitativeSelection().contains(str)) {
                        crObject = Criteria.startGetting(scan, str, true);
                    }else {
                        crObject = Criteria.startGetting(scan, str, false);
                    }
                }
                catch (Exception e){
                    System.out.println("Ошибка");
                }
                if (crObject != null) {
                    System.out.println("Параметр добавлен");
                    criterias.add(crObject);
                }
            }
            else if (poll.equals("2")) {
                outList();
            }
        }
    }
    public Set<String> quantitativeSelection(){
        Set<String> set = new HashSet<>();
        set.add("RAM");
        set.add("HDD");

        return set;
    }

    public Set<String> stringSelection(){
        Set<String> set = new HashSet<>();
        set.add("name");
        set.add("model");
        set.add("color");
        set.add("operationSys");
        return set;
    }
    public String getPoll(){
        String text = "Выберите опрерацию: \n " +
        "1. Добавить критерий \n " +
        "2. Вывести список \n " +
        "3. Завершить";
        System.out.println(text);
        String answer = scan.next();
        return answer;
    }
    
}

class Criteria {
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

    public static Criteria startGetting(Scanner scan, String choce, boolean isNum){
        if (isNum) {
            String question = "Выберите криетрий выбора: " +
            "\n 1. Значение" +
            "\n 2. Меньше" +
            "\n 3. Больше" +
            "\n 4. Интервал";
            System.out.println(question);
            String text = scan.next();
            Criteria criteria = null;

            if (text.equals("1")) {
                System.out.println("Введите значение поиска: ");
                int getValue = scan.nextInt();
                criteria = new Criteria(choce, isNum, getValue, null, null);
            }
            else if (text.equals("2")) {
                System.out.println("Введите максимальное предельное значение: ");
                double getValue = scan.nextDouble();
                criteria = new Criteria(choce, isNum, null, null, getValue);
            }
            else if (text.equals("3")) {
                System.out.println("Введите минимальное предельное значение: ");
                double getValue = scan.nextDouble();
                criteria = new Criteria(choce, isNum, null, getValue, null);
            } else if (text.equals("4")) {
                System.out.println("Введите минимальное предельное значение: ");
                double getMin = scan.nextDouble();
                System.out.println("Введите максимальное предельное значение: ");
                double getMax = scan.nextDouble();
                criteria = new Criteria(choce, isNum, null, getMin, getMax);
            }

            return criteria;
        }

        System.out.println("Введите значение поиска: ");
        String getValue = scan.next();
        return new Criteria(choce, isNum, getValue, null, null);
    }
       
}
