import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBinTreeGen {
    BinTreeGen<Integer> tree;
    BinTreeGen<Integer> emptyTree;

    @BeforeEach
    void createTrees() {

        BinNodeGen<Integer> k1 = new BinNodeGen<Integer>(2);
        BinNodeGen<Integer> k2 = new BinNodeGen<Integer>(7);
        BinNodeGen<Integer> m1 = new BinNodeGen<Integer>(4, k1, k2);
        BinNodeGen<Integer> m2 = new BinNodeGen<Integer>(11);
        BinNodeGen<Integer> m = new BinNodeGen<Integer>(8, m1, m2);
        BinNodeGen<Integer> n = new BinNodeGen<Integer>(20);
        BinNodeGen<Integer> o = new BinNodeGen<Integer>(15, m, n);
        tree = new BinTreeGen<>(o);

        emptyTree = new BinTreeGen<>();
    }

    @Test
    void insertSuccessfully() {
        BinTreeGen<Integer> sameTree = new BinTreeGen<>();
        sameTree.insertNode(15);
        sameTree.insertNode(8);
        sameTree.insertNode(20);
        sameTree.insertNode(11);
        sameTree.insertNode(4);
        sameTree.insertNode(2);

        assertTrue(sameTree.insertNode(7));

        System.out.println(sameTree);
        System.out.println(tree);

        assertTrue(sameTree.toString().equals(tree.toString()));
    }

    @Test
    void insertEmptyTree() {
        assertEquals(0,emptyTree.countNodes());
        emptyTree.insertNode(15);
        assertEquals(1,emptyTree.countNodes());

        System.out.println(emptyTree);
    }

    @Test
    void insertItemAlreadyExists() {
        assertEquals(7,tree.countNodes());

        assertFalse(tree.insertNode(15));
        assertFalse(tree.insertNode(2));
        System.out.println(tree);

        assertEquals(7,tree.countNodes());
    }

    @Test
    void insertItemNull() {
        assertEquals(7,tree.countNodes());

        assertFalse(tree.insertNode(null));
        System.out.println(tree);

        assertEquals(7,tree.countNodes());
    }

    @Test
    void countDefault(){
        assertEquals(7,tree.countNodes());
        tree.insertNode(1);
        assertEquals(8,tree.countNodes());
    }

    @Test
    void countEmptyTree(){
        assertEquals(0,emptyTree.countNodes());
        emptyTree.insertNode(1);
        assertEquals(1,emptyTree.countNodes());
    }

    @Test
    void findSuccessfully() {
        assertTrue(tree.find(15).data.compareTo(15) == 0);
        assertTrue(tree.find(11).data.compareTo(11) == 0);
        assertTrue(tree.find(2).data.compareTo(2) == 0);
        assertTrue(tree.find(20).data.compareTo(20) == 0);
    }

    @Test
    void findReturnNull() {
        assertTrue(tree.find(33) == null);
        assertTrue(tree.find(1) == null);

    }

    @Test
    void findEmptyTree() {
        assertTrue(emptyTree.find(15) == null);

    }

    @Test
    void findItemNull() {
        assertThrows(NullPointerException.class, () -> tree.find(null));
    }


    @Test
    void toStringDefault() {
        System.out.println(tree);
    }

    @Test
    void toStringEmptyTree() {
        System.out.println(emptyTree);
    }
}
