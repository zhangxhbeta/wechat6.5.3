package com.tencent.mm.sdk.platformtools;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class bf {
    private static ThreadLocal<XmlPullParser> nlT = new ThreadLocal();

    private static class a {
        private XmlPullParser nlU;
        private String nlV;
        private StringBuilder nlW = new StringBuilder();
        private Map<String, String> nlX;
        private Map<Integer, Integer> nlY;

        public a(String str, String str2) {
            this.nlV = str2;
            XmlPullParser xmlPullParser = (XmlPullParser) bf.nlT.get();
            this.nlU = xmlPullParser;
            if (xmlPullParser == null) {
                ThreadLocal buy = bf.nlT;
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                this.nlU = newPullParser;
                buy.set(newPullParser);
            }
            this.nlU.setInput(new StringReader(str));
            this.nlY = new HashMap();
            this.nlX = new HashMap();
        }

        public final Map<String, String> buz() {
            int eventType = this.nlU.getEventType();
            while (eventType != 1) {
                int next = this.nlU.next();
                String str;
                if (next == 2) {
                    this.nlW.append('.').append(this.nlU.getName());
                    String stringBuilder = this.nlW.toString();
                    int hashCode = stringBuilder.hashCode();
                    Integer num = (Integer) this.nlY.get(Integer.valueOf(hashCode));
                    if (num != null) {
                        num = Integer.valueOf(num.intValue() + 1);
                        this.nlW.append(num);
                        this.nlY.put(Integer.valueOf(hashCode), num);
                        str = stringBuilder + num;
                    } else {
                        this.nlY.put(Integer.valueOf(hashCode), Integer.valueOf(0));
                        str = stringBuilder;
                    }
                    this.nlX.put(str, SQLiteDatabase.KeyEmpty);
                    for (int i = 0; i < this.nlU.getAttributeCount(); i++) {
                        this.nlX.put(str + ".$" + this.nlU.getAttributeName(i), this.nlU.getAttributeValue(i));
                    }
                    eventType = next;
                } else if (next == 4) {
                    str = this.nlU.getText();
                    if (str != null) {
                        this.nlX.put(this.nlW.toString(), str);
                    }
                    eventType = next;
                } else {
                    if (next == 3) {
                        this.nlW = this.nlW.delete(this.nlW.lastIndexOf("."), this.nlW.length());
                        if (this.nlW.length() == 0) {
                            break;
                        }
                    }
                    eventType = next;
                }
            }
            return this.nlX;
        }
    }

    public static Map<String, String> q(String str, String str2) {
        Map<String, String> map = null;
        int indexOf = str == null ? -1 : str.indexOf("<" + str2);
        if (indexOf < 0) {
            v.e("MicroMsg.SDK.XmlParser", "can not find the tag <%s>", str2);
        } else {
            if (indexOf > 0) {
                str = str.substring(indexOf);
            }
            try {
                map = new a(str, str2).buz();
            } catch (Throwable e) {
                v.a("MicroMsg.SDK.XmlParser", e, "[ %s ]", str);
            }
        }
        return map;
    }
}
