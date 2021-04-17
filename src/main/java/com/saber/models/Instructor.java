package com.saber.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "instructor")
@NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
@NamedQuery(name = "Instructor.findById", query = "SELECT i FROM Instructor i where i.id=:id")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "instructor_detail_id", referencedColumnName = "id")
    private InstructorDetail instructorDetail;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "instructor",
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,
            CascadeType.REFRESH,CascadeType.REFRESH})
    private List<Course> courses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setInstructor(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instructor)) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getInstructorDetail(), that.getInstructorDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getInstructorDetail());
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                ", courses=" + courses +
                '}';
    }
}
