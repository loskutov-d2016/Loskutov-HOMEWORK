package Lesson07.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private final int Win_WIDTH = 500; //размер (ширина)
    private final int Win_HEIGHT = 500; //размер (высота)
    private final int Win_POS_X = 600;//начало отрисовки окна
    private final int Win_POS_Y = 200;

    private Settings settingsWindow;
    private GameMap gameMap;

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(Win_WIDTH, Win_HEIGHT);
        setLocation(Win_POS_X, Win_POS_Y);
        setTitle("OUR GAME");
        setResizable(false);//true - разрешает изменять окно
        settingsWindow = new Settings(this);
        gameMap = new GameMap();


        JButton btnStartGame = new JButton("Start New Game");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        JButton btnExitGame = new JButton("Exit Game");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel containerForButton = new JPanel();
        containerForButton.setLayout(new GridLayout(1, 2)); //созданные ранее кнопки распологаем внизу(пространство делится на 2 части)
        containerForButton.add(btnStartGame);
        containerForButton.add(btnExitGame);

        add(containerForButton, BorderLayout.SOUTH);

        setVisible(true);
    }
    void startGameWithUserSetting(int modeGame,int mapSizeX, int mapSizeY, int winLength) {
        gameMap.startGame(modeGame, mapSizeX, mapSizeY, winLength);
    }
}

