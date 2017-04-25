package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private static d kRy = null;
    public Map<String, MallNews> kRx = new HashMap();

    public static d bgO() {
        if (kRy == null) {
            kRy = new d();
        }
        return kRy;
    }

    private d() {
        NH();
    }

    public final void NH() {
        this.kRx.clear();
        ak.yW();
        String str = (String) c.vf().get(270341, "");
        v.d("MicroMsg.MallNewsManagerNewVersion", "data : " + str);
        for (String str2 : be.g(str2.split(";"))) {
            MallNews Di = Di(str2);
            if (Di != null) {
                this.kRx.put(Di.kRn, Di);
            }
        }
    }

    public final boolean aGr() {
        v.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.kRx.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.kRx.keySet()) {
            if (!be.kS(str)) {
                MallNews mallNews = (MallNews) this.kRx.get(str);
                stringBuffer.append(mallNews.kRu.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + mallNews.keV + "</activityid><type>" + mallNews.type + "</type><showflag>" + mallNews.kRl + "</showflag><newsTipFlag>" + mallNews.kRm + "</newsTipFlag></mallactivitynew></sysmsg>;");
            }
        }
        v.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + stringBuffer.toString());
        ak.yW();
        c.vf().set(270341, stringBuffer.toString());
        return true;
    }

    public final MallNews Dj(String str) {
        return (MallNews) this.kRx.get(str);
    }

    private static MallNews Di(String str) {
        if (be.kS(str)) {
            return null;
        }
        Map q = bf.q(str, "sysmsg");
        if (q == null) {
            return null;
        }
        try {
            MallNews mallNews = new MallNews((String) q.get(".sysmsg.mallactivitynew.functionid"));
            mallNews.keV = (String) q.get(".sysmsg.mallactivitynew.activityid");
            mallNews.type = (String) q.get(".sysmsg.mallactivitynew.type");
            mallNews.aXx = be.getInt((String) q.get(".sysmsg.mallactivitynew.showtype"), 0);
            if (q.containsKey(".sysmsg.mallactivitynew.showflag")) {
                mallNews.kRl = (String) q.get(".sysmsg.mallactivitynew.showflag");
            } else {
                mallNews.kRl = "0";
            }
            if (q.containsKey(".sysmsg.mallactivitynew.newsTipFlag")) {
                mallNews.kRm = (String) q.get(".sysmsg.mallactivitynew.newsTipFlag");
            } else {
                mallNews.kRm = "0";
            }
            mallNews.kRu = str;
            if (be.kS(mallNews.kRn)) {
                return null;
            }
            return mallNews;
        } catch (Exception e) {
            v.e("MicroMsg.MallNewsManagerNewVersion", "cmdid error");
            return null;
        }
    }
}
