import java.util.Arrays;
import java.util.Scanner;

public class ExchangeRatesGO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double currency = Double.parseDouble(in.nextLine());
        int days = Integer.parseInt(in.nextLine());
        double[][] exchange = new double[days][];

        for(int i = 0; i < days; ++i)
        {
            exchange[i] = Arrays.stream(in.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        }

        System.out.printf("{0:0.00}",Rec(currency, 0, 0, exchange));
    }

    static double Rec(double currency, int type, int day, double[][] exchange)
    {
        if(day == exchange.length)
        {
            return type == 0 ? currency : 0;
        }

        return Math.max(Rec(currency, type, day + 1, exchange), Rec(currency * exchange[day][type], 1 - type, day + 1, exchange));
    }
}
