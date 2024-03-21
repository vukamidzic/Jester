package managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gameObjects.CourtPerson;
import gameObjects.Cup;
import gameObjects.GameObject;
import gameObjects.Killer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CupManager {
    List<Cup> cups;

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
                Cup cup = new Cup(x, y, 100.0f, 100.0f, "cup");
                if (person instanceof Killer) cup.poisoned = true;
                this.cups.add(cup);
            }
        }
    }

    public void moveCups(CourtManager courtManager) {
        ArrayList<CourtPerson> people = courtManager.getPeople();
        for (int i = 0; i < this.cups.size(); ++i) {
            int personIndex = courtManager.getPersonIndex(this.cups.get(i));
            System.err.println("Cup index: " + personIndex);
            if (personIndex <= 3) {
                if (personIndex == 3) {
                    this.cups.set(i, null);
                }
                else {
                    this.cups.get(i).setX(people.get(personIndex+1).getX());
                    this.cups.get(i).setY(people.get(personIndex+1).getY());
                }
            }
            else {
                if (personIndex == 4) {
                    this.cups.set(i, null);
                }
                else {
                    this.cups.get(i).setX(people.get(personIndex-1).getX());
                    this.cups.get(i).setY(people.get(personIndex-1).getY());
                }
            }
        }

        this.cups.removeIf(Objects::isNull);
        this.cups.add(new Cup(
           people.get(0).getX(), people.get(0).getY(), 100.0f, 100.0f, "cup"
        ));
        this.cups.add(new Cup(
                people.get(7).getX(), people.get(0).getY(), 100.0f, 100.0f, "cup"
        ));
    }
}
