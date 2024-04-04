package Bai1.ra.run;

import Bai1.ra.bussinessImp.Author;
import Bai1.ra.bussinessImp.Book;
import Bai1.ra.config.InputMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookManagement
{

    public static List<Author> authorList = new ArrayList<>();
    public static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args)
    {
        while (true){
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập số tác giả và nhập thông tin các tác giả [10 điểm]\n" +
                    "2. Nhập số sách và nhập thông tin các sách [20 điểm]\n" +
                    "3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/Comparator) [10 điểm]\n" +
                    "4. Tìm kiếm sách theo tên tác giả sách [05 điểm]\n" +
                    "5. Thoát [05 điểm]");
            System.out.println("mời bạn nhập");
            byte choice = InputMethods.getByte();
            switch (choice)
            {
                case 1:
                    creatAndInputAuthor();
                    break;
                case 2:
                    creatAndInputBook();
                    break;
                case 3:
                    sortByBookPriceIncrease();
                    break;
                case 4:
                    searchBookByNameAuthor();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không đúng");
                    break;
            }
        }
    }



    private static void creatAndInputAuthor()
    {
        System.out.println("Nhap so tac gia muon them");
        int numberAuthor = InputMethods.getInteger();
        for (int i = 0; i < numberAuthor; i++)
        {
            Author author = new Author();
            author.inputData();
            authorList.add(author);
        }
        authorList.forEach(Author::displayData);
    }
    private static void creatAndInputBook()
    {
        System.out.println("Nhap so sach muon them");
        int numberBook = InputMethods.getInteger();
        for (int i = 0; i < numberBook; i++)
        {
            Book book = new Book();
            book.inputData();
            bookList.add(book);
        }
        bookList.forEach(Book::displayData);

    }

    private static void sortByBookPriceIncrease()
    {
       Collections.sort(bookList);
       bookList.forEach(Book::displayData);
    }
    private static void searchBookByNameAuthor()
    {
        System.out.println("Nhap ten tac gia");
        String authorName = InputMethods.getString();
        boolean check = false;
        for (Book book : bookList)
        {
            if (book.getAuthor()==null){
                continue;
            }
            if (book.getAuthor().getAuthorName().contains(authorName)){
                System.out.println("Sach thuoc tac gia :" + book.getAuthor().getAuthorName());
                book.displayData();
                check = true;
            }
        }
        if (!check){
            System.out.println("Khong co ten tac gia muon tim");
        }
    }
}
