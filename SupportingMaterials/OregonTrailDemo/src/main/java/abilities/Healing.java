package abilities;

import player.Traveller;

public interface Healing {

    //abstract method
    Traveller heal(Traveller sickTraveler);
    Traveller giveMedicine(Traveller sickTraveler);
    Traveller cureDysentery(Traveller sickTraveler);

}
