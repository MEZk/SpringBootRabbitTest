import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.github.mezk.callbackprocessor.CallbackProcessorFactory;

@SpringBootApplication
@ComponentScan("io.github.mezk")
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServiceLocatorFactoryBean callbackProcessorsFactory() {
        ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
        bean.setServiceLocatorInterface(CallbackProcessorFactory.class);
        return bean;
    }
}
