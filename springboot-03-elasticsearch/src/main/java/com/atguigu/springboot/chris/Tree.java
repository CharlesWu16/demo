package com.atguigu.springboot.chris;

import java.util.Scanner;

public class Tree {

    /*
     * Merry Christams!!!
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要祝福人的名字: ");
        String name = sc.next();
        for (int i = 0; i <= 5; i++) {
            for (int k = 0; k <= 7 - i; k++) {
                System.out.print(" ");
            }
            for (int z = 1; z <= 2 * i - 1; z++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 3; i <= 7; i++) {
            for (int k = 0; k <= 7 - i; k++) {
                System.out.print(" ");
            }
            for (int z = 1; z <= 2 * i - 1; z++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i <= 4; i++) {
            for (int k = 0; k <= 5; k++) {
                System.out.print(" ");
            }
            for (int z = 1; z <= 3; z++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("亲手为你准备棵圣诞树送个你！");
        System.out.println("祝福" + name + "圣诞快乐！");
        System.out.println("       " + "生蛋快乐！！");
    }

   /* public static void main(String[] args) {
        //叶子层
        int level = 10;
        //根层
        int rootLevel = 2;
        int spaceNum = level - 1;

        //画叶子
        // 为什么从1开始   不管了就是任性
        for (int i = 1; i <= level; i++) {
            spaceNum--;
            for (int g = 0; g <= spaceNum; g++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= ((i * 2) -1); j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

        //画根
        for (int i = 1; i <= rootLevel; i++) {
            for (int g = 1; g < level; g++) {
                System.out.print(" ");
            }
            System.out.print("*\n");
        }
    }*/

}
