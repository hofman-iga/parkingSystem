package pl.hofman.parkingSystem.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.hofman.parkingSystem.model.ParkingSpace;
import pl.hofman.parkingSystem.model.UserDb;
import pl.hofman.parkingSystem.repository.SpaceRepository;
import pl.hofman.parkingSystem.repository.UserRepository;
import pl.hofman.parkingSystem.service.MyUserDetails;
import java.util.List;
import java.util.Optional;

@RequestMapping("/parking")
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SpaceRepository spaceRepository;

    @Autowired
    UserDetails myUserDetails;

    @GetMapping("/all" )
    //Swagger:
    @ApiOperation(value = "Displays all parking spaces and their owners",
            notes = "Parking spaces, their state and due dates available",
            response = UserDb.class)

    public String getUsers(Model model){
        List<UserDb> allUsers = userRepository.findAll();
        model.addAttribute("allUsers", allUsers);
        return "displayAll";
    }

    @RequestMapping("/modify")
    //Swagger:
    @ApiOperation(value = "Endpoint to which user is after changing parking space details",
            notes = "Only state and due date of parking space can be changed",
            response = UserDb.class)
    public String updateSpaceStatus(@AuthenticationPrincipal MyUserDetails userDetails, @RequestParam(value = "state", required = false) String state,
                                    @RequestParam(value = "dateToWhen", required = false) String dateToWhen, Model model) {

        String nameOfUser = userDetails.getFirstNameLog();
        Integer spaceId = userDetails.getParkingSpaceLog().getId();
        model.addAttribute("name",nameOfUser);
        model.addAttribute("spaceId",spaceId);
        model.addAttribute("state",state);
        model.addAttribute("dateToWhen",dateToWhen);
        UserDb userDbParking = userDetails.getUserDbLog();

        Optional<ParkingSpace> optionalParkingSpace = spaceRepository.findById(userDbParking.getParkingSpace().getId());
        optionalParkingSpace.get().setState(state);
        optionalParkingSpace.get().setDateToWhen(dateToWhen);

        spaceRepository.save(optionalParkingSpace.get());

        return "modify";
    }

    @GetMapping("/editSpace")
    //Swagger:
    @ApiOperation(value = "Endpoint enabling logged user changing his parking space state",
            notes = "Only state and due date of parking space can be changed; change done via form",
            response = UserDb.class)

    public String getUserData(@AuthenticationPrincipal MyUserDetails userDetails) {
        return "editSpace";
    }

    @GetMapping("/user")
    //Swagger:
    @ApiOperation(value = "Displays all data of logged user",
            notes = "User data (name, mail, parking space details displayed); logging in required",
            response = UserDb.class)
    public String getUserDataNew(@AuthenticationPrincipal MyUserDetails userDetails, Model model2) {

        Optional<UserDb> optionalUserDb = userRepository.findByUserNameDb(userDetails.getUserDbLog().getUserNameDb());
        UserDb userDb = optionalUserDb.get();
        String nameOfUser = userDb.getFirstName();
        String spaceState = userDb.getParkingSpace().getState();
        String spaceDate = userDb.getParkingSpace().getDateToWhen();
        ParkingSpace parkingSpace = userDb.getParkingSpace();
        Integer spaceId = parkingSpace.getId();

        model2.addAttribute("name",nameOfUser);
        model2.addAttribute("spaceId",spaceId);
        model2.addAttribute("spaceState",spaceState);
        model2.addAttribute("spaceDate",spaceDate);

        return "userWeb";
    }


    @GetMapping("/admin")
    //Swagger:
    @ApiOperation(value = "Endpoint available only for admin; displays all users data",
            notes = "All users accounts data available for admin",
            response = UserDb.class)
    public List<UserDb> getAdminData(){
        return userRepository.findAll();
    }
}
