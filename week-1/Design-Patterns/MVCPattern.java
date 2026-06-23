package designpatterns;

class StudentModel {

    String name;
    String id;

    StudentModel(String name, String id) {
        this.name = name;
        this.id = id;
    }
}

class StudentView {

    void show(StudentModel student) {
        System.out.println("Name : " + student.name);
        System.out.println("Id : " + student.id);
    }
}

class StudentController {

    StudentModel student;
    StudentView view;

    StudentController(StudentModel student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    void updateView() {
        view.show(student);
    }
}

public class MVCPattern {

    public static void main(String[] args) {

        StudentModel student = new StudentModel("Anand", "101");

        StudentView view = new StudentView();

        StudentController controller =
                new StudentController(student, view);

        controller.updateView();

        student.name = "Anand Dev";

        controller.updateView();
    }
}