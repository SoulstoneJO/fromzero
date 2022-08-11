package top.tytcc.learn.controller;

import generated.api.TestControllerApi;
import generated.model.CustomerInfo;
import generated.model.RemoteTestResponse;
import generated.model.UserDetailRequest;
import generated.model.UserDetailResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import top.tytcc.learn.service.CustomerService;
import top.tytcc.learn.service.RemoteService;
import top.tytcc.learn.service.UserDetailService;


/**
 * TestController.
 */
@RestController // Spring容器托管 https://blog.csdn.net/u010412719/article/details/69710480
public class TestController implements TestControllerApi {
  @Autowired
  UserDetailService userDetailService;
  @Autowired
  CustomerService customerService;
  @Autowired
  RemoteService remoteService;

  @Override
  public ResponseEntity<UserDetailResponse> userDetail(String language,
                                                       @Valid UserDetailRequest userDetailRequest) {
    return ResponseEntity.ok(userDetailService.queryUserDetail(userDetailRequest, language));
  }

  @Override
  public ResponseEntity<List<CustomerInfo>> customerInfo() {
    return ResponseEntity.ok(customerService.getCustomerInfo());
  }

  @Override
  public ResponseEntity<RemoteTestResponse> remoteTest() {
    return ResponseEntity.ok(remoteService.getRemoteInfo());
  }
}
