import Vehicle.Vehicle;
import Vehicle.Motorcycle;
import Vehicle.Car;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)

class VehicleTest {
//    private final Car car = new Car("BMW", "M5", 2010); ;
//    private final Motorcycle motorcycle = new Motorcycle("Yamaha", "YZF", 2020);

    private Car car;
    private Motorcycle motorcycle;

    @BeforeAll
    void start() {
        this.car = new Car("BMW", "M5", 2010);
        this.motorcycle = new Motorcycle("Yamaha", "YZF", 2020);
    }

    @AfterEach
    void stopVehicle() {
        car.park();
        motorcycle.park();
    }

    //проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
    @Test
    void carIsVehicle() {
        assertTrue(this.car instanceof Vehicle);
    }

    //проверка того, объект Car создается с 4-мя колесами
    @Test
    void countWheelsCarQuatro() {
        assertEquals(car.getNumWheels(), 4);
    }

    //проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    void countWheelsMotoTwo() {
        assertEquals(motorcycle.getNumWheels(), 2);

    }

    //проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    void speedCarTestDriving() {
        car.testDrive();
        assertEquals(car.getSpeed(), 60);
    }

    //проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    void speedMotoTestDriving() {
        motorcycle.testDrive();
        assertEquals(motorcycle.getSpeed(), 75);
    }

    //проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    void speedCarParkingZero() {
        car.testDrive();
        car.park();
        assertEquals(car.getSpeed(), 0);
    }


    //проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    @Test
    void speedMotoParkingZero() {
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(motorcycle.getSpeed(), 0);
    }
}