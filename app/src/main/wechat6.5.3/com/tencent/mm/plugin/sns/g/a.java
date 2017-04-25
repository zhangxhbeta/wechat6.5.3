package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.protocal.c.abp;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.protocal.c.de;
import com.tencent.mm.protocal.c.df;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    private static int AW(String str) {
        int i = 0;
        try {
            i = be.getInt(str, 0);
        } catch (Exception e) {
            v.e("MicroMsg.AlbumBgHelper", "parserInt error " + str);
        }
        return i;
    }

    private static float km(String str) {
        float f = 0.0f;
        if (str != null) {
            try {
                f = be.getFloat(str, 0.0f);
            } catch (Exception e) {
                v.e("MicroMsg.AlbumBgHelper", "parseFloat error " + str);
            }
        }
        return f;
    }

    private static String kn(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static bw AX(String str) {
        Map q = bf.q(str, "albumList");
        bw bwVar = new bw();
        if (q == null) {
            return bwVar;
        }
        bwVar.glC = kn((String) q.get(".albumList.$lang"));
        de deVar = new de();
        deVar.gkB = kn((String) q.get(".albumList.album.author.name"));
        deVar.aXz = kn((String) q.get(".albumList.album.author.title"));
        deVar.mdJ = kn((String) q.get(".albumList.album.author.description"));
        deVar.mdI = kn((String) q.get(".albumList.album.author.quote"));
        df dfVar = new df();
        aid l = l(q, ".albumList.album.author.icon.media");
        String str2 = (String) q.get(".albumList.album.author.icon.media.id");
        String str3 = (String) q.get(".albumList.album.author.icon.media.type");
        String str4 = (String) q.get(".albumList.album.author.icon.media.title");
        String str5 = (String) q.get(".albumList.album.author.icon.media.desc");
        String str6 = (String) q.get(".albumList.album.author.icon.media.url");
        String str7 = (String) q.get(".albumList.album.author.icon.media.private");
        String str8 = (String) q.get(".albumList.album.author.icon.media.thumb");
        String str9 = (String) q.get(".albumList.album.author.icon.media.url.$type");
        String str10 = (String) q.get(".albumList.album.author.icon.media.thumb.$type");
        aib com_tencent_mm_protocal_c_aib = new aib();
        com_tencent_mm_protocal_c_aib.gID = kn(str2);
        com_tencent_mm_protocal_c_aib.efm = AW(str3);
        com_tencent_mm_protocal_c_aib.aXz = kn(str4);
        com_tencent_mm_protocal_c_aib.gkC = kn(str5);
        com_tencent_mm_protocal_c_aib.glb = kn(str6);
        com_tencent_mm_protocal_c_aib.mHO = AW(str9);
        com_tencent_mm_protocal_c_aib.mHP = kn(str8);
        com_tencent_mm_protocal_c_aib.mHQ = AW(str10);
        com_tencent_mm_protocal_c_aib.mHR = AW(str7);
        com_tencent_mm_protocal_c_aib.mHS = l;
        dfVar.mdL = com_tencent_mm_protocal_c_aib;
        deVar.mdK = dfVar;
        bwVar.mcr = deVar;
        int i = 0;
        while (true) {
            Object obj;
            abp com_tencent_mm_protocal_c_abp = new abp();
            if (i == 0) {
                obj = ".albumList.album.groupList.group.name";
                str4 = ".albumList.album.groupList.group.mediaList";
            } else {
                str4 = ".albumList.album.groupList.group" + i + ".name";
                String str11 = ".albumList.album.groupList.group" + i + ".mediaList";
                str2 = str4;
                str4 = str11;
            }
            str2 = (String) q.get(obj);
            if (str2 == null) {
                return bwVar;
            }
            com_tencent_mm_protocal_c_abp.gkB = kn(str2);
            com_tencent_mm_protocal_c_abp.mom = m(q, str4);
            bwVar.mcs.add(com_tencent_mm_protocal_c_abp);
            i++;
        }
    }

    private static aid l(Map<String, String> map, String str) {
        String str2 = str + ".size.$width";
        String str3 = str + ".size.$height";
        str2 = (String) map.get(str2);
        str3 = (String) map.get(str3);
        String str4 = (String) map.get(str + ".size.$totalSize");
        aid com_tencent_mm_protocal_c_aid = new aid();
        com_tencent_mm_protocal_c_aid.lHK = 0.0f;
        com_tencent_mm_protocal_c_aid.mID = 0.0f;
        com_tencent_mm_protocal_c_aid.mIE = 0.0f;
        if (str2 != null) {
            com_tencent_mm_protocal_c_aid.mID = km(str2);
        }
        if (str3 != null) {
            com_tencent_mm_protocal_c_aid.lHK = km(str3);
        }
        if (str4 != null) {
            com_tencent_mm_protocal_c_aid.mIE = km(str4);
        }
        return com_tencent_mm_protocal_c_aid;
    }

    private static LinkedList<aib> m(Map<String, String> map, String str) {
        LinkedList<aib> linkedList = new LinkedList();
        int i = 0;
        while (true) {
            Object obj;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            if (i != 0) {
                obj = str + ".media" + i + ".id";
                str2 = str + ".media" + i + ".type";
                str3 = str + ".media" + i + ".title";
                str4 = str + ".media" + i + ".desc";
                str5 = str + ".media" + i + ".url";
                str6 = str + ".media" + i + ".thumb";
                str7 = str + ".media" + i + ".url.$type";
                str8 = str + ".media" + i + ".thumb.$type";
                str9 = str + ".media" + i + ".private";
                str10 = str + ".media" + i;
                str11 = str9;
                Object obj2 = str2;
                Object obj3 = str8;
                Object obj4 = str3;
                Object obj5 = str7;
                Object obj6 = str4;
                Object obj7 = str6;
                Object obj8 = str5;
                Object obj9 = str11;
            } else {
                obj = str + ".media.id";
                str2 = str + ".media.type";
                str3 = str + ".media.title";
                str4 = str + ".media.desc";
                str5 = str + ".media.url";
                str6 = str + ".media.thumb";
                str7 = str + ".media.url.$type";
                str8 = str + ".media.thumb.$type";
                str9 = str + ".media.private";
                str10 = str + ".media";
                str11 = str9;
                str9 = str2;
                str2 = str8;
                str8 = str3;
                str3 = str7;
                str7 = str4;
                str4 = str6;
                str6 = str5;
                str5 = str11;
            }
            if (obj != null && obj2 != null) {
                aid l = l(map, str10);
                str10 = (String) map.get(obj);
                str9 = (String) map.get(obj2);
                str8 = (String) map.get(obj4);
                str7 = (String) map.get(obj6);
                str6 = (String) map.get(obj8);
                str5 = (String) map.get(obj9);
                str4 = (String) map.get(obj7);
                str3 = (String) map.get(obj5);
                str2 = (String) map.get(obj3);
                if (str10 == null || str9 == null) {
                    break;
                }
                aib com_tencent_mm_protocal_c_aib = new aib();
                com_tencent_mm_protocal_c_aib.gID = kn(str10);
                com_tencent_mm_protocal_c_aib.efm = AW(str9);
                com_tencent_mm_protocal_c_aib.aXz = kn(str8);
                com_tencent_mm_protocal_c_aib.gkC = kn(str7);
                com_tencent_mm_protocal_c_aib.glb = kn(str6);
                com_tencent_mm_protocal_c_aib.mHO = AW(str3);
                com_tencent_mm_protocal_c_aib.mHP = kn(str4);
                com_tencent_mm_protocal_c_aib.mHQ = AW(str2);
                com_tencent_mm_protocal_c_aib.mHR = AW(str5);
                com_tencent_mm_protocal_c_aib.mHS = l;
                linkedList.add(com_tencent_mm_protocal_c_aib);
                i++;
            } else {
                break;
            }
        }
        return linkedList;
    }
}
