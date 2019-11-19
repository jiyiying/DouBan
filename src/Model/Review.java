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
public class Review implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer reviewID;
	private Integer userID;
	private Integer movieID;
	private Double score;
	private Date date;
	private String title;
	private String comment;
	private Integer likeCount;
	private Integer dislikeCount;
	
}
