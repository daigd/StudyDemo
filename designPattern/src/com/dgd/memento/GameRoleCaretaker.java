package com.dgd.memento;

/**
 * @Author DGD
 * @date 2018/3/17.
 * 游戏人物备忘录对象管理者
 */
public class GameRoleCaretaker {
    //记录被保存的备忘录对象
    private GamRoleStateMemento memento;

    public void saveGameRoleMemento(GamRoleStateMemento memento) {
        this.memento = memento;
    }

    public GamRoleStateMemento retrieveGameRoleMemento() {
        return this.memento;
    }
}
