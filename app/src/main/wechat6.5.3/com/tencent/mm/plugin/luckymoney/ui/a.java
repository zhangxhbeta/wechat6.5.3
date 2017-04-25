package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private List<b> hfo = new LinkedList();
    private boolean hfp = false;
    private boolean hfq = false;
    private TextView hfr;

    public final void a(b bVar) {
        if (bVar != null) {
            this.hfo.add(bVar);
        }
    }

    public final void f(TextView textView) {
        if (textView != null) {
            this.hfr = textView;
        }
    }

    public final void clear() {
        this.hfo.clear();
        this.hfr = null;
    }

    public final boolean ayl() {
        this.hfq = false;
        this.hfp = false;
        for (int i = 0; i < this.hfo.size(); i++) {
            b bVar = (b) this.hfo.get(i);
            int ayn = bVar.ayn();
            if (ayn != 0) {
                bVar.onError();
                CharSequence mE = bVar.mE(ayn);
                if (!(this.hfr == null || be.kS(mE))) {
                    if (!this.hfp) {
                        this.hfr.setText(mE);
                    }
                    this.hfr.setVisibility(0);
                    this.hfp = true;
                }
                this.hfq = true;
            } else {
                bVar.restore();
            }
        }
        if (!(this.hfq || this.hfr == null)) {
            this.hfr.setVisibility(8);
            this.hfp = false;
        }
        return this.hfq;
    }

    public final boolean aym() {
        for (int i = 0; i < this.hfo.size(); i++) {
            if (((b) this.hfo.get(i)).ayn() != 0) {
                return true;
            }
        }
        return false;
    }

    public final void wf(String str) {
        if (this.hfr != null && !be.kS(str)) {
            this.hfr.setText(str);
            this.hfr.setVisibility(0);
            this.hfp = true;
        } else if (this.hfr != null) {
            this.hfr.setVisibility(8);
            this.hfp = false;
        }
    }
}
