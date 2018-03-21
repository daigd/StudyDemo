package com.dgd.singleton;

/**
 * @Author DGD
 * @date 2018/3/21.
 */
public class Client {
    public static void main(String[] args) {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        System.out.println(hungrySingleton == hungrySingleton1);

        DoubleCheckSingleton doubleCheckSingleton = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton doubleCheckSingleton1 = DoubleCheckSingleton.getInstance();
        System.out.println(doubleCheckSingleton == doubleCheckSingleton1);

        LasyHolderSingleton lasyHolderSingleton = LasyHolderSingleton.getInstance();
        LasyHolderSingleton lasyHolderSingleton1 = LasyHolderSingleton.getInstance();
        System.out.println(lasyHolderSingleton == lasyHolderSingleton1);

        EnumSingleton enumSingleton = EnumSingleton.instance;
        EnumSingleton enumSingleton1 = EnumSingleton.instance;
        System.out.println(enumSingleton == enumSingleton1);

    }
}
