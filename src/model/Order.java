package model;
import java.sql.Date;
public class Order {
	private int Order_ID;
	private int User_ID;
	private int PD_ID;
	private int Order_Quantity;
	private String Order_Payment;
	private String Order_Status;
	private java.sql.Date d2;
	public int getOrder_ID() {
		return Order_ID;
	}
	public void setOrder_ID(int order_ID) {
		Order_ID = order_ID;
	}
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}
	public int getPD_ID() {
		return PD_ID;
	}
	public void setPD_ID(int pD_ID) {
		PD_ID = pD_ID;
	}
	public int getOrder_Quantity() {
		return Order_Quantity;
	}
	public void setOrder_Quantity(int order_Quantity) {
		Order_Quantity = order_Quantity;
	}
	public String getOrder_Payment() {
		return Order_Payment;
	}
	public void setOrder_Payment(String order_Payment) {
		Order_Payment = order_Payment;
	}
	public String getOrder_Status() {
		return Order_Status;
	}
	public void setOrder_Status(String order_Status) {
		Order_Status = order_Status;
	}
	public java.sql.Date getD2() {
		return d2;
	}
	public void setD2(java.sql.Date d2) {
		this.d2 = d2;
	}
	
}
