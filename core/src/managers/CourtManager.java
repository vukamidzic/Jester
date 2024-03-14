package managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gameObjects.GameObject;
import gameObjects.Killer;
import gameObjects.King;
import gameObjects.Neutral;

import java.util.ArrayList;

public class CourtManager {
    ArrayList<GameObject> people;

    public CourtManager(King king) {
        people = new ArrayList<>();
        populateTable(king);
    }

    public void drawObjects(SpriteBatch batch) {
        for (GameObject object : this.people) {
            object.drawObject(batch);
        }
    }

    private void populateTable(King king) {
        int killerIndex = (int)Math.floor(Math.random() * 8);
        Gdx.app.log("INFO", String.format("Killer pos at table: %d", killerIndex));
        populateLeftSide(king, killerIndex);
        populateRightSide(king, killerIndex);
    }

    private void populateLeftSide(King king, int killerIndex) {
        float space = 100.0f;
        float x = king.getX() + 30.0f, y = king.getY();
        int index;

        for (index = 0; index < 4; ++index) {
            float newX = x - space - king.getWidth()/3;
            GameObject object;

            if (index == killerIndex) {
                object = new Killer(
                        newX,
                        y,
                        king.getWidth() - 100.0f,
                        king.getHeight() - 100.0f,
                        "killer"
                );
            }
            else {
                object = new Neutral(
                        newX,
                        y,
                        king.getWidth() - 100.0f,
                        king.getHeight() - 100.0f,
                        "neutral"
                );
            }

            this.people.add(object);
            x = newX;
        }
    }

    private void populateRightSide(King king, int killerIndex) {
        float space = 100.0f;
        float x = king.getX() + king.getWidth()/2 - 80.0f, y = king.getY();
        int index;

        for (index = 4; index < 8; ++index) {
            float newX = x + space + king.getWidth()/3;
            GameObject object;

            if (index == killerIndex) {
                object = new Killer(
                        newX,
                        y,
                        king.getWidth() - 100.0f,
                        king.getHeight() - 100.0f,
                        "killer"
                );
            }
            else {
                object = new Neutral(
                        newX,
                        y,
                        king.getWidth() - 100.0f,
                        king.getHeight() - 100.0f,
                        "neutral"
                );
            }

            this.people.add(object);
            x = newX;
        }
    }

    // TODO define functions for managing CourtPerson objects
}
