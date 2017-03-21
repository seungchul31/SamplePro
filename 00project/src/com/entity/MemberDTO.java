package com.entity;

public class MemberDTO {
	private String userid;
	private String passwd;
	private String nickname;
	private String year;
	private String month;
	private String day;
	private String gender;
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(String userid, String passwd, String nickname, String year, String month, String day,
			String gender) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.nickname = nickname;
		this.year = year;
		this.month = month;
		this.day = day;
		this.gender = gender;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", nickname=" + nickname + ", year=" + year
				+ ", month=" + month + ", day=" + day + ", gender=" + gender + "]";
	}
	
	
}
