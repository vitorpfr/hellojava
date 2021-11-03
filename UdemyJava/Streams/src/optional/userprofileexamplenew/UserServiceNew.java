package optional.userprofileexamplenew;

// https://dzone.com/articles/introduction-to-pragmatic-functional-java


public class UserServiceNew {
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    public UserServiceNew(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }

    // functional version
//    public Result<UserWithProfile> getUserWithProfile(User.Id userId) {
//        return userRepository.findById(userId)
//                .map(user -> UserWithProfile.of(user, userProfileRepository.findById(userId).or(UserProfile.defaultDetails())))
//                .toResult(Causes.cause("User with ID " + userId + " not found"));
//    }
}

class Result<T> {
    T value;

    public Result(T value) {
        this.value = value;
    }
}
