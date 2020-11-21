import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import java.awt.*;
import org.osbot.rs07.utility.ConditionalSleep;

@ScriptManifest(name = "First Script", author = "Bombur", version = 0.1, info = "", logo = "")

public class Main extends Script {

    @Override
    public void onStart() {
        log("Starting script.");
    }

    @Override
    public void onExit() {
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
                    sleep(random(100, 250));
                }
            }

        return random(1000, 2000); //The amount of time in milliseconds before the loop starts over
    }


    @Override
    public void onPaint(Graphics2D g) {
        //This is where you will put your code for paint(s)
    }

}