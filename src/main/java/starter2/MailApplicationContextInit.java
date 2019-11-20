package starter2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;


public class MailApplicationContextInit implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
       ConfigurableEnvironment environment=configurableApplicationContext.getEnvironment();
        PropertySource ps=null;
        try {
           ps = new ResourcePropertySource(new ClassPathResource("project.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       environment.getPropertySources().addFirst(ps);
        if(environment.getProperty("emails")==null||environment.getProperty("emails").isEmpty()){


                throw new NoMailFoundException("You need to add mails to your project properties!");



        }else System.out.println("Vse normalno");
    }
}
