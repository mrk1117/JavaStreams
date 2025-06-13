import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorPartitioning {

    public record Car(String type, String make, String model, Integer engineCapacity) {
    }

    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("sedan", "BMW", "530", 1998),
                new Car("sedan", "Audi", "A5", 1990),
                new Car("sedan", "Mercedes", "E class", 2500),
                new Car("hatchback", "Skoda", "Octavia", 1600),
                new Car("hatchback", "Toyota", "HRV", 1450));

        // take elements from a stream and generate a collection T input , A collector
        // type as wildcard and R resulting type
        //
        Map<Boolean, List<Car>> partitionedCars = cars.stream().collect(
                Collectors.partitioningBy(car -> car.type.equals("sedan")));
        
        System.out.println("Partitioned cars: " + partitionedCars);

    }
}
