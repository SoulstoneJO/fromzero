package top.tytcc.learn.service;

import generated.model.InfoRemote;
import generated.model.RemoteTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tytcc.learn.network.TestRemoteClient;
import top.tytcc.learn.network.entity.TestInfoRemoteEntity;

@Service
public class RemoteService {
  @Autowired
  TestRemoteClient testRemoteClient;

  public RemoteTestResponse getRemoteInfo() {
    // info_id可以是从前端传入，也可以是按照业务逻辑从数据库获取

    final var testInfoRemoteEntity =
        testRemoteClient.testRemoteCall("1", TestInfoRemoteEntity.class);
    final var info = testInfoRemoteEntity.getInfo();
    return new RemoteTestResponse()
        .infoId(testInfoRemoteEntity.getInfoId())
        .info(new InfoRemote()
            .type(info.getType())
            .message(info.getMessage()));
  }
}
