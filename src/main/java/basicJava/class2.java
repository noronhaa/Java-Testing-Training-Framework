package basicJava;

public class class2 extends class1{

    public class2(String name){
        super(name);
    }


    public static void main(String[] args){

        useClass2();
    }


    public static void useClass2() {
        System.out.println(class1.name2);
    }
}
