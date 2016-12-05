package test;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Iterator;

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
        ManageOffer MO1 = new ManageOffer(1);
        ManageOffer MO2 = new ManageOffer(2);
        
        List offers1 = MO1.listOffers();
        for (Iterator iterator = offers1.iterator(); iterator.hasNext();){
            MO1.deleteOffer((Offer) iterator.next());
        }
        List offers2 = MO2.listOffers();
        for (Iterator iterator = offers2.iterator(); iterator.hasNext();){
            MO2.deleteOffer((Offer) iterator.next());
        }

        // adding entries
        Date d = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        
        String enterprise1 = "Squadeo";
        String activityField1 = "Informatique";
        int length1a = 170;
        int length1b = 180;
        int areaCode1a = 31;
        int areaCode1b = 75;
        String title1a = "Evaluation of Watermarking Technologies";
        String title1b = "Developpement d'une solution 360° Video";
        String location1a = "Toulouse";
        String location1b = "Paris";
        String missionStatement1a = "A COMPLETER";
        String missionStatement1b = "A COMPLETER";
        int pay1a = 700;
        int pay1b = 600;
        String details1a = "A COMPLETER";
        String details1b = "A COMPLETER";
        String profile1a = "A COMPLETER";
        String profile1b = "A COMPLETER";
        String contactInformations1a = "Gérard Letard, 05 00 00 00 00";
        String contactInformations1b = "kevinlelin@laposte.fr";

        String enterprise2 = "Solvay";
        String activityField2 = "Chimie";
        int length2a = 160;
        int areaCode2a = 13;
        String title2a = "Développement de Charges Minérales Hautes Performances pour application plastique";
        String location2a = "Marseille";
        String missionStatement2a = "A COMPLETER";
        int pay2a = 800;
        String details2a = "A COMPLETER";
        String profile2a = "A COMPLETER";
        String contactInformations2a = "Envoyer CV à SOLVAY, SERVICE RECRUTEMENT, LA CAPITAINERIE, 8 RUE JAUBERT 13005 MARSEILLE";

        Integer off1aID = MO1.addOffer(enterprise1, d, d, length1a, activityField1, title1a, areaCode1a, location1a, missionStatement1a, pay1a, details1a, profile1a, contactInformations1a);
        Integer off1bID = MO1.addOffer(enterprise1, d, d, length1b, activityField1, title1b, areaCode1b, location1b, missionStatement1b, pay1b, details1b, profile1b, contactInformations1b);
        Integer off2aID = MO2.addOffer(enterprise2, d, d, length2a, activityField2, title2a, areaCode2a, location2a, missionStatement2a, pay2a, details2a, profile2a, contactInformations2a);
    }

}