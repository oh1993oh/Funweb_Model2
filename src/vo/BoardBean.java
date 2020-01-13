package vo;

import java.sql.Date;

public class BoardBean {
	
	private int board_num;
	private String board_name;
	private String board_pass;
	private String board_subject;
	private String board_content;
	private String board_file;
	private int board_re_ref;
	private int board_re_lev;
	private int board_re_seq;
	private int board_readcount;
	private Date board_date;
	public int getboard_num() {
		return board_num;
	}
	public void setboard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getboard_name() {
		return board_name;
	}
	public void setboard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getboard_pass() {
		return board_pass;
	}
	public void setboard_pass(String board_pass) {
		this.board_pass = board_pass;
	}
	public String getboard_subject() {
		return board_subject;
	}
	public void setboard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getboard_content() {
		return board_content;
	}
	public void setboard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getboard_file() {
		return board_file;
	}
	public void setboard_file(String board_file) {
		this.board_file = board_file;
	}
	public int getboard_re_ref() {
		return board_re_ref;
	}
	public void setboard_re_ref(int board_re_ref) {
		this.board_re_ref = board_re_ref;
	}
	public int getboard_re_lev() {
		return board_re_lev;
	}
	public void setboard_re_lev(int board_re_lev) {
		this.board_re_lev = board_re_lev;
	}
	public int getboard_re_seq() {
		return board_re_seq;
	}
	public void setboard_re_seq(int board_re_seq) {
		this.board_re_seq = board_re_seq;
	}
	public int getboard_readcount() {
		return board_readcount;
	}
	public void setboard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}
	public Date getboard_date() {
		return board_date;
	}
	public void setboard_date(Date board_date) {
		this.board_date = board_date;
	}
	
	
	
	
	
	
}
