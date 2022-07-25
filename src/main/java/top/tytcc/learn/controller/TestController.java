package top.tytcc.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.tytcc.learn.dao.User;

/**
 * TestController.
 */
@RestController // Spring容器托管 https://blog.csdn.net/u010412719/article/details/69710480
public class TestController {

  @GetMapping("/get") // Get路径
  public String get(String name) {
    return "Greetings from Spring Boot! " + name;
  }

  /**
   * post.
   */
  @PostMapping("/post") // Post路径
  public User post(@RequestBody
                       User user) { // @RequestBody注解 https://blog.csdn.net/u011066470/article/details/112502544
    // json https://zh.wikipedia.org/wiki/JSON
    // https://www.runoob.com/json/json-syntax.html
    return user;
  }

}
