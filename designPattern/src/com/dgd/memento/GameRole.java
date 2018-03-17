package com.dgd.memento;

/**
 * @Author DGD
 * @date 2018/3/17.
 * 游戏角色类
 */
public class GameRole {
    //角色名
    private String name;
    //生命值
    private int vitality;
    //攻击力
    private int attack;
    //防御力
    private int defense;

    public GameRole(String name) {
        this.name = name;
        this.vitality = 100;
        this.attack = 60;
        this.defense = 50;
    }

    //人物战斗后，生命力、攻击力、防御力减半
    public void fight() {
        this.vitality = this.vitality / 2;
        this.attack = this.attack / 2;
        this.defense = this.defense / 2;
    }

    @Override
    public String toString() {
        return "GameRole{" +
                "name='" + name + '\'' +
                ", vitality=" + vitality +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }

    //创建备忘录对象
    public GamRoleStateMemento createMemento() {
        return new GameRoleState(this.vitality, this.attack, this.defense);
    }
    //重新设置人物角色状态，让其回到备忘录记录的状态
    public void setMemento(GamRoleStateMemento memento) {
        GameRoleState gameRoleState = (GameRoleState) memento;
        this.vitality = gameRoleState.vitality;
        this.attack = gameRoleState.attack;
        this.defense = gameRoleState.defense;
    }
    /**
     * 真正的备忘录对象，设计成内部类，不让外部对象访问
     */
    private static class GameRoleState implements GamRoleStateMemento {
        //保存游戏人物的生命值、攻击力和防御力
        private int vitality;
        private int attack;
        private int defense;

        public GameRoleState(int vitality, int attack, int defense) {
            this.vitality = vitality;
            this.attack = attack;
            this.defense = defense;
        }
    }
}
