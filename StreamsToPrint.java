import java.util.List;

public class StreamsToPrint {
    public String id;
    public String name;
    public String streamerName;
    public String noOfListenings;
    public String length;
    public String dateAdded;


    public StreamsToPrint(String id, String name, String streamerName, String noOfListenings, String length, String dateAdded) {
        this.id = id;
        this.name = name;
        this.streamerName = streamerName;
        this.noOfListenings = noOfListenings;
        this.length = length;
        this.dateAdded = dateAdded;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreamerName(String streamerName) {
        this.streamerName = streamerName;
    }

    public void setNoOfListenings(String noOfListenings) {
        this.noOfListenings = noOfListenings;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
