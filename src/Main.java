import java.io.Serializable;

public class Main {
    public static void main(String[] args) {
        Number[] arr = new Number[3];
        arr[0] = 3.1;
        for (int i = 0; i< 10 ; i++){
            System.out.println((999999-100000)*0.1);
        }
        TestStuff<String> tss = new TestStuff<String>();
        TestStuff<Integer> tsi = new TestStuff<Integer>();
        TestStuff<?>[] arr2 = new TestStuff<?>[3];
        arr2[0] = tss;
        arr2[1] = tsi;

        Serializable s = TestStuff.random("hi",4);
    }
}