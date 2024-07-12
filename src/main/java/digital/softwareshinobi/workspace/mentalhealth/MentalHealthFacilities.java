package digital.softwareshinobi.workspace.mentalhealth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class MentalHealthFacilities {

    @GetMapping("/mock/mental-health-facilities")
    public String generateMockFacilities() {
        
        List<MentalHealthFacility> facilities = new ArrayList();

        String[] states = {"CA", "TX", "NY", "FL", "IL", "WA", "OH", "NC", "GA", "NJ", "CO", "VA"};
        
        String[] facilityTypes = {"Outpatient Clinic", "Residential Treatment Center", "Support Group"};

        // Create 12 mock facilities
        for (int i = 0; i < 12; i++) {
            facilities.add(createMockFacility(i, states, facilityTypes));
        }

        return facilities.toString();
    }

    private MentalHealthFacility createMockFacility(int index, String[] states, String[] facilityTypes) {
        String name = "Sample Mental Health Facility " + (index + 1);
        String address = generateRandomAddress();
        String phone = generateRandomPhone();
        String state = states[(int) Math.floor(Math.random() * states.length)];
        String type = facilityTypes[(int) Math.floor(Math.random() * facilityTypes.length)];
        return new MentalHealthFacility(name, address, phone, state, type);
    }

    private String generateRandomAddress() {
    
        return "444 Sunrise Boulevard";
        
    }

    private String generateRandomPhone() {
       
        return "2813308004";
        
    }
   
}
