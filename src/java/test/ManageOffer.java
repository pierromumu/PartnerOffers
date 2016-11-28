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
        Integer off1ID = MO1.addOffer("en1", d, d, 0, "af1", "ti1", 0, "lo1", "ms1", 0, "de1", "pr1", "ci1");
        Integer off2ID = MO2.addOffer("en2", d, d, 0, "af2", "ti2", 0, "lo2", "ms2", 0, "de2", "pr2", "ci2");
    }

}