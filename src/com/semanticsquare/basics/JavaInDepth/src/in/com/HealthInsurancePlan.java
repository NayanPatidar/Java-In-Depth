package in.com;

public class HealthInsurancePlan {
    // Code for 'coverage' field goes here

    // Don't worry about the below code and also the InsuranceBrand class
    double coverage ;

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    private InsuranceBrand offeredBy;

    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }
}
