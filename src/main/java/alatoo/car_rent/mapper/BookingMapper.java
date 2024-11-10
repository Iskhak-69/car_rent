package alatoo.car_rent.mapper;

import alatoo.car_rent.model.entity.Booking;
import alatoo.car_rent.model.entity.User;
import alatoo.car_rent.model.entity.Car;
import alatoo.car_rent.model.dto.booking.BookingRequest;
import alatoo.car_rent.model.dto.booking.BookingResponse;
import java.util.List;

public interface BookingMapper {
    BookingResponse toBookingResponse(Booking booking);
    Booking toBooking(BookingRequest request, Car car, User tenant);
    List<BookingResponse> toBookingResponses(List<Booking> bookings);
}
