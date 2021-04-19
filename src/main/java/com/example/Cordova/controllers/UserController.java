package com.example.Cordova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class UserController {

    @GetMapping("/")
    public String RenderHomePage(Principal principal, Model m){
        m.addAttribute("user", principal);
        return "home";
    }

    @GetMapping("/gallery")
    public String RenderGallery(Principal principal, Model m){
        m.addAttribute("computers", principal);
        return "gallery";
    }

    @GetMapping("/contact")
    public String RenderContact(Principal principal, Model m){
        return "contact";
    }

    @GetMapping("/aboutme")
    public String RenderAboutme(Principal principal, Model m){
        return "aboutme";
    }

    @PostMapping("/email")
    public RedirectView SendQueryEmail(Principal principal, Model m){
        //throw in a success message "your message has been sent"
        //handle submission with form information, generate an email

//        Email from = new Email("CordovaLegacy4cl.com");
//        String subject = "Sending with SendGrid is Fun";
//        Email to = new Email("mattpet26@gmail.com");
//        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
//        Mail mail = new Mail(from, subject, to, content);
//        SendGrid sg = new SendGrid(System.getenv("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\n"));
//        Request request = new Request();
//        try {
//            request.setMethod(Method.POST);
//            request.setEndpoint("mail/send");
//            request.setBody(mail.build());
//            Response response = sg.api(request);
//            System.out.println(response.getStatusCode());
//            System.out.println(response.getBody());
//            System.out.println(response.getHeaders());
//        } catch (IOException ex) {
//            throw ex;
//        }

        return new RedirectView("/home");
    }
}
