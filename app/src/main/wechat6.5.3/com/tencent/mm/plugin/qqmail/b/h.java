package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public abstract class h {
    protected static int dMN = 0;
    protected static String fWL = "weixin/android";
    protected static String host = "";
    protected static String iaH = "";

    public interface a {
        void aHu();
    }

    public static class b {
        int iaI;
        Map<String, String> iaJ;
        Map<String, String> iaK;
        d iaL;

        public b(int i, Map<String, String> map, Map<String, String> map2, d dVar) {
            this.iaI = i;
            this.iaJ = map;
            this.iaK = map2;
            this.iaL = dVar;
        }

        public final String toString() {
            return "Request method:" + this.iaI + ", params:" + (this.iaJ != null ? this.iaJ : "") + ", cookie:" + (this.iaK != null ? this.iaK : "");
        }
    }

    public static class c {
        String content;
        Map<String, String> iaK;
        int status = 0;

        public c(int i, Map<String, String> map, String str) {
            this.status = i;
            this.iaK = map;
            this.content = str;
        }

        public final String toString() {
            return "Response status:" + this.status + ", cookie:" + (this.iaK != null ? this.iaK : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
        }
    }

    public static class d {
        String bfh;
        String filePath;

        public d(String str, String str2) {
            this.bfh = str;
            this.filePath = str2;
        }
    }

    public abstract c a(String str, String str2, b bVar, a aVar);

    public abstract void cancel();

    public static void setHost(String str) {
        y.host = str;
    }

    public static void setUserAgent(String str) {
        y.fWL = str;
    }

    public static void xY(String str) {
        iaH = str;
    }

    protected static String b(String str, String str2, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(str2.startsWith("http://") || str2.startsWith("https://"))) {
            stringBuilder.append(str + host);
        }
        stringBuilder.append(str2);
        if (map == null) {
            return stringBuilder.toString();
        }
        stringBuilder.append('?');
        Object obj = 1;
        for (String str3 : map.keySet()) {
            stringBuilder.append(obj != null ? "" : "&").append(URLEncoder.encode(str3, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(be.ma((String) map.get(str3)), ProtocolPackage.ServerEncoding));
            obj = null;
        }
        return stringBuilder.toString();
    }

    protected static String y(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : map.keySet()) {
            stringBuilder.append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode((String) map.get(str), ProtocolPackage.ServerEncoding));
            int i2 = i + 1;
            if (map.size() > i2) {
                stringBuilder.append("; ");
            }
            i = i2;
        }
        return stringBuilder.toString();
    }

    protected static Map<String, String> xZ(String str) {
        Map<String, String> hashMap = new HashMap();
        if (!(str == null || str.length() == 0)) {
            for (String split : str.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }
}
