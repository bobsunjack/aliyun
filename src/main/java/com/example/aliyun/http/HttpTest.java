package com.example.aliyun.http;

import com.alibaba.fastjson.JSONObject;
import com.example.aliyun.util.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
/*@Component*/
public class HttpTest implements CommandLineRunner {
    private String url = "https://33.97.128.46:443/fms/services/rest/resource/findCamera";
    @Override
    public void run(String... args)  {
        try {
            String params= "start=1&size=1";
            String content= HttpClientUtil.getByUrl(url+"?" + params,null);
            log.error(content);
            JSONObject obj= (JSONObject) JSONObject.parse("{name:1}");
            Integer totalNUM = new Integer(((JSONObject) ((JSONObject) obj.get("data")).get("page")).get("total").toString());
            Integer page=totalNUM/20;
            if(page*20<totalNUM){
                page++;
            }

           /* for (int index = 1; index <= page; index++) {
                params= "size=20&start="+index;
                String content= HttpClientUtil.getByUrl(url+"?" + params,null);
                log.error(index+"index:"+content);
            }*/

        } catch (IOException e) {
            log.error("HttpTest", e);
        }
    }
}
