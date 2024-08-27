package Uber.ReviewService.services;

import Uber.ReviewService.models.Booking;
import Uber.ReviewService.models.CustomDriver;
import Uber.ReviewService.models.Driver;
import Uber.ReviewService.repositories.BookingRepository;
import Uber.ReviewService.repositories.DriverRepository;
import Uber.ReviewService.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;
    List<Driver> drivers;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        System.out.println("*******************");
//        Review review = Review.builder()
//                        .content("Amazing ride quality")
//                        .rating(5.0).build();
//
//        Booking booking = Booking.builder()
//                    .review(review)
//                    .endTime(new Date())
//                    .build();
//
//        //reviewRepository.save(review);
//        bookingRepository.save(booking);
//        System.out.println(review);
//        Optional<Booking> booking= bookingRepository.findById(1L);
//        if(booking.isPresent())
//            bookingRepository.delete(booking.get());
  //       Optional<Driver> driver = driverRepository.findById(1L);
//        if(driver.isPresent()){
//           // System.out.println(driver.get().getName());
//            List<Booking> bookings =  driver.get().getBookings();
//            for (Booking b :
//                    bookings) {
//                //System.out.println(b.getId());
//            }
//           List<Booking> bookings = bookingRepository.findAllByDriverId(1L);
//            for(Booking booking : bookings){
//                System.out.println(booking.getBookingStatus());
//           }
//        }
//        Optional<Booking> booking =  bookingRepository.findById(1L);
       //Optional<Driver> driver2 =  driverRepository.hqlFindByIdAndLicense(2L,"MP11-3423");
      // System.out.println(driver2.get().getName());
        List<Long> driverIds = new ArrayList<>(Arrays.asList(1L,2L,3L,5L,6L,7L,8L));
        List<Driver> driver_s = driverRepository.findAllByIdIn(driverIds);

       // List<Booking> bookings = bookingRepository.findAllByDriverIn(driver_s);

        for(Driver driver1 : driver_s){
             List<Booking> bookings =  driver1.getBookings();
            bookings.forEach(booking-> System.out.println(booking.getId()));
        }

    }

}
