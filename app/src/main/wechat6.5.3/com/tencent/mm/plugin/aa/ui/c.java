package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.regex.Pattern;

public final class c extends com.tencent.mm.ui.contact.a.a {
    private static final Pattern cVF = Pattern.compile(",");
    public CharSequence dtS;
    public CharSequence dtT;
    private b dtU = new b(this);
    a dtV = new a(this);
    public String username;

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public View dtW;
        public ImageView dtX;
        public TextView dtY;
        public TextView dtZ;
        public CheckBox dua;
        final /* synthetic */ c dub;

        public a(c cVar) {
            this.dub = cVar;
            super(cVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ c dub;

        public b(c cVar) {
            this.dub = cVar;
            super(cVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            if (com.tencent.mm.bd.a.dt(context)) {
                inflate = LayoutInflater.from(context).inflate(2130904339, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(2130904338, viewGroup, false);
            }
            a aVar = this.dub.dtV;
            aVar.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar.dtY = (TextView) inflate.findViewById(2131755456);
            aVar.dtZ = (TextView) inflate.findViewById(2131755458);
            aVar.dtW = inflate.findViewById(2131758337);
            aVar.dua = (CheckBox) inflate.findViewById(2131755510);
            LayoutParams layoutParams = (LayoutParams) aVar.dua.getLayoutParams();
            layoutParams.leftMargin = context.getResources().getDimensionPixelSize(2131493250);
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(2131493251);
            aVar.dua.setLayoutParams(layoutParams);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            if (cVar.username == null || cVar.username.length() <= 0) {
                aVar3.dtX.setImageResource(2130838080);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.m(aVar3.dtX, cVar.username);
            }
            if (be.D(cVar.dtS)) {
                aVar3.dtY.setVisibility(8);
            } else {
                aVar3.dtY.setText(cVar.dtS);
                aVar3.dtY.setVisibility(0);
            }
            if (be.D(cVar.dtT)) {
                aVar3.dtZ.setVisibility(8);
            } else {
                aVar3.dtZ.setText(cVar.dtT);
                aVar3.dtZ.setVisibility(0);
            }
            if (this.dub.oHa) {
                if (z) {
                    aVar3.dua.setChecked(true);
                    aVar3.dua.setEnabled(false);
                } else {
                    aVar3.dua.setChecked(z2);
                    aVar3.dua.setEnabled(true);
                }
                aVar3.dua.setVisibility(0);
            } else {
                aVar3.dua.setVisibility(8);
            }
            if (this.dub.eyw) {
                aVar3.dtW.setBackgroundResource(2130838048);
            } else {
                aVar3.dtW.setBackgroundResource(2130838046);
            }
            if (cVar.euW.field_deleteFlag == 1) {
                aVar3.dtZ.setVisibility(0);
                aVar3.dtZ.setText(context.getString(2131230829));
            }
        }

        public final boolean NG() {
            return false;
        }
    }

    public c(int i) {
        super(2, i);
    }

    public final void bo(Context context) {
        if (this.euW == null) {
            v.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[]{Integer.valueOf(this.position)});
            return;
        }
        CharSequence c;
        this.username = this.euW.field_username;
        if (be.kS(this.aYF)) {
            c = l.c(this.euW);
        } else {
            c = l.D(this.euW.field_username, this.aYF);
        }
        if (k.xF().equals(this.username)) {
            c = c + context.getString(2131230776);
        }
        this.dtS = e.a(context, c, com.tencent.mm.bd.a.N(context, 2131493169));
    }

    public final com.tencent.mm.ui.contact.a.a.b NE() {
        return this.dtU;
    }

    protected final com.tencent.mm.ui.contact.a.a.a NF() {
        return this.dtV;
    }
}
