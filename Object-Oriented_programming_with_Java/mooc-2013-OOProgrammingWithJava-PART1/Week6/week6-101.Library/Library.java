import java.util.ArrayList;

public class Library {
    private ArrayList<Book> list;

    public Library() {
        this.list = new ArrayList<Book>();
    }

    public void addBook(Book newBook) {
        this.list.add(newBook);
    }

    public void printBooks() {
        int n = 0;
        while(n < this.list.size()) {
            System.out.println(this.list.get(n));
            n++;
        }
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> found = new ArrayList<Book>();

        int n = 0;
        while(n < this.list.size()) {
            if(StringUtils.included(this.list.get(n).title(), title)) {
                found.add(this.list.get(n));
            }
            n++;
        }

        return found;
    }

    public ArrayList<Book> searchByPublisher(String publisher) {
        ArrayList<Book> found = new ArrayList<Book>();

        int n = 0;
        while(n < this.list.size()) {
            if(StringUtils.included(this.list.get(n).publisher(), publisher)) {

                found.add(this.list.get(n));
            }
            n++;
        }

        return found;

    }

    public ArrayList<Book> searchByYear(int year) {
        ArrayList<Book> found = new ArrayList<Book>();

        int n = 0;
        while(n < this.list.size()) {
            if(this.list.get(n).year() == year) {
                found.add(this.list.get(n));
            }
            n++;
        }

        return found;
    }

}