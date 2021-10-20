package java15.rpgsample.rpgcreature;

import java.util.Random;

/**
 * 魔法使いクラス
 */
public class Wizard extends Monster{
    private final static int HP = 30;
    private final static int DEFENCE = 10;

    private final int MAX_INT = 100;
    private final int PARSE_INT = 70;
    private final int NOMAL_DAMAGAE = 5;
    private final int PULUS_NUM = 1;
    private final int MAX_NUM = 10;
    /**
     * 魔法使いのコンストラクタ
     */
    public Wizard(){
        super("魔法使い",HP,DEFENCE);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        int damage = 0;
        if( r.nextInt(MAX_INT) < PARSE_INT){
            System.out.printf("%sは魔法を唱えた！\n",getName());
            damage = r.nextInt(MAX_NUM)+NOMAL_DAMAGAE;
        }else{
            System.out.printf("%sの攻撃！\n",getName());
            damage = r.nextInt(NOMAL_DAMAGAE)+PULUS_NUM;
        }
        opponent.damaged(damage);
        
        displayMessage(opponent,damage);
        
    }
}
