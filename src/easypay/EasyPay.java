package easypay;

import java.io.*;

public class EasyPay {

    public static void main(String[] args) throws Exception {
        //    InputStreamReader input = new InputStreamReader(System.in);
        /*   BufferedReader buffer = new BufferedReader(input);

        ElectricityBill test = new ElectricityBill("1", 30, 500);
        System.out.println(test.getType());
        System.out.println(test.getBillTotal());
        test.makePayment(200);
        System.out.println(test.getAmountDue());
        test.getDetails();

        /*       PhoneBill chris = new PhoneBill();
        System.out.println(chris.getType());
        chris.addLocalCalls(100);
        chris.addLongDistCallUsage(6);
        chris.addMobileCallUsage(100);
        chris.addNetworkFeatures(1);
        System.out.println(chris.getBillTotal());
        chris.makePayment(50);
        System.out.println(chris.getAmountDue());
        chris.getDetails();
        
        GasBill bobo = new GasBill();
        bobo.setUsage(550);
        bobo.setPeriod(30);
        bobo.setType(1);
        bobo.calcBillTotal();
        System.out.println(bobo.getServiceCharge());
        System.out.println(bobo.getUsageCharge());
        System.out.println(bobo.getBillTotal());
        System.out.println(bobo.getType());
         */
        WaterBill coco = new WaterBill();
        coco.setPeriod(30);
        coco.setUsage(250);
        coco.setType(2);
        coco.calcBillTotal();
        coco.makePayment(100);
        //    System.out.println(coco.getBillTotal());
        //    System.out.println(coco.getType());
        coco.getDetails();

        PhoneBill cici = new PhoneBill();
        System.out.println(cici.getType());

        CustomerAccount cc = new CustomerAccount("chris", 1, 51381670, "tai hang");
        System.out.println(cc.getCustName());
        System.out.println(cc.getCustNum());
        System.out.println(cc.getCustPhoneNum());
        System.out.println(cc.getCustAddress());

        cc.setCustomerInfo("Cici", 2, 51283201, "Chai Wan");
        System.out.println(cc.getCustName());
        System.out.println(cc.getCustNum());
        System.out.println(cc.getCustPhoneNum());
        System.out.println(cc.getCustAddress());
        
        cc.getBill();
        
        

    }

}
