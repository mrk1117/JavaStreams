import java.util.List;
import java.util.stream.Stream;

public class MapFunction {

    public record Car(String type, String make, String model, Integer engineCapacity) {
    }

    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("sedan", "BMW", "530", 1998),
                new Car("sedan", "Audi", "A5", 1990),
                new Car("sedan", "Mercedes", "E class", 2500),
                new Car("hatchback", "Skoda", "Octavia", 1600),
                new Car("hatchback", "Toyota", "HRV", 1450));

        // hybrid list of make and model
        // this is a flat map
        // flattens return list, takes the 2 elements and places them in the list
        // List type can also be of type List instead of String
        List<String> carMakeModelList = cars.stream().flatMap(car -> Stream.of(car.make, car.model)).toList();

        System.out.println(carMakeModelList);
    }
}
