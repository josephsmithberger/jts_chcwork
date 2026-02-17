import java.util.ArrayList;
import java.util.Scanner;
public class librarySim{
	public static void main(String[] args){
		libraryMenu ui = new libraryMenu();
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
		return name + " | My books: " + utility.stringList(books);
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
	public libraryMenu(){
		this(new library());
	}
	public libraryMenu(library nLib){
		myLib = new library(nLib);
	}
	public void start(){
		System.out.println("\nWelcome to " + myLib.getName() + " library! Choose from the following:");
		boolean running = true;
		while (running){
			System.out.println("\n1. View books \n2. Add books \n3. Add patrons \n4. Check out book \n5. Return a book \n6. Exit");
			int choice = input.nextInt();
			switch (choice){
				case 6:
					System.out.println("See you later!");
					running = false;
				default:
					System.out.println("Please enter a valid option from the provided list.");
					break;
			}
		}
	}
}
class utility{
	public static <T> ArrayList<T> toArrayList(T[] arr){
		ArrayList<T> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++){
			list.add(arr[i]);
		}
		return list;
	}
	public static <T> String stringList(ArrayList<T> list) {
	    String result = "";
	    for (T item : list) {
	        result += item + " ";
	    }
	    return result;
	}
}