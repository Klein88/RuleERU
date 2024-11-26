package web.rulemanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("web.rulemanage.mapper")
public class RuleManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuleManageApplication.class,args);
    }
}
