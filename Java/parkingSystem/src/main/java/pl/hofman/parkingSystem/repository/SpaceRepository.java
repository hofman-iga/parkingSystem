package pl.hofman.parkingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hofman.parkingSystem.model.ParkingSpace;

public interface SpaceRepository extends JpaRepository <ParkingSpace, Integer> {
}
