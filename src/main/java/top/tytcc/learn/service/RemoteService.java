package top.tytcc.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tytcc.learn.network.TestRemoteClient;
import top.tytcc.learn.network.entity.TestInfoRemoteEntity;
import top.tytcc.learn.repository.entity.content.generated.CustomerInfo;

import java.util.List;

@Service
public class RemoteService {
  @Autowired
  TestRemoteClient testRemoteClient;

  public TestInfoRemoteEntity getRemoteInfo() {
    // info_id可以是从前端传入，也可以是按照业务逻辑从数据库获取

    return testRemoteClient.testRemoteCall("1", TestInfoRemoteEntity.class);
  }
}
