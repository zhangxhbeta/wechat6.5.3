package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.l;
import com.tencent.mm.modelsearch.h;
import com.tencent.mmdb.database.SQLiteDatabase;

public class e extends a {
    public CharSequence dtS;
    public CharSequence oJs;
    public int oJt = 0;
    private b oJu = new b(this);
    a oJv = new a(this);
    public String username;

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public ImageView dtX;
        public TextView dtZ;
        public CheckBox dua;
        public TextView euh;
        final /* synthetic */ e oJw;

        public a(e eVar) {
            this.oJw = eVar;
            super(eVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ e oJw;

        public b(e eVar) {
            this.oJw = eVar;
            super(eVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130904338, viewGroup, false);
            a aVar = this.oJw.oJv;
            aVar.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar.euh = (TextView) inflate.findViewById(2131755456);
            aVar.dtZ = (TextView) inflate.findViewById(2131755458);
            aVar.dtZ.setVisibility(8);
            aVar.dua = (CheckBox) inflate.findViewById(2131755510);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            e eVar = (e) aVar2;
            a aVar3 = (a) aVar;
            if (this.oJw.oJt == 0 || this.oJw.oJs == null) {
                h.a(eVar.dtS, aVar3.euh);
                com.tencent.mm.pluginsdk.ui.a.b.m(aVar3.dtX, eVar.username);
                if (this.oJw.oHa) {
                    if (z) {
                        aVar3.dua.setChecked(true);
                        aVar3.dua.setEnabled(false);
                    } else {
                        aVar3.dua.setChecked(z2);
                        aVar3.dua.setEnabled(true);
                    }
                    aVar3.dua.setVisibility(0);
                    return;
                }
                aVar3.dua.setVisibility(8);
                return;
            }
            aVar3.dtX.setImageResource(this.oJw.oJt);
            aVar3.euh.setText(this.oJw.oJs);
        }

        public final boolean NG() {
            return false;
        }
    }

    public e(int i) {
        super(4, i);
    }

    public void bo(Context context) {
        if (this.oJt != 0 && this.oJs != null) {
            return;
        }
        if (this.euW == null) {
            this.dtS = SQLiteDatabase.KeyEmpty;
            this.username = SQLiteDatabase.KeyEmpty;
            return;
        }
        this.dtS = com.tencent.mm.pluginsdk.ui.d.e.a(context, l.c(this.euW), com.tencent.mm.bd.a.N(context, 2131493169));
        this.username = this.euW.field_username;
    }

    public final com.tencent.mm.ui.contact.a.a.b NE() {
        return this.oJu;
    }

    protected final com.tencent.mm.ui.contact.a.a.a NF() {
        return this.oJv;
    }
}
