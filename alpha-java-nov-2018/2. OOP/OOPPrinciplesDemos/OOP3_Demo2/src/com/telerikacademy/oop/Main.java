package com.telerikacademy.oop;

public class Main {
    public static void main(String[] args) {
        // Part 1 - We can call the method with every class in the hierarchy, as long as its compatible with User.
        User user = new User();
        User staff = new Staff();
        User editor = new Editor();

        UserPrint userPrint = new UserPrint();
        userPrint.printUserType(user);
        userPrint.printUserType(staff);
        userPrint.printUserType(editor);

        //editor.approveReview();

        // Part 2
        // Call object's type's method
		// editor.approveReview();

        // Call method & see how JVM calls the most specific one
        // editor.postAReview();
		// editor.saveWebLink();
    }
}
