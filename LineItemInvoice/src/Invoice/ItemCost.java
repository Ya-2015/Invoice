package Invoice;

public class ItemCost {
	private double tax = 0;
	private double subTotal = 0;
	private double grandTotal = 0;
	private double taxRate = 0.1;
	private LineItem lineItem;
	
	public ItemCost(int qty, String des, double price, int num, boolean isTaxable){
		lineItem = new LineItem(qty, des, price, num, isTaxable);
		
		calculateSubTotal();
	}
	
	public LineItem getLineItemInstance(){
		return lineItem;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	
	public double getTaxAmount(){
		tax = 0;
		if(lineItem.isTaxable()){
			tax =  subTotal * taxRate;
		}
		
		return tax;
	}
	
	public double getTaxableSub(){
		
		if (lineItem.isTaxable()){
			return subTotal;
		}else{
			return 0;
		}
		
		
	}
	
	public double getUntaxableSub(){
		if (!lineItem.isTaxable()){
			return subTotal;
		}else{
			return 0;
		}
	}
	
	public double getSubtoatl(){
		return subTotal;
	}
	
	private double calculateSubTotal(){
		subTotal = 0;
		
		double unitPrice = lineItem.getUnitPrice();
		double qty = lineItem.getQty();
		
		subTotal = unitPrice * qty;
		
		return subTotal;
	}
	
	public double getGrandTotal(){
		grandTotal = subTotal + tax;
		return grandTotal;
	}
}
