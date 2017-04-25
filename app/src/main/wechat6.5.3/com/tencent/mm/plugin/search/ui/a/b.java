package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.storage.u;
import java.util.List;

public abstract class b extends com.tencent.mm.ui.f.a.a {
    public h eAt;
    public CharSequence eAu;
    public CharSequence eAv;
    public u euW;
    public List<String> ezU;
    a iIL = new a(this);
    public String username;

    public class a extends com.tencent.mm.ui.f.a.a.a {
        public View dtW;
        public ImageView dtX;
        public TextView dtY;
        public TextView dtZ;
        final /* synthetic */ b iIM;

        public a(b bVar) {
            this.iIM = bVar;
            super(bVar);
        }
    }

    public abstract class b extends com.tencent.mm.ui.f.a.a.b {
        final /* synthetic */ b iIM;

        public b(b bVar) {
            this.iIM = bVar;
            super(bVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130903677, viewGroup, false);
            inflate.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, 1073741824));
            a aVar = this.iIM.iIL;
            aVar.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar.dtY = (TextView) inflate.findViewById(2131755456);
            aVar.dtZ = (TextView) inflate.findViewById(2131755458);
            aVar.dtW = inflate.findViewById(2131757157);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar, com.tencent.mm.ui.f.a.a aVar2) {
            a aVar3 = (a) aVar;
            b bVar = (b) aVar2;
            cY(aVar3.dtW);
            com.tencent.mm.pluginsdk.ui.a.b.m(aVar3.dtX, bVar.username);
            com.tencent.mm.modelsearch.h.b(bVar.eAu, aVar3.dtY);
            com.tencent.mm.modelsearch.h.b(bVar.eAv, aVar3.dtZ);
        }
    }

    public b(int i) {
        super(1, i);
    }

    public final int YM() {
        return this.eAt.cWA;
    }
}
