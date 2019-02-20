package annotationConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Application {
    private Logger logger;

    @Autowired
    public Application(Logger logger){
        this.logger=logger;
    }

    void run(){
        logger.logMessage("Run from Application Class");
    }
}
