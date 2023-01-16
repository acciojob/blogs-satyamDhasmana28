package com.driver;

import com.driver.models.Image;
import com.driver.services.ImageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogsApplication {
    public static void main(String[] args) {
//        Image image = new Image();
//        image.setDimensions("4X4");
//        String sd="9X9";
//        ImageService imageService = new ImageService();
//        int c=  imageService.countImagesInScreen(image,sd);
//        System.out.println("image count ="+c);
        SpringApplication.run(BlogsApplication.class, args);
    }
}
