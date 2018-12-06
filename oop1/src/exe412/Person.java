package exe412;

public class Person {
    private String name;
    private int age;
    private String phoneNumber;
    private String[] interests;
    private Person[] friends;

    public String getName() {
        return name;
    }

    public Person(String name, int age)
    {
        setName(name);
        setAge(age);
       this.interests=new String[0];
       this.friends=new Person[0];
    }
    public Person (String name, int age, String phoneNumber)
    {
        this(name,age);
        setPhoneNumber(phoneNumber);
    }
    public Person (String name, int age, String phoneNumber, String[] interests, Person[]friends)
    {
        this(name,age,phoneNumber);
        setInterests(interests);
        setFriends(friends);
    }

    public Person(String name,int age, String[] interests, Person[]friends)
    {
        this(name,age);
        setInterests(interests);
        setFriends(friends);
    }

    public Person(String name, int age, String phoneNumber,String[] interests)
    {
        this(name,age,phoneNumber);
        setInterests(interests);
    }
    private void setName(String name)
    {
        if (name.length()<3)
        {
            throw new IllegalArgumentException("Enter valid name!");
        }
        this.name=name;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age<0)
        {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    private String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length()!=10)
        {
            throw new IllegalArgumentException("Phone number must contains ten digits form 0 to 9!");
        }
        if (phoneNumber.charAt(0)!='0')
        {
            throw new IllegalArgumentException("Phone number must start with '0' !");
        }
        this.phoneNumber = phoneNumber;
    }

    protected void getInterests() {
        if (this.interests.length==0)
        {
            System.out.println("Interest: Only programming !");
            return;
        }
        System.out.print(this.getName() + " interests are: ");
        for (String interest : interests) {
            System.out.print(interest+ ", ");
        }

    }

    private void setFriends(Person[] friends) {
        this.friends = friends;
    }

    private void  getFriends() {
        if(this.friends.length==0)
        {
            System.out.println(this.getName() + " don't have any friends :( ... ");
            return ;
        }
        System.out.print(this.getName() + "friends are : ");
        for (Person friend : friends) {
            System.out.print(friend.getName()+ ", ");
        }

    }

    private void setInterests(String[] interests) {
        this.interests = interests;
    }

     void introducePerson()
    {
        System.out.printf("Hey, I am %s and I am %d years old :)\n",this.getName(),this.getAge());
    }
    void sharePhone()
   {
       if (this.getPhoneNumber()==null)
       {
           System.out.println(this.getName() + " don't have a phone number!");
           return;
       }
       System.out.println("If you want, you can contact with me at "+ this.getPhoneNumber());
   }

    void showFriends()
   {
       this.getFriends();
   }

}
