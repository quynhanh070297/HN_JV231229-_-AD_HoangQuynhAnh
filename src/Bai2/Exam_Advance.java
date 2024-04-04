package Bai2;

import Bai1.ra.config.InputMethods;

import java.util.Stack;

public class Exam_Advance
{
    public static void main(String[] args)
    {
        Stack<String> stackList = new Stack<>();
        while (true){
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập URL muốn truy cập\n" +
                    "2. Quay lại\n" +
                    "3. Thoát");
            System.out.println("mời bạn nhập");
            byte choice = InputMethods.getByte();
            switch (choice)
            {
                case 1:
                    System.out.println("Nhap URL");
                    String ulrInput = InputMethods.getString();
                    stackList.add(ulrInput);
                    System.out.println("Ban dang o : " + ulrInput);
                    break;
                case 2:
                    if (stackList.isEmpty()){
                        System.out.println("Khong co lich su");
                    }else {
                        stackList.pop();
                        if (stackList.isEmpty()){
                            System.out.println("Khong co lich su");
                        }
                        else {
                            System.out.println("Ban dang o trang : "+ stackList.peek());
                        }
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
