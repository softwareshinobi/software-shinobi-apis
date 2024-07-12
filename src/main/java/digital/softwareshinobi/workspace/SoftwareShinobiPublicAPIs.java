package digital.softwareshinobi.workspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoftwareShinobiPublicAPIs {

    public static void main(final String[] commandLineArguments) {

        System.out.println("launch > SoftwareShinobiPublicAPIs");
       
        SpringApplication.run(SoftwareShinobiPublicAPIs.class, commandLineArguments);

    }

}
