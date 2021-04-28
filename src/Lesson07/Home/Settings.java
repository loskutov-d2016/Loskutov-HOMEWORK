package Lesson07.Home;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private final int Win_WIDTH = 350; //размер (ширина)
    private final int Win_HEIGHT = 250;

    private MainWindow mainWindow;
    private JRadioButton playWithHuman;//радио батон(играть с человеком)
    private JRadioButton playWithAI;

    private JSlider sliderMapSizeSetup;//1 слайдер
    private JSlider sliderWinLengthSetup;//2 слайдер

    private JButton confirmUserSettings;

    private final int MIN_MAP_SIZE = 3; //минимальный размер карты (на старте слайдера)
    private final int MAX_MAP_SIZE = 10;//максимальный размер карты(для слайдера)
    private final int MIN_WIN_LENGTH = 3;
    private final String MAP_SIZE_PREFIX = "MAP size is";
    private final String WIN_LENGTH_PREFIX = "WIN length is";



    Settings(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setupWindow(mainWindow);
        modeGameControllers();
        mapSetupControllers();
        confirUserSetting();
    }
     private void modeGameControllers(){
       add(new JLabel("Choose mode game"));
       //радио батон
        playWithHuman = new JRadioButton("Human vs. Human", true);//при добавлении True, при вызове будет выбран Human
        playWithAI = new JRadioButton("Human vs. AI");//если выбрать True будет выбран изначально AI

       add(playWithHuman);//добавление радио батон на окно
        add(playWithAI);

        ButtonGroup gameModelButtonGroup = new ButtonGroup();
        gameModelButtonGroup.add(playWithHuman);
        gameModelButtonGroup.add(playWithAI);
         add(playWithHuman);
         add(playWithAI);
     }

    private void mapSetupControllers(){
        JLabel labelMapSize = new JLabel(MAP_SIZE_PREFIX + MIN_MAP_SIZE);
        JLabel labelWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        sliderMapSizeSetup = new JSlider(MIN_MAP_SIZE, MAX_MAP_SIZE, MIN_MAP_SIZE); //1слайдер
        sliderMapSizeSetup.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentMapSize = sliderMapSizeSetup.getValue();//чтобы бегунок менял значение
                labelMapSize.setText(MAP_SIZE_PREFIX + currentMapSize);//чтобы бегунок менял значение
                sliderWinLengthSetup.setMaximum(currentMapSize);//чтобы бегунок менял значение

            }
        });
        sliderWinLengthSetup = new JSlider(MIN_WIN_LENGTH, MIN_MAP_SIZE, MIN_MAP_SIZE);//2 слайдер
        sliderWinLengthSetup.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinLength.setText(WIN_LENGTH_PREFIX + sliderWinLengthSetup.getValue());//для того чтобы бегунок менял значения

            }
        });
        add(new JLabel("Choose map size"));
        add(sliderMapSizeSetup);
        add(labelMapSize);
        add(new JLabel("Choose Win length"));
        add(labelWinLength);
        add(sliderWinLengthSetup);
    }
    private void confirUserSetting(){
        confirmUserSettings = new JButton("Start game with settings");
        confirmUserSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectUserSettings();

            }
        });
        add(confirmUserSettings);

    }

    private void setupWindow(MainWindow mainWindow) {
        setSize(Win_WIDTH, Win_HEIGHT);
        Rectangle mainWindowParams = mainWindow.getBounds();
        int posWindowX = (int) mainWindowParams.getCenterX() - Win_WIDTH / 2;//поместить вспываюшее окно по середине основного окна
        int posWindowY = (int) mainWindowParams.getCenterY() - Win_HEIGHT / 2;

        setLocation(posWindowX, posWindowY);

        setTitle("Settings");
        setResizable(false);
        setLayout(new GridLayout(10,1));

    }
    private void collectUserSettings() {
        int gameMode;

        if (playWithHuman.isSelected()) {
            gameMode = GameMap.GAME_MODE_HVH;
        } else  if (playWithAI.isSelected()) {
            gameMode = GameMap.GAME_MODE_HVA;

        } else {
            throw  new RuntimeException("Something wrong: Cause incorrect game mode");
        }

        int mapSize = sliderMapSizeSetup.getValue();
        int winLen = sliderWinLengthSetup.getValue();
        mainWindow.startGameWithUserSetting(gameMode, mapSize, mapSize, winLen);
        setVisible(false);

    }
}
