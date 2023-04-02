import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.sun.jdi.IntegerValue;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class ProiectPOO {
    public static List<Streamer> streamersList = new ArrayList<>();
    public static List<Stream> streamsList = new ArrayList<>();
    public static List<User> usersList = new ArrayList<>();
    public static HashMap<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        if (args == null) {
            System.out.println("Nothing to read here");
        } else {
            String src = "./src/main/resources/";
            String streamers = src + args[0];
            String streams = src + args[1];
            String users = src + args[2];
            String commands = src + args[3];
            FileReader reader = null;
            File commfile = new File(commands);
            ReadCSV.readStreamers(streamers);
            ReadCSV.readStreams(streams);
            ReadCSV.readUsers(users);
            try {
                Scanner scanner = new Scanner(commfile);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(" ");
                    String command = parts[1];
                    if (command.equals("LIST")) {
                        for (Streamer streamer : streamersList) {
                            if (parts[0].equals(Integer.toString(streamer.id))) {
                                Integer id = streamer.id;

                                Command listStreamsCommand = new ListStreams(streamer);
                                listStreamsCommand.execute();
                            }

                        }
                        for (User user : usersList) {
                            if (parts[0].equals(Integer.toString(user.id))) {
                                Command listHistoryCommand = new ListHistory(user);
                                listHistoryCommand.execute();
                            }
                        }
                    }
                    if (command.equals("ADD")) {
                        for (Streamer streamer : streamersList) {
                            if (parts[0].equals(Integer.toString(streamer.id))) {
                                Command addStreamCommand = new AddStream(streamer, Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), Integer.valueOf(parts[4]), Long.valueOf(parts[5]), parts[6]);
                                addStreamCommand.execute();
                            }
                        }
                    }
                    if (command.equals("DELETE")) {
                        for (Streamer streamer : streamersList) {
                            if (parts[0].equals(Integer.toString(streamer.id))) {
                                Stream s = Stream.getStreamById(Integer.valueOf(parts[2]));
                                Command deleteStreamCommand = new DeleteStream(streamer, s);
                                deleteStreamCommand.execute();
                            }
                        }
                    }
                    if (command.equals("LISTEN")) {
                        for (User user : usersList) {
                            if (parts[0].equals(Integer.toString(user.id))) {
                                Stream s = Stream.getStreamById(Integer.valueOf(parts[2]));
                                Command listenCommand = new ListenStream(user, s);
                                listenCommand.execute();
                            }
                        }
                    }
                    if (command.equals("RECOMMEND")) {
                        for (User user : usersList) {
                            if (parts[0].equals(Integer.toString(user.id))) {
                                if (parts[2].equals("PIESA MUZICALA")) {
                                    Command rec5Command = new Recommend5(user, 1);
                                    rec5Command.execute();
                                } else if (parts[2].equals("PODCAST")) {
                                    Command rec5Command = new Recommend5(user, 2);
                                    rec5Command.execute();
                                } else if (parts[2].equals("AUDIOBOOK")) {
                                    Command rec5Command = new Recommend5(user, 3);
                                    rec5Command.execute();
                                }
                            }
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("exception occurred" + e);
            }


        }
    }
}
