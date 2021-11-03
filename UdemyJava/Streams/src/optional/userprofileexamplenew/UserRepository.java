package optional.userprofileexamplenew;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(User.Id userId);
}


