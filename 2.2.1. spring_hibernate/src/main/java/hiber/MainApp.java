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

        Car car = new Car("Toyota Corolla", 1L);
        Car car2 = new Car("Toyota Camry", 2L);
        Car car3 = new Car("Toyota Land Cruiser", 3L);
        Car car4 = new Car("Toyota Alphard", 4L);
        userService.add(new User("Ivan", "Sidorov", "user1@mail.ru", car));
        userService.add(new User("Anton", "Titov", "user2@mail.ru", car2));
        userService.add(new User("Sergey", "Petrov", "user3@mail.ru", car3));
        userService.add(new User("Irina", "Ivanova", "user4@mail.ru", car4));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        User foundUser = userService.findUserByCar("Toyota Corolla",1L);
        System.out.println("Владелец данного авто " + foundUser.getFirstName() + " " + foundUser.getLastName());
        System.out.println();

        context.close();
    }
}
