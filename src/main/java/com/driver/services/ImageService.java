package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;
    @Autowired
    BlogRepository blogRepository;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog
        List<Image> imageListInBlog = blog.getImageList();
        Image image = new Image(description,dimensions);
        imageListInBlog.add(image);
        blog.setImageList(imageListInBlog);
        image.setBlog(blog);
        blogRepository.save(blog);
        return image;
    }

    public void deleteImage(Image image){
    imageRepository2.delete(image);
    }

    public Image findById(int id) {
    return imageRepository2.findById(id).get();
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0
        int imageCount=0;
        String imageDimension=image.getDimensions();
        int imageX = getIndexOfXInDimension(imageDimension);
        int screenX=getIndexOfXInDimension(screenDimensions);

        int imageW = convertToInt(imageDimension.substring(0,imageX));
        int imageH = convertToInt(imageDimension.substring(imageX+1,imageDimension.length()));
        int screenW = convertToInt(screenDimensions.substring(0,screenX));
        int screenH = convertToInt(screenDimensions.substring(screenX+1,screenDimensions.length()));
//        System.out.println(imageW);
//        System.out.println(imageH);
//        System.out.println(screenW);
//        System.out.println(screenH);
        if(image!=null){
            int imageInXDimension=screenW%imageW;
            int imageInYDimension=screenH%imageH;
            imageCount=imageInXDimension*imageInYDimension;
            return imageCount;
        }
      return 0;
    }
    private  int getIndexOfXInDimension(String dimension){
        int ans =-1;
        for(int i =0 ; i < dimension.length();i++){
            if(dimension.charAt(i)=='X'){
              ans =i;
              break;
            }
        }
        return ans;
    }
    public int convertToInt(String str){
        int i,ans=0;
        for(i=0;i<str.length();i++){
//            if(str.charAt(i)=='X'){
//                break;
//            }
            int digit = str.charAt(i)-'0';
            ans = ans*10 + digit;
        }
        return ans;
    }
}
