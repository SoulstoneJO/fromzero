package top.tytcc.learn.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FromZeroUtil {
  public static List<Integer> byteArrayToIntList(byte[] byteArray) {
    final var string = new String(byteArray);
    final var stringArray = string.substring(1, string.length() - 1).replaceAll(" ", "").split(",");
    return Arrays.stream(stringArray).map(Integer::valueOf).collect(Collectors.toList());
  }
}
