package rentAcar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, List<Car>> availableCars = new HashMap<>();
        Map<Integer, Car> carId = new HashMap<>();

        Scanner in = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");

        Car firstCar = new Car(1,"Opel","Astra","Sofia",33.33,"10.01.2019/11.02.2019");
        carId.put(1,firstCar);

        availableCars.put("Sofia",new ArrayList<>());
        availableCars.get("Sofia").add(firstCar);

        String inputData = in.nextLine();
        String[] commandSplit;

        while(!inputData.equals("Exit")){
            commandSplit = inputData.split(" ");
          String firstElement = commandSplit[0];
            switch (firstElement){
                case "1":
                    String city = commandSplit[1];
                    if (!availableCars.containsKey(city))
                    {
                        System.out.println("No cars in this city");
                    }
                    else {
                        availableCars.get(city).forEach(System.out::println);
                    }
                    break;
                case "2":
                    Integer id = Integer.parseInt(commandSplit[1]);
                    String date = commandSplit[2];
                    String[] dateInfo = date.split("/");
                    String startingDate = dateInfo[0];
                    String endDate = dateInfo[1];

                    LocalDate startingWant = LocalDate.from(formatter.parse(startingDate));
                    LocalDate endingWant = LocalDate.from(formatter.parse(endDate));


                    String strDateReal = carId.get(id).getDate();
                    String[] realDate= strDateReal.split("/");
                   String startReal = realDate[0];
                   String endReal = realDate[1];

                    LocalDate start = LocalDate.from(formatter.parse(startReal));
                    LocalDate end = LocalDate.from(formatter.parse(endReal));


                    if (startingWant.compareTo(end)>0)
                    {
                        firstCar.setDate(strDateReal);
                    }
                    else if (startingWant.compareTo(end)<0)
                    {
                        System.out.println("Car is not available");
                    }
                    break;
                case "3":
                    Integer id2 = Integer.parseInt(commandSplit[1]);
                    String cityBack = commandSplit[1];

                    Car back = carId.get(id2);
                    availableCars.get(cityBack).add(back);
                    break;
            }

            inputData = in.nextLine();
        }

    }
}
