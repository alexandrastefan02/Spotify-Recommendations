public class AddStream implements Command {
    private Streamer streamer;
    private Integer streamType;
    private Integer id;
    private Integer streamGenre;
    private Long length;
    private String name;

    public AddStream(Streamer streamer, Integer streamType, Integer id, Integer streamGenre, Long length, String name) {
        this.streamer = streamer;
        this.streamType = streamType;
        this.id = id;
        this.streamGenre = streamGenre;
        this.length = length;
        this.name = name;
    }

    @Override
    public void execute() {
        streamer.addStream(streamType, id, streamGenre, length, name, streamer.id);
    }
}
