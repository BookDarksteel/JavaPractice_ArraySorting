//JavaPractice2_ArraySorting
//version:1.0.1r
//Main.java
//Book Darksteel
//完成日期：2024年3月3日

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //输出欢迎信息
        System.out.println("-----\nJavaPractice_ArraySorting\n-----\nversion:1.0.1\n");
        System.out.println("欢迎使用\n");
        //关于设置模式
        boolean show_details=true;
        Scanner sc=new Scanner(System.in);
        System.out.println("按Enter键继续，输入“s”后按Enter键进入设置模式。");
        String start_control_str=sc.nextLine();
        start_control_str=start_control_str.trim().toLowerCase()+" ";
        System.out.println();
        if(start_control_str.charAt(0)=='s'){
            System.out.println("已进入设置模式");
            System.out.println("注意：对设置的修改仅在程序关闭前生效，下次启动程序将按默认设置初始化程序。");
            String settings_control_str="not inputted yet";
            while(true){
                if(show_details){
                    System.out.println("显示排序过程：开启");
                }
                else{
                    System.out.println("显示排序过程：关闭");
                }
                System.out.println("(\t输入“s”后按Enter键修改“显示排序过程”项的设置；");
                System.out.println("\t输入“a”后按Enter键显示关于本程序的信息；");
                System.out.println("\t直接按Enter键退出设置模式。\t)");
                settings_control_str=sc.nextLine();
                System.out.println();
                settings_control_str=settings_control_str.trim().toLowerCase()+" ";
                if(settings_control_str.startsWith("s")){
                    show_details=!show_details;
                    System.out.println("设置修改成功\n");
                } else if (settings_control_str.startsWith("a")) {
                    System.out.println("关于JavaPractice_ArraySorting");
                    System.out.println("版本：1.0.1r");
                    System.out.println("开发者：Book Darksteel");
                    System.out.println("开发完成日期：2024年3月3日");
                    System.out.println("本程序实现对一维整数数组进行排序的功能。");
                    System.out.println("本程序是Book Darksteel出于练习Java编程技术的目的开发的程序。");
                    System.out.println();
                } else {
                    break;
                }
            }
            System.out.println("已退出设置模式");
        }
        //用户输入数组长度
        int array_length=0;
        while(true){
            try{
                Scanner sc_array_length=new Scanner(System.in);
                System.out.println("请输入您希望进行排序的数组的长度：");
                array_length=sc_array_length.nextInt();
                if(array_length>0){
                    break;
                }
                else{
                    throw new InputMismatchException("不满足输入的整数应大于0的要求。Not meeting the requirement that the input integer should be greater than 0.");
                }
            }
            catch (InputMismatchException e){
                System.out.println("本程序无法理解您的输入，请您重新输入。");
                System.out.println("注意：您应该输入大于0的整数。");
            }
        }
        //用户输入数组
        int[] array =new int[array_length];
        System.out.println("\n请输入数组\n(本程序仅支持数组元素为整数的数组，数组中的每个值应为整数。)");
        for(int i=0;i<array_length;++i){
            while (true){
                try{
                    Scanner sc_array_element=new Scanner(System.in);
                    System.out.println("请输入数组的第"+(i+1)+"个元素:");
                    array[i]=sc_array_element.nextInt();
                    break;
                }
                catch (InputMismatchException e){
                    System.out.println("本程序无法理解您的输入，请您重新输入。");
                    System.out.println("注意：您应该输入整数。");
                }
            }
        }
        System.out.println("数组输入完成\n");

        //创建用于排序的数组对象
        ArrayForSorting array_for_sorting=new ArrayForSorting(array_length,array);

        //循环地根据用户指示进行操作
        while(true){
            System.out.println("请输入您希望进行的操作：");
            System.out.println("(\t输入“o”并按Enter键显示输入的原始数组；");
            System.out.println("\t输入“c”并按Enter键显示当前数组；");
            System.out.println("\t输入“bs”并按Enter键对当前数组执行冒泡排序；");
            System.out.println("\t输入“ss”并按Enter键对当前数组执行选择排序；");
            System.out.println("\t输入“is”并按Enter键对当前数组执行插入排序；");
            System.out.println("\t输入“r”并按Enter键反转当前数组的顺序；");
            System.out.println("\t输入“e”并按Enter键退出程序。\t)");
            String operation_str=sc.nextLine();
            System.out.println();
            operation_str=operation_str.trim().toLowerCase()+" ";
            if(operation_str.startsWith("o")){
                array_for_sorting.print_original_array();
            } else if (operation_str.startsWith("c")) {
                array_for_sorting.print_current_array();
            } else if (operation_str.startsWith("bs")) {
                array_for_sorting.bubble_sort(show_details);
            } else if (operation_str.startsWith("ss")) {
                array_for_sorting.select_sort(show_details);
            } else if (operation_str.startsWith("is")) {
                array_for_sorting.insertion_sort(show_details);
            } else if (operation_str.startsWith("r")) {
                array_for_sorting.reverse(show_details);
            } else if (operation_str.startsWith("e")) {
                break;
            } else {
                System.out.println("本程序无法理解您的输入，请您重新输入。");
            }
        }

        //输出感谢信息
        System.out.println("感谢您使用本程序");
    }
}
