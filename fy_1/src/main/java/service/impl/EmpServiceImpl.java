package service.impl;

import dao.EmpDAO;
import dao.impl.EmpDAOImpl;
import entity.Emp;
import service.EmpService;
import util.Page;

import java.util.List;

public class EmpServiceImpl implements EmpService {

    private EmpDAO dao = new EmpDAOImpl();

    @Override
    public Page getByPage(int pageNo) {
        Page page = new Page();
        //设置page的页号
        page.setPageNo(pageNo);

        //调用dao，获得总条数
        int count = dao.getCountByPage();
        //把数据放入page
        page.setCount(count);
        //调用dao，获得分页数据
        List<Emp> list = dao.getByPage(page.getStart(),
                page.getPageSize());


        page.setList(list);

        return page;
    }
}
