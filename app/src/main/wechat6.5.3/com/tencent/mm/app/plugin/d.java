package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mm.pluginsdk.j.m;
import com.tencent.mm.pluginsdk.ui.applet.h;
import com.tencent.mm.pluginsdk.ui.d.a;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class d implements m {
    public final String q(Context context, String str) {
        Object aS = a.aS(context, str);
        if (aS.size() != 0) {
            Collections.sort(aS, new Comparator<h>(this) {
                final /* synthetic */ d aSm;

                {
                    this.aSm = r1;
                }

                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    h hVar = (h) obj2;
                    int i = ((h) obj).start;
                    int i2 = hVar.start;
                    if (i < i2) {
                        return -1;
                    }
                    return i > i2 ? 1 : 0;
                }
            });
            Iterator it = aS.iterator();
            String str2 = str;
            while (it.hasNext()) {
                String format;
                h hVar = (h) it.next();
                String str3 = null;
                int i = hVar.start;
                int i2 = hVar.end;
                switch (hVar.type) {
                    case 1:
                        str3 = "<a href=\"%s\">%s</a>";
                        break;
                    case 24:
                        str3 = "<a href=\"%s@mailto@\">%s</a>";
                        break;
                    case 25:
                        str3 = "<a href=\"%s@tel@\">%s</a>";
                        break;
                }
                if (str3 != null) {
                    String str4 = hVar.url;
                    if (hVar.type != 1 || str4.startsWith("http://")) {
                        format = String.format(str3, new Object[]{str4.trim(), str4.trim()});
                    } else {
                        format = String.format(str3, new Object[]{"http://" + str4.trim(), str4.trim()});
                    }
                    format = a(str2, i, i2, format);
                    if (format.length() == 0) {
                        v.d("MicroMsg.QrCodeURLHelper", "formatQRString, result:%s", str);
                    }
                } else {
                    format = str2;
                }
                str2 = format;
            }
            str = str2;
            v.d("MicroMsg.QrCodeURLHelper", "formatQRString, result:%s", str);
        }
        return str;
    }

    private static String a(String str, int i, int i2, String str2) {
        if (be.kS(str) || be.kS(str2) || i >= i2) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(str.subSequence(0, i + 0));
            stringBuilder.append(str2);
            stringBuilder.append(str.subSequence(i2 + 0, str.length()));
            str2.length();
            return stringBuilder.toString();
        } catch (Exception e) {
            v.e("MicroMsg.QrCodeURLHelper", e.getMessage());
            return SQLiteDatabase.KeyEmpty;
        }
    }

    public final boolean a(Context context, String str, OnDismissListener onDismissListener) {
        v.d("MicroMsg.QrCodeURLHelper", "tryHandleEvents, url:%s", str);
        if (be.kS(str)) {
            return false;
        }
        if (str.endsWith("@mailto@")) {
            g.b(context, str.substring(0, str.length() - 8), onDismissListener);
        } else if (!str.endsWith("@tel@")) {
            return false;
        } else {
            String substring = str.substring(0, str.length() - 5);
            Bundle bundle = new Bundle();
            bundle.putInt("fromScene", 3);
            g.a(context, substring, onDismissListener, bundle);
        }
        return true;
    }

    public final boolean bv(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (str.endsWith("@mailto@") || str.endsWith("@tel@")) {
            return true;
        }
        return false;
    }
}
