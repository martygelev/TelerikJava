public class PowerSum {
    public static Integer answer = 0;

    public static void main(String[] args) {
        int x = 29;
        int n = 2;

        solve(x, n, 0, 1, answer);
        System.out.println(answer);
    }

    private static int solve(int x, int n, int currentSum, int currentNumber, Integer answer) {

        if (currentSum == x) {
            return 1;
        } else if (currentSum < x) {
            currentSum += Math.pow(currentNumber, n);
            answer = answer + solve(x, n, currentSum, currentNumber + 1, answer);
        } else {
            currentSum -= Math.pow(currentNumber, n);
            answer = answer + solve(x, n, currentSum, currentNumber + 1, answer);
            return 0;
        }

        return answer;

    }

}