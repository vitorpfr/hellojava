package optional.userprofileexamplenew;

import java.util.Optional;

public interface UserProfileRepository {
    Optional<UserProfile> findById(User.Id userId);
}
