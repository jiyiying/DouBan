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
public class Awards implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer personID;
	private Date date;
	private String organization;
	private String awardType;
	private String movieID;
}
