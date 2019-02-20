package codeCofiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        Application application = context.getBean(Application.class);
        application.run();
    }

    @Bean
    Application application(){
        return new Application(consoleLogger());
    }


    @Bean
    Logger consoleLogger() {
        return new ConsoleLogger();
    }


}
