package gameObjects;

public class CourtPerson extends GameObject {
    State state;
    Party party;

    public CourtPerson(float _x, float _y, float _width, float _height, String _name) {
        super(_x, _y, _width, _height, _name);
        this.state = State.IDLE;
    }

    public void setParty(Party _party) { this.party = _party; }

    enum State {IDLE, CHEERFUL, OFFENDED }

    // yet to be changed
    public enum Party { RED, BLACK }
}
