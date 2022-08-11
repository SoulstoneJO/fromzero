package top.tytcc.learn.repository.entity.admin.customized;

import lombok.Data;

@Data
public class UserDetailEntity {
  private Integer userId;
  private String userName;
  private String roleName;
  private byte[] rolePermission;
}
