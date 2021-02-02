package pl.hofman.parkingSystem.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    public String getParkingSpaces(){
        List<UserDb> allUsers = userRepository.findAll();
        return allUsers.toString();
    }

    @GetMapping("/user")
    //Swagger:
    @ApiOperation(value = "Displays all data of logged user",
                  notes = "User data (name, mail, parking space details displayed); logging in required",
                  response = UserDb.class)

    public Optional<UserDb> getUserData(@AuthenticationPrincipal MyUserDetails userDetails) {
        String userFirstName = userDetails.getFirstNameLog();
        Optional<UserDb> optionalUserDb = userRepository.findByUserNameDb(userDetails.getUserDbLog().getUserNameDb());
        return optionalUserDb;
    }

    @GetMapping("/admin")
    //Swagger:
    @ApiOperation(value = "Endpoint available only for admin; displays all users data",
                  notes = "All users accounts data available for admin",
                  response = UserDb.class)
    public List<UserDb> getAdminData(){
        return userRepository.findAll();
    }

    @PutMapping("/edit")
    //Swagger:
    @ApiOperation(value = "Endpoint enabling logged user changing his parking space state",
                  notes = "Only state and due date of parking space can be changed; required json format",
                  response = UserDb.class)
    public ResponseEntity<UserDb> updateSpaceStatus(@AuthenticationPrincipal MyUserDetails userDetails, @RequestBody ParkingSpace parkingSpace) {

       UserDb userDbParking = userDetails.getUserDbLog();

        Optional<ParkingSpace> optionalParkingSpace = spaceRepository.findById(userDbParking.getParkingSpace().getId());
        optionalParkingSpace.get().setState(parkingSpace.getState());
        optionalParkingSpace.get().setDateToWhen(parkingSpace.getDateToWhen());
        spaceRepository.save(optionalParkingSpace.get());
      return new ResponseEntity<>(HttpStatus.OK);
  }
}
