package org.training.java17.records;

public class CarMain {

    public static void main(String[] args){
        // 1. Regular class
        Car car = new Car("20043012", "Luis Enrique");
        System.out.println(car);
        System.out.println(car.getOwner());
        System.out.println(car.getRegNumber());

        // 2. Using a record
        CardRecord cardRecord = new CardRecord("245493032", "Goku");
        System.out.println(cardRecord);
        System.out.println(cardRecord.owner()); // slightly different accessor method names
        System.out.println(cardRecord.regNumber());

        // 3. Define an instance method; cannot define an instance field
        System.out.println(cardRecord.isNewCar());

        // 4. Define a static field
        System.out.println(CardRecord.currentYear);

        // 5. Define a static method
        CardRecord blankCar = CardRecord.createBlankCarRecord();
        System.out.println("blank owner: " + blankCar.owner()); // slightly different accessor method names
        System.out.println("blank reg number: " + blankCar.regNumber());

        // 6. Custom canonical constructor and compact constructor
        // 7. Non-canonical record constructor must delegate to another constructor
        // 8. Override the owner() accessor method
        // 9. Cannot define a subtype based on a record
        // 10. Can implement an interface
        // 11. When defining your record, you cannot extend from another type
    }
}
