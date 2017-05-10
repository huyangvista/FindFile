package vdll.utils.String;


/**
 * @author gaobin
 */
public class StringUtil {
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }


    public static int getChineseCharacterCount(String str) {
        int ccCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isChinese(str.charAt(i))) {
                ccCount++;
            }
        }

        return ccCount;
    }

    public static String toBytesStringTag(String in, String tag) {
        byte[] bytes = in.getBytes();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(bytes[i]);
            sb.append(tag);
        }
        if (sb.length() > tag.length()) {
            sb.delete(sb.length() - tag.length(), sb.length());
        }
        return sb.toString();
    }

    public static String toString(byte[] bs) {
        return new String(bs);
    }
}
