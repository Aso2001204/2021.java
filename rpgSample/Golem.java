package java15.rpgsample.rpgcreature;
import java.util.Random;

public class Golem extends Monster {
    private final static int HP = 100;
    private final int MAX_INT = 100;
    private final int PROVALITY = 5;
    private final static int DEFENCE = 30;
    
    public Golem(){
        super("ゴーレム",HP,DEFENCE);
    }

    // 攻撃メソッド
    @Override
    public void attack(Creature opponent){
        Random r = new Random();
        int damage = 30;
        if(r.nextInt(MAX_INT) <= PROVALITY ){
            System.out.println("ゴーレムのクリティカルダメージ！！");
        }else{
            damage = r.nextInt(4)+5;
        }
        opponent.damaged(damage);
    }
}
