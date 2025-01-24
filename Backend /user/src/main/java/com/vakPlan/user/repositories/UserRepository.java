package com.vakPlan.user.repositories;

import com.vakPlan.user.models.dbEntity.User;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

/**
 * User repository interface to handle all
 * kinds of db related activity for users object
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    User save(User user);

}
