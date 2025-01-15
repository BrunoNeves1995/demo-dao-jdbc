package application;

import entities.Department;
import entities.Seller;

import java.time.LocalDate;

public class Program {

    public static void main(String[] args) {
        Department dp = new Department(1, "Books");
        Seller seller = new Seller(21,"bob", "bob@gamil", LocalDate.now(), 3000.0, dp);

        System.out.println(seller);
    }


}
