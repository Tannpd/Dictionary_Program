package Controller;

import Common.Library;
import View.Menu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Manager extends Menu {
    Library l;
    HashMap<String, String> hm = new HashMap<>();
    public Manager(String td, String[] mc, String exit) {
        super(td, mc, exit);
        l = new Library();
        hm = new HashMap<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addNewWord(hm);
                break;
            case 2:
                deleteWord(hm);
                break;
            case 3:
                translate(hm);
                break;
        }
    }

      public void addNewWord(HashMap<String, String> hm) {
        System.out.print("Enter English: ");
        String english = l.checkInputString();
        if (!checkKeywordExist(hm, english)) {
            if (!l.checkInputYN()) {
                return;
            }
        }
        System.out.print("Enter Vietnamese: "); 
        String vietnam = l.checkInputString();
        //check key word english exist or not
        hm.put(english, vietnam);
        System.err.println("Add successful.");
    }

    //delete word
    public void deleteWord(HashMap<String, String> hm) {
        System.out.print("Enter english: ");
        String english = l.checkInputString();
        hm.remove(english);
        System.err.println("Delete successful.");
    }

    //translate
    public void translate(HashMap<String, String> hm) {
        System.out.print("Enter english: ");
        String english = l.checkInputString();
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry entry : entries) {
            if (entry.getKey().equals(english)) {
                System.out.println("Vietnamese: " + entry.getValue());
                return;
            }
        }
        System.err.println("Not found in data");
    }

    //check key englist exist
    public boolean checkKeywordExist(HashMap<String, String> hm, String english) {
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (english.equalsIgnoreCase(mentry.getKey().toString())) {
                return false;
            }
        }
        return true;
    }

}
