package dto;

public class Cadd {

	private String adcode;
	private String mid;
	private String clcode;
	private String amount;
	private String price;
	private String csize;
	public String getAdcode() {
		return adcode;
	}
	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getClcode() {
		return clcode;
	}
	public void setClcode(String clcode) {
		this.clcode = clcode;
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
	@Override
	public String toString() {
		return "Cadd [adcode=" + adcode + ", mid=" + mid + ", clcode=" + clcode + ", amount=" + amount + ", price="
				+ price + ", csize=" + csize + "]";
	}
	
	
}
