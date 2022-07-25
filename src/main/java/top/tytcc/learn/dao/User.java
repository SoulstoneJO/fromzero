package top.tytcc.learn.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 一个简单的dto实体类.
 */
@Getter
@Setter
@AllArgsConstructor
public class User {
  private final String name;
  private final String password;

}
