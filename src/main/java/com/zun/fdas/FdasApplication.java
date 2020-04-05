package com.zun.fdas;

import com.zun.fdas.utils.GenerateDataUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.zun.fdas")
public class FdasApplication {

    public static void main(String[] args) {
        SpringApplication.run(FdasApplication.class, args);
        GenerateDataUtils mysqlUtils = new GenerateDataUtils();
        Thread thread = new Thread(mysqlUtils);
        thread.start();



    }

}
