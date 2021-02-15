package pl.hofman.parkingSystem.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.hofman.parkingSystem.model.ParkingSpace;
import pl.hofman.parkingSystem.model.UserDb;
import pl.hofman.parkingSystem.repository.UserRepository;

@Component
@Profile("demo")
public class UserData implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        UserDb userDb = new UserDb();
        userDb.setFirstName("Iga");
        userDb.setLastName("Hofman");
        userDb.seteMail("i.hofman@gmail.com");
        userDb.setUserNameDb("ihofman");
        userDb.setPasswordDb("parking1");
        userDb.setRoleDb("ROLE_ADMIN");

        ParkingSpace parkingSpace = new ParkingSpace();
        //parkingSpace.setId(1);
        parkingSpace.setState("free");
        parkingSpace.setDateToWhen("02-02-2021");
        userDb.setParkingSpace(parkingSpace);

        userRepository.save(userDb);

        UserDb userDb2 = new UserDb();
        userDb2.setFirstName("Jan");
        userDb2.setLastName("Nowak");
        userDb2.seteMail("j.nowak@gmail.com");
        userDb2.setUserNameDb("jnowak");
        userDb2.setPasswordDb("parking2");
        userDb2.setRoleDb("ROLE_USER");

        ParkingSpace parkingSpace2 = new ParkingSpace();
        //parkingSpace2.setId(2);
        parkingSpace2.setState("occupied");
        parkingSpace2.setDateToWhen("15-02-2021");
        userDb2.setParkingSpace(parkingSpace2);

        userRepository.save(userDb2);


        UserDb userDb3 = new UserDb();
        userDb3.setFirstName("Maria");
        userDb3.setLastName("Bak");
        userDb3.seteMail("m.bak@gmail.com");
        userDb3.setUserNameDb("mbak");
        userDb3.setPasswordDb("parking3");
        userDb3.setRoleDb("ROLE_USER");

        ParkingSpace parkingSpace3 = new ParkingSpace();
        //parkingSpace3.setId(3);
        parkingSpace3.setState("occupied");
        parkingSpace3.setDateToWhen("01-03-2021");
        userDb3.setParkingSpace(parkingSpace3);

        userRepository.save(userDb3);

        UserDb userDb4 = new UserDb();
        userDb4.setFirstName("Ewa");
        userDb4.setLastName("Wisniewska");
        userDb4.seteMail("e.wisniewska@gmail.com");
        userDb4.setUserNameDb("ewisniewska");
        userDb4.setPasswordDb("parking4");
        userDb4.setRoleDb("ROLE_USER");

        ParkingSpace parkingSpace4 = new ParkingSpace();
        //parkingSpace4.setId(4);
        parkingSpace4.setState("occupied");
        parkingSpace4.setDateToWhen("10-02-2021");
        userDb4.setParkingSpace(parkingSpace4);

        userRepository.save(userDb4);

        UserDb userDb5 = new UserDb();
        userDb5.setFirstName("Andrzej");
        userDb5.setLastName("Kowalski");
        userDb5.seteMail("a.kowalski@gmail.com");
        userDb5.setUserNameDb("akowalski");
        userDb5.setPasswordDb("parking5");
        userDb5.setRoleDb("ROLE_USER");

        ParkingSpace parkingSpace5 = new ParkingSpace();
        //parkingSpace4.setId(4);
        parkingSpace5.setState("occupied");
        parkingSpace5.setDateToWhen("01-02-2021");
        userDb5.setParkingSpace(parkingSpace5);

        userRepository.save(userDb5);

        UserDb userDb6 = new UserDb();
        userDb6.setFirstName("Marek");
        userDb6.setLastName("Zdunski");
        userDb6.seteMail("m.zdunski@gmail.com");
        userDb6.setUserNameDb("mzdunski");
        userDb6.setPasswordDb("parking6");
        userDb6.setRoleDb("ROLE_USER");

        ParkingSpace parkingSpace6 = new ParkingSpace();
        //parkingSpace4.setId(4);
        parkingSpace6.setState("free");
        parkingSpace6.setDateToWhen("01-03-2021");
        userDb6.setParkingSpace(parkingSpace6);

        userRepository.save(userDb6);

        UserDb userDb7 = new UserDb();
        userDb7.setFirstName("Joanna");
        userDb7.setLastName("Kot");
        userDb7.seteMail("j.kot@gmail.com");
        userDb7.setUserNameDb("jkot");
        userDb7.setPasswordDb("parking7");
        userDb7.setRoleDb("ROLE_USER");

        ParkingSpace parkingSpace7 = new ParkingSpace();
        //parkingSpace4.setId(4);
        parkingSpace7.setState("free");
        parkingSpace7.setDateToWhen("01-02-2021");
        userDb7.setParkingSpace(parkingSpace7);

        userRepository.save(userDb7);

        UserDb userDb8 = new UserDb();
        userDb8.setFirstName("Marcin");
        userDb8.setLastName("Jaskolski");
        userDb8.seteMail("m.jaskolski@gmail.com");
        userDb8.setUserNameDb("mjaskolski");
        userDb8.setPasswordDb("parking8");
        userDb8.setRoleDb("ROLE_USER");

        ParkingSpace parkingSpace8 = new ParkingSpace();
        //parkingSpace4.setId(4);
        parkingSpace8.setState("occupied");
        parkingSpace8.setDateToWhen("01-03-2021");
        userDb8.setParkingSpace(parkingSpace8);

        userRepository.save(userDb8);
    }
}
