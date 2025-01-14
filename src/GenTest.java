public class GenTest<E> implements InterfaceGenTest<E> {

    public static <E> void doSth(E x){
        System.out.println(x);
    }

    BinNodeGen<E> doMore(){
        return null;
    }
}
