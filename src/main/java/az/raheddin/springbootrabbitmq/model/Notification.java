package az.raheddin.springbootrabbitmq.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class Notification implements Serializable {

    private String notificationId;
    private Date createAt;
    private Boolean seen;
    private String msj;


}
