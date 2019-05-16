package dao;

import java.sql.*;

//其他dao实现类的父类
public class BaseDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;


    //通用查询
    public ResultSet executeQuery(String sql,Object... params){

        try {
            conn = getConnection();

            ps = conn.prepareStatement(sql);
            //设置参数
            if(params!=null){
                for(int i=0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }

            //由statement执行查询sql语句
            rs = ps.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;


    }

    //通用增删改
    public int executeUpdate(String sql,Object... params){

        int re=-1;

        try {
            conn = getConnection();

            ps = conn.prepareStatement(sql);
            //设置参数
            if(params!=null){
                for(int i=0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }

            //由statement执行新增sql语句
            re = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           closeAll();

        }
        return re;

    }

    //获得连接
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获得连接
            //获得返回值变量：光标放到语句结尾：alt+enter->local var...回车
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "root", "kgc");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }
    //关闭连接
    public void closeAll(){
        try {
            if (rs != null) {
                rs.close();
            }

            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
