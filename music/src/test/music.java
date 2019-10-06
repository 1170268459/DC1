package test;

import dao.impl.musicImpl;
import dao.musicdao;
import domin.Music;
import java.util.List;
import java.util.Scanner;

import static test.IUser.success;



public class music {
    static musicdao mu = new musicImpl();

    public void select() throws Exception {
        ;
        System.out.println("请输入你要查询的音乐名字");
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        String n = scanner.next();
        String m = scanner.next();

        boolean i = mu.select(new Music(s, n, m));
        if (i) {
            System.out.println("有该音乐");
            success();
        } else {
            System.out.println("没有该音乐");
            select();
        }
    }

    public void add() throws Exception {

        System.out.println("请输入你要增加的音乐名字");
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        String n = scanner.next();
        String m = scanner.next();

        boolean i = mu.add(new Music(s, n, m));
        if (i) {
            System.out.println("成功");
            success();
        } else {
            System.out.println("失败！有该音乐");
            add();
        }
    }

    public void update() throws Exception {

        System.out.println("请输入你要更新的音乐");
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        String n = scanner.next();
        String m = scanner.next();

        boolean i = mu.update(new Music(s, n, m));
        if (i) {
            System.out.println("成功");
            success();
        } else {
            System.out.println("失败！更新");
            success() ;
        }
    }

    public void delete() throws Exception {
        System.out.println("欢迎来到你的音乐");
        System.out.println("请输入你要删除的音乐id");
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();

        boolean i = mu.delete(s);

        if (i) {
            System.out.println("成功---将返回主页面");
            success();
        } else {
            System.out.println("没有成功");
            delete();
        }
    }

    public static void show() throws Exception {
        List<Music> us = mu.show();
        for (Music u : us) {
            System.out.println(u);
        }
        success();

    }

    public void seletAll() throws Exception {
        System.out.println(mu.selectAll());
        success();

    }
}
