package com.example.quanlycanbo.controler;

import com.example.quanlycanbo.service.impl.EngineerImpl;
import com.example.quanlycanbo.service.impl.LabourImpl;
import com.example.quanlycanbo.service.impl.StaffImpl;

import java.util.Scanner;

public class QLCBController {
    EngineerImpl engineer = new EngineerImpl();
    StaffImpl staff = new StaffImpl();
    LabourImpl labour = new LabourImpl();

    public static void main(String[] args) {
        xuatMenu();
    }
    public static void xuatMenu() {
        boolean check = true;
        while (check) {
            System.out.println("-- CHƯƠNG TRÌNH QUẢN LÝ CÁN BỘ --");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách các cán bộ");
            System.out.println("4. Tìm kiếm theo tên");
            System.out.println("5. Thoát");
            System.out.println("Chọn chức năng: ");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1: {
                    themMoi();
                    break;
                }
                case 2: {
                    xoa();
                    break;
                }
                case 3:{
                    xemDanhSachCanBo();
                    break;
                }
                case 4:{
                    timKiem();
                    break;
                }
                case 5: {
                    System.exit(0);
                }
                default:
                    System.out.println("No choice!");
            }
        }
    }
    public static void themMoi() {
        EngineerImpl engineer = new EngineerImpl();
        StaffImpl staff = new StaffImpl();
        LabourImpl labour = new LabourImpl();
        boolean check = true;
        while (check) {
            System.out.println("1. Thêm mới kỹ sư");
            System.out.println("2. Thêm mới công nhân");
            System.out.println("3. Thêm mới nhân viên");
            System.out.println("4. Return Menu");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1: {
                    engineer.themMoi();
                    engineer.xemDS();
                    break;
                }
                case 2: {
                    labour.themMoi();
                    labour.xemDS();
                    break;
                }
                case 3: {
                    staff.themMoi();
                    staff.xemDS();
                    break;
                }
                case 4: {
                    xuatMenu();
                }
            }
        }
    }
    public static void xoa() {

    }

    public static void xemDanhSachCanBo() {
        EngineerImpl engineer = new EngineerImpl();
        StaffImpl staff = new StaffImpl();
        LabourImpl labour = new LabourImpl();
        boolean check = true;
        while (check) {
            System.out.println("1. Xem danh sách kỹ sư");
            System.out.println("2. Xem danh sách công nhân");
            System.out.println("3. Xem danh sách nhân viên");
            System.out.println("4. Return Menu");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1: {
                    engineer.xemDS();
                    break;
                }
                case 2: {
                    labour.xemDS();
                    break;
                }
                case 3: {
                    staff.xemDS();
                    break;
                }
                case 4: {
                    xuatMenu();
                }
            }
        }
    }

    public static void timKiem() {
        EngineerImpl engineer = new EngineerImpl();
        StaffImpl staff = new StaffImpl();
        LabourImpl labour = new LabourImpl();
        boolean check = true;
        while (check) {
            System.out.println("1. Tìm tên kỹ sư");
            System.out.println("2. Tìm tên công nhân");
            System.out.println("3. Tìm tên nhân viên");
            System.out.println("4. Return Menu");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1: {
                    engineer.timkiem();
                    break;
                }
                case 2: {
                    labour.timkiem();
                    break;
                }
                case 3: {
                    staff.timkiem();
                    break;
                }
                case 4: {
                    xuatMenu();
                }
            }
        }
    }
}
