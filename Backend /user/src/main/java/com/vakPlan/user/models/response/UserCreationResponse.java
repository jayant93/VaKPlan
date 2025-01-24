package com.vakPlan.user.models.response;



/**
 * User creation response will return the firstName of the user with
 * a response message that email has been sent to the user's email Id
 */

public class UserCreationResponse {

    private String firstName;
    private String responseMessage;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Override
    public String toString() {
        return "UserCreationResponse{" +
                "firstName='" + firstName + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
