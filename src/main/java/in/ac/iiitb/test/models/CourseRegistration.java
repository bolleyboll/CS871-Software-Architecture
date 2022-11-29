package in.ac.iiitb.test.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "course_registrations")
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @JoinColumn(name = "username")
    String student;

    @ManyToOne
    @JoinColumn(name = "courseCode")
    Course course;
}