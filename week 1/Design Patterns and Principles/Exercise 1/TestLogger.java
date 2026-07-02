public class TestLogger {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.printMessage("First Log Message");
        logger2.printMessage("Second Log Message");

        if (logger1 == logger2) {
            System.out.println("Only one object is created.");
        } else {
            System.out.println("Different objects are created.");
        }
    }
}