package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    public static final Pattern jqf = Pattern.compile("\\{([\\s\\S]*?)\\}");
    public static String[] jqg = new String[]{"{sex", "{username", "{richtext"};
    public static HashMap<String, a> jqh = new HashMap();

    enum a {
        OK,
        FAIL
    }

    public static String a(a aVar) {
        if (!jqh.containsKey(aVar.jqb)) {
            Object obj = aVar.jqb;
            if (be.kS(obj)) {
                return aVar.jqa;
            }
            Object obj2;
            do {
                Matcher matcher = jqf.matcher(obj);
                if (matcher.find()) {
                    int groupCount = matcher.groupCount();
                    Object group = matcher.group();
                    v.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + groupCount + " " + group);
                    obj = obj.replace(group, "");
                    for (String indexOf : jqg) {
                        if (group.indexOf(indexOf) >= 0) {
                            obj2 = 1;
                            continue;
                            break;
                        }
                    }
                    obj2 = null;
                    continue;
                } else {
                    jqh.put(aVar.jqb, a.OK);
                    return aVar.jqb;
                }
            } while (obj2 != null);
            jqh.put(aVar.jqb, a.FAIL);
            return aVar.jqa;
        } else if (((a) jqh.get(aVar.jqb)) == a.OK) {
            return aVar.jqb;
        } else {
            return aVar.jqa;
        }
    }
}
