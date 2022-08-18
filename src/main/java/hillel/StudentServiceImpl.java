package hillel;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private SessionFactory sessionFactory;

    StudentServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Добавить новую запись Студента
     * @param student Объект типа Student;
     * @return При успешном добавлении записи в базу, объект типа Student с заполненным id
     */
    public Student add(Student student) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            session.close();
            return student;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Выбрать всех студентов по заданному имени
     * @param name
     * @return Список(заполненный или пустой, при отсутствии совпадений)
     */
    public List<Student> getByName(String name) {

        List<Student> studentList = new ArrayList<>();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.like("fio", "%" + name + "%"));
        studentList = criteria.list();

        session.close();
        return studentList;
    }

    public List<Student> getByIds(List<Integer> ids) {
        List<Student> studentList = new ArrayList<>();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.in("id", ids));
        studentList = criteria.list();

        session.close();
        return studentList;
    }

}
