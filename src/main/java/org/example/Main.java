package org.example;

import java.util.Scanner;

public class Main {
    // viet ct kiem tra nam nhap vao co phai nam nhuan hay khong
    /*
    nam nhuan la nam chia het cho 4 ma khong chia het cho 100
     */

    public static boolean kiemTraNamNhuan(int nam) {
        if (nam < 0) throw new IllegalArgumentException( "Nam k hop le");
        if (nam % 4 == 0 & nam % 100 != 0) {
            return true;

        } else {
            return false;
        }
    }

    /*
    kiem tra chuoi la number hay la chu
    neu la so thi la so nguyen hay so thap phan
     */

    public static boolean isNumber(String test){
        if (test == null) return false;
        try {
            Integer.parseInt(test);
            //Double.parseDouble(test);
            return true;
        }catch (NumberFormatException e){
            return false;
        }

    }

    /*
    Kiem tra do phuc tap cua Password
    length >= 8
    include Upper, lower case
    include digits
    include special charaters
     */

    public static boolean isValidPassword(String password){
        return false;
    }


    /*
    Tim so lon thu nhat và lon thu 2 cua 1 mang
    array = {9,8,10,7,5,8}
     */



}