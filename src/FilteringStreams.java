import java.util.List;

public class FilteringStreams {

    public record Car(String type, String make, String model, Integer engineCapacity) {
    }

    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("sedan", "BMW", "530", 1998),
                new Car("sedan", "Audi", "A5", 1990),
                new Car("sedan", "Mercedes", "E class", 2500),
                new Car("hatchback", "Skoda", "Octavia", 1600),
                new Car("hatchback", "Toyota", "HRV", 1450));

        // return stream of cars(list converted to stream)
        // predicate is an interface which takes one element of our type and returns
        // true or false, this method returns stream of T
        // car -> is a lambda expression
        // we convert our stream to a list by using .toList() method
        List<Car> sedanCars = cars.stream().filter(car -> car.type.equals("sedan")).toList();

        System.out.println(sedanCars);
    }
}
