package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.ah;

public final class f {
    public int fah;
    public ol fai;
    public oc faj;
    public int fak;
    public String fal;
    public boolean fam;
    public boolean fan = true;
    public boolean fao = false;
    public int mStatus;
    public int rT;

    public enum a {
        ;

        static {
            fap = 1;
            faq = 2;
            far = new int[]{fap, faq};
        }
    }

    public f(ol olVar) {
        this.fai = olVar;
        this.fah = a.fap;
    }

    public f(oc ocVar) {
        this.faj = ocVar;
        this.fah = a.faq;
    }

    public final void dh(int i) {
        if (i == 7 && this.mStatus == 6 && this.fan) {
            this.fam = true;
        }
        this.mStatus = i;
    }

    public final void a(boolean z, ah ahVar, boolean z2) {
        ol olVar = this.fai;
        if (olVar != null) {
            if (z2) {
                dh(7);
                return;
            }
            boolean a = e.a(olVar);
            boolean b = e.b(olVar);
            boolean bx = olVar == null ? false : e.bx(olVar.mqi, 8);
            boolean isEmpty = TextUtils.isEmpty(olVar.mqg);
            if (!bx || !b) {
                if (!a) {
                    if (!b && (z || !isEmpty)) {
                        this.fak = 1;
                        if (z && ahVar != null) {
                            switch (ahVar.nvd) {
                                case 11:
                                    dh(11);
                                    break;
                                case 12:
                                    dh(4);
                                    break;
                                default:
                                    if (!(ahVar.nvb == 7 || ahVar.nvb == 6 || ahVar.nvb == 3)) {
                                        dh(10);
                                        break;
                                    }
                            }
                        } else if (z) {
                            dh(11);
                        } else {
                            dh(4);
                        }
                    } else {
                        dh(3);
                        this.fak = 0;
                    }
                } else {
                    dh(3);
                    if (b || (!z && isEmpty)) {
                        this.fak = 0;
                    } else {
                        this.fak = 1;
                    }
                }
            } else {
                dh(8);
            }
            if (z && ahVar != null && !be.kS(ahVar.nvf)) {
                this.fai.mqg = ahVar.nvf;
            }
        }
    }
}
