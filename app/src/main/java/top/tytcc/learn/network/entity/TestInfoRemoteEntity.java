package top.tytcc.learn.network.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TestInfoRemoteEntity {
  @JsonProperty("info_id")
  private String infoId;
  private InfoRemoteEntity info;

}
