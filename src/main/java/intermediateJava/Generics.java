package intermediateJava;

/**
 * Created by noronhaa on 13/08/15.
 */
public class Generics {

    public static void main(String[] args){
        String words[] = {"ash","mike","ben"};
        String word1 = "a";
        String word2 = "b";
        String word3 = "c";
        generics1(word1,word2,word3);



        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);
    }

    public static void generics1(String... strings){
        for (String string : strings){
            System.out.println(string);
        }
    }

    public static <E> void printArray(E[] array){
        for (E value : array){
            System.out.println(value);
        }
    }
}
