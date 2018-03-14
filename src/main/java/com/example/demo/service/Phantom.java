package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class Phantom {

    private String url;

    private String componentId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public void executeJs() throws IOException {
        Runtime rt = Runtime.getRuntime();
        //这里的url 换成上一步生成的html文件路径
//        String url = "http://localhost:8080/revenueAssuranceMetrics/index?email=true";
        //java 调用phantomjs执行脚本，传入需要截图的url。这里的phantomjs可以添加的环境bin下，或者在程序目录
        Process p = rt.exec("bash -c /client/phantomjs /client/chapture.js " + this.url);
//        InputStream is = p.getInputStream();
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//        StringBuffer sbf = new StringBuffer();
//        String tmp = "";
//        while((tmp = br.readLine())!=null){
//            sbf.append(tmp);
//        }
    }
}
