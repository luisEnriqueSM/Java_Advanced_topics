package org.training.java17.records;

// regNumber and owner are know as 'components'
public record CardRecord(String regNumber, String owner) {
    // private final int age; // instance fields must be listed in constructor signature above
    // 4. Define a static field
    public static final String currentYear = "24";

    // 3. Define an instance method; cannot define an instance field
    public boolean isNewCar(){
        return regNumber.substring(0,2).equals(currentYear);
    }

    // 5. Define a static method
    public static CardRecord createBlankCarRecord(){
        return new CardRecord("      ", "");
    }

    // 6. Custom canonical constructor and compact constructor
    // custom canonical constructor
    // no arguments explicitly defined
    public CardRecord{
        if(regNumber.length() <= 4){
            throw new IllegalArgumentException();
        }
    }

    // 7. Non-canonical record constructor must delegate to another constructor
    public CardRecord(){
        this("    ", "");
    }

    // 8. Override the owner() accessor method
    @Override
    public String owner(){
        return owner.toUpperCase();
    }
}

// 9. Cannot define a subtype based on a record
// Because it's final
// class X extends CardRecord{}

// 11. When defining your record, you cannot extend from another type
// We cannot extends from CardRecord because that class is inheriting from Record class
// and we cannot do multiple inheritance.
