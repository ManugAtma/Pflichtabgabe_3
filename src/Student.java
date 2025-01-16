public class Student implements StudentInterface, Comparable<Student> {
    private int matriculationNo;
    private String name;
    private String course;

    /**
     * creates a default student object with name 'unknown', course 'unknown' and matriculation number 100000
     */
    public Student() {
        matriculationNo = 100000; // default 6 digit matriculation number
        name = "unknown";
        course = "unknown";
        System.out.println("Default student with name 'unknown', course 'unknown' and matriculation number " + matriculationNo + " was created.");
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
        matriculationNo = m;
        setName(n);
        setCourse(c);
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

    @Override
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
