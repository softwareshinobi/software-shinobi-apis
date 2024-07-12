package online.soyyomateo.email;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"email-list"})
public class EmailUnsubscribeAPI {
   public EmailUnsubscribeAPI() {
      System.out.println();
      System.out.println("*** ");
      System.out.println("*** init -- EmailUnsubscribeAPI");
      System.out.println("*** ");
      System.out.println();
   }

   @GetMapping({"/"})
   public String hello() {
      return "hello from the EmailUnsubscribeAPI.";
   }

   @GetMapping({"/health-check"})
   public String returnHealthCheckContentJSON() {
      return "EmailUnsubscribeAPI API Is Up!";
   }

   @GetMapping({"/unsubscribe/{email}"})
   public String unsubscribeUserFromEmailList(@PathVariable("email") String email) {
      StringBuffer buf = new StringBuffer();
      buf.append("unsubscribed: ").append(email);
      String ret = buf.toString();
      buf = null;
      return ret;
   }
}
