package in.com;

public class Billing {
    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
        double insuranceValue;
        double remainingValue;

        if (patientInsurancePlan instanceof PlatinumPlan){
            insuranceValue = 0.9 * amount;
            remainingValue = amount - insuranceValue - 50.0;
            System.out.println("Here in Platinum");
        }
        else if (patientInsurancePlan instanceof GoldPlan) {
            insuranceValue = 0.8 * amount;
            remainingValue = amount - insuranceValue - 40.0;
            System.out.println("Here in Gold");
        }
        else if (patientInsurancePlan instanceof SilverPlan){
            insuranceValue = 0.7 * amount;
            remainingValue = amount - insuranceValue - 30.0;
            System.out.println("Here in Silver");
        }
        else if (patientInsurancePlan instanceof BronzePlan) {
            insuranceValue = 0.6 * amount;
            remainingValue = amount - insuranceValue - 25.0;
            System.out.println("Here in Bronze");
        }else {
            insuranceValue = 0;
            remainingValue = amount - 20.0;
            System.out.println("Here in nowhere!!");
        }

        payments[0] = insuranceValue;
        payments[1] = remainingValue;
        System.out.println("payments[0]: " + payments[0]);
        System.out.println("payments[1]: " + payments[1]);
        return payments;
    }

}
