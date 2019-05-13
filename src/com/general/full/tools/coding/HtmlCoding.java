package com.general.full.tools.coding;

import org.apache.commons.text.StringEscapeUtils;

public class HtmlCoding {
    /**
     *
     * **/
    public static String enHtml(String string)
    {
        return StringEscapeUtils.escapeHtml4(string);
    }

    /**
     *
     * **/
    public static String deHtml(String string)
    {
        return StringEscapeUtils.unescapeHtml4(string);
    }
}
