package com.tencent.mm.ui.friend;

import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.protocal.c.aka;
import com.tencent.mm.protocal.c.qy;
import java.util.LinkedList;

final class b extends BaseAdapter {
    private LinkedList<aka> cqE;
    private boolean[] dxc;
    private final LayoutInflater gwU;
    LinkedList<qy> oNS;
    boolean oNT;

    static class a {
        TextView dxd;
        CheckBox dxe;
        TextView eVA;
        TextView exG;
        TextView oNU;
        int type;

        a() {
        }
    }

    public b(LayoutInflater layoutInflater) {
        this.gwU = layoutInflater;
    }

    public final void gO(int i) {
        if (i >= 0 && i < this.dxc.length) {
            this.dxc[i] = !this.dxc[i];
            super.notifyDataSetChanged();
        }
    }

    public final void e(LinkedList<aka> linkedList, int i) {
        if (i < 0) {
            this.cqE = linkedList;
        } else {
            this.cqE = new LinkedList();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                if (i == ((aka) linkedList.get(i2)).muJ) {
                    this.cqE.add(linkedList.get(i2));
                }
            }
        }
        this.dxc = new boolean[this.cqE.size()];
    }

    public final String[] bIF() {
        int i = 0;
        int i2 = 0;
        for (boolean z : this.dxc) {
            if (z) {
                i2++;
            }
        }
        String[] strArr = new String[i2];
        int i3 = 0;
        while (i3 < this.cqE.size()) {
            if (this.dxc[i3]) {
                int i4 = i + 1;
                strArr[i] = ((aka) this.cqE.get(i3)).gln;
                i2 = i4;
            } else {
                i2 = i;
            }
            i3++;
            i = i2;
        }
        return strArr;
    }

    public final int getCount() {
        if (this.oNT) {
            if (this.oNS == null) {
                return 0;
            }
            return this.oNS.size();
        } else if (this.cqE != null) {
            return this.cqE.size();
        } else {
            return 0;
        }
    }

    public final Object getItem(int i) {
        if (this.oNT) {
            return this.oNS.get(i);
        }
        return this.cqE.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
        r8 = this;
        r7 = 1;
        r6 = 2;
        r5 = 0;
        r0 = r8.oNT;
        if (r0 == 0) goto L_0x0049;
    L_0x0007:
        r0 = r8.oNS;
        r0 = r0.get(r9);
        r0 = (com.tencent.mm.protocal.c.qy) r0;
        if (r10 == 0) goto L_0x001b;
    L_0x0011:
        r1 = r10.getTag();
        r1 = (com.tencent.mm.ui.friend.b.a) r1;
        r1 = r1.type;
        if (r1 == r6) goto L_0x0042;
    L_0x001b:
        r1 = r8.gwU;
        r2 = 2130903813; // 0x7f030305 float:1.7414455E38 double:1.0528063686E-314;
        r10 = r1.inflate(r2, r11, r5);
        r2 = new com.tencent.mm.ui.friend.b$a;
        r2.<init>();
        r2.type = r6;
        r1 = 2131757513; // 0x7f1009c9 float:1.9145964E38 double:1.0532281524E-314;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.eVA = r1;
        r10.setTag(r2);
        r1 = r2;
    L_0x003a:
        r1 = r1.eVA;
        r0 = r0.muK;
        r1.setText(r0);
    L_0x0041:
        return r10;
    L_0x0042:
        r1 = r10.getTag();
        r1 = (com.tencent.mm.ui.friend.b.a) r1;
        goto L_0x003a;
    L_0x0049:
        r0 = r8.cqE;
        r0 = r0.get(r9);
        r0 = (com.tencent.mm.protocal.c.aka) r0;
        if (r10 == 0) goto L_0x005d;
    L_0x0053:
        r1 = r10.getTag();
        r1 = (com.tencent.mm.ui.friend.b.a) r1;
        r1 = r1.type;
        if (r1 == r7) goto L_0x00d7;
    L_0x005d:
        r1 = r8.gwU;
        r2 = 2130903812; // 0x7f030304 float:1.7414453E38 double:1.052806368E-314;
        r10 = r1.inflate(r2, r11, r5);
        r2 = new com.tencent.mm.ui.friend.b$a;
        r2.<init>();
        r2.type = r7;
        r1 = 2131757511; // 0x7f1009c7 float:1.914596E38 double:1.0532281514E-314;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.exG = r1;
        r1 = 2131757512; // 0x7f1009c8 float:1.9145962E38 double:1.053228152E-314;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.oNU = r1;
        r1 = 2131756898; // 0x7f100762 float:1.9144717E38 double:1.0532278486E-314;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.CheckBox) r1;
        r2.dxe = r1;
        r1 = 2131756897; // 0x7f100761 float:1.9144714E38 double:1.053227848E-314;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.dxd = r1;
        r10.setTag(r2);
        r1 = r2;
    L_0x009d:
        r2 = com.tencent.mm.modelfriend.ah.FP();
        r3 = r0.gln;
        r2 = r2.iK(r3);
        if (r2 == 0) goto L_0x00de;
    L_0x00a9:
        r2 = r1.dxd;
        r2.setVisibility(r5);
    L_0x00ae:
        r3 = r1.exG;
        if (r0 == 0) goto L_0x010d;
    L_0x00b2:
        r2 = r0.mnX;
        if (r2 == 0) goto L_0x00e6;
    L_0x00b6:
        r4 = r2.length();
        if (r4 <= 0) goto L_0x00e6;
    L_0x00bc:
        r3.setText(r2);
        r2 = r1.oNU;
        if (r0 == 0) goto L_0x0150;
    L_0x00c3:
        r3 = r0.mEk;
        if (r3 != 0) goto L_0x0111;
    L_0x00c7:
        r0 = r0.gln;
    L_0x00c9:
        r2.setText(r0);
        r0 = r1.dxe;
        r1 = r8.dxc;
        r1 = r1[r9];
        r0.setChecked(r1);
        goto L_0x0041;
    L_0x00d7:
        r1 = r10.getTag();
        r1 = (com.tencent.mm.ui.friend.b.a) r1;
        goto L_0x009d;
    L_0x00de:
        r2 = r1.dxd;
        r3 = 8;
        r2.setVisibility(r3);
        goto L_0x00ae;
    L_0x00e6:
        r2 = r0.efy;
        if (r2 == 0) goto L_0x00f0;
    L_0x00ea:
        r4 = r2.length();
        if (r4 > 0) goto L_0x00bc;
    L_0x00f0:
        r2 = new com.tencent.mm.a.o;
        r4 = r0.fvo;
        r2.<init>(r4);
        r2 = r2.toString();
        if (r2 == 0) goto L_0x0103;
    L_0x00fd:
        r4 = r2.length();
        if (r4 > 0) goto L_0x00bc;
    L_0x0103:
        r2 = r0.mgi;
        if (r2 == 0) goto L_0x010d;
    L_0x0107:
        r4 = r2.length();
        if (r4 > 0) goto L_0x00bc;
    L_0x010d:
        r2 = "";
        goto L_0x00bc;
    L_0x0111:
        r3 = r0.mEk;
        if (r3 != r6) goto L_0x0118;
    L_0x0115:
        r0 = r0.gln;
        goto L_0x00c9;
    L_0x0118:
        r3 = r0.mEk;
        if (r3 != r7) goto L_0x0150;
    L_0x011c:
        r0 = r0.gln;
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r3 != 0) goto L_0x0150;
    L_0x0124:
        r3 = "@";
        r0 = r0.split(r3);
        if (r0 == 0) goto L_0x0138;
    L_0x012d:
        r3 = r0.length;
        if (r3 < r6) goto L_0x0138;
    L_0x0130:
        r3 = r0[r5];
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r3);
        if (r3 == 0) goto L_0x013c;
    L_0x0138:
        r0 = "";
        goto L_0x00c9;
    L_0x013c:
        r3 = new java.lang.StringBuilder;
        r4 = "@";
        r3.<init>(r4);
        r0 = r0[r5];
        r0 = r3.append(r0);
        r0 = r0.toString();
        goto L_0x00c9;
    L_0x0150:
        r0 = "";
        goto L_0x00c9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.friend.b.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
