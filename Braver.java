package java15.rpgsample.rpgcreature;

import java.util.Random;

/**
 * 勇者クラス
 */
public class Braver extends Creature{
    private int coin = 0;

    private final static int MAX_HP = 100;
    private final static int RECOVERY_POINT = 20;
    private final static int CRITICAL_HIT_RATE = 10;
    private final int NOT_HP = 0;
    private final int MAX_NUM = 100;

    /**
     * 勇者クラスのコンストラクタ
     */
    public Braver(String name){
        super(name,MAX_HP);
    }
    
    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent){
        coin = opponent.getHp();
        Random r = new Random();
        int damage = NOT_HP;
        System.out.printf("%sの攻撃！\n",getName());

        //クリティカルヒットかのチェック
        if( r.nextInt(MAX_NUM) < CRITICAL_HIT_RATE ){
            //クリティカルヒット
            damage = 50;
            System.out.printf("%sのクリティカルヒット！\n",getName());
        }else{
            damage = r.nextInt(CRITICAL_HIT_RATE)+1;
            
        }
        damage -= opponent.getDefence();
        damage = damage<0? 0 : damage;
        opponent.damaged(damage);
        
        displayMessage(opponent,damage);
    }

    /**
     * HP回復処理
     */
    public void recovery(){
        System.out.printf("%sはHPを回復した！\n",getName());
        hp += RECOVERY_POINT;
        if( hp > MAX_HP ){
            hp = MAX_HP;
        }
    }

    public  int getCoin() {
        return this.coin;
    }
}
