package jdbcStudent;

public class Student {
	
	private int sno;  
	private String sname;  //이름
	private String snum;  //학번
	private String sbirth;  //생년월일
	private String sphone;  //전화번호
	private String saddr;  //주소
	private String regdate;  //등록일
	
	public Student() {}
	
	//학생 등록
	public Student(String sname, String snum, String sbirth, String sphone,String saddr) {
		this.sname = sname;
		this.snum = snum;
		this.sbirth = sbirth;
		this.sphone = sphone;
		this.saddr = saddr;
	}
	
	//학생 리스트
	public Student(int sno, String sname, String snum) {
		this.sno = sno;
		this.sname = sname;
		this.snum = snum;
	}
	
	//내정보 보기
	public Student(int sno, String sname, String snum, String sbirth, String sphone, String saddr, String regdate) {
		this(snum, sphone, saddr);
		this.sno = sno;
		this.sname = sname;
		this.sbirth = sbirth;
		this.regdate = regdate;
	}
	
	//내정보 수정
	public Student(String snum, String sphone, String saddr) {
		this.snum = snum;
		this.sphone = sphone;
		this.saddr = saddr;
	}
	
	// 출력
	@Override
	public String toString() {
		return sno+". "+sname+"("+snum+")"+" | 생년월일:"+sbirth+" | 전화번호:"+sphone
				+" | 주소:"+saddr+" | 둥록날짜:"+regdate;
	}
	
	public void print() {

		System.out.println("|"+" "+sno+". "+snum+"("+sname+") |");

	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getSbirth() {
		return sbirth;
	}

	public void setSbirth(String sbirth) {
		this.sbirth = sbirth;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getSaddr() {
		return saddr;
	}

	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
