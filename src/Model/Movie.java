package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer movieID;
	private String movieName;
	private String moviePoster;
	private String country;
	private String language;
	private Date releaseDate;
	private Integer length;
	private String profile;
	
	private ArrayList<Integer> actors;//电影人物关系表
}
