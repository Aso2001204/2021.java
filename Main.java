package finalkadai;

public class Main {
    public static void main(String[] args){
        Game[] game = new Game[6];
        for(int i=1 ; i<game.length ; i++){
            if(i<5){
                System.out.println(i + "回目");
            }else{
                Game.end();
                break;
            }
            game[i] = new Game();
            game[i].start();
            if(game[i].isRevenge()==false){
                Game.end();
                break;
            }
        }
    }
    
}