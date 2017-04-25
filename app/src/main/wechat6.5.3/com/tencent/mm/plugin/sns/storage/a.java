package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public static int jtV = 0;
    public static int jtW = 1;
    public String blq;
    public String jbF;
    public String jpt;
    public int jtX;
    public long jtY;
    public long jtZ;
    public int jua;
    public String jub;
    public String juc;
    public String jud;
    public String jue;
    public int juf;
    public String jug;
    public String juh;
    public String jui;
    public int juj;
    public String juk;
    public String jul;
    public LinkedList<String> jum;
    boolean jun;
    public String juo;
    public String jup;
    public HashMap<String, String> juq;

    public a() {
        this.blq = "";
        this.jpt = "";
        this.jua = 0;
        this.jub = "";
        this.juc = "";
        this.jud = "";
        this.jue = "";
        this.juf = 0;
        this.jug = "";
        this.juh = "";
        this.jui = "";
        this.juj = jtV;
        this.juk = "";
        this.jul = "";
        this.jum = new LinkedList();
    }

    public a(String str) {
        this.blq = "";
        this.jpt = "";
        this.jua = 0;
        this.jub = "";
        this.juc = "";
        this.jud = "";
        this.jue = "";
        this.juf = 0;
        this.jug = "";
        this.juh = "";
        this.jui = "";
        this.juj = jtV;
        this.juk = "";
        this.jul = "";
        this.jum = new LinkedList();
        this.jun = false;
        Bc(str);
    }

    private void Bc(String str) {
        int i = 0;
        if (!be.kS(str)) {
            v.i("MicroMsg.ADInfo", "feed xml %s", new Object[]{str});
            Map q = bf.q(str, "ADInfo");
            if (q != null) {
                this.jbF = be.ah((String) q.get(".ADInfo.viewid"), "");
                if (q.get(".ADInfo.ad_sns_pos") != null) {
                    String ah;
                    this.jtX = be.KL((String) q.get(".ADInfo.ad_sns_pos"));
                    this.jtY = be.KM((String) q.get(".ADInfo.noExposureExpireTime"));
                    this.jtZ = be.KM((String) q.get(".ADInfo.exposureNoActionExpireTime"));
                    this.jpt = be.ah((String) q.get(".ADInfo.uxInfo"), "");
                    this.jua = be.KL((String) q.get(".ADInfo.adActionType"));
                    this.jub = be.ah((String) q.get(".ADInfo.adActionCardTitle"), "");
                    this.juc = be.ah((String) q.get(".ADInfo.adActionCardTpId"), "");
                    this.jud = be.ah((String) q.get(".ADInfo.adActionCardExt"), "");
                    this.jue = be.ah((String) q.get(".ADInfo.adActionLink"), "");
                    this.juf = be.KL((String) q.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
                    this.jug = be.ah((String) q.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
                    this.juh = be.ah((String) q.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
                    this.jui = be.ah((String) q.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
                    String ah2 = be.ah((String) q.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
                    this.juj = be.KL((String) q.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
                    if (this.juj == jtW) {
                        this.jul = be.ah((String) q.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
                        String ah3 = be.ah((String) q.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
                        String str2 = ".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName";
                        this.jum.clear();
                        int i2 = 0;
                        while (true) {
                            if (i2 == 0) {
                                ah = be.ah((String) q.get(str2), "");
                            } else {
                                ah = be.ah((String) q.get(str2 + i2), "");
                            }
                            if (be.kS(ah)) {
                                break;
                            }
                            this.jum.add(ah);
                            i2 = (i2 + 1) + 1;
                        }
                        int i3 = ah3.indexOf("%s") >= 0 ? 1 : 0;
                        int indexOf = ah3.indexOf("%");
                        i2 = ah3.lastIndexOf("%");
                        if (be.kS(ah3) || i3 == 0 || indexOf != i2) {
                            this.juk = ah2;
                            this.juj = jtV;
                        } else {
                            this.juk = ah3;
                        }
                    } else {
                        this.juk = ah2;
                        this.juj = jtV;
                    }
                    this.jun = q.containsKey(".ADInfo.adCanvasInfo");
                    this.jup = (String) q.get(".ADInfo.session_data.aid");
                    this.juo = (String) q.get(".ADInfo.session_data.trace_id");
                    this.juq = new HashMap();
                    String str3 = ".ADInfo.adCanvasExt.adCardItemList.cardItem";
                    while (true) {
                        String str4;
                        if (i == 0) {
                            str4 = str3;
                        } else {
                            str4 = str3 + i;
                        }
                        ah = (String) q.get(str4 + ".cardTpId");
                        str4 = (String) q.get(str4 + ".cardExt");
                        if (!be.kS(ah)) {
                            this.juq.put(ah, str4);
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
