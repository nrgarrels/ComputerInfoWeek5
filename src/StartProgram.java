import java.util.List;
import java.util.Scanner;

import controller.ComputerHelper;
import model.Computers;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static ComputerHelper lih = new ComputerHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter Manufacturer: ");
		String manufacturer = in.nextLine();
		System.out.print("Enter the Type(Desktop/Laptop/etc): ");
		String type = in.nextLine();
		System.out.print("Enter the OS(Windows/Mac/Linux): ");
		String os = in.nextLine();
		Computers toAdd = new Computers(manufacturer, type, os);
		lih.insertItem(toAdd);

	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the Manufacturer to delete: ");
		String manufacturer = in.nextLine();
		System.out.print("Enter the Type to delete: ");
		String type = in.nextLine();
		System.out.print("Enter the OS to delete: ");
		String os = in.nextLine();
		Computers toDelete = new Computers(manufacturer, type, os);
		lih.deleteItem(toDelete);


	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Manufacturer");
		System.out.println("2 : Search by Type");
		System.out.println("3 : Search by OS");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Computers> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the Manufacturer: ");
			String manufacturerName = in.nextLine();
			foundItems = lih.searchForItemByManufacturer(manufacturerName);
			}else if(searchBy == 2){ 
				System.out.print("Enter the Type: ");
				String typeName = in.nextLine();
				foundItems = lih.searchForItemByType(typeName);
			} else {
			System.out.print("Enter the OS: ");
			String OSName = in.nextLine();
			foundItems = lih.searchForItemByOS(OSName);
			}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Computers l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Computers toEdit = lih.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getManufacturer() + " " + toEdit.getType() + " " +toEdit.getOs());
			System.out.println("1 : Update Manufacturer");
			System.out.println("2 : Update Type");
			System.out.println("3 : Update OS");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Manufacturer: ");
				String newManufacturer = in.nextLine();
				toEdit.setManufacturer(newManufacturer);
			} else if (update == 2) {
				System.out.print("New Type: ");
				String newType = in.nextLine();
				toEdit.setType(newType);
			}else if (update == 3) {
				System.out.print("New OS: ");
				String newOS = in.nextLine();
				toEdit.setOs(newOS);
				
			}

			lih.updateComputer(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome shopping list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an Computer");
			System.out.println("*  2 -- Edit an Computer");
			System.out.println("*  3 -- Delete an Computer");
			System.out.println("*  4 -- View the list of Computers");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<Computers> allItems = lih.showAllComputers();
		for(Computers singleItem : allItems){
		System.out.println(singleItem.toString());
		}
		

	}
}
