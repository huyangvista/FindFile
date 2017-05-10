package vdll.utils.String;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Hocean on 2017/2/10.
 */
public class StringGet {


    public static void main(String[] args) {
        String ss = "\"陈伟\"<chenwei@btravelplus.com>\n" +
                "\"王大光\"<wangdaguang@btravelplus.com>\n" +
                "\"张旺旺\"<zhangwangwang@btravelplus.com>\n" +
                "\"黄喆\"<huangzhe@btravelplus.com>\n" +
                "\"冷世胤\"<lengshiyin@btravelplus.com>\n" +
                "\"刘晶晶\"<liujingjing@btravelplus.com>\n" +
                "\"肖丹\"<xiaodan@btravelplus.com>\n" +
                "\"王玉荣\"<wangyurong@btravelplus.com>\n" +
                "\"袁志芳\"<yuanzhifang@btravelplus.com>\n" +
                "\"张浩\"<zhanghao@btravelplus.com>\n" +
                "\"王兆迎\"<wangzhaoying@btravelplus.com>\n" +
                "\"刘树鹏\"<liushupeng@btravelplus.com>\n" +
                "\"乔桐\"<qiaotong@btravelplus.com>\n" +
                "\"吉尚叶\"<jishangye@btravelplus.com>\n" +
                "\"鲍学慧\"<baoxuehui@btravelplus.com>\n" +
                "\"张宏\"<zhanghong@btravelplus.com>\n" +
                "\"汪敬琳\"<wangjinglin@btravelplus.com>\n" +
                "\"任倩雅\"<renqianya@btravelplus.com>\n" +
                "\"施可悦\"<shikeyue@btravelplus.com>\n" +
                "\"梁志福\"<liangzhifu@btravelplus.com>\n" +
                "\"刘陶\"<liutao@btravelplus.com>\n" +
                "\"段沛欣\"<duanpeixin@btravelplus.com>\n" +
                "\"胡海洋\"<huhaiyang@btravelplus.com>\n" +
                "\"张筱祺\"<zhangxiaoqi@btravelplus.com>\n" +
                "\"曹紫薇\"<caoziwei@btravelplus.com>\n" +
                "\"曹爱冬\"<caoaidong@btravelplus.com>\n" +
                "\"代志英\"<daizhiying@btravelplus.com>\n" +
                "\"李丹\"<lidan@btravelplus.com>\n" +
                "\"汤哲\"<tangzhe@btravelplus.com>\n" +
                "\"tbi01\"<tbi01@btravelplus.com>\n" +
                "\"杜鹃\"<dujuan@btravelplus.com>\n" +
                "\"赵洋\"<zhaoyang@btravelplus.com>\n" +
                "\"刘小萌\"<liuxiaomeng@btravelplus.com>\n" +
                "\"高燕\"<gaoyan@btravelplus.com>\n" +
                "\"曹晓春\"<caoxiaochun@btravelplus.com>\n" +
                "\"高燕/曹晓春\"<airticket-1@btravelplus.com>\n" +
                "\"杜鹃组\"<airticket@btravelplus.com>\n" +
                "\"甄子奕\"<zhenziyi@btravelplus.com>\n" +
                "\"张芸溪\"<zhangyunxi@btravelplus.com>\n" +
                "\"徐翠静\"<xucuijing@btravelplus.com>\n" +
                "\"王梦露\"<wangmenglu@btravelplus.com>\n" +
                "\"周琦\"<zhouqi@btravelplus.com>\n" +
                "\"张莉\"<zhangli@btravelplus.com>\n" +
                "\"薛晶\"<xuejing@btravelplus.com>\n" +
                "\"刘长双\"<liuchangshuang@btravelplus.com>\n" +
                "\"李莹\"<liying@btravelplus.com>\n" +
                "\"李平花\"<lipinghua@btravelplus.com>\n" +
                "\"赖金兰\"<laijinlan@btravelplus.com>\n" +
                "\"范婧\"<fanjing@btravelplus.com>\n" +
                "\"山姗\"<shanshan@btravelplus.com>\n" +
                "\"张煜\"<zhangyu@btravelplus.com>\n" +
                "\"李莎\"<lisha@btravelplus.com>\n" +
                "\"康莹\"<kangying@btravelplus.com>\n" +
                "\"侯佳音\"<houjiayin@btravelplus.com>\n" +
                "\"曹娜\"<caona@btravelplus.com>\n" +
                "\"刘晓静\"<liuxiaojing@btravelplus.com>\n" +
                "\"刘聪\"<liucong@btravelplus.com>\n" +
                "\"韩婉婵\"<hanwanchan@btravelplus.com>\n" +
                "\"郝媛妹\"<haoyuanmei@btravelplus.com>\n" +
                "\"么向媛\"<yaoxiangyuan@btravelplus.com>\n" +
                "\"闻树双\"<wenshushuang@btravelplus.com>\n" +
                "\"赵文畅\"<zhaowenchang@btravelplus.com>\n" +
                "\"张一珠\"<zhangyizhu@btravelplus.com>\n" +
                "\"张小丽\"<zhangxiaoli@btravelplus.com>\n" +
                "\"徐健刚\"<xujiangang@btravelplus.com>\n" +
                "\"闻扬铭\"<wenyangming@btravelplus.com>\n" +
                "\"王会颖\"<wanghuiying@btravelplus.com>\n" +
                "\"刘蓉\"<liurong@btravelplus.com>\n" +
                "\"陈虹\"<chenhong@btravelplus.com>\n" +
                "\"王华楠\"<wanghuanan@btravelplus.com>\n" +
                "\"包欣欣\"<baoxinxin@btravelplus.com>\n" +
                "\"李琼\"<liqiong@btravelplus.com>\n" +
                "\"王雨朦\"<wangyumeng@btravelplus.com>\n" +
                "\"冯梓珈\"<fengzijia@btravelplus.com>\n" +
                "\"赵静\"<zhaojing@btravelplus.com>\n" +
                "\"刘博\"<liubo@btravelplus.com>\n" +
                "\"吴丽娟\"<wulijuan@btravelplus.com>\n" +
                "\"邢沛娱\"<xingpeiyu@btravelplus.com>\n" +
                "\"王哲\"<wangzhe@btravelplus.com>\n" +
                "\"梁惠婷\"<lianghuiting@btravelplus.com>\n" +
                "\"李刚\"<ligang@btravelplus.com>\n" +
                "\"赵孝敏\"<zhaoxiaomin@btravelplus.com>\n" +
                "\"王晶\"<wangjing@btravelplus.com>\n" +
                "\"张亚虹\"<zhangyahong@btravelplus.com>\n" +
                "\"吴光艳\"<wuguangyan@btravelplus.com>\n" +
                "\"王欣\"<wangxin@btravelplus.com>\n" +
                "\"韩媛媛\"<hanyuanyuan@btravelplus.com>\n" +
                "\"郭晓峰\"<guoxiaofeng@btravelplus.com>\n" +
                "\"蔡朦\"<caimeng@btravelplus.com>\n" +
                "\"曹梦萍\"<caomengping@btravelplus.com>\n" +
                "\"杨艳丽\"<yangyanli@btravelplus.com>\n" +
                "\"王蕊\"<wangrui@btravelplus.com>\n" +
                "\"张莹\"<zhangying@btravelplus.com>\n" +
                "\"赵智欣\"<zhaozhixin@btravelplus.com>\n" +
                "\"呼妍\"<huyan@btravelplus.com>\n" +
                "\"王新莉\"<wangxinli@btravelplus.com>\n" +
                "\"权璐\"<quanlu@btravelplus.com>\n" +
                "\"丁涵\"<dinghan@btravelplus.com>\n" +
                "\"李彤\"<litong@btravelplus.com>\n" +
                "\"遇伟\"<yuwei@btravelplus.com>\n";

        String sd = "lidan@btravelplus.com\n" +
                "shanshan@btravelplus.com\n" +
                "zhaozhixin@btravelplus.com\n" +
                "yuwei@btravelplus.com\n" +
                "dujuan@btravelplus.com\n" +
                "liying@btravelplus.com\n" +
                "chenfang@btravelplus.com\n" +
                "laijinlan@btravelplus.com\n" +
                "gaoyan@btravelplus.com\n" +
                "houjiayin@btravelplus.com\n" +
                "wuguangyan@btravelplus.com\n" +
                "xucuijing@btravelplus.com\n" +
                "hanyuanyuan@btravelplus.com\n" +
                "yangyanli@btravelplus.com\n" +
                "wanghuanan@btravelplus.com\n" +
                "caimeng@btravelplus.com\n" +
                "baoxinxin@btravelplus.com\n" +
                "quanlu@btravelplus.com\n" +
                "chenwei@btravelplus.com\n" +
                "wangdaguang@btravelplus.com\n" +
                "wangxinli@btravelplus.com\n" +
                "zhangwangwang@btravelplus.com\n" +
                "liqiong@btravelplus.com\n" +
                "chenhong@btravelplus.com\n" +
                "wangyurong@btravelplus.com\n" +
                "liujingjing@btravelplus.com\n" +
                "xiaodan@btravelplus.com\n" +
                "huangzhe@btravelplus.com\n" +
                "lengshiyin@btravelplus.com\n" +
                "zhangying@btravelplus.com\n" +
                "fanjing@btravelplus.com\n" +
                "yuanzhifang@btravelplus.com\n" +
                "zhanghao@btravelplus.com\n" +
                "qiaotong@btravelplus.com\n" +
                "liushupeng@btravelplus.com\n" +
                "tangzhe@btravelplus.com\n" +
                "renqianya@btravelplus.com\n" +
                "caoxiaochun@btravelplus.com\n" +
                "shikeyue@btravelplus.com\n" +
                "huyan@btravelplus.com\n" +
                "hanwanchan@btravelplus.com\n" +
                "wangjinglin@btravelplus.com\n" +
                "wangzhaoying@btravelplus.com\n" +
                "zhaojing@btravelplus.com\n" +
                "baoxuehui@btravelplus.com\n" +
                "wangyumeng@btravelplus.com\n" +
                "jishangye@btravelplus.com\n" +
                "daizhiying@btravelplus.com\n" +
                "zhangli@btravelplus.com\n" +
                "duanpeixin@btravelplus.com\n" +
                "liangzhifu@btravelplus.com\n" +
                "huhaiyang@btravelplus.com\n" +
                "zhangxiaoqi@btravelplus.com\n" +
                "liutao@btravelplus.com\n" +
                "zhanghong@btravelplus.com\n" +
                "fengzijia@btravelplus.com\n" +
                "guoxiaofeng@btravelplus.com\n" +
                "wangxin@btravelplus.com\n" +
                "zhangyahong@btravelplus.com\n" +
                "ligang@btravelplus.com\n" +
                "zhaoxiaomin@btravelplus.com\n" +
                "caoziwei@btravelplus.com\n" +
                "caona@btravelplus.com\n" +
                "xujiangang@btravelplus.com\n" +
                "liuxiaojing@btravelplus.com\n" +
                "pengwen@btravelplus.com\n" +
                "liubo@btravelplus.com\n" +
                "liurong@btravelplus.com\n" +
                "zhangxiaoli@btravelplus.com\n" +
                "liuxiaomeng@btravelplus.com\n" +
                "wangshan@btravelplus.com\n" +
                "kangying@btravelplus.com\n" +
                "caomengping@btravelplus.com\n" +
                "zhouqi@btravelplus.com\n" +
                "litong@btravelplus.com\n" +
                "xumingze@btravelplus.com\n" +
                "liudandan@btravelplus.com\n" +
                "zhangyu@btravelplus.com\n" +
                "liucong@btravelplus.com\n" +
                "wenyangming@btravelplus.com\n" +
                "liuchangshuang@btravelplus.com\n" +
                "xuejing@btravelplus.com\n" +
                "wulijuan@btravelplus.com\n" +
                "zhaowenchang@btravelplus.com\n" +
                "lanyongzhi@btravelplus.com\n" +
                "wangzhe@btravelplus.com\n" +
                "zhangyizhu@btravelplus.com\n" +
                "daizhiying01@btravelplus.com\n" +
                "xingpeiyu@btravelplus.com\n" +
                "wangjing@btravelplus.com\n" +
                "wanghuiying@btravelplus.com\n" +
                "wangmenglu@btravelplus.com\n" +
                "zhaoyang@btravelplus.com\n" +
                "wangrui@btravelplus.com\n" +
                "lianghuiting@btravelplus.com\n" +
                "caoaidong@btravelplus.com\n" +
                "lipinghua@btravelplus.com\n" +
                "lisha@btravelplus.com";

        String[] aa = ss.split("\n");
        String[] bb = sd.split("\n");


        for (String a : aa) {
            boolean vb = false;
            for (String b : bb) {
                if (a.contains(b)) {
                    vb = true;
                }
            }
            if(!vb){
                System.out.println(a);
            }
        }

    }


    public static List<String> getTagIn(String txt, String ltag, String rtag) {
        /*String find = null;
        String regex = String.format("(?<=%s)(\\S+)(?=%s)",ltag,rtag);
        Pattern pattern = Pattern.compile (regex);
        Matcher matcher = pattern.matcher (text);
        while (matcher.find())
        {
            find = matcher.group ();
        }
        return find;*/
        List<String> list = new ArrayList<>();

        while (true) {
            int p = txt.indexOf(ltag);
            int q = txt.indexOf(rtag);
            if ((p >= 0 && q >= 0)) {
                list.add(txt.substring(p + ltag.length(), q));
                txt = txt.substring(q + rtag.length());
            } else {
                break;
            }
        }

        return list;
    }
}
