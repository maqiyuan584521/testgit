package test;

import dao.EmpDAO;
import dao.impl.EmpDAOImpl;
import entity.Emp;
import org.junit.Test;
import service.EmpService;
import service.impl.EmpServiceImpl;
import util.Page;

import java.util.List;

public class Test1 {

    @Test
    public void test1(){
        EmpDAO dao = new EmpDAOImpl();
        int count = dao.getCountByPage();
        System.out.println(count);
    }

    @Test
    public void test2(){
        EmpDAO dao = new EmpDAOImpl();
        List<Emp> list = dao.getByPage(3, 5);
        for(Emp emp:list) {
            System.out.println(emp);
        }
    }

    @Test
    public void test3(){
        EmpService service = new EmpServiceImpl();
        Page page = service.getByPage(1);

        List<Emp> list = page.getList();
        for(Emp emp:list) {
            System.out.println(emp);
        }
    }
}
