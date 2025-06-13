import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorGrouping {

    public record Car(String type, String make, String model, Integer engineCapacity) {
    }

    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("sedan", "BMW", "530", 1998),
                new Car("sedan", "Audi", "A5", 1990),
                new Car("sedan", "Mercedes", "E class", 2500),
                new Car("hatchback", "Skoda", "Octavia", 1600),
                new Car("hatchback", "Toyota", "HRV", 1450));

        // Map has structure (type, (make, engineCapacity))
        Map<String, Map<String, Integer>> groupedCars = cars.stream().collect(
                // groupingBy(car -> car.type, toMap(car -> car.model, car -> car.engineCapacity)));
                Collectors.groupingBy(car -> car.type, Collectors.toMap(Car::make, Car::engineCapacity)));

        System.out.println("Grouped cars: " + groupedCars);                        
    }
}