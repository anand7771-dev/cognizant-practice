package designpatterns;

class Database {

    private static Database obj = new Database();

    private Database() {
    }

    public static Database getInstance() {
        return obj;
    }

    public void show() {
        System.out.println("Database Connected");
    }
}

public class SingletonPattern {

    public static void main(String[] args) {

        Database d1 = Database.getInstance();
        Database d2 = Database.getInstance();

        d1.show();

        if(d1 == d2) {
            System.out.println("Same Object");
        }
        else {
            System.out.println("Different Object");
        }
    }
}