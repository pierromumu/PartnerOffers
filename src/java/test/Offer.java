package test;

import java.sql.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Offer {
    private int ido;
    private String enterprise;
    private Date dateCreation;
    private Date dateBeginning;
    private int length;
    private String activityField;
    private String title;
    private int areaCode;
    private String location;
    private String missionStatement;
    private int pay;
    private String details;
    private String profile;
    private String contactInformations;

    public Offer(){}
    public Offer(String en, Date dc, Date db, int le, String af, String ti, int ac, String lo, String ms, int pa, String de, String pr, String ci){
        this.enterprise = en;
        this.dateCreation = dc;
        this.dateBeginning = db;
        this.length = le;
        this.activityField = af;
        this.title = ti;
        this.areaCode = ac;
        this.location = lo;
        this.missionStatement = ms;
        this.pay = pa;
        this.details = de;
        this.profile = pr;
        this.contactInformations = ci;
    }

    public int getIdo(){return this.ido;}
    public String getEnterprise(){return this.enterprise;}
    public Date getDateCreation(){return this.dateCreation;}
    public Date getDateBeginning(){return this.dateBeginning;}
    public int getLength(){return this.length;}
    public String getActivityField(){return this.activityField;}
    public String getTitle(){return this.title;}
    public int getAreaCode(){return this.areaCode;}
    public String getLocation(){return this.location;}
    public String getMissionStatement(){return this.missionStatement;}
    public int getPay(){return this.pay;}
    public String getDetails(){return this.details;}
    public String getProfile(){return this.profile;}
    public String getContactInformations(){return this.contactInformations;}

    public void setIdo(int i){this.ido=i;}
    public void setEnterprise(String e){this.enterprise=e;}
    public void setDateCreation(Date d){this.dateCreation=d;}
    public void setDateBeginning(Date d){this.dateBeginning=d;}
    public void setLength(int l){this.length=l;}
    public void setActivityField(String a){this.activityField=a;}
    public void setTitle(String t){this.title=t;}
    public void setAreaCode(int a){this.areaCode=a;}
    public void setLocation(String l){this.location=l;}
    public void setMissionStatement(String m){this.missionStatement=m;}
    public void setPay(int p){this.pay=p;}
    public void setDetails(String d){this.details=d;}
    public void setProfile(String p){this.profile=p;}
    public void setContactInformations(String c){this.contactInformations=c;}

    @Override
    public String toString(){
        return getTitle();
    }
}
