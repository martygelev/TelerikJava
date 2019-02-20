package annotationConfiguration;
import org.springframework.stereotype.Component;

@Component
public class ConsoleLogger  implements  Logger{

    @Override
    public void logMessage(String message) {
        System.out.println(message);
    }
}
