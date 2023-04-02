import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class ListStreams implements Command {
    private Streamer streamer;

    public ListStreams(Streamer streamer) {
        this.streamer = streamer;
    }

    public void execute() {
        streamer.listStreams();
    }
}


