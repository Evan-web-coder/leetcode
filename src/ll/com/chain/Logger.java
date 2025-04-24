package ll.com.chain;

public abstract class Logger {
    protected Logger next;  // 下一个处理器

    public void setNext(Logger next) {
        this.next = next;
    }

    public void log(LogLevel level, String message) {
        if (canHandle(level)) {
            write(message);
        } else if (next != null) {
            next.log(level, message); // 传递给下一个
        }
    }

    protected abstract boolean canHandle(LogLevel level);
    protected abstract void write(String message);
}
