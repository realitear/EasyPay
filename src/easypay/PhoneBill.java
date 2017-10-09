/*
Class Name: PhoneBill
 */
package easypay;

public class PhoneBill {

    private int numberOfLocalCalls;
    private int numberOfLongDistCalls;
    private int minuteOfLongDistCalls;
    private int numberOfMobileCalls;
    private int minuteOfMobileCalls;
    private int numberOfNetworkFeatures;
    private double paidAmount;
    private final String type;

    public PhoneBill() {
        this.type = "Phone";
        paidAmount = 0.0;
        resetAllCalls();
    }

    public final void resetAllCalls() {
        numberOfLocalCalls = 0;
        numberOfLongDistCalls = 0;
        minuteOfLongDistCalls = 0;
        numberOfMobileCalls = 0;
        minuteOfMobileCalls = 0;
        numberOfNetworkFeatures = 0;
    }

    public void addLocalCalls(int inNumberOfLocalCalls) {
        numberOfLocalCalls = numberOfLocalCalls + inNumberOfLocalCalls;
    }

    public void addLongDistCallUsage(double inMinuteUsage) {
        numberOfLongDistCalls++;

        if (inMinuteUsage > 5) {
            minuteOfLongDistCalls = minuteOfLongDistCalls + 5;
        } else {
            minuteOfLongDistCalls = minuteOfLongDistCalls + (int) inMinuteUsage;
        }
    }

    public void addMobileCallUsage(double inMiniteUsage) {
        numberOfMobileCalls++;
        minuteOfMobileCalls = minuteOfMobileCalls + (int) inMiniteUsage;
    }

    public void addNetworkFeatures(int inNetworkFeatures) {
        numberOfNetworkFeatures = numberOfNetworkFeatures + inNetworkFeatures;
    }

    public double getBillTotal() {
        double totalBill;
        totalBill = 0;

        totalBill = totalBill + numberOfLocalCalls * 0.25;
        totalBill = totalBill + numberOfLongDistCalls * 0.17 + minuteOfLongDistCalls * 0.30;
        totalBill = totalBill + numberOfMobileCalls * 0.26 + minuteOfMobileCalls + 0.43;
        totalBill = totalBill + numberOfNetworkFeatures * 0.15;
        return totalBill;
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
        System.out.println("Here is your Phone Bill information: ");
        System.out.println("Total local calls: " + numberOfLocalCalls);
        System.out.println("Total long distance calls: " + numberOfLongDistCalls + ", total usage is : " + minuteOfLongDistCalls);
        System.out.println("Total mobile calls : " + numberOfMobileCalls + ", total usage is : " + minuteOfMobileCalls);
        System.out.println("Total usage of network features: " + numberOfNetworkFeatures);
    }

}
