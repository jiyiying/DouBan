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
	private Double score;
	private Boolean wantToWatch;
	private String comment;
	private String tag;
	private Integer likeCount;
	private Date date;
	private Boolean visibility;
}
