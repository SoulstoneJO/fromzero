package top.tytcc.learn.controller;

import java.util.List;
import top.tytcc.learn.repository.entity.generated.Admin;
import top.tytcc.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController.
 */
@RestController // Spring容器托管 https://blog.csdn.net/u010412719/article/details/69710480
public class TestController {
  @Autowired // DI 依赖注入 IOC 控制反转
  UserService userService;

  @GetMapping("/get_user") // Get路径
  public List<Admin> getUser() {
    return userService.getUser();
  }
}
