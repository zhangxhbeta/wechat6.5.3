package com.tencent.mm.bc;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class f extends com.tencent.recovery.d.a {
    public static f ned;
    private SharedPreferences cnm;
    private a neb = new a();
    private b nec = new b();

    public static class a {
        public int emv;
        public int nee;
        public int nef;
        public int neg;
        public int neh;
        public int nei;

        public final void JJ(String str) {
            try {
                int[] JI = f.JI(str);
                this.emv = JI[0];
                this.nee = JI[1];
                this.nef = JI[2];
                this.neg = JI[3];
                this.neh = JI[4];
                this.nei = JI[5];
            } catch (Exception e) {
            }
        }

        public final String brR() {
            return f.r(new int[]{this.emv, this.nee, this.nef, this.neg, this.neh, this.nei});
        }

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.emv > 0) {
                stringBuffer.append("totalCount:" + this.emv + " ");
            }
            if (this.nee > 0) {
                stringBuffer.append("enterRecoveryCount:" + this.nee + " ");
            }
            if (this.nef > 0) {
                stringBuffer.append("existRecoveryProcessCount:" + this.nef + " ");
            }
            if (this.neg > 0) {
                stringBuffer.append("foregroundExpCount:" + this.neg + " ");
            }
            if (this.neh > 0) {
                stringBuffer.append("backgroundExpCount:" + this.neh + " ");
            }
            if (this.nei > 0) {
                stringBuffer.append("normalCount:" + this.nei + " ");
            }
            return stringBuffer.toString();
        }
    }

    public static class b {
        public int nej;
        public int nek;
        public int nel;
        public int nem;
        public int nen;
        public int neo;
        public int nep;
        public int neq;
        public int ner;
        public int nes;
        public int neu;
        public int nev;

        public final void JJ(String str) {
            try {
                int[] JI = f.JI(str);
                this.nej = JI[0];
                this.nek = JI[1];
                this.nel = JI[2];
                this.nem = JI[3];
                this.nen = JI[4];
                this.neo = JI[5];
                this.nep = JI[6];
                this.neq = JI[7];
                this.ner = JI[8];
                this.nes = JI[9];
                this.neu = JI[10];
                this.nev = JI[11];
            } catch (Exception e) {
            }
        }

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.nej > 0) {
                stringBuffer.append("appForegroundExpCount:" + this.nej + " ");
            }
            if (this.nek > 0) {
                stringBuffer.append("appBackgroundExpCount:" + this.nek + " ");
            }
            if (this.nel > 0) {
                stringBuffer.append("componentForegroundExpCount:" + this.nel + " ");
            }
            if (this.nem > 0) {
                stringBuffer.append("componentBackgroundExpCount:" + this.nem + " ");
            }
            if (this.nen > 0) {
                stringBuffer.append("appForegroundCrashOrAnrExpCount:" + this.nen + " ");
            }
            if (this.neo > 0) {
                stringBuffer.append("appBackgroundCrashOrAnrExpCount:" + this.neo + " ");
            }
            if (this.nep > 0) {
                stringBuffer.append("componentForegroundCrashOrAnrExpCount:" + this.nep + " ");
            }
            if (this.neq > 0) {
                stringBuffer.append("componentBackgroundCrashOrAnrExpCount:" + this.neq + " ");
            }
            if (this.ner > 0) {
                stringBuffer.append("appForegroundTimeoutExpCount:" + this.ner + " ");
            }
            if (this.nes > 0) {
                stringBuffer.append("appBackgroundTimeoutExpCount:" + this.nes + " ");
            }
            if (this.neu > 0) {
                stringBuffer.append("componentForegroundTimeoutExpCount:" + this.neu + " ");
            }
            if (this.nev > 0) {
                stringBuffer.append("componentBackgroundTimeoutExpCount:" + this.nev + " ");
            }
            return stringBuffer.toString();
        }
    }

    private void brP() {
        if (this.cnm == null) {
            this.cnm = aa.getContext().getSharedPreferences(aa.getProcessName() + "_recovery_statics", 0);
            this.neb.JJ(this.cnm.getString("KeyGeneralObj", SQLiteDatabase.KeyEmpty));
            this.nec.JJ(this.cnm.getString("KeyStatusObj", SQLiteDatabase.KeyEmpty));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.recovery.model.RecoveryExceptionItem r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r7.brP();
        r0 = r7.neb;
        r3 = r0.emv;
        r3 = r3 + 1;
        r0.emv = r3;
        r3 = r8.pua;
        if (r3 == 0) goto L_0x008e;
    L_0x0011:
        r3 = r0.neg;
        r3 = r3 + 1;
        r0.neg = r3;
    L_0x0017:
        r0 = r7.nec;
        r3 = r8.dyp;
        switch(r3) {
            case 1: goto L_0x0095;
            case 2: goto L_0x00d7;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = r2;
    L_0x001f:
        if (r0 != 0) goto L_0x002a;
    L_0x0021:
        r0 = "MicroMsg.Recovery.WXRecoveryReporter";
        r3 = "recovery statics not set exception";
        com.tencent.mm.sdk.platformtools.v.i(r0, r3);
    L_0x002a:
        r0 = r7.cnm;
        r0 = r0.edit();
        r3 = r7.neb;
        r3 = r3.brR();
        r4 = r7.nec;
        r5 = 12;
        r5 = new int[r5];
        r6 = r4.nej;
        r5[r2] = r6;
        r2 = r4.nek;
        r5[r1] = r2;
        r1 = 2;
        r2 = r4.nel;
        r5[r1] = r2;
        r1 = 3;
        r2 = r4.nem;
        r5[r1] = r2;
        r1 = 4;
        r2 = r4.nen;
        r5[r1] = r2;
        r1 = 5;
        r2 = r4.neo;
        r5[r1] = r2;
        r1 = 6;
        r2 = r4.nep;
        r5[r1] = r2;
        r1 = 7;
        r2 = r4.neq;
        r5[r1] = r2;
        r1 = 8;
        r2 = r4.ner;
        r5[r1] = r2;
        r1 = 9;
        r2 = r4.nes;
        r5[r1] = r2;
        r1 = 10;
        r2 = r4.neu;
        r5[r1] = r2;
        r1 = 11;
        r2 = r4.nev;
        r5[r1] = r2;
        r1 = r(r5);
        r2 = "KeyGeneralObj";
        r0.putString(r2, r3);
        r2 = "KeyStatusObj";
        r0.putString(r2, r1);
        r0.commit();
        return;
    L_0x008e:
        r3 = r0.neh;
        r3 = r3 + 1;
        r0.neh = r3;
        goto L_0x0017;
    L_0x0095:
        r3 = r8.pua;
        if (r3 == 0) goto L_0x00b8;
    L_0x0099:
        r3 = r0.nej;
        r3 = r3 + 1;
        r0.nej = r3;
        r3 = r8.type;
        switch(r3) {
            case 21: goto L_0x00a6;
            case 22: goto L_0x00af;
            case 23: goto L_0x00af;
            default: goto L_0x00a4;
        };
    L_0x00a4:
        goto L_0x001e;
    L_0x00a6:
        r3 = r0.ner;
        r3 = r3 + 1;
        r0.ner = r3;
        r0 = r1;
        goto L_0x001f;
    L_0x00af:
        r3 = r0.nen;
        r3 = r3 + 1;
        r0.nen = r3;
        r0 = r1;
        goto L_0x001f;
    L_0x00b8:
        r3 = r0.nek;
        r3 = r3 + 1;
        r0.nek = r3;
        r3 = r8.type;
        switch(r3) {
            case 21: goto L_0x00c5;
            case 22: goto L_0x00ce;
            case 23: goto L_0x00ce;
            default: goto L_0x00c3;
        };
    L_0x00c3:
        goto L_0x001e;
    L_0x00c5:
        r3 = r0.nes;
        r3 = r3 + 1;
        r0.nes = r3;
        r0 = r1;
        goto L_0x001f;
    L_0x00ce:
        r3 = r0.neo;
        r3 = r3 + 1;
        r0.neo = r3;
        r0 = r1;
        goto L_0x001f;
    L_0x00d7:
        r3 = r8.pua;
        if (r3 == 0) goto L_0x00fa;
    L_0x00db:
        r3 = r0.nel;
        r3 = r3 + 1;
        r0.nel = r3;
        r3 = r8.type;
        switch(r3) {
            case 21: goto L_0x00e8;
            case 22: goto L_0x00f1;
            case 23: goto L_0x00f1;
            default: goto L_0x00e6;
        };
    L_0x00e6:
        goto L_0x001e;
    L_0x00e8:
        r3 = r0.neu;
        r3 = r3 + 1;
        r0.neu = r3;
        r0 = r1;
        goto L_0x001f;
    L_0x00f1:
        r3 = r0.nep;
        r3 = r3 + 1;
        r0.nep = r3;
        r0 = r1;
        goto L_0x001f;
    L_0x00fa:
        r3 = r0.nem;
        r3 = r3 + 1;
        r0.nem = r3;
        r3 = r8.type;
        switch(r3) {
            case 21: goto L_0x0107;
            case 22: goto L_0x0110;
            case 23: goto L_0x0110;
            default: goto L_0x0105;
        };
    L_0x0105:
        goto L_0x001e;
    L_0x0107:
        r3 = r0.nev;
        r3 = r3 + 1;
        r0.nev = r3;
        r0 = r1;
        goto L_0x001f;
    L_0x0110:
        r3 = r0.neq;
        r3 = r3 + 1;
        r0.neq = r3;
        r0 = r1;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.bc.f.a(com.tencent.recovery.model.RecoveryExceptionItem):void");
    }

    public final void brQ() {
        brP();
        a aVar = this.neb;
        aVar.emv++;
        aVar.nei++;
        Editor edit = this.cnm.edit();
        edit.putString("KeyGeneralObj", this.neb.brR());
        edit.commit();
    }

    public final void uS(int i) {
        brP();
        a aVar = this.neb;
        if (i == 0) {
            aVar.nee++;
        } else {
            aVar.nef++;
        }
        Editor edit = this.cnm.edit();
        edit.putString("KeyGeneralObj", this.neb.brR());
        edit.commit();
    }

    public static int[] JI(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String[] split = str.split(",");
        if (split == null || split.length <= 0) {
            return null;
        }
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                iArr[i] = Integer.valueOf(split[i]).intValue();
            } catch (Exception e) {
            }
        }
        return iArr;
    }

    public static String r(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (iArr.length > 0) {
            for (int valueOf : iArr) {
                stringBuffer.append(Integer.valueOf(valueOf));
                stringBuffer.append(" ");
            }
            stringBuffer.trimToSize();
        }
        return stringBuffer.toString().replace(" ", ",");
    }
}
