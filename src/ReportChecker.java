import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReportChecker {

    private int numberOfReports = 0;
    private int safetyMechnismEnagegd = 0;

    private boolean isSafe(ArrayList<Integer> input) {
        boolean isIncreasing = input.get(0) < input.get(1);

        for (int i = 1 ; i < input.size() ; i++){

            int diff = input.get(i) - input.get(i-1);

            if (Math.abs(diff) < 1 || Math.abs(diff) > 3){
                return false;
            }

            if ((isIncreasing && input.get(i) < input.get(i-1)) || (!isIncreasing && input.get(i) > input.get(i-1))) {
                return false;
            }
        }
        return true;
    }

    public boolean isSafeReport(ArrayList<Integer> input){
        numberOfReports ++;

        if (isSafe(input)) {
            return true;
        }

        for (int i = 0; i < input.size(); i++){
            ArrayList<Integer> adaptedInput = new ArrayList<>(input);
            adaptedInput.remove(i);
            if (isSafe(adaptedInput)){
                safetyMechnismEnagegd ++;
                return true;
            }
        }
        return false;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public int getSafetyMechnismEnagegd() {
        return safetyMechnismEnagegd;
    }
}
