package logic;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1990501617629593245L;

    private Long id;
    private String name;
    private Long age;
    private Role role;

    public Student() {
        name = null;
    }

    public Student(Student s) {
        name = s.getName();
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "age")
    public Long getAge() {
        return age;
    }

    public void setId(Long i) {
        id = i;
    }

    public void setName(String s) {
        name = s;
    }

    public void setAge(Long l) {
        age = l;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
