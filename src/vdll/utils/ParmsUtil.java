package vdll.utils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author Hocean  @version 2016年8月11日 下午2:07:45.
 */
public class ParmsUtil {
    public static void main(String[] args) {
        System.out.println(isNumber("2345234520"));
        System.out.println(isNumber("0"));
        System.out.println(isNumber("0."));
        System.out.println(isNumber(".0"));
        System.out.println(isNumber("."));
        System.out.println(isNumber("0..3"));
        System.out.println(isNumber("0.3asdf "));

    }

    public interface Action<T>{
        void invoke(T t);
    }


    public ParmsUtil() {
    }









    /**
     * 添加前缀
     *
     * @param url
     * @return
     */
    public static String vto(String url) {
        String EDIRCT = "redirect:"; //重定向页面前缀
        return EDIRCT + url;
    }

    public static enum EFilter {
        model, map
    }


    /**
     * 返回到前台字段动态添加时
     *
     * @param t   添加后的 对象(子类)
     * @param old 原对象（父类）
     * @return
     */
    public static <T> T addField(T t, Object old) {
        Class<?> cls = old.getClass(); //反射
        for (; cls != Object.class; cls = cls.getSuperclass()) {
            try {
                Field[] fields = cls.getDeclaredFields(); //属性
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true); //反射私有属性 权限
                    Field field = fields[i]; //第几个参数
                    Class<?> type = field.getType(); //反射类型
                    @SuppressWarnings("unused")
                    String typeName = type.getName();//得到类型
                    //System.out.println(typeName);
                    String fieldName = field.getName(); //反射字段
                    //System.out.println(fieldName); //字段名
                    try {
                        Object value = field.get(old); //字段值
                        //System.out.println(value);

                        Field fieldFind = null; //需要寻找目标对象
                        Class<?> clazz = t.getClass();
                        for (; clazz != Object.class; clazz = clazz.getSuperclass()) { //寻找目标对象的属性
                            try {
                                fieldFind = clazz.getDeclaredField(fieldName);
                            } catch (Exception e) {
                                //不可打印 不可抛出    否则不会进入到父类中
                            }
                        }
                        //Class<?> clazz = tr.getClass(); //反射
                        //fieldFind = clazz.getDeclaredField(fieldName);
                        fieldFind.setAccessible(true); //反射私有属性 权限
                        fieldFind.set(t, value); //赋值到目标类
                    } catch (Exception e1) {
                    }
                }
            } catch (Exception e) {
            }
        }
        return t;

    }

    /**
     * 快速键值对
     *
     * @param o
     * @return
     */
    public static Map<String, Object> markMap(Object... o) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < o.length; i += 2) {
            map.put(o[i].toString(), o[i + 1]);
        }
        return map;
    }


    /**
     * 创建订单号
     *
     * @param first 需要两位前缀
     * @return
     */
    public static String createOrderNo(String first) {
        String orderNo = first + new Date().getTime();//需要生成
        return orderNo;
    }

    /**
     * 判斷字符串是否能  转换为int double 去空格
     *
     * @param o
     * @return
     */
    public static boolean isNumber(Object o) {
        if (o == null) return false;
        String str = o.toString().trim();
        int len = str.length();
        int po = 0;
        char point = '.';
        for (int i = len - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                if (c == point) {
                    if (++po > 1) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (po <= 0) {
            return len >= 1;
        } else if (po <= 1) {
            return len >= 2;
        } else {
            return false;
        }
    }


    /**
     * 检测可现实map
     *
     * @param list
     */
    public static void KeyOneSore(List<Map<String, Object>> list) {
        if (list == null) return;
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> en = it.next();
                Object val = en.getValue();
                map.put(en.getKey(), ArrayToString(val));
            }
        }
    }

    /**
     * 集合类型转换为字符串  递归
     *
     * @param val
     * @return
     */
    public static String ArrayToString(Object val) {
        if (val instanceof String[]) { //是数组
            List<String> listSore = Arrays.asList((String[]) val);
            Collections.sort(listSore);
            ArrayToString(listSore.get(0));
        }
        return val.toString();
    }

    /**
     * 对集合的指定字段 进行最大最小选择 sore -1 选小的 1 选大的
     *
     * @param list
     * @param key
     * @param sore 小于0 选最小的
     */
    public static void KeyOneSore(List<Map<String, Object>> list, String key, int sore) {
        if (list == null) return;
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            if (map.containsKey(key)) {
                Object val = map.get(key);
                if (val.getClass().isArray()) { //是数组
                    List<String> listSore = Arrays.asList((String[]) val);
                    Collections.sort(listSore);
                    map.put(key, sore < 0 ? listSore.get(0) : listSore.get(listSore.size() - 1));
                }
            }
        }
    }

    /**
     * 多选 返回原来的搜索状态
     * 如选择框初始值 String[] statusesBase ={"0","2","3","4"};
     * 返回给前台页面 filterMap.put("statusesBase",typeEs(statuses,statusesBase));
     *
     * @param sear 搜索的复选框数组
     * @param base 复选框所有的值
     * @return 返回原来的搜索状态
     */
    public static String[] typeEs(String[] sear, String[] base) {
        String[] re = new String[base.length];
        if (sear != null) {
            for (int i = 0; i < base.length; i++) {
                int j = 0;
                for (; j < sear.length; j++) {
                    if (base[i].equals(sear[j])) {
                        re[i] = "-1";
                        break;
                    }
                }
                if (j >= sear.length) {
                    re[i] = null;
                }
            }
        }
        return re;
    }

    /**
     * 多选合成语句
     * 如条件 <if test="status_es != null and status_es != ''" > and ${status_es}</if>
     * 对应数据库字段  status
     * 则 filterMap.put("status_es",sqlEs(statuses,"status"));
     *
     * @param sear  搜索的复选框值
     * @param field 对应数据库字段
     * @return
     */
    public static String sqlEs(String[] sear, String field) {
        String re = "";
        if (sear != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (String s : sear) {
                if (s == null) continue;
                if (s.trim().equals("")) {
                    sb.append(field);
                    sb.append(" = ");
                    sb.append(s);
                    continue;
                }
                sb.append(field);
                sb.append(" like '%");
                sb.append(s);
                sb.append("%' or ");
            }
            if (sb.length() >= 3) {
                sb.delete(sb.length() - 3, sb.length());
                sb.append(")");
                re = sb.toString();
            }
        } else {
            re = field + " is null";
        }
        return re;

    }


    public enum EListParmsRep {
        replace,  //替换字段为新的值 {ParmsUtil.EListParmsRep.replaceIndex,"settle_type",0,"公司月结","个人支付"}
        replaceIndex,  //序列替换 {ParmsUtil.EListParmsRep.replaceIndex,"pay_type",0,"艺龙", "官网公务卡", "对公汇款", "7天月结", "公司携程", "公司垫付", "航旅通"}
        clone, //替换字段为新的字段 	{ParmsUtil.EListParmsRep.clone,"business_type_item","business_type_ss"},
        cloneSelect,
        cloneSelectReplace,
        cloneSelectValue,
        ifnulladd, gather  // 替换字段为新的选择字段 并添加到新的字段  {ParmsUtil.EListParmsRep.gather,"settle_type","settle_name","0","company_name","1","name"}
    }

    /**
     * 对列表进行参数转换
     *
     * @param list
     * @param new  Object[][]{    {ParmsUtil.EListParmsRep.replaceIndex,"settle_type",0,"公司月结","个人支付"}     }
     */
    public static void setListParmsRep(List<Map<String, Object>> list, Object[]... val) {
        if (list == null) return;
        try {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                for (int j = 0; j < val.length; j++) {
                    Object[] col = val[j];
                    if (col.length < 2) continue;
                    EListParmsRep type = (EListParmsRep) col[0];
                    String key = col[1].toString();
                    switch (type) {
                        case replace:
                            if (map.containsKey(key)) {
                                Object v = map.get(key);
                                for (int k = 2; k < col.length && k + 1 < col.length; k += 2) {
                                    if (v != null && v.toString().equals(col[k].toString())) {
                                        map.put(key, col[k + 1]);
                                    }
                                }
                            }
                            break;
                        case ifnulladd:
                            if (!map.containsKey(key)) {
                                map.put(key, col[2]);
                            }
                            break;
                        case replaceIndex:
                            if (map.containsKey(key)) {
                                Object v = map.get(key);
                                int start = Integer.parseInt(col[2].toString());
                                for (int k = 3; k < col.length; k++) {
                                    if (v != null &&  v.toString().equals(Integer.toString(k - 3 + start))) {
                                        map.put(key, col[k]);
                                    }
                                }
                            }
                            break;
                        case gather:
                            String newKey = col[2].toString();
                            if (map.containsKey(key)) {
                                Object v = map.get(key);
                                for (int k = 3; k < col.length && k + 1 < col.length; k += 2) {
                                    if (v != null && v.toString().equals(col[k].toString())) {
                                        if (map.containsKey(col[k + 1].toString())) {
                                            map.put(newKey, map.get(col[k + 1].toString()));
                                        }
                                    }
                                }
                            }
                            break;
                        case clone:
                            newKey = col[2].toString();
                            if (map.containsKey(key)) {
                                Object v = map.get(key);
                                map.put(newKey, v);
                            }
                            break;
                        case cloneSelect:
                            newKey = col[2].toString();
                            if (map.containsKey(key)) {
                                Object v = map.get(key);
                                for (int k = 3; k + 1 < col.length; k += 2) {
                                    if (map.containsKey(col[k].toString())) {
                                        if (v != null &&  v.toString().equals(map.get(col[k + 1].toString()))) {
                                            map.put(newKey, v);
                                        }
                                    }
                                }
                            }
                            break;
                        case cloneSelectReplace:
                            newKey = col[2].toString();
                            if (map.containsKey(key)) {
                                Object v = map.get(key);
                                Object[] rep = (Object[]) col[col.length - 1];
                                int k = 3;
                                for (; k + 1 < col.length - 1; k += 2) {
                                    if (map.containsKey(col[k].toString())) {
                                        if (!col[k + 1].toString().equals(map.get(col[k].toString()))) {
                                            break;
                                        }
                                    }
                                }
                                if (k + 1 >= col.length - 1) {
                                    for (int m = 0; m + 1 < rep.length; m += 2) {
                                        Object rv = rep[m];
                                            if (v != null && rv.toString().equals(v.toString())) {
                                                map.put(newKey, rep[m + 1].toString());
                                            }
                                    }
                                }
                            }
                            break;
                        case cloneSelectValue:
                            newKey = col[2].toString();
                            if (map.containsKey(key)) {
                                //Object v = map.get(key);
                                Object rep =  col[col.length - 1];
                                int k = 3;
                                for (; k + 1 < col.length - 1; k += 2) {
                                    if (map.containsKey(col[k].toString())) {
                                        if (!col[k + 1].toString().equals(map.get(col[k].toString()))) {
                                            break;
                                        }
                                    }
                                }
                                if (k + 1 >= col.length - 1) {
                                    map.put(newKey, rep);
                                }
                            }
                            break;
                        default:
                            break;
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void setListParmsRep(List<Map<String, Object>> list, Action<Map> actList, Action<Map.Entry<String, Object>> actMap) {
        for (int i = 0; i < list.size() ; i++) {
            Map<String, Object> map = list.get(i);
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Object> next = iterator.next();
                if (actMap != null) {
                    actMap.invoke(next);
                }
            }
            if (actList != null) {
                actList.invoke(map);
            }
        }
    }


    /**
     * 生成UUID
     *
     * @return
     */
    public static String makeId() {
        return UUID.randomUUID().toString();
    }
}
