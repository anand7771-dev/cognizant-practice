package designpatterns;

public class BuilderPattern {

    static class Student {
        String name;
        int age;
        String course;

        private Student(Builder b) {
            this.name = b.name;
            this.age = b.age;
            this.course = b.course;
        }

        public void display() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Course: " + course);
        }

        static class Builder {
            String name;
            int age;
            String course;

            Builder(String name) {
                this.name = name;
            }

            Builder age(int age) {
                this.age = age;
                return this;
            }

            Builder course(String course) {
                this.course = course;
                return this;
            }

            Student build() {
                return new Student(this);
            }
        }
    }

    public static void main(String[] args) {

        Student s1 = new Student.Builder("Anand")
                .age(21)
                .course("B.Tech")
                .build();

        s1.display();

        Student s2 = new Student.Builder("Rahul")
                .course("BCA")
                .build();

        s2.display();
    }
}