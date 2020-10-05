package lihewei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableZuulProxy
public class EurekaServerApplication7004 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication7004.class, args);
    }
}
