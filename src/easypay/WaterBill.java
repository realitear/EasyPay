/*
Class Name: Water Bill;
 */
package easypay;

public class WaterBill {

    private int paymentPeriod;
    private double waterUsage;
    private double usageCharge;
    private double exceededUsage;

    private int billType;
    private String billTypeName;
    private final String type;
    private final double openBalance;
    private double closingBalance;
    private double billTotal;
    private double paidAmount;
    private double chargeRate;
    private int thresholds;

    WaterBill() {
        this.type = "Water";
        openBalance = 0;
        closingBalance = 0;
        billTotal = 0;
        waterUsage = 0;
    }

    public void setPeriod(int inpaymentPeriod) {
        paymentPeriod = inpaymentPeriod;
    }

    public void setUsage(double kL) {
        waterUsage = kL;
    }

    public boolean setType(int type) {
        switch (type) {
            case 1:
                this.billType = type;
                this.billTypeName = "Commercial";
                this.chargeRate = 0.70;
                return false;
            case 2:
                this.billType = type;
                this.billTypeName = "Commercial in a period of drought";
                this.thresholds = 200;
                this.chargeRate = 0.7;
                return false;
            case 3:
                this.billType = type;
                this.billTypeName = "Residential";
                this.chargeRate = 0.55;
                return false;
            case 4:
                this.billType = type;
                this.billTypeName = "Residential in a period of drought";
                this.thresholds = 50;
                this.chargeRate = 0.55;
                return false;
            default:
                return true;
        }
    }

    public void calcUsageCharge() {

        if (this.billType == 1) {
            this.usageCharge = this.waterUsage * this.chargeRate;
        } else {
            if (this.billType == 2) {
                this.exceededUsage = this.waterUsage - this.thresholds;
                if (this.waterUsage > this.thresholds) {
                    this.usageCharge = this.waterUsage * this.chargeRate + (this.exceededUsage / 10.0 * 3);
                } else {
                    this.usageCharge = this.waterUsage * this.chargeRate;
                }
            } else {
                if (this.billType == 3) {
                    this.usageCharge = this.waterUsage * this.chargeRate;
                } else {
                    if (this.billType == 4) {
                        this.exceededUsage = this.waterUsage - this.thresholds;
                        if (this.waterUsage > this.thresholds) {
                            this.usageCharge = this.waterUsage * this.chargeRate + (this.exceededUsage / 10.0 * 3);
                        } else {
                            this.usageCharge = this.waterUsage * this.chargeRate;
                        }
                    }
                }
            }
        }
    }

    public void calcBillTotal() {
        calcUsageCharge();
        this.billTotal = this.usageCharge;
        this.closingBalance = this.openBalance + this.billTotal;
    }

    public double getBillTotal() {
        return this.billTotal;
    }

    public void makePayment(double inPayment) {
        paidAmount = paidAmount + inPayment;
    }

    public double getAmountDue() {
        return getBillTotal() - paidAmount;
    }

    public int getPeriod() {
        return paymentPeriod;
    }

    public double getUsage() {
        return waterUsage;
    }

    public double getExceededUsage() {
        return exceededUsage;
    }

    public double getUsageCharge() {
        return usageCharge;
    }

    public String getType() {
        return this.type;
    }

    public double getBalance() {
        return closingBalance;
    }

    public void getDetails() {
        System.out.println("Here is your Water Bill information: ");
        System.out.println("Bill Days: " + paymentPeriod + ", Water usage: " + waterUsage + "kL.");
        System.out.println("This bill is : " + getType() + ", and the charge rate is : $" + this.chargeRate + " per kL");
        if (billType == 2 || billType == 4) {
            System.out.println("This bill is in the period of drought, additional charge will be fined.");
        } else {
            System.out.println("This bill is in a normal period, no additional charge will be fined.");
        }
        if ((this.waterUsage > this.thresholds) && (billType == 2 || billType == 4)) {
            System.out.println("Water usage has exceeded the threshold for " + exceededUsage + "kL.");
        }
        else{
            System.out.println("No exceeded water consumption.");
        }
        System.out.println("Bill total: " + getBillTotal());
        System.out.println("Paid amount: " + paidAmount);
        System.out.println("Amount due: " + getAmountDue());
    }

}
