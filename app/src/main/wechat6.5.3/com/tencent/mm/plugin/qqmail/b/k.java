package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class k {
    String bhM = null;
    private String[] iaY = null;
    private String[] iaZ = null;
    String iav = null;
    private String[] iba = null;
    String ibb = null;
    a[] ibc = null;
    a[] ibd = null;

    public static class a {
        String aST;
        int fileSize;
        String ibe;
        String name;
    }

    public k(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2) {
        if (!be.kS(str)) {
            this.bhM = str;
        }
        if (strArr == null || strArr.length <= 0) {
            this.iaY = null;
        } else {
            this.iaY = strArr;
        }
        if (strArr2 == null || strArr2.length <= 0) {
            this.iaZ = null;
        } else {
            this.iaZ = strArr2;
        }
        if (strArr3 == null || strArr3.length <= 0) {
            this.iba = null;
        } else {
            this.iba = strArr3;
        }
        if (be.kS(str2)) {
            this.iav = null;
        } else {
            this.iav = str2;
        }
    }

    final String aHw() {
        if (this.iaY == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("To: ");
        for (String str : this.iaY) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    final String aHx() {
        if (this.iaZ == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Cc: ");
        for (String str : this.iaZ) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    final String aHy() {
        if (this.iba == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Bcc: ");
        for (String str : this.iaZ) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    public static String yc(String str) {
        String m;
        String str2 = null;
        String str3 = "abEdf4&^^*sxcSD$%&1sdfz@!~AZcT4s322dA%^&&*$##C$%__SDy4d_(*%";
        int length = str3.length();
        try {
            m = g.m((str + "d$3^&xRw%&*_(").getBytes());
        } catch (Throwable e) {
            v.a("MicroMsg.MailContentFormatter", e, "", new Object[0]);
            v.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + e.getLocalizedMessage());
            m = str2;
        }
        char[] cArr = new char[(m.length() * 2)];
        int i = 0;
        for (int i2 = 0; i2 < m.length(); i2++) {
            int i3 = i + 1;
            cArr[i] = m.charAt(i2);
            char charAt = m.charAt(i2);
            i = i3 + 1;
            cArr[i3] = (char) (str3.charAt(charAt % length) + m.charAt(i2));
        }
        try {
            str2 = g.m(new String(cArr).getBytes("ISO-8859-1"));
        } catch (Throwable e2) {
            v.a("MicroMsg.MailContentFormatter", e2, "", new Object[0]);
            v.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + e2.getLocalizedMessage());
        }
        return str2;
    }
}
