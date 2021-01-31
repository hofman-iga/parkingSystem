package pl.hofman.parkingSystem.model;


import javax.persistence.*;

@Entity
@Table(name = "parking_user")
public class UserDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String userNameDb;
    private String passwordDb;
    private String roleDb;

    public UserDb() {
    }

    public UserDb(Integer id) {
        this.id = id;
    }

    public UserDb(String firstName) {
        this.firstName = firstName;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", eMail='" + eMail + '\'' +
//                ", userName='" + userNameDb + '\'' +
//                ", parkingSpaceId=" + parkingSpace.getId() + '\'' +
//                ", parkingSpace=" + parkingSpace.getState() + '\'' +
//                ", parkingSpaceDate='" + parkingSpace.getDateToWhen() +
//                '}';
//    }

    @Override
    public String toString() {
        return ("\r\n"+"\r\n"+"(*) Parking Space Number: " + parkingSpace.getId() + "\r\n"+
                "Parking Space State: " + parkingSpace.getState() + "\r\n"+
                "Parking Space Date to When State: " + parkingSpace.getDateToWhen()) + "\r\n"+
                "Owner: " + firstName +" "+ lastName + "\r\n"+
                "eMail: " + eMail;
    }


    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getUserNameDb() {
        return userNameDb;
    }

    public String getPasswordDb() {
        return passwordDb;
    }

    public String getRoleDb() {
        return roleDb;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setUserNameDb(String userNameDb) {
        this.userNameDb = userNameDb;
    }

    public void setPasswordDb(String passwordDb) {
        this.passwordDb = passwordDb;
    }

    public void setRoleDb(String roleDb) {
        this.roleDb = roleDb;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

   public void setParkingSpace(ParkingSpace parkingSpace) {
      this.parkingSpace = parkingSpace;
    }

    @OneToOne(cascade = {CascadeType.PERSIST})
    private ParkingSpace parkingSpace;
}
