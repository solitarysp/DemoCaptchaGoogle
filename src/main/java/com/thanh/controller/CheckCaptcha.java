package com.thanh.controller;/*
  By Chi Can Em  28-02-2018
 */


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.thanh.model.Result;
import com.thanh.utils.RequestHtml;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class CheckCaptcha extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // nếu có check captcha thì sẽ gửi getParameter lên với name g-recaptcha-response
        String value = req.getParameter("g-recaptcha-response");
        // kiếm tra nếu chưa check captcha
        if(value.equals("")){
            System.out.println("chua check captcha");
            return;
        }
        HashMap<String, String> listParameter = new HashMap<String, String>();
        //đoạn key bí mật dùng để giải mã, xem có chuẩn k
        listParameter.put("secret", "6Lfxd0kUAAAAAG3wlwMAHZ47ttc2iWkiM9N3aBGt");
        // giá trị truyền vào
        listParameter.put("response", value);
        // request lên google với các value đó
        String result = RequestHtml.requestPostWithListPram("https://www.google.com/recaptcha/api/siteverify", listParameter);

        try {
            //convert json sang object
            ObjectMapper mapper = new ObjectMapper();
            Result staff1 = mapper.readValue(result, Result.class);

            if (staff1.getSuccess() == "true") {
                System.out.println("thành công");
            }else {
                System.out.println("Thất bại");
            }
        }catch (UnrecognizedPropertyException e){
            System.out.println("Thất bại vì k convert đc");
        }catch (Exception e){
            System.out.println("lỗi k biết");
        }

    }
}
