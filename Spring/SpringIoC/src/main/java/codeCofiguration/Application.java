package codeCofiguration;


public class Application {
    private Logger logger;

    public Application(Logger logger) {
        this.logger = logger;
    }
    void run() {
        logger.logMessage("IoC is OK");
    }
}
