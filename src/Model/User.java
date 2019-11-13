package Model;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer userID;
	private String userName;
	private String password;
	private String phoneNumber;
	private String profilePhoto;
	private String email;
	private String wechat;
	private String qq;
	private String weibo;
}
