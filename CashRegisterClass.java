import java.text.DecimalFormat;

/**
 * CashRegisterClass contains methods that:
 *                                          1. add up item's price
 *                                          2. calculate tax amount
 *                                          3. Calculate tips amount (0%, 10%, 15%)
 *                                          4. Calculate final total
 *                                          5. Calculate the change when needed
 * @author Aurora Ngan Hoang
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
    public void add(double itemValue)
    {
        totalAmt = totalAmt + itemValue;
    }
    
    //CalcTaxAmt method accepts the total amount of money of what customer had
    //ordered
    public void calcTaxAmt(double totalAmt)
    {
        taxAmt = totalAmt * TAXPERCENT;
    }
   
    /** CalcTipAmt method accepts the total $ and the tip % that customer choose 
     *  to tip.
     * 
     */
    public void calcTipAmt(double total, double tipPercent)
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
    }
    
    /*CalcFinalTotal method accepts total amount of money of items that customer
    * had order, tips total, and tax total. Then, it will add up and display
    * the final total $ that customer needs to pay.
    */
    public void calcFinalTotal(double totalAmt, double tipAmt, double taxAmt)
    {
        this.finalTotal = totalAmt + tipAmt + taxAmt;
    }
    
    /*calcChange method accepts the amount of money that customer gives in order 
    * to pay for their orders. Then, it will calculate the change if necessary.
    */
    public void calcChange(double customerPay)
    {
        /*Storing the formatted finalTotal amount into totalAmt as String
         * in order to convert it to double data type
        */
        String totalAmt = decimalFormat.format(finalTotal);
        
        //Converting the string into double data type 
        //& store it into this.finalTotal
        this.finalTotal = Double.parseDouble(totalAmt);
        
        //if-else statement to decide whether change is necessary
        if(customerPay == this.finalTotal)
        {
            System.out.println("No Change");
        }
        else if (customerPay > finalTotal)
        {
           this.changeAmt = customerPay - finalTotal;
           System.out.println("Change: $" + decimalFormat.format(this.changeAmt)); 
        }
        else if(customerPay < finalTotal)
        {
            System.out.println("Insufficient payment: Your final total is $" 
                            + decimalFormat.format(finalTotal) + ".");
        }
    }
    
    //getResults display all the calculations needed for the transactions
    public void getResults()
    {
        System.out.println("Total (without tax): $" + decimalFormat.format(this.totalAmt));
        System.out.println("Tax amount: $" + decimalFormat.format(taxAmt));
        System.out.println("Tips total: $" + decimalFormat.format(this.tipsAmt));
        System.out.println("Final Total: $" + decimalFormat.format(this.finalTotal));
    }
    
    
}
