package optional.userprofileexamplenew;

public class UserProfile {
    User user;
    String somethingElse;

    public UserProfile(User user, String str) {
        this.user = user;
        this.somethingElse = str;
    }

    public static UserProfile defaultDetails() {
        return new UserProfile(new User("John Doe", new User.Id(45)), "blablabla");
    }
}
