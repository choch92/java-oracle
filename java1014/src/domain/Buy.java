package domain;

import java.sql.Date;

public class Buy {
	private int buycode;
	private String itemname;
	private String customerid;
	private int count;
	private Date buydate;
	public int getBuycode() {
		return buycode;
	}
	public void setBuycode(int buycode) {
		this.buycode = buycode;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getBuydate() {
		return buydate;
	}
	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}
	@Override
	public String toString() {
		return "Buy [buycode=" + buycode + ", itemname=" + itemname + ", customerid=" + customerid + ", count=" + count
				+ ", buydate=" + buydate + "]";
	}
}
