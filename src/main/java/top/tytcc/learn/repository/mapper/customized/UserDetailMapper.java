package top.tytcc.learn.repository.mapper.customized;

import top.tytcc.learn.repository.entity.customized.UserDetailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDetailMapper {
  UserDetailEntity selectUserDetailByUserId(@Param("userId") Integer userId);
}
