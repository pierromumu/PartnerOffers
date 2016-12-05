package test;

import java.util.*;

public class SortedOffersList {

    private List<Offer> l;
    private List<Offer> backup;

    public List<Offer> getOffers(){
        return l;
    }

    public void restoreBackupList(){
        l = new ArrayList<Offer>(backup);
    }

    public void saveListAsBackup(){
        backup = new ArrayList<Offer>(l);
    }

    public SortedOffersList(){}
    public SortedOffersList(List<Offer> paramList){
        this.l = new ArrayList<Offer>(paramList);
        this.backup = new ArrayList<Offer>(paramList);
    }

    public void filterListByEnterprise(String paramE){
        if(!(l.isEmpty())){
            List<Offer> result = new ArrayList<Offer>();
            for (Iterator<Offer> i = l.iterator(); i.hasNext(); ) {
                Offer o = i.next();
                if(o.getEnterprise().equals(paramE)){
                    result.add(o);
                }
            }
            l = result;
        }
    }
    
    public void filterListByDateBeginningBefore(Date paramDB){
        if(!(l.isEmpty())){
            List<Offer> result = new ArrayList<Offer>();
            for (Iterator<Offer> i = l.iterator(); i.hasNext(); ) {
                Offer o = i.next();
                if(o.getDateBeginning().before(paramDB)){
                    result.add(o);
                }
            }
            l = result;
        }
    }

    public void filterListByLengthAfter(int paramL){
        if(!(l.isEmpty())){
            List<Offer> result = new ArrayList<Offer>();
            for (Iterator<Offer> i = l.iterator(); i.hasNext(); ) {
                Offer o = i.next();
                if(o.getLength()>=paramL){
                    result.add(o);
                }
            }
            l = result;
        }
    }

    public void filterListByActivityField(String paramAF){
        if(!(l.isEmpty())){
            List<Offer> result = new ArrayList<Offer>();
            for (Iterator<Offer> i = l.iterator(); i.hasNext(); ) {
                Offer o = i.next();
                if(o.getActivityField().equals(paramAF)){
                    result.add(o);
                }
            }
            l = result;
        }
    }

    public void filterListByAreaCode(int paramAC){
        if(!(l.isEmpty())){
            List<Offer> result = new ArrayList<Offer>();
            for (Iterator<Offer> i = l.iterator(); i.hasNext(); ) {
                Offer o = i.next();
                if(o.getAreaCode()==paramAC){
                    result.add(o);
                }
            }
            l = result;
        }
    }

    public void filterListByPayAfter(int paramP){
        if(!(l.isEmpty())){
            List<Offer> result = new ArrayList<Offer>();
            for (Iterator<Offer> i = l.iterator(); i.hasNext(); ) {
                Offer o = i.next();
                if(o.getPay()>=paramP){
                    result.add(o);
                }
            }
            l = result;
        }
    }

    public void filterListByKeywords(String[] paramK){
        if(!(l.isEmpty())){
            List<Offer> result = new ArrayList<Offer>();
            for (Iterator<Offer> i = l.iterator(); i.hasNext(); ) {
                Offer o = i.next();
                String text = o.getTitle()+o.getMissionStatement()+o.getDetails();
                Boolean add = true;
                for(String t : paramK){
                    if(!(text.contains(t))){
                        add = false;
                    }
                }
                if(add){
                    result.add(o);
                }
                
            }
            l = result;
        }
    }

    public void sortListByDateBeginning(){
        Collections.sort(l, new Comparator<Offer>(){
            public int compare(Offer one, Offer two) {
                int c;
                if(one.getDateBeginning().before(two.getDateBeginning())){
                    c = -1;
                } else if(one.getDateBeginning().after(two.getDateBeginning())) {
                    c = 1;
                } else {
                    c = 0;
                }
                return c;
            }
        });
    }

    public void sortListByDateCreation(){
        Collections.sort(l, new Comparator<Offer>(){
            public int compare(Offer one, Offer two) {
                int c;
                if(one.getDateCreation().before(two.getDateCreation())){
                    c = -1;
                } else if(one.getDateCreation().after(two.getDateCreation())) {
                    c = 1;
                } else {
                    c = 0;
                }
                return c;
            }
        });
    }

    public void sortListByPay(){
        Collections.sort(l, new Comparator<Offer>(){
            public int compare(Offer one, Offer two) {
                int c;
                if(one.getPay()<two.getPay()){
                    c = -1;
                } else if(one.getPay()>two.getPay()) {
                    c = 1;
                } else {
                    c = 0;
                }
                return c;
            }
        });
    }
}
