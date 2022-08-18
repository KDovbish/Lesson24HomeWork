package hillel;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    @Test
    void add() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        StudentService studentService = new StudentServiceImpl(sessionFactory);
        Student student = studentService.add(new Student(1, "Филимонов2 Ф.Ф.", 1, 2004));
        System.out.println(student);
        HibernateUtil.shutdown();
    }
}