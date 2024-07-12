package digital.softwareshinobi.workspace.apartmentrental;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ApartmentRentalAPI {

    @GetMapping("/mock/apartment-rentals")
    public String generateMockApartmentRentals() {
        List<ApartmentUnit> units = new ArrayList<>();

        // Create 12 mock apartment units
        for (int i = 1; i <= 12; i++) {
            units.add(createMockUnit(i));
        }

        // Build the mock string representation
        StringBuilder mockData = new StringBuilder("Mock Apartment Rental Data:\n\n");
        for (ApartmentUnit unit : units) {
            mockData.append(unit.toString() + "\n\n");
        }

        return mockData.toString();
    }

    private ApartmentUnit createMockUnit(int unitNumber) {
        String status = Math.random() < 0.5 ? "Available" : "Occupied";
        int rent = (int) (Math.random() * 1000) + 1000; // Random rent between $1000 and $2000
        return new ApartmentUnit(unitNumber, status, rent);
    }

    private static class ApartmentUnit {
        private final int unitNumber;
        private final String status;
        private final int rent;

        public ApartmentUnit(int unitNumber, String status, int rent) {
            this.unitNumber = unitNumber;
            this.status = status;
            this.rent = rent;
        }

        @Override
        public String toString() {
            return "Unit Number: " + unitNumber + "\n" +
                   "Status: " + status + "\n" +
                   "Rent: $" + rent;
        }
    }
}
