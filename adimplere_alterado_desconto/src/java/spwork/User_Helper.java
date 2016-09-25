/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vinic
 */
public class User_Helper {
    Session session = null;
 
    public User_Helper() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
  
    public boolean Test_User_From_Email(String email,boolean ok)
    {
        Transaction tx = null;
        User002 user =  new User002();
      try{
           // tx = session.beginTransaction();
         //Make an HQL query to get the results from books table . You can also use SQL here.
          tx=session.beginTransaction();
         List user_list = session.createQuery("FROM User002").list();
         //Iterate over the result and print it.
         for (Iterator iterator =
                           user_list.iterator(); iterator.hasNext();){
             
                                    user = (User002) iterator.next(); 
                                    if(ok){
                                        if((user.getEmail002()).equalsIgnoreCase(email) && user.getIndSit002()==1)
                                        return true;
                                    }
                                    else
                                    {
                                        if((user.getEmail002()).equalsIgnoreCase(email))
                                        return true ;
                                    }
           
         }
         tx.commit();
         session.close();
      }catch (HibernateException e) {
         e.printStackTrace();
      }
      
        
        return false;
    }
    
     public List <User002> List_User_From_Email(String email,boolean ok)
    {
        User002 user =  new User002();
        Transaction tx = null;
        List <User002> user_ans = new ArrayList <User002>();
      try{
         //Make an HQL query to get the results from books table . You can also use SQL here.
         tx=session.beginTransaction();
         List user_list = session.createQuery("FROM User002").list();
         
         //Iterate over the result and print it.
         for (Iterator iterator =
                           user_list.iterator(); iterator.hasNext();){
             
                                    user = (User002) iterator.next();  
                                     if(ok){
                                        if((user.getEmail002()).equalsIgnoreCase(email) && user.getIndSit002()==1)
                                         user_ans.add(user);
                                    }
                                    else
                                    {
                                        if((user.getEmail002()).equalsIgnoreCase(email))
                                         user_ans.add(user) ;
                                    }
                                   
           
         }
         tx.commit();
         session.close();
      }catch (HibernateException e) {
        e.printStackTrace();
      }
        
        return user_ans;
    }
      public List <User002> List_User_From_CPF(String cpf,boolean ok)
    {
        int a = 0;
        User002 user =  new User002();
        Transaction tx = null;
        List <User002> user_ans = new ArrayList <User002>();
      try{
         //Make an HQL query to get the results from books table . You can also use SQL here.
          tx = session.beginTransaction();
         List user_list = session.createQuery("FROM User002").list();
         
         //Iterate over the result and print it.
         for (Iterator iterator =
                           user_list.iterator(); iterator.hasNext();){
             
                                    user = (User002) iterator.next(); 
                                     if(ok){
                                        if((user.getCpf002()).equals(cpf) && user.getIndSit002()==1)
                                         user_ans.add(user);
                                    }
                                    else
                                    {
                                        if((user.getCpf002()).equals(cpf))
                                         user_ans.add(user) ;
                                    }
                                    a = 1;
                                  
           
         }
         tx.commit();
         session.close();
      }catch (HibernateException e) {
        e.printStackTrace();
      }
        
        return user_ans;
    }
       public boolean Test_User_From_CPF(String cpf,boolean ok)
    {
        User002 user =  new User002();
        Transaction tx = null;
      try{
         //Make an HQL query to get the results from books table . You can also use SQL here.
         tx=session.beginTransaction();
         List user_list = session.createQuery("FROM User002").list();
         //Iterate over the result and print it.
         for (Iterator iterator =
                           user_list.iterator(); iterator.hasNext();){
             
                                    user = (User002) iterator.next();  
                                     if(ok){
                                        if((user.getCpf002()).equals(cpf) && user.getIndSit002()==1)
                                         return true;
                                    }
                                    else
                                    {
                                        if((user.getCpf002()).equals(cpf))
                                         return true;
                                    }
                                    
           
         }
         tx.commit();
         session.close();
      }catch (HibernateException e) {
        e.printStackTrace();
      }
        
        return false;
    }
    
     public boolean Test_Payments_Boleto(String tkey)
    {
        Boleto003 boleto =  new Boleto003();
        Transaction tx = null;
      try{
         //Make an HQL query to get the results from books table . You can also use SQL here.
         tx=session.beginTransaction();
         List boleto_list = session.createQuery("FROM Boleto003").list();
         //Iterate over the result and print it.
         for (Iterator iterator =
                           boleto_list.iterator(); iterator.hasNext();){
             
                                    boleto = (Boleto003) iterator.next();  
                                    if(tkey.equals(boleto.getTransactionKey003()))
                                    return true;
           
         }
         tx.commit();
         session.close();
      }catch (HibernateException e) {
        e.printStackTrace();
      }
        
        return false;
    }
     public Boleto003 Search_Payments_Boleto(String tkey)
    {
        Boleto003 boleto =  new Boleto003();
        Boleto003 boleto_aux =  new Boleto003();
        Transaction tx = null;
      try{
         //Make an HQL query to get the results from books table . You can also use SQL here.
         tx=session.beginTransaction();
         List boleto_list = session.createQuery("FROM Boleto003").list();
         //Iterate over the result and print it.
         for (Iterator iterator =
                           boleto_list.iterator(); iterator.hasNext();){
             
                                    boleto = (Boleto003) iterator.next();  
                                    if(tkey.equals(boleto.getTransactionKey003()))
                                    return boleto;
           
         }
         tx.commit();
         session.close();
      }catch (HibernateException e) {
        e.printStackTrace();
      }
        
        return boleto_aux;
    }
     
     public boolean Test_Payments_Credit_Card(String tkey)
    {
        Transaction tx = null;
        CreditCard004 CreditCard =  new CreditCard004();
      try{
          tx=session.beginTransaction();
         //Make an HQL query to get the results from books table . You can also use SQL here.
         List CreditCard_list = session.createQuery("FROM CreditCard004").list();
         //Iterate over the result and print it.
         for (Iterator iterator =
                           CreditCard_list.iterator(); iterator.hasNext();){
             
                                    CreditCard = (CreditCard004) iterator.next();  
                                    if(tkey.equalsIgnoreCase(CreditCard.getTransactionKey004()))
                                    return true;
           
         }
         tx.commit();
         session.close();
      }catch (HibernateException e) {
        e.printStackTrace();
      }
        
        return false;
    }
       
          
       
        public void AddBoleto(Boleto003 boleto)
    {
       Transaction tx = null;
      try{
         tx=session.beginTransaction();
         session.save(boleto);
         tx.commit();
         session.close();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        
        
       
    }
          public CreditCard004 Search_Credit_Card_Transaction(String transaction_key){
            CreditCard004 CreditCard =  new CreditCard004();
            CreditCard004 CreditCard_ans =  new CreditCard004();
            Transaction tx = null;
            try{
                //Make an HQL query to get the results from books table . You can also use SQL here.
                tx = session.beginTransaction();
                List CreditCard_list = session.createQuery("FROM CreditCard004").list();
                //Iterate over the result and print it.
                for (Iterator iterator =
                           CreditCard_list.iterator(); iterator.hasNext();){
             
                                    CreditCard = (CreditCard004) iterator.next();  
                                    if(transaction_key.equalsIgnoreCase(CreditCard.getTransactionKey004()))
                                    return CreditCard;
           
            }
            tx.commit();
            session.close();
            }catch (HibernateException e) {
                e.printStackTrace();
            }
        
            return CreditCard_ans;
        }
          public Boleto003 Search_Boleto_From_Cod_Boleto(String id){
            Boleto003 boleto =  new Boleto003();
            Boleto003 boleto_ans =  new Boleto003();
            Transaction tx = null;
            try{
                //Make an HQL query to get the results from books table . You can also use SQL here.
                tx = session.beginTransaction();
                List CreditCard_list = session.createQuery("FROM Boleto003").list();
                //Iterate over the result and print it.
                for (Iterator iterator =
                           CreditCard_list.iterator(); iterator.hasNext();){
             
                                    boleto = (Boleto003) iterator.next();  
                                    if(Long.parseLong(id) == (boleto.getCodInstc003()))
                                    return boleto;
           
            }
            tx.commit();
            session.close();
            }catch (HibernateException e) {
                e.printStackTrace();
            }
        
            return boleto_ans;
        }
          public Boleto003 Search_Boleto_From_Cod_User(long cod_instc_user){
            Boleto003 boleto =  new Boleto003();
            Boleto003 boleto_ans =  new Boleto003();
            Transaction tx = null;
            try{
                //Make an HQL query to get the results from books table . You can also use SQL here.
                tx = session.beginTransaction();
                List CreditCard_list = session.createQuery("FROM Boleto003").list();
                //Iterate over the result and print it.
                for (Iterator iterator =
                           CreditCard_list.iterator(); iterator.hasNext();){
             
                                    boleto = (Boleto003) iterator.next();  
                                    if(cod_instc_user == (boleto.getCodInstcUser003()))
                                    return boleto;
           
            }
            tx.commit();
            session.close();
            }catch (HibernateException e) {
                e.printStackTrace();
            }
        
            return boleto_ans;
        }
          public Boolean Test_Boleto_From_Cod_User(long cod_instc_user){
            Boleto003 boleto =  new Boleto003();
            
            Transaction tx = null;
            try{
                //Make an HQL query to get the results from books table . You can also use SQL here.
                tx = session.beginTransaction();
                List CreditCard_list = session.createQuery("FROM Boleto003").list();
                //Iterate over the result and print it.
                for (Iterator iterator =
                           CreditCard_list.iterator(); iterator.hasNext();){
             
                                    boleto = (Boleto003) iterator.next();  
                                    if(cod_instc_user == (boleto.getCodInstcUser003()))
                                    return true;
           
            }
            tx.commit();
            session.close();
            }catch (HibernateException e) {
                e.printStackTrace();
            }
        
            return false;
        }
         public boolean Test_Credit_Card_Transaction(String transaction_key){
            CreditCard004 CreditCard =  new CreditCard004();
            CreditCard004 CreditCard_ans =  new CreditCard004();
            Transaction tx = null;
            try{
                //Make an HQL query to get the results from books table . You can also use SQL here.
                tx = session.beginTransaction();
                List CreditCard_list = session.createQuery("FROM CreditCard004").list();
                //Iterate over the result and print it.
                for (Iterator iterator =
                           CreditCard_list.iterator(); iterator.hasNext();){
             
                                    CreditCard = (CreditCard004) iterator.next();  
                                    if(transaction_key.equalsIgnoreCase(CreditCard.getTransactionKey004()))
                                    return true;
           
            }
            tx.commit();
            session.close();
            }catch (HibernateException e) {
                e.printStackTrace();
            }
        
            return false;
        }  
        public CreditCard004 Search_Credit_Card_Transaction_From_User(Long cod_instc_user){
            CreditCard004 CreditCard =  new CreditCard004();
            CreditCard004 CreditCard_ans =  new CreditCard004();
            Transaction tx = null;
            try{
                //Make an HQL query to get the results from books table . You can also use SQL here.
                tx = session.beginTransaction();
                List CreditCard_list = session.createQuery("FROM CreditCard004").list();
                //Iterate over the result and print it.
                for (Iterator iterator =
                           CreditCard_list.iterator(); iterator.hasNext();){
             
                                    CreditCard = (CreditCard004) iterator.next();  
                                    if(cod_instc_user == CreditCard.getCodInstcUser004())
                                    return CreditCard;
           
            }
            
            }catch (HibernateException e) {
                e.printStackTrace();
            }
            tx.commit();
            session.close();
            return CreditCard_ans;
        }
        public boolean Test_Credit_Card_Transaction_From_User(Long cod_instc_user){
            CreditCard004 CreditCard =  new CreditCard004();
            CreditCard004 CreditCard_ans =  new CreditCard004();
            Transaction tx = null;
            try{
                //Make an HQL query to get the results from books table . You can also use SQL here.
                tx = session.beginTransaction();
                List CreditCard_list = session.createQuery("FROM CreditCard004").list();
                //Iterate over the result and print it.
                for (Iterator iterator =
                           CreditCard_list.iterator(); iterator.hasNext();){
             
                                    CreditCard = (CreditCard004) iterator.next();  
                                    if(cod_instc_user == CreditCard.getCodInstcUser004())
                                    {
                                         tx.commit();
                                         session.close();
                                         return true;
                                    }
                                    
           
            }
            
            }catch (HibernateException e) {
                e.printStackTrace();
            }
                tx.commit();
                session.close();
            return false;
        }
         public List <User002> Search_User_From_Cod_User(String cod_instc_user){
            User002 User =  new User002();
            User002 User_ans =  new User002();
            List <User002> user_list_ans =  new ArrayList();
            Transaction tx = null;
            try{
                //Make an HQL query to get the results from books table . You can also use SQL here.
                tx = session.beginTransaction();
                List User_list = session.createQuery("FROM User002").list();
                //Iterate over the result and print it.
                for (Iterator iterator =
                           User_list.iterator(); iterator.hasNext();){
             
                                    User = (User002) iterator.next();  
                                    if(cod_instc_user.equals(User.getCodInstc002().toString()))
                                    {
                                         
                                         user_list_ans.add(User);
                                    }
                                    
           
            }
            
            }catch (HibernateException e) {
                e.printStackTrace();
            }
                tx.commit();
                session.close();
            return user_list_ans;
        }
         
          public Client001 Search_Client_From_Cod_Client(Long cod_instc_clint){
            Client001 Client =  new Client001();
            Transaction tx = null;
            try{
                //Make an HQL query to get the results from books table . You can also use SQL here.
                tx = session.beginTransaction();
                List User_list = session.createQuery("FROM Client001").list();
                //Iterate over the result and print it.
                for (Iterator iterator =
                           User_list.iterator(); iterator.hasNext();){
             
                                    Client = (Client001) iterator.next();  
                                    if(cod_instc_clint == Client.getCodInstc001())
                                    {
                                         tx.commit();
                                         session.close();
                                         return Client;
                                    }
                                    
           
            }
            
            }catch (HibernateException e) {
                e.printStackTrace();
            }
                tx.commit();
                session.close();
            return null;
        }
         public void AddCreditCard(CreditCard004 cc){
            Transaction tx=null;
            try{
                tx=session.beginTransaction();
                
                session.save(cc);
                tx.commit();
                session.close();
               
         
            } catch (RuntimeException e) {
                if (tx != null) {
                tx.rollback();
               
                
            }
           
        }
           
       
       
        
    
}
        public void Update_User(User002 user){
            Transaction tx=null;
            try{
                tx=session.beginTransaction();
                
                session.update(user);
                tx.commit();
                session.close();
               
         
            } catch (RuntimeException e) {
                if (tx != null) {
                tx.rollback();
               
                
            }
           
        }
    }
    public void Update_Boleto(Boleto003 boleto){
            Transaction tx=null;
            try{
                tx=session.beginTransaction();
                
                session.update(boleto);
                tx.commit();
                session.close();
               
         
            } catch (RuntimeException e) {
                if (tx != null) {
                tx.rollback();
               
                
            }
           
        }
    } 
    public void Update_Credi_Card(CreditCard004 cc){
            Transaction tx=null;
            try{
                tx=session.beginTransaction();
                
                session.update(cc);
                tx.commit();
                session.close();
               
         
            } catch (RuntimeException e) {
                if (tx != null) {
                tx.rollback();
               
                
            }
           
        }
    } 
        
        
}
         

