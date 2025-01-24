package com.vakPlan.user.restcontrollers;

import com.vakPlan.user.models.request.UserCreationRequest;
import com.vakPlan.user.models.response.UserCreationResponse;
import com.vakPlan.user.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    UserService userService;

    /**
     * User creation Post API
     * @param request
     * @return
     */
    @PostMapping
    public ResponseEntity<UserCreationResponse> createUser(
                    @RequestBody UserCreationRequest request) {

        UserCreationResponse response = (UserCreationResponse)
                userService.createUser(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
