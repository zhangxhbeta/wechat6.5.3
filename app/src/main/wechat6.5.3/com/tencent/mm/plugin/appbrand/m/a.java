package com.tencent.mm.plugin.appbrand.m;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.plugin.appbrand.appcache.c;
import com.tencent.mm.sdk.platformtools.be;
import java.util.List;

public final class a extends com.tencent.mm.ui.f.a.a {
    public h eAt;
    public List<String> ezU;
    public CharSequence lQt;
    public com.tencent.mm.plugin.appbrand.b.b nPG;
    private b ovR = new b(this);
    a ovV = new a(this);

    public class a extends com.tencent.mm.ui.f.a.a.a {
        public View dtW;
        public ImageView dtX;
        public TextView dtY;
        public TextView ovW;
        public TextView ovZ;
        final /* synthetic */ a owa;

        public a(a aVar) {
            this.owa = aVar;
            super(aVar);
        }
    }

    public class b extends com.tencent.mm.ui.f.a.a.b {
        final /* synthetic */ a owa;

        public b(a aVar) {
            this.owa = aVar;
            super(aVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130904720, viewGroup, false);
            a aVar = this.owa.ovV;
            aVar.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar.dtY = (TextView) inflate.findViewById(2131755456);
            aVar.dtW = inflate.findViewById(2131757157);
            aVar.ovW = (TextView) inflate.findViewById(2131755367);
            aVar.ovZ = (TextView) inflate.findViewById(2131755368);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar, com.tencent.mm.ui.f.a.a aVar2) {
            int i;
            int i2 = 1;
            a aVar3 = (a) aVar2;
            a aVar4 = (a) aVar;
            aVar4.dtY.setText(this.owa.lQt);
            int i3 = this.owa.nPG.dzx;
            long j = this.owa.nPG.dBG;
            if ((1 & j) > 0) {
                i = 2131230986;
            } else if ((j & 2) > 0) {
                i = 2131230985;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 == 0 || i3 != 0) {
                aVar4.dtX.setColorFilter(null);
            } else {
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(0.0f);
                aVar4.dtX.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                aVar4.ovW.setVisibility(0);
                aVar4.ovW.setText(i);
            }
            CharSequence gX = c.gX(this.owa.nPG.dzx);
            if (be.kS(gX)) {
                aVar4.ovZ.setVisibility(8);
            } else {
                aVar4.ovZ.setText(gX);
                aVar4.ovZ.setVisibility(0);
            }
            com.tencent.mm.t.a.b.AL().a(aVar4.dtX, aVar3.nPG.dBD, com.tencent.mm.t.a.a.AK(), com.tencent.mm.t.a.c.cxH);
        }

        public final boolean a(Context context, com.tencent.mm.ui.f.a.a aVar) {
            a aVar2 = (a) aVar;
            ok okVar = new ok();
            okVar.bpu.userName = aVar2.nPG.aWH;
            okVar.bpu.bpx = aVar2.nPG.dzx;
            okVar.bpu.bpA = true;
            com.tencent.mm.sdk.c.a.nhr.z(okVar);
            return true;
        }
    }

    public a(int i) {
        super(16, i);
    }

    public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar) {
        String str;
        boolean z = true;
        boolean z2 = false;
        this.nPG = com.tencent.mm.plugin.appbrand.a.a.dzS.Rl(this.eAt.cWv);
        switch (this.eAt.cWt) {
            case 2:
                break;
            case 3:
                z2 = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            this.lQt = com.tencent.mm.modelsearch.h.a(this.nPG.appName, this.ezU, z2, this.bkC);
        } else {
            this.lQt = com.tencent.mm.modelsearch.h.a(this.nPG.appName, this.ezU, this.bkC, this.eAt);
        }
        if (this.nPG == null) {
            str = "";
        } else {
            str = this.nPG.aWH;
        }
        this.info = str;
    }

    public final com.tencent.mm.ui.f.a.a.b YL() {
        return this.ovR;
    }

    public final String asE() {
        return this.nPG.appName;
    }

    public final int YM() {
        return this.eAt.cWA;
    }
}
