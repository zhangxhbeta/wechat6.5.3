package com.tencent.mm.plugin.sns.g;

import android.util.Base64;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.axx;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class j {
    public static String ehY = "]]>";
    public static String ehZ = "<TimelineObject>";
    public static String eia = "</TimelineObject>";

    static class a {
        StringBuffer eid = new StringBuffer();

        a() {
        }

        public final void oT(String str) {
            this.eid.append("<" + str + ">");
        }

        public final void oU(String str) {
            this.eid.append("</" + str + ">");
        }

        public final void setText(String str) {
            if (!be.kS(str)) {
                if (str.contains(j.ehY)) {
                    this.eid.append("<![CDATA[" + be.KJ(str) + "]]>");
                } else {
                    this.eid.append("<![CDATA[" + str + "]]>");
                }
            }
        }

        public final void qq(int i) {
            this.eid.append(i);
        }

        public final void e(String str, Map<String, String> map) {
            this.eid.append("<" + str);
            for (String str2 : map.keySet()) {
                this.eid.append(" " + str2 + "=\"" + ((String) map.get(str2)) + "\" ");
            }
            this.eid.append(">");
            map.clear();
        }
    }

    private static String AY(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private static String AZ(String str) {
        if (be.kS(str)) {
            return "";
        }
        return (str.matches("\\d*") ? 1 : null) == null ? "" : str;
    }

    public static String a(azr com_tencent_mm_protocal_c_azr) {
        String replace;
        a aVar = new a();
        Map hashMap = new HashMap();
        aVar.oT("TimelineObject");
        aVar.oT("id");
        if (com_tencent_mm_protocal_c_azr.gID == null || com_tencent_mm_protocal_c_azr.gID.equals("")) {
            aVar.setText("0");
        } else {
            aVar.setText(com_tencent_mm_protocal_c_azr.gID);
        }
        aVar.oU("id");
        if (com_tencent_mm_protocal_c_azr.gln != null) {
            aVar.oT("username");
            aVar.setText(com_tencent_mm_protocal_c_azr.gln);
            aVar.oU("username");
        }
        aVar.oT("createTime");
        aVar.setText(com_tencent_mm_protocal_c_azr.hNS);
        aVar.oU("createTime");
        aVar.oT("contentDescShowType");
        aVar.qq(com_tencent_mm_protocal_c_azr.mWs);
        aVar.oU("contentDescShowType");
        aVar.oT("contentDescScene");
        aVar.qq(com_tencent_mm_protocal_c_azr.mWt);
        aVar.oU("contentDescScene");
        aVar.oT("private");
        aVar.setText(com_tencent_mm_protocal_c_azr.mHR);
        aVar.oU("private");
        if (!(com_tencent_mm_protocal_c_azr.mWp == null || be.kS(com_tencent_mm_protocal_c_azr.mWp.gID))) {
            aVar.oT("appInfo");
            aVar.oT("id");
            aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWp.gID));
            aVar.oU("id");
            aVar.oT("version");
            aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWp.efc));
            aVar.oU("version");
            aVar.oT("appName");
            aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWp.hNZ));
            aVar.oU("appName");
            aVar.oT("installUrl");
            aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWp.mcF));
            aVar.oU("installUrl");
            aVar.oT("fromUrl");
            aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWp.mcG));
            aVar.oU("fromUrl");
            aVar.oU("appInfo");
        }
        if (!(com_tencent_mm_protocal_c_azr.mWv == null || be.kS(com_tencent_mm_protocal_c_azr.mWv.cqg))) {
            aVar.oT("streamvideo");
            aVar.oT("streamvideourl");
            aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWv.cqg));
            aVar.oU("streamvideourl");
            aVar.oT("streamvideototaltime");
            aVar.qq(com_tencent_mm_protocal_c_azr.mWv.cqh);
            aVar.oU("streamvideototaltime");
            aVar.oT("streamvideotitle");
            aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWv.cqi));
            aVar.oU("streamvideotitle");
            aVar.oT("streamvideowording");
            aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWv.cqj));
            aVar.oU("streamvideowording");
            aVar.oT("streamvideoweburl");
            aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWv.cqk));
            aVar.oU("streamvideoweburl");
            aVar.oT("streamvideothumburl");
            aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWv.cql));
            aVar.oU("streamvideothumburl");
            aVar.oT("streamvideoaduxinfo");
            aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWv.cqm));
            aVar.oU("streamvideoaduxinfo");
            aVar.oT("streamvideopublishid");
            aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWv.cqn));
            aVar.oU("streamvideopublishid");
            aVar.oU("streamvideo");
        }
        aVar.oT("contentDesc");
        aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWn));
        aVar.oU("contentDesc");
        aVar.oT("contentattr");
        aVar.setText(com_tencent_mm_protocal_c_azr.cog);
        aVar.oU("contentattr");
        aVar.oT("sourceUserName");
        aVar.setText(AY(com_tencent_mm_protocal_c_azr.lJi));
        aVar.oU("sourceUserName");
        aVar.oT("sourceNickName");
        aVar.setText(AY(com_tencent_mm_protocal_c_azr.lJj));
        aVar.oU("sourceNickName");
        aVar.oT("statisticsData");
        aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWu));
        aVar.oU("statisticsData");
        aVar.oT("weappInfo");
        aVar.oT("appUserName");
        aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWw.username));
        aVar.oU("appUserName");
        aVar.oT("pagePath");
        aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWw.path));
        aVar.oU("pagePath");
        aVar.oU("weappInfo");
        aVar.oT("canvasInfoXml");
        aVar.setText(AY(com_tencent_mm_protocal_c_azr.jYp));
        aVar.oU("canvasInfoXml");
        if (com_tencent_mm_protocal_c_azr.mWo != null) {
            float f = com_tencent_mm_protocal_c_azr.mWo.mjM;
            float f2 = com_tencent_mm_protocal_c_azr.mWo.mjN;
            if (!(f == -1000.0f || f2 == -1000.0f)) {
                hashMap.clear();
                hashMap.put("longitude", com_tencent_mm_protocal_c_azr.mWo.mjM);
                hashMap.put("latitude", com_tencent_mm_protocal_c_azr.mWo.mjN);
                hashMap.put("city", be.KJ(AY(com_tencent_mm_protocal_c_azr.mWo.cHe)));
                hashMap.put("poiName", be.KJ(AY(com_tencent_mm_protocal_c_azr.mWo.gUr)));
                hashMap.put("poiAddress", be.KJ(AY(com_tencent_mm_protocal_c_azr.mWo.jGR)));
                hashMap.put("poiScale", com_tencent_mm_protocal_c_azr.mWo.mGk);
                hashMap.put("poiClassifyId", AY(com_tencent_mm_protocal_c_azr.mWo.mGi));
                hashMap.put("poiClassifyType", com_tencent_mm_protocal_c_azr.mWo.jGT);
                hashMap.put("poiClickableStatus", com_tencent_mm_protocal_c_azr.mWo.mGl);
                aVar.e("location", hashMap);
                aVar.oU("location");
            }
        }
        aVar.oT("ContentObject");
        aVar.oT("contentStyle");
        aVar.setText(com_tencent_mm_protocal_c_azr.mWq.mol);
        aVar.oU("contentStyle");
        aVar.oT("title");
        aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWq.aXz));
        aVar.oU("title");
        aVar.oT("description");
        aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWq.gkC));
        aVar.oU("description");
        aVar.oT("contentUrl");
        aVar.setText(AY(com_tencent_mm_protocal_c_azr.mWq.glb));
        aVar.oU("contentUrl");
        if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
            aVar.oT("mediaList");
            Iterator it = com_tencent_mm_protocal_c_azr.mWq.mom.iterator();
            while (it.hasNext()) {
                aib com_tencent_mm_protocal_c_aib = (aib) it.next();
                aVar.oT("media");
                aVar.oT("id");
                if (AZ(com_tencent_mm_protocal_c_aib.gID).equals("")) {
                    aVar.setText("0");
                } else {
                    aVar.setText(AZ(com_tencent_mm_protocal_c_aib.gID));
                }
                aVar.oU("id");
                aVar.oT(Columns.TYPE);
                aVar.setText(com_tencent_mm_protocal_c_aib.efm);
                aVar.oU(Columns.TYPE);
                aVar.oT("title");
                aVar.setText(AY(com_tencent_mm_protocal_c_aib.aXz));
                aVar.oU("title");
                aVar.oT("description");
                aVar.setText(AY(com_tencent_mm_protocal_c_aib.gkC));
                aVar.oU("description");
                aVar.oT("private");
                aVar.setText(com_tencent_mm_protocal_c_aib.mHR);
                aVar.oU("private");
                hashMap.clear();
                hashMap.put(Columns.TYPE, com_tencent_mm_protocal_c_aib.mHO);
                if (!be.kS(com_tencent_mm_protocal_c_aib.aZy)) {
                    hashMap.put("md5", com_tencent_mm_protocal_c_aib.aZy);
                }
                if (!be.kS(com_tencent_mm_protocal_c_aib.mIk)) {
                    hashMap.put("videomd5", com_tencent_mm_protocal_c_aib.mIk);
                }
                aVar.e("url", hashMap);
                aVar.setText(AY(com_tencent_mm_protocal_c_aib.glb));
                aVar.oU("url");
                if (!(com_tencent_mm_protocal_c_aib.mHP == null || com_tencent_mm_protocal_c_aib.mHP.equals(""))) {
                    hashMap.clear();
                    hashMap.put(Columns.TYPE, com_tencent_mm_protocal_c_aib.mHQ);
                    aVar.e("thumb", hashMap);
                    aVar.setText(AY(com_tencent_mm_protocal_c_aib.mHP));
                    aVar.oU("thumb");
                }
                if (com_tencent_mm_protocal_c_aib.aYp > 0) {
                    aVar.oT("subType");
                    aVar.setText(com_tencent_mm_protocal_c_aib.aYp);
                    aVar.oU("subType");
                }
                if (!be.kS(com_tencent_mm_protocal_c_aib.jFe)) {
                    aVar.oT("userData");
                    aVar.setText(com_tencent_mm_protocal_c_aib.jFe);
                    aVar.oU("userData");
                }
                if (!(com_tencent_mm_protocal_c_aib.mHT == null || com_tencent_mm_protocal_c_aib.mHT.equals(""))) {
                    hashMap.clear();
                    hashMap.put(Columns.TYPE, com_tencent_mm_protocal_c_aib.mHU);
                    aVar.e("lowBandUrl", hashMap);
                    aVar.setText(AY(com_tencent_mm_protocal_c_aib.mHT));
                    aVar.oU("lowBandUrl");
                }
                if (com_tencent_mm_protocal_c_aib.mHS != null) {
                    hashMap.clear();
                    if (com_tencent_mm_protocal_c_aib.mHS.mID > 0.0f) {
                        hashMap.put("width", com_tencent_mm_protocal_c_aib.mHS.mID);
                    }
                    if (com_tencent_mm_protocal_c_aib.mHS.lHK > 0.0f) {
                        hashMap.put("height", com_tencent_mm_protocal_c_aib.mHS.lHK);
                    }
                    if (com_tencent_mm_protocal_c_aib.mHS.mIE > 0.0f) {
                        hashMap.put("totalSize", com_tencent_mm_protocal_c_aib.mHS.mIE);
                    }
                    aVar.e("size", hashMap);
                    aVar.oU("size");
                }
                aVar.oU("media");
            }
            aVar.oU("mediaList");
        }
        aVar.oU("ContentObject");
        if (com_tencent_mm_protocal_c_azr.joj != null) {
            aVar.oT("actionInfo");
            if (!(com_tencent_mm_protocal_c_azr.joj.maK == null || be.kS(com_tencent_mm_protocal_c_azr.joj.maK.maD))) {
                aVar.oT("appMsg");
                aVar.oT("mediaTagName");
                aVar.setText(com_tencent_mm_protocal_c_azr.joj.maK.maD);
                aVar.oU("mediaTagName");
                aVar.oT("messageExt");
                aVar.setText(com_tencent_mm_protocal_c_azr.joj.maK.maE);
                aVar.oU("messageExt");
                aVar.oT("messageAction");
                aVar.setText(com_tencent_mm_protocal_c_azr.joj.maK.maF);
                aVar.oU("messageAction");
                aVar.oU("appMsg");
            }
            aVar.oU("actionInfo");
        }
        if (!(com_tencent_mm_protocal_c_azr.mWp == null || be.kS(com_tencent_mm_protocal_c_azr.mWp.gID))) {
            String str = com_tencent_mm_protocal_c_azr.jGu;
            axz com_tencent_mm_protocal_c_axz = new axz();
            if (str != null) {
                try {
                    com_tencent_mm_protocal_c_axz.az(Base64.decode(str, 0));
                } catch (Exception e) {
                }
            }
            com_tencent_mm_protocal_c_axz.mVv = new axx();
            com_tencent_mm_protocal_c_axz.mVv.ghW = com_tencent_mm_protocal_c_azr.mWp.gID;
            try {
                str = Base64.encodeToString(com_tencent_mm_protocal_c_axz.toByteArray(), 0);
                replace = str.replace("\n", "");
            } catch (Throwable e2) {
                Throwable th = e2;
                replace = str;
                v.a("MicroMsg.TimelineConvert", th, "", new Object[0]);
            }
            com_tencent_mm_protocal_c_azr.jGu = replace;
        }
        if (com_tencent_mm_protocal_c_azr.jGu != null) {
            aVar.oT("statExtStr");
            aVar.setText(com_tencent_mm_protocal_c_azr.jGu);
            aVar.oU("statExtStr");
        }
        aVar.oU("TimelineObject");
        replace = aVar.eid.toString();
        v.d("MicroMsg.TimelineConvert", "xmlContent: " + replace);
        if (bf.q(replace, "TimelineObject") != null) {
            return replace;
        }
        v.e("MicroMsg.TimelineConvert", "xml is error");
        return "";
    }
}
