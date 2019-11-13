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
public class SubDiscuss implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	private Integer discussID;
	private Integer parentDiscussID;
	private String discussType;
	private Integer userID;
	private String comment;
	private Date date;
	private Integer likeCount;
	
}
