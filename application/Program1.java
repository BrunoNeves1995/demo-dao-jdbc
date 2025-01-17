package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program1 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();



        System.out.println();
        System.out.println("=== TEST 2: department findAll ===");
        List<Department> departments = departmentDao.findAll();
        for (Department obj : departments)
            System.out.println("   " +obj);
    }
}
