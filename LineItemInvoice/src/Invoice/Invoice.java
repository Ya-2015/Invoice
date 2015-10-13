package Invoice;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Invoice {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Customer Name: ?");
		String name = scan.next();
		System.out.print("Invoice Number: ?");
		int invoiceNum = scan.nextInt();
		System.out.print("Purchase Date: ?");
		String date = scan.next();
		
		System.out.print("\nPlease tell purchase details\n");
		System.out.print("End with Qty == 0 ");
		ArrayList<ItemCost> items = new ArrayList<ItemCost>();
		
		int qty = -1;
		String des = "";
		double price = 0;
		boolean isTaxable = false;
		
		System.out.print("\n\nQuantity: ?");
		qty = scan.nextInt();
		
		while(qty != 0){
			System.out.print("Item Description: ?");
			des = scan.next();
			System.out.print("Unit Price: ?");
			price = scan.nextDouble();
			System.out.print("Is Item Taxable: ? yes or no");
			if (scan.next().equalsIgnoreCase("yes")){
				isTaxable = true;
			}else{
				isTaxable = false;
			}
			
			items.add(new ItemCost(qty, des, price, invoiceNum, isTaxable));
			
			System.out.print("\nQuantity: ?");
			qty = scan.nextInt();
		}
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		//print invoice
		System.out.println("\n-------------");
		System.out.println("Invoice");
		System.out.println("Customer Name:\t" + name);
		System.out.println("Invoice Number:\t" + invoiceNum);
		System.out.println("Purchase Date:\t" + date);
		System.out.println("\nPurchase Item\t\t" + "Qty\t" + "Unit Price\t" + "Cost");
		double tax = 0;
		double taxSubTotal = 0;
		double unTaxSubTotal = 0;
		double grandTotal = 0;
		String item = "";
		for (int i = 0; i < items.size(); i++){
			item = items.get(i).getLineItemInstance().getDescription();
			if(!items.get(i).getLineItemInstance().isTaxable()){
				item += "*";
			}
			
			System.out.printf("%s\t\t\t%d\t$%.2f\t\t$%.2f\n", item, items.get(i).getLineItemInstance().getQty(),items.get(i).getLineItemInstance().getUnitPrice(),items.get(i).getSubtoatl());
			tax += items.get(i).getTaxAmount();
			taxSubTotal += items.get(i).getTaxableSub();
			unTaxSubTotal += items.get(i).getUntaxableSub();
			grandTotal += items.get(i).getGrandTotal();
		}
		System.out.println();
		System.out.printf("Taxable Subtotal:\t%s\n", currency.format(taxSubTotal));
		System.out.printf("UnTaxable Subtotal:\t%s\n", currency.format(unTaxSubTotal));
		System.out.printf("Tax:\t\t\t%s\n", currency.format(tax));
		System.out.printf("Grand Total:\t\t%s\n", currency.format(grandTotal));
	
		System.out.println("\n* is tax exempted");
		scan.close();
	}
}
