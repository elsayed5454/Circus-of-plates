package eg.edu.alexu.csd.oop.game.view;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.model.Strategy.IStrategy;
import eg.edu.alexu.csd.oop.game.model.world.Circus;

import javax.swing.*;

public class MenuBar {

    private World circus;
    private IStrategy strategy;
    private  int width;
    private int height;

    public MenuBar (World circus, IStrategy strategy, int width, int height) {

        this.circus = circus;
        this.strategy = strategy;
        this.width = width;
        this.height = height;
    }

    public void generate() {

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        //option for creating a new game
        JMenuItem newMenuItem = new JMenuItem("New");

        //option for pausing the current game
        JMenuItem pauseMenuItem = new JMenuItem("Pause");

        //option for resuming the current game
        JMenuItem resumeMenuItem = new JMenuItem("Resume");

        //option for exiting the game
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        menu.add(newMenuItem);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menu.add(exitMenuItem);

        menuBar.add(menu);

        final GameEngine.GameController gameController = GameEngine.start("Game", circus, menuBar);

        newMenuItem.addActionListener(e -> gameController.changeWorld(new Circus(width, height, strategy)));

        pauseMenuItem.addActionListener(e -> gameController.pause());

        resumeMenuItem.addActionListener(e -> gameController.resume());

        exitMenuItem.addActionListener(e -> System.exit(0));
    }

}