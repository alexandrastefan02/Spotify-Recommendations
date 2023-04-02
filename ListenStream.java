public class ListenStream implements Command {
    private User user;
    private Stream stream;

    public ListenStream(User user, Stream stream) {
        this.user = user;
        this.stream = stream;
    }

    @Override
    public void execute() {
        user.listen(stream);
    }
}
