public abstract class TestStuff {
    final int f;

    TestStuff(){
        f= 3;
    }

    TestStuff(int a){
        this();
        System.out.println("hi");
    }

    abstract void doSth();
}
