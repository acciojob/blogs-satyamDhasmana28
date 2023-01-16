package com.driver;

import com.driver.models.Image;
import com.driver.services.ImageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogsApplication {
    public static void main(String[] args) {
//        Image image = new Image();
//        image.setDimensions("25X20");
//        String sd="7X5";
//        ImageService imageService = new ImageService();
//        imageService.countImagesInScreen(image,sd);
//        System.out.println("hi");
        SpringApplication.run(BlogsApplication.class, args);
    }
}
