package com.bosssoft.gpmscloud.controller;

import com.bosssoft.gpmscloud.common.core.response.RestResponse;
import com.bosssoft.gpmscloud.common.core.response.RestResponseBuilder;
import com.bosssoft.gpmscloud.security.oauth.client.annotation.IgnoreToken;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Pan Bao Qiang
 * @Description
 * @create 2020-08-25 22:11
 */
@RestController("PlatformIndexController")
@RequestMapping
@Api(tags = "Controller入口测试")
public class IndexController {
    /**
     * 无需权限
     *
     * @return
     */
    @GetMapping("index")
    @IgnoreToken
    public RestResponse<String> index() {
        return RestResponseBuilder.<String>builder().data("welcome to GPX-BASIC-PLATFORM!").build();
    }

    /**
     * 需要权限
     *
     * @return
     */
    @GetMapping("indexWithToken")
    public RestResponse<String> indexWithToken() {
        return RestResponseBuilder.<String>builder().data("welcome to GPX-BASIC-PLATFORM! Authentication Success!").build();
    }

    @GetMapping("add")
    public RestResponse<Integer> add(int a, int b) {
        return RestResponseBuilder.<Integer>builder().data(a + b).build();
    }

    @GetMapping("delete")
    public RestResponse<Integer> delete(int a, int b) {
        return RestResponseBuilder.<Integer>builder().data(a - b).build();
    }

//    @PostConstruct
//    public void test() {
//        openServer();
//    }
//
//    private void openServer() {
//        Thread thread = new Thread(() -> {
//            FileUpLoadServer fileUpLoadServer = null;
//            try {
//                fileUpLoadServer = new FileUpLoadServer(FinalVariables.SERVER_PORT);
//                fileUpLoadServer.load();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }, "server");
//        thread.start();
//    }

    /**
     * redis测试调用,结合@Cacheable
     *
     * @return
     */
    @GetMapping("pathTest")
    public RestResponse<String> pathTest(String path, String filename) {

        String newKey = path + "/" + filename;
        return RestResponseBuilder.<String>builder().data(String.join("*", newKey.split("\\/+"))).build();
    }

}
