package data_provider;

import dto.Car;
import org.testng.annotations.DataProvider;
import utils.Fuel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static utils.RandomUtils.*;
import static utils.RandomUtils.generateString;

public class CarDP {

    @DataProvider
    public Car[] addNewCarDP() {
        Car car1 = Car.builder()
                .city("Haifa")
                .manufacture("DP Car")
                .model("Astra")
                .year("2020")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-" + generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();

        Car car2 = Car.builder()
                .city("Bat-yam")
                .manufacture("Opel")
                .model("Astra")
                .year("2020")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();

        Car car3 = Car.builder()
                .city("Haifa")
                .manufacture("DP Car")
                .model("Astra")
                .year("2020")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-" + generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();

        return new Car[]{car1, car2, car3};
    }
    @DataProvider
    public Car[] addNewCarDPOnlyForEmptyCity() {
        Car car = Car.builder()
                .city("")
                .manufacture("DP Car")
                .model("Astra")
                .year("2020")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-" + generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();

        return new Car[]{car};
    }

    @DataProvider
    public Car[] addNewCarDPForNegativeTests() {

        Car car1 = Car.builder()
                .city("Haifa")
                .manufacture("")
                .model("Astra")
                .year("2020")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();

        Car car2 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("")
                .year("2020")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        Car car3 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("")
                .year("2020")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();

        Car car4 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        Car car5 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel("")
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        Car car6 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(null)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        Car car7 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        Car car8 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("")
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        Car car9 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(null)
                .about("about")
                .image("1.jpg")
                .build();
        Car car10 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2026")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-" + generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        Car car11 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(21)
                .carClass("C")
                .serialNumber("Opel-" + generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        Car car12 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(1)
                .carClass("C")
                .serialNumber("Opel-" + generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        Car car13 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("fggfgggggggggggq")
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        Car car14 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-" + generateString(7))
                .pricePerDay(-1.0)
                .about("about")
                .image("1.jpg")
                .build();
        Car car15 = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-" + generateString(7))
                .pricePerDay(1001.00)
                .about("about")
                .image("1.jpg")
                .build();

        return new Car[]{car1, car2, car3, car4, car5, car6, car7,
                car8, car9, car10, car11, car12, car13, car14, car15};
    }

    @DataProvider
    public Iterator<Car> addNewCarDPFile() {
        List<Car> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/main/resources/DataProvider/dataCar.csv"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] splitArray = line.split(",");
                list.add(Car.builder()
                                .city(splitArray[0])
                                .manufacture(splitArray[1])
                                .model(splitArray[2])
                                .year(splitArray[3])
                                .fuel(splitArray[4])
                                .seats(Integer.valueOf(splitArray[5]))
                                .carClass(splitArray[6])
                                .serialNumber(splitArray[7])
                                .pricePerDay(Double.valueOf(splitArray[8]))
                        .build());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.listIterator();
    }
}


