package com.tencent.mm.ui.account;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.h;
import com.tencent.mm.modelfriend.i;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.j;

@Deprecated
final class d extends j<h> {
    private int[] cHB;
    private String dxb;
    a nIk;

    public interface a {
        void vT(int i);
    }

    static class b {
        TextView cHI;
        TextView cHJ;
        ImageView dtz;
        TextView nIl;
        TextView nIm;
        ImageView nIn;

        b() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (h) obj;
        if (obj == null) {
            obj = new h();
        }
        obj.b(cursor);
        return obj;
    }

    public d(Context context, com.tencent.mm.ui.j.a aVar) {
        super(context, new h());
        this.nDK = aVar;
    }

    protected final void Om() {
        Ol();
    }

    public final void Ol() {
        i FM = ah.FM();
        String str = this.dxb;
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" where ( ");
            stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
        }
        setCursor(FM.cuX.rawQuery("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null));
        this.cHB = new int[getCount()];
        if (!(this.nIk == null || this.dxb == null)) {
            this.nIk.vT(getCursor().getCount());
        }
        super.notifyDataSetChanged();
    }

    public final void uU(String str) {
        this.dxb = be.lZ(str.trim());
        avc();
        Ol();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        h hVar = (h) getItem(i);
        if (view == null) {
            b bVar2 = new b();
            view = View.inflate(this.context, 2130903584, null);
            bVar2.dtz = (ImageView) view.findViewById(2131756891);
            bVar2.cHI = (TextView) view.findViewById(2131756892);
            bVar2.cHJ = (TextView) view.findViewById(2131756895);
            bVar2.nIl = (TextView) view.findViewById(2131756893);
            bVar2.nIm = (TextView) view.findViewById(2131756894);
            bVar2.nIn = (ImageView) view.findViewById(2131756896);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.cHI.setText(e.a(this.context, hVar.EQ(), bVar.cHI.getTextSize()));
        bVar.nIm.setVisibility(8);
        bVar.nIn.setVisibility(0);
        switch (this.cHB[i]) {
            case 0:
                if (hVar.status != MMGIFException.D_GIF_ERR_READ_FAILED) {
                    ak.yW();
                    if (!c.wH().LT(hVar.getUsername())) {
                        bVar.cHJ.setVisibility(8);
                        bVar.nIl.setVisibility(0);
                        break;
                    }
                }
                if (hVar.status != MMGIFException.D_GIF_ERR_READ_FAILED) {
                    bVar.cHJ.setVisibility(0);
                    bVar.cHJ.setText(2131232992);
                    bVar.cHJ.setTextColor(this.context.getResources().getColor(2131689506));
                    bVar.nIl.setVisibility(8);
                    break;
                }
                bVar.cHJ.setVisibility(8);
                bVar.nIl.setVisibility(8);
                bVar.nIn.setVisibility(8);
                break;
            case 2:
                bVar.nIl.setVisibility(8);
                bVar.cHJ.setVisibility(0);
                bVar.cHJ.setText(2131232996);
                bVar.cHJ.setTextColor(this.context.getResources().getColor(2131689507));
                break;
        }
        Bitmap gy = com.tencent.mm.u.b.gy(hVar.bCb);
        if (gy == null) {
            bVar.dtz.setImageDrawable(com.tencent.mm.bd.a.a(this.context, 2131165440));
        } else {
            bVar.dtz.setImageBitmap(gy);
        }
        return view;
    }
}
