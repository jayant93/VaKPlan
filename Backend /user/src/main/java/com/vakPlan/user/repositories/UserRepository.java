package com.vakPlan.user.repositories;

import com.vakPlan.user.models.dbEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User repository interface to handle all
 * kinds of db related activity for users object
 */

public interface UserRepository extends JpaRepository<User,Long> {

}
