package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println("   " +seller);

        System.out.println();
        System.out.println("=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);
        for (Seller obj : sellers)
            System.out.println("   " +obj);

        System.out.println();
        System.out.println("=== TEST 3: seller findAll ===");
        List<Seller> sellers1 = sellerDao.findAll();
        for (Seller obj : sellers1)
            System.out.println("   " +obj);

        System.out.println("=== TEST 4: seller insert ===");
        Seller seller2 = new Seller(null, "Toni", "toni@gmail.com", LocalDate.of(2025, 01, 15), 2500.0, new Department(4, "Books"));
        sellerDao.insert(seller2);
        System.out.println("   " + seller2.getId());


        System.out.println();
        System.out.println("=== TEST 5: seller update ===");
        Seller seller3 = sellerDao.findById(1);
        seller3.setName("bebe Waine");
        sellerDao.update(seller3);
        System.out.println("update complit");


    }


}
