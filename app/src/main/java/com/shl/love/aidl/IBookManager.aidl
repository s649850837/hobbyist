import com.shl.love.aidl.Book;
interface IBookManager{
    List<Book> getBookList();
    void addBook(in Book book);
}