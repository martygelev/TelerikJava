# Computing Health Insurance Premium for Staff ~ Let's put Abstract Classes &amp; Methods into practice

This is a very simple exercise and it would enable us to use **_abstract classes_** & **_methods_**. In this exercise, we will extend the HMS system. Earlier we introduced a _billing component_ to bill the patients, which was dependent on their insurance plan (**_platinum/gold/silver/bronze_**). Let's now build something for staff members. Like patients, staff members would also need health insurance. So, as employees of the Hospital, every month staff members would be paying a **premium** (i.e., some amount of money) towards their health insurance. In this exercise we would compute this **monthly premium**, which would be dependent on the chosen insurance plan (i.e., **_platinum/gold/silver/bronze_**) along with **monthly salary** of the staff member as follows:

**platinum** - 8% of the salary

**gold** - 7% of salary

**silver** - 6% of salary

**bronze** - 5% of salary

Later, in another exercise (part 2), we will further improve this monthly premium computation logic based on additional factors.  

Implementation specifics:

1. **Move insured & insurancePlan fields from Patient.java to User.java**. Earlier, these fields were specific to Patient. But, now since we are talking about staff members also having health insurance and since both Staff & Patient are sub-classes of User, we can now move these two fields along with their getters and setters into User class.

1. Let's introduce monthly premium calculation logic in classes corresponding to different insurance plans as the logic is dependent on insurance plan chosen in addition to salary. So, let's introduce the following **_abstract_** method in the super class HealthInsurancePlan and this method would be overridden in specific sub-classes.  

```java
public abstract double computeMonthlyPremium(double salary);  
```

1. One more thing - let's introduce more complex insurance company thatn just the name we were using. Add the following class to your hierarchy:

```java
public class InsuranceBrand {
	private long id;
	private String name;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
```

and change the **offeredBy** field in **HelathInsurancePlan** class.

Thanks & Happy Coding!!