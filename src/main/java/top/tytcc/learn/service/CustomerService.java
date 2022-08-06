package top.tytcc.learn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tytcc.learn.repository.entity.content.generated.CustomerInfo;
import top.tytcc.learn.repository.entity.content.generated.CustomerInfoExample;
import top.tytcc.learn.repository.mapper.content.generated.CustomerInfoMapper;

@Service
public class CustomerService {
  @Autowired
  CustomerInfoMapper customerInfoMapper;

  public List<CustomerInfo> getCustomerInfo() {
    final var example = new CustomerInfoExample();
    return customerInfoMapper.selectByExample(example);
  }
}
