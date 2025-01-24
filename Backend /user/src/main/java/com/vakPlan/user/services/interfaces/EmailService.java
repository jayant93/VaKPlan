package com.vakPlan.user.services.interfaces;

public interface EmailService<EMAILTO,USERNAME> {

    public boolean sendPasswordResetLink(EMAILTO emailreq,USERNAME name);

}
