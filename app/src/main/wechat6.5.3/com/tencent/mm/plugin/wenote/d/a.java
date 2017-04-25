package com.tencent.mm.plugin.wenote.d;

import com.tencent.mm.sdk.platformtools.be;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class a {
    public static ArrayList<String> FW(String str) {
        if (be.kS(str) || str.length() == 0) {
            return null;
        }
        String replaceAll = Pattern.compile("<object[^>]*>", 2).matcher(str).replaceAll("#WNNoteNode#[ThisisNoteNodeObj]#WNNoteNode#");
        if (!(be.kS(replaceAll) || replaceAll.length() == 0)) {
            replaceAll = Pattern.compile("&nbsp;", 2).matcher(Pattern.compile("<[^>]*>", 2).matcher(Pattern.compile("</p>", 2).matcher(Pattern.compile("<p [^>]*>", 2).matcher(Pattern.compile("<div>", 2).matcher(Pattern.compile("<br[^>]*>", 2).matcher(replaceAll).replaceAll("\n")).replaceAll("\n")).replaceAll("\n")).replaceAll("\n")).replaceAll("")).replaceAll(" ");
        }
        String[] split = replaceAll.split("#WNNoteNode#");
        ArrayList<String> arrayList = new ArrayList();
        for (Object add : split) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
