package alatoo.car_rent.controllers;

import alatoo.car_rent.model.dto.booking.BookingRequest;
import alatoo.car_rent.model.dto.booking.BookingResponse;
import alatoo.car_rent.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @GetMapping
    public List<BookingResponse> getAllBookings(
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        // Если статус указан, получаем бронирования с этим статусом
        if (status != null) {
            return bookingService.getAllBookingsByStatus(status, page, size);
        } else {
            // Если статус не указан, получаем все бронирования
            return bookingService.getAllBookings(page, size);
        }
    }

    @GetMapping("/myBookings")
    public List<BookingResponse> getAllTenantBookings(
            @RequestHeader("Authorization") String token,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        // Получаем все бронирования арендатора
        return bookingService.getAllTenantsBooking(token, page, size);
    }

    @GetMapping("/{id}")
    public BookingResponse getBookingById(@PathVariable UUID id) {
        // Получаем информацию о бронировании по ID
        return bookingService.getBookingById(id);
    }

    @PostMapping("/{carId}")
    public List<BookingResponse> createBooking(
            @RequestHeader("Authorization") String token,
            @PathVariable UUID carId,
            @RequestBody BookingRequest request
    ) {
        // Создаем новое бронирование
        return bookingService.createBooking(token, carId, request);
    }
}
