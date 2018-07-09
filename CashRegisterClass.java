
import java.text.DecimalFormat;

/**
 *
 * @author Ngan
 */
public class CashRegisterClass {
    
    //Data Members
    private double totalAmt; //Pre tax & tip
    private double finalTotal; //After adding both tip & tax
    private double taxAmt;
    private final double TAXPERCENT = .008;
    private double tipsAmt;
    private double customerPay;
    private double changeAmt;
    
    
    //No-Arg Constructor 
    public CashRegisterClass()
    {
        
    }
    
    //To round the results to two decimal places
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    //add method sums up the total amount of money of the items that customer 
    //had ordered
    public double add(double itemValue)
    {
        totalAmt = totalAmt + itemValue;
        return totalAmt;
    }
    
    //getTotalAmount shows the total amount before tips & tax on output screen
    public void getTotalAmt()
    {
        System.out.println("Total:  $" + decimalFormat.format(this.totalAmt));
    }
    
    //CalcTaxAmt method accepts the total amount of money of what customer had
    //ordered
    public double calcTaxAmt(double totalAmt)
    {
        taxAmt = totalAmt * TAXPERCENT;
        System.out.println("Tax amount: $" + decimalFormat.format(taxAmt));
        return taxAmt;
    }
   
    /** CalcTipAmt method accepts the total $ and the tip % that customer choose 
     *  to tip.
     * 
     */
    public double calcTipAmt(double total, double tipPercent)
    {
        //Converting tipPercent into decimals for tip total calculation
        tipPercent = (tipPercent/100);
        if (tipPercent == 0.0)
                {
                    this.tipsAmt = 0.00;
                }
        else if (tipPercent == .1)
                {
                    this.tipsAmt = total * tipPercent;
                }
        else if (tipPercent == .15)
                {
                    this.tipsAmt = total * tipPercent;
                }
        System.out.println("Tips total: $" + decimalFormat.format(this.tipsAmt));
        return this.tipsAmt;
    }
    
    /*CalcFinalTotal method accepts total amount of money of items that customer
    * had order, tips total, and tax total. Then, it will add up and display
    * the final total $ that customer needs to pay.
    */
    
    public double calcFinalTotal(double totalAmt, double tipAmt, double taxAmt)
    {
        this.finalTotal = totalAmt + tipAmt + taxAmt;
        System.out.println("Final Total: $" + decimalFormat.format(this.finalTotal));
        return this.finalTotal;
    }
    
    public double calcChange(double customerPay)
    {
        this.changeAmt = customerPay - finalTotal;
        System.out.println("Change: $" + decimalFormat.format(this.changeAmt));
        return this.changeAmt;
    }
    
    
}
