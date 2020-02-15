package com.jiker.keju;

public class AppRunner {

    public static void main(String[] args) {
        /*TODO
          args[0]为resources下的测试数据文件名。
          读取测试数据文件作为你程序的输入参数，
          并将结果保存到receipt变量中。
         */
        String testDataFile = args[0];
        String receipt = new Receipt(testDataFile).bill() + "\n";
        System.out.println(receipt);
    }
}
