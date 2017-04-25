package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.n;
import java.util.ArrayList;
import java.util.List;

public final class c extends n {
    public static boolean iYV = true;
    public static boolean iYW = false;
    List<String> iYT;
    private boolean iYU;

    public class a extends d {
        final /* synthetic */ c iYX;

        public class a extends com.tencent.mm.ui.contact.a.d.a {
            public View iWo;
            public View iYY;
            final /* synthetic */ a iYZ;

            public a(a aVar) {
                this.iYZ = aVar;
                super(aVar);
            }
        }

        public class b extends com.tencent.mm.ui.contact.a.d.b {
            final /* synthetic */ a iYZ;

            public b(a aVar) {
                this.iYZ = aVar;
                super(aVar);
            }

            public final View a(Context context, ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(context).inflate(2130904406, viewGroup, false);
                a aVar = (a) this.iYZ.NF();
                aVar.dtX = (ImageView) inflate.findViewById(2131755508);
                aVar.dtY = (TextView) inflate.findViewById(2131755456);
                aVar.dtZ = (TextView) inflate.findViewById(2131755458);
                aVar.dtW = inflate.findViewById(2131758337);
                aVar.dua = (CheckBox) inflate.findViewById(2131755510);
                aVar.iWo = inflate.findViewById(2131759211);
                aVar.iYY = inflate.findViewById(2131756534);
                inflate.setTag(aVar);
                aVar.dtY.setTextColor(-1);
                LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                layoutParams.width = -1;
                inflate.setLayoutParams(layoutParams);
                inflate.setBackgroundResource(2131689547);
                return inflate;
            }

            public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
                ab abVar = aVar2.euW;
                a aVar3 = (a) aVar;
                aVar3.dtW.setVisibility(0);
                aVar3.iYY.setVisibility(8);
                aVar3.iWo.setVisibility(8);
                if (c.zI(abVar.field_username)) {
                    aVar3.dtX.setImageResource(2131165919);
                    aVar3.dtY.setText(2131235339);
                    aVar3.dtZ.setText(2131235337);
                    aVar3.dtZ.setVisibility(0);
                    aVar3.dua.setEnabled(false);
                    if (c.iYW) {
                        aVar3.dtW.setBackgroundResource(2130839168);
                        aVar3.dua.setVisibility(0);
                        aVar3.dua.setBackgroundResource(2131165926);
                        aVar3.iWo.setVisibility(0);
                    } else {
                        aVar3.dtW.setBackgroundResource(2130839172);
                        aVar3.dua.setVisibility(8);
                        aVar3.dua.setBackgroundResource(2131165928);
                        aVar3.iWo.setVisibility(8);
                    }
                    c cVar = this.iYZ.iYX;
                    c.d(context, aVar3.dtW);
                    ViewGroup.LayoutParams layoutParams = aVar3.dtX.getLayoutParams();
                    layoutParams.width = com.tencent.mm.bd.a.N(context, 2131493564);
                    layoutParams.height = com.tencent.mm.bd.a.N(context, 2131493564);
                    aVar3.dtX.setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar3.dua.getLayoutParams();
                    layoutParams2.height = com.tencent.mm.bd.a.N(context, 2131493570);
                    layoutParams2.width = com.tencent.mm.bd.a.N(context, 2131493570);
                    layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
                    aVar3.dua.setLayoutParams(layoutParams2);
                    return;
                }
                if (c.zG(abVar.field_username)) {
                    aVar3.dtX.setImageResource(2131165925);
                    aVar3.dua.setVisibility(8);
                    aVar3.dtY.setText(context.getString(2131235348));
                    aVar3.dtZ.setVisibility(8);
                    if (c.iYV) {
                        aVar3.dtW.setBackgroundResource(2130839172);
                        aVar3.iWo.setVisibility(8);
                    } else {
                        aVar3.dtW.setBackgroundResource(2130839168);
                        aVar3.iWo.setVisibility(0);
                    }
                    cVar = this.iYZ.iYX;
                    c.d(context, aVar3.dtW);
                } else if (c.zH(abVar.field_username)) {
                    aVar3.dtW.setVisibility(8);
                    aVar3.iYY.setVisibility(0);
                    return;
                } else {
                    super.a(context, aVar, aVar2, z, z2);
                    aVar3.dtW.setBackgroundResource(2130839172);
                    cVar = this.iYZ.iYX;
                    c.d(context, aVar3.dtW);
                }
                layoutParams = aVar3.dtX.getLayoutParams();
                layoutParams.width = com.tencent.mm.bd.a.N(context, 2131493564);
                layoutParams.height = com.tencent.mm.bd.a.N(context, 2131493564);
                aVar3.dtX.setLayoutParams(layoutParams);
                layoutParams2 = (LinearLayout.LayoutParams) aVar3.dua.getLayoutParams();
                layoutParams2.height = com.tencent.mm.bd.a.N(context, 2131493570);
                layoutParams2.width = com.tencent.mm.bd.a.N(context, 2131493570);
                layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
                aVar3.dua.setLayoutParams(layoutParams2);
                aVar3.dua.setBackgroundResource(2130839167);
            }
        }

        public a(c cVar, int i) {
            this.iYX = cVar;
            super(i);
        }

        public final com.tencent.mm.ui.contact.a.a.b NE() {
            return new b(this);
        }

        protected final com.tencent.mm.ui.contact.a.a.a NF() {
            return new a(this);
        }
    }

    static /* synthetic */ void d(Context context, View view) {
        if (view != null && context != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = com.tencent.mm.bd.a.N(context, 2131493572);
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            view.setLayoutParams(layoutParams);
            view.setPadding(com.tencent.mm.bd.a.fromDPToPix(context, 10), view.getPaddingTop(), com.tencent.mm.bd.a.fromDPToPix(context, 10), view.getPaddingTop());
        }
    }

    public c(l lVar) {
        super(lVar, new ArrayList(), true, true);
        this.iYU = true;
        this.iYU = true;
        this.iYT = null;
    }

    public final int getCount() {
        return this.iYT == null ? 0 : this.iYT.size();
    }

    protected final com.tencent.mm.ui.contact.a.a gK(int i) {
        if (this.iYT == null) {
            return null;
        }
        if (i < 0 || i >= getCount()) {
            v.e("MicroMsg.MainSightSelectContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
            return null;
        }
        u uVar;
        com.tencent.mm.ui.contact.a.a aVar = new a(this, i);
        String str = (String) this.iYT.get(i);
        if (zG(str)) {
            uVar = new u("@sns.tencent");
        } else if (zH(str)) {
            uVar = new u("@search.tencent");
        } else if (zI(str)) {
            uVar = new u("@draft.tencent");
        } else {
            ak.yW();
            uVar = com.tencent.mm.model.c.wH().LX((String) this.iYT.get(i));
        }
        aVar.euW = uVar;
        aVar.oHa = this.iYU;
        return aVar;
    }

    public static boolean zG(String str) {
        return be.kS(str) ? false : str.endsWith("@sns.tencent");
    }

    public static boolean zH(String str) {
        return be.kS(str) ? false : str.endsWith("@search.tencent");
    }

    public static boolean zI(String str) {
        return be.kS(str) ? false : str.endsWith("@draft.tencent");
    }

    public final boolean aQk() {
        return this.iYU;
    }
}
