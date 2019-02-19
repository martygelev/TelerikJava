package dsa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cooking {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Product> cook = new HashMap<>();
        List<String> productAppearance = new ArrayList<>();

        int n = Integer.parseInt(console.readLine());

        for (int i = 0; i < n; i++) {
            String input = console.readLine();
            if (input.endsWith(":")) {
                input = input + "null";
            }
            String[] arrInput = input.split(":");
            double quantity = Double.parseDouble(arrInput[0]);

            String measure = arrInput[1];
            String productName = arrInput[2];

            Product product1 = new Product(productName, measure, quantity);

            if (cook.isEmpty()) {
                cook.put(productName.toLowerCase(), product1);
                productAppearance.add(productName.toLowerCase());
                continue;
            }
            if (cook.containsKey(productName.toLowerCase())) {
                double updateCupQty = cook.get(productName.toLowerCase()).getCupQty();
                if (updateCupQty < 0) {
                    updateCupQty = 0.00;
                }
                double calculateCurrentCupQty = product1.getCupQty();
                double updateQty = updateCupQty + calculateCurrentCupQty;
                cook.get(productName.toLowerCase()).setCupQty(updateQty);

            } else {
                cook.put(productName.toLowerCase(), product1);
                productAppearance.add(productName.toLowerCase());
            }
        }

        int m = Integer.parseInt(console.readLine());

        for (int i = 0; i < m; i++) {
            String input = console.readLine();
            if (input.endsWith(":")) {
                input = input + "null";
            }
            String[] arrInput = input.split(":");


            double quantity = Double.parseDouble(arrInput[0]);
            String measure = arrInput[1];
            String productName = arrInput[2];


            Product product1 = new Product(productName, measure, quantity);
            if (cook.containsKey(productName.toLowerCase())) {
                double updateCupQty = cook.get(productName.toLowerCase()).getCupQty();
                if (updateCupQty < 0) {
                    updateCupQty = 0.00;
                }
                double calculateCurrentCupQty = product1.getCupQty();
                double updateQty = updateCupQty - calculateCurrentCupQty;
                cook.get(productName.toLowerCase()).setCupQty(updateQty);

            }
        }


        for (String productShowed : productAppearance) {
            double cookCupQtyTemp = cook.get(productShowed).getCupQty();


            if (cookCupQtyTemp > 0 && cook.containsKey(productShowed)) {
                double qtyForPrint = cook.get(productShowed).getCupQty();
                String originalMeasureForSwitch = cook.get(productShowed).getOriginalMeasure();
                qtyForPrint = cook.get(productShowed).reverseToOriginalQty(originalMeasureForSwitch,
                        qtyForPrint) + 0.0001;
                String stringValue = String.valueOf(qtyForPrint);
                BigDecimal printValue = new BigDecimal(stringValue);

                if (cook.get(productShowed).getName().equals("null")) {
                    System.out.printf("%.2f:%s:\n", printValue, cook.get(productShowed).getOriginalMeasure());

                } else {
                    System.out.printf("%.2f:%s:%s\n", printValue,
                            cook.get(productShowed).getOriginalMeasure(), cook.get(productShowed).getName());
                }
            }
        }
    }

    public static class Product {
        private String name;
        private String originalMeasure;
        private double originalQty;
        private String measure;
        private double cupQty;

        Product(String name, String originalMeasure, double originalQty) {

            setName(name);
            setOriginalMeasure(originalMeasure);
            setOriginalQty(originalQty);
            setMeasure(originalMeasure);
            setCupQty(originalMeasure, originalQty);

        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }

        String getOriginalMeasure() {
            return originalMeasure;
        }

        void setOriginalMeasure(String originalMeasure) {
            this.originalMeasure = originalMeasure;
        }

        void setOriginalQty(double originalQty) {
            this.originalQty = originalQty;
        }

        void setMeasure(String originalMeasure) {
            String measureSwitch = getString(originalMeasure);
            this.measure = measureSwitch;
        }

        double getCupQty() {
            return cupQty;
        }

        void setCupQty(double setCupQty) {
            this.cupQty = setCupQty;
        }

        void setCupQty(String originalMeasure, double originalQty) {
            String measureSwitch = " ";
            measureSwitch = getString(originalMeasure);
            switch (measureSwitch.toLowerCase()) {
                case "gals":
                    originalQty = originalQty * 16.00;
                    break;
                case "qts":
                    originalQty = originalQty * 4.00;
                    break;
                case "pts":
                    originalQty = originalQty * 2.00;
                    break;
                case "ls":
                    originalQty = originalQty * 4.1666666666666666666;
                    break;
                case "fl ozs":
                    originalQty = originalQty * 0.125;
                    break;
                case "tbsps":
                    originalQty = originalQty * 0.0625;
                    break;
                case "tsps":
                    originalQty = originalQty * 0.0208333333;
                    break;
                case "mls":
                    originalQty = originalQty * 0.0041666666666666666;
                    break;
                default:
                    originalQty = originalQty;
                    break;
            }

            this.cupQty = originalQty;
        }

        double reverseToOriginalQty(String originalMeasure, double cupQty) {
            switch (originalMeasure.toLowerCase()) {
                case "gallons":
                    cupQty = cupQty / 16.00;
                    break;
                case "quarts":
                    cupQty = cupQty / 4.00;
                    break;
                case "pints":
                    cupQty = cupQty / 2.00;
                    break;
                case "liters":
                    cupQty = cupQty / 4.166666666666666666;
                    break;
                case "fluid ounces":
                    cupQty = cupQty / 0.125;
                    break;
                case "tablespoons":
                    cupQty = cupQty / 0.0625;
                    break;
                case "teaspoons":
                    cupQty = cupQty / 0.02083333333333333333;
                    break;
                case "milliliters":
                    cupQty = cupQty / 0.0041666666666666666;
                    break;
                case "gals":
                    cupQty = cupQty / 16.00;
                    break;
                case "qts":
                    cupQty = cupQty / 4.00;
                    break;
                case "pts":
                    cupQty = cupQty / 2.00;
                    break;
                case "ls":
                    cupQty = cupQty / 4.166666666666666666;
                    break;
                case "fl ozs":
                    cupQty = cupQty / 0.125;
                    break;
                case "tbsps":
                    cupQty = cupQty / 0.0625;
                    break;
                case "tsps":
                    cupQty = cupQty / 0.02083333333333333333;
                    break;
                case "mls":
                    cupQty = cupQty / 0.0041666666666666666;
                    break;
                default:
                    cupQty = cupQty;
                    break;
            }

            return cupQty;
        }

        @Override
        public int hashCode() {

            return this.getName().hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.hashCode() == this.hashCode()) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static String getString(String originalMeasure) {
        String measureSwitch;
        switch (originalMeasure) {
            case "gallons":
                measureSwitch = "gals";
                break;
            case "quarts":
                measureSwitch = "qts";
                break;
            case "pints":
                measureSwitch = "pts";
                break;
            case "liters":
                measureSwitch = "ls";
                break;
            case "fluid ounces":
                measureSwitch = "fl ozs";
                break;
            case "tablespoons":
                measureSwitch = "tbsps";
                break;
            case "teaspoons":
                measureSwitch = "tsps";
                break;
            case "milliliters":
                measureSwitch = "mls";
                break;
            case "cups":
                measureSwitch = "cups";
                break;
            default:
                measureSwitch = originalMeasure;
                break;
        }
        return measureSwitch;
    }
}


