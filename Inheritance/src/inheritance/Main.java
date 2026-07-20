package inheritance;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.doBark(); // parent class method is called here

        GermanShepard germanShepard = new GermanShepard();
        germanShepard.doBark(); // child class method is called here which got extend from parent class
        //child class is empty but as it extends it has methods
        // but during debugging it will go to parent as idea cannot show as it extend thing in child.

    }
}
