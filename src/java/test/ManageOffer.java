package test;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageOffer {

    public SessionFactory factory;

    public ManageOffer(){
       try{
           factory = new Configuration().configure("test/hibernate.cfg.xml").buildSessionFactory();
       }catch (Throwable ex) {
           System.err.println("Failed to create sessionFactory object." + ex);
           throw new ExceptionInInitializerError(ex);
       }
    }

    // CREATE
    public Integer addOffer(String t, String l, String m, String d, String p, String c){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer offerID = null;
      try{
         tx = session.beginTransaction();
         Offer offer = new Offer(t, l, m, d, p, c);
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
        ManageOffer MO = new ManageOffer();

        // adding an entry
        Integer offID1 = MO.addOffer("t1", "l1", "m1", "d1", "p1", "c1");
        Integer offID2 = MO.addOffer("t2", "l2", "m2", "d2", "p2", "c2");

        /*List offers = MO.listOffers();
        for (Iterator iterator = offers.iterator(); iterator.hasNext();){
            MO.deleteOffer((Offer) iterator.next());
            //System.out.println((Offer) iterator.next());
        }*/
    }

}