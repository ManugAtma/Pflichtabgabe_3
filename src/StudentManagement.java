public class StudentManagement extends BinTreeGen<Student> implements StudentManagementInterface {

    public StudentManagement() {}


    @Override
    public int countStudents() {
        return countNodes();
    }

    @Override
    public boolean insertStudent(Student student) {
        return insertNode(student);
    }

    @Override
    public Student searchStudent(int matrNo) throws IllegalArgumentException {
        if (matrNo < 100000 || matrNo > 999999) throw new IllegalArgumentException("invalid matriculation number");
        Student p = new Student(matrNo, "p", "p"); // create student object p so that method find(p) can be used
        BinNodeGen<Student> result = find(p);            // declare BinNodeGen variable to store result of find(p)
        return result == null ? null : result.data;
    }

    @Override
    public boolean isStudent(Student s) throws NullPointerException {
        if(s == null) throw new NullPointerException("student cannot be null");
        return find(s) != null;
    }
}
