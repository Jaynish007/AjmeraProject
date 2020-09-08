/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
//
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
public class BankApp {
    public static void main(String[] args)
    {
      BankAccount obj=new BankAccount("Ajmera","007");
      obj.showMenu();
        
    }
}
class BankAccount{
    int balance1=1000,balance2=1000;
    int preTransaction;
    HashMap<String,Integer> mp1=new HashMap<>();
    HashMap<String,Integer> mp2=new HashMap<>();
    HashMap<String,Integer> mp3=new HashMap<>();
    HashMap<String,Integer> mp4=new HashMap<>();
    ArrayList<Integer>l1=new ArrayList();
    ArrayList<Integer>l2=new ArrayList();
    ArrayList<Integer>l3=new ArrayList();
    ArrayList<Integer>l4=new ArrayList();
    
    String cName;
    String cId;
    BankAccount(String cname,String cid)
    {
        cName=cname;
        cId=cid;
    }
    void depositSaving(int amount)
    {
        if(amount!=0)
        {
            balance1=balance1+amount;
            preTransaction=amount;
        }
    }
    void depositChecking(int amount)
    {
        if(amount!=0)
        {
            balance2=balance2+amount;
            preTransaction=amount;
        }
    }
    void withdrawSaving(int amount)
    {
        if(amount!=0)
        {
            balance1=balance1-amount;
            preTransaction=-amount;
        }
    }
    void withdrawChecking(int amount)
    {
        if(amount!=0)
        {
            balance2=balance2-amount;
            preTransaction=-amount;
        }
    }
    void getPrevTransactionSaving()
    {
        if(preTransaction>0)
        {
            mp1.put("Deposited::::",preTransaction);
            mp3.put("Deposited::::",preTransaction);
            l1.add(preTransaction);
            l3.add(preTransaction);
            System.out.println("Deposited::::"+preTransaction);
        }else if(preTransaction<0){
            mp1.put("Withdraw::::",preTransaction);
            mp4.put("Withdraw::::",preTransaction);
            l1.add(preTransaction);
            l4.add(preTransaction);
            System.out.println("Withdraw::::"+Math.abs(preTransaction));
        }else
        {
            System.out.println("No transaction");
        }
    }
    void getPrevTransactionChecking()
    {
        if(preTransaction>0)
        {
            mp2.put("Deposited::::",preTransaction);
            mp3.put("Deposited::::",preTransaction);
            l2.add(preTransaction);
            l3.add(preTransaction);
            System.out.println("Deposited::::"+preTransaction);
        }else if(preTransaction<0){
            mp2.put("Withdraw::::",preTransaction);
            mp4.put("Withdraw::::",preTransaction);
            l2.add(preTransaction);
            l4.add(preTransaction);
            System.out.println("Withdraw::::"+Math.abs(preTransaction));
        }else
        {
            System.out.println("No transaction");
        }
    }
    void showMenu()
    {
        char op='\0';
        int flag;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome "+cName);
        System.out.println("Your Id is "+cId);
        do{
         System.out.println("Enter Account type ");
         System.out.println("1.Saving");
         System.out.println("2.Checking");
         System.out.println("3.Exit");
        flag=scanner.nextInt();
        if(flag==3)break;
        System.out.println("A.Check Balance");
        System.out.println("B.Deposit");
        System.out.println("C.withdraw");
        System.out.println("D.previous Transaction");
        System.out.println("E.Exit");
        do{
            System.out.println("Enter an Option::");
            if(flag==1)
            {
                System.out.println("Balance="+balance1);
            }else 
            {
                System.out.println("Balance="+balance2);
            }
            System.out.println("\n");
            op=scanner.next().charAt(0);
            System.out.println("\n");
            switch(op)
            {
                
                case 'A':
                    System.out.println("##################################");
                    if(flag==1)
                    {
                        System.out.println("Balance="+balance1);
                    }else
                    {
                        System.out.println("Balance="+balance2);
                    }
                    System.out.println("##################################");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("##################################");
                    System.out.println("Enter Amount to deposit");
                    System.out.println("##################################");
                    int amount=scanner.nextInt();
                    if(flag==1)
                    {
                        depositSaving(amount);
                        getPrevTransactionSaving();
                    }else
                    {
                        depositChecking(amount);
                        getPrevTransactionChecking();
                    }
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("##################################");
                    System.out.println("Enter Amount to withdraw");
                    System.out.println("##################################");
                    int amount2=scanner.nextInt();
                    if(flag==1)
                    {
                        withdrawSaving(amount2);
                        getPrevTransactionSaving();
                    }else
                    {
                        withdrawSaving(amount2);
                        getPrevTransactionChecking();
                    }
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("##################################");
                     if(flag==1)
                    {
                        getPrevTransactionSaving();
                    }else
                    {
                        getPrevTransactionChecking();
                    }
                    //getPrevTransaction();
                    System.out.println("##################################");
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("##################################");
                    break;
                default:
                    System.out.println("Invalid Option Please enter again");
                    break;
                   
            }
        
        }while(op!='E');
        
       
       
        }while(flag!=3);
        System.out.println("First Trasaction of Saving");
       System.out.println(mp1);
       System.out.println("All the Trasaction of Saving");
       System.out.println(l1);
       System.out.println("First the Trasaction of Checking");
       System.out.println(mp2);
       System.out.println("All the Trasaction of Checking");
       System.out.println(l2);
       System.out.println("First the Trasaction of Deposit:::");
       System.out.println(mp3);
       System.out.println("All the Trasaction of Deposit:::");
       System.out.println(l3);
       System.out.println("First the Trasaction of Withdraw:::");
       System.out.println(mp4);
       System.out.println("All the Trasaction of Withdraw:::");
       System.out.println(l4);
       
       System.out.println("Final Balance of Saving");
        System.out.println(balance1);
       System.out.println("Final Balance of Checking");
        System.out.println(balance2);
    }
}
