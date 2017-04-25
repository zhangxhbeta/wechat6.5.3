package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.ui.base.a.b;
import com.tencent.mm.sdk.platformtools.v;

public final class e extends com.tencent.mm.plugin.brandservice.ui.base.a {
    private static b exM;
    long exR;
    String exS;
    String ezo;
    int vI;

    public static class a implements com.tencent.mm.plugin.brandservice.ui.base.a.a {
        public TextView dMQ;
    }

    public e(Object obj, long j, int i, String str) {
        super(2, null);
        this.exR = j;
        this.exS = str;
        this.vI = i;
    }

    public final b Yn() {
        if (exM == null) {
            exM = new b(this) {
                final /* synthetic */ e ezp;

                {
                    this.ezp = r1;
                }

                public final boolean a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a aVar, Object... objArr) {
                    if (!(context == null || aVar == null)) {
                        int i = 0;
                        if (objArr != null && objArr.length >= 2 && (objArr[1] instanceof Integer)) {
                            i = ((Integer) objArr[1]).intValue();
                        }
                        e eVar = (e) aVar;
                        Intent intent = new Intent(context, BizSearchDetailPageUI.class);
                        intent.putExtra("keyword", eVar.exS);
                        intent.putExtra("businessType", eVar.exR);
                        intent.putExtra("offset", eVar.vI);
                        intent.putExtra("showEditText", true);
                        intent.putExtra("fromScene", i);
                        context.startActivity(intent);
                    }
                    return true;
                }

                public final View b(Context context, View view) {
                    if (view == null) {
                        return View.inflate(context, 2130904312, null);
                    }
                    return view;
                }

                public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, com.tencent.mm.plugin.brandservice.ui.base.a aVar2) {
                    if (context == null || aVar == null || aVar2 == null) {
                        v.e("MicroMsg.ReadMoreBtnDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                    } else if (!(aVar instanceof a)) {
                        v.e("MicroMsg.ReadMoreBtnDataItem", "The ViewHolder is not a instance of MoreBtnViewHolder.");
                    } else if (aVar2 instanceof e) {
                        ((a) aVar).dMQ.setText(((e) aVar2).ezo);
                    } else {
                        v.e("MicroMsg.ReadMoreBtnDataItem", "The DataItem is not a instance of MoreBtnDataItem.");
                    }
                }

                public final void a(View view, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar) {
                    if (view != null && aVar != null && (aVar instanceof a)) {
                        ((a) aVar).dMQ = (TextView) view.findViewById(2131756783);
                    }
                }
            };
        }
        return exM;
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.a.a Yo() {
        return new a();
    }

    public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, Object... objArr) {
        this.ezo = "";
    }
}
