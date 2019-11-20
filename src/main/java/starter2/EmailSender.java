package starter2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

//@ConditionalOnProperty("to.address")
@Service
public class EmailSender implements Sender {
    Logger log = LoggerFactory.getLogger(this.getClass());

    //@Autowired
   // private Mail mail;

    @Value("${emails}")
    public  List<String> emails;
//    @Autowired
//    ArrayList emails= new ArrayList(Arrays.asList(mail.getAddress().split(",")));

    public void send(String message) {
        emails.forEach(e -> {
            log.info("Sending mail with text {} on email {}", message, e);
        });
    }
}
