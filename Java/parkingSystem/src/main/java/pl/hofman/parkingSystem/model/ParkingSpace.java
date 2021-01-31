package pl.hofman.parkingSystem.model;


import javax.persistence.*;


@Entity
@Table(name = "parking_space")
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String state;
    private String dateToWhen;

    public ParkingSpace() {
    }

    public ParkingSpace(Integer id) {
        this.id = id;
    }

    public ParkingSpace(String state) {
        this.state = state;
    }

    //public ParkingSpace(User user) {
     //   this.user = user;
    //}

    public Integer getId() {
        return id;
    }

    //public User getUser() {
   //     return user;
   // }

    //public void setUser(User user) {
   //     this.user = user;
    //}


    @Override
    public String toString() {
        return "ParkingSpace{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", dateToWhen='" + dateToWhen + '\'' +
                ", userDb=" + userDb +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDateToWhen() {
        return dateToWhen;
    }

    public void setDateToWhen(String dateToWhen) {
        this.dateToWhen = dateToWhen;
    }

    @OneToOne(mappedBy = "parkingSpace")
    private UserDb userDb;
}
