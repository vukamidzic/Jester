package gameObjects;

public class CourtPerson extends GameObject {
    enum State {
        IDLE,
        CHEERFUL,
        OFFENDED
    }

    // yet to be changed
    enum Party {
        RED,
        BLUE
    }

    State state;
    Party party;

    public CourtPerson(float _x, float _y, float _width, float _height, String _name) {
        super(_x, _y, _width, _height, _name);
    }
}
