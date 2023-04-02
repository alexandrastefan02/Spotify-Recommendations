import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Format {
    private static Format instance;

    public Format() {
    }

    public static Format getInstance() {
        if (instance == null) {
            instance = new Format();
        }
        return instance;
    }

    public String dateFormat(Long dateAdded) {
        Date date = new Date(dateAdded * 1000);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        String data = format.format(date);
        return data;
    }

    public String secondsToTimeFormat(Long totalSeconds) {
        long seconds = totalSeconds;
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;

        if (hours == 0) {
            return String.format("%02d:%02d", minutes, seconds);
        } else {
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }
    }

}
