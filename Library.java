import java.util.Scanner;
class Book{
	int bookId;
	String title;
	String author;
	String category;
	boolean isAvailable;
	
	void borrowBook() {
		if(isAvailable)
			isAvailable = false;
		else
			System.out.println("NOT AVAILABLE.");
	}
	void returnBook() {
		if(!isAvailable)
			isAvailable = true;
		else
			System.out.println("Book already saved.");
	}
	void displayBookDetails() {
		System.out.println("ID: " + bookId);
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Category: " + category);
		System.out.println("Status: " + isAvailable); 
	}
}


public class Library {

	public static void main(String[] args) {
		
		String choice;
		int borrow;
		
		Scanner input = new Scanner(System.in);
		
		Book[] books = new Book[3];
		
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		
		b1.bookId = 12345;
		b1.title = "Kite Runner";
		b1.author = "Khaled Hosseini";
		b1.category = "Fiction";
		b1.isAvailable = true;
		
		b2.bookId = 5994;
		b2.title = "Fundamentals of Computer Programming";
		b2.author = "Juadat Mamoon";
		b2.category = "Non-Fiction";
		b2.isAvailable = false;
		
		b3.bookId = 22225;
		b3.title = "The BFG";
		b3.author = "JK.Rowling";
		b3.category = "Fiction";
		b3.isAvailable = true;
		
		books[0] = b1;
		books[1] = b2;
		books[2] = b3;
		
		System.out.println("All books are:");
		for(int i = 0; i < 3; i++) {
			books[i].displayBookDetails();
		}
		
		while(true) {
			System.out.print("Enter the name of the book or the author (enter 0 if you dont want to) : ");
			choice = input.nextLine();
			
			for(int j = 0; j < 3; j++) {
				if (choice.equals(books[j].title) || choice.equals(books[j].author)) {
					books[j].displayBookDetails();
					System.out.print("Do you want to borrow this book?( 1 for yes, 0 for no: ");
					borrow = input.nextInt();
					if (borrow == 1 )
						books[j].borrowBook();
				}
			}
			if(choice.equals("0"))
				break;
		}
		
		System.out.println("BORROWED BOOKS:");
		for(int i = 0; i < 3; i++) {
			if(!books[i].isAvailable)
				books[i].displayBookDetails();
		}
		
		System.out.println("NON-BORROWED BOOKS:");
		for(int i = 0; i < 3; i++) {
			if(books[i].isAvailable)
				books[i].displayBookDetails();
		}	
		
	}

}
