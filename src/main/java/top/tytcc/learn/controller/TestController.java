package top.tytcc.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import top.tytcc.learn.model.request.UserDetailRequest;
import top.tytcc.learn.model.response.UserDetailResponse;
import top.tytcc.learn.network.entity.TestInfoRemoteEntity;
import top.tytcc.learn.repository.entity.admin.generated.Admin;
import top.tytcc.learn.repository.entity.content.generated.CustomerInfo;
import top.tytcc.learn.service.CustomerService;
import top.tytcc.learn.service.RemoteService;
import top.tytcc.learn.service.UserDetailService;
import top.tytcc.learn.service.UserService;

/**
 * TestController.
 */
@RestController // Spring容器托管 https://blog.csdn.net/u010412719/article/details/69710480
public class TestController {
  // 这里不采用restful API风格，采用Remote Procedure Call API风格 https://waylau.com/remote-procedure-calls/
  @Autowired // DI 依赖注入 IOC 控制反转
  UserService userService;
  @Autowired
  UserDetailService userDetailService;
  @Autowired
  CustomerService customerService;
  @Autowired
  RemoteService remoteService;


  @GetMapping("/get_user") // Get路径
  public List<Admin> getUser() {
    return userService.getUser();
  }

  @PostMapping("/user_detail")
  public UserDetailResponse userDetail(@RequestBody UserDetailRequest userDetailRequest, @RequestHeader("language") String language) {
    // final var i = 1 / 0; // 测试异常切面用
    return userDetailService.queryUserDetail(userDetailRequest, language);
  }

  @GetMapping("/customer_info")
  public List<CustomerInfo> getCustomerInfo() {
    return customerService.getCustomerInfo();
  }

  @GetMapping("/remote_test")
  public TestInfoRemoteEntity getRemoteInfo() {
    return remoteService.getRemoteInfo();
  }

}
