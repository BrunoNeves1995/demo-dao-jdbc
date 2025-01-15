package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;

public class Program {

    public static void main(String[] args) {
        Department dp = new Department(1, "Books");
        Seller seller = new Seller(21,"bob", "bob@gamil", LocalDate.now(), 3000.0, dp);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);
    }


}
