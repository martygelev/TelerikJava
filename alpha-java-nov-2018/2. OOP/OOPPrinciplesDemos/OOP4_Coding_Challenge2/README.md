# Computing Health Insurance Premium for Staff (Part 2) ~ Let's put Interfaces into practice

In this exercise, we will make use of **interfaces** and will extend the earlier exercise where we used abstract classes & methods to incorporate logic to compute monthly health insurance premium for staff members. There we used only _salary_ information of the User. Now, let's extend it to also include two more parameters:

1. **_age_**

1. **_whether or not the user smokes_**.

Rules for these parameters can vary across insurance plans ( **_platinum/gold/silver/bronze_**) & and from one insurance company to another. Let's assume that we have only one insurance company called **BlueCrossBlueShield** and the rules for the different plans are as below:

**Platinum Plan**: If age > 55 then add 200 to premium. If user smokes then add 100

**Gold Plan**: If age > 55 then add 150 to premium. If user smokes then add 90

**Silver Plan**: If age > 55 then add 100 to premium. If user smokes then add 80

**Bronze Plan**: If age > 55 then add 50 to premium. If user smokes then add 70

Essentially, premium increases if the user is over 55 years of age. Similarly, if user smokes, then his/her premium would also be increased. Note that age & smoking are independent here, i.e., if age **<** 55 and user smokes, then we increase the premium only for smoking.

As we can see the above rules are specific to BlueCrossBlueShield, which IS-A type of Insurance Brand. Recall from earlier exercises that we already have a class called InsuranceBrand. So, the implementation for the above rules would be provided in BlueCrossBlueShield in a method called **_computeMonthlyPremium_**. Let's also assume that InsuranceBrand is very generic and can be used across class hierarchies. In this case, it may be better to represent it as an interface. So, we can change it from a class to interface and it would declare only a single method computeMonthlyPremium, whose declaration is as follows and would thus be implemented by BlueCrossBlueShield. As you can see the method parameters can be used to implement the above logic and return the appropriate insurance premium. Also, since we are making InsuranceBrand an interface, its existing fields (id & name) and the corresponding getters & setters can be moved into the subclass BlueCrossBlueShield.   

```java
public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking);  
```

Recall that in the previous exercise, monthly premium was computed using only salary & insurance plan using a similarly named method **_computeMonthlyPremium(double)_**, which was implemented by individual insurance plan classes (PlatinumPlan/GoldPlan/SilverPlan/BronzePlan). This method should now additionally take the two new parameters 'age' & 'smoking' too. Below is the implementation of **computeMonthlyPremium** in PlatinumPlan.java and you can implement it in other insurance plan related classes too. _**getOfferedBy**_() is from the super class and it would return an instance of InsuranceBrand. Notice, that we are passing 'this' reference to computeMonthlyPremium as it is expecting a **HealthInsurancePlan** instance and in this case it would be an instance of PlatinumPlan. 

```java
public  double computeMonthlyPremium(double salary,  int age,  boolean smoking)  {
    return  0.08  \* salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
}
```

Finally, add age (int) & smoking (boolean) fields in User.java and make sure setters & getters are added with correct conventions. Although, these fields are added in User class, they really do not serve any purpose in this exercise as computeMonthlyPremium above takes age & smoking values separately. 

Below is a sample invocation code:  

```java
User staff =  new  User();  
InsuranceBrand insuranceBrand =  new  BlueCrossBlueShield();  
HealthInsurancePlan insurancePlan =  new  PlatinumPlan();  

insurancePlan.setOfferedBy(insuranceBrand);
staff.setInsurancePlan(insurancePlan);
insurancePlan.computeMonthlyPremium(5000,  56,  true);
```

Overall just to summarize, we have two class hierarchies here: (i) an abstract class HealthInsurancePlan and the specific insurance plans as its subtypes (ii) an interface InsuranceBrand and its subtypes (BlueCrossBlueShield). HealthInsurancePlan defines both state & behavior while InsuranceBrand defines just the behavior as it should be.

Thanks & Happy Coding!!