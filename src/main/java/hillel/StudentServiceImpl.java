package hillel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentServiceImpl implements StudentService {

    private SessionFactory sessionFactory;

    StudentServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Student add(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }

}
