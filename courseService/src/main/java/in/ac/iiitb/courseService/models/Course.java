package in.ac.iiitb.courseService.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
	@Column(name = "courseId", unique = true, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;

	@Id
	@Column(name = "courseCode", unique = true, length = 20, nullable = false)
	private String courseCode;

	@Column(name = "courseName", length = 100, nullable = false)
	private String courseName;
}