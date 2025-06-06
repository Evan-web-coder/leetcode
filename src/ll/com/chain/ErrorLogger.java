package ll.com.chain;

public class ErrorLogger extends Logger {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.ERROR;
    }

    @Override
    protected void write(String message) {
        System.out.println("[ERROR] " + message);
    }
}
