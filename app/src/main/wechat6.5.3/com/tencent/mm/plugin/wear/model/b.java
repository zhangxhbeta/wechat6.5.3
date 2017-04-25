package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.e.a.qx;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.c.bhl;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public final class b implements e {
    boolean lbb;
    c lbc = new c<qx>(this) {
        final /* synthetic */ b lbf;

        {
            this.lbf = r2;
            this.nhz = qx.class.getName().hashCode();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b r10) {
            /*
            r9 = this;
            r8 = 2;
            r7 = 1;
            r6 = 0;
            r10 = (com.tencent.mm.e.a.qx) r10;
            r0 = r10 instanceof com.tencent.mm.e.a.qx;
            if (r0 == 0) goto L_0x0010;
        L_0x0009:
            r0 = r10.bsC;
            r0 = r0.aYt;
            switch(r0) {
                case 2: goto L_0x0011;
                case 3: goto L_0x0010;
                case 4: goto L_0x0010;
                case 5: goto L_0x0062;
                case 6: goto L_0x007e;
                case 7: goto L_0x0010;
                case 8: goto L_0x0038;
                case 9: goto L_0x0032;
                default: goto L_0x0010;
            };
        L_0x0010:
            return r6;
        L_0x0011:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "receive register response, deviceId=%s | isSuccess=%b";
            r2 = new java.lang.Object[r8];
            r3 = r10.bsC;
            r3 = r3.aRh;
            r2[r6] = r3;
            r3 = r10.bsC;
            r3 = r3.bbq;
            r3 = java.lang.Boolean.valueOf(r3);
            r2[r7] = r3;
            com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
            r0 = r10.bsC;
            r0 = r0.bbq;
            if (r0 == 0) goto L_0x0010;
        L_0x0032:
            r0 = r9.lbf;
            r0.connect();
            goto L_0x0010;
        L_0x0038:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "receive auth response, deviceId=%s | isSuccess=%b";
            r2 = new java.lang.Object[r8];
            r3 = r10.bsC;
            r3 = r3.aRh;
            r2[r6] = r3;
            r3 = r10.bsC;
            r3 = r3.bbq;
            r3 = java.lang.Boolean.valueOf(r3);
            r2[r7] = r3;
            com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
            r0 = r9.lbf;
            r1 = r10.bsC;
            r1 = r1.bbq;
            r0.lbb = r1;
            r0 = r9.lbf;
            r0 = r0.lbb;
            if (r0 == 0) goto L_0x0010;
        L_0x0061:
            goto L_0x0032;
        L_0x0062:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "receive send response, deviceId=%s | isSuccess=%b";
            r2 = new java.lang.Object[r8];
            r3 = r10.bsC;
            r3 = r3.aRh;
            r2[r6] = r3;
            r3 = r10.bsC;
            r3 = r3.bbq;
            r3 = java.lang.Boolean.valueOf(r3);
            r2[r7] = r3;
            com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
            goto L_0x0010;
        L_0x007e:
            r0 = com.tencent.mm.plugin.wear.model.a.bhH();
            r0 = r0.laR;
            r0 = r0.lbj;
            r0 = r0.lcb;
            if (r0 == 0) goto L_0x0096;
        L_0x008a:
            r0 = r0.ncr;
            r1 = r10.bsC;
            r1 = r1.aRh;
            r0 = r0.equals(r1);
            if (r0 != 0) goto L_0x00a1;
        L_0x0096:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "request is null or request.LocalNodeId is not same!";
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);
            goto L_0x0010;
        L_0x00a1:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "request step count deviceId=%s";
            r2 = new java.lang.Object[r7];
            r3 = r10.bsC;
            r3 = r3.aRh;
            r2[r6] = r3;
            com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
            r0 = r9.lbf;
            r1 = r10.bsC;
            r1 = r1.aRh;
            r1 = com.tencent.mm.plugin.wear.model.b.DG(r1);
            r2 = com.tencent.mm.plugin.wear.model.b.bhI();
            if (r1 == 0) goto L_0x00d8;
        L_0x00c2:
            r3 = r0.lbb;
            if (r3 == 0) goto L_0x00d8;
        L_0x00c6:
            if (r2 == 0) goto L_0x00d8;
        L_0x00c8:
            r1 = com.tencent.mm.plugin.wear.model.a.bhH();
            r1 = r1.laX;
            r2 = new com.tencent.mm.plugin.wear.model.b$2;
            r2.<init>(r0);
            r1.a(r2);
            goto L_0x0010;
        L_0x00d8:
            r3 = "MicroMsg.Wear.WearBizLogic";
            r4 = "isRegister=%b | isFocus=%b | isAuth=%b";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r1 = java.lang.Boolean.valueOf(r1);
            r5[r6] = r1;
            r1 = java.lang.Boolean.valueOf(r2);
            r5[r7] = r1;
            r0 = r0.lbb;
            r0 = java.lang.Boolean.valueOf(r0);
            r5[r8] = r0;
            com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);
            goto L_0x0010;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wear.model.b.1.a(com.tencent.mm.sdk.c.b):boolean");
        }
    };
    com.tencent.mm.sdk.h.j.b lbd = new com.tencent.mm.sdk.h.j.b(this) {
        final /* synthetic */ b lbf;

        {
            this.lbf = r1;
        }

        public final void a(int i, j jVar, Object obj) {
            if (obj == null || !(obj instanceof String)) {
                v.d("MicroMsg.Wear.WearBizLogic", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), jVar, obj});
                return;
            }
            String str = (String) obj;
            if (str != null && str.equals("gh_43f2581f6fd6")) {
                if (!b.bhI() && this.lbf.lbb) {
                    this.lbf.lbb = false;
                } else if (b.bhI() && !this.lbf.lbb) {
                    this.lbf.connect();
                }
            }
        }
    };
    ah lbe = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ b lbf;

        {
            this.lbf = r1;
        }

        public final boolean oU() {
            b.a(a.bhH().laR.lbj.lcb);
            return true;
        }
    }, true);

    private class a extends d {
        final /* synthetic */ b lbf;

        private a(b bVar) {
            this.lbf = bVar;
        }

        public final void execute() {
            ak.vy().a(30, this.lbf);
            List linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            List linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(1));
            ak.vy().a(new m(1, linkedList, linkedList2, "", ""), 0);
        }

        public final String getName() {
            return "AddContactTask";
        }
    }

    private class b extends d {
        final /* synthetic */ b lbf;
        private bhl lbg;

        public b(b bVar, bhl com_tencent_mm_protocal_c_bhl) {
            this.lbf = bVar;
            this.lbg = com_tencent_mm_protocal_c_bhl;
        }

        public final void execute() {
            ak.vy().a(1091, this.lbf);
            ak.vy().a(new com.tencent.mm.plugin.wear.model.d.a(this.lbg.ncr, "gh_43f2581f6fd6"), 0);
        }

        public final String getName() {
            return "RegisterDeviceTask";
        }
    }

    public b() {
        com.tencent.mm.sdk.c.a.nhr.e(this.lbc);
        ak.yW();
        com.tencent.mm.model.c.wH().a(this.lbd);
    }

    public final void connect() {
        bhl com_tencent_mm_protocal_c_bhl = a.bhH().laR.lbj.lcb;
        if (com_tencent_mm_protocal_c_bhl == null) {
            v.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
        } else if (!bhI()) {
            ak.yW();
            v.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", new Object[]{Boolean.valueOf(((Boolean) com.tencent.mm.model.c.vf().get(327825, Boolean.valueOf(false))).booleanValue())});
            if (!((Boolean) com.tencent.mm.model.c.vf().get(327825, Boolean.valueOf(false))).booleanValue()) {
                if (be.He()) {
                    v.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
                    return;
                }
                a.bhH().laX.a(new a());
                a.bhH().laX.a(new b(this, com_tencent_mm_protocal_c_bhl));
            }
        } else if (!DG(com_tencent_mm_protocal_c_bhl.ncr)) {
            v.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", new Object[]{com_tencent_mm_protocal_c_bhl.ncr});
            a.bhH().laX.a(new b(this, com_tencent_mm_protocal_c_bhl));
        } else if (this.lbb) {
            if (this.lbe.btC()) {
                v.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
                this.lbe.ea(3600000);
            } else {
                v.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
                this.lbe.QI();
                this.lbe.ea(3600000);
            }
            a(com_tencent_mm_protocal_c_bhl);
        } else {
            v.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", new Object[]{com_tencent_mm_protocal_c_bhl.ncr});
            String str = com_tencent_mm_protocal_c_bhl.ncr;
            String str2 = "gh_43f2581f6fd6";
            if (!this.lbb && DG(str)) {
                v.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", new Object[]{str, str2});
                qx qxVar = new qx();
                qxVar.bsC.aYt = 7;
                qxVar.bsC.aRh = str;
                qxVar.bsC.aZN = str2;
                com.tencent.mm.sdk.c.a.nhr.z(qxVar);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2;
        if (kVar instanceof com.tencent.mm.plugin.wear.model.d.a) {
            ak.vy().b(1091, this);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wear.model.d.a aVar = (com.tencent.mm.plugin.wear.model.d.a) kVar;
                String str3 = aVar.aRh;
                str2 = aVar.aZN;
                qx qxVar = new qx();
                qxVar.bsC.aYt = 1;
                qxVar.bsC.aRh = str3;
                qxVar.bsC.aZN = str2;
                com.tencent.mm.sdk.c.a.nhr.z(qxVar);
                return;
            }
            v.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        } else if (kVar instanceof m) {
            ak.vy().b(30, this);
            if (i == 0 && i2 == 0) {
                str2 = ((m) kVar).bmW();
                v.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", new Object[]{str2});
                ak.yW();
                u LX = com.tencent.mm.model.c.wH().LX("gh_43f2581f6fd6");
                if (LX == null || be.kS(str2)) {
                    v.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + str2 + ", contact = " + LX);
                } else {
                    BizInfo bizInfo = null;
                    if (com.tencent.mm.model.m.eB(LX.field_username)) {
                        String ma = be.ma(LX.field_username);
                        bizInfo = com.tencent.mm.modelbiz.e.hw(ma);
                        if (bizInfo != null) {
                            bizInfo.field_username = str2;
                        }
                        com.tencent.mm.modelbiz.u.Dy().hp(ma);
                        LX.bY(ma);
                    }
                    LX.setUsername(str2);
                    if (((int) LX.chr) == 0) {
                        ak.yW();
                        com.tencent.mm.model.c.wH().O(LX);
                    }
                    if (((int) LX.chr) <= 0) {
                        v.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
                    } else {
                        com.tencent.mm.model.m.n(LX);
                        ak.yW();
                        u LX2 = com.tencent.mm.model.c.wH().LX(LX.field_username);
                        if (bizInfo != null) {
                            com.tencent.mm.modelbiz.u.Dy().d(bizInfo);
                        } else {
                            bizInfo = com.tencent.mm.modelbiz.e.hw(LX2.field_username);
                            if (bizInfo == null || bizInfo.Ct()) {
                                v.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
                                com.tencent.mm.model.ab.a.crZ.I(LX2.field_username, "");
                                com.tencent.mm.u.b.gC(LX2.field_username);
                            } else if (LX2.bvp()) {
                                v.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", new Object[]{Integer.valueOf(LX2.bCr)});
                                com.tencent.mm.model.ab.a.crZ.I(LX2.field_username, "");
                                com.tencent.mm.u.b.gC(LX2.field_username);
                            }
                        }
                    }
                }
                com.tencent.mm.modelbiz.u.Dy().e(com.tencent.mm.modelbiz.u.Dy().ho(LX.field_username));
                ak.yW();
                com.tencent.mm.model.c.vf().set(327825, Boolean.valueOf(true));
                connect();
                return;
            }
            v.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 4 && i2 == -24 && !be.kS(str)) {
                Toast.makeText(aa.getContext(), str, 1).show();
            }
        }
    }

    static boolean DG(String str) {
        qx qxVar = new qx();
        qxVar.bsC.aYt = 3;
        qxVar.bsC.aRh = str;
        qxVar.bsC.aZN = "gh_43f2581f6fd6";
        com.tencent.mm.sdk.c.a.nhr.z(qxVar);
        v.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", new Object[]{Boolean.valueOf(qxVar.bsC.bbq)});
        return qxVar.bsC.bbq;
    }

    static boolean bhI() {
        ak.yW();
        return com.tencent.mm.i.a.ei(com.tencent.mm.model.c.wH().LX("gh_43f2581f6fd6").field_type);
    }

    public static void a(bhl com_tencent_mm_protocal_c_bhl) {
        if (com_tencent_mm_protocal_c_bhl != null) {
            qx qxVar = new qx();
            qxVar.bsC.aYt = 6;
            qxVar.bsC.aRh = com_tencent_mm_protocal_c_bhl.ncr;
            com.tencent.mm.sdk.c.a.nhr.z(qxVar);
            return;
        }
        v.i("MicroMsg.Wear.WearBizLogic", "request is null");
    }
}
