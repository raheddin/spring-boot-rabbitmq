package az.raheddin.springbootrabbitmq;

import az.raheddin.springbootrabbitmq.model.Notification;
import az.raheddin.springbootrabbitmq.producer.NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootRabbitmqApplication implements CommandLineRunner {

    public final NotificationProducer notificationProducer;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootRabbitmqApplication.class, args);
       /* String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(beanName);
        }
        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);*/
    }

    @Override
    public void run(String... args) throws Exception {
       System.out.println("START");
        for (int i = 0; i < 1000000; i++) {
            Notification notification = Notification
                    .builder()
                    .notificationId(UUID.randomUUID().toString())
                    .createAt(new Date())
                    .msj("Raheddin:"+i)
                    .seen(Boolean.FALSE)
                    .build();
           // notificationProducer.sendToQueue(notification);
        }
    }
}
