package Controller.dao;

public class Accont {
	private String user;
	private String pass;
	private String id;
	private String image;
	private String fullname;
	public Accont() {
		}
	public Accont(String _user, String _pass) {
		user=_user;
		pass=_pass;
	}
	public Accont(String _id,String _user, String _pass,String _image,String _fullname) {
		user=_user;
		pass=_pass;
		id=_id;
		image=_image;
		fullname=_fullname;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String _user) {
		user=_user;
	}
	public String getPass() {
		return user;
	}
	public void setPass(String _pass) {
		pass=_pass;
	}

}
