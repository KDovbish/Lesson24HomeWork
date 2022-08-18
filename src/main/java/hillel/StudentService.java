package hillel;

import java.util.List;

public interface StudentService {
    Student add(Student entry);
    List<Student> getByName(String name);
    List<Student> getByIds(List<Integer> id);
}
