package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.f.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;

public final class d {
    private Context context;
    f dxf;
    private View hFT;
    private View iHK;
    public OnClickListener iqU;
    String lJI;
    private HashMap<String, Preference> lJJ = new HashMap();
    boolean lJK = false;
    boolean lJL;
    public e lJM;
    b lJN;
    a lJO;
    private OnClickListener lJP;
    private OnClickListener lJQ;
    private OnClickListener lJR;
    private b lJS;
    private f.a lJT;
    private e.a lJU;
    String username;

    public d(Context context) {
        boolean z = false;
        if (this.lJK) {
            z = true;
        }
        this.lJL = z;
        this.lJN = null;
        this.iqU = null;
        this.lJO = null;
        this.lJR = new OnClickListener(this) {
            final /* synthetic */ d lJV;

            {
                this.lJV = r1;
            }

            public final void onClick(View view) {
                v.d("MicroMsg.ContactListArchor", "OnClickListener = onClick ");
            }
        };
        this.lJS = new b(this) {
            final /* synthetic */ d lJV;

            {
                this.lJV = r1;
            }

            public final boolean jn(int i) {
                if (this.lJV.lJM.lKi && this.lJV.lJM.tW(i) && !this.lJV.lJM.tV(i)) {
                    v.d("MicroMsg.ContactListArchor", "onItemLongClick " + i);
                }
                return true;
            }
        };
        this.lJT = new f.a(this) {
            final /* synthetic */ d lJV;

            {
                this.lJV = r1;
            }

            public final void tU(int i) {
                int i2 = 1;
                if (this.lJV.lJO != null && this.lJV.lJM != null) {
                    e eVar = this.lJV.lJM;
                    int i3 = eVar.lKi ? (eVar.eRm || i != eVar.lKg + 2) ? 0 : 1 : (eVar.eRm || i != eVar.lKg + 1) ? 0 : 1;
                    if (i3 == 0) {
                        eVar = this.lJV.lJM;
                        if (eVar.eRm || i != eVar.lKg) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        if (i3 != 0) {
                            this.lJV.lJO.jq(i);
                            return;
                        }
                        eVar = this.lJV.lJM;
                        if (eVar.eRm || i != eVar.lKg + 1) {
                            i2 = 0;
                        }
                        if (i2 != 0) {
                            if (!this.lJV.lJM.lKi) {
                                return;
                            }
                            if (m.dE(this.lJV.username)) {
                                this.lJV.lJO.jo(i);
                            } else {
                                this.lJV.lJM.tV(0);
                            }
                        } else if (this.lJV.lJM.eRm && this.lJV.lJM.tW(i)) {
                            this.lJV.lJO.jo(i);
                        } else if (this.lJV.lJM.eRm && !this.lJV.lJM.tW(i)) {
                            this.lJV.lJO.adp();
                        } else if (!this.lJV.lJM.eRm && this.lJV.lJM.tW(i)) {
                            this.lJV.lJO.jp(i);
                        }
                    }
                }
            }
        };
        this.lJU = new e.a(this) {
            final /* synthetic */ d lJV;

            {
                this.lJV = r1;
            }

            public final void bpj() {
                if (this.lJV.dxf != null) {
                    this.lJV.dxf.notifyDataSetChanged();
                }
            }
        };
        this.context = context;
        this.lJM = new e(this.context);
        this.lJM.lJY = this.lJU;
    }

    final void vV(String str) {
        e eVar = this.lJM;
        eVar.username = str;
        eVar.bhx = m.dE(str);
        if (!eVar.bhx) {
            eVar.lKa = e.hC(str);
        }
        if (!eVar.lKa) {
            eVar.ePs = eVar.eRX.wO().LC(str);
        }
        if (eVar.lKa) {
            c.a aVar = new c.a();
            aVar.cPv = com.tencent.mm.modelbiz.a.e.ic(eVar.username);
            aVar.cPs = true;
            aVar.cPO = true;
            aVar.cPH = 2131165440;
            eVar.eSp = aVar.GU();
        }
        this.lJM.lKm = this.lJL;
        this.lJM.notifyChanged();
        aIO();
    }

    private static String tT(int i) {
        if (i >= 0) {
            return "pref_contact_list_row_" + i;
        }
        String str = "unkown";
        if (i == -1) {
            str = "header";
        } else if (i == -2) {
            str = "footer";
        }
        return "pref_contact_list_row_" + str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aIO() {
        /*
        r15 = this;
        r0 = r15.dxf;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        r0 = r15.lJI;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r15.lJJ;
        r0 = r0.keySet();
        r1 = r0.iterator();
    L_0x0013:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0025;
    L_0x0019:
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r2 = r15.dxf;
        r2.Ox(r0);
        goto L_0x0013;
    L_0x0025:
        r0 = r15.lJJ;
        r0.clear();
        r0 = r15.dxf;
        r1 = r15.lJI;
        r1 = r0.indexOf(r1);
        r0 = 0;
        r2 = 0;
        r3 = r15.hFT;
        if (r3 == 0) goto L_0x0039;
    L_0x0038:
        r0 = 1;
    L_0x0039:
        r3 = r15.iHK;
        if (r3 == 0) goto L_0x01eb;
    L_0x003d:
        r3 = r15.lJK;
        if (r3 == 0) goto L_0x004c;
    L_0x0041:
        r3 = r15.lJM;
        r4 = r3.lKf;
        r3 = r3.lKn;
        if (r4 <= r3) goto L_0x0111;
    L_0x0049:
        r3 = 1;
    L_0x004a:
        if (r3 == 0) goto L_0x01eb;
    L_0x004c:
        r2 = 1;
        r7 = r2;
    L_0x004e:
        if (r0 == 0) goto L_0x007c;
    L_0x0050:
        r0 = new com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference;
        r2 = r15.context;
        r0.<init>(r2);
        r2 = -1;
        r2 = tT(r2);
        r0.setKey(r2);
        r2 = r15.hFT;
        r0.setCustomView(r2);
        r2 = 2130838046; // 0x7f02021e float:1.7281063E38 double:1.0527738754E-314;
        r0.background = r2;
        r2 = r15.lJP;
        r0.iqU = r2;
        r2 = r15.dxf;
        r2.a(r0, r1);
        r2 = r15.lJJ;
        r3 = r0.dnU;
        r2.put(r3, r0);
        r0 = r1 + 1;
        r1 = r0;
    L_0x007c:
        r0 = r15.lJN;
        if (r0 == 0) goto L_0x0114;
    L_0x0080:
        r0 = r15.lJN;
        r2 = r0;
    L_0x0083:
        r0 = r15.iqU;
        if (r0 == 0) goto L_0x0119;
    L_0x0087:
        r0 = r15.iqU;
        r3 = r0;
    L_0x008a:
        r0 = r15.lJM;
        r0 = r0.lKq;
        r4 = r15.lJM;
        r5 = r4.bpk();
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r4 != 0) goto L_0x00a6;
    L_0x009a:
        if (r0 == 0) goto L_0x011e;
    L_0x009c:
        r4 = com.tencent.mm.model.k.xF();
        r0 = r0.equals(r4);
        if (r0 != 0) goto L_0x011e;
    L_0x00a6:
        r0 = 0;
    L_0x00a7:
        r4 = r15.lJM;
        r4 = r4.lKa;
        if (r4 == 0) goto L_0x01e8;
    L_0x00ad:
        r0 = r15.lJM;
        r0 = r0.lKb;
        r4 = r0;
    L_0x00b2:
        r0 = r15.lJM;
        r6 = r0.lKg;
        if (r5 == 0) goto L_0x00ba;
    L_0x00b8:
        if (r4 == 0) goto L_0x0120;
    L_0x00ba:
        r0 = 2;
    L_0x00bb:
        r8 = r6 + r0;
        r6 = 0;
        r5 = r15.lJM;
        r9 = r15.context;
        if (r9 != 0) goto L_0x0122;
    L_0x00c4:
        r0 = 0;
    L_0x00c5:
        r5 = 0;
    L_0x00c6:
        r9 = r15.lJM;
        r9 = r9.getCount();
        if (r5 >= r9) goto L_0x01bf;
    L_0x00ce:
        if (r5 >= r8) goto L_0x01bf;
    L_0x00d0:
        r9 = new com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
        r10 = r15.context;
        r11 = 1;
        r9.<init>(r10, r11);
        r10 = tT(r6);
        r9.setKey(r10);
        r10 = r9.lKF;
        r11 = r15.lJM;
        r10.lJM = r11;
        r10.row = r6;
        r10.index = r5;
        r10 = r9.lKF;
        r10.lKG = r0;
        r10 = r9.lKF;
        r10.ePp = r4;
        r10 = r9.lKF;
        r10.iqU = r3;
        r10 = r9.lKF;
        r11 = r15.lJT;
        r10.lJT = r11;
        r10 = r9.lKF;
        r10.lKH = r2;
        r10 = r15.dxf;
        r11 = r1 + r6;
        r10.a(r9, r11);
        r10 = r15.lJJ;
        r11 = r9.dnU;
        r10.put(r11, r9);
        r5 = r5 + r0;
        r6 = r6 + 1;
        goto L_0x00c6;
    L_0x0111:
        r3 = 0;
        goto L_0x004a;
    L_0x0114:
        r0 = r15.lJS;
        r2 = r0;
        goto L_0x0083;
    L_0x0119:
        r0 = r15.lJR;
        r3 = r0;
        goto L_0x008a;
    L_0x011e:
        r0 = 1;
        goto L_0x00a7;
    L_0x0120:
        r0 = 1;
        goto L_0x00bb;
    L_0x0122:
        r0 = "window";
        r0 = r9.getSystemService(r0);
        r0 = (android.view.WindowManager) r0;
        r0 = r0.getDefaultDisplay();
        r10 = r0.getWidth();
        r0 = r0.getHeight();
        r11 = (float) r10;
        r12 = r9.getResources();
        r13 = 2131493162; // 0x7f0c012a float:1.8609796E38 double:1.0530975457E-314;
        r12 = r12.getDimension(r13);
        r13 = r9.getResources();
        r14 = 2131493152; // 0x7f0c0120 float:1.8609776E38 double:1.0530975407E-314;
        r13 = r13.getDimension(r14);
        r14 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r13 = r13 * r14;
        r12 = r12 + r13;
        r11 = r11 / r12;
        r12 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1));
        if (r11 < 0) goto L_0x01af;
    L_0x0159:
        if (r0 <= r10) goto L_0x01af;
    L_0x015b:
        r0 = 1;
        r5.lKy = r0;
    L_0x015e:
        r0 = r9.getResources();
        r11 = 2131493152; // 0x7f0c0120 float:1.8609776E38 double:1.0530975407E-314;
        r0 = r0.getDimension(r11);
        r11 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r11 = r11 * r0;
        r0 = r5.lKy;
        if (r0 == 0) goto L_0x01b3;
    L_0x0170:
        r0 = r9.getResources();
        r5 = 2131493162; // 0x7f0c012a float:1.8609796E38 double:1.0530975457E-314;
        r0 = r0.getDimension(r5);
    L_0x017b:
        r0 = r0 + r11;
        r0 = (int) r0;
        r5 = (float) r10;
        r9 = r9.getResources();
        r10 = 2131493143; // 0x7f0c0117 float:1.8609758E38 double:1.0530975363E-314;
        r9 = r9.getDimension(r10);
        r10 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r9 = r9 * r10;
        r5 = r5 - r9;
        r0 = (float) r0;
        r0 = r5 / r0;
        r0 = (int) r0;
        r5 = "MicroMsg.ContactsListArchAdapter";
        r9 = "[getWrapColNum] :%s";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r12 = java.lang.Integer.valueOf(r0);
        r10[r11] = r12;
        com.tencent.mm.sdk.platformtools.v.i(r5, r9, r10);
        com.tencent.mm.pluginsdk.ui.applet.e.lJX = r0;
        r5 = 4;
        if (r0 != r5) goto L_0x00c5;
    L_0x01a9:
        r5 = 43;
        com.tencent.mm.pluginsdk.ui.applet.e.lJW = r5;
        goto L_0x00c5;
    L_0x01af:
        r0 = 0;
        r5.lKy = r0;
        goto L_0x015e;
    L_0x01b3:
        r0 = r9.getResources();
        r5 = 2131493160; // 0x7f0c0128 float:1.8609792E38 double:1.0530975447E-314;
        r0 = r0.getDimension(r5);
        goto L_0x017b;
    L_0x01bf:
        if (r7 == 0) goto L_0x0008;
    L_0x01c1:
        r0 = new com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference;
        r2 = r15.context;
        r0.<init>(r2);
        r2 = -2;
        r2 = tT(r2);
        r0.setKey(r2);
        r2 = r15.iHK;
        r0.setCustomView(r2);
        r2 = r15.lJQ;
        r0.iqU = r2;
        r2 = r15.dxf;
        r1 = r1 + r6;
        r2.a(r0, r1);
        r1 = r15.lJJ;
        r2 = r0.dnU;
        r1.put(r2, r0);
        goto L_0x0008;
    L_0x01e8:
        r4 = r0;
        goto L_0x00b2;
    L_0x01eb:
        r7 = r2;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.applet.d.aIO():void");
    }
}
