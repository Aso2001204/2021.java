package finalkadai;
import java.util.*;

public class Game {
    static Scanner sc = new Scanner(System.in);
    public static String[][] goban = new String[5][5];
    public int x;
    public int y;
    public int rand;
    private String ans;
    private boolean revenge;

    public void start(){
        System.out.print("====================\n"+
                         "   戦艦ゲーム開始\n"+
                         "====================\n");
        System.out.println("フィールドは正方形です。");
        System.out.print("数字を入力してください\n");
        rand = Integer.parseInt(sc.next());
        System.out.println("船の数を入力してください");
        int sum = Integer.parseInt(sc.next());
        Ship[] ship = new Ship[sum];
        for(int i=0 ; i<ship.length ; i++){
            String name = inputName();
            ship[i] = new Ship(name,rand);
            setGoban(ship[i],ship[i].getName(),ship[i].getX(),ship[i].getY());
        }
        batleShip(ship);
        
    }
    public boolean isRevenge() {
        return revenge;
    }
    public void setRevenge(boolean revenge) {
        this.revenge = revenge;
    }
    public String getAns() {
        return ans;
    }
    public void setAns(String ans) {
        this.ans = ans;
    }
    //名前の入力受付
    public static String inputName(){
        System.out.println("好きな船の名前を入力してください");
        String name = sc.next();
        return name;
    }
    //フィールドに船を設置
    public void setGoban(Ship ship,String name ,int x,int y){
        while(goban[y][x] != null){
            ship.changeSet(rand);
        }
        goban[y][x] = name;
    }

    //バトルシーン
    public void batleShip(Ship[] ship){
        int turnCount = 1;
        while(checkShip(ship) == true ){
            if(turnCount<10){
                System.out.println(turnCount + "ターン目！");
            }else if(turnCount==10){
                System.out.println("最終ターンです！ファイト！！");
            }else{
                gameOver();
                break;
            }
            System.out.println("1～5の間で数字を入力してください");
            System.out.println("X座標を入力してください");
            int x = sc.nextInt() -1;
            x = checkIndex(x,rand);
            System.out.println("Y座標を入力してください");
            int y = sc.nextInt() -1;
            y = checkIndex(y,rand);
            Random random = new Random();
            int critical = random.nextInt(1000); 
            for(int i=0 ; i<ship.length ; i++){
                if(critical != 777){
                    if(ship[i].getHp() > 0){
                        if(Math.abs(ship[i].getX()-x)==1 && Math.abs(ship[i].getY()-y)==1){
                            System.out.println( ship[i].getName() + "：波高し");

                        }else if(ship[i].getX()==x && ship[i].getY()==y ){
                            ship[i].minusHp();
                            ship[i].changeSet(rand);
                            System.out.println(ship[i].getName() + "：命中");
                        }else{
                            System.out.println(ship[i].getName() + "：外れました");
                        }
                    }else{
                        System.out.println(ship[i].getName() + "：沈没");
                    }
                }else{
                    System.out.println("出ました！クリティカルヒット！");
                    System.out.println("＠＠＠＠＠　全艦殲滅成功　＠＠＠＠＠");
                    end();
                }
            }
            turnCount++;
        }
    }

    public boolean checkShip(Ship[] ship){
        boolean ans = true;
        int cnt = 0;
        for(Ship i : ship){
            if(i.getHp() == 0){
                cnt++;
            }
        }
        if(cnt==3){
            ans =false;
        }
        return ans;
    }

    public int checkIndex(int a , int max){
        while(booleanIndex(a,max)==false){
            System.out.println("1~"+ max + "の間の数字を入力してください");
            a = sc.nextInt();
        }
        return a;
    }

    public boolean booleanIndex(int a, int max){
        boolean ans = false;
        if(a>0 && a<=max){
            ans = true;
        }
        return ans;
    }

    //ゲームエンド
    public static void end(){
        System.out.println("======   GAME END   =====");
    }

    public void gameOver(){
        System.out.println("10ターン以内に殲滅できませんでした。");
        System.out.println("*****  GAME OVER  *****");
        System.out.println("もう一度挑戦しますか？");
        System.out.println("yes か  no  で答えてください");
        ans = sc.next();
        checkRevenge();
    }
    public void checkRevenge(){
        if(ans.equals("yes")|| ans.equals("YES")){
            revenge = true;
        }else{
            revenge =false;
        }
    }
}
