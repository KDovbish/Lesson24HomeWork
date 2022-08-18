package hillel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fio;
    private Integer groupId;
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "GroupId", nullable = false, insertable = false, updatable = false)
    private StudentGroup studentGroup;

    public Student(Integer id, String fio, Integer groupId, Integer year) {
        this.id = id;
        this.fio = fio;
        this.groupId = groupId;
        this.year = year;
    }

}
