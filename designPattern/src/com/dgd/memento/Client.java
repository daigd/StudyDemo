package com.dgd.memento;

/**
 * @Author DGD
 * @date 2018/3/17.
 */
public class Client {
    public static void main(String[] args) {
        //创建一个游戏人物对象
        GameRole gameRole = new GameRole("小天使");
        //查看当前人物属性
        System.out.println("战斗前:");
        System.out.println(gameRole.toString());

        //跟BOSS大战一场前先保存下进度
        GameRoleCaretaker caretaker = new GameRoleCaretaker();
        caretaker.saveGameRoleMemento(gameRole.createMemento());

        //战斗
        gameRole.fight();

        //查看当前人物属性
        System.out.println("战斗后:");
        System.out.println(gameRole.toString());

        //恢复
        gameRole.setMemento(caretaker.retrieveGameRoleMemento());

        //再查看当前人物属性
        System.out.println("回跳至进度保存的时刻:");
        System.out.println(gameRole.toString());
    }
}
