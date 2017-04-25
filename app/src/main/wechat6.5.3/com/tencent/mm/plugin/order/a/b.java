package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b implements ag {
    private static HashMap<Integer, c> bXq;
    private List<WeakReference<Object>> eAR = new ArrayList();
    private com.tencent.mm.model.bo.b eWu = new com.tencent.mm.model.bo.b(this) {
        final /* synthetic */ b hMz;

        {
            this.hMz = r1;
        }

        public final void a(final a aVar) {
            final String a = m.a(aVar.czu.mbW);
            v.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:" + a);
            this.hMz.mHandler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass3 hMB;

                public final void run() {
                    com.tencent.mm.plugin.order.model.c aFI = b.aFI();
                    String str = a;
                    String str2 = aVar.czu.mbT;
                    if (!TextUtils.isEmpty(str)) {
                        j xz = com.tencent.mm.plugin.order.model.c.xz(str);
                        if (xz == null) {
                            v.i("MicroMsg.MallPayMsgManager", "payMsg == null");
                        } else if (!TextUtils.isEmpty(xz.hOa) || !TextUtils.isEmpty(xz.hOr) || !TextUtils.isEmpty(xz.hOq) || !TextUtils.isEmpty(xz.blu) || !TextUtils.isEmpty(xz.hOm) || !TextUtils.isEmpty(xz.hOn) || !TextUtils.isEmpty(xz.hOl) || !TextUtils.isEmpty(xz.hOp) || !TextUtils.isEmpty(xz.hOo) || !TextUtils.isEmpty(xz.hOk)) {
                            if (xz.hOk != null && com.tencent.mm.plugin.order.c.c.qw(xz.hOk)) {
                                int intValue = Integer.valueOf(xz.hOk).intValue();
                                if (!(intValue == 2 || intValue == 1)) {
                                    return;
                                }
                            }
                            if (TextUtils.isEmpty(xz.hOm)) {
                                xz.blm = str2;
                            } else {
                                xz.blm = str2 + xz.hOm;
                            }
                            v.i("MicroMsg.MallPayMsgManager", "msgid: " + xz.blm);
                            v.i("MicroMsg.MallPayMsgManager", "msgType: " + xz.hOk);
                            if (aFI.xB(xz.blm)) {
                                v.e("MicroMsg.MallPayMsgManager", "msg for id " + xz.blm + " is exist!!");
                                com.tencent.mm.plugin.order.b.a xD = aFI.xD(xz.blm);
                                aFI.xA(xz.blm);
                                aFI.eBB.add(xz);
                                aFI.a(xz, str, xD.field_isRead);
                            } else {
                                aFI.eBB.add(xz);
                                aFI.a(xz, str, "0");
                            }
                            aFI.aFM();
                            b aFF = b.aFF();
                            if (xz != null) {
                                amb com_tencent_mm_protocal_c_amb = new amb();
                                if (TextUtils.isEmpty(xz.hOm) || !com.tencent.mm.plugin.order.c.c.qw(xz.hOm)) {
                                    com_tencent_mm_protocal_c_amb.hNS = (int) (System.currentTimeMillis() / 1000);
                                    com_tencent_mm_protocal_c_amb.hNU = (int) (System.currentTimeMillis() / 1000);
                                } else {
                                    com_tencent_mm_protocal_c_amb.hNS = Integer.valueOf(xz.hOm).intValue();
                                    com_tencent_mm_protocal_c_amb.hNU = Integer.valueOf(xz.hOm).intValue();
                                }
                                com_tencent_mm_protocal_c_amb.hNX = 100000;
                                com_tencent_mm_protocal_c_amb.hOa = xz.hOa;
                                com_tencent_mm_protocal_c_amb.hNP = xz.blm;
                                com_tencent_mm_protocal_c_amb.hNT = xz.hOo;
                                com_tencent_mm_protocal_c_amb.mMU = -1;
                                com_tencent_mm_protocal_c_amb.hOb = xz.hOl;
                                com_tencent_mm_protocal_c_amb.hOc = xz.hOo;
                                com_tencent_mm_protocal_c_amb.hOd = xz.blu;
                            }
                            aFF.aFG();
                        }
                    }
                }
            });
        }
    };
    com.tencent.mm.plugin.order.model.b hMv = null;
    private com.tencent.mm.plugin.order.b.b hMw;
    private com.tencent.mm.plugin.order.model.c hMx = null;
    private com.tencent.mm.model.bo.b hMy = new com.tencent.mm.model.bo.b(this) {
        final /* synthetic */ b hMz;

        {
            this.hMz = r1;
        }

        public final void a(a aVar) {
            final String a = m.a(aVar.czu.mbW);
            v.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:" + a);
            this.hMz.mHandler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 hMA;

                public final void run() {
                    b bVar = this.hMA.hMz;
                    ak.yW();
                    if (com.tencent.mm.model.c.ww() == 0) {
                        throw new com.tencent.mm.model.b();
                    }
                    if (bVar.hMv == null) {
                        bVar.hMv = new com.tencent.mm.plugin.order.model.b();
                    }
                    com.tencent.mm.plugin.order.model.b bVar2 = bVar.hMv;
                    String str = a;
                    if (!be.kS(str)) {
                        Map q = bf.q(str, "sysmsg");
                        if (q != null) {
                            try {
                                str = (String) q.get(".sysmsg.wxpay.transid");
                                if (!be.kS(str)) {
                                    v.d("MicroMsg.WalletOrdersManager", "transid " + str);
                                    if (!bVar2.hMP.contains(str)) {
                                        bVar2.hMP.add(str);
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().set(204817, Integer.valueOf(bVar2.hMP.size()));
                                        v.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + bVar2.hMP.size());
                                        bVar2.aFJ();
                                        b.aFF().Yj();
                                    }
                                }
                            } catch (Exception e) {
                                v.e("MicroMsg.WalletOrdersManager", "cmdid error");
                            }
                        }
                    }
                }
            });
        }
    };
    private ac mHandler = new ac(Looper.getMainLooper());

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("ORDERCOMMONMSGXML_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.plugin.order.b.b.cic;
            }
        });
        com.tencent.mm.wallet_core.a.b("ShowOrdersInfoProcess", a.class);
    }

    public static b aFF() {
        b bVar = (b) ak.yP().fY("plugin.order");
        if (bVar != null) {
            return bVar;
        }
        v.w("MicroMsg.SubCoreWalletOrder", "not found in MMCore, new one");
        bVar = new b();
        ak.yP().a("plugin.order", bVar);
        return bVar;
    }

    public final void aFG() {
        if (this.eAR != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    weakReference.get();
                }
            }
        }
    }

    public final void Yj() {
        if (this.eAR != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    weakReference.get();
                }
            }
        }
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        this.hMv = null;
        this.hMx = null;
    }

    public final void th() {
    }

    public static com.tencent.mm.plugin.order.b.b aFH() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aFF().hMw == null) {
            b aFF = aFF();
            ak.yW();
            aFF.hMw = new com.tencent.mm.plugin.order.b.b(com.tencent.mm.model.c.wE());
        }
        return aFF().hMw;
    }

    public static com.tencent.mm.plugin.order.model.c aFI() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aFF().hMx == null) {
            aFF().hMx = new com.tencent.mm.plugin.order.model.c();
        }
        return aFF().hMx;
    }

    public static String axB() {
        if (!ak.uz()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(com.tencent.mm.model.c.wP()).append("order").toString();
    }
}
