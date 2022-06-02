import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class PlayList {
    private String playListName;
    HashMap<String, Song> playList = new HashMap<>();

    public PlayList(String playListName, HashMap<String, Song> playList) {
        this.playListName = playListName;
        this.playList = playList;
   
    }
    public String getPlayListName() {
        return playListName;
    }
    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }
    public Collection<String> getKeys (){
        return this.playList.keySet();
    }
    public ArrayList <String> getNames (){
        Collection <Song> songs = this.playList.values();
        ArrayList <String> songsNames = new ArrayList<>();
        for (Song song : songs) {
            songsNames.add(song.getTitle());          
        }
        return songsNames; 

    }


}
