package ll.com.chain;

public class Main {
    public static void main(String[] args) {
        Logger errorLogger = new ErrorLogger();
        Logger debugLogger = new DebugLogger();
        Logger infoLogger = new InfoLogger();

        // 组装责任链：INFO -> DEBUG -> ERROR
        infoLogger.setNext(debugLogger);
        debugLogger.setNext(errorLogger);

        // 测试
        infoLogger.log(LogLevel.INFO, "系统启动完成");
        infoLogger.log(LogLevel.DEBUG, "调试中，检查变量值");
        infoLogger.log(LogLevel.ERROR, "发生严重错误，程序终止");
    }
}
