import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class MainLibrary {
    private BufferedReader reader;
    private String line;
    private String components[] = null;
    private HashMap<String, Song> mainLibrary = new HashMap<>();

    private HashMap<String, Song> readFile(String FileName) {
        //System.out.println("Method readFile");
        try {
            //System.out.println("readFile catch");
            reader = new BufferedReader(new FileReader(FileName));
            while ((line = reader.readLine()) != null) {
                components = line.split(",");
                mapLine(components);
            }
            reader.close();
            line = null;
            components = null;
        } catch (Exception e) {
            System.out.println("Main library has been created:");
        }
        //System.out.println(this.mainLibrary);
        return this.mainLibrary;
    }

    private void mapLine(String[] components) {

        String title=components[0];
        String songID=components[1];
        String date=components[2];
        String length=components[3];
        String genre=components[4];
        String cover=components[5];
        String description=components[6];

        //System.out.print("Archivo "+components[1]+" :");

        //System.out.println(title +", "+ songID +", "+ date +", "+ length +", "+ genre +", "+ cover +", "+ description);
        Song newSong = new Song(title, songID, date, length, genre, cover, description);
        this.mainLibrary.put(newSong.getSongID(),newSong);
    }
    
    private PlayList createMainPlaylistHashMap (HashMap<String, Song> mainLibrary){
        
        return new PlayList("Main_Library", mainLibrary);
    }
    public PlayList createMainLibrary (String Filename){
        return createMainPlaylistHashMap(readFile(Filename));
    }
    

}
