package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.j;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class cv extends j<at> {
    private String bdo;
    private String cyO;
    private String exv;
    private boolean nQK;
    a orP;

    public interface a {
        void xe(int i);
    }

    private static class b {
        public ImageView dtX;
        public TextView euh;
        public TextView eui;
        public TextView orQ;

        private b() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (at) obj;
        if (obj == null) {
            obj = new at();
        }
        obj.b(cursor);
        return obj;
    }

    public cv(Context context, at atVar, String str, String str2, boolean z) {
        super(context, atVar);
        this.bdo = str;
        this.cyO = str2;
        this.nQK = z;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.context, 2130904308, null);
            bVar = new b();
            bVar.dtX = (ImageView) view.findViewById(2131755508);
            bVar.euh = (TextView) view.findViewById(2131756539);
            bVar.eui = (TextView) view.findViewById(2131756540);
            bVar.orQ = (TextView) view.findViewById(2131757187);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        at atVar = (at) getItem(i);
        if (atVar != null) {
            if (this.nQK && atVar.field_isSend == 0) {
                String str = atVar.field_content;
                String fL = aw.fL(str);
                if (!t.kS(fL)) {
                    com.tencent.mm.pluginsdk.ui.a.b.m(bVar.dtX, fL);
                    bVar.euh.setText(e.a(this.context, l.er(fL), bVar.euh.getTextSize()));
                }
                bVar.eui.setText(ak(atVar));
                bVar.orQ.setText(e.a(this.context, aw.fM(str), bVar.orQ.getTextSize()));
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.m(bVar.dtX, aj(atVar));
                bVar.euh.setText(e.a(this.context, l.er(aj(atVar)), bVar.euh.getTextSize()));
                bVar.eui.setText(ak(atVar));
                bVar.orQ.setText(e.a(this.context, atVar.field_content, bVar.orQ.getTextSize()));
            }
        }
        return view;
    }

    public final void uU(String str) {
        this.exv = str;
        if (!t.kS(this.exv)) {
            avc();
            Ol();
        }
    }

    private String aj(at atVar) {
        return atVar.field_isSend == 1 ? this.cyO : this.bdo;
    }

    public final void Ol() {
        ak.yW();
        setCursor(c.wJ().dM(this.bdo, this.exv));
        if (!(this.orP == null || t.kS(this.exv))) {
            this.orP.xe(getCount());
        }
        super.notifyDataSetChanged();
    }

    protected final void Om() {
        avc();
        Ol();
    }

    private CharSequence ak(at atVar) {
        return atVar.field_createTime == Long.MAX_VALUE ? SQLiteDatabase.KeyEmpty : o.c(this.context, atVar.field_createTime, true);
    }
}
