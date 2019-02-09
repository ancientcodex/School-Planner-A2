package Data;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Lesson> lessons;

    public Agenda(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void printLessons(){
        for (Lesson l: lessons) {
            System.out.println(l);
        }
    }

    public int amountOfLessons(){
        return lessons.size();
    }
}