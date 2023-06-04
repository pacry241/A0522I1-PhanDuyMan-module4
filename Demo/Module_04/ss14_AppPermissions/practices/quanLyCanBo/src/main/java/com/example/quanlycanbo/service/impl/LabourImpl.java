package com.example.quanlycanbo.service.impl;

import com.example.quanlycanbo.model.Labour;
import com.example.quanlycanbo.service.ILabour;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LabourImpl implements ILabour {
    private static List<Labour> labourList = new ArrayList<>();
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
        System.out.println("Nhập bậc: ");
        int rank = Integer.parseInt(scanner.nextLine());
        Labour labour = new Labour(name, age, gender, address, rank);
        labourList.add(labour);
    }

    @Override
    public void xemDS() {
        for (Labour labour: labourList) {
            System.out.println(labour.toString());
        }
    }

    @Override
    public void xoa() {

    }

    @Override
    public void timkiem() {
        boolean check = false;
        if (labourList.isEmpty()) {
            System.out.println("Danh sách đang trống !!!");
        } else {
            System.out.println("Nhập tên: ");
            String tenCanTim = scanner.nextLine();
            for (Labour labour : labourList) {
                if (labour.getName().equals(tenCanTim)) {
                    System.out.println("Cán bộ bạn cần tìm là: " + labour.toString());
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
