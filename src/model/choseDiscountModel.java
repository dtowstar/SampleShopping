package model;
import java.util.*;
public class choseDiscountModel {
	private  String dateNowStr;
	private  int lastYearCost;
	private  ArrayList<cart> cartlist;
	public choseDiscountModel(String dateNowStr,int lastYearCost,ArrayList<cart> cartlist){
		this.dateNowStr = dateNowStr;
		this.lastYearCost = lastYearCost;
		this.cartlist = cartlist;
	}
	public String getDateNowStr() {
		return dateNowStr;
	}
	public void setDateNowStr(String dateNowStr) {
		this.dateNowStr = dateNowStr;
	}
	public int getLastYearCost() {
		return lastYearCost;
	}
	public void setLastYearCost(int lastYearCost) {
		this.lastYearCost = lastYearCost;
	}
	public ArrayList<cart> getCartlist() {
		return cartlist;
	}
	public void setCartlist(ArrayList<cart> cartlist) {
		this.cartlist = cartlist;
	}
}
