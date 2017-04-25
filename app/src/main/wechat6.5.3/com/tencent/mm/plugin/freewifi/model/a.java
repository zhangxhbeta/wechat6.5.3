package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.g.AnonymousClass2;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class a {
    SparseArray<Long> fYv = new SparseArray();
    private g fYw = new g();

    public final void a(String str, b bVar, int i, Intent intent) {
        j.apm().aoU().post(new com.tencent.mm.plugin.freewifi.model.g.AnonymousClass1(this.fYw, str, intent, bVar, i));
    }

    public final void a(String str, String str2, Intent intent) {
        j.apm().aoU().post(new AnonymousClass2(this.fYw, str2, str, intent, null));
    }

    public final synchronized void aoR() {
        v.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "ap check for bar.");
        String aoY = d.aoY();
        v.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "autuApAuth, get ssid is %s ", new Object[]{aoY});
        if (!be.kS(aoY)) {
            if (j.apj().tO(aoY) == null) {
                String aoW = d.aoW();
                String str = "MicroMsg.FreeWifi.FreeWifiAuthManager";
                String str2 = "freewifi info is null, now try to check is the wechat wifi fromserver, ssid is : %s, mac is : %s, nowmac hashcode : %d";
                Object[] objArr = new Object[3];
                objArr[0] = aoY;
                objArr[1] = aoW;
                objArr[2] = Integer.valueOf(aoW == null ? 0 : aoW.hashCode());
                v.i(str, str2, objArr);
                if (!be.kS(aoW)) {
                    boolean z;
                    c tP = j.apj().tP(aoY);
                    str2 = "MicroMsg.FreeWifi.FreeWifiAuthManager";
                    String str3 = "now mac is : %s, loacal mac is : %s";
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = aoW;
                    objArr2[1] = tP == null ? "null free wifiinfo" : tP.field_mac;
                    v.i(str2, str3, objArr2);
                    if (tP != null) {
                        v.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "freewifi is not null, expired time = %d", new Object[]{Long.valueOf(tP.field_expiredTime)});
                        if (!aoW.equalsIgnoreCase(tP.field_mac) || tP.field_expiredTime - be.Nh() < 0) {
                            v.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has expierd time or mac has changed");
                            z = true;
                        }
                        z = false;
                    } else if (this.fYv.indexOfKey(aoW.hashCode()) >= 0) {
                        v.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has checked this mac, now time - last check time = %d", new Object[]{Long.valueOf(be.Ni() - ((Long) this.fYv.get(aoW.hashCode())).longValue())});
                        if (be.Ni() - ((Long) this.fYv.get(aoW.hashCode())).longValue() > 43200000) {
                            z = true;
                        }
                        z = false;
                    } else {
                        v.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has not checked this mac, try to check from server");
                        z = true;
                    }
                    v.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "Should request bar from back end = %b", new Object[]{Boolean.valueOf(z)});
                    if (z) {
                        int i;
                        v.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "now should do ap check, rssi is :  %d, mac : %s, mac hashcode : %d", new Object[]{Integer.valueOf(d.aoX()), aoW, Integer.valueOf(aoW.hashCode())});
                        if (System.currentTimeMillis() - a.fWV.tw("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS") > ((long) ((((a.fWV.getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7) * 24) * 60) * 60) * BaseReportManager.MAX_READ_COUNT))) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (a.fWV.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1) {
                            i |= 2;
                        }
                        if (a.fWV.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0) == 1) {
                            i |= 4;
                        }
                        if (a.fWV.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0) == 1) {
                            i |= 8;
                        }
                        v.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "features : " + i);
                        new com.tencent.mm.plugin.freewifi.d.b(aoW, aoY, r5, i).b(new e(this) {
                            final /* synthetic */ a fYx;

                            {
                                this.fYx = r1;
                            }

                            public final void a(int i, int i2, String str, k kVar) {
                                String str2 = ((com.tencent.mm.plugin.freewifi.d.b) kVar).mac;
                                if (!m.ty(str2)) {
                                    if (i2 == -30011) {
                                        this.fYx.fYv.put(str2.hashCode(), Long.valueOf(be.Ni()));
                                    } else {
                                        this.fYx.fYv.remove(str2.hashCode());
                                    }
                                }
                            }
                        });
                    }
                }
            }
        }
    }
}
