package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car audi = new Car("Audi", 100);
      Car lada = new Car("Lada", 2101);
      Car ford = new Car("Ford", 999);
      Car fiat = new Car("Fiat", 3);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setCar(audi);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setCar(lada);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setCar(ford);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      user4.setCar(fiat);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();

      System.out.println("\nБыли созданы и получены из БД юзеры:\n");

      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
         System.out.println(user.toString());
      }
      System.out.println("\nЮзер, владеющий машиной по ее модели и серии\n");
      System.out.println(userService.getUserByCar("Ford", 999).toString());

      context.close();
   }
}
