package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.h;
import java.util.List;

public final class c extends com.tencent.mm.ui.f.a.a {
    public int actionType = -1;
    public h eAt;
    public List<String> ezU;
    public CharSequence fRY;
    public String fSb;
    public CharSequence iIN;
    public String iIO;
    public com.tencent.mm.plugin.search.a.b iIP;
    private b iIQ = new b(this);
    a iIR = new a(this);

    public class a extends com.tencent.mm.ui.f.a.a.a {
        public View dtW;
        public ImageView dtX;
        public TextView dtY;
        public TextView dtZ;
        final /* synthetic */ c iIS;

        public a(c cVar) {
            this.iIS = cVar;
            super(cVar);
        }
    }

    public class b extends com.tencent.mm.ui.f.a.a.b {
        final /* synthetic */ c iIS;

        public b(c cVar) {
            this.iIS = cVar;
            super(cVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130903677, viewGroup, false);
            inflate.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, 1073741824));
            a aVar = this.iIS.iIR;
            aVar.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar.dtY = (TextView) inflate.findViewById(2131755456);
            aVar.dtZ = (TextView) inflate.findViewById(2131755458);
            aVar.dtW = inflate.findViewById(2131757157);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar, com.tencent.mm.ui.f.a.a aVar2) {
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            cY(aVar3.dtW);
            com.tencent.mm.modelsearch.h.b(this.iIS.fRY, aVar3.dtY);
            com.tencent.mm.modelsearch.h.b(this.iIS.iIN, aVar3.dtZ);
            com.tencent.mm.modelsearch.h.a(context, aVar3.dtX, null, cVar.fSb, 2131165590);
        }

        public final boolean a(Context context, com.tencent.mm.ui.f.a.a aVar) {
            c cVar = (c) aVar;
            p.b(this.iIS.bkC, cVar.eAt, 0);
            if (!(com.tencent.mm.t.a.gq(cVar.iIP.field_url) || com.tencent.mm.plugin.search.a.b.B(context, cVar.iIP.field_featureId))) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", cVar.iIP.field_url);
                com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            }
            return true;
        }
    }

    public c(int i) {
        super(3, i);
    }

    public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar) {
        com.tencent.mm.plugin.search.a.b bVar;
        Object obj = 1;
        com.tencent.mm.plugin.search.a.b.b bVar2 = (com.tencent.mm.plugin.search.a.b.b) p.gd(17);
        Cursor rawQuery = bVar2.cUY.rawQuery("Select * from Feature where featureId = " + Integer.valueOf(this.eAt.cWv).intValue(), null);
        if (rawQuery.moveToFirst()) {
            bVar = new com.tencent.mm.plugin.search.a.b();
            bVar.b(rawQuery);
            rawQuery.close();
        } else {
            bVar = null;
        }
        this.iIP = bVar;
        if (this.iIP != null) {
            boolean z;
            this.fRY = this.iIP.field_title;
            this.iIN = this.iIP.field_tag;
            this.fSb = this.iIP.field_iconPath;
            this.iIO = this.iIP.field_androidUrl;
            this.actionType = this.iIP.field_actionType;
            switch (this.eAt.cWt) {
                case 1:
                    obj = null;
                    z = false;
                    break;
                case 2:
                    z = false;
                    break;
                case 3:
                    z = true;
                    break;
                case 4:
                    this.iIN = com.tencent.mm.modelsearch.h.a(context, this.iIN, this.ezU);
                    return;
                default:
                    return;
            }
            if (obj != null) {
                this.fRY = com.tencent.mm.modelsearch.h.a(this.fRY, this.ezU, z, this.bkC);
            } else {
                this.fRY = com.tencent.mm.modelsearch.h.a(this.fRY, this.ezU, this.bkC, this.eAt);
            }
        }
    }

    public final com.tencent.mm.ui.f.a.a.b YL() {
        return this.iIQ;
    }

    public final String asE() {
        return this.iIP.field_title;
    }

    public final int YM() {
        return this.eAt.cWA;
    }
}
