package com.project.dao.imp;

import com.project.dao.ICompanyDao;
import com.project.model.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/11/14 0014.
 */
public class CompanyDaoImpl extends  BaseDaoImpl implements ICompanyDao{
    @Override
    public List<Company> getCompanys() {
      String sql = "select * from company1";
        Object[] objects = new Object[]{};
        ResultSet rs = this.execQuery(sql, objects);
        List<Company> list = new LinkedList<>();
        try {
            while(rs.next()){
                Company company = new Company();
                company.setCid(rs.getInt(1));
                company.setZwName(rs.getString(2));
                company.setcName(rs.getString(3));
                company.setCplace(rs.getString(4));
                company.setCxz(rs.getString(5));
                company.setCgm(rs.getString(6));
                company.setCcy(rs.getString(7));
                company.setLsalary(rs.getDouble(8));
                company.setHsalary(rs.getDouble(9));
                list.add(company);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close(conn,ps,rs);
        }

        return  list;
    }

    @Override
    public void deleteByCid(int cid) {
        String sql  = "delete from company1 where c_id=?";
        Object[] objects = new Object[1];
        objects[0]=cid;
        int excupdate = this.excupdate(sql, objects);
        if(excupdate>0){
            System.out.println("É¾³ý³É¹¦");
        }

    }

    @Override
    public int getCount() throws SQLException {
        String sql ="select count(*) from company1";
        Object[] objects=new Object[]{};
        ResultSet rs = execQuery(sql, objects);
        int num=0;
        if(rs.next()){
            num= rs.getInt(1);
        }

        this.close(conn,ps,rs);
        return num;
    }

    @Override
    public List<Company> getPages(int pageIndex, int pageSize) {
        String sql = "select * from company1 limit ?,?";
        Object[] objects = {(pageIndex - 1) * pageSize, pageSize};
        ResultSet rs = execQuery(sql, objects);
        List<Company> list = new LinkedList<>();
        try {
            while (rs.next()) {
                Company company = new Company();
                company.setCid(rs.getInt(1));
                company.setZwName(rs.getString(2));
                company.setcName(rs.getString(3));
                company.setCplace(rs.getString(4));
                company.setCxz(rs.getString(5));
                company.setCgm(rs.getString(6));
                company.setCcy(rs.getString(7));
                company.setLsalary(rs.getDouble(8));
                company.setHsalary(rs.getDouble(9));
                list.add(company);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        List<Company> pages = new CompanyDaoImpl().getPages(1, 10);
        System.out.println(pages.size());
        System.out.println(pages);



    }
}
