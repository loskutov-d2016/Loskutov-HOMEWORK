package Lesson07.Home;

public class GameMap {
    public static final int GAME_MODE_HVH = 0;
    public static final int GAME_MODE_HVA = 1;

    GameMap() {
    }
    void startGame(int modeGame, int mapSizeX,int mapSixeY, int winLength){
        System.out.println("mode = \n" + modeGame +
                "\nmapSizeX = " + mapSizeX +
                "\nmapSizeY = " + mapSixeY +
                "\nwinLength = " + winLength);
    }
}
