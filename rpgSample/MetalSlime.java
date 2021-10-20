package java15.rpgsample.rpgcreature;

import java.util.Random;

/**
 * メタルスライムクラス
 */
public class MetalSlime extends Monster{
    private final static int MAX_NUM = 100;
    private final static int ESCAPE_RATE = 40;
    private final static int HP = 12;
    private final static int DEFENCE = 100;
    /**
     * メタルスライムのコンストラクタ
     */
    public MetalSlime(){
        super("メタルスライム",HP,DEFENCE);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        if( r.nextInt(MAX_NUM) < ESCAPE_RATE ){
            System.out.printf("%sは逃げ出した！\n",getName());
            escapeFlag = true;
        }else{
            int damage = r.nextInt(5);
            System.out.printf("%sの攻撃！\n",getName());
            
            opponent.damaged(damage);
            
            displayMessage(opponent,damage);
        }
    }
}
