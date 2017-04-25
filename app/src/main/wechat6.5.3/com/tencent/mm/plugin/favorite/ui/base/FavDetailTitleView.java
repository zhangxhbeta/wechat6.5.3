package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class FavDetailTitleView extends LinearLayout {
    private ImageView dtX;
    private TextView dtY;

    public FavDetailTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.dtX = (ImageView) findViewById(2131755508);
        this.dtY = (TextView) findViewById(2131755456);
    }

    public final void x(i iVar) {
        if (iVar != null && iVar.field_favProto != null) {
            CharSequence et;
            if (14 != iVar.field_type || be.kS(iVar.field_favProto.title)) {
                this.dtX.setVisibility(0);
                qg qgVar = iVar.field_favProto.mtP;
                if (qgVar == null || be.kS(qgVar.mtu)) {
                    v.v("MicroMsg.FavDetailTitleView", "display name, from item info user[%s]", new Object[]{iVar.field_fromUser});
                    et = com.tencent.mm.plugin.favorite.b.v.et(iVar.field_fromUser);
                    b.m(this.dtX, iVar.field_fromUser);
                } else {
                    et = l.er(qgVar.mtu);
                    String et2;
                    if (k.xF().equals(qgVar.bhM)) {
                        et2 = com.tencent.mm.plugin.favorite.b.v.et(qgVar.toUser);
                        if (!be.ah(et2, "").equals(qgVar.toUser)) {
                            et = et + " - " + et2;
                        }
                    } else {
                        et2 = com.tencent.mm.plugin.favorite.b.v.et(qgVar.bhM);
                        if (!be.ah(et2, "").equals(qgVar.bhM)) {
                            et = et + " - " + et2;
                        }
                    }
                    v.v("MicroMsg.FavDetailTitleView", "display name, source from[%s] to[%s]", new Object[]{qgVar.bhM, qgVar.toUser});
                    b.m(this.dtX, qgVar.mtu);
                }
            } else {
                et = iVar.field_favProto.title;
                this.dtX.setVisibility(8);
            }
            this.dtY.setText(e.a(getContext(), et, this.dtY.getTextSize()));
        }
    }
}
