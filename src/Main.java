import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import java.awt.*;

@ScriptManifest(name = "First Script", author = "Bombur", version = 0.1, info = "", logo = "")

public class Main extends Script {

    @Override
    public void onStart() {
        //Code here will execute before the loop is started
    }

    @Override
    public void onExit() {
        //Code here will execute after the script ends

    }

    @Override
    public int onLoop() {
        return 100; //The amount of time in milliseconds before the loop starts over
    }

    @Override
    public void onPaint(Graphics2D g) {
        //This is where you will put your code for paint(s)
    }

}