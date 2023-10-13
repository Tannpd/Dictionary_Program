
import Controller.Manager;
public class Main {
    public static void main(String[] args) {
        String mChon[] = {"Add new word", "Delete word","Search word"};
        Manager manager = new Manager("Main Menu", mChon, "exit");
        manager.run();
    }
}
