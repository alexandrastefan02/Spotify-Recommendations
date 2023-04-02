import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Streamer {
    Integer streamerType;
    Integer id;
    String name;

    public Streamer(Integer streamerType, Integer id, String name) {
        this.streamerType = streamerType;
        this.id = id;
        this.name = name;
    }

    public Integer getStreamerType() {
        return streamerType;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addStream(Integer streamType, Integer id, Integer streamGenre, Long length, String name, Integer streamerId) {
        long unixTime = System.currentTimeMillis() / 1000L;
        Stream s = new Stream(streamType, id, streamGenre, 0L, streamerId, length, unixTime, name);
        ProiectPOO.streamsList.add(s);
    }

    public static String getStreamerNameById(List<Streamer> streamers, Integer streamerId) {
        for (Streamer streamer : streamers) {
            if (streamer.getId().equals(streamerId)) {
                return streamer.getName();
            }
        }
        return null;
    }

    public void listStreams() {
        ObjectMapper mapper = new ObjectMapper();
        for (Stream s : ProiectPOO.streamsList) {
            if (s.streamerId.equals(id)) {
                try {

                    List<StreamsToPrint> personalStreams = new ArrayList<>();
                    String streamerName = Streamer.getStreamerNameById(ProiectPOO.streamersList, id);
                    Format format = Format.getInstance();
                    String data = format.dateFormat(s.dateAdded);
                    String length = format.secondsToTimeFormat(s.length);
                    StreamsToPrint p = new StreamsToPrint(s.id.toString(), s.name, streamerName, s.noOfStreams.toString(), length, data);
                    personalStreams.add(p);
                    // System.out.println(s);
                    String json = mapper.writeValueAsString(personalStreams);
                    System.out.println(json);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    public void deleteStream(Integer streamId) {
        Iterator<Stream> iterator = ProiectPOO.streamsList.iterator();
        while (iterator.hasNext()) {
            Stream s = iterator.next();
            if (s.id.equals(streamId)) {
                iterator.remove();
            }
        }
    }


}
