package Bai3;

import Bai1.ra.config.InputMethods;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Exam_Advance3
{
    public static void main(String[] args)
    {
        Queue<String> listName = new LinkedList<>();
        while (true){
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên khách hàng chờ mua vé xem phim\n" +
                    "2. Khách tiếp theo\n" +
                    "3. Thoát");
            System.out.println("mời bạn nhập");
            byte choice = InputMethods.getByte();
            switch (choice)
            {
                case 1:
                    System.out.println("Nhập tên khách hàng");
                    String inputName = InputMethods.getString();
                    listName.add(inputName);
                    System.out.println("Luu thanh cong");
                    System.out.println(listName);
                    break;
                case 2:
                 if(listName.isEmpty()){
                        System.out.println("Khong co Khach hang nao");
                    }
                 else {
                     String nameDisplay = listName.poll();
                     System.out.println("Moi anh/chi :");
                     System.out.println(nameDisplay);
                 }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không đúng");
                    break;
            }
        }
    }
}
