package dao.impl;

import dao.BaseDAO;
import dao.EmpDAO;
import entity.Emp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAOImpl extends BaseDAO implements EmpDAO {
    @Override
    public List<Emp> getByPage(int start, int pageSize) {
        List<Emp> list = new ArrayList<Emp>();
        String sql = "select * from emp order by id  limit ?,?";
        ResultSet rs = executeQuery(sql, start, pageSize);
        try {
            while(rs.next()){
                Emp emp = new Emp(rs.getInt("id"),
                        rs.getString("name"));
                list.add(emp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }


        return list;
    }

    @Override
    public int getCountByPage() {
        int count=-1;
        String sql ="select count(1) from emp";
        ResultSet rs = executeQuery(sql);
        try {
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return count;
    }
}
