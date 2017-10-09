/*
Class Name: CustomerAccount;

 */
package easypay;

public class CustomerAccount {

    private String custName;
    private int custNumber;
    private int custPhoneNumber;
    private String custPostalAddress;
    private Bill bills;

    CustomerAccount(String name, int custNum, int phoneNum, String postalAddr) {
        setCustomerInfo(name, custNum, phoneNum, postalAddr);
    }

    public void setCustomerInfo(String inName, int inCustNum, int inPhoneNum, String inPostalAddr) {
        this.custName = inName;
        this.custNumber = inCustNum;
        this.custPhoneNumber = inPhoneNum;
        this.custPostalAddress = inPostalAddr;
    }

    public void addBill() {
        GasBill temp = new GasBill();
        Bill bills = new Bill("Gas", temp);

    }

    public String getCustName() {
        return this.custName;
    }

    public int getCustNum() {
        return this.custNumber;
    }

    public int getCustPhoneNum() {
        return this.custPhoneNumber;
    }

    public String getCustAddress() {
        return this.custPostalAddress;
    }

    public void removePaidBills() {

    }

    public void getBill() {
        return this.bills;
    }

    public void showSummary() {

    }
}
