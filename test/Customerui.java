package com.db.test;

import java.util.List;
import java.util.Scanner;

import com.db.dao.CustomerDaoImpl;

public class Customerui {
	
	public static void main(String[] args) {

		boolean exit=false;
		int option=0;
		Scanner sc=new Scanner(System.in);
		Integer custId;
		String name;
		String address;
		Long contact;
		String password;
		String email;
		String choice;
		
		Customer c=null;
		CustomerDaoImpl cimpl=new CustomerDaoImpl();
		Boolean flag;
		List<Customer> clist=null;
		
		System.out.println("-------------------Welcome to Anudip The One Stop Shop------------------");
		while(exit==false) {
			
			System.out.println("Enter the options as given below:-");
			System.out.println("1------------> Insert customer");
			System.out.println("2------------> Update  customers");
			System.out.println("3------------> Show All customers");
			
			
			option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			case 1:
				System.out.print("Enter name of customer: ");
				name=sc.nextLine();
				
				System.out.print("Enter email of customer: ");
				email=sc.nextLine();
				
				System.out.print("Enter the permanent address of customer: ");
				address=sc.nextLine();
				
				System.out.print("Enter the contact of customer: ");
				contact=sc.nextLong();
				sc.nextLine();
				
				System.out.print("Enter the password: ");
				password=sc.nextLine();
				
				c=new Customer(name, email, address, contact, password);
				
				flag=cimpl.insertCustomer(c);
				
				if(flag)
					System.out.println("Customer inserted successfully!!!");
				else 
					System.out.println("Errror while inserting the customer !!!");
				
				break;

			case 2:
				clist=cimpl.showAllCustomers();
				if(clist!=null && clist.isEmpty()!=true) {
					
					for(Customer customer:clist) {
						System.out.println(customer.getname()+" : "+customer.getCustId());
						System.out.println("__________________________________\n");
					}
					System.out.print("Please enter the id of the customer to be updated: ");
					custId=sc.nextInt();
					sc.nextLine();
					
					c=cimpl.showCustomerById(custId);
					if(c!=null) {
						System.out.println(c);
						System.out.println("Enter yes or no based on if you want to update this customer");
						choice=sc.nextLine();
						if(choice.equalsIgnoreCase("yes")) {
							System.out.print("Enter name of customer: ");
							name=sc.nextLine();
							
							System.out.print("Enter email of customer: ");
							email=sc.nextLine();
							
							System.out.print("Enter the permanent address of customer: ");
							address=sc.nextLine();
							
							System.out.print("Enter the contact of customer: ");
							contact=sc.nextLong();
							sc.nextLine();
							
							System.out.print("Enter the password: ");
							password=sc.nextLine();
							
							
							c.setname(name);
							c.setEmail(email);
							c.setaddress(address);
							c.setContact(contact);
							c.setPassword(password);
							
							flag=cimpl.updateCustomer(c);
							if(flag)
								System.out.println("Customer updated successfully!!!");
							else
								System.out.println("Error while updating Customer!!!");
							
						}
						else if(choice.equalsIgnoreCase("no"))
							System.out.println("No issues.Continue browsing");
						else
							System.out.println("Please enter yes or no only!!!");
					}
					else
						System.out.println("No customer found by this id");
					
				}
				else 
					System.out.println("Unable to show customer at this moment!! Please try again later!!!");
				
				break;

				
			case 3:
				
			
				clist=cimpl.showAllCustomers();
				if(clist!=null && clist.isEmpty()!=true) {
					for(Customer customer:clist) {
						System.out.println(customer);
						System.out.println("__________________________________\n");
					}
				}
				else 
					System.out.println("Unable to show customer list at this moment!! Please try again later!!!");
				
				break;
				
				
	}

}
	}

}
