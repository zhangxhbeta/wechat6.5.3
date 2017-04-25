package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class h extends BaseAdapter {
    private f fkM;
    private Context mContext;
    ArrayList<com.tencent.mm.storage.a.a> mData = new ArrayList();

    class a {
        ImageView bdF;
        final /* synthetic */ h fnk;

        public a(h hVar, View view) {
            this.fnk = hVar;
            this.bdF = (ImageView) view.findViewById(2131759216);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return kb(i);
    }

    public h(Context context, f fVar) {
        this.mContext = context;
        this.fkM = fVar;
    }

    public final int getCount() {
        return this.mData == null ? 0 : this.mData.size();
    }

    public final com.tencent.mm.storage.a.a kb(int i) {
        if (this.mData == null || this.mData.isEmpty() || this.mData.size() < i) {
            return null;
        }
        return (com.tencent.mm.storage.a.a) this.mData.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(2130904410, null);
            aVar = new a(this, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.storage.a.a kb = kb(i);
        if (kb == null) {
            aVar.bdF.setVisibility(8);
            aVar.bdF.setTag("");
            v.i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "emoji group info is null. position:%d", new Object[]{Integer.valueOf(i)});
        } else {
            aVar.bdF.setVisibility(0);
        }
        com.tencent.mm.ae.a.a.c.a aVar2;
        if ("TAG_DEFAULT_TAB".equals(kb.field_productID)) {
            aVar2 = new com.tencent.mm.ae.a.a.c.a();
            aVar2.cPq = true;
            aVar2.cPx = 4;
            aVar2.cPL = 2130837780;
            aVar2.cPy = this.fkM.flR;
            aVar2.cPy = this.fkM.flR;
            n.GL().a("2131165491", aVar.bdF, aVar2.GU());
        } else if (String.valueOf(com.tencent.mm.storage.a.a.nwK).equals(kb.field_productID)) {
            aVar2 = new com.tencent.mm.ae.a.a.c.a();
            aVar2.cPq = true;
            aVar2.cPx = 4;
            aVar2.cPL = 2130837780;
            aVar2.cPy = this.fkM.flR;
            aVar2.cPy = this.fkM.flR;
            n.GL().a("2131165490", aVar.bdF, aVar2.GU());
        } else if (String.valueOf(com.tencent.mm.storage.a.a.nwJ).equals(kb.field_productID)) {
            aVar2 = new com.tencent.mm.ae.a.a.c.a();
            aVar2.cPq = true;
            aVar2.cPx = 4;
            aVar2.cPL = 2130837780;
            aVar2.cPy = this.fkM.flR;
            aVar2.cPy = this.fkM.flR;
            n.GL().a("2130838171", aVar.bdF, aVar2.GU());
        } else if ("TAG_STORE_MANEGER_TAB".equals(kb.field_productID)) {
            aVar2 = new com.tencent.mm.ae.a.a.c.a();
            aVar2.cPq = true;
            aVar2.cPx = 4;
            aVar2.cPL = 2130837780;
            aVar2.cPy = this.fkM.flR;
            aVar2.cPy = this.fkM.flR;
            n.GL().a("2131165493", aVar.bdF, aVar2.GU());
        } else if (f.a(kb)) {
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            r1 = stringBuilder.append(EmojiLogic.z(c.wY(), kb.field_productID, "")).append("_panel_enable").toString();
            com.tencent.mm.ae.a.a.c.a aVar3 = new com.tencent.mm.ae.a.a.c.a();
            aVar3.cPu = r1;
            aVar3.cPq = true;
            aVar3.cPL = 2130837780;
            aVar3.cPx = 1;
            aVar3.cPy = this.fkM.flR;
            aVar3.cPy = this.fkM.flR;
            n.GL().a(r1, aVar.bdF, aVar3.GU());
        } else {
            String str = kb.field_packGrayIconUrl;
            ak.yW();
            r1 = EmojiLogic.z(c.wY(), kb.field_productID, str);
            com.tencent.mm.ae.a.a.c.a aVar4 = new com.tencent.mm.ae.a.a.c.a();
            aVar4.cPu = r1;
            aVar4.cPq = true;
            aVar4.cPs = true;
            aVar4.cPL = 2130837780;
            aVar4.cPB = true;
            aVar4.cPy = this.fkM.flR;
            aVar4.cPy = this.fkM.flR;
            com.tencent.mm.ae.a.a.c GU = aVar4.GU();
            if (be.kS(str)) {
                n.GL().a("", aVar.bdF, GU);
                v.i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "empty url.");
            } else {
                n.GL().a(str, aVar.bdF, GU);
            }
        }
        aVar.bdF.setBackgroundResource(2130837780);
        aVar.bdF.setPadding(this.fkM.flS, this.fkM.flS, this.fkM.flS, this.fkM.flS);
        if (i == this.fkM.ahL()) {
            aVar.bdF.setSelected(true);
        } else {
            aVar.bdF.setSelected(false);
        }
        return view;
    }
}
