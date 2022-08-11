package top.tytcc.learn.service;

import generated.model.CustomerInfo;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tytcc.learn.repository.entity.content.generated.CustomerInfoExample;
import top.tytcc.learn.repository.mapper.content.generated.CustomerInfoMapper;

@Service
public class CustomerService {
  @Autowired
  CustomerInfoMapper customerInfoMapper;

  public List<CustomerInfo> getCustomerInfo() {

    return customerInfoMapper.selectByExample(new CustomerInfoExample())
        .stream()
        .map(entity -> new CustomerInfo()
            .customerId(entity.getCustomerId())
            .customerEmail(entity.getCustomerEmail())
            .customerName(entity.getCustomerName())
            .customerLevel(Integer.valueOf(entity.getCustomerLevel()))
            .gender(entity.getGender())
            .birthday(String.valueOf(entity.getBirthday())))
        .collect(Collectors.toList());
  }
}
