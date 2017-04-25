package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;

public final class e {
    private final d[] cmm = new d[3];
    private final Object mLock = new Object();
    private int vO;

    public final d vM() {
        d dVar = null;
        synchronized (this.mLock) {
            if (this.vO > 0) {
                int i = this.vO - 1;
                dVar = this.cmm[i];
                this.cmm[i] = null;
                this.vO--;
            }
        }
        return dVar;
    }

    public final boolean a(d dVar) {
        synchronized (this.mLock) {
            boolean z;
            for (int i = 0; i < this.vO; i++) {
                if (this.cmm[i] == dVar) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                throw new IllegalStateException("Already in the pool!");
            }
            dVar.clZ = null;
            dVar.cma = null;
            dVar.cmb = 0;
            dVar.cmc = 0;
            dVar.cmd = new TextPaint();
            dVar.width = 0;
            dVar.cme = Alignment.ALIGN_NORMAL;
            dVar.gravity = 51;
            dVar.cmf = null;
            dVar.cmg = 0;
            dVar.maxLines = Integer.MAX_VALUE;
            dVar.cmh = null;
            dVar.cmi = 0.0f;
            dVar.cmj = 1.0f;
            dVar.cmk = false;
            dVar.maxLength = 0;
            dVar.cml = null;
            if (this.vO < this.cmm.length) {
                this.cmm[this.vO] = dVar;
                this.vO++;
                return true;
            }
            return false;
        }
    }
}
