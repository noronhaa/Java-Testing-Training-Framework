package basicJava;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * junit continued
 * junit tests
 *
 */
public class BasicJavaExamples {

    //These are class variables - the Type must be defined

    //String type - value must be in ""
    String nameOfStringVariable = "hello";

    //int type - value must be whole number
    int nameOfIntVariable = 5;

    //boolean type - value must be either 'true' or 'false'
    boolean nameOfBooleanVariable = true;



    public static void main(String[] args){
        //This is a special method which can be run, anything inside this method - any code or methods called will be executed

        //This is a coommand to print the contents or value of whats inside the brackets
        System.out.println("Hello World");
    }


    void methodWithLocalVariables(){
        //these are local variables as they are inside a method, they can ONLY be accessed from with in the method
        String localStringVariable = "hello locally";
        int localintVariable = 6;
        boolean localbooleanVariable = false;
    }


    void methodWithNoRetunrType(){
        //a method that does not return anything
        //everything in between the { } will be executed when the method is called
    }


    String methodWithAStringReturnType(){
        return "this string value will be retuned when the method is called";
    }


    int methodWithIntReturnType(){
        //the int value 5 will be returned when the method is called
        return 5;
    }


    boolean methodWithBooleanReturnType(){
        //the boolean value true will be returned when the method is called
        return true;
    }


    void methodWithAStringParameter(String nameOfStringParameter){
       //when this method is called it must be called with a string parameter eg - methodWithAStringParameter("Hello World")
        //this method will print the value of the string the method is called with
        System.out.println(nameOfStringVariable);
    }


    void methodWithMultipleParametersOfDifferentTypes(String name, int age, int height){
        //methods can have multiple paramters of different types
        //methodWithMultipleParametersOfDifferentTypes("Ashley",22,156); this would display "Name: Ashley, Age: 22, height 156"
        System.out.println("Name: "+name + ", Age: " + age + ", height " + height);
    }

    void variableNumOfParameters(int... numbers){
        //now put input into a loop and it will do stuff with as many variable as you put in! - format int array
        for (int number: numbers){
            System.out.println(number);
        }

    }


    @Test
    public void junitDemoTest(){

        int int1 = 4;
        int int2 =4;

        assertEquals("numbers dont match",int1,int2);
        String name1 = "Ashley";
        String name2 = "Ash";

//                assertEquals("name dont match",name1,name2);
        assertTrue("Name match not found", name1.contains(name2));
    }

    @Test
    public void junitIfStatementTest(){

        int refundRequestAge = 9;
        boolean giveRefund;

        if (refundRequestAge < 8){
            giveRefund =true;
        } else if (refundRequestAge == 8){
            giveRefund = false;
        } else {
            giveRefund = false;
        }

        int i = 5;
        Integer j = 6;

        assertTrue(giveRefund);





//        if (refundRequestAge < 8){
//            System.out.println("true - give refund!!");
//        }
//
//        if (refundRequestAge == 8){
//            System.out.println("maybe give refund");
//        }
//
//        if (refundRequestAge > 8){
//            System.out.println("dont give refund");
//        }



    }


}
