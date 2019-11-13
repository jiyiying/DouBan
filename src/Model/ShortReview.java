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
public class ShortReview implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer userID;
	private Integer movieID;
	private double score;
	private boolean wantToWatch;
	private String comment;
	private String tag;
	private Integer like;
	private Date date;
	private boolean visibility;
}
