package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program1 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println();
        System.out.println("=== TEST 1: department findAll ===");
        Department department = departmentDao.findById(4);
        System.out.println("   " +department);


        System.out.println();
        System.out.println("=== TEST 2: department findAll ===");
        List<Department> departments = departmentDao.findAll();
        for (Department obj : departments)
            System.out.println("   " +obj);


        System.out.println();
        System.out.println("=== TEST 3: department insert ===");
        Department department1 = new Department(null,"D1");
        departmentDao.insert(department1);
        System.out.println("inserted:  " +department1.getId());

        System.out.println();
        System.out.println("=== TEST 4: department update ===");
        Department department2 = departmentDao.findById(15);
        department2.setName("Gamer");
        departmentDao.update(department2);
        System.out.println("update complited");

        System.out.println();
        System.out.println("=== TEST 5: department update ===");
        departmentDao.deleteById(11);
        System.out.println("deleted complited");
    }
}
