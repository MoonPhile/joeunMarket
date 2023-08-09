package com.joeun.service;

import com.joeun.dto.Payment;
import com.joeun.mapper.PaymentMapper;
import org.json.simple.JSONObject;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.JSONParser;
//import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentMapper paymentMapper;

    public void insertPayment(Payment payment) {
        System.out.println("인서트 페이먼트 실행");
        try {
            paymentMapper.insertPayment(payment);

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    /**
     *
     * @return 포트원 토큰
     */
    public String getAccessToken(){
        String reqUrl = "https://api.iamport.kr/users/getToken";
        String access_token = "";
        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            Map<String,Object> map = new HashMap<>();
            
            //수정필요
            map.put("imp_key","4733323784021880");
            map.put("imp_secret","UtVnQlGvSCIICvs7ykwQGNz6V2lthPQsq2jPMvjBeqzt1EHr1CgyO2l8Ulw5wIwivnc8fbkmfFgUdp6F");
            
            JSONParser jsonParser = new JSONParser();
            JSONObject reqJson = new JSONObject(map);
            System.out.println("reqJson.toString() = " + reqJson.toString());
            bw.write(reqJson.toJSONString());
            bw.flush();

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode = " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line = "";
            while((line = br.readLine())!=null){
                result.append(line);
            }
            JSONObject obj = (JSONObject) jsonParser.parse(result.toString());
            JSONObject responseObj = (JSONObject) obj.get("response");
            access_token = responseObj.get("access_token").toString();
            System.out.println("access_token = " + access_token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return access_token;
    }

    public void payCancel(String accessToken, String imp_uid) {
        String reqUrl = "https://api.iamport.kr/payments/cancel";
        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","application/json");
            conn.setRequestProperty("Authorization",accessToken);
            conn.setDoOutput(true);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            Map<String,Object> map = new HashMap<>();
            map.put("imp_uid",imp_uid);
            JSONObject reqJson = new JSONObject(map);
            bw.write(reqJson.toJSONString());
            bw.flush();

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode = " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line = "";
            while((line = br.readLine())!=null){
                result.append(line);
            }
            JSONParser parser = new JSONParser();
            org.json.simple.JSONObject obj = (org.json.simple.JSONObject) parser.parse(result.toString());
            System.out.println("obj = " + obj);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
