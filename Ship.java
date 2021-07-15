package finalkadai;
import java.util.*;

public class Ship {
    private String name;
    private int hp;
    private int x;
    private int y;
    Random random = new Random();


    public Ship(String name,int rand){
        setName(name);
        this.hp = 3;
        setX(rand);
        setY(rand);
    }

    public int getY() {
        return y;
    }

    public void setY(int rand) {
        this.y = setRandom(rand);
    }

    public int getX() {
        return x;
    }

    public void setX(int rand) {
        this.x = setRandom(rand);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int setRandom(int rand){
        return random.nextInt(rand);
    }

    public void changeSet(int rand){
        this.setX(rand);
        this.setY(rand);
    }

    public void minusHp(){
        hp -= 1;
    }
}
    

