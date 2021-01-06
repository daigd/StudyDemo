package com.dgd.jvmdemo.oom;

/**
 * @author : DaiGD
 * @createtime :  2021年01月05日 11:20
 * @description : 演示栈溢出异常：VM Args：-Xss128k
 */
public class JVMStacksOF
{
    private int stackLength = 1;

    public void stackLeak()
    {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args)
    {
        System.out.println("JVMStacksOF");
        JVMStacksOF oom = new JVMStacksOF();
        try
        {
            oom.stackLeak();
        }
        catch (Throwable e) {
            System.out.println("stack Length:" + oom.stackLength);
            throw e;

        }
    }
}
