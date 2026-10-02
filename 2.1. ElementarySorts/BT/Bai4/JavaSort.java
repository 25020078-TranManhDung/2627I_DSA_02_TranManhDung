import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {return id;}
    public String getFname() {return fname;}
    public double getCgpa() {return cgpa;}
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.getCgpa() != s2.getCgpa()) {
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        }

        if (!s1.getFname().equals(s2.getFname())) {
            return s1.getFname().compareTo(s2.getFname());
        }

        return Integer.compare(s1.getId(), s2.getId());
    }
}

public class JavaSort {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(36, "Mixi", 3.6));
        studentList.add(new Student(67, "Jack", 1.8));
        studentList.add(new Student(18, "Rose", 3.75));
        studentList.add(new Student(10, "Son", 3.67));
        studentList.add(new Student(11, "Soopi", 1.8));

        Collections.sort(studentList, new StudentComparator());

        System.out.println("Danh sách sinh viên sau khi sắp xếp:");
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
