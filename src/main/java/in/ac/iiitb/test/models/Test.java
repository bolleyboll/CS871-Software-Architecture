package in.ac.iiitb.test.models;

import java.util.Date;

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
@Table(name = "tests")
public class Test {

	@Id
	@Column(name = "testId", unique = true, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer testId;

	@Column(name = "name", unique = true, length = 200, nullable = false)
	private String name;

	@Column(name = "startDate", nullable = false)
	// @Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "duration", nullable = false)
	private Integer duration;

	@ManyToOne
	@JoinColumn
	private Subject courseCode;
}