package pl.hofman.parkingSystem.service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import pl.hofman.parkingSystem.model.ParkingSpace;
import pl.hofman.parkingSystem.model.UserDb;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private String firstNameLog;
    private ParkingSpace parkingSpaceLog;
    private UserDb userDbLog;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(UserDb user) {
        this.userName = user.getUserNameDb();
        this.password = user.getPasswordDb();
        this.authorities = Arrays.stream(user.getRoleDb().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        this.firstNameLog = user.getFirstName();
        this.parkingSpaceLog = user.getParkingSpace();
        this.userDbLog = user;
    }

    public MyUserDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }


    public String getFirstNameLog() {
        return firstNameLog;
    }


    public UserDb getUserDbLog() {
        return userDbLog;
    }

    public ParkingSpace getParkingSpaceLog() {
        return parkingSpaceLog;
    }

    public void setParkingSpaceLog(ParkingSpace parkingSpaceLog) {
        this.parkingSpaceLog = parkingSpaceLog;
    }

    public void setUserDbLog(UserDb userDbLog) {
        this.userDbLog = userDbLog;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
