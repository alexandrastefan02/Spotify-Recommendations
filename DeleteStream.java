public class DeleteStream implements Command {
    private Streamer streamer;
    private Stream stream;

    public DeleteStream(Streamer streamer, Stream stream) {
        this.streamer = streamer;
        this.stream = stream;
    }

    @Override
    public void execute() {
        streamer.deleteStream(stream.id);
    }
}
