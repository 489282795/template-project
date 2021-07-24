package com.cn.template.controller.base;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "该注解没有实际的使用意义", tags = "ActiveMQ测试类")
@RestController
@RequestMapping("/activemq")
public class ActiveMQTestController {

//    @Autowired
//    @Qualifier(value ="senderService")
//    private ActiveMQSenderService senderService;
//
//    @ApiOperation(value = "ActiveMQ测试接口",notes = "用来测试ActiveMQ发送消息")
//    @RequestMapping(method = RequestMethod.GET, value = "/sendMessage")
//    @ResponseBody
//    public Response senMessage() {
//        senderService.sendMessage("测试");
//        Response response = new Response();
//        response.setMessage("消息发送成功");
//        return response;
//    }
}
