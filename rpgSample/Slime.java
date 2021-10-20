package java15.rpgsample.rpgcreature;

import java.util.Random;

/**
 * スライムクラス
 */
public class Slime extends Monster{
    private final static int HP = 12;
    private final static int DEFENCE = 5;
    private final int MAX_NUM = 5;

    /**
     * スライムクラスのコンストラクタ
     */
    public Slime(){
        super("スライム",HP,DEFENCE);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        int damage = r.nextInt(MAX_NUM);
        System.out.printf("%sの攻撃！\n",getName());
        
        opponent.damaged(damage);
        
        displayMessage(opponent,damage);
        
    }
    
}
