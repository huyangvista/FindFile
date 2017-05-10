import vdll.data.msql.MySqlString;
import vdll.utils.ParmsUtil;
import vdll.utils.String.StringGet;
import vdll.utils.io.FileOperate;

import javax.jnlp.FileOpenService;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hocean on 2017/5/10.
 */
public class Main {
    static String fileNamf = "1365676089";

    //数据库字段
    static String f_TicketNumber = "grossrefund_amount";
    static String f_grossrefund_amount = "grossrefund_amount";
    static String f_refundtickettax = "refundtickettax";
    static String f_ticketstatus = "ticketstatus";
    static String f_dedu = "dedu";
    static String f_realrefundticketfee = "realrefundticketfee";
    static String f_rfnb = "rfnb";
    static String f_rtime = "rtime";

    //XML标签
    static String t_TicketNumber = "TicketNumber";
    static String t_grossrefund_amount = "Amount";
    static String t_refundtickettax = "";
    static String t_ticketstatus = "R";
    static String t_dedu = "DEDU";
    static String t_realrefundticketfee = "TFAR";
    static String t_rfnb = "RFNB";
    static String t_rtime = "TIME";

    //获取到的参数值
    static String TicketNumber = "";
    static String grossrefund_amount = "";
    static String refundtickettax = "";  //calc  refundtickettax = realrefundticketfee + dedu - grossrefund_amoun
    static String ticketstatus = "R";  //def
    static String dedu = "";
    static String realrefundticketfee = "";   // 除以100
    static String rfnb = "";
    static String rtime = "";


    public static void main(String[] args) {

        //MySqlString.CreateDemo(mySql);

        List<File> list = find(new File("D:\\dpdata"));
        System.out.println("搜索 -> " + fileNamf );
        System.out.println("找到文件：" + list.size() + "个 ");
        String text ="";
        if(list.size() > 0){
            text = FileOperate.readTxt(list.get(0).getPath());
        }

        // String tag = "<TIME>000</TIME> sadasd001222fgsdfg<TIME>000</TIME>sdfasdfasdfa";

        grossrefund_amount = getTag(text, t_grossrefund_amount);
        dedu = getTag(text, t_dedu);
        realrefundticketfee = getTag(text, t_realrefundticketfee);
        rfnb = getTag(text, t_rfnb);
        rtime = getTag(text, t_rtime);
        TicketNumber = getTag(text, t_TicketNumber);

        double dGrossrefund_amoun = 0;
        double dDedu = 0;
        double dRealrefundticketfee = 0;
        double dRefundtickettax = 0;
        if (ParmsUtil.isNumber(grossrefund_amount)) {
            dGrossrefund_amoun = Double.parseDouble(grossrefund_amount);
        }
        if (ParmsUtil.isNumber(dedu)) {
            dDedu = Double.parseDouble(dedu);
        }
        if (ParmsUtil.isNumber(realrefundticketfee)) {
            dRealrefundticketfee = Double.parseDouble(realrefundticketfee) / 100;
            realrefundticketfee = dRealrefundticketfee + "0";
        }
        dRefundtickettax = dRealrefundticketfee + dDedu - dGrossrefund_amoun;
        refundtickettax = dRefundtickettax + "0";

        rtime = rtime.substring(0,10) + " " + rtime.substring(11,19);

        System.out.println("按最后找到的标签值,生成语句： ");
        System.out.println(getUpdate(TicketNumber, f_grossrefund_amount, grossrefund_amount));
        System.out.println(getUpdate(TicketNumber, f_refundtickettax, refundtickettax));
        System.out.println(getUpdate(TicketNumber, f_ticketstatus, ticketstatus));
        System.out.println(getUpdate(TicketNumber, f_dedu, dedu));
        System.out.println(getUpdate(TicketNumber, f_realrefundticketfee, realrefundticketfee));
        System.out.println(getUpdate(TicketNumber, f_rfnb, rfnb));
        System.out.println(getUpdate(TicketNumber, f_rtime, rtime));

    }

    public static List<File> find(File dir) {
        List<File> list = new ArrayList<>();
        find(list, dir);
        return list;
    }

    private static void find(List<File> list, File dir) {
        File[] fs = dir.listFiles();
        for (int i = 0; i < fs.length; i++) {
            File f = fs[i];
            if (f.isDirectory()) {
                find(list, f);
            } else {
                // 20170509095200
                if (f.getName().contains(fileNamf)) {
                    //System.out.println(f.getName());
                    list.add(f);
                }
            }
        }
    }

    public static String getTag(String text, String t) {
        List<String> lt = StringGet.getTagIn(text, "<" + t + ">", "</" + t + ">");
        if (lt.size() > 0) {
            return lt.get(lt.size() - 1).trim();
        }
        return "";
    }

    public static String getUpdate(String tktNumber, String f, String v) {
        return String.format("UPDATE T_BLUESKY_ORD_TKTDATA  set %s = '%s'   where ticketnumber='%s';", f, v, tktNumber);
    }

}


/*
select rfnb, realrefundticketfee, ticketstatus, rtime, dedu, zval, cair
from T_BLUESKY_ORD_TKTDATA where ticketnumber = '1373781861';

UPDATE T_BLUESKY_ORD_TKTDATA  set grossrefund_amount=880.00        where ticketnumber='1373781861';
UPDATE T_BLUESKY_ORD_TKTDATA  set refundtickettax=50.00            where ticketnumber='1373781861';
UPDATE T_BLUESKY_ORD_TKTDATA  set ticketstatus='R'                 where ticketnumber='1373781861';
UPDATE T_BLUESKY_ORD_TKTDATA  set dedu=264.00                      where ticketnumber='1373781861';
UPDATE T_BLUESKY_ORD_TKTDATA  set realrefundticketfee=666.00       where ticketnumber='1373781861';
UPDATE T_BLUESKY_ORD_TKTDATA  set rfnb = '167698493'               where ticketnumber='1373781861';
UPDATE T_BLUESKY_ORD_TKTDATA  set rtime = '2017-05-10 11:41:00'    where ticketnumber='1373781861';

UPDATE T_BLUESKY_ORD_TKTDATA  set grossrefund_amount = '880.00'   where ticketnumber='1373781861';
UPDATE T_BLUESKY_ORD_TKTDATA  set refundtickettax = '50.0'   where ticketnumber='1373781861';
UPDATE T_BLUESKY_ORD_TKTDATA  set ticketstatus = 'R'   where ticketnumber='1373781861';
UPDATE T_BLUESKY_ORD_TKTDATA  set dedu = '264.00      '   where ticketnumber='1373781861';
UPDATE T_BLUESKY_ORD_TKTDATA  set realrefundticketfee = '66600'   where ticketnumber='1373781861';
UPDATE T_BLUESKY_ORD_TKTDATA  set rfnb = '167698493'   where ticketnumber='1373781861';
UPDATE T_BLUESKY_ORD_TKTDATA  set rtime = '2017-05-10T11:41:00Z'   where ticketnumber='1373781861';

梁志福，Mate 2017/5/10 13:55:34
refundtickettax = realrefundticketfee + dedu - grossrefund_amoun
 */