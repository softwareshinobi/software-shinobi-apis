package digital.softwareshinobi.workspace.dwity;

import digital.softwareshinobi.dwityuniverse.thirdparty.Wget;
import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("dwity")
public class DwityUniverseController {

    public DwityUniverseController() {

        System.out.println("## ");
        System.out.println("## init > Dwity Universe API");
        System.out.println("## ");

    }

    @GetMapping("health")
    public String healthCheck() {

        return "ONLINE";

    }

    @GetMapping("all")
    public List<VEvent> listAllEvents() throws IOException {

        List<VEvent> allEvents = this.fetchAllEventsFromCalendar();

        return allEvents;

    }

    @GetMapping("")
    public List<VEvent> listActiveEvents() throws IOException {

        List<VEvent> allEvents = this.fetchAllEventsFromCalendar();

        List<VEvent> onlyActiveEvents = new ArrayList();

        Date rightNow = new Date();
        
        System.out.println("rightNowDate / " + rightNow);
        
        for (final VEvent singleEvent : allEvents) {

            boolean startDateHasPassed = singleEvent.getDateStart().getValue().before(rightNow);

            boolean endDateHasNotPassed = singleEvent.getDateEnd().getValue().after(rightNow);

            boolean isActive = startDateHasPassed && endDateHasNotPassed;

            if (isActive) {

                // System.out.println("found active / " + singleEvent);
                onlyActiveEvents.add(singleEvent);

            }

        }

        return onlyActiveEvents;

    }

    private List<VEvent> fetchAllEventsFromCalendar() throws IOException {

        String randomFileName
                = "dwity-online-calendar-export." + UUID.randomUUID().toString() + ".ics";

        File temporaryICSFile = new File(randomFileName);

        String url = "https://calendar.google.com/calendar/ical/7515c36d9d63b973f7467fe0bf7588a64a10301e5659aa30e8f58cfb3434e2b1%40group.calendar.google.com/public/basic.ics";

        Wget.wGet(randomFileName, url);

        ICalendar icals = Biweekly.parse(temporaryICSFile).first();

        List<VEvent> eventList = icals.getEvents();

        temporaryICSFile.delete();

        return eventList;

    }

}
