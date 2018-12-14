package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor	//인자없는 생성자
@ToString

public class Transcript {
	
	private int number;
	
	@NotEmpty
	private String subject;
	
	
	private int year;
	
	
	private int semester;
	
	@NotEmpty
	private String code;
	
	
	private int score;
	
	@NotEmpty
	private String type;
	
	private String grade;
	
	private int sum;
 	
}
