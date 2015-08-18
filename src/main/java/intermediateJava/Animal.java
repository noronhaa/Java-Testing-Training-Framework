package intermediateJava;

/**
 * Created by noronhaa on 13/08/15.
 */
public class Animal {

    public static void staticMethod(){
        System.out.println("this is a static superclass method");
    }

    public void instanceMethod(){
        System.out.println("this is a instance superclass method");
    }

}

class Cat extends Animal{

    public static void staticMethod(){
        System.out.println("this is a static subclass method");
    }

    public  void instanceMethod(){
        System.out.println("this is a instance subclass method");
    }


    public static void main(String[] args){

        Cat cat = new Cat();
        cat.instanceMethod();
        Cat.staticMethod();
        Animal animal = cat;
        animal.instanceMethod();
        Animal.staticMethod();
    }
}
