package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.am.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class al {
    public static am nkh = null;

    public static String dA(String str, String str2) {
        String replace = Kq(str).replace("+", SQLiteDatabase.KeyEmpty);
        if (nkh == null) {
            nkh = new am();
        }
        int length;
        if (be.kS(str2)) {
            for (a aVar : nkh.nki) {
                if (replace.startsWith(aVar.nkk)) {
                    length = replace.length() - aVar.nkk.length();
                    if (length >= aVar.nkl && length <= aVar.nkm) {
                        v.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", aVar.nkk, aVar.nkj, Integer.valueOf(aVar.nkm), Integer.valueOf(aVar.nkm));
                        return aVar.nkk;
                    }
                }
            }
        } else {
            for (a aVar2 : nkh.nki) {
                if (replace.startsWith(aVar2.nkk)) {
                    length = replace.length() - aVar2.nkk.length();
                    if (length >= aVar2.nkl && length <= aVar2.nkm && str2.equalsIgnoreCase(aVar2.nkj)) {
                        v.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", aVar2.nkk, aVar2.nkj, Integer.valueOf(aVar2.nkm), Integer.valueOf(aVar2.nkm));
                        return aVar2.nkk;
                    }
                }
            }
        }
        return null;
    }

    public static String vl(String str) {
        return dA(str, null);
    }

    public static String Kp(String str) {
        if (be.kS(str) || !be.KT(str).booleanValue()) {
            return str;
        }
        al alVar = new al();
        String str2 = "86";
        if (str.startsWith("+")) {
            str = str.replace("+", SQLiteDatabase.KeyEmpty);
            str2 = dA(str, null);
            if (str2 != null) {
                str = str.substring(str2.length());
            }
        }
        return formatNumber(str2, str);
    }

    public static String Kq(String str) {
        if (be.kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        return str.replaceAll("[\\.\\-\\ ]", SQLiteDatabase.KeyEmpty).trim();
    }

    public static String formatNumber(String str, String str2) {
        if (be.kS(str) || be.kS(str2)) {
            return str2;
        }
        if (nkh == null) {
            nkh = new am();
        }
        for (a aVar : nkh.nki) {
            if (!(aVar.nkk == null || !str.trim().toLowerCase().equals(aVar.nkk.trim().toLowerCase()) || aVar.nkn == null)) {
                String Kq = Kq(str2);
                if (Kq != null && Kq.length() > aVar.nkl) {
                    return Kq;
                }
                for (b bVar : aVar.nkn) {
                    String W;
                    int i;
                    int i2;
                    char charAt;
                    StringBuffer stringBuffer;
                    int length;
                    if (be.kS(bVar.nko)) {
                        if (aVar.nkn.size() > 1) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(Kq);
                            int length2 = Kq.length();
                            if (length2 <= bG(bVar.nkq, aVar.nkm)) {
                                while (stringBuffer2.toString().length() < aVar.nkm) {
                                    stringBuffer2.append("0");
                                }
                                W = W(bVar.nkq, bVar.nkp, stringBuffer2.toString());
                                Kq = W;
                                i = 0;
                                for (i2 = 0; i2 < Kq.length(); i2++) {
                                    charAt = Kq.charAt(i2);
                                    if (i >= length2) {
                                        Kq = Kq.substring(0, i2);
                                    }
                                    if (!(charAt == ' ' || charAt == '-' || charAt == '。')) {
                                        i++;
                                    }
                                }
                                return Kq;
                            }
                        } else {
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(Kq);
                            length = Kq.length();
                            while (stringBuffer.toString().length() < aVar.nkm) {
                                stringBuffer.append("0");
                            }
                            String W2 = W(bVar.nkq, bVar.nkp, stringBuffer.toString());
                            i = 0;
                            for (int i3 = 0; i3 < W2.length(); i3++) {
                                charAt = W2.charAt(i3);
                                if (i >= length) {
                                    W2 = W2.substring(0, i3);
                                }
                                if (!(charAt == ' ' || charAt == '-' || charAt == '。')) {
                                    i++;
                                }
                            }
                            return W2;
                        }
                    } else if (Pattern.compile(bVar.nko).matcher(Kq).lookingAt()) {
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(Kq);
                        length = Kq.length();
                        while (stringBuffer.toString().length() < aVar.nkm) {
                            stringBuffer.append(Kq.charAt(length - 1));
                        }
                        W = W(bVar.nkq, bVar.nkp, stringBuffer.toString());
                        Kq = W;
                        i = 0;
                        for (i2 = 0; i2 < Kq.length(); i2++) {
                            charAt = Kq.charAt(i2);
                            if (i >= length) {
                                Kq = Kq.substring(0, i2);
                            }
                            if (!(charAt == ' ' || charAt == '-' || charAt == '。')) {
                                i++;
                            }
                        }
                        return Kq;
                    }
                }
                continue;
            }
        }
        return str2;
    }

    private static int bG(String str, int i) {
        Pattern compile = Pattern.compile(str);
        Object obj = "1";
        int i2 = 0;
        while (i2 < i && !compile.matcher(obj).find()) {
            obj = obj + "1";
            i2++;
        }
        return i2 + 1;
    }

    private static String W(String str, String str2, String str3) {
        Matcher matcher = Pattern.compile(str).matcher(str3);
        if (matcher.find()) {
            return matcher.replaceAll(str2);
        }
        return str3;
    }
}
