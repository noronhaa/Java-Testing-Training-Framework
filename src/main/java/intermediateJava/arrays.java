package intermediateJava;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by noronhaa on 09/08/15.
 */
public class arrays {

    public static void main(String[] args){



    }

    static void staticArray(){

        //normal array - cannot change length, only values
        int[] numArray = {1,2,3};
        numArray[1] = 3;

    }

    void arrayList(){

        //arrayList is non static - can change length!
        ArrayList<Integer> numArrayList =new ArrayList<Integer>();
        numArrayList.add(0,1);


        LinkedList linkedList = new LinkedList();
    }


}
