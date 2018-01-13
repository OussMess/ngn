package RTP;

import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;

public class Receive {
    Player Player;
    public void rec(String ipAdress) {

        try {

            // medialocator to receive data from this url : includes the sender that we want to receive data from
            MediaLocator url = new MediaLocator("rtp://"+ ipAdress +":10000/audio");

            //creating a player to receive data
            Player = Manager.createRealizedPlayer(url);
            Player.start();
        } catch (Exception ex) {
        }

    }
    public void stoprec(){
        Player.close();
    }
}
