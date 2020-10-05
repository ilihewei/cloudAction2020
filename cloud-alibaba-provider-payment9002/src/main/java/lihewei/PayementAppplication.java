package lihewei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lihewei
 *
 * nacos 本身自带负载均衡，整合netfix的ribbon代码
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class PayementAppplication {
    public static void main(String[] args) {
        SpringApplication.run (PayementAppplication.class,args);
    }
}
