//package com.codeup.springblog.cotrollers;
//
//import com.codeup.springblog.models.Ad;
//import com.codeup.springblog.repositories.AdRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.persistence.Column;
//import java.util.List;
//
//@Controller
//public class AdController {
//
//
//    //Dependency injection //
////Create an instance of the Ad Repository or Dao
//    private final AdRepository adsDao;
//
//    public AdController(AdRepository adsDao){
//        this.adsDao=adsDao;
//    }
//
//    @GetMapping("/ads/jpa")
//    @ResponseBody
//        public List<Ad> jpaIndex(){
//        return  adsDao.findAll();
//    }
//
//}
