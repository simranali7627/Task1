public class Drone {
    int posX;
    int posY;
    Drone(int x, int y){
        posX = x;
        posY = y;
    }

    @Override
    public String toString() {
        return " " + posX +
                " " + posY ;
    }
}
