package digital.softwareshinobi.workspace.mentalhealth;

public class MentalHealthFacility {

        private final String name;
        private final String address;
        private final String phone;
        private final String state;
        private final String type;

        public MentalHealthFacility(String name, String address, String phone, String state, String type) {
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.state = state;
            this.type = type;
        }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MentalHealthFacility{");
        sb.append("name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", phone=").append(phone);
        sb.append(", state=").append(state);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }

    }
