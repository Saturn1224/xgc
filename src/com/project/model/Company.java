package com.project.model;

/**
 * Created by Administrator on 2018/11/12 0012.
 */
public class Company {
    private  int cid;
    private  String zwName;
    private  String cName;
    private String cplace;
    private  String cxz;
    private String cgm;
    private  String ccy;
    private  Double lsalary;
    private  Double hsalary;

    @Override
    public String toString() {
        return "Company{" +
                "cid=" + cid +
                ", zwName='" + zwName + '\'' +
                ", cName='" + cName + '\'' +
                ", cplace='" + cplace + '\'' +
                ", cxz='" + cxz + '\'' +
                ", cgm='" + cgm + '\'' +
                ", ccy='" + ccy + '\'' +
                ", lsalary=" + lsalary +
                ", hsalary=" + hsalary +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {

        this.cid = cid;
    }

    public String getZwName() {
        return zwName;
    }

    public void setZwName(String zwName) {
        this.zwName = zwName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getCplace() {
        return cplace;
    }

    public void setCplace(String cplace) {
        this.cplace = cplace;
    }

    public String getCxz() {
        return cxz;
    }

    public void setCxz(String cxz) {
        this.cxz = cxz;
    }

    public String getCgm() {
        return cgm;
    }

    public void setCgm(String cgm) {
        this.cgm = cgm;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public Double getLsalary() {
        return lsalary;
    }

    public void setLsalary(Double lsalary) {
        this.lsalary = lsalary;
    }

    public Double getHsalary() {
        return hsalary;
    }

    public void setHsalary(Double hsalary) {
        this.hsalary = hsalary;
    }
}
