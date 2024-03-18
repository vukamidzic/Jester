package managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gameObjects.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CourtManager {
    ArrayList<CourtPerson> people;

    public CourtManager(King king) {
        people = new ArrayList<>();
        populateTable(king);
    }

    public ArrayList<CourtPerson> getPeople() {
        return this.people;
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
        CourtPerson.Party currParty = CourtPerson.Party.RED;
        ArrayList<String> personTypes = new ArrayList<>();
        personTypes.add("noble");
        personTypes.add("lady");
        personTypes.add("knight");


        float space = 100.0f;
        float x = king.getX() + 30.0f, y = king.getY();
        int index;

        for (index = 0; index < 4; ++index) {
            float newX = x - space - king.getWidth()/3;
            String objectName = personTypes.get((int)Math.floor(Math.random()*3));
            CourtPerson person;

            if (index == killerIndex) {
                person = new Killer(
                        newX,
                        y,
                        king.getWidth() - 100.0f,
                        king.getHeight() - 100.0f,
                        String.format("%s_%s_idle", objectName, currParty.toString().toLowerCase())
                );
            }
            else {
                person = new Neutral(
                        newX,
                        y,
                        king.getWidth() - 100.0f,
                        king.getHeight() - 100.0f,
                        String.format("%s_%s_idle", objectName, currParty.toString().toLowerCase())
                );
            }
            person.setParty(currParty);
            currParty = (currParty == CourtPerson.Party.RED) ?
                    CourtPerson.Party.BLACK :
                    CourtPerson.Party.RED;

            this.people.add(person);
            x = newX;
        }
    }

    private void populateRightSide(King king, int killerIndex) {
        CourtPerson.Party currParty = CourtPerson.Party.BLACK;
        ArrayList<String> personTypes = new ArrayList<>();
        personTypes.add("noble");
        personTypes.add("lady");
        personTypes.add("knight");

        float space = 100.0f;
        float x = king.getX() + king.getWidth()/2 - 80.0f, y = king.getY();
        int index;

        for (index = 4; index < 8; ++index) {
            float newX = x + space + king.getWidth()/3;
            String objectName = personTypes.get((int)Math.floor(Math.random()*3));
            CourtPerson person;

            if (index == killerIndex) {
                person = new Killer(
                        newX,
                        y,
                        king.getWidth() - 100.0f,
                        king.getHeight() - 100.0f,
                        String.format("%s_%s_idle", objectName, currParty.toString().toLowerCase())
                );
            }
            else {
                person = new Neutral(
                        newX,
                        y,
                        king.getWidth() - 100.0f,
                        king.getHeight() - 100.0f,
                        String.format("%s_%s_idle", objectName, currParty.toString().toLowerCase())
                );
            }
            person.setParty(currParty);
            currParty = (currParty == CourtPerson.Party.BLACK) ?
                    CourtPerson.Party.RED :
                    CourtPerson.Party.BLACK;

            this.people.add(person);
            x = newX;
        }
    }

    // TODO define functions for managing CourtPerson objects
}
