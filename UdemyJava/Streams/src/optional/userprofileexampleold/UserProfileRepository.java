package optional.userprofileexampleold;

public interface UserProfileRepository {
    UserProfile findById(User.Id userId);
}
