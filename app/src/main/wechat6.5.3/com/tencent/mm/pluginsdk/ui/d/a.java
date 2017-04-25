package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import com.tencent.mm.pluginsdk.ui.applet.h;
import com.tencent.mm.sdk.platformtools.aa;
import java.util.ArrayList;
import java.util.regex.Matcher;

public final class a {
    public static ArrayList<h> aS(Context context, String str) {
        ArrayList<h> arrayList = new ArrayList();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.d.a.lQK.matcher(str);
        while (matcher.find()) {
            h a = a(context, matcher.group(), matcher.start(), matcher.end());
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public static h a(Context context, String str, int i, int i2) {
        return a(context, str, i, i2, 0, 0);
    }

    public static h a(Context context, String str, int i, int i2, int i3, int i4) {
        if (context == null) {
            context = aa.getContext();
        }
        h r = com.tencent.mm.pluginsdk.j.a.lxW.r(context, str);
        if (r != null) {
            r.start = i;
            r.end = i2;
            r.linkColor = i3;
            r.backgroundColor = i4;
        }
        return r;
    }
}
