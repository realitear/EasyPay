/*
Class Name: GasBill
 */
package easypay;

public class GasBill {

    private int paymentPeriod;
    private double usageCharge;
    private double openBalance;
    private double closingBalance;
    private double basicChargeRate;
    private double extraChargeRate;
    private double serviceCharge;
    private double gasUsage;
    private int billType;
    private final String type;
    private String billTypeName;
    private double billTotal;
    private double paidAmount;

    public GasBill() {
        this.type = "Gas";
        openBalance = 0;
        closingBalance = 0;
        billTotal = 0;
        gasUsage = 0;
    }

    public void setPeriod(int inPaymentPeriod) {
        paymentPeriod = inPaymentPeriod;
    }

    public void setUsage(double kJ) {
        gasUsage = kJ;
    }

    public boolean setType(int type) {

        switch (type) {
            case 1:
                this.billType = type;
                this.billTypeName = "Commercial";
                this.basicChargeRate = 1.083;
                return false;
            case 2:
                this.billType = type;
                this.billTypeName = "Residential";
                this.basicChargeRate = 1.021;
                this.extraChargeRate = 1.037;
                return false;
            default:
                return true;
        }
    }

    public void calcServiceCharge() {
        serviceCharge = paymentPeriod * 0.42;
    }

    public void calcUsageCharge() {
        if (this.billType == 1) {
            this.usageCharge = this.gasUsage * this.basicChargeRate;
        } else {
            if (this.gasUsage > 500) {
                this.usageCharge = this.basicChargeRate * 500 + (this.gasUsage - 500) * this.extraChargeRate;
            } else {
                this.usageCharge = this.gasUsage * this.basicChargeRate;
            }
        }

    }

    public void calcBillTotal() {
        calcServiceCharge();
        calcUsageCharge();
        this.billTotal = this.usageCharge + this.serviceCharge;
        this.closingBalance = this.openBalance + this.billTotal;
    }

    public void makePayment(double inPayment) {
        paidAmount = inPayment;
    }

    public double getAmountDue() {
        return getBillTotal() - paidAmount;
    }

    public String getType() {
        return type;
    }

    public int getPeriod() {
        return paymentPeriod;
    }

    public double getUsage() {
        return gasUsage;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public double getUsageCharge() {
        return usageCharge;
    }

    public double getBillTotal() {
        return billTotal;
    }

    public double getBalance() {
        return closingBalance;
    }
    
    public void getDetails(){
        
        
    }

}
