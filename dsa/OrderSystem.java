package ok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderSystem {
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine());

        List<Order> orders = new ArrayList<>(); //remove and from this list !
        TreeMap<String, List<Order>> consumerOrders = new TreeMap<>();

        for(int i = 0; i<num;i++){
            String input = in.readLine();

            if (input.contains("AddOrder")) {
                String[] com = input.replace("AddOrder ", "").split(";");
                String name = com[0];
                Double price = Double.parseDouble(com[1]);
                String consumer = com[2];

                    Order order = new Order(name, price, consumer);
                    orders.add(order);
                    builder.append("Order added");
                            builder.append(System.lineSeparator());

                    if (!consumerOrders.containsKey(consumer)) {
                        consumerOrders.put(consumer, new ArrayList<>());
                    }
                    consumerOrders.get(consumer).add(order);

            } else if (input.contains("FindOrdersByConsumer")) {
                String consumer = input.replace("FindOrdersByConsumer ", "");

                if (!consumerOrders.containsKey(consumer) || consumerOrders.get(consumer).isEmpty()) {
                    builder.append("No orders found");
                    builder.append(System.lineSeparator());
                    continue;
                } else {
                    builder.append(consumerOrders.get(consumer).stream()
                            .sorted(Comparator.comparing(Order::getName))
                            .map(Order::toString)
                            .collect(Collectors.joining(System.lineSeparator()))); //TODO CHECK!!!
                    builder.append(System.lineSeparator());
                }

            } else if (input.contains("DeleteOrders")) {
                String consumer = input.replace("DeleteOrders ", "");
                if (consumerOrders.containsKey(consumer)) {

                        int size = consumerOrders.get(consumer).size();

                        List<Order> ordersToRemove = orders.stream().
                                filter(o -> o.getConsumer().equals(consumer)).
                                collect(Collectors.toList());
                        orders.removeAll(ordersToRemove);

                        consumerOrders.remove(consumer);
                        builder.append(String.format("%d orders deleted", size));
                        builder.append(System.lineSeparator());

                } else {
                    builder.append("No orders found");
                    builder.append(System.lineSeparator());
                    continue;
                }

            } else if (input.contains("FindOrdersByPriceRange")) {
                String[] priceData = input.replace("FindOrdersByPriceRange ", "").split(";");
                Double startingPrice = Double.parseDouble(priceData[0]);
                Double endingPrice = Double.parseDouble(priceData[1]);

                Stream stream = orders.stream()
                        .filter(x -> x.getPrice() >= startingPrice && x.getPrice() <= endingPrice);
                if (stream.count()==0){
                    builder.append("No orders found");
                    builder.append(System.lineSeparator());
                    continue;
                }
                builder.append(orders.stream()
                        .filter(x -> x.getPrice() >= startingPrice && x.getPrice() <= endingPrice)
                        .sorted(Comparator.comparing(Order::getName))
                        .map(Order::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
                builder.append(System.lineSeparator());
            }

        }
        System.out.print(builder);
    }

    static class Order implements Comparable<Order>{
        private String name;
        private Double price;
        private String consumer;

        public Order(String name, double price, String consumer) {
            this.name = name;
            this.price = price;
            this.consumer = consumer;
        }

        public String getName() {
            return name;
        }

        public Double getPrice() {
            return price;
        }

        public String getConsumer() {
            return consumer;
        }

        @Override
        public String toString() {
            return String.format("{%s;%s;%.2f}", getName(), getConsumer(), getPrice());
        }
        @Override
        public int compareTo(Order o) {
            return name.compareTo(o.name);
        }
    }
}