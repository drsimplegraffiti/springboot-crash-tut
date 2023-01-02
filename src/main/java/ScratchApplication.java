import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class ScratchApplication {
    public static void main(String[] args){
        SpringApplication.run(ScratchApplication.class);
    }

    @RequestMapping("/")
    public String homePage(){
        return "Hello world";
    }
}
