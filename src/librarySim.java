import java.util.ArrayList;

public class librarySim{
	public static void main(String[] args){
		book b = new book(813.6, "Allen Levi", "Theo of Golden", false);
		System.out.println(b);
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
		return name + " | My books: " + utility.stringBooks(books);
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

}

class utility{
	public static <T> ArrayList<T> toArrayList(T[] arr){
		ArrayList<T> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++){
			list.add(arr[i]);
		}
		return list;
	}
	public static String stringBooks(ArrayList<book> myBooks){
		String concatBook = "";
		for (book myBook: myBooks){
			concatBook += myBook.getTitle() + " ";
		}
		return concatBook;
	}
	public static String stringPatrons(ArrayList<patron> myPatrons){
		String concatPatron = "";
		for (patron myPatron: myPatrons){
			concatPatron += myPatron.getName() + " ";
		}
		return concatPatron;
	}
}