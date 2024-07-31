// Save this as SingletonTest.java
public class SingletonPatternExample {
    public static void main(String[] args) {
        // Test Singleton behavior
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Verify both references point to the same instance
        System.out.println("Logger1 instance hash code: " + logger1.hashCode());
        System.out.println("Logger2 instance hash code: " + logger2.hashCode());

        // Test logging functionality
        logger1.log("This is a log message.");

        // Verify that both references are the same and log the message
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 refer to the same instance.");
        } else {
            System.out.println("Different instances for logger1 and logger2.");
        }
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("LOG: " + message);
    }

    public static class Logger {

        // Step 2: Private static instance of the class
        private static Logger instance;

        // Step 3: Private constructor to prevent instantiation
        private Logger() {
        }

        // Step 4: Public static method to provide access to the instance
        static Logger getInstance() {
            if (instance == null) {
                synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                }
            }
            return instance;
        }

        // Method to log messages
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }
}
