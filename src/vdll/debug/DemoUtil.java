package vdll.debug;

import vdll.utils.ReflectUtil;

import java.lang.reflect.Field;

/**
 * 调试输出 所有字段
 * Created by Hocean on 2017/4/7.
 */
public class DemoUtil {
    public static String toString(Object demo) {
        Field[] fields = ReflectUtil.getFields(demo.getClass());
        StringBuilder sb = new StringBuilder();
        for (Field item : fields) {
            sb.append(item.getName());
            sb.append(":");
            try {
                sb.append(item.get(demo));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
