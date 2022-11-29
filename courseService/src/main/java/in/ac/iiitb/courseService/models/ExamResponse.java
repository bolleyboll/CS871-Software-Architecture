package in.ac.iiitb.courseService.models;

import javax.persistence.Column;
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
@Table(name = "exam_responses")
public class ExamResponse {
	@Id
	@Column(name = "examId", unique = true, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer examResponseId;

	@Column(name = "name", unique = false, length = 200, nullable = false)
	private String student;

	@Column(name = "response", unique = false, length = 2000, nullable = true)
	private String response;

	@ManyToOne
	@JoinColumn
	private Exam exam;
}
