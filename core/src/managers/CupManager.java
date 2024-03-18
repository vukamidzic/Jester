package managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gameObjects.CourtPerson;
import gameObjects.Cup;
import gameObjects.GameObject;

import java.util.ArrayList;

public class CupManager {
    ArrayList<GameObject> cups;

    public CupManager(CourtManager courtManager) {
        cups = new ArrayList<>();
        placeCups(courtManager);
    }

    public void drawObjects(SpriteBatch batch) {
        for (GameObject object : this.cups) {
            object.drawObject(batch);
        }
    }

    private void placeCups(CourtManager courtManager) {
        ArrayList<CourtPerson> people = courtManager.getPeople();

        for (CourtPerson person : people) {
            float x = person.getX(), y = person.getY();
            int toPlace = (int)Math.floor(Math.random()*2);

            if (toPlace == 1) {
                Cup cup = new Cup(
                        x,
                        y,
                        100.0f,
                        100.0f,
                        "cup"
                );
                this.cups.add(cup);
            }
        }
    }
}
