package hosting.controller;

import hosting.models.Tbl_data;
import hosting.service.ITbl_dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

@Controller
public class TblController {
    @Autowired
    ITbl_dataService iTbl_dataService;

    long count = 0;
    HashSet<Long> dataList = new HashSet<>();

    @GetMapping("/menu")
    public ModelAndView home(HttpSession httpSession, @CookieValue(value = "is_approve", defaultValue = "-1") long is_approve,
                             HttpServletResponse response, HttpServletRequest request) throws Exception {
        Long tbl_data = iTbl_dataService.countData();
        tbl_data = tbl_data - count;
        if (tbl_data < 0) {
            tbl_data = 0L;
        }
        Cookie cookie = new Cookie("is_approve", String.valueOf(tbl_data));
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView("menu");
        modelAndView.addObject("list", iTbl_dataService.findAll());
        modelAndView.addObject("cookie", cookie);
        return modelAndView;
    }

    @GetMapping("/remove/{article_id}")
    public ModelAndView remove(@PathVariable long article_id, HttpServletResponse response) throws Exception {
        Optional<Tbl_data> tblData = iTbl_dataService.findById(article_id);
        if (!dataList.contains(article_id)){
            count = count + 1;
            dataList.add(article_id);
        }
        tblData.get().setIs_approve(0);
        iTbl_dataService.save(tblData.get());
        Long tbl_data = iTbl_dataService.countData();
        if (count > tbl_data) {
            throw new Exception();
        }
        Cookie cookie = new Cookie("is_approve", String.valueOf(tbl_data - count));
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView("menu");
        modelAndView.addObject("list", iTbl_dataService.findAll());
        modelAndView.addObject("cookie", cookie);
        return modelAndView;
    }

    @GetMapping("/approve/{article_id}")
    public ModelAndView test(@PathVariable long article_id, HttpServletResponse response,
                             HttpServletRequest request) throws Exception {
        Optional<Tbl_data> tblData = iTbl_dataService.findById(article_id);
        if (!dataList.contains(article_id)){
            count = count + 1;
            dataList.add(article_id);
        }
        tblData.get().setIs_approve(2);
        iTbl_dataService.save(tblData.get());
        Long tbl_data = iTbl_dataService.countData();
        if (count > tbl_data) {
            throw new Exception();
        }
        Cookie cookie = new Cookie("is_approve", String.valueOf(tbl_data - count));
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView("menu");
        modelAndView.addObject("list", iTbl_dataService.findAll());
        modelAndView.addObject("cookie", cookie);
        return modelAndView;
    }

    @GetMapping("/fix/{article_id}")
    public ModelAndView fix(@PathVariable long article_id, HttpServletResponse response)throws Exception {
        Optional<Tbl_data> tblData = iTbl_dataService.findById(article_id);
        if (!dataList.contains(article_id)){
            count = count + 1;
            dataList.add(article_id);
        }
        tblData.get().setIs_approve(1);
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        tblData.get().setUpdated_date(date);
        iTbl_dataService.save(tblData.get());
        Long tbl_data = iTbl_dataService.countData();
        if (count > tbl_data) {
            throw new Exception();
        }
        Cookie cookie = new Cookie("is_approve", String.valueOf(tbl_data - count));
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView("menu");
        modelAndView.addObject("list", iTbl_dataService.findAll());
        modelAndView.addObject("cookie", cookie);
        return modelAndView;
    }

    @RequestMapping("/home")
    public ModelAndView home(@CookieValue(value = "is_approve", defaultValue = "-1") long is_approve, HttpServletResponse response, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("home");
        Cookie cookie = new Cookie("is_approve", String.valueOf(is_approve + 1));
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        modelAndView.addObject("cookie", cookie);
        modelAndView.addObject("list", iTbl_dataService.findAll());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }
}
