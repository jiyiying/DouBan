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
public class Discuss implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer topicID;
	private Integer userID;
	private Integer movieID;
	private String topic;
	private String comment;
	private Date date;
	private Integer responseCount;
	
}
