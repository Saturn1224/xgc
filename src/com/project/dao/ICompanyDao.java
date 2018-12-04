package com.project.dao;

import com.project.model.Company;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2018/11/14 0014.
 */
public interface ICompanyDao {
    public List<Company>  getCompanys();
    public void deleteByCid(int cid);
    //ҳ��������
    public  int getCount() throws SQLException;
    //��ҳ
    public List<Company> getPages(int pageIndex,int pageSize);
}

