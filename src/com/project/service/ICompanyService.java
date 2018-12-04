package com.project.service;

import com.project.model.Company;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2018/11/14 0014.
 */
public interface ICompanyService {
    public List<Company> getCompanys();
    public  void  deleteByCid(int cid);
    public int getCount() throws SQLException;
    public List<Company> getPages(int pageIndex,int pageSize);
}
