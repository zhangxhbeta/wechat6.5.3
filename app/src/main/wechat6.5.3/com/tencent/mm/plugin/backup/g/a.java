package com.tencent.mm.plugin.backup.g;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.q.c;
import com.tencent.mm.q.d;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    public static String ehY = "]]>";
    public static String ehZ = "<msg>";
    public static String eia = "</msg>";

    static class a {
        Map<String, String> eib = null;
        boolean eic = true;

        public a(String str) {
            this.eib = au.Ks(str);
            if (this.eib == null) {
                this.eic = false;
                this.eib = new HashMap();
            }
        }

        final int getInt(String str) {
            if (this.eib.containsKey(str)) {
                return be.getInt((String) this.eib.get(str), 0);
            }
            return 0;
        }
    }

    static class b {
        StringBuffer eid = new StringBuffer();

        b() {
        }

        public final void oT(String str) {
            this.eid.append("<" + str + ">");
        }

        public final void oU(String str) {
            this.eid.append("</" + str + ">");
        }

        public final void aY(String str, String str2) {
            oT(str);
            if (!be.kS(str2)) {
                if (str2.contains(a.ehY)) {
                    this.eid.append("<![CDATA[" + be.KJ(str2) + "]]>");
                } else {
                    this.eid.append("<![CDATA[" + str2 + "]]>");
                }
            }
            oU(str);
        }

        public final void af(String str, int i) {
            oT(str);
            this.eid.append(i);
            oU(str);
        }

        public final void e(String str, Map<String, String> map) {
            this.eid.append("<" + str);
            for (String str2 : map.keySet()) {
                this.eid.append(" " + str2 + " =  \"" + ((String) map.get(str2)) + "\" ");
            }
            this.eid.append(">");
            map.clear();
        }
    }

    public static String oS(String str) {
        int i = 0;
        c dZ = com.tencent.mm.q.a.a.dZ(str);
        a aVar = new a(str);
        if (aVar.eic) {
            String str2;
            String str3;
            String str4;
            b bVar = new b();
            List list = dZ.cqE;
            Map hashMap = new HashMap();
            bVar.oT("msg");
            hashMap.put("appid", (String) aVar.eib.get(".msg.appmsg.$appid"));
            hashMap.put("sdkver", (String) aVar.eib.get(".msg.appmsg.$sdkver"));
            bVar.e("appmsg", hashMap);
            if (list == null || list.size() == 0) {
                str2 = SQLiteDatabase.KeyEmpty;
                str3 = SQLiteDatabase.KeyEmpty;
                str4 = SQLiteDatabase.KeyEmpty;
            } else {
                str3 = ((d) list.get(0)).title;
                str4 = ((d) list.get(0)).url;
                str2 = ((d) list.get(0)).cqI;
                str2 = str3;
                str3 = str4;
                str4 = ((d) list.get(0)).cqK;
            }
            bVar.aY(SlookSmartClipMetaTag.TAG_TYPE_TITLE, str2);
            bVar.aY("des", (String) aVar.eib.get(".msg.appmsg.des"));
            bVar.aY("action", (String) aVar.eib.get(".msg.appmsg.action"));
            bVar.af("type", aVar.getInt(".msg.appmsg.type"));
            bVar.af("showtype", aVar.getInt(".msg.appmsg.showtype"));
            bVar.aY("content", (String) aVar.eib.get(".msg.appmsg.content"));
            bVar.aY(SlookSmartClipMetaTag.TAG_TYPE_URL, str3);
            bVar.aY("lowurl", (String) aVar.eib.get(".msg.appmsg.lowurl"));
            bVar.oT("appattach");
            bVar.af("totallen", aVar.getInt(".msg.appmsg.appattach.totallen"));
            bVar.aY("attachid", (String) aVar.eib.get(".msg.appmsg.appattach.attachid"));
            bVar.aY("fileext", (String) aVar.eib.get(".msg.appmsg.appattach.fileext"));
            bVar.oU("appattach");
            bVar.oT("mmreader");
            hashMap.put("type", dZ.type);
            hashMap.put("count", (list == null ? 0 : list.size()));
            bVar.e("category", hashMap);
            bVar.aY("name", dZ.bnS);
            bVar.oT("topnew");
            bVar.aY("cover", (String) aVar.eib.get(".msg.appmsg.mmreader.category.topnew.cover"));
            bVar.aY("width", (String) aVar.eib.get(".msg.appmsg.mmreader.category.topnew.width"));
            bVar.aY("height", (String) aVar.eib.get(".msg.appmsg.mmreader.category.topnew.height"));
            bVar.aY("digest", str4);
            bVar.oU("topnew");
            while (i < list.size()) {
                bVar.oT("item");
                str4 = ((d) list.get(i)).title;
                str3 = ((d) list.get(i)).url;
                String str5 = ((d) list.get(i)).cqG;
                String str6 = ((d) list.get(i)).cqH;
                String str7 = ((d) list.get(i)).time;
                String str8 = ((d) list.get(i)).cqI;
                String str9 = ((d) list.get(i)).cqJ;
                str2 = ((d) list.get(i)).cqK;
                bVar.aY(SlookSmartClipMetaTag.TAG_TYPE_TITLE, str4);
                bVar.aY(SlookSmartClipMetaTag.TAG_TYPE_URL, str3);
                bVar.aY("shorturl", str5);
                bVar.aY("longurl", str6);
                bVar.aY("pub_time", str7);
                bVar.aY("cover", str8);
                bVar.aY("tweetid", str9);
                bVar.aY("digest", str2);
                bVar.aY("fileid", (String) aVar.eib.get((".msg.appmsg.mmreader.category.item" + (i == 0 ? SQLiteDatabase.KeyEmpty : String.valueOf(i))) + ".fileid"));
                bVar.oT("source");
                bVar.oT("source");
                bVar.aY("name", dZ.bnS);
                bVar.oU("source");
                bVar.oU("source");
                bVar.oU("item");
                i++;
            }
            bVar.oU("category");
            bVar.oT("publisher");
            bVar.aY("username", dZ.bnR);
            bVar.aY("nickname", dZ.bnS);
            bVar.oU("publisher");
            bVar.oU("mmreader");
            bVar.oU("appmsg");
            bVar.aY("fromusername", dZ.bnR);
            bVar.af("scene", aVar.getInt(".msg.scene"));
            bVar.oT("appinfo");
            bVar.aY("version", (String) aVar.eib.get(".msg.appinfo.appname"));
            bVar.aY("appname", (String) aVar.eib.get(".msg.appinfo.version"));
            bVar.oU("appinfo");
            bVar.aY("commenturl", dZ.bNm);
            bVar.oU("msg");
            v.d("MicroMsg.AppmsgConvert", "xml " + bVar.eid.toString());
            return bVar.eid.toString();
        }
        v.e("MicroMsg.AppmsgConvert", "buffer error");
        return SQLiteDatabase.KeyEmpty;
    }
}
