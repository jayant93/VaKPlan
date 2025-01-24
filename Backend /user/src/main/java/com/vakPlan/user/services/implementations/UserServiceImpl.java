package com.vakPlan.user.services.implementations;

import com.vakPlan.user.models.dbEntity.User;
import com.vakPlan.user.models.request.UserCreationRequest;
import com.vakPlan.user.models.response.UserCreationResponse;
import com.vakPlan.user.repositories.UserRepository;
import com.vakPlan.user.services.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * UserService implementation to manipulate user information
 */
@Service
public class UserServiceImpl implements
        UserService<UserCreationRequest, UserCreationResponse> {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepo;

    @Value("${user.creation.message}")
    String userCreationMessage;

    @Transactional
    @Override
    public UserCreationResponse createUser(UserCreationRequest request) {

        User dbUser = new User();
            dbUser.setId(UUID.randomUUID().toString());
            dbUser.setEmail(request.getEmail());
            dbUser.setFirstName(request.getFirstName());
            dbUser.setLastName(request.getLastName());
            dbUser.setPhoneNumber(request.getPhoneNumber());
            dbUser.setMiddleName(request.getMiddleName());
            try {
                userRepo.save(dbUser);
            }catch (Exception e){
                String errorMessage = "User creation failed with Exception : "+e.getMessage();
                log.error(errorMessage);
                throw new RuntimeException(errorMessage);
            }

            UserCreationResponse response = new UserCreationResponse();
            response.setFirstName(dbUser.getFirstName());
            response.setResponseMessage(userCreationMessage);

        return response;
    }
}
