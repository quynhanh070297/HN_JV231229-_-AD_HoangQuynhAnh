package Bai1.ra.bussinessImp;

import Bai1.ra.business.IShop;
import Bai1.ra.config.InputMethods;
import Bai1.ra.run.BookManagement;

import java.util.List;

public class Book implements IShop,Comparable<Book>
{
    private int bookId;
    private String  bookName;
    private String title;
    private int numberOfPages;
    private Author author;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private Boolean bookStatus;

    public Book()
    {

    }

    public Book(int bookId, String bookName, String title, int numberOfPages, Author author, int quantity, int importPrice, boolean bookStatus)
    {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = getInputExportPrice();
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId()
    {
        return bookId;
    }

    public void setBookId(int bookId)
    {
        this.bookId = bookId;
    }

    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getNumberOfPages()
    {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages)
    {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor()
    {
        return author;
    }

    public void setAuthor(Author author)
    {
        this.author = author;
    }

    public float getImportPrice()
    {
        return importPrice;
    }

    public void setImportPrice(float importPrice)
    {
        this.importPrice = importPrice;
    }

    public float getExportPrice()
    {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice)
    {
        this.exportPrice = exportPrice;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public Boolean getBookStatus()
    {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus)
    {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData()
    {
        System.out.println("Moi ban nhap ID Sach");
        this.bookId = InputMethods.getInteger();
        System.out.println("Moi ban nhap Ten sach");
        this.bookName = InputMethods.getString();
        System.out.println("Moi ban nhap Tieu de Sach");
        this.title = InputMethods.getString();
        System.out.println("Moi ban nhap so trang");
        this.numberOfPages = InputMethods.getInteger();
        System.out.println("Moi ban nhap tac gia");
        this.author = getInputAuthorName(BookManagement.authorList);
        System.out.println("Moi ban nhap so luong sach");
        this.quantity = InputMethods.getInteger();
        System.out.println("Moi ban nhap gia nhap");
        this.importPrice = InputMethods.getInteger();
        this.exportPrice = getInputExportPrice();
        System.out.println("Moi ban nhap  trang thai sach");
        this.bookStatus = InputMethods.getBoolean();



    }

    private float getInputExportPrice()
    {
       return importPrice*RATE;
    }

    private Author getInputAuthorName(List<Author> authorList)
    {
        authorList.forEach(Author::displayData);
        System.out.println("Moi ban nhap ten tac gia muon chon ");
        String choiceAuthor = InputMethods.getString();
        boolean check = false;
        for (Author author1 : authorList)
        {
           if (author1.getAuthorName().contains(choiceAuthor)){
               check = true;
               return author1;
           }
        }
        if (!check){
            System.out.println("Khong co ten tac gia muon chon");
        }
        return  null;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", author=" + author +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", quantity=" + quantity +
                ", bookStatus=" + bookStatus +
                '}';
    }

    @Override
    public void displayData()
    {
        //Triển khai phương thức displayData() cho phép in các thông tin sách gồm mã
       // sách, tên sách, tên tác giả(authorName), giá bán sách, số lượng sách, trạng thái
        System.out.println("--------------------------------------------------------------------------------\n"+
                "| BookId=" + bookId +
                "| BookName='" + bookName + '\'' +
                "| Author=" + author.getAuthorName() +
                "| ExportPrice=" + exportPrice +
                "| Quantity=" + quantity +
                "| bookStatus=" + (bookStatus?"Dang Ban":"Het hang") );
    }

    @Override
    public int compareTo(Book o)
    {
        return Float.compare(this.exportPrice,o.exportPrice);
    }
}
