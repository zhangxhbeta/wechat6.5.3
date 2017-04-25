package com.tencent.mm.plugin.game.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.fq;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import java.util.List;

public final class a extends com.tencent.mm.ui.f.a.a {
    public h eAt;
    public List<String> ezU;
    public String fSb;
    public String fSc;
    public f gpF;
    public CharSequence gzu;
    public String gzv;
    private b gzw = new b(this);
    a gzx = new a(this);

    public class a extends com.tencent.mm.ui.f.a.a.a {
        public View dtW;
        public ImageView dtX;
        public TextView dtY;
        public TextView dtZ;
        final /* synthetic */ a gzy;

        public a(a aVar) {
            this.gzy = aVar;
            super(aVar);
        }
    }

    public class b extends com.tencent.mm.ui.f.a.a.b {
        final /* synthetic */ a gzy;

        public b(a aVar) {
            this.gzy = aVar;
            super(aVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130903682, viewGroup, false);
            a aVar = this.gzy.gzx;
            aVar.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar.dtY = (TextView) inflate.findViewById(2131755456);
            aVar.dtZ = (TextView) inflate.findViewById(2131755458);
            aVar.dtW = inflate.findViewById(2131757157);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar, com.tencent.mm.ui.f.a.a aVar2) {
            a aVar3 = (a) aVar2;
            a aVar4 = (a) aVar;
            aVar4.dtY.setText(this.gzy.gzu);
            com.tencent.mm.modelsearch.h.b(this.gzy.gzv, aVar4.dtZ);
            com.tencent.mm.modelsearch.h.a(context, aVar4.dtX, aVar3.fSc, aVar3.fSb, 2131165590, 0, 0);
        }

        public final boolean a(Context context, com.tencent.mm.ui.f.a.a aVar) {
            a aVar2 = (a) aVar;
            fq fqVar = new fq();
            fqVar.beY.context = context;
            fqVar.beY.actionCode = 2;
            fqVar.beY.appId = aVar2.gpF.field_appId;
            fqVar.beY.beZ = "search_src=40";
            fqVar.beY.scene = 4;
            com.tencent.mm.sdk.c.a.nhr.z(fqVar);
            return true;
        }
    }

    public a(int i) {
        super(5, i);
    }

    public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar) {
        this.gpF = am.bnB().Gz(this.eAt.cWv);
        this.gzu = com.tencent.mm.modelsearch.h.a(this.eAt.content, this.ezU, this.bkC, this.eAt);
        this.gzv = this.gpF.bxr;
        am.bnB();
        this.fSb = i.bB(this.gpF.field_appId, 1);
        this.fSc = this.gpF.field_appIconUrl;
    }

    public final com.tencent.mm.ui.f.a.a.b YL() {
        return this.gzw;
    }

    public final String asE() {
        return this.gpF.field_appName;
    }

    public final int YM() {
        return this.eAt.cWA;
    }
}
