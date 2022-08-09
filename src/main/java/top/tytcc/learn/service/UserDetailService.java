package top.tytcc.learn.service;

import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.context.MessageSource;
import top.tytcc.learn.common.FromZeroUtil;
import top.tytcc.learn.common.exception.FromZeroParameterException;
import top.tytcc.learn.constant.MessageCode;
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
  @Autowired
  MessageSource messageSource;

  public UserDetailResponse queryUserDetail(UserDetailRequest request, String language) {
    if (ObjectUtils.isEmpty(request.getUserId())) {
      throw new FromZeroParameterException(messageSource.getMessage(MessageCode.PARAM_USERID_EMPTY, null, new Locale(language)));
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
