package core;

import gui.GUI;
import gui.Tree;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

@ScriptManifest(name = "First Script", author = "Bombur", version = 0.1, info = "", logo = "")

public class Main extends Script {

    private GUI gui = new GUI();
    private Tree tree;

    @Override
    public void onStart() {
        try {
            SwingUtilities.invokeAndWait(() -> {
                gui = new GUI();
                gui.open();
            });
        }

        catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
            stop();
            return;
        }

        if (!gui.isStarted()) {
            stop();
            return;
        }

        tree = gui.getSelectedTree();
        log("Starting script.");
    }

    @Override
    public void onExit() {
        if (gui != null) {
            gui.close();
        }

        log("Stopping script.");
    }

    @Override
    public int onLoop() throws InterruptedException {
            RS2Object willowTree = getObjects().closest("Willow");

            if (willowTree != null && !myPlayer().isAnimating() && !getInventory().isFull()) {
                sleep(random(500, 1000));
                log("Clicking willow tree.");
                willowTree.interact("Chop down");
            }
            else if (getInventory().isFull()) {
                sleep(random(500, 1000));
                while (!getInventory().isEmpty()) {
                    getInventory().drop("Willow logs");
                    sleep(random(250, 500));
                }
            }

        return random(1000, 2000); //The amount of time in milliseconds before the loop starts over
    }


    @Override
    public void onPaint(Graphics2D g) {
        //This is where you will put your code for paint(s)
    }

}