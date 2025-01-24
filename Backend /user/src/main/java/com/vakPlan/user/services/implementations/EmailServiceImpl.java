package com.vakPlan.user.services.implementations;

import com.vakPlan.user.services.interfaces.EmailService;
import com.vakPlan.user.utility.Utility;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



@Service
public class EmailServiceImpl implements EmailService<String,String> {

    Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
    @Autowired
    private JavaMailSender mailSender;

    @Value("${password.reset.link}")
    String resetLink;

    @Value("${vakpal.email.id}")
    String vakPlanEmail;

    // Method to send first-time login email with default password and reset link
    public boolean sendPasswordResetLink(String toEmail, String userName) {
        // Create MIME message
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(vakPlanEmail);
            helper.setTo(toEmail);
            helper.setSubject("Welcome to vaKPlan – Your AI-Powered Vacation Planner 🌍✈️");

            // body of the email
            String body = "<html>"
                    + "<body>"
                    + "<p>Dear " + userName + ",</p>"
                    + "<p>Welcome to <strong>vaKPlan</strong>, where planning your dream vacation becomes effortless, fun, and smart!</p>"
                    + "<h3>✨ Why vaKPlan?</h3>"
                    + "<ul>"
                    + "<li>🌟 Create personalized vacation plans tailored to your preferences.</li>"
                    + "<li>💰 Make the most of your <strong>budget</strong> with the best deals and options.</li>"
                    + "<li>📅 Save time by having curated itineraries designed just for you.</li>"
                    + "</ul>"
                    + "<p>Whether it’s a solo adventure or a family getaway, vaKPlan ensures every detail is taken care of, making your trip truly memorable.</p>"
                    + "<h3>🔐 First Time Login</h3>"
                    + "<p>Your default password is: <strong>'" + Utility.generateRandomPassword() + "'</strong></p>"
                    + "<p>Click below to securely <a href='" + resetLink + toEmail + "'> reset your password</a>.</p>"
                    + "<p>If you didn’t request a reset, feel free to ignore this email.</p>"
                    + "<p>🌟 Ready to plan your next adventure? <a href='#'>Log In to vaKPlan Now</a></p>"
                    + "<p>Warm regards,<br/>The vaKPlan Team 🌍✨<br/><em>Your Journey, Powered by AI</em></p>"
                    + "</body>"
                    + "</html>";

            helper.setText(body, true);  // true means this is HTML

            // Send the email
            mailSender.send(message);
            log.debug("First-time login email sent to: " + toEmail);
        } catch (MessagingException | MailException e) {
            e.printStackTrace();
            log.error("Error sending email to: " + toEmail +" Failure reason : "+e.getMessage());
            return false;
        }

        return true;
    }

}
