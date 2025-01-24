package com.vakPlan.user.services.interfaces;

/**
 * Includes all service contracts for the user
 * like create user,update user ,delete user
 */
public interface UserService<REQ, RES> {
    RES createUser(REQ req);
}