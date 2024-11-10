package alatoo.car_rent.service;

import alatoo.car_rent.model.dto.booking.BookingRequest;
import alatoo.car_rent.model.dto.booking.BookingResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface BookingService {
    List<BookingResponse> getAllBookings(int page, int size);
    List<BookingResponse> getAllTenantsBooking(String token, int page, int size);
    List<BookingResponse> getAllBookingsByStatus(String status, int page, int size);
    BookingResponse getBookingById(UUID id);
    List<BookingResponse> createBooking(String token, UUID carId, BookingRequest request);
}