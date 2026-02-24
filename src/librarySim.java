import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class librarySim{
	public static void main(String[] args){
		libraryMenu ui = new libraryMenu(utility.generate());
		ui.start();
	}
}

class book{
	private double callNumber; //dewey decimal system instead of isbn
	private String author;
	private String title; 
	private boolean isCheckedOut;

	//constructors
	public book(){
		callNumber = 0;
		author = "author";
		title = "title";
		isCheckedOut = false;

	}
	public book(double myCallNumber, String myAuthor, String myTitle, boolean amCheckedOut){
		callNumber = myCallNumber;
		author = myAuthor;
		title = myTitle;
		isCheckedOut = amCheckedOut;
	}

	public book(book b){
		this(b.callNumber, b.author, b.title, b.isCheckedOut);
	}

	//setters
	public void setCallNumber(double nCallNum){
		callNumber = nCallNum;
	}
	public void setAuthor(String nAuthor){
		author = nAuthor;
	}
	public void setTitle(String nTitle){
		title = nTitle;
	}
	public void setIsCheckedOut(boolean nCheckedOut){
		isCheckedOut = nCheckedOut;
	}
	//getters
	public double getCallNumber(){
		return callNumber;
	}
	public String getAuthor(){
		return author;
	}
	public String getTitle(){
		return title;
	}
	public boolean getIsCheckedOut(){
		return isCheckedOut;
	}
	//toString
	public String toString(){
		return title + " by " + author + " | Is checked out: " + isCheckedOut + " | Call Number: " + String.format("%06.2f", callNumber);
	}
	//helper
	public void checkOut(){
		isCheckedOut = true;
	}
	public void returnBook(){
		isCheckedOut = false;
	}
}
class patron{
	private String name;
	private ArrayList <book> books = new ArrayList<>();
	//constructors
	public patron(){
		this("", new book[0]);
	}
	public patron(patron p){
		this(p.name, p.books);
	}
	public patron(String myName, book[] myBooks){
		name = myName;
		books = utility.toArrayList(myBooks);

	}
	public patron(String myName, ArrayList<book> myBooks){
		name = myName;
		books = new ArrayList<>(myBooks);
	}
	//setters
	public void setName(String nName){
		name = nName;
	}
	public void setBooks(ArrayList<book> nBooks){
		books = new ArrayList<>(nBooks);
	}
	public void setBooks(book[] nBooks){
		books = utility.toArrayList(nBooks);
	}
	//getters
	public String getName(){
		return name;
	}
	public ArrayList<book> getBooks(){
		return books;
	}
	//toString
	public String toString(){
		return name + " | My books: " + utility.stringList(books, false);
	}
	//helpers
	public void checkOutBook(book myBook){
		System.out.println(myBook.getTitle() + " was checked out by " + name);
		myBook.checkOut();
		books.add(myBook);
	}
}

class library{
	private String name;
	private ArrayList <book> books = new ArrayList<>();
	private ArrayList <patron> patrons = new ArrayList<>();
	//constructors
	public library(){
		this("", new book[0], new patron[0]);
	}
	public library(library l){
		this(l.name, l.books, l.patrons);
	}
	public library(String myName, book[] myBooks, patron[] myPatrons){
		name = myName;
		books = utility.toArrayList(myBooks);
		patrons = utility.toArrayList(myPatrons);

	}
	public library(String myName, ArrayList<book> myBooks, ArrayList<patron> myPatrons){
		name = myName;
		books = new ArrayList<>(myBooks);
		patrons = new ArrayList<>(myPatrons);
	}
	//setters
	public void setName(String nName){
		name = nName;
	}
	public void setBooks(ArrayList<book> nBooks){
		books = new ArrayList<>(nBooks);
	}
	public void setBooks(book[] nBooks){
		books = utility.toArrayList(nBooks);
	}
	public void setPatrons(ArrayList<patron> nPatrons){
		patrons = new ArrayList<>(nPatrons);
	}
	public void setPatrons(patron[] nPatrons){
		patrons = utility.toArrayList(nPatrons);
	}
	//getters
	public String getName(){
		return name;
	}
	public ArrayList<book> getBooks(){
		return books;
	}
	public ArrayList<patron> getPatrons(){
		return patrons;
	}
}
class libraryMenu{
	library myLib;
	private Scanner input = new Scanner(System.in);
	private Scanner fileInput;
	public libraryMenu(){
		this(new library());
	}
	public libraryMenu(library nLib){
		myLib = nLib;
	}
	public void checkOut(){
		patron p = utility.selectFromList(input, "Search for Patron name:", myLib.getPatrons());
	    if (p == null) return;

	    book b = utility.selectFromList(input, "Search for Book title/author:", myLib.getBooks());
	    if (b == null) return;

	    if (b.getIsCheckedOut()) {
	        System.out.println("Sorry, that book is already out.");
	    } else {
	        p.checkOutBook(b);
	        System.out.println("Success! " + p.getName() + " took home " + b.getTitle());
	    }
	}
	public void returnBook() {
	    patron p = utility.selectFromList(input, "Who is returning a book?", myLib.getPatrons());
	    if (p == null) return;

	    book b = utility.selectFromList(input, "Which book is being returned?", p.getBooks());
	    
	    if (b != null) {
	        b.returnBook();
	        p.getBooks().remove(b);
	        System.out.println("Book returned successfully.");
	    }
	}
	public void addPatron(){
		input.nextLine();
		System.out.println("What's the patron's name?");
		String name = input.nextLine();
		patron newPatron = new patron(name, new book[0]);
		myLib.getPatrons().add(newPatron);
		System.out.println(name + " has been added a patron!");
	}
	public void addBook(){
		input.nextLine();
		System.out.println("What's the book's title?");
		String title = input.nextLine();
		System.out.println("What's the book's author?");
		String author = input.nextLine();
		System.out.println("What's the book's call number? (according to dewey decimal system)");
		double callNumber = Double.parseDouble(input.nextLine());
		book newBook = new book(callNumber, author, title, false);
    	myLib.getBooks().add(newBook);
		System.out.println(title + " has been added a book!");
	}
	// file input
	public void setUpFile(){
	    input.nextLine();
	    while(true){
	        System.out.println("Please provide the path to your data, so I can populate the library.");
	        File myFile = new File(input.nextLine());

	        int fileExtPos = myFile.getName().lastIndexOf('.');
	        if (fileExtPos == -1) {
	            System.out.println("Please include the file extension.");
	            continue;
	        }

	        if (!myFile.getName().substring(fileExtPos).equals(".csv")) {
	            System.out.println("Invalid file type. CSV please!");
	            continue;
	        }

	        try{
	            fileInput = new Scanner(myFile);
	            System.out.println("Loaded file..");
	            break;
	        }
	        catch (FileNotFoundException e){
	            System.out.println("File not found, provide a working path");
	        }
	    }
	    loadFromFile();
	}
	public void loadFromFile(){
		int i = 0;
		while (fileInput.hasNext()){
			i++;
			String line = fileInput.nextLine();
			String[] data = line.split(",");
			switch (data[0]){
				case "COMMENT":
					break;
				case "BOOK":
					book newBook = new book(Double.parseDouble(data[1]), data[2], data[3], false);
					myLib.getBooks().add(newBook);
					System.out.println("Line " + i + ": Added " + newBook);
					break;
				case "PATRON":
					patron newPatron = new patron(data[1], new book[0]);
    				myLib.getPatrons().add(newPatron);
    				int j = 2;
					while (j<data.length){
						book bookCached = findBookFromString(data[j], myLib.getBooks());
						if (bookCached != null){newPatron.checkOutBook(bookCached);}
						j++;
					}
    				System.out.println("Line " + i + ": Added " + newPatron);
					break;
				default:
					System.out.println("Line " + i + ": Unrecognized data type, skipping this line.");
					break;
			}
		}
		System.out.println("\nLibrary loaded from file!");
	}
	public book findBookFromString(String name, ArrayList<book> list){
		for (book item : list) {
	        if (item.getTitle().equalsIgnoreCase(name)){
	        	return item;
	        }
	    }
	    return null;
	}
	public void start(){
		System.out.println("\nWelcome to " + myLib.getName() + " library! Choose from the following:");
		boolean running = true;
		while (running){
			System.out.println("\n1. View books \n2. Add books \n3. Add patrons \n4. Check out book \n5. Return a book \n6. Load from File \n7. Exit");
			int choice = input.nextInt();
			switch (choice){
				case 1:
					System.out.println(myLib.getBooks());
					break;
				case 2:
					addBook();
					break;
				case 3:
					addPatron();
					break;
				case 4:
					checkOut();
					break;
				case 5:
					returnBook();
					break;
				case 6:
					setUpFile();
					break;
				case 7:
					System.out.println("See you later!");
					running = false;
					break;
				default:
					System.out.println("Please enter a valid option from the provided list.");
					break;
			}
		}
	}
}
class utility{
	public static <T> ArrayList<T> toArrayList(T[] list){
		ArrayList<T> arr = new ArrayList<>();
		for (int i = 0; i < list.length; i++){
			arr.add(list[i]);
		}
		return arr;
	}
	public static <T> String stringList(ArrayList<T> list, boolean numbered) {
	    String result = "";
	    if (numbered){
	    	result += "Choose from the following:\n";
	    }
		for (int i = 0; i < list.size(); i++) {
		    T item = list.get(i);
		    result += (i + 1) + ". " + item + "\n";
		}
	    if (numbered){
	    	result += (list.size() + 1) + ". None of these";
	    }
	    return result;
	}
	public static <T> ArrayList<T> findObjFromString(String name, ArrayList<T> list){
		ArrayList<T> arr = new ArrayList<>();
		for (T item : list) {
	        if (item.toString().contains(name)){
	        	arr.add(item);
	        }
	    }
	    return arr;
	}
	public static <T> T selectFromList(Scanner input, String prompt, ArrayList<T> fullList) {
	    while (true) {
	        System.out.println(prompt);
	        String search = input.next();
	        ArrayList<T> options = findObjFromString(search, fullList);
	            
	        System.out.println(utility.stringList(options, true));
	        int choice = input.nextInt();

	           
	        if (choice > 0 && choice <= options.size()) {
	            return options.get(choice - 1);
	        } else if (choice == options.size() + 1) {
	            return null;
	    	}
	    	System.out.println("Invalid selection. Try again.");
	    }
	}

	//method for testing
	public static library generate() {
        // Create some books
        book[] initialBooks = {
            new book(823.91, "George Orwell", "1984", false),
            new book(510.00, "Euclid", "The Elements", false),
            new book(150.00, "Marcus Aurelius", "Meditations", false),
            new book(813.54, "F. Scott Fitzgerald", "The Great Gatsby", false),
            new book(612.00, "Alice Roberts", "The Complete Human Body", false),
            new book(200.00, "Alan Watts", "The Way of Zen", false),
            new book(940.53, "Antony Beevor", "The Second World War", false)
        };

        // Create some patrons
        patron[] initialPatrons = {
            new patron("Joseph", new book[0]),
            new patron("Riordan", new book[0]),
            new patron("Hailey", new book[0])
        };

        return new library("Cockeysville", initialBooks, initialPatrons);
    }
}