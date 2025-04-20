//Ubah method calculateTax agar menerima objek TaxPayerInfo:
package lib;

public class TaxFunction {

    public static int calculateTax(TaxPayerInfo info) {
        int tax = 0;

        if (info.numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        int numberOfChildren = Math.min(info.numberOfChildren, 3);

        int nonTaxableIncome = 54000000;
        if (info.isMarried) {
            nonTaxableIncome += 4500000 + (numberOfChildren * 1500000);
        }

        double taxableIncome = ((info.monthlySalary + info.otherMonthlyIncome) * info.numberOfMonthWorking) - info.deductible - nonTaxableIncome;
        tax = (int) Math.round(0.05 * taxableIncome);

        return Math.max(tax, 0);
    }

}
