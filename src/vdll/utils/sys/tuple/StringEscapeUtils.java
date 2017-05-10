package vdll.utils.sys.tuple;

/**
 * Created by Hocean on 2017/3/27.
 */

public class StringEscapeUtils {

    public static final CharSequenceTranslator ESCAPE_HTML4 =
            new AggregateTranslator(
                    new LookupTranslator(EntityArrays.BASIC_ESCAPE()),
                    new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE()),
                    new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE())
            );
    public static final CharSequenceTranslator UNESCAPE_HTML4 =
            new AggregateTranslator(
                    new LookupTranslator(EntityArrays.BASIC_UNESCAPE()),
                    new LookupTranslator(EntityArrays.ISO8859_1_UNESCAPE()),
                    new LookupTranslator(EntityArrays.HTML40_EXTENDED_UNESCAPE()),
                    new NumericEntityUnescaper()
            );

    public static final String escapeHtml4(final String input) {
        return ESCAPE_HTML4.translate(input);
    }

    public static final String unescapeHtml4(final String input) {
        return UNESCAPE_HTML4.translate(input);
    }

}
