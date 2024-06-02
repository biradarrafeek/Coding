package LibraryMangement;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<Transaction> transactions;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // Methods to add, remove, search books and manage members and transactions
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String bookId) {
        books.removeIf(book -> book.getId().equals(bookId));
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public void issueBook(String bookId, String memberId) {
        Book book = getBookById(bookId);
        Member member = getMemberById(memberId);
        if (book != null && member != null && !book.isIssued()) {
            book.setIssued(true);
            member.getBorrowedBooks().add(book);
            transactions.add(new Transaction(generateTransactionId(), book, member));
        }
    }

    public void returnBook(String bookId, String memberId) {
        Book book = getBookById(bookId);
        Member member = getMemberById(memberId);
        if (book != null && member != null && book.isIssued()) {
            book.setIssued(false);
            member.getBorrowedBooks().remove(book);
            // Find and update transaction
        }
    }

    private Book getBookById(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    private Member getMemberById(String memberId) {
        for (Member member : members) {
            if (member.getId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    private String generateTransactionId() {
        return "TXN" + (transactions.size() + 1);
    }

}
