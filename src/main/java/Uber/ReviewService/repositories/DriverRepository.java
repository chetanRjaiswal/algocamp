package Uber.ReviewService.repositories;

import Uber.ReviewService.models.Booking;
import Uber.ReviewService.models.CustomDriver;
import Uber.ReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    //List<Booking> findAll
    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);


    @Query(nativeQuery = true,value = "SELECT * FROM DRIVER WHERE id= :id AND license_number= :license")
    //Above is raw SQL Query or native Query if query has any mistake error will come on runtime by mysql.
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id,String license);

    @Query("SELECT d FROM Driver as d WHERE d.id= :id AND d.licenseNumber= :license")
    Optional<Driver> hqlFindByIdAndLicense(Long id, String license);
    // @Query("FROM Driver as d WHERE d.id= :id AND d.licenseNumber= :ln")
    //@Query("select new Uber.ReviewService.models.CustomDriver(d.id,d.name) from Driver d where d.id = :id and d.licenseNumber= :license")
    //Optional<CustomDriver> hqlFindByIdAndLicense(Long id, String license);
    //above is Hibernate query language and if query has issue error will come at compile time only that boost the
    // performance of application because error already be checked at compile time.


    List<Driver> findAllByIdIn(List<Long> driverIds);
}
