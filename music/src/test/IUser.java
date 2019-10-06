package test;

import dao.impl.userdaoImpl;
import dao.userdao;
import domin.User;

import java.util.Scanner;

public class IUser {
    static userdao use = new userdaoImpl();
    static Scanner scanner = new Scanner(System.in);

    //进入系统
    public static void index() throws Exception {
        music m = new music();
        System.out.println("======欢迎来到你的音乐======");
        System.out.println("+ 1.登录                   +");
        System.out.println("+ 2.注册                   +");
        System.out.println("+ 3.删除用户！             +");
        System.out.println("+ 4.更改用户密码           +");

        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        if (s == 1) {
            //登录
            login();
        } else if (s == 2) {
            //注册
            regist();
        } else if (s == 3) {
            deluser();
        } else if (s == 4) {
            updatauser();
        }
    }

    private static void updatauser() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("++请输入用户名++");
        String name = scanner.next();
        System.out.println("++请输入新密码++");
        String password = scanner.next();
        System.out.println("请确认密码");
        String password1 = scanner.next();
        if (name != null && password.equals(password1)) {

            use.updatau(new User(name, password));
            if (use.updatau(new User(name, password))) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        } else {
            System.out.println("失败！");
            login();
        }
    }

    /*注册用户*/
    public static void regist() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("++请输入注册用户名++");
        String name = scanner.next();
        System.out.println("++请输入注册密码++");
        String password = scanner.next();
        System.out.println("请确认密码");
        String password1 = scanner.next();
        if (name != null && password.equals(password1)) {

            use.regesit(new User(name, password));
            if (use.regesit(new User(name, password))) {
                System.out.println("ch");
            } else {
                System.out.println("失败");
            }
        } else {
            System.out.println("失败！");
            regist();
        }

    }

    /*登录账号*/
    public static void login() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("======对用户的操作========");
        System.out.println("请输入用户名");
        String name = scanner.next();
        System.out.println("请输入密码");
        String password = scanner.next();

        boolean i = use.login(new User(name, password));
        if (i) {
            System.out.println("登录成功");
            success();
        } else {
            System.out.println("失败。重新登录");
            login();
        }
    }

    /*登录成功对音乐的操作*/
    public static void success() throws Exception {
        music m = new music();
        Ifen ifen = new Ifen();

        System.out.println("======对于音乐的操作========");
        System.out.println("1.查询音乐");
        System.out.println("2.添加音乐");
        System.out.println("3.更新音乐");
        System.out.println("4.删除音乐");
        System.out.println("5.显示所有音乐");
        System.out.println("6.总共的音乐数目");
        System.out.println("7.查询分类");
        int b = scanner.nextInt();
        if (b == 1) {
            m.select();
            success();
        } else if (b == 2) {
            m.add();
            success();
        } else if (b == 3) {
            m.update();
            success();
        } else if (b == 4) {
            m.delete();
            success();
        } else if (b == 5) {
            m.show();
        } else if (b == 6) {
            m.seletAll();
        } else if (b == 7) {
            ifen.select();
        }
    }

    public static void deluser() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要删除用户名,无需输入密码！删除后不可恢复");

        String name = scanner.next();
        System.out.println("请输入Y（确认）或者N（取消）");
        String q = scanner.next();
        if (q.equals("Y") || q.equals("y")) {
            boolean i = use.deluser(name);
            if (i) {
                System.out.println("删除用户成功");
                login();
            } else {
                System.out.println("失败。重新输入id");
                deluser();
            }
        } else {
            System.out.println("你已经取消");
            index();
        }
    }

}
