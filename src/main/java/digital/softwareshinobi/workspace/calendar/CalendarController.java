package digital.softwareshinobi.workspace.calendar;

import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("calendar")
public class CalendarController {

    private final String CALENDAR_DEFAULT = "";

    private String calendar = CALENDAR_DEFAULT;

    public static final String KEY_INTENTION = "calendar";

   public CalendarController() {

        System.out.println("## ");
        System.out.println("## init > Calendar Controller");
        System.out.println("## ");

    }

    @GetMapping("")
    public String getCalendar() {

        return this.calendar;

    }

    @PostMapping("")
    public String setCalendar(@RequestBody Map requestPayLoad) {

        System.out.println("enter > setIntention");

        System.out.println("requestPayLoad / " + requestPayLoad);

        String calendarFromPayload = requestPayLoad.get(KEY_INTENTION).toString().trim();

        System.out.println("calendar / payload / " + calendarFromPayload);

        System.out.println("calendar / before / " + this.calendar);

        this.calendar = calendarFromPayload;

        System.out.println("calendar /  after / " + this.calendar);

        String confirmationString = "calendar updated /".concat(calendar).concat("/");

        System.out.println("return / " + confirmationString);

        System.out.println("exit < setIntention()");

        return confirmationString;

    }

    @GetMapping("health")
    public String getHealth() {

        return "OK";

    }

}
