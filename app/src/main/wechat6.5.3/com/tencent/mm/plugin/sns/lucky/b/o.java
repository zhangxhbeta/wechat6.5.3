package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.a.g;
import com.tencent.mm.e.a.nh;
import com.tencent.mm.plugin.appbrand.jsapi.ak;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.t.a;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class o {
    private static int[] jeZ = new int[]{50, 66, 68, 88, 99, ak.CTRL_INDEX, au.CTRL_INDEX, 166, 168, 188, 199, 233, 266, 268, 288, 299, 369, 419, 520, 666, 1024};
    private static String jet = "";
    private static o jeu = null;
    public long efw = 0;
    private StringBuffer eid = new StringBuffer();
    public String jeA = "";
    public long jeB = 0;
    public long jeC = 0;
    public String jeD = "";
    public String jeE = "";
    public String jeF = "";
    public String jeG = "";
    public String jeH = "";
    public String jeI = "";
    public String jeJ = "";
    public String jeK = "";
    public String jeL = "";
    public String jeM = "";
    public String jeN = "";
    public String jeO = "";
    public String jeP = "";
    public String jeQ = "";
    public String jeR = "";
    public String jeS = "";
    public String jeT = "";
    public String jeU = "";
    public int jeV = -1;
    public String jeW = "";
    private List<List<Integer>> jeX = new LinkedList();
    private List<Integer> jeY = new LinkedList();
    public String jeq = "";
    public long jer = 0;
    public String jev = "";
    public int jew = 0;
    public int jex = 0;
    public long jey = 0;
    public long jez = 0;
    private LinkedList<k> jfa = new LinkedList();

    public final List<Integer> pU(int i) {
        if (i < this.jeX.size() && i >= 0) {
            List<Integer> list = (List) this.jeX.get(i);
            if (list != null) {
                return list;
            }
        }
        v.i("MicroMsg.NewYearSnsCtrlV2", "getAmountLeveldefaults %d ", new Object[]{Integer.valueOf(i)});
        if (this.jeY == null || this.jeY.size() == 0) {
            this.jeY = new ArrayList();
            for (int valueOf : jeZ) {
                this.jeY.add(Integer.valueOf(valueOf));
            }
        }
        return this.jeY;
    }

    public static o aRh() {
        if (!com.tencent.mm.model.ak.uz()) {
            return new o();
        }
        c Ls = com.tencent.mm.model.c.c.Au().Ls("100068");
        String str = Ls.field_rawXML;
        if (be.kS(str)) {
            str = "";
        }
        String m = g.m(str.getBytes());
        if (jeu == null || !m.equals(jet)) {
            v.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
            jeu = new o();
            try {
                Map buX = Ls.buX();
                str = "";
                if (buX != null) {
                    str = (String) buX.get("SnsHBConfig");
                }
                if (be.kS(str)) {
                    str = "";
                }
                str = URLDecoder.decode(str, "UTF-8");
                o oVar = jeu;
                oVar.eid = new StringBuffer();
                oVar.jfa.clear();
                Map q = bf.q(str, "sysmsg");
                if (q == null) {
                    v.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", new Object[]{str});
                } else {
                    oVar.jer = be.KM((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
                    oVar.eid.append("BeginTime:" + oVar.jer + ";");
                    oVar.efw = be.KM((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
                    oVar.eid.append("EndTime:" + oVar.efw + ";\n");
                    oVar.jew = be.KL((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
                    oVar.jex = be.KL((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
                    oVar.eid.append("SvrDownReqLimitLevelMin:" + oVar.jew + " SvrDownReqLimitLevelMax: " + oVar.jex + ";\n");
                    oVar.jeB = be.KM((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
                    oVar.jeC = be.KM((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
                    oVar.jeD = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
                    oVar.jeE = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
                    oVar.jeF = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
                    oVar.jeG = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
                    oVar.jeH = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
                    oVar.jeI = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
                    oVar.jeK = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
                    oVar.jeL = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
                    oVar.jeJ = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
                    oVar.jeM = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
                    oVar.jeN = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
                    oVar.jeU = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
                    oVar.jeV = be.KL((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
                    oVar.jeW = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
                    if (oVar.jeV <= 0) {
                        v.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + oVar.jeV);
                        oVar.jeV = 1;
                    }
                    oVar.eid.append("FullScreenID:" + oVar.jeW + " BrowseBeginTime:" + oVar.jeB + " BrowseEndTime:" + oVar.jeC + " FullScreenTitle:" + oVar.jeD + " FullScreenDescription:" + oVar.jeE + " FullScreenQueryTips:" + oVar.jeF + " FullScreenAcceptButtonText: " + oVar.jeG);
                    oVar.eid.append("FullScreenRejectButtonText:" + oVar.jeH + " ActionSheetOpenTips:" + oVar.jeI + " ActionSheetOpenSuccTips:" + oVar.jeK + " ActionSheetOpenFailTips:" + oVar.jeL + " ActionSheetCloseTips:" + oVar.jeJ + " ActionSheetCloseSuccTips: " + oVar.jeM + " ActionSheetCloseFailTips: " + oVar.jeN + "MaxPostFeedID: " + oVar.jeU + " MaxPostFeedCount:" + oVar.jeV);
                    oVar.jeO = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
                    oVar.jeP = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
                    oVar.jeQ = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
                    oVar.jeR = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
                    oVar.jeS = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
                    oVar.jeT = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
                    oVar.eid.append("AlertTipForHasUsed:" + oVar.jeO + " AlertTipForObtainUsedRight:" + oVar.jeP + " AlertTipForClosedBrowseSwitch:" + oVar.jeQ + " AlertButtonText:" + oVar.jeR + " GoldenCameraTip:" + oVar.jeS + " GoldenCameraTipID:" + oVar.jeT);
                    int i = 0;
                    while (true) {
                        String str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "RedPointID";
                        oVar.jeq = be.ah((String) q.get(String.format(str2, objArr)), "");
                        oVar.eid.append("RedPointID:" + oVar.jeq + ";");
                        if (be.kS(oVar.jeq)) {
                            break;
                        }
                        str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "BeginTime";
                        oVar.jey = be.KM((String) q.get(String.format(str2, objArr)));
                        oVar.eid.append("RedPointID_BeginTime:" + oVar.jey + ";");
                        str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "EndTime";
                        oVar.jez = be.KM((String) q.get(String.format(str2, objArr)));
                        oVar.eid.append("RedPointID_EndTime:" + oVar.jez + ";\n");
                        k kVar = new k();
                        kVar.jeq = oVar.jeq;
                        kVar.jer = oVar.jey;
                        kVar.efw = oVar.jez;
                        oVar.jfa.add(kVar);
                        i++;
                    }
                    oVar.jeA = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
                    oVar.eid.append("PostTips:" + oVar.jeA + ";");
                    oVar.jev = be.ah((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
                    oVar.eid.append("EntranceTips:" + oVar.jev + ";");
                    oVar.jeX.clear();
                    int i2 = 0;
                    while (true) {
                        int KL = be.KL((String) q.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Count"));
                        oVar.eid.append("count: " + i2 + " | " + KL + ";\n");
                        if (KL == 0) {
                            break;
                        }
                        List linkedList = new LinkedList();
                        i = 0;
                        while (i < KL) {
                            int KL2 = be.KL((String) q.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Amount" + (i == 0 ? "" : Integer.valueOf(i))));
                            linkedList.add(Integer.valueOf(KL2));
                            oVar.eid.append("AmountLevel : " + i2 + " index " + i + " val: " + KL2 + ";");
                            i++;
                        }
                        oVar.jeX.add(linkedList);
                        i2++;
                    }
                    v.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + oVar.eid.toString());
                }
                jet = m;
            } catch (Exception e) {
                v.e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + e.getMessage());
            }
        }
        return jeu;
    }

    public static boolean aRi() {
        com.tencent.mm.model.ak.yW();
        return ((Boolean) com.tencent.mm.model.c.vf().get(a.nrW, Boolean.valueOf(true))).booleanValue();
    }

    public final void aRj() {
        i f = t.f(a.nsa);
        if (f.jqD == null || be.kS(f.jqD.jqA)) {
            f.jqD = new com.tencent.mm.plugin.sns.g.g();
            f.jqD.jqA = this.jeU;
            f.jqD.jqB = 0;
        }
        if (be.kS(f.jqD.jqA) || !f.jqD.jqA.equals(this.jeU)) {
            f.jqD = new com.tencent.mm.plugin.sns.g.g();
            f.jqD.jqA = this.jeU;
            f.jqD.jqB = 0;
        } else {
            com.tencent.mm.plugin.sns.g.g gVar = f.jqD;
            gVar.jqB--;
            if (f.jqD.jqB < 0) {
                f.jqD.jqB = 0;
            }
        }
        v.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + f.jqD.jqB + " postId: " + this.jeU + " " + be.bur().toString());
        try {
            com.tencent.mm.model.ak.yW();
            com.tencent.mm.model.c.vf().a(a.nsa, new String(f.toByteArray(), Charset.forName("ISO-8859-1")));
        } catch (IOException e) {
            v.w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + e.getLocalizedMessage());
        }
        com.tencent.mm.sdk.c.a.nhr.z(new nh());
    }
}
