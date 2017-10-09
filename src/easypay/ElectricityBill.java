package easypay;

/*
Class Name: ElectricityBill
 */
public class ElectricityBill {

    private int billDay;
    private int kwh;
    private double paidAmount;
    private String region;
    private final String type;

    public ElectricityBill(String inRegion, int inBillDay, int inKwh) {
        this.type = "Electricity";
        region = inRegion;
        billDay = inBillDay;
        kwh = inKwh;
        paidAmount = 0.0;
        // constructor
    }

    public double calcServiceCharge() {
        return billDay * 0.59;
    }

    public double calcUsageCharge() {
        double basicCharge = 0;
        double extraCharge = 0;

        switch (region) {
            case "1":
                if (kwh > 380) {
                    basicCharge = 380 * 0.69;
                    extraCharge = (kwh - 380) * 0.59;
                } else {
                    basicCharge = kwh * 0.69;
                }
                break;
            case "2":
                if (kwh > 450) {
                    basicCharge = 450 * 0.65;
                    extraCharge = (kwh - 450) * 0.6;
                } else {
                    basicCharge = kwh * 0.65;
                }
                break;
            case "3":
                if (kwh > 1000) {
                    basicCharge = 1000 * 0.76;
                    extraCharge = (kwh - 1000) * 0.52;
                } else {
                    basicCharge = kwh * 0.76;
                }
                break;
            default:
                basicCharge = 0;
                extraCharge = 0;
                break;
        }
        return basicCharge + extraCharge;
    }

    public double getBillTotal() {
        return calcServiceCharge() + calcUsageCharge();
    }

    public double getAmountDue() {
        return getBillTotal() - paidAmount;

    }

    public void makePayment(double inPayment) {
        paidAmount = paidAmount + inPayment;
    }

    public String getType() {
        return type;
    }

    public void getDetails() {
        System.out.println("Here is your Electricity Bill information: ");
        System.out.println("region: " + region + ", Bill Days: " + billDay + ", Electricity usage: " + kwh + ". ");
        System.out.println("Service charge: " + calcServiceCharge());
        System.out.println("Usage charge: " + calcUsageCharge());
        System.out.println("Bill total: " + getBillTotal());
        System.out.println("Paid amount: " + paidAmount);
        System.out.println("Amount due: " + getAmountDue());
    }
}
