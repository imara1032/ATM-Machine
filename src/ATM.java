/**
 * 
 * Title: ATM.java
 * It is a ATM machine, has only 10 members (User). those users are 
 * stored in an array. ATM machine allowed users to deposit, withdraw, and 
 * transfer money.   
 * Author:Imara Dharmakirthi
 * Date: 02/13/15
 *
 */
import java.text.*;
public class ATM {
private String BankName;
private String Location;
private double balance;
private int serialNum;
private int withdrawal,withdrawalFail,deposit,depositFail,transfer, tansferFail;
User[] bankMembers;

ATM(){balance=100.00;
bankMembers=new User[10];
bankMembers[0]= new User("Alice", 1234, 5000.00);
bankMembers[1]= new User("Tom", 2000, 200.00);
bankMembers[2]= new User("Monica", 3000, 50.00);
bankMembers[3]= new User("Michael", 7777, 0.00);
bankMembers[4]= new User("John", 8000, 500.00);
bankMembers[5]= new User("Jane", 2222, 500.00);
bankMembers[6]= new User("Robert", 2323, 200.00);
bankMembers[7]= new User("Owen", 4455, 50.00);
bankMembers[8]= new User("Chris", 8787, 10.00);
bankMembers[9]= new User("Rebecca", 8080, 555.55);
withdrawal=0;
deposit=0;
transfer=0;
withdrawalFail=0;
depositFail=0;
tansferFail=0;
}
ATM (String aName)
{
BankName=aName;	
balance=100.00;
bankMembers=new User[10];
bankMembers[0]= new User("Alice", 1234, 5000.00);
bankMembers[1]= new User("Tom", 2000, 200.00);
bankMembers[2]= new User("Monica", 3000, 50.00);
bankMembers[3]= new User("Michael", 7777, 0.00);
bankMembers[4]= new User("John", 8000, 500.00);
bankMembers[5]= new User("Jane", 2222, 500.00);
bankMembers[6]= new User("Robert", 2323, 200.00);
bankMembers[7]= new User("Owen", 4455, 50.00);
bankMembers[8]= new User("Chris", 8787, 10.00);
bankMembers[9]= new User("Rebecca", 8080, 555.55);
withdrawal=0;
deposit=0;
transfer=0;
withdrawalFail=0;
depositFail=0;
tansferFail=0;
}
ATM (int aSerial, String aBankName, String aLocation)
{
BankName=aBankName;
Location=aLocation;
serialNum=aSerial;
balance=100.00;
bankMembers=new User[10];
bankMembers[0]= new User("Alice", 1234, 5000.00);
bankMembers[1]= new User("Tom", 2000, 200.00);
bankMembers[2]= new User("Monica", 3000, 50.00);
bankMembers[3]= new User("Michael", 7777, 0.00);
bankMembers[4]= new User("John", 8000, 500.00);
bankMembers[5]= new User("Jane", 2222, 500.00);
bankMembers[6]= new User("Robert", 2323, 200.00);
bankMembers[7]= new User("Owen", 4455, 50.00);
bankMembers[8]= new User("Chris", 8787, 10.00);
bankMembers[9]= new User("Rebecca", 8080, 555.55);
withdrawal=0;
deposit=0;
transfer=0;
withdrawalFail=0;
depositFail=0;
tansferFail=0;
}
public String toString(){
	NumberFormat format= NumberFormat.getCurrencyInstance();
	String bankdeta="Serial Number: "+ this.serialNum +"\n" +
			"Bank Name: "+ this.BankName +"\n"+
			"Location: "+ this.Location + "\n"+
			"Balance: "+ format.format(this.balance);
	return bankdeta;
}
public boolean equals(ATM temp){
if(this.serialNum== temp.serialNum && this.BankName.equals(temp.BankName) && this.Location.equals(temp.Location) && this.balance==temp.balance ){
	return true;} else{return false;}
}
public void setATM(int aSerial, String aLocation){
	serialNum=aSerial;
	Location= aLocation;
}
public void addFund(double addBalance){
	balance=balance + addBalance;
}
public void displayMenu(){
	System.out.println("===== ATM Transaction Menu =====");
	System.out.print("1. Withdrawal\n" + "2. Deposit\n"+ "3. Transfer\n");
}
public void withdrawal(String aName, int aPin, double amount){
	NumberFormat format= NumberFormat.getCurrencyInstance();
	boolean FailWithd=true;
	for(int i=0; i<bankMembers.length; i++){
		if((bankMembers[i].UserName).equals(aName) && bankMembers[i].Pin== aPin && bankMembers[i].UserBalance >= amount && balance>= amount){
			bankMembers[i].UserBalance =bankMembers[i].UserBalance -amount;
			System.out.println("Succeed – withdrawal: "+ bankMembers[i].UserName  +" new balance: "+ format.format(bankMembers[i].UserBalance));
			balance= balance -amount;
			withdrawal++;
			FailWithd=false;}
	}
	if(FailWithd){System.out.println("Fail – withdrawal"); withdrawalFail++;}
	
}

public void deposit(String aName, int aPin, double amount){
	NumberFormat format= NumberFormat.getCurrencyInstance();
	boolean Fail=true;
	for(int i=0; i<bankMembers.length; i++){
		if((bankMembers[i].UserName).equals(aName) && bankMembers[i].Pin== aPin && bankMembers[i].UserBalance>=amount){
			bankMembers[i].UserBalance =bankMembers[i].UserBalance +amount;
			System.out.println("Succeed – deposit: "+ bankMembers[i].UserName  +" new balance: "+ format.format(bankMembers[i].UserBalance) );
			balance= balance +amount;
			deposit++;
			Fail=false;
		}
	}
		if(Fail){System.out.println("Fail – deposit"); depositFail++;}
}

public void status(){
	NumberFormat format= NumberFormat.getCurrencyInstance();
	System.out.println("Serial Number: "+ serialNum +"\nBank Name: "+ BankName +"\nLocation: "+ Location + "\nBalance: "+ format.format(balance));
	
	int totalTrans=withdrawal+deposit+transfer+withdrawalFail+depositFail+ tansferFail ;
	System.out.println(totalTrans+" Transactions so far:");
	System.out.println("    Withdrawal: "+(withdrawal+ withdrawalFail)+" ("+withdrawal+" success, "+ withdrawalFail+ " fail)");
	System.out.println("    Deposit: "+(deposit+ depositFail)+" ("+deposit+" success, "+depositFail + " fail)");
	System.out.println("    Transfer: "+(transfer+ tansferFail)+" ("+transfer+" success, "+ tansferFail+ " fail)");
}
public void transfer(String sender, int tranferPin, double amount, String reciver, int reciPin){
	NumberFormat format= NumberFormat.getCurrencyInstance();
	boolean TranferAccount=false;
	boolean reciverAccount=false;
	int senderPin=0;
	int reciverPin=0;
	for(int i=0; i<bankMembers.length; i++){
		if((bankMembers[i].UserName).equals(sender) && bankMembers[i].Pin== tranferPin && bankMembers[i].UserBalance>= amount){
			TranferAccount=true; senderPin=i;
		}
		if((bankMembers[i].UserName).equals(reciver) && bankMembers[i].Pin== reciPin){reciverAccount=true; reciverPin=i;}
}
	if(reciverAccount && TranferAccount){
		bankMembers[senderPin].UserBalance=bankMembers[senderPin].UserBalance -amount;
		bankMembers[reciverPin].UserBalance=bankMembers[reciverPin].UserBalance +amount;
		transfer++;
		System.out.println("Succeed – transfer: "+bankMembers[senderPin].UserName+"new balance: "+format.format(bankMembers[senderPin].UserBalance)+", "+bankMembers[reciverPin].UserName+" new balance: "+format.format(bankMembers[reciverPin].UserBalance));
	}else{System.out.println("Fail – Transfer");tansferFail++;}
}
public class User
{
	private String UserName;
	private int Pin;
	private double UserBalance;
	User(){}
	User(String aName, int aPin, double aBalance){
		UserName=aName;
		Pin= aPin;
		UserBalance=aBalance;
	}
	
	}
}
