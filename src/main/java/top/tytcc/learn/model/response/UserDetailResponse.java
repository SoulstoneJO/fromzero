package top.tytcc.learn.model.response;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import top.tytcc.learn.repository.entity.generated.Permission;

@Data
@Builder
public class UserDetailResponse {
  private Integer userId;
  private String userName;
  private String roleName;
  private List<Permission> permissionList;
}
