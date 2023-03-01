package az.raheddin.springbootrabbitmq.listener;

import az.raheddin.springbootrabbitmq.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationListener {

    @RabbitListener(queues = "raheddin-queue",concurrency = "10")
    public void handleMessage1(Notification notification) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Thread Name:"+Thread.currentThread().getName());
        System.out.println("Z1:" + notification.toString());
    }

   // @RabbitListener(queues = "raheddin-queue",concurrency = "10")
    public void handleMessage2(Notification notification) throws InterruptedException {
      //  Thread.sleep(4000);
        System.out.println("R1:" + notification.toString());
    }

}
