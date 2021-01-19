package com.uennar.fcmTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uennar.fcmTest.model.DataBody;
import com.uennar.fcmTest.model.SendData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class HomeController {
    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("data", new DataBody());
        model.addAttribute("to", new String());
        return "home";
    }

    @PostMapping("/")
    String send(@ModelAttribute("data") DataBody data, @ModelAttribute("to") String to, Model model) {
        String result = "fail";
        try {
            URL url = new URL("https://fcm.googleapis.com/fcm/send");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + "AAAAB0O6QII:APA91bGyrNcfSMmquy7G3hbG4Y2QOYJanyuWw0x-QqCspwuW3pOz9bu3bOa7IARxbZkgRP47lAoST5jKHOkSjvCo3jbC-ZmiRnayRLMMlNkWq4vB2OR1rxhT4LzNS8dbTq3zR1qkBrpp");

            SendData sendData = new SendData(data, to);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(sendData);

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(json);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            if (responseCode >= 200 && responseCode < 300) {
                result = "Всё успешно";
            }
            System.out.println(responseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("result", result);
        return "home";
    }
}
