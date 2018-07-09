/**
 *
 * @author Ngan
 */
public class CashRegisterClass {
    
    //Data Members
    private double totalAmt;
    private double taxAmt;
    private final double TAXPERCENT = .008;
    private double tipsAmt;
    private double customerPay;
    private double changeAmt;
    
    
    //Constructor accepts the total amount of money of what customer had ordered
    public CashRegisterClass(double totalAmt)
    {
        this.totalAmt = totalAmt;
    }
    
    //CalcTaxAmt method accepts the total amount of money of what customer had
    //ordered
    public double CalcTaxAmt(double totalAmt)
    {
        taxAmt = totalAmt * TAXPERCENT;
        System.out.println("Tax amount: $" + taxAmt);
        return taxAmt;
    }
    
    public double CalcTipAmt(double total, double tipPercent)
    {
        if (tipPercent == 0.0)
                {
                    this.tipsAmt = 0.00;
                }
        else if ()
        
        
        
        return 0.0;
    }
    
    
}
