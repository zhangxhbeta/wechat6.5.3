package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public final class b {
    public static String juM = ".adxml.adArgs.arg";
    public String blq = "";
    public String cID;
    public int cZA;
    public String juA = "";
    public int juB = 0;
    public String juC = "";
    public String juD = "";
    public String juE = "";
    public String juF = "";
    public String juG = "";
    public String juH = "";
    public int juI;
    public int juJ;
    public int juK;
    public Map<String, String> juL = new HashMap();
    public int juN;
    public int juO;
    public float juP;
    public float juQ;
    public int juR;
    public int juS;
    public int juT;
    public String juU;
    public float juV;
    public float juW;
    public float juX;
    public float juY;
    public String jue;
    public boolean jun;
    public String jur;
    public int jus = 0;
    public int jut = 0;
    public String juu = "";
    public String juv = "";
    public int juw = 0;
    public String jux = "";
    public String juy = "";
    public int juz = 0;

    public b(String str) {
        if (be.kS(str) || !str.trim().startsWith("<RecXml")) {
            P(str, "", "adxml");
            return;
        }
        Map P = P(str, ".RecXml", "RecXml");
        if (P != null && !P.isEmpty()) {
            this.juI = be.KL((String) P.get(".RecXml.$type"));
            this.juJ = be.KL((String) P.get(".RecXml.$source"));
            this.juK = be.KL((String) P.get(".RecXml.$expId"));
        }
    }

    private Map<String, String> P(String str, String str2, String str3) {
        if (be.kS(str) || be.kS(str3)) {
            return null;
        }
        this.blq = str;
        v.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", new Object[]{str, str2, str3});
        Map<String, String> q = f.q(str, str3);
        if (q == null) {
            return null;
        }
        this.cZA = be.KL((String) q.get(str2 + ".adxml.adType"));
        this.jur = be.ah((String) q.get(str2 + ".adxml.adActionTitle"), "");
        this.jue = be.ah((String) q.get(str2 + ".adxml.adActionLink"), "");
        this.cID = be.ah((String) q.get(str2 + ".adxml.nickname"), "");
        this.jus = be.KL((String) q.get(str2 + ".adxml.webviewRightBarShow"));
        this.jut = be.KL((String) q.get(str2 + ".adxml.adActionLinkHidden"));
        this.juu = be.ah((String) q.get(str2 + ".adxml.adActionLinkName"), "");
        this.juv = be.ah((String) q.get(str2 + ".adxml.adActionLinkIcon"), "");
        this.jux = be.ah((String) q.get(str2 + ".adxml.attachShareLinkWording"), "");
        this.juy = be.ah((String) q.get(str2 + ".adxml.attachShareLinkUrl"), "");
        this.juw = be.KL((String) q.get(str2 + ".adxml.attachShareLinkIsHidden"));
        if (be.kS(this.jux) || be.kS(this.juy)) {
            this.juw = 1;
        }
        this.juC = be.ah((String) q.get(str2 + ".adxml.expandOutsideTitle.zh"), "");
        this.juE = be.ah((String) q.get(str2 + ".adxml.expandOutsideTitle.tw"), "");
        this.juD = be.ah((String) q.get(str2 + ".adxml.expandOutsideTitle.en"), "");
        this.juF = be.ah((String) q.get(str2 + ".adxml.expandInsideTitle.zh"), "");
        this.juH = be.ah((String) q.get(str2 + ".adxml.expandInsideTitle.tw"), "");
        this.juG = be.ah((String) q.get(str2 + ".adxml.expandInsideTitle.en"), "");
        this.juz = be.KL((String) q.get(str2 + ".adxml.headClickType"));
        this.juA = be.ah((String) q.get(str2 + ".adxml.headClickParam"), "");
        this.juB = be.KL((String) q.get(str2 + ".adxml.headClickRightBarShow"));
        int i = 0;
        while (true) {
            String str4 = str2 + juM + (i == 0 ? "" : Integer.valueOf(i)) + ".key";
            String str5 = (String) q.get(str4);
            if (str5 != null) {
                String str6 = str2 + juM + (i == 0 ? "" : Integer.valueOf(i)) + ".value";
                String str7 = (String) q.get(str6);
                v.i("MicroMsg.ADXml", "newKey " + str4 + " " + str5 + " newValue : " + str6 + " " + str7);
                this.juL.put(str5, str7);
                i++;
            } else {
                this.jun = q.containsKey(str2 + ".adxml.adCanvasInfo");
                this.juN = be.KL((String) q.get(str2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
                this.juO = be.KL((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
                this.juP = (float) be.KN((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth"));
                this.juQ = (float) be.KN((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight"));
                this.juT = be.KL((String) q.get(str2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
                this.juU = be.ah((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
                this.juR = be.KL((String) q.get(str2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
                this.juS = be.KL((String) q.get(str2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
                this.juV = (float) be.KN((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconWidth"));
                this.juW = (float) be.KN((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconHeight"));
                this.juX = (float) be.KN((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight"));
                this.juY = (float) be.KN((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom"));
                return q;
            }
        }
    }
}
