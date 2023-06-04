package com.example.quanlycanbo.service.impl;

import com.example.quanlycanbo.model.Staff;
import com.example.quanlycanbo.service.IStaff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffImpl implements IStaff {
    private static List<Staff> staffList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void themMoi() {
        System.out.println("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giới tính: ");
        int gender = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập công việc: ");
        String work = scanner.nextLine();
        Staff staff = new Staff(name, age, gender, address, work);
        staffList.add(staff);
    }

    @Override
    public void xemDS() {
        for (Staff staff: staffList) {
            System.out.println(staff.toString());
        }
    }

    @Override
    public void xoa() {

    }

    @Override
    public void timkiem() {
        boolean check = false;
        if (staffList.isEmpty()) {
            System.out.println("Danh sách đang trống !!!");
        } else {
            System.out.println("Nhập tên: ");
            String tenCanTim = scanner.nextLine();
            for (Staff staff : staffList) {
                if (staff.getName().equals(tenCanTim)) {
                    System.out.println("Cán bộ bạn cần tìm là: " + staff.toString());
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("Không tìm thấy cán bộ có tên là: " + tenCanTim);
            }
        }
    }
}
