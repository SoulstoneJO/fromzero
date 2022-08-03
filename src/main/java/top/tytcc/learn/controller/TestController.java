package top.tytcc.learn.controller;

import java.util.List;
import top.tytcc.learn.model.request.UserDetailRequest;
import top.tytcc.learn.model.response.UserDetailResponse;
import top.tytcc.learn.repository.entity.generated.Admin;
import top.tytcc.learn.service.UserDetailService;
import top.tytcc.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

  @GetMapping("/get_user") // Get路径
  public List<Admin> getUser() {
    return userService.getUser();
  }

  @PostMapping("/user_detail")
  public UserDetailResponse userDetail(@RequestBody UserDetailRequest userDetailRequest) {
    return userDetailService.queryUserDetail(userDetailRequest);
  }

}
