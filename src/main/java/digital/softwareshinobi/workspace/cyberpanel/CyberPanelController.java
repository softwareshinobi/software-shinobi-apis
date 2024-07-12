package digital.softwareshinobi.workspace.cyberpanel;

import java.util.Objects;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("web/vhostconfig")
public class CyberPanelController {

    private final String VHOST_CONFIG_TEMPLATE = " extprocessor shinobiNetCode {   \n \n    type                    proxy\n    \n    address                 10.142.0.5:44300\n    \n    maxConns                100\n    \n    pcKeepAliveTimeout      60\n    \n    initTimeout             60\n    \n    retryTimeout            0\n    \n    respBuffer              0 \n\n}  \n\nrewrite  {   \n\n    RewriteCond %{HTTPS} !=on \n\n    RewriteRule ^ https://%{HTTP_HOST}%{REQUEST_URI} [L,R=301]  \n\n    RewriteRule /(.*) http://shinobiNetCode/$1 [P]   \n\n    enable                  1 \n\n    autoLoadHtaccess        1 \n\n} \n";

    public CyberPanelController() {

        System.out.println("### ");
        System.out.println("### init -- CyberPanelController");
        System.out.println("### ");

    }

    @GetMapping("")
    public String root() {
        return "Cyber Panel Vhost Config Generator";
    }

    @GetMapping("health")
    public String returnHealth() {
        return "OK";
    }

    @PostMapping("")
    public String generateVhostConfig(@RequestBody final String formResponses) {
        
        System.out.println("enter :: generateVhostConfig()");
        
        System.out.println("param > formResponses > "+formResponses);
        
        final JSONObject jsonObject = new JSONObject(formResponses);
                
        System.out.println("jsonObject /" + jsonObject);
        
        Objects.requireNonNull(this);
        
        final String vhostConfigReplaced = " extprocessor shinobiNetCode {   \n \n    type                    proxy\n    \n    address                 10.142.0.5:44300\n    \n    maxConns                100\n    \n    pcKeepAliveTimeout      60\n    \n    initTimeout             60\n    \n    retryTimeout            0\n    \n    respBuffer              0 \n\n}  \n\nrewrite  {   \n\n    RewriteCond %{HTTPS} !=on \n\n    RewriteRule ^ https://%{HTTP_HOST}%{REQUEST_URI} [L,R=301]  \n\n    RewriteRule /(.*) http://shinobiNetCode/$1 [P]   \n\n    enable                  1 \n\n    autoLoadHtaccess        1 \n\n} \n".replaceAll("shinobiNetCode", jsonObject.getString("localServiceName")).replaceAll("10.142.0.5", jsonObject.getString("remoteServerIP")).replaceAll("44300", jsonObject.getString("remoteServerPort"));
        
        System.out.println("returning: " + vhostConfigReplaced);
        
        System.out.println("exit :: generateVhostConfig()");
                
        return vhostConfigReplaced;
        
    }
    
}
