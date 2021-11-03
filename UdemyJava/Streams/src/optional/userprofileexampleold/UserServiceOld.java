package optional.userprofileexampleold;

public class UserServiceOld {
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    // constructor
    public UserServiceOld(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }

    // get user method
    public UserWithProfile getUserWithProfile(User.Id userId) {
        // tries to retrieve user from database
        User user = userRepository.findById(userId);

        // if null was returned (no user found), throw custom exception
        if (user == null) {
            throw new UserNotFoundException("User with ID " + userId + " not found");
        }

        // get details with userid
        UserProfile details = userProfileRepository.findById(userId);

        // build UserWithProfile joining user and details, returning it
        return UserWithProfile.of(user, details == null
                ? UserProfile.defaultDetails()
                : details);
    }
}
