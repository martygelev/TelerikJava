package EncaosulationExe;

public class Chicken {
    private String name;
    private int age;

    private String getName(){
        return  this.name;
    }
    private void setName(String name)
    {
        if (name.isEmpty() ||  name.equals(" "))
        {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name=name;
    }

    private void setAge(int age) {
if (age<0 || age>15)
{
    throw new IllegalArgumentException("Age should be between 0 and 15.");
}
        this.age = age;
    }

    private int getAge() {
        return this.age;
    }

    public   Chicken(String name, int age)
    {
        this.setAge(age);
        this.setName(name);

    }

    public String calculateProductPerDay(){
        double eggsPerDay =0;
        if (this.getAge()>=0 && this.getAge()<=5) {
            eggsPerDay = 2;
        }
        else if (this.getAge()>=6 && this.getAge()<=11)
        {
            eggsPerDay =1;
        }
        else if (this.getAge()>=12 && this.getAge()<=15) {
            eggsPerDay=0.75;
        }

        return String.format("Chicken %s (age %d) can produce %d eggs per day.",this.getName(),this.getAge(),(int)eggsPerDay);
    }
}
