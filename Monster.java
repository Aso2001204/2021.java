package java15.rpgsample.rpgcreature;

/**
 * モンスターのスーパークラス
 */
public abstract class Monster extends Creature{
    protected boolean escapeFlag = false;
    private final int NOT_HP = 0;

    /**
     * モンスタークラスのコンストラクタ
     * @param name　名前
     * @param hp　モンスターの体力
     */
    public Monster(String name,int hp ,int defence){
        super(name,hp,defence);
    }

    /**
     * 〇〇が現れたを表示するメソッド
     */
    public void displayAppearanceMsg(){
        System.out.printf("%sが現れた！\n",getName());
    }

    /**
     * すでに逃げているかのチェック
     * @return true:逃げている　false：まだ逃げていない
     */
    public boolean isEscaped(){
        return escapeFlag;
    }

    /**
     * モンスターが居るかどうかのチェックメソッド
     * モンスターが居ない＝「モンスターが死んでいる」もしくは「すでに逃げている」
     * @return true:居る false：居ない
     */
    public boolean isThere(){
        return (hp > NOT_HP && !escapeFlag);
    } 

    
}
