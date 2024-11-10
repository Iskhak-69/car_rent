package alatoo.car_rent.mapper;

import alatoo.car_rent.model.entity.Car;
import alatoo.car_rent.model.dto.car.CarRequest;
import alatoo.car_rent.model.dto.car.CarResponse;
import java.util.List;

public interface CarMapper {
    Car toCar(CarRequest request);
    CarResponse toCarResponse(Car car);
    List<CarResponse> toCarResponseList(List<Car> cars);
}
