package com.tencent.mm.ui.tools.a;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class c extends a {
    private String dVK;
    public int oSS;
    private int oWA;
    private int oWB;
    private ArrayList<InputFilter> oWC;
    private a oWD;
    public boolean oWy = true;
    private WeakReference<EditText> oWz;

    public interface a {
        void adq();

        void adr();

        void qK(String str);
    }

    private c(WeakReference<EditText> weakReference) {
        this.oWz = weakReference;
        this.oSS = com.tencent.mm.ui.tools.h.a.oSU;
        this.oWy = false;
    }

    public static c b(EditText editText) {
        return new c(new WeakReference(editText));
    }

    public final c dw(int i, int i2) {
        this.oWB = i;
        this.oWA = i2;
        return this;
    }

    public final c yn(int i) {
        this.oWB = 0;
        this.oWA = i;
        return this;
    }

    public final void a(a aVar) {
        this.oWD = aVar;
        bqC();
    }

    protected final int QH() {
        Object obj;
        if (be.kS(this.dVK)) {
            if (this.oWz == null) {
                return 1;
            }
            this.dVK = ((EditText) this.oWz.get()).getText().toString().trim();
        }
        int cn = h.cn(this.dVK, this.oSS);
        if (cn < 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            v.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
            return 2;
        } else if (cn < this.oWB) {
            return 1;
        } else {
            if (cn > this.oWA) {
                return 2;
            }
            return 0;
        }
    }

    protected final void bqC() {
        if (!this.oWy) {
            if (this.oWz == null) {
                v.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
                return;
            } else if (be.bP(this.oWC)) {
                ((EditText) this.oWz.get()).setFilters(new InputFilter[]{new h(this.oWA, this.oSS)});
            } else {
                this.oWC.add(new h(this.oWA, this.oSS));
                ((EditText) this.oWz.get()).setFilters((InputFilter[]) this.oWC.toArray(new InputFilter[this.oWC.size()]));
            }
        }
        if (this.oWD != null) {
            switch (QH()) {
                case 0:
                    this.oWD.qK(this.dVK);
                    return;
                case 1:
                    this.oWD.adq();
                    return;
                case 2:
                    this.oWD.adr();
                    return;
                default:
                    return;
            }
        }
    }
}
