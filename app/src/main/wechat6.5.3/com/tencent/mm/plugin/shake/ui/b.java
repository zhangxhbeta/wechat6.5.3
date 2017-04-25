package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ar.k;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.j;

final class b extends j<com.tencent.mm.ar.j> {
    private int aGx = -1;
    private MMActivity aWn;
    protected f euc;
    protected c eud;
    protected d euf = MMSlideDelView.bCp();
    protected e hGa;
    private k iQF;

    static class a {
        TextView cHI;
        ImageView dtz;
        View eum;
        TextView eun;
        TextView hka;

        a() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.ar.j) obj;
        if (obj == null) {
            obj = new com.tencent.mm.ar.j();
        }
        obj.b(cursor);
        return obj;
    }

    public b(Context context, k kVar, int i) {
        super(context, new com.tencent.mm.ar.j());
        this.aWn = (MMActivity) context;
        this.aGx = i;
        this.iQF = kVar;
    }

    public final void a(f fVar) {
        this.euc = fVar;
    }

    public final void a(e eVar) {
        this.hGa = eVar;
    }

    public final void a(c cVar) {
        this.eud = cVar;
    }

    public final void pr(int i) {
        avc();
        this.aGx = i;
        Ol();
    }

    protected final void Om() {
        Ol();
    }

    public final void Ol() {
        k kVar = this.iQF;
        setCursor(kVar.cie.rawQuery("SELECT * FROM " + kVar.getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + this.aGx, null));
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        com.tencent.mm.ar.j jVar = (com.tencent.mm.ar.j) getItem(i);
        if (view == null) {
            MMSlideDelView mMSlideDelView = (MMSlideDelView) View.inflate(this.aWn, 2130903162, null);
            a aVar2 = new a();
            View inflate = View.inflate(this.aWn, 2130904285, null);
            aVar2.dtz = (ImageView) inflate.findViewById(2131756891);
            aVar2.cHI = (TextView) inflate.findViewById(2131758942);
            aVar2.hka = (TextView) inflate.findViewById(2131758943);
            aVar2.eum = mMSlideDelView.findViewById(2131755551);
            aVar2.eun = (TextView) mMSlideDelView.findViewById(2131755552);
            mMSlideDelView.setView(inflate);
            mMSlideDelView.euc = this.euc;
            mMSlideDelView.eud = this.eud;
            mMSlideDelView.euf = this.euf;
            mMSlideDelView.gMt = false;
            mMSlideDelView.setTag(aVar2);
            view = mMSlideDelView;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.eum.setTag(Long.valueOf(jVar.field_svrid));
        aVar.eum.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b iQG;

            {
                this.iQG = r1;
            }

            public final void onClick(View view) {
                v.v("MicroMsg.SayHiAdapter", "on delView clicked");
                this.iQG.euf.avn();
                if (this.iQG.hGa != null) {
                    this.iQG.hGa.aE(view.getTag());
                }
            }
        });
        aVar.cHI.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.aWn, at.d.MB(jVar.field_content).getDisplayName(), aVar.cHI.getTextSize()));
        aVar.hka.setText(jVar.field_sayhicontent);
        com.tencent.mm.pluginsdk.ui.a.b.m(aVar.dtz, jVar.field_sayhiuser);
        return view;
    }
}
