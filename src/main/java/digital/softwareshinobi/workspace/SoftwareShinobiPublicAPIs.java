package digital.softwareshinobi.workspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoftwareShinobiPublicAPIs {

    public static void main(final String[] commandLineArguments) {

        System.out.println();
        System.out.println("##");
        System.out.println("## launch > Software Shinobi Public APIs");
        System.out.println("##");
        System.out.println();

        SpringApplication.run(SoftwareShinobiPublicAPIs.class, commandLineArguments);

    }

}
