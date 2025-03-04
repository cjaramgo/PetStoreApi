package payloads;

import model.User;
import com.github.javafaker.Faker;

public class UserPayload {

    public static Faker fake = new Faker();
    public static User user = new User();

    public User postUser(){

        user.setId(fake.number().randomDigitNotZero());
        user.setUsername(fake.name().username());
        user.setFirstName(fake.name().firstName());
        user.setLastName(fake.name().lastName());
        user.setEmail(fake.internet().emailAddress());
        user.setPassword(fake.internet().password());
        user.setPhone(fake.phoneNumber().phoneNumber());
        user.setUserStatus("1");

        return user;
    }

    public User putUser(){

        user.setFirstName(fake.name().firstName());
        user.setLastName(fake.name().lastName());
        user.setEmail(fake.internet().emailAddress());
        user.setPhone(fake.phoneNumber().phoneNumber());

        return user;
    }
}
