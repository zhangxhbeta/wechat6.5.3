package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c {
    private static c kRw = null;
    public Map<String, MallNews> kRx = new HashMap();

    public static c bgL() {
        if (kRw == null) {
            kRw = new c();
        }
        return kRw;
    }

    private c() {
        NH();
    }

    public final void NH() {
        this.kRx.clear();
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(270339, "");
        v.d("MicroMsg.MallNewsManager", "data : " + str);
        for (String str2 : be.g(str2.split(";"))) {
            MallNews Di = Di(str2);
            if (Di != null) {
                this.kRx.put(Di.kRn, Di);
            }
        }
    }

    public final List<String> bgM() {
        List<String> arrayList = new ArrayList();
        for (MallNews mallNews : this.kRx.values()) {
            if (!be.kS(mallNews.bax)) {
                arrayList.add(mallNews.bax);
            }
        }
        v.d("MicroMsg.MallNewsManager", "tickets.size : " + arrayList.size());
        return arrayList;
    }

    public static void bgN() {
        v.d("MicroMsg.MallNewsManager", "clearMallNew ");
        com.tencent.mm.p.c.us().az(262156, 266248);
    }

    public final boolean aGr() {
        v.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.kRx.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.kRx.keySet()) {
            if (!be.kS(str)) {
                MallNews mallNews = (MallNews) this.kRx.get(str);
                stringBuffer.append(mallNews.kRu.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + mallNews.kRl + "</showflag><newsTipFlag>" + mallNews.kRm + "</newsTipFlag></mallactivity></sysmsg>;");
            }
        }
        v.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        ak.yW();
        com.tencent.mm.model.c.vf().set(270339, stringBuffer.toString());
        return true;
    }

    public final String Dg(String str) {
        MallNews mallNews = (MallNews) this.kRx.get(str);
        if (mallNews == null || be.kS(mallNews.bax)) {
            return null;
        }
        return mallNews.bax;
    }

    public final MallNews Dh(String str) {
        v.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : " + str);
        if (be.kS(str) || !this.kRx.containsKey(str)) {
            return null;
        }
        MallNews mallNews = (MallNews) this.kRx.get(str);
        if (!"0".equals(mallNews.kRl)) {
            return mallNews;
        }
        mallNews.kRl = "1";
        aGr();
        return mallNews;
    }

    public static MallNews Di(String str) {
        if (be.kS(str)) {
            return null;
        }
        Map q = bf.q(str, "sysmsg");
        if (q == null) {
            return null;
        }
        try {
            MallNews mallNews = new MallNews((String) q.get(".sysmsg.mallactivity.functionid"));
            mallNews.keV = (String) q.get(".sysmsg.mallactivity.activityid");
            mallNews.bax = (String) q.get(".sysmsg.mallactivity.ticket");
            mallNews.type = (String) q.get(".sysmsg.mallactivity.type");
            mallNews.aXx = be.getInt((String) q.get(".sysmsg.mallactivity.showtype"), 0);
            if (q.containsKey(".sysmsg.mallactivity.showflag")) {
                mallNews.kRl = (String) q.get(".sysmsg.mallactivity.showflag");
            } else {
                mallNews.kRl = "0";
            }
            if (q.containsKey(".sysmsg.mallactivity.newsTipFlag")) {
                mallNews.kRm = (String) q.get(".sysmsg.mallactivity.newsTipFlag");
            } else {
                mallNews.kRm = "0";
            }
            mallNews.kRu = str;
            if (be.kS(mallNews.kRn)) {
                return null;
            }
            return mallNews;
        } catch (Exception e) {
            v.e("MicroMsg.MallNewsManager", "cmdid error");
            return null;
        }
    }

    public final void Q(ArrayList<MallFunction> arrayList) {
        if (arrayList != null) {
            Set<String> hashSet = new HashSet(this.kRx.keySet());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                hashSet.remove(((MallFunction) it.next()).imm);
            }
            for (String remove : hashSet) {
                this.kRx.remove(remove);
            }
            aGr();
        }
    }
}
