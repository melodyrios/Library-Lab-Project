package libraryLab;


import java.util.ArrayList;

public class Library extends Book {
    // Add the missing implementation to this class
	private static String address;
	static ArrayList<Book> libraryBooks = new ArrayList<Book>();
	
	public Library(String bookTitle, String address) {
		super(bookTitle);
		Library.address = address;
		Library.libraryBooks = libraryBooks;
	}
	
	
	
	public boolean isBorrowed() {
		return borrowed;
    }
   
	public static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}

	
	public void addBook(Book book) {
		Library.libraryBooks.add(book);
	}

	
	public void printAddress() {
		System.out.println(address);
	}
	
	public void printAvailableBooks() {
		if(libraryBooks.isEmpty()) {
			System.out.println("No book in catalog");
		} 
		for(Book book:Library.libraryBooks) {
			System.out.println(book.getTitle());
		}
	}
	
	public void borrowBook(String title) {
		for(Book book: Library.libraryBooks) {
			if(title.equals(book.getTitle())) {
				if(book.isBorrowed()) {
					System.out.println("Sorry, this book is already borrowed.");
					return;
				}
				else {
					book.returned();
					System.out.println("You successfully borrowed " +title+".");
					return;
				}
			}
		}
		System.out.println("Sorry, this book is not in our catalog.");
	}
	
	
	public void returnBook(String title) {
		for(Book book: Library.libraryBooks) {
			if(title.equals(book.getTitle())) {
				book.returned();
				System.out.println("You successfully returned "+title+".");
			}
		}
	}
	
	


    public static void main(String[] args) {
        // Create two libraries /*
        Library firstLibrary = new Library("10 Main St.", address);
        Library secondLibrary = new Library("228 Liberty St.", address);
	
        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        
        
        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
 
       
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        
    }
}