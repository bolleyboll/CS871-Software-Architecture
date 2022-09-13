package in.ac.iiitb.test.models;


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
@Table(name = "subjects")
public class Subject {
	@Column(name = "subjectId", unique = true, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subjectId;

	@Id
	@Column(name = "subjectCode", unique = true, length = 20, nullable = false)
	private String subjectCode;

	@Column(name = "subjectName", length = 100, nullable = false)
	private String subjectName;

	// @OneToMany(mappedBy = "subject")
    // Set<CourseRegistration> registrations;
}