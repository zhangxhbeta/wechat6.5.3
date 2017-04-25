package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.j;

public final class c extends j<com.tencent.mm.modelbiz.a.c> implements b {
    private final MMActivity aWn;
    private com.tencent.mm.ae.a.a.c eSp = null;
    protected f euc;
    protected com.tencent.mm.ui.base.MMSlideDelView.c eud;
    protected e eue;
    protected d euf = MMSlideDelView.bCp();
    private final String ezn;

    public static class a {
        public ImageView dtX;
        public TextView euh;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.modelbiz.a.c) obj;
        if (obj == null) {
            obj = new com.tencent.mm.modelbiz.a.c();
        }
        obj.b(cursor);
        return obj;
    }

    public c(Context context, com.tencent.mm.ui.j.a aVar, String str) {
        super(context, new com.tencent.mm.modelbiz.a.c());
        this.nDK = aVar;
        this.aWn = (MMActivity) context;
        this.ezn = str;
        com.tencent.mm.ae.a.a.c.a aVar2 = new com.tencent.mm.ae.a.a.c.a();
        aVar2.cPv = com.tencent.mm.modelbiz.a.e.ib(this.ezn);
        aVar2.cPs = true;
        aVar2.cPO = true;
        aVar2.cPH = 2131165440;
        this.eSp = aVar2.GU();
    }

    public final void Ol() {
        avc();
        com.tencent.mm.modelbiz.a.d DA = u.DA();
        String str = this.ezn;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from BizChatInfo");
        stringBuilder.append(" where brandUserName = '").append(str).append("'");
        stringBuilder.append(" and (bitFlag & 8").append(") != 0 ");
        StringBuilder append = stringBuilder.append(" order by ");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" case when length(BizChatInfo.chatNamePY) > 0 then upper(").append("BizChatInfo.chatNamePY) ");
        stringBuffer.append(" else upper(BizChatInfo.chatName) end asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatNamePY) asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatName) asc ");
        append.append(stringBuffer.toString());
        v.d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", stringBuilder.toString());
        setCursor(DA.cie.rawQuery(stringBuilder.toString(), null));
        if (this.nDK != null) {
            this.nDK.Oi();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void a(f fVar) {
        this.euc = fVar;
    }

    public final void a(e eVar) {
        this.eue = eVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.eud = cVar;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        if (this.euf != null) {
            this.euf.avm();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        com.tencent.mm.modelbiz.a.c cVar = (com.tencent.mm.modelbiz.a.c) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.aWn, 2130903532, null);
            aVar2.dtX = (ImageView) view.findViewById(2131755508);
            aVar2.euh = (TextView) view.findViewById(2131756329);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        n.GL().a(cVar.field_headImageUrl, aVar.dtX, this.eSp);
        aVar.euh.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.aWn, cVar.field_chatName, (int) aVar.euh.getTextSize()));
        return view;
    }

    protected final void Om() {
        Ol();
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        super.a(i, jVar, obj);
    }
}
