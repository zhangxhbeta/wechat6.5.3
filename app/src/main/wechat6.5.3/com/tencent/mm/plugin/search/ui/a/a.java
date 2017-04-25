package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelsearch.h;
import java.util.List;

public final class a extends com.tencent.mm.ui.f.a.a {
    public List<String> ezU;
    public CharSequence iIH;
    private b iII = new b(this);
    private a iIJ = new a(this);

    public class a extends com.tencent.mm.ui.f.a.a.a {
        public View dtW;
        public ImageView eZn;
        final /* synthetic */ a iIK;
        public TextView ijk;

        public a(a aVar) {
            this.iIK = aVar;
            super(aVar);
        }
    }

    public class b extends com.tencent.mm.ui.f.a.a.b {
        final /* synthetic */ a iIK;

        public b(a aVar) {
            this.iIK = aVar;
            super(aVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130903689, viewGroup, false);
            a aVar = new a(this.iIK);
            aVar.eZn = (ImageView) inflate.findViewById(2131756771);
            aVar.ijk = (TextView) inflate.findViewById(2131755314);
            aVar.dtW = inflate.findViewById(2131757157);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar, com.tencent.mm.ui.f.a.a aVar2) {
            a aVar3 = (a) aVar;
            cY(aVar3.dtW);
            h.b(this.iIK.iIH, aVar3.ijk);
            aVar3.eZn.setImageResource(2131165219);
        }

        public final boolean a(Context context, com.tencent.mm.ui.f.a.a aVar) {
            return false;
        }
    }

    public a(int i) {
        super(10, i);
    }

    public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar) {
        this.iIH = TextUtils.concat(new CharSequence[]{context.getResources().getString(2131233000), h.a(context, this.bkC, this.ezU)});
    }

    public final com.tencent.mm.ui.f.a.a.b YL() {
        return this.iII;
    }
}
