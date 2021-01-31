package pl.hofman.parkingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.hofman.parkingSystem.model.ParkingSpace;
import pl.hofman.parkingSystem.model.UserDb;
import pl.hofman.parkingSystem.repository.SpaceRepository;
import pl.hofman.parkingSystem.repository.UserRepository;
import pl.hofman.parkingSystem.service.MyUserDetails;
import pl.hofman.parkingSystem.service.MyUserDetailsService;

import java.awt.print.Book;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
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

    public String getParkingSpaces(){
        List<UserDb> allUsers = userRepository.findAll();
        return allUsers.toString();
    }

    @GetMapping("/user")

    public Optional<UserDb> getUserData(@AuthenticationPrincipal MyUserDetails userDetails) {
        String userFirstName = userDetails.getFirstNameLog();
        Optional<UserDb> optionalUserDb = userRepository.findByUserNameDb(userDetails.getUserDbLog().getUserNameDb());
        return optionalUserDb;
    }

    @GetMapping("/admin")

    public List<UserDb> getAdminData(){
        return userRepository.findAll();
    }

    @PutMapping("/edit")
    public ResponseEntity<UserDb> updateSpaceStatus(@AuthenticationPrincipal MyUserDetails userDetails, @RequestBody ParkingSpace parkingSpace) {

       UserDb userDbParking = userDetails.getUserDbLog();
       //userDbParking.setFirstName(userDb.getFirstName());
        Optional<ParkingSpace> optionalParkingSpace = spaceRepository.findById(userDbParking.getParkingSpace().getId());
       optionalParkingSpace.get().setState(parkingSpace.getState());
        optionalParkingSpace.get().setDateToWhen(parkingSpace.getDateToWhen());
        //ParkingSpace userParkingSpace = userDetails.getParkingSpaceLog();

       //userParkingSpace.setState(state);
        //userParkingSpace.setDateToWhen(parkingSpace.getDateToWhen());
        spaceRepository.save(optionalParkingSpace.get());
        //modelMap.put("")
      return new ResponseEntity<>(HttpStatus.OK);
  }


    //public String getUserData(Principal principal) {
    //    return principal.;
  // }

//    public ResponseEntity getUserData() {
//
//        Optional<UserDb> optionalUser = userRepository.findByUserNameDb(myUserDetails.getUsername());
//        if (optionalUser.isPresent()) {
//            return ResponseEntity.ok(optionalUser.get().getFirstName());
//        } else {
//            return (ResponseEntity) ResponseEntity.notFound();
//        }
//    }


}
