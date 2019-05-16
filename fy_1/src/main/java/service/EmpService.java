package service;

import util.Page;

public interface EmpService {

    //分页业务
    public Page getByPage(int pageNo);
}
