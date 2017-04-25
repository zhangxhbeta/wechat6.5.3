package com.tencent.mm.plugin.sns.a.a;

import android.view.View;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    long cZw = 0;
    public String cZx = "";
    boolean eDI = false;
    public int fEU = 0;
    public int hGO = 1;
    public int jbA = 0;
    public int jbB;
    private View jbC;
    private int jbD = 0;
    private com.tencent.mm.plugin.sns.storage.a jbE = null;
    private String jbF = "";
    int jbG = -10086;
    private int jbH = -10086;
    int jbI = -10086;
    private int jbJ = -10086;
    long jbK = 0;
    long jbL = 0;
    private int jbM = -10086;
    private int jbN = -10086;
    long jbO = 0;
    private int jbP = -10086;
    private int jbQ = -10086;
    long jbR = 0;
    private int jbS = -10086;
    private int jbT = -10086;
    long jbU = 0;
    private int jbV = -10086;
    private int jbW = -10086;
    long jbX = 0;
    int jbY = 0;
    int jbZ = -1;
    boolean jbv = false;
    public awa jbw;
    public View jbx;
    public View jby;
    public int jbz = 0;
    int jca = -1;
    int jcb = 0;
    int jcc = 0;
    int position = 0;

    public a(com.tencent.mm.plugin.sns.storage.a aVar, long j, View view, int i, View view2, int i2, int i3, awa com_tencent_mm_protocal_c_awa, int i4) {
        this.position = i4;
        this.jbx = view;
        this.jbw = com_tencent_mm_protocal_c_awa;
        this.jbE = aVar;
        this.hGO = i3;
        this.jbF = aVar == null ? "" : be.ah(aVar.jbF, "");
        this.cZx = aVar == null ? "" : be.ah(aVar.jpt, "");
        this.cZw = j;
        this.jbB = i;
        this.jbC = view2;
        this.jbD = i2;
        if (this.jbx != null) {
            this.jby = this.jbx.findViewById(2131759475);
        }
        NI();
    }

    private void NI() {
        if (this.fEU == 0) {
            b.a(this.jbx.getContext(), 50.0f);
            this.fEU = this.jbx.getHeight();
            if (this.jby != null) {
                this.jbz = this.jby.getHeight();
            }
            if (this.fEU != 0) {
                int i = 0;
                if (this.jbC != null) {
                    i = this.jbC.getBottom();
                }
                this.jbA = this.fEU / 2;
                this.jbB = (this.jbB - i) - this.jbD;
                v.i("MicroMsg.AdViewStatic", "viewHeight " + this.fEU + " SCREEN_HEIGHT: " + this.jbB + " abottom: " + i + " stHeight: " + this.jbD + " commentViewHeight:" + this.jbz);
            }
        }
    }

    public final void aQT() {
        boolean z = true;
        if (this.jbx != null) {
            NI();
            if (!this.eDI && this.fEU > 0) {
                int i;
                int i2;
                this.jbv = true;
                int top = this.jbx.getTop();
                int bottom = this.jbx.getBottom();
                if (this.jbG == -10086 && this.jbH == -10086) {
                    this.jbG = top;
                    this.jbH = bottom;
                }
                this.jbI = top;
                this.jbJ = bottom;
                if (top < 0) {
                    i = top + this.fEU;
                    int i3 = this.fEU - i;
                    if (i < this.jbA || this.jbM != -10086) {
                        boolean z2 = true;
                    } else {
                        this.jbM = top;
                        this.jbN = bottom;
                        this.jbO = System.currentTimeMillis();
                        v.i("MicroMsg.AdViewStatic", "up first touch half" + i + " top " + top + " viewhieght " + this.fEU + " inscreenval: " + i + " outscreenval: " + i3);
                        i2 = 0;
                    }
                    if (i3 >= this.jbA && this.jbP == -10086 && r0 != 0 && this.jbO > 0) {
                        this.jbP = top;
                        this.jbQ = bottom;
                        this.jbR = System.currentTimeMillis();
                        v.i("MicroMsg.AdViewStatic", "down first touch half" + i + " bottom " + bottom + " viewhieght " + this.fEU + " inscreenval: " + i + " outscreenval: " + i3);
                    }
                }
                if (bottom > this.jbB) {
                    i2 = bottom - this.jbB;
                    i = this.fEU - i2;
                    if (i >= this.jbA && this.jbM == -10086) {
                        this.jbM = top;
                        this.jbN = bottom;
                        this.jbO = System.currentTimeMillis();
                        v.i("MicroMsg.AdViewStatic", "up first touch half" + i2 + " top " + top + " viewhieght " + this.fEU + " inscreenval: " + i + " outscreenval: " + i2);
                        z = false;
                    }
                    if (i2 >= this.jbA && this.jbP == -10086 && r2 && this.jbO > 0) {
                        this.jbP = top;
                        this.jbQ = bottom;
                        this.jbR = System.currentTimeMillis();
                        v.i("MicroMsg.AdViewStatic", "down first touch half" + i2 + " bottom " + bottom + " viewhieght " + this.fEU + " inscreenval: " + i + " outscreenval: " + i2);
                    }
                }
                if (top < 0 || bottom > this.jbB) {
                    if (this.jbX == 0 && this.jbU != 0) {
                        this.jbV = top;
                        this.jbW = bottom;
                        this.jbX = System.currentTimeMillis();
                    }
                } else if (this.jbU == 0) {
                    this.jbS = top;
                    this.jbT = bottom;
                    this.jbU = System.currentTimeMillis();
                }
                if (top < 0) {
                    i2 = -top;
                    if (this.jbZ == -1 || this.jbZ > i2) {
                        this.jbZ = i2;
                    }
                } else {
                    this.jbZ = 0;
                }
                if (bottom > this.jbB) {
                    i2 = bottom - this.jbB;
                    if (this.jca == -1 || this.jca > i2) {
                        this.jca = i2;
                    }
                } else {
                    this.jca = 0;
                }
                i2 = this.fEU;
                if (top < 0) {
                    i2 += top;
                }
                if (bottom > this.jbB) {
                    i2 -= bottom - this.jbB;
                }
                if (this.jbY == -1 || this.jbY < i2) {
                    this.jbY = i2;
                }
            }
        }
    }
}
