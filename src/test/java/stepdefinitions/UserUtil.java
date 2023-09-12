package stepdefinitions;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class UserUtil {
       int id;
       String userName;
       String firstName;
       String lastName;
       String email;
       String password;
       String phone;
       String userStatus;
  }
