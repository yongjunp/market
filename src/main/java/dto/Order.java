package dto;

public class Order {

	private String odcode;
	private String clcode;
	private String mid;
	private String oddate;
	private String amount;
	private String price;
	private String csize;
	private String odaddress;
	private String odstate;
	public String getOdcode() {
		return odcode;
	}
	public void setOdcode(String odcode) {
		this.odcode = odcode;
	}
	@Override
	public String toString() {
		return "Order [odcode=" + odcode + ", clcode=" + clcode + ", mid=" + mid + ", oddate=" + oddate + ", amount="
				+ amount + ", price=" + price + ", csize=" + csize + ", odaddress=" + odaddress + ", odstate=" + odstate
				+ "]";
	}
	public String getClcode() {
		return clcode;
	}
	public void setClcode(String clcode) {
		this.clcode = clcode;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getOddate() {
		return oddate;
	}
	public void setOddate(String oddate) {
		this.oddate = oddate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCsize() {
		return csize;
	}
	public void setCsize(String csize) {
		this.csize = csize;
	}
	public String getOdaddress() {
		return odaddress;
	}
	public void setOdaddress(String odaddress) {
		this.odaddress = odaddress;
	}
	public String getOdstate() {
		return odstate;
	}
	public void setOdstate(String odstate) {
		this.odstate = odstate;
	}
}
