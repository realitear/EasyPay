/*
	Class Name : Bill
	Date       :
	Description: As different bills come from different objects.
                     It is difficult for the customer to hold an array of bill ( an array requires same object )
                     A Bill class is developed. It can have electricity bill, gas bill, water bill or phone bill.
                     The type is to identify it.
 */
package easypay;

public class Bill {

    String type;

    // Electricity object
    ElectricityBill myElectricityBill;

    // Gas object
    GasBill myGasBill;

    // Phone object
    PhoneBill myPhoneBill;

    // Water object
    WaterBill myWaterBill;

    public Bill(String inputType, ElectricityBill inElectricity) {
        type = inputType;
        myElectricityBill = inElectricity;
    }

    public Bill(String inputType, GasBill inGas) {
        type = inputType;
        myGasBill = inGas;
    }

    public Bill(String inputType, PhoneBill inPhone) {
        type = inputType;
        myPhoneBill = inPhone;
    }

    public Bill(String inputType, WaterBill inWater) {
        type = inputType;
        myWaterBill = inWater;
    }

}
