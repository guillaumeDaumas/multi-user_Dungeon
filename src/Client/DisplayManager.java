package Client;

import Server.Entity;
import Server.Server_Interface.IChatServer;
import Server.Server_Interface.IGameServer;
import Server.Room;
import Tools.Colors;
import javafx.util.Pair;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import static Tools.Text.instruction;

public class DisplayManager {
    private List<Avatar> playerList; //liste des joueur sur la même case
    private Avatar myAvatar;

    public DisplayManager(Avatar myAvatar) {
        this.playerList = new LinkedList<>();
        this.myAvatar = myAvatar;
    }

    public void updateList(IChatServer cs){
        try {
            playerList=cs.getNeighbour(myAvatar);
        } catch (RemoteException e) {
            System.out.println("impossible de mettre a jour la liste des voisins");
        }
    }

    public void clearScreen(){
        for(int i = 0 ; i < 20; i++)
            System.out.println("\n");
    }

    public void displayNeighbour(IChatServer cs){
        updateList(cs);
        System.out.println("Player in the same room :");
        for( Avatar av : playerList){
            System.out.println(av.getName());
        }
    }

    /**
     * Affiche les informations relatives à la position
     * -n° de la salle et portes
     * nom et point de vie du monstre
     * nbr d'utilisateur dans la salle
     * @param gs
     * serveur de jeu courant
     * @param cs
     * serveur de chat courant
     */
    public void displayPosition(IGameServer gs, IChatServer cs){
        Pair<Room, Entity> result = null;
        try {
            result = gs.getRoomInfo(myAvatar);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Room currentRoom = result.getKey();
        Entity monster = result.getValue();
        updateList(cs);
        System.out.println("         N");
        System.out.println("   ◼ ▬ "+currentRoom.getNorth()+" "+currentRoom.getNorth()+" "+currentRoom.getNorth() +" ▬ ◼");
        System.out.println("   ▮           ▮"+"     Monster's name : "+instruction(monster.getName()));
        System.out.println("   "+currentRoom.getWest()+"           "+currentRoom.getEast()+"     Monster's life point : "+instruction(monster.getLifePoint().toString()));
        System.out.println(" W "+currentRoom.getWest()+"    "+instruction(parsePosition(currentRoom.getId()))+"    "+currentRoom.getEast()+" E   "+instruction(playerList.size()+" ")+"players in your room");
        System.out.println("   "+currentRoom.getWest()+"           "+currentRoom.getEast());
        System.out.println("   ▮           ▮");
        System.out.println("   ◼ ▬ "+currentRoom.getSouth()+" "+currentRoom.getSouth()+" "+currentRoom.getSouth() +" ▬ ◼");
        System.out.println("         S");
        //System.out.println(currentRoom.getNorth().toString()+" "+currentRoom.getEast().toString()+" "+monster.getName()+" "+monster.getLifePoint()+"□");
    }

    public String parsePosition(Integer position){
        if(position<100){
            if(position<10){
                if(position<1){
                    return "000";
                }
                return "00"+position;
            }
            return "0"+position;
        }
        return position.toString();
    }

    public void help(){
        System.out.println("command list :");
        System.out.println("-To speak with people in your room");
        System.out.println("\t"+ Colors.blue+"/"+Colors.reset+" 'message'");
        System.out.println("-To escape from a room/battle");
        System.out.println("\t"+Colors.blue+"Escape 'dest'"+Colors.reset+" or "+Colors.blue+"E 'dest' "+Colors.reset+"or "+Colors.blue+"e 'dest'"+Colors.reset);
        System.out.println("\t#where 'dest' can be N (North), E (East), S (South) or W (West)");
        System.out.println("\t#Be careful if you run away, you will loose some life points");
        System.out.println("-To print this help message");
        System.out.println(Colors.blue+"\tHelp "+Colors.reset+"or"+Colors.blue+" H "+Colors.reset+"or"+Colors.blue+" h"+Colors.reset);
        System.out.println("-To display game info");
        System.out.println(Colors.blue+"\tInfo "+Colors.reset+"or"+Colors.blue+" I "+Colors.reset+"or"+Colors.blue+" i"+Colors.reset);
        System.out.println("-To move on the board");
        System.out.println(Colors.blue+"\tMove 'dest'"+Colors.reset+" or"+Colors.blue+" M 'dest' "+Colors.reset+"or"+Colors.blue+" m 'dest'"+Colors.reset);
        System.out.println("\t#where 'dest' can be N (North), E (East), S (South) or W (West)");
        System.out.println("-To display players in your room");
        System.out.println(Colors.blue+"\tNeighbour"+Colors.reset+" or"+Colors.blue+" N "+Colors.reset+"or"+Colors.blue+" n"+Colors.reset);
        System.out.println("-To quit the game");
        System.out.println(Colors.blue+"\tExit"+Colors.reset);
    }



}
