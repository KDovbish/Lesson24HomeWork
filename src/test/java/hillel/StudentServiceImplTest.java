package hillel;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    @Test
    void add() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        StudentService studentService = new StudentServiceImpl(sessionFactory);
        Student student = studentService.add(new Student(1, "Андреев А.А.", 5, 2005));
        System.out.println(student);
        HibernateUtil.shutdown();
    }

    @Test
    void getByName() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        StudentService studentService = new StudentServiceImpl(sessionFactory);
        List<Student> studentList = studentService.getByName("Андреев");
        System.out.println(studentList);
        HibernateUtil.shutdown();
    }

    @Test
    void getByIds() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        StudentService studentService = new StudentServiceImpl(sessionFactory);
        List<Student> studentList = studentService.getByIds(List.of(1,3));
        System.out.println(studentList);
        HibernateUtil.shutdown();
    }
}