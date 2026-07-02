public class Logger {

    private static Logger obj = new Logger();

    private Logger() {
        System.out.println("Logger Created");
    }

    public static Logger getInstance() {
        return obj;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}