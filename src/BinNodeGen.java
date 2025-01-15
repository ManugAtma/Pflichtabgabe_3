public class BinNodeGen<E> {
    E data;
    BinNodeGen<E> left;
    BinNodeGen<E> right;

    BinNodeGen(){}

    public BinNodeGen(E data, BinNodeGen<E> left, BinNodeGen<E> right)
            throws NullPointerException {
        if (data == null) throw new NullPointerException("data cannot be null");
        this.data = data;
        this.left = left;
        this.right = right;

    }

    public BinNodeGen(E data) throws NullPointerException {
        if (data == null) throw new NullPointerException("data cannot be null");
        this.data = data;
    }
}

// doc comments for constructors? also for BinTreeGen
// default access for constructors?
// MatrNr, parameterloser Konstruktor Student?
// Eindeutigkeit der MAtrNr außerhalb von StudentManagement prüfen?
// Pakete nutzen?
// "insbesondere Verwendung von Konstanten"
// parameterloser Konstruktor (von Student) auf private ("zur Verfügung")?
