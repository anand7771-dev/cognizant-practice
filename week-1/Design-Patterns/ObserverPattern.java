package designpatterns;

import java.util.ArrayList;

interface Observer {
    void update(String message);
}

class Student implements Observer {

    String name;

    Student(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

class Teacher {

    ArrayList<Observer> list = new ArrayList<>();

    void addObserver(Observer o) {
        list.add(o);
    }

    void notifyStudents(String message) {
        for (Observer o : list) {
            o.update(message);
        }
    }
}

public class ObserverPattern {

    public static void main(String[] args) {

        Teacher teacher = new Teacher();

        Student s1 = new Student("Anand");
        Student s2 = new Student("Rahul");

        teacher.addObserver(s1);
        teacher.addObserver(s2);

        teacher.notifyStudents("Class starts at 10 AM");
    }
}