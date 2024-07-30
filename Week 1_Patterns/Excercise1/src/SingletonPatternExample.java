class Logger{
    private static Logger instance;
    private Logger(){} 

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(String msg){
        System.out.println("log message: "+msg);
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        // Get the instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log some messages
        logger1.log("message from log1");
        logger2.log("message from log2");

        // Check if both instances are the same
        if(logger1 == logger2){
        System.out.println("loggers are same");
        }   else{
            System.out.println("loggers are different.");
        }
    }
}