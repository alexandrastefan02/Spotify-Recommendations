import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListHistory implements Command {
    private User user;

    public ListHistory(User user) {
        this.user = user;
    }

    @Override
    public void execute() {
        user.listHistory();
    }
}
