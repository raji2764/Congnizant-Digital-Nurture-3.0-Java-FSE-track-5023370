/*Linear Search:
Checks each element in the list one by one until the desired element is found or the list ends. */
/*Binary Search:
Efficiently finds an element in a sorted list by repeatedly dividing the search interval in half. */


import java.util.Arrays;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        // Sample books (unsorted and sorted)
        Book[] books = {
                new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book(2, "To Kill a Mockingbird", "Harper Lee"),
                new Book(3, "1984", "George Orwell"),
                new Book(4, "Pride and Prejudice", "Jane Austen")
        };

        // Sort books by title for binary search
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));

        // Linear search
        System.out.println("Linear Search Result:");
        Book foundBook = linearSearchByTitle(books, "1984");
        System.out.println(foundBook != null ? foundBook : "Book not found");

        // Binary search
        System.out.println("Binary Search Result:");
        foundBook = binarySearchByTitle(books, "1984");
        System.out.println(foundBook != null ? foundBook : "Book not found");
    }

    // Linear search by title
    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Binary search by title (requires sorted array)
    public static Book binarySearchByTitle(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = title.compareToIgnoreCase(books[mid].getTitle());

            if (cmp < 0) {
                right = mid - 1;
            } else if (cmp > 0) {
                left = mid + 1;
            } else {
                return books[mid]; // Book found
            }
        }
        return null; // Book not found
    }

    static class Book {
        private int bookId;
        private String title;
        private String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookId=" + bookId +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

}
