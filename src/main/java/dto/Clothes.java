package dto;

public class Clothes {
	private String clcode;
	private String cname;
	private String ctype;
	private String cprice;
	private String camount;
	private String csize;
	private String cstate;
	private String clinfo;
	private String clphoto;
	public String getClphoto() {
		return clphoto;
	}
	public void setClphoto(String clphoto) {
		this.clphoto = clphoto;
	}
	public String getClcode() {
		return clcode;
	}
	public void setClcode(String clcode) {
		this.clcode = clcode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getCprice() {
		return cprice;
	}
	public void setCprice(String cprice) {
		this.cprice = cprice;
	}
	public String getCamount() {
		return camount;
	}
	public void setCamount(String camount) {
		this.camount = camount;
	}
	public String getCsize() {
		return csize;
	}
	public void setCsize(String csize) {
		this.csize = csize;
	}
	public String getCstate() {
		return cstate;
	}
	public void setCstate(String cstate) {
		this.cstate = cstate;
	}
	public String getClinfo() {
		return clinfo;
	}
	public void setClinfo(String clinfo) {
		this.clinfo = clinfo;
	}
	@Override
	public String toString() {
		return "Clothes [clcode=" + clcode + ", cname=" + cname + ", ctype=" + ctype + ", cprice=" + cprice
				+ ", camount=" + camount + ", csize=" + csize + ", cstate=" + cstate + ", clinfo=" + clinfo
				+ ", clphoto=" + clphoto + "]";
	}
	
}
