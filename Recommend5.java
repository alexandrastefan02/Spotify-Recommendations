public class Recommend5 implements Command {
    private User user;
    private Integer type;

    public Recommend5(User user, Integer type) {
        this.user = user;
        this.type = type;
    }

    @Override
    public void execute() {
        user.recommend5(type);
    }
}
