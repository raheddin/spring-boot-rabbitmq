package az.raheddin.springbootrabbitmq.producer;

import az.raheddin.springbootrabbitmq.model.Notification;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationProducer {

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void init() {
     /*   System.out.println("START");
        Notification notification = Notification
                .builder()
                .notificationId(UUID.randomUUID().toString())
                .createAt(new Date())
                .msj("Raheddin Asadzade")
                .seen(Boolean.FALSE)
                .build();
        sendToQueue(notification);*/
    }



    private final RabbitTemplate rabbitTemplate;

    public void sendToQueue(Notification notification) {
        System.out.println("Notification Id:" + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName,routingName, notification);
    }
}
