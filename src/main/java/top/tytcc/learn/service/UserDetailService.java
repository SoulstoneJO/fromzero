package top.tytcc.learn.service;

import java.util.stream.Collectors;
import top.tytcc.learn.common.FromZeroUtil;
import top.tytcc.learn.common.exception.FromZeroParameterException;
import top.tytcc.learn.model.request.UserDetailRequest;
import top.tytcc.learn.model.response.UserDetailResponse;
import top.tytcc.learn.repository.entity.admin.generated.PermissionKey;
import top.tytcc.learn.repository.mapper.admin.generated.PermissionMapper;
import top.tytcc.learn.repository.mapper.admin.customized.UserDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserDetailService {
  @Autowired
  UserDetailMapper userDetailMapper;
  @Autowired
  PermissionMapper permissionMapper;

  public UserDetailResponse queryUserDetail(UserDetailRequest request) {
    if (ObjectUtils.isEmpty(request.getUserId())) {
      // TODO message should be set in messageSource
      throw new FromZeroParameterException("FromZeroParameterException");
    }

    final var userDetailEntity = userDetailMapper.selectUserDetailByUserId(request.getUserId());

    // 流写法
    final var permissionList =
        FromZeroUtil.byteArrayToIntList(userDetailEntity.getRolePermission()).stream()
            .map(permissionId -> {
              final var permissionKey = new PermissionKey();
              permissionKey.setPermissionId(permissionId);
              return permissionMapper.selectByPrimaryKey(permissionKey);
            }).collect(Collectors.toList());

    // lombok builder写法
    return UserDetailResponse.builder()
        .userId(userDetailEntity.getUserId())
        .userName(userDetailEntity.getUserName())
        .roleName(userDetailEntity.getRoleName())
        .permissionList(permissionList)
        .build();
  }
}
