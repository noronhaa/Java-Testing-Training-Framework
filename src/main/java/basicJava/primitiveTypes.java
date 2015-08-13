package basicJava;

/**
 * Created by noronhaa on 10/08/15.
 */
public class primitiveTypes {

    public static void main(String[] args){
        class2 cl2 = new class2("ashley");
        String name = cl2.name;
        System.out.println(name);
    }


    //Must be in ""
//    String nameOfStringVariable = "value of variable";
    String nameOfStringVariable = "6";

    //must be whole number
    static int nameOfIntVariable = 5;

    //can be decimal
    double nameOfDoubleVariable = 5.44;

    //can be only true or false
    boolean nameOfBooleanVariable = true;
    boolean nameOfBooleanVariable2 = false;

    void thisIsAMethod(){
        System.out.println("Everything here will be executed by the method");
    }



//    nameOfStringVariable;nameOfIntVariable;nameOfDoubleVariable;nameOfBooleanVariable;nameOfBooleanVariable2;



}
