package leetcode.p1400.p1491;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        double sum = 0;
        int min = salary[0], max = salary[0];
        for (int s : salary) {
            sum += s;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        return (sum - min - max) / (salary.length - 2);
    }
}
