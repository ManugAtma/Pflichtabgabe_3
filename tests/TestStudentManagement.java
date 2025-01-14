import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStudentManagement {
    StudentManagement sm;
    StudentManagement emptySm;
    Student rafael;
    Student attila;
    Student monty;

    @BeforeEach
    void createStudentManagement(){
        sm = new StudentManagement();
        rafael = new Student(555555, "Rafael", "AI");
        attila = new Student(222222, "Attila", "AI");
        monty = new Student(888888, "Monty", "AI");

        sm.insertStudent(rafael);
        sm.insertStudent(new Student(333333, "Johanna", "AI"));
        sm.insertStudent(new Student(111111, "Cemre", "AI"));
        sm.insertStudent(attila);
        sm.insertStudent(monty);

        emptySm = new StudentManagement();
    }

    @Test
    void insertStudents(){
        System.out.println(sm);
    }

    @Test
    void countStudents(){
        assertEquals(5, sm.countStudents());
        assertEquals(0, emptySm.countStudents());

        assertTrue(sm.insertStudent(new Student(123456,"sb", "sth")));
        assertEquals(6, sm.countStudents());
    }

    @Test
    void searchStudentSuccessfully(){
        assertEquals(attila, sm.searchStudent(222222));
        assertEquals(monty, sm.searchStudent(888888));
        assertEquals(rafael, sm.searchStudent(555555));
    }

    @Test
    void searchStudentReturnNull(){
        assertNull(sm.searchStudent(123456));
        assertNull(sm.searchStudent(434343));
        assertNull(sm.searchStudent(767676));

        assertEquals(5, sm.countStudents());
    }

    @Test
    void searchStudentIllegalArgument(){
        assertThrows(IllegalArgumentException.class, ()->sm.searchStudent(0));
        assertThrows(IllegalArgumentException.class, ()->sm.searchStudent(1234567));
    }

    @Test
    void isStudentTrue(){
        assertTrue(sm.isStudent(rafael));
        assertTrue(sm.isStudent(attila));
        assertTrue(sm.isStudent(monty));
    }

    @Test
    void isStudentFalse(){
        Student s = new Student(123456, "sb", "sth");
        assertFalse(sm.isStudent(s));
    }

    @Test
    void isStudentNullPointer(){
        assertThrows(NullPointerException.class, ()->sm.isStudent(null));
    }
}
