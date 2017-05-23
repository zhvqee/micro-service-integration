package com.qee.controller;

import com.qee.remote.model.User;
import com.qee.service.HelloBackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@RestController
public class HelloController {

    @Autowired
    private HelloBackgroundService helloBackgroundService;

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(20,40, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());


    @RequestMapping("/hello")
    @ResponseBody
    public Map<String,Object> hello(){
        Map<String,Object> ret = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        String s1 = helloBackgroundService.hello("张三");
        sb.append(s1).append("\n");
        User user = null;
        try {
            user = helloBackgroundService.hello(URLEncoder.encode("李四", "UTF-8"), 30);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append(user.toString()).append("\n");
        String s3 = helloBackgroundService.hello(new User("王五", 19));
        sb.append(s3).append("\n");
        ret.put("show",sb.toString());
        return ret;
    }

    @RequestMapping("/cycleDo")
    @ResponseBody
    public Map<String,Object> cycleDo() throws ExecutionException, InterruptedException {
        Map<String,Object> maps = new ConcurrentHashMap<String, Object>();
        for (int i=1;i<50;i++){
            Future<String> task = task();
            System.out.println("===================="+i);
            maps.put("list"+i,task);
        }
        List<String> list = new ArrayList<String>();
        for(Map.Entry<String,Object> entry: maps.entrySet()){
            Future<String> task = (Future<String>) entry.getValue();
            String s = task.get();
            list.add(s);
        }
        Map<String,Object> ret = new HashMap<String, Object>();
        ret.put("list",list);
        return ret;
    }

    private   Future<String> task() throws ExecutionException, InterruptedException {
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Map<String,Object> ret = new HashMap<String, Object>();
                StringBuffer sb = new StringBuffer();
                String s1 = helloBackgroundService.hello("张三");
                sb.append(s1).append("\n");
                User user = null;
                try {
                    user = helloBackgroundService.hello(URLEncoder.encode("李四", "UTF-8"), 30);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                sb.append(user.toString()).append("\n");
                String s3 = helloBackgroundService.hello(new User("王五", 19));
                sb.append(s3).append("\n");
                ret.put("show",sb.toString());
                return ret.toString();
            }
        });
        return future;
    }
}
