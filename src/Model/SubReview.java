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
public class SubReview implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer commentID;
	private String parentType;
	private Integer parentID;
	private Integer userID;
	private Integer movieID;
	private Date commentDate;
	private String comment;
	
	
}
