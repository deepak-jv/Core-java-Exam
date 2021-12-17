package com.joshi.ph.service;

import java.sql.SQLException;
import java.util.*;

import com.joshi.ph.dao.UserDaoImpl;
import com.joshi.ph.dao.User_IF;
import com.joshi.ph.model.User;

class DuplicateNameException1 extends Exception {
	public DuplicateNameException1() {
		super();
	}
}

class DuplicateNumberException1 extends Exception {
	public DuplicateNumberException1() {
		super();
	}
}

public class Service_User {

	public static void main(String[] args) throws SQLException {
		
		

		System.out.println("=======================================================================");
		System.out.println("===================== Welcome To Phone Book ===========================");
		System.out.println("=======================================================================");
		System.out.println();
		
  while(true) {		
		
		


		// ====== getting data from browser/ui ====================

		int add = 1;
		int get = 2;
		int update = 3;
		int delete = 4;
		int fid = 5;
		int fname = 6;
		int fnum = 7;
		int exit = 8;

		UserDaoImpl uif = new UserDaoImpl();

		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the desired operations.");
		System.out.println();
		System.out.println("Enter 1 to add data into phone book");
		System.out.println("Enter 2 to get all the data from phone book");
		System.out.println("Enter 3 to update data in phone book");
		System.out.println("Enter 4 to delete data from phone book");
		System.out.println("Enter 5 to find data by its id from phone book");
		System.out.println("Enter 6 to find data by name from phone book");
		System.out.println("Enter 7 to find data by phone number from phone book");
		System.out.println("Enter 8 to close the phone book");
		int s1 = sc.nextInt();

		// ========================= Save data ================================

		if (s1==add) {
			User u = new User();

			try {
				System.out.println("Enter name");
				String name = sc.next();
				User_IF u2 = new UserDaoImpl();
				User us = u2.findByName(name);

				if (name.equals(us.getName())) {

					throw new DuplicateNameException1();
				}

				else {

					u.setName(name);

				}

				try {
					System.out.println("Enter phone number");
					int ph_no = sc.nextInt();
					User_IF u3 = new UserDaoImpl();
					User us1 = u2.findByNumber(ph_no);

					if (ph_no == us1.getPh_number()) {

						throw new DuplicateNumberException1();
					} else {

						u.setPh_number(ph_no);
						;

					}

					try {
						int flag = uif.save(u);
						if (flag > 0) {
							System.out.println("Data is saved successfully");
						} else {
							System.out.println("Data not Saved try again!");
						}

					} catch (SQLException e) {
						e.printStackTrace();
						break;
					}

				}

				catch (DuplicateNumberException1 dn) {
					System.out.println(dn + ": The phone number already exists, Try again!");
					continue;
				}
			}

			catch (DuplicateNameException1 dn) {
				System.out.println(dn + ": The name already exists, Try again!");

			}

		}

		// ======================= update data ===========================

		else if (s1 == update) {
			User u1 = new User();

			System.out.println("Enter id which you want to update");

			int i = sc.nextInt();
			try {
				System.out.println("Enter new name");
				String name = sc.next();
				User_IF u2 = new UserDaoImpl();
				User us = u2.findByName(name);

				if (name.equals(us.getName())) {

					throw new DuplicateNameException1();
				}

				else {

					us.setName(name);

				}

				try {
					System.out.println("Enter phone number");
					int ph_no = sc.nextInt();
					User_IF u3 = new UserDaoImpl();
					User us1 = u2.findByNumber(ph_no);

					if (ph_no == us1.getPh_number()) {

						throw new DuplicateNumberException1();
					} else {

						us1.setPh_number(ph_no);

					}

					u1.setId(i);
					u1.setName(name);
					u1.setPh_number(ph_no);

					try {
						int flag = uif.update(u1);
						if (flag > 0)
							System.out.println("Data updated successfully");
						else
							System.out.println("Something went wrong data not updated, try again!");
					}

					catch (SQLException e) {
						e.printStackTrace();
						break;
					}

				}

				catch (DuplicateNumberException1 dn) {
					System.out.println(dn + ": The phone number already exists, Try again!");
					break;
				}
			}

			catch (DuplicateNameException1 dn) {
				System.out.println(dn + ": The name already exists, Try again!");

			}

		}

		// ======================= find by id ===========================

		else if (s1 == fid) {

			System.out.println("Enter the id for getting the corresponding data");
			int gi = sc.nextInt();

			User_IF u2 = new UserDaoImpl();
			try {
				User us = u2.findById(gi);
				if (us.getName() != null) {
					System.out.println("the required result is");
					System.out.println("Id:\tName:\tPhone number: ");
					System.out.println(us.getId() + "\t" + us.getName() + "\t" + us.getPh_number());
				} else {
					System.out.println("Employee Id does not exist, try again!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// ==================== find by name ======================

		else if (s1 == fname) {

			System.out.println("Enter the name for getting the corresponding data");
			String gi = sc.next();

			User_IF u2 = new UserDaoImpl();
			try {
				User us = u2.findByName(gi);
				if (us.getName() != null) {
					System.out.println("the required result is");
					System.out.println("Id:\tName:\tPhone number: ");
					System.out.println(us.getId() + "\t" + us.getName() + "\t" + us.getPh_number());
				} else {
					System.out.println("Employee name does not exist, try again!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// ================ find by phone number ============================

		else if (s1 == fnum) {

			System.out.println("Enter the phone number for getting the corresponding data");
			int gi = sc.nextInt();

			User_IF u2 = new UserDaoImpl();
			try {
				User us = u2.findByNumber(gi);
				if (us.getName() != null) {
					System.out.println("the required result is");
					System.out.println("Id:\tName:\tPhone number: ");
					System.out.println(us.getId() + "\t" + us.getName() + "\t" + us.getPh_number());
				} else {
					System.out.println("Employee phone number does not exist, try again!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// ========================= get all =========================

		else if (s1 == get) {

			User_IF u2 = new UserDaoImpl();
			List<User> usr = u2.getall();

			System.out.println("Id:\tName:\tPhone number: ");
			for (User user : usr) {

				System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getPh_number());
			}
		}
		// ==================== delete data ===========================
		else if (s1 == delete) {

			System.out.println("Enter the id which you want to delete");
			int i = sc.nextInt();

			User u1 = new User();
			u1.setId(i);
			try {
				uif.delete(u1);
				if (u1.getId() == i)
					System.out.println("Data deleted successfully");
				else
					System.out.println("Something went wrong data not deleted, try again!");
			}

			catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (s1 == exit) {
			System.out.println(" Enter no if you don't want to do further any operation");
			
		}

		else {
			System.out.println("Given input is invalid, Try again!");
		}
		
		System.out.println("Do you want to do some more operations enter yes|no (case sensitive)");
		String opt = sc.next();
		if(opt.equals("yes")){
			
			continue;
			
		}
		
		else {
			
			System.out.println("Thanks for visiting !");
			break;
		}
		

	}
  
	}
}
