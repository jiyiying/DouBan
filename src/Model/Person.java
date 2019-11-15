package Model;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private integer personID;
	private String name;
	private String photo;
	private String gender;
	private Date birthday;
	private String birthplace;
	private String profile;
	
	
}
