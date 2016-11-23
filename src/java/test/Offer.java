package test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierre
 */
public class Offer {
    private int id;
    private String title;
    private String location;
    private String missionStatement;
    private String details;
    private String profile;
    private String contactInformations;

    public Offer(){}
    public Offer(String t, String l, String m, String d, String p, String c){
        this.title=t;
        this.location=l;
        this.missionStatement=m;
        this.details=d;
        this.profile=p;
        this.contactInformations=c;
    }

    public int getId(){return this.id;}
    public String getTitle(){return this.title;}
    public String getLocation(){return this.location;}
    public String getMissionStatement(){return this.missionStatement;}
    public String getDetails(){return this.details;}
    public String getProfile(){return this.profile;}
    public String getContactInformations(){return this.contactInformations;}

    public void setId(int i){this.id=i;}
    public void setTitle(String t){this.title=t;}
    public void setLocation(String l){this.location=l;}
    public void setMissionStatement(String m){this.missionStatement=m;}
    public void setDetails(String d){this.details=d;}
    public void setProfile(String p){this.profile=p;}
    public void setContactInformations(String c){this.contactInformations=c;}

    @Override
    public String toString(){
        return getId()+" "+getTitle()+" "+getLocation()+" "+getMissionStatement()+" "+getDetails()+" "+getProfile()+" "+getContactInformations();
    }
}
