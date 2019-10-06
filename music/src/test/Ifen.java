package test;

;
import dao.fen;
import dao.impl.fenImpl;
import domin.Fen;

import java.util.Scanner;

public class Ifen {
    static fen fen =new fenImpl();
    Scanner scanner=new Scanner(System.in);
    public  void select(){
        System.out.println("查询分类");
        System.out.println("欢迎来到查询音乐分类的");
        System.out.println("请输入你要删除的音乐id");
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        String  m=scanner.next();

        boolean i = fen.select(new Fen(s,m));

        if (i) {
            System.out.println("查询分类成功");

        } else {
            System.out.println("没有成功");
        }

    }



}
