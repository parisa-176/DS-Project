import java.awt.event.PaintEvent;
import java.util.*;

public class Person extends Node {
    String key;
    String name;
    String lastName;
    String birthDate;
    String birthPlace;
    String workPlace;
    static Dictionary<String, Person> dict = new Hashtable<>();

    Person(String name, String lastName, String key, String birthDate, String birthPlace, String workPlace) {
        this.name = name;
        this.lastName = lastName;
        this.key = key;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.workPlace = workPlace;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++)
            dict.put(data.get(i)[2], new Person(data.get(i)[0], data.get(i)[1], data.get(i)[2], data.get(i)[3], data.get(i)[4], data.get(i)[5]));
    }

    public static void showData() {
        Enumeration e = dict.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }

    static public void findSazmani(Dictionary<String,Person> dictionary) {
        Dictionary<String,Person> dic_find = null;
        Enumeration e = dictionary.elements();
        while (e.hasMoreElements()){
            Person person = (Person)e.nextElement();
            if(person.workPlace.equals("گمرک") || person.workPlace.equals("بنادر")){
                dic_find.put(person.key,person);
            }
        }
    }
}
