package com.tencent.mm.plugin.card.ui.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c.a;
import com.tencent.mm.ae.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.protocal.c.nd;

public final class h extends f {
    private View eMI;

    public final void NI() {
    }

    public final void update() {
        if (this.eMI == null) {
            this.eMI = ((ViewStub) findViewById(2131755812)).inflate();
        }
        this.eMI.setOnClickListener(this.eMF.abu());
        nd ndVar = this.eMF.abq().Zv().mlf;
        if (TextUtils.isEmpty(ndVar.hQW)) {
            findViewById(2131755792).setVisibility(8);
        } else {
            ((TextView) findViewById(2131755793)).setText(ndVar.hQW);
            findViewById(2131755792).setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(2131755791);
        if (ndVar.mpb == null || ndVar.mpb.size() <= 0 || TextUtils.isEmpty((CharSequence) ndVar.mpb.get(0))) {
            imageView.setVisibility(8);
            return;
        }
        String str = (String) ndVar.mpb.get(0);
        imageView.setVisibility(0);
        a aVar = new a();
        aVar.cPv = e.cnj;
        n.GM();
        aVar.cPN = null;
        aVar.cPu = i.pR(str);
        aVar.cPs = true;
        aVar.cPP = false;
        aVar.cPq = true;
        n.GL().a(str, imageView, aVar.GU());
    }

    public final void acF() {
        if (this.eMI != null) {
            this.eMI.setVisibility(8);
        }
    }
}
