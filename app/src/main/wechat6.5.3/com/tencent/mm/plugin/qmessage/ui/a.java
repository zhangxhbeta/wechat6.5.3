package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.qmessage.a.b;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.c.a, e {
    Context context;
    private ProgressDialog dwR;
    private f dxf;
    private u euW;

    public final class a {
        String bCk;
        String bCl;
        String cJf;
        String cJg;
        final /* synthetic */ a hZT;
        String hZU;
        String hZV;
        String hZW;

        private a(a aVar) {
            this.hZT = aVar;
            this.hZU = "";
            this.hZV = "";
            this.cJf = "";
            this.hZW = "";
            this.cJg = "";
            this.bCl = "";
            this.bCk = "";
        }
    }

    public a(Context context) {
        this.context = context;
    }

    public final boolean pz(String str) {
        return true;
    }

    public final boolean a(f fVar, u uVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        Assert.assertTrue(fVar != null);
        if (uVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(u.LJ(uVar.field_username));
        ak.vy().a(140, this);
        this.euW = uVar;
        this.dxf = fVar;
        fVar.addPreferencesFromResource(2131099675);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) fVar.Ow("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.lQq = "ContactWidgetQContact";
            normalUserHeaderPreference.a(uVar, 0, null);
        }
        XR();
        d xU = g.aHl().xU(this.euW.field_username);
        if (xU == null || be.ma(xU.getUsername()).length() <= 0) {
            v.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
            xU = new d();
            xU.username = this.euW.field_username;
            xU.bkU = -1;
            g.aHl().a(xU);
        }
        if (xU.hZH == 1) {
            String str = this.euW.field_username;
            z2 = be.ma(xU.aHj()).length() <= 0;
            if (be.ma(str).length() > 0) {
                z3 = true;
            }
            Assert.assertTrue(z3);
            Set hashSet = new HashSet();
            hashSet.add(str);
            final b bVar = new b(hashSet);
            new ac().post(new Runnable(this) {
                final /* synthetic */ a hZT;

                public final void run() {
                    ak.vy().a(bVar, 0);
                }
            });
            if (z2) {
                Context context = this.context;
                this.context.getString(2131231164);
                this.dwR = com.tencent.mm.ui.base.g.a(context, this.context.getString(2131231085), true, new OnCancelListener(this) {
                    final /* synthetic */ a hZT;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(bVar);
                    }
                });
            }
        }
        return true;
    }

    private void XR() {
        d xU = g.aHl().xU(this.euW.field_username);
        if (xU == null || be.ma(xU.getUsername()).length() <= 0) {
            v.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
            return;
        }
        if (be.ma(xU.aHj()).length() <= 0) {
            v.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
        }
        Preference Ow = this.dxf.Ow("contact_info_qcontact_sex");
        Preference Ow2 = this.dxf.Ow("contact_info_qcontact_age");
        Preference Ow3 = this.dxf.Ow("contact_info_qcontact_birthday");
        Preference Ow4 = this.dxf.Ow("contact_info_qcontact_address");
        a aVar = new a();
        String aHj = xU.aHj();
        if (be.ma(aHj).length() <= 0) {
            v.e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
        } else {
            Map q = bf.q(aHj, "extinfo");
            if (q != null) {
                aVar.hZU = (String) q.get(".extinfo.sex");
                aVar.hZV = (String) q.get(".extinfo.age");
                aVar.hZW = (String) q.get(".extinfo.bd");
                aVar.cJg = (String) q.get(".extinfo.country");
                aVar.bCk = (String) q.get(".extinfo.province");
                aVar.bCl = (String) q.get(".extinfo.city");
            }
            if (aVar.hZU == null || !aVar.hZU.equals("1")) {
                aVar.hZU = aVar.hZT.context.getString(2131235211);
            } else {
                aVar.hZU = aVar.hZT.context.getString(2131235212);
            }
            if (aVar.cJg != null) {
                aVar.cJf += aVar.cJg + " ";
            }
            if (aVar.bCk != null) {
                aVar.cJf += aVar.bCk + " ";
            }
            if (aVar.bCl != null) {
                aVar.cJf += aVar.bCl;
            }
        }
        if (Ow != null) {
            Ow.setSummary(aVar.hZU == null ? "" : aVar.hZU);
        }
        if (Ow2 != null) {
            Ow2.setSummary(aVar.hZV == null ? "" : aVar.hZV);
        }
        if (Ow3 != null) {
            Ow3.setSummary(aVar.hZW == null ? "" : aVar.hZW);
        }
        if (Ow4 != null) {
            Ow4.setSummary(aVar.cJf == null ? "" : aVar.cJf);
        }
        this.dxf.notifyDataSetChanged();
    }

    public final boolean XS() {
        ak.vy().b(140, this);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.dxf.Ow("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.onDetach();
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r9, int r10, java.lang.String r11, com.tencent.mm.v.k r12) {
        /*
        r8 = this;
        r7 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r6 = 2;
        r1 = 0;
        r0 = 1;
        r2 = r12.getType();
        r3 = 140; // 0x8c float:1.96E-43 double:6.9E-322;
        if (r2 == r3) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r2 = r8.dwR;
        if (r2 == 0) goto L_0x0020;
    L_0x0012:
        r2 = r8.dwR;
        r2.dismiss();
        r2 = 0;
        r8.dwR = r2;
        switch(r9) {
            case 1: goto L_0x005e;
            case 2: goto L_0x0083;
            default: goto L_0x001d;
        };
    L_0x001d:
        r0 = r1;
    L_0x001e:
        if (r0 != 0) goto L_0x000d;
    L_0x0020:
        if (r9 != 0) goto L_0x000d;
    L_0x0022:
        if (r10 != 0) goto L_0x000d;
    L_0x0024:
        r0 = com.tencent.mm.plugin.qmessage.a.g.aHl();
        r2 = r8.euW;
        r2 = r2.field_username;
        r0 = r0.xU(r2);
        if (r0 == 0) goto L_0x0040;
    L_0x0032:
        r2 = r0.getUsername();
        r2 = com.tencent.mm.sdk.platformtools.be.ma(r2);
        r2 = r2.length();
        if (r2 > 0) goto L_0x00a9;
    L_0x0040:
        r0 = "MicroMsg.ContactWidgetQContact";
        r1 = new java.lang.StringBuilder;
        r2 = "resetUpdateStatus: did not find this QContact, username = ";
        r1.<init>(r2);
        r2 = r8.euW;
        r2 = r2.field_username;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
    L_0x005a:
        r8.XR();
        goto L_0x000d;
    L_0x005e:
        r2 = com.tencent.mm.platformtools.q.dpx;
        if (r2 == 0) goto L_0x001d;
    L_0x0062:
        r2 = r8.context;
        r3 = r8.context;
        r4 = 2131232874; // 0x7f08086a float:1.808187E38 double:1.0529689463E-314;
        r5 = new java.lang.Object[r6];
        r6 = java.lang.Integer.valueOf(r0);
        r5[r1] = r6;
        r6 = java.lang.Integer.valueOf(r10);
        r5[r0] = r6;
        r3 = r3.getString(r4, r5);
        r2 = android.widget.Toast.makeText(r2, r3, r7);
        r2.show();
        goto L_0x001e;
    L_0x0083:
        r2 = com.tencent.mm.platformtools.q.dpx;
        if (r2 == 0) goto L_0x001d;
    L_0x0087:
        r2 = r8.context;
        r3 = r8.context;
        r4 = 2131232875; // 0x7f08086b float:1.8081872E38 double:1.052968947E-314;
        r5 = new java.lang.Object[r6];
        r6 = java.lang.Integer.valueOf(r6);
        r5[r1] = r6;
        r6 = java.lang.Integer.valueOf(r10);
        r5[r0] = r6;
        r3 = r3.getString(r4, r5);
        r2 = android.widget.Toast.makeText(r2, r3, r7);
        r2.show();
        goto L_0x001e;
    L_0x00a9:
        r2 = 8;
        r0.bkU = r2;
        r0.hZH = r1;
        r1 = com.tencent.mm.plugin.qmessage.a.g.aHl();
        r2 = r8.euW;
        r2 = r2.field_username;
        r0 = r1.a(r2, r0);
        if (r0 != 0) goto L_0x005a;
    L_0x00bd:
        r0 = "MicroMsg.ContactWidgetQContact";
        r1 = new java.lang.StringBuilder;
        r2 = "resetUpdateStatus: update Qcontact failed, username = ";
        r1.<init>(r2);
        r2 = r8.euW;
        r2 = r2.field_username;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qmessage.ui.a.a(int, int, java.lang.String, com.tencent.mm.v.k):void");
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
