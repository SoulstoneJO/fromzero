package top.tytcc.learn.repository.mapper.admin.customized;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.tytcc.learn.repository.entity.admin.customized.UserDetailEntity;

@Mapper
public interface UserDetailMapper {
  UserDetailEntity selectUserDetailByUserId(@Param("userId") Integer userId);
}
