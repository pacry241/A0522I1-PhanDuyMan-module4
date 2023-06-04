package com.example.quanlycanbo.service.impl;

import com.example.quanlycanbo.model.Engineer;
import com.example.quanlycanbo.service.IEngineer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EngineerImpl implements IEngineer {
    private static List<Engineer> engineerList = new ArrayList<>();
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
        System.out.println("Nhập ngành đào tạo: ");
        String trainingIndustry = scanner.nextLine();
        Engineer engineer = new Engineer(name, age, gender, address, trainingIndustry);
        engineerList.add(engineer);
    }

    @Override
    public void xemDS() {
        for (Engineer engineer: engineerList) {
            System.out.println(engineer.toString());
        }
    }

    @Override
    public void xoa() {

    }

    @Override
    public void timkiem() {
        boolean check = false;
        if (engineerList.isEmpty()) {
            System.out.println("Danh sách đang trống !!!");
        } else {
            System.out.println("Nhập tên: ");
            String tenCanTim = scanner.nextLine();
            for (Engineer engineer : engineerList) {
                if (engineer.getName().equals(tenCanTim)) {
                    System.out.println("Cán bộ bạn cần tìm là: " + engineer.toString());
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
