package griffio;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@RequestMapping
public class Main {
    /**
     * printBannerfrom banner.txt and resolve properties from application.properties
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping("/status")
    @ResponseBody
    String status() {
        return "OK";
    }
}
