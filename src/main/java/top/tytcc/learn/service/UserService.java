package top.tytcc.learn.service;

import java.util.List;
import top.tytcc.learn.repository.entity.generated.Admin;
import top.tytcc.learn.repository.entity.generated.AdminExample;
import top.tytcc.learn.repository.mapper.generated.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 有些时候可以使用interface
@Service //交由spring框架管理，可以之后用于依赖注入
public class UserService {
  @Autowired
  AdminMapper adminMapper;

  public List<Admin> getUser() {
    final var adminExample = new AdminExample();
    return adminMapper.selectByExample(adminExample);
  }

}
