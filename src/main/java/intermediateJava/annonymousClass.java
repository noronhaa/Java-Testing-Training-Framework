package intermediateJava;

/**
 * Created by noronhaa on 12/08/15.
 */
public class annonymousClass {

    public void read(){
        System.out.println("normal read");
    }


}

class anomClass{

    annonymousClass anom = new annonymousClass(){
        public void read(){
            System.out.println("this is overriding");
        }
    };


        }
