import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestStudent {
    Student s1;

    @BeforeEach
    void createStudent() {
        s1 = new Student(123456, "Rafael", "Applied Computer Science");
    }

    @Test
    void parameterlessConstructor() {
        Student s2 = new Student();
    }

    @Test
    void constructorExceptions() {
        assertThrows(IllegalArgumentException.class, () -> new Student(1234567, "Rafael", "Applied Computer Science"));
        assertThrows(NullPointerException.class, () -> new Student(123456, null, "Applied Computer Science"));
        assertThrows(NullPointerException.class, () -> new Student(123456, "Rafael", null));
        assertThrows(IllegalArgumentException.class, () -> new Student(1234567, "", "Applied Computer Science"));
        assertThrows(IllegalArgumentException.class, () -> new Student(1234567, "Rafael", ""));
    }

    @Test
    void toStringTest() {
        System.out.println(s1);
    }
}
