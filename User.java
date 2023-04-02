import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.stream.Streams;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class User {
    Integer id;
    String name;
    List<Integer> streams;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void listHistory() {
        ObjectMapper mapper = new ObjectMapper();
        List<String> list = ProiectPOO.map.get(id.toString());
        for (String i : list) {
            Stream s = Stream.getStreamById(Integer.valueOf(i));
            try {
                List<StreamsToPrint> personalStreams = new ArrayList<>();
                String streamerName = Streamer.getStreamerNameById(ProiectPOO.streamersList, s.streamerId);
                Format format = Format.getInstance();
                String data = format.dateFormat(s.dateAdded);
                String length = format.secondsToTimeFormat(s.length);
                StreamsToPrint p = new StreamsToPrint(s.id.toString(), s.name, streamerName, s.noOfStreams.toString(), length, data);
                personalStreams.add(p);
                String json = mapper.writeValueAsString(personalStreams);
                System.out.println(json);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void listen(Stream stream) {
        List<String> streams = ProiectPOO.map.getOrDefault(id.toString(), new ArrayList<>());
        streams.add(stream.id.toString());
        ProiectPOO.map.put(id.toString(), streams);
    }

    public List<String> checkIfLikeStreamer() {
        List<String> likedStreamers = new ArrayList<>();
        List<String> listenedStreams = ProiectPOO.map.getOrDefault(id.toString(), new ArrayList<>());
        Iterator<String> iterator = listenedStreams.iterator();
        while (iterator.hasNext()) {
            String streamId = iterator.next();
            Stream s = Stream.getStreamById(Integer.valueOf(streamId));
            likedStreamers.add(s.streamerId.toString());
        }
        return likedStreamers;
    }

    public List<Stream> recommendedType(List<Stream> list, Integer type) {
        List<Stream> goodType = new ArrayList<>();
        list = ProiectPOO.streamsList;
        for (Stream s : list) {
            if (s.streamType.equals(type)) {
                goodType.add(s);
            }
        }
        return goodType;
    }

    public List<Stream> getStreamsByStreamers(Integer type) {
        List<Stream> result = new ArrayList<>();
        List<Stream> streams = recommendedType(ProiectPOO.streamsList, type);
        List<String> streamerIds = checkIfLikeStreamer();
        for (Stream stream : streams) {
            if (streamerIds.contains(stream.streamerId.toString())) {
                result.add(stream);
            }
        }
        return result; //lista streamuri din type ul cerut facute de streameri ascultati
    }

    public List<Stream> getNotListenedStreamsByListenedStreamers(Integer type) {
        List<Stream> notListenedStreamsByListenedStreamers = new ArrayList<>();
        List<Stream> result = getNotListenedStreamsByListenedStreamers(type);
        List<String> listenedStreams = ProiectPOO.map.getOrDefault(id.toString(), new ArrayList<>());
        for (Stream stream : result) {
            if (!listenedStreams.contains(stream.id.toString())) {
                notListenedStreamsByListenedStreamers.add(stream);
            }
        }
        return notListenedStreamsByListenedStreamers;
    }


    public void sortStreamsByLength(List<Stream> streams) {
        Collections.sort(streams, new Comparator<Stream>() {
            @Override
            public int compare(Stream stream1, Stream stream2) {
                return Long.compare(stream1.getNoOfStreams(), stream2.getNoOfStreams());
            }
        });
    }

    public void recommend5(Integer type) {
        List<Stream> unsorted = getStreamsByStreamers(type);
        sortStreamsByLength(unsorted);
        ObjectMapper mapper = new ObjectMapper();
        for (Stream s : unsorted) {
            try {
                List<StreamsToPrint> personalStreams = new ArrayList<>();
                String streamerName = Streamer.getStreamerNameById(ProiectPOO.streamersList, s.streamerId);
                Format format = Format.getInstance();
                String data = format.dateFormat(s.dateAdded);
                String length = format.secondsToTimeFormat(s.length);
                StreamsToPrint p = new StreamsToPrint(s.id.toString(), s.name, streamerName, s.noOfStreams.toString(), length, data);
                personalStreams.add(p);
                String json = mapper.writeValueAsString(personalStreams);
                System.out.println(json);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
