package test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Iterator;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageOffer {

    public SessionFactory factory;

    public ManageOffer(int num){
       try{
           factory = new Configuration().configure("test/hibernateP"+num+".cfg.xml").buildSessionFactory();
       }catch (Throwable ex) {
           System.err.println("Failed to create sessionFactory object." + ex);
           throw new ExceptionInInitializerError(ex);
       }
    }

    // CREATE
    public Integer addOffer(String en, Date dc, Date db, int le, String af, String ti, int ac, String lo, String ms, int pa, String de, String pr, String ci){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer offerID = null;
      try{
         tx = session.beginTransaction();
         Offer offer = new Offer(en, dc, db, le, af, ti, ac, lo, ms, pa, de, pr, ci);
         offerID = (Integer) session.save(offer);
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
      }finally {
         session.close();
      }
      return offerID;
    }

    // DELETE
    public void deleteOffer(Offer offer){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         session.delete(offer);
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
      }finally {
         session.close();
      }
    }

    // READ
    public List listOffers(){
      Session session = factory.openSession();
      List result = null;
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List offers = session.createQuery("FROM Offer").list();
         tx.commit();
         result = offers;
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
      }finally {
         session.close();
         return result;
      }
    }

    public static void main(String args[]) {
        ManageOffer MOA = new ManageOffer(1);
        ManageOffer MOB = new ManageOffer(2);

        // deleting old entries
        List offersA = MOA.listOffers();
        for (Iterator iterator = offersA.iterator(); iterator.hasNext();){
            MOA.deleteOffer((Offer) iterator.next());
        }
        List offersB = MOB.listOffers();
        for (Iterator iterator = offersB.iterator(); iterator.hasNext();){
            MOB.deleteOffer((Offer) iterator.next());
        }

        // adding new entries
        Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Integer offId1 = MOA.addOffer(OffersContent.enterprise1, currentDate, new Date(formatter.parse(OffersContent.date1).getTime()), OffersContent.length1, OffersContent.activityField1, OffersContent.title1, OffersContent.areaCode1, OffersContent.location1, OffersContent.missionStatement1, OffersContent.pay1, OffersContent.details1, OffersContent.profile1, OffersContent.contactInformations1);
            Integer offId2 = MOA.addOffer(OffersContent.enterprise2, currentDate, new Date(formatter.parse(OffersContent.date2).getTime()), OffersContent.length2, OffersContent.activityField2, OffersContent.title2, OffersContent.areaCode2, OffersContent.location2, OffersContent.missionStatement2, OffersContent.pay2, OffersContent.details2, OffersContent.profile2, OffersContent.contactInformations2);
            Integer offId3 = MOA.addOffer(OffersContent.enterprise3, currentDate, new Date(formatter.parse(OffersContent.date3).getTime()), OffersContent.length3, OffersContent.activityField3, OffersContent.title3, OffersContent.areaCode3, OffersContent.location3, OffersContent.missionStatement3, OffersContent.pay3, OffersContent.details3, OffersContent.profile3, OffersContent.contactInformations3);
            Integer offId4 = MOA.addOffer(OffersContent.enterprise4, currentDate, new Date(formatter.parse(OffersContent.date4).getTime()), OffersContent.length4, OffersContent.activityField4, OffersContent.title4, OffersContent.areaCode4, OffersContent.location4, OffersContent.missionStatement4, OffersContent.pay4, OffersContent.details4, OffersContent.profile4, OffersContent.contactInformations4);
            Integer offId5 = MOB.addOffer(OffersContent.enterprise5, currentDate, new Date(formatter.parse(OffersContent.date5).getTime()), OffersContent.length5, OffersContent.activityField5, OffersContent.title5, OffersContent.areaCode5, OffersContent.location5, OffersContent.missionStatement5, OffersContent.pay5, OffersContent.details5, OffersContent.profile5, OffersContent.contactInformations5);
            Integer offId6 = MOB.addOffer(OffersContent.enterprise6, currentDate, new Date(formatter.parse(OffersContent.date6).getTime()), OffersContent.length6, OffersContent.activityField6, OffersContent.title6, OffersContent.areaCode6, OffersContent.location6, OffersContent.missionStatement6, OffersContent.pay6, OffersContent.details6, OffersContent.profile6, OffersContent.contactInformations6);
            Integer offId7 = MOB.addOffer(OffersContent.enterprise7, currentDate, new Date(formatter.parse(OffersContent.date7).getTime()), OffersContent.length7, OffersContent.activityField7, OffersContent.title7, OffersContent.areaCode7, OffersContent.location7, OffersContent.missionStatement7, OffersContent.pay7, OffersContent.details7, OffersContent.profile7, OffersContent.contactInformations7);
        } catch (ParseException ex) {
            Logger.getLogger(ManageOffer.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }

}