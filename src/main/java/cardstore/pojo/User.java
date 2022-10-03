package cardstore.pojo;

import java.time.LocalDateTime;

public class User {
	private Integer u_id;
	private String u_account;
	private String u_password;
	private String u_name;
	private String u_nickname;
	private String u_email;
	private LocalDateTime u_date;
	private Integer u_status;
	
	public User() {
	}

	public User(Integer u_id, String u_account, String u_password, String u_name, String u_nickname, String u_email,
			LocalDateTime u_date, Integer u_status) {
		this.u_id = u_id;
		this.u_account = u_account;
		this.u_password = u_password;
		this.u_name = u_name;
		this.u_nickname = u_nickname;
		this.u_email = u_email;
		this.u_date = u_date;
		this.u_status = u_status;
	}

	public User(String u_account, String u_password, String u_name, String u_nickname, String u_email,
			LocalDateTime u_date, Integer u_status) {
		this.u_account = u_account;
		this.u_password = u_password;
		this.u_name = u_name;
		this.u_nickname = u_nickname;
		this.u_email = u_email;
		this.u_date = u_date;
		this.u_status = u_status;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public String getU_account() {
		return u_account;
	}

	public void setU_account(String u_account) {
		this.u_account = u_account;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_nickname() {
		return u_nickname;
	}

	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public LocalDateTime getU_date() {
		return u_date;
	}

	public void setU_date(LocalDateTime u_date) {
		this.u_date = u_date;
	}

	public Integer getU_status() {
		return u_status;
	}

	public void setU_status(Integer u_status) {
		this.u_status = u_status;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_account=" + u_account + ", u_password=" + u_password + ", u_name=" + u_name
				+ ", u_nickname=" + u_nickname + ", u_email=" + u_email + ", u_date=" + u_date + ", u_status="
				+ u_status + "]";
	}

	
	
}
