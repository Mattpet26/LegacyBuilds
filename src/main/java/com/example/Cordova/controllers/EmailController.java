package com.example.Cordova.controllers;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller
public class EmailController {

    @Autowired
    public SendGrid sendgrid;

    @PostMapping("/sendgrid")
    public RedirectView sendEmail(@RequestParam("msg") String message, RedirectAttributes redirAttrs, String email, String fname, String lname){
        Email from = new Email("LegacyBuilds4cl@gmail.com");
        String subject = "Client Message";
        Email to = new Email("Mattpet26@gmail.com");
        Content content = new Content("text/html", "I'm replacing the <strong>body tag</strong>" + message + email + fname + lname);

        Mail mail = new Mail(from, subject, to, content);

        mail.setReplyTo(new Email("LegacyBuilds4cl@gmail.com"));
        mail.personalization.get(0).addSubstitution("-username-", "Some blog user");

        Request request = new Request();
        Response response = null;


        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            response = sendgrid.api(request);

            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            redirAttrs.addFlashAttribute("error", "Email did not send!");

        }

        redirAttrs.addFlashAttribute("success", "Email sent!");
        return new RedirectView("/");
    }
}
