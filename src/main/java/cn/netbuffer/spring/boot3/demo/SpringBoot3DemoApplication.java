package cn.netbuffer.spring.boot3.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot3DemoApplication {

    public static Dotenv DOTENV;

    public static void main(String[] args) {
        initDotEnv();
        SpringApplication.run(SpringBoot3DemoApplication.class, args);
    }

    private static void initDotEnv() {
        DOTENV = Dotenv.configure().filename("sb3d.env").ignoreIfMissing().load();
        DOTENV.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
    }

}
