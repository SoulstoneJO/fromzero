package top.tytcc.learn.service;

import generated.model.Permission;
import generated.model.UserDetailRequest;
import generated.model.UserDetailResponse;
import java.util.Locale;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import top.tytcc.learn.common.FromZeroUtil;
import top.tytcc.learn.common.exception.FromZeroParameterException;
import top.tytcc.learn.constant.MessageCode;
import top.tytcc.learn.repository.entity.admin.generated.PermissionKey;
import top.tytcc.learn.repository.mapper.admin.customized.UserDetailMapper;
import top.tytcc.learn.repository.mapper.admin.generated.PermissionMapper;


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
              final var permissionDB = permissionMapper.selectByPrimaryKey(permissionKey);
              return new Permission()
                  .permissionId(permissionDB.getPermissionId())
                  .permissionName(permissionDB.getPermissionName());
            }).collect(Collectors.toList());

    return new UserDetailResponse()
        .userId(userDetailEntity.getUserId())
        .userName(userDetailEntity.getUserName())
        .roleName(userDetailEntity.getRoleName())
        .permissionList(permissionList);
  }
}
