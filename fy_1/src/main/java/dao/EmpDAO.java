package dao;

import entity.Emp;

import java.util.List;

public interface EmpDAO {

    //获得分页数据
    //select * from emp limit ?,?
    public List<Emp> getByPage(int start,int pageSize);


    //总条数
    public int getCountByPage();

}
