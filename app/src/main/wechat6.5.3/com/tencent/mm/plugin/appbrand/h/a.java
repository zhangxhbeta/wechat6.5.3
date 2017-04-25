package com.tencent.mm.plugin.appbrand.h;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.netscene.AppBrandRunCgi;
import com.tencent.mm.protocal.c.aep;
import com.tencent.mm.protocal.c.aeq;
import com.tencent.mm.protocal.c.aer;
import com.tencent.mm.protocal.c.aes;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import java.util.HashSet;
import java.util.Set;

public final class a {
    private static Set<String> dPq = new HashSet();
    private final a dPo;
    private final String dPp;
    private final String dzg;

    public interface a {
        void PV();

        void PW();

        void onCancel();
    }

    static /* synthetic */ void a(a aVar, aeq com_tencent_mm_protocal_c_aeq) {
        if (com_tencent_mm_protocal_c_aeq.mmP.bcd == 0) {
            dPq.add(aQ(aVar.dzg, aVar.dPp));
            aVar.dPo.PV();
            return;
        }
        String str = com_tencent_mm_protocal_c_aeq.mix;
        final String str2 = com_tencent_mm_protocal_c_aeq.mEW;
        com.tencent.mm.plugin.appbrand.ipc.a.a(str, "", aa.getResources().getString(2131230948), aa.getResources().getString(2131230949), new OnClickListener(aVar) {
            final /* synthetic */ a dPs;

            public final void onClick(DialogInterface dialogInterface, int i) {
                a.a(this.dPs, str2, 1);
                a.dPq.add(a.aQ(this.dPs.dzg, this.dPs.dPp));
                this.dPs.dPo.PV();
            }
        }, new OnClickListener(aVar) {
            final /* synthetic */ a dPs;

            public final void onClick(DialogInterface dialogInterface, int i) {
                a.a(this.dPs, str2, 2);
                a.dPq.remove(a.aQ(this.dPs.dzg, this.dPs.dPp));
                this.dPs.dPo.PW();
            }
        }, new OnClickListener(aVar) {
            final /* synthetic */ a dPs;

            {
                this.dPs = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                a.dPq.remove(a.aQ(this.dPs.dzg, this.dPs.dPp));
                this.dPs.dPo.onCancel();
            }
        });
    }

    static /* synthetic */ void a(a aVar, String str, final int i) {
        com.tencent.mm.v.b.a aVar2 = new com.tencent.mm.v.b.a();
        aVar2.czm = 1027;
        aVar2.uri = "/cgi-bin/mmbiz-bin/js-usersetauth";
        aer com_tencent_mm_protocal_c_aer = new aer();
        com_tencent_mm_protocal_c_aer.glj = aVar.dzg;
        com_tencent_mm_protocal_c_aer.miv = str;
        com_tencent_mm_protocal_c_aer.mEI = i;
        aVar2.czn = com_tencent_mm_protocal_c_aer;
        aVar2.czo = new aes();
        AppBrandRunCgi.a(aVar2.Bv(), new com.tencent.mm.plugin.appbrand.netscene.AppBrandRunCgi.a(aVar) {
            final /* synthetic */ a dPs;

            public final void a(int i, int i2, String str, b bVar) {
                if (i != 0 || i2 != 0 || bVar.czl.czs == null) {
                    v.e("MicroMsg.AppBrandJsApiUserAuth", "setAuth, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.czl.czs});
                } else if (((aes) bVar.czl.czs).mmP.bcd == 0 && 1 == i) {
                    v.i("MicroMsg.AppBrandJsApiUserAuth", "setAuth, add allow cache appId = %s, api = %s", new Object[]{this.dPs.dzg, this.dPs.dPp});
                    a.dPq.add(a.aQ(this.dPs.dzg, this.dPs.dPp));
                }
            }
        });
    }

    private a(a aVar, String str, String str2) {
        this.dPo = aVar;
        this.dzg = str;
        this.dPp = str2;
    }

    private static String aQ(String str, String str2) {
        return str + "#" + str2;
    }

    public static boolean aR(String str, String str2) {
        return dPq.contains(aQ(str, str2));
    }

    public static void a(String str, String str2, a aVar) {
        if (!be.kS(str) && !be.kS(str2) && !dPq.contains(aQ(str, str2))) {
            a aVar2 = new a(aVar, str, str2);
            com.tencent.mm.v.b.a aVar3 = new com.tencent.mm.v.b.a();
            aVar3.czm = 1116;
            aVar3.uri = "/cgi-bin/mmbiz-bin/js-userauth";
            aep com_tencent_mm_protocal_c_aep = new aep();
            com_tencent_mm_protocal_c_aep.glj = aVar2.dzg;
            com_tencent_mm_protocal_c_aep.mEV = aVar2.dPp;
            aVar3.czn = com_tencent_mm_protocal_c_aep;
            aVar3.czo = new aeq();
            AppBrandRunCgi.a(aVar3.Bv(), new com.tencent.mm.plugin.appbrand.netscene.AppBrandRunCgi.a(aVar2) {
                final /* synthetic */ a dPs;

                {
                    this.dPs = r1;
                }

                public final void a(int i, int i2, String str, b bVar) {
                    if (i == 0 && i2 == 0 && bVar.czl.czs != null) {
                        a.a(this.dPs, (aeq) bVar.czl.czs);
                        return;
                    }
                    v.e("MicroMsg.AppBrandJsApiUserAuth", "checkAuth, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.czl.czs});
                    a.dPq.remove(a.aQ(this.dPs.dzg, this.dPs.dPp));
                    this.dPs.dPo.PW();
                }
            });
        }
    }
}
