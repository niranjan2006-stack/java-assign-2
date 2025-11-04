package assignment2;

public class Traveler extends Customer {
    private int age;

    public Traveler(int id, String name, int age) {
        super(id, name);
        this.age = age;
    }

    public int getAge() { return age; }
}