import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadCSV {
    public static void readStreamers(String streamers) {
        FileReader reader = null;
        try {
            reader = new FileReader(streamers);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Iterable<CSVRecord> records = null;
        try {
            records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (CSVRecord record : records) {
            String streamerType = record.get("streamerType");
            String id = record.get("id");
            String name = record.get("name");
            Streamer streamer = new Streamer(Integer.valueOf(streamerType), Integer.valueOf(id), name);
            ProiectPOO.streamersList.add(streamer);
        }
    }

    public static void readStreams(String streams) {
        FileReader reader = null;
        try {
            reader = new FileReader(streams);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Iterable<CSVRecord> records1 = null;
        try {
            records1 = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (CSVRecord record : records1) {
            String streamType = record.get("streamType");
            String id = record.get("id");
            String streamGenre = record.get("streamGenre");
            String noOfStreams = record.get("noOfStreams");
            String streamerId = record.get("streamerId");
            String length = record.get("length");
            String dateAdded = record.get("dateAdded");
            String name = record.get("name");

            Stream stream = new Stream(Integer.valueOf(streamType), Integer.valueOf(id), Integer.valueOf(streamGenre), Long.valueOf(noOfStreams), Integer.valueOf(streamerId), Long.valueOf(length), Long.valueOf(dateAdded), name);
            ProiectPOO.streamsList.add(stream);

        }
    }

    public static void readUsers(String users) {
        FileReader reader = null;
        try {
            reader = new FileReader(users);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Iterable<CSVRecord> records2 = null;
        try {
            records2 = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (CSVRecord record : records2) {
            String id = record.get("id");
            String name = record.get("name");
            User user = new User(Integer.valueOf(id), name);
            ProiectPOO.usersList.add(user);
            String idString = record.get("streams");
            String[] ids = idString.split(" ");
            List<String> streamsOfUser = new ArrayList<>();
            for (String i : ids) {
                streamsOfUser.add(i);

            }
            ProiectPOO.map.put(id, streamsOfUser);
        }
    }
}
