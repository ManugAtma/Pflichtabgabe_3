public class Main {
    public static void main(String[] args) {
        /*GenTest<?>[] arr = new GenTest<?>[4];
        arr[0] = new GenTest<String>();
        arr[1] = new GenTest<Integer>();*/

        GenTest<String> gt = new GenTest<String>();
        BinNodeGen<String> bn = gt.doMore();

        System.out.println("hi" + "" + "hi");
    }
}