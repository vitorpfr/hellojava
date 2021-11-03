package optional.userprofileexampleold;

public class UserWithProfile {
    User user;
    UserProfile profile;

    public UserWithProfile(User user, UserProfile profile) {
        this.user = user;
        this.profile = profile;
    }

    public static UserWithProfile of(User user, UserProfile profile) {
        return new UserWithProfile(user, profile);
    }
}
