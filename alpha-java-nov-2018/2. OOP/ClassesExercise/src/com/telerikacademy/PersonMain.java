package com.telerikacademy;

public class PersonMain {
    public static void main(String[] args) {
        Person pesho = new Person("Pesho", 23, "0887123456");
        pesho.addInterest("Football");
        pesho.addInterest("Computer Games");

        Person gosho = new Person("Gosho", 30, "0887654321");
        gosho.addInterest("Ski");
        gosho.addInterest("Climbing");
        gosho.addInterest("Programming");

        Person ivana = new Person("Ivana", 21, "0887112233");
        ivana.addInterest("Books");
        ivana.addInterest("Cooking");

        Person misho = new Person("Misho", 25, "0888888888");
        misho.addInterest("Music");
        misho.addInterest("Play drums");
        misho.addInterest("Yoga");

        Person rumi = new Person("Rumi", 27, "0885588111");
        rumi.addInterest("Programming");
        rumi.addInterest("Dancing");

        pesho.addFriend(gosho);
        pesho.addFriend(misho);

        gosho.addFriend(rumi);

        ivana.addFriend(pesho);
        ivana.addFriend(rumi);

        misho.addFriend(pesho);
        misho.addFriend(gosho);
        misho.addFriend(ivana);
        misho.addFriend(rumi);

        rumi.addFriend(ivana);

        Person[] people = {pesho, gosho, ivana, misho, rumi};
        for (Person person : people) {
            person.introduce();
            person.sharePhone();
            person.showFriends();

            System.out.println();
            System.out.println();
        }
    }
}
