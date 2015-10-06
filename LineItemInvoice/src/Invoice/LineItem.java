package Invoice;

public class LineItem {
	private int qty = 0;
	private String description = "";
	private double unitPrice = 0;
	private int invoiceNum = 0;
	private boolean isTaxable = false;
	
	public LineItem(int qty, String des, double price, int num, boolean isTaxable){
		this.setQty(qty);
		this.setDescription(des);
		this.setUnitPrice(price);
		this.setInvoiceNum(num);
		this.setTaxable(isTaxable);
	}
	

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public int getInvoiceNum() {
		return invoiceNum;
	}


	public void setInvoiceNum(int invoiceNum) {
		this.invoiceNum = invoiceNum;
	}


	public boolean isTaxable() {
		return isTaxable;
	}


	public void setTaxable(boolean isTaxable) {
		this.isTaxable = isTaxable;
	}
	
}
