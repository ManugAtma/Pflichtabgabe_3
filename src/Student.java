public class Student implements StudentInterface, Comparable<Student> {
    private int matriculationNo;
    private String name;
    private String course;


    public Student() {
        matriculationNo = (int) Math.round((Math.random() * 999999));
        name = "unknown";
        course = "unknown";
        System.out.println("Student with unknown name, unknown course and randomly generated matriculationNo " + matriculationNo + " was created.");
    }

    /**
     * a unique 6-digits matriculation number is assigned to each student
     * upon enrollment
     * each student has a name
     * each student has a course he/she has enrolled for
     *
     * @param m 6-digits matriculation number (i.e. between 100000 and 999999)
     * @param n name, cannot be null or empty string
     * @param c course, cannot be null or empty string
     * @throws IllegalArgumentException if matriculationNo, name or course is not valid
     * @throws NullPointerException     if name or course is null
     */
    public Student(int m, String n, String c)
            throws IllegalArgumentException, NullPointerException {
        if (m < 100000 || m > 999999) throw new IllegalArgumentException("invalid matriculation number");
        if (n == null || c == null) throw new NullPointerException("No argument can be null");
        if (n.isEmpty() || c.isEmpty()) throw new IllegalArgumentException("No argument can be empty");

        matriculationNo = m;
        name = n;
        course = c;
    }

    @Override
    public int getMatriculationNo() {
        return matriculationNo;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) throws NullPointerException, IllegalArgumentException {
        if (name == null) throw new NullPointerException("name cannot be null");
        if (name.isEmpty()) throw new IllegalArgumentException("name cannot be empty");
        this.name = name;
    }

    @Override
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) throws NullPointerException, IllegalArgumentException {
        if (course == null) throw new NullPointerException("course cannot be null");
        if (course.isEmpty()) throw new IllegalArgumentException("course cannot be empty");
        this.course = course;
    }

    @Override
    public String toString() {
        return matriculationNo + ", " + name + ", " + course;
    }

    @Override
    public int compareTo(Student s) throws NullPointerException {
        if(s == null) throw new NullPointerException("s cannot be null");
        return this.matriculationNo - s.getMatriculationNo();
    }
}
