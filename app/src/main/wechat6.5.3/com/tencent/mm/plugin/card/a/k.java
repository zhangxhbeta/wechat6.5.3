package com.tencent.mm.plugin.card.a;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class k implements com.tencent.mm.modelgeo.a.a, e {
    public Map<String, Set<a>> eBE = new HashMap();
    public HashMap<String, String> eBF = new HashMap();
    private String eBG;
    public r eBH;
    private ac handler;

    public interface a {
        void a(boolean z, ArrayList<ix> arrayList);
    }

    public k() {
        ak.vy().a(563, this);
        this.handler = new ac(Looper.getMainLooper());
    }

    public final void a(String str, a aVar) {
        synchronized (this.eBE) {
            try {
                if (this.eBE.get(str) != null) {
                    ((Set) this.eBE.get(str)).remove(aVar);
                }
            } catch (Exception e) {
            }
        }
        synchronized (this.eBF) {
            this.eBF.remove(str);
        }
    }

    private void a(final String str, final boolean z, final ArrayList<ix> arrayList) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ k eBJ;

            public final void run() {
                Set set = (Set) this.eBJ.eBE.get(str);
                if (set != null && set.size() > 0) {
                    Set<a> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (a aVar : hashSet) {
                        if (aVar != null) {
                            aVar.a(z, arrayList);
                        }
                    }
                }
            }
        });
    }

    public final boolean a(String str, String str2, a aVar) {
        int i;
        v.d("MicroMsg.CardShopLBSManager", "getShopList, cardTpId = %s, card_id = %s", new Object[]{str, str2});
        this.eBG = str;
        synchronized (this.eBE) {
            if (!this.eBE.containsKey(str)) {
                this.eBE.put(str, new HashSet());
            }
            if (!((Set) this.eBE.get(str)).contains(aVar)) {
                ((Set) this.eBE.get(str)).add(aVar);
            }
        }
        synchronized (this.eBF) {
            if (!TextUtils.isEmpty(str2)) {
                this.eBF.put(str, str2);
            }
        }
        c FY = c.FY();
        if (FY == null) {
            v.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            i = 0;
        } else {
            FY.b(this);
            i = 1;
        }
        if (i == 0) {
            v.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            return false;
        }
        if (this.eBH != null) {
            ak.vy().c(this.eBH);
        }
        return true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        this.eBH = null;
        String str2 = ((r) kVar).eDv;
        v.i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            ArrayList arrayList = ((r) kVar).eDw;
            String str3 = "MicroMsg.CardShopLBSManager";
            String str4 = "onSceneEnd, respShopList size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            v.d(str3, str4, objArr);
            a(str2, true, arrayList);
            return;
        }
        v.e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
        a(str2, false, null);
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
        if (!z) {
            return true;
        }
        c FY = c.FY();
        if (FY != null) {
            FY.c(this);
        }
        v.d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)});
        Set set = (Set) this.eBE.get(this.eBG);
        if (set == null || set.size() == 0) {
            v.e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
            return false;
        }
        r rVar = new r(this.eBG, f, f2, (String) this.eBF.get(this.eBG));
        if (ak.vy().a(rVar, 0)) {
            this.eBH = rVar;
        } else {
            v.e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
            a(this.eBG, false, null);
        }
        return true;
    }
}
