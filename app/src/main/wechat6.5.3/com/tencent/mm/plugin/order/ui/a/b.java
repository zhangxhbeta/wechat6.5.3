package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public final class b implements a {
    public final List<Preference> a(final Context context, final f fVar, final MallTransactionObject mallTransactionObject) {
        f fVar2;
        f fVar3;
        List<Preference> arrayList = new ArrayList();
        boolean z = mallTransactionObject.aTg == 2;
        if (!(be.kS(mallTransactionObject.hNi) || be.kS(mallTransactionObject.dDo))) {
            d dVar = new d(context);
            dVar.fyK = mallTransactionObject.dDo;
            dVar.mName = mallTransactionObject.hNi;
            dVar.mOnClickListener = new OnClickListener(this) {
                final /* synthetic */ b hPy;

                public final void onClick(View view) {
                    if (!be.kS(mallTransactionObject.hNh)) {
                        e.L(context, mallTransactionObject.hNh);
                    }
                }
            };
            arrayList.add(dVar);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        v.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + mallTransactionObject.hNx + " and fetchTotalFee is " + mallTransactionObject.hNH);
        h hVar;
        if (TextUtils.isEmpty(mallTransactionObject.hNx)) {
            boolean z2;
            i iVar = new i(context);
            iVar.hPT = e.d(mallTransactionObject.eWz, mallTransactionObject.hNg);
            iVar.setTitle(z ? context.getString(2131236230) : context.getString(2131236244));
            if (!be.kS(mallTransactionObject.hMY)) {
                iVar.xG(mallTransactionObject.hMY);
            }
            arrayList.add(iVar);
            if (mallTransactionObject.eWz == mallTransactionObject.hNm || mallTransactionObject.hNm <= 0.0d) {
                z2 = false;
            } else {
                hVar = new h(context);
                hVar.hPP = false;
                hVar.hPQ = true;
                arrayList.add(hVar);
                fVar2 = new f(context);
                fVar2.setContent(e.d(mallTransactionObject.hNm, mallTransactionObject.hNg));
                fVar2.setTitle(2131236252);
                arrayList.add(fVar2);
                if (!be.kS(mallTransactionObject.hNl)) {
                    g gVar = new g(context);
                    gVar.setTitle(2131236240);
                    gVar.ezq = fVar;
                    String[] split = mallTransactionObject.hNl.split("\n");
                    if (split.length == 1) {
                        gVar.hPI = split[0];
                    } else {
                        gVar.hPI = context.getString(2131236241, new Object[]{Integer.valueOf(split.length), e.d(mallTransactionObject.hNm - mallTransactionObject.eWz, mallTransactionObject.hNg)});
                        gVar.a(split, TruncateAt.MIDDLE);
                    }
                    arrayList.add(gVar);
                }
                z2 = true;
            }
            h hVar2 = new h(context);
            hVar2.hPP = z2;
            hVar2.hPQ = true;
            arrayList.add(hVar2);
        } else {
            i iVar2 = new i(context);
            iVar2.hPT = e.d(mallTransactionObject.hNH, mallTransactionObject.hNg);
            iVar2.setTitle(context.getString(2131236231));
            if (!be.kS(mallTransactionObject.hNI)) {
                iVar2.xG(mallTransactionObject.hNI);
            }
            arrayList.add(iVar2);
            hVar = new h(context);
            hVar.hPP = false;
            hVar.hPQ = true;
            arrayList.add(hVar);
            fVar2 = new f(context);
            fVar2.setTitle(2131236244);
            fVar2.setContent(e.d(mallTransactionObject.eWz, mallTransactionObject.hNg));
            arrayList.add(fVar2);
            fVar2 = new f(context);
            fVar2.setTitle(2131236232);
            fVar2.setContent(mallTransactionObject.hNx);
            arrayList.add(fVar2);
        }
        if (!be.kS(mallTransactionObject.desc)) {
            if (z) {
                fVar3 = new f(context);
                fVar3.setTitle(2131236250);
                fVar3.setContent(mallTransactionObject.desc);
                arrayList.add(fVar3);
            } else {
                fVar3 = new f(context);
                fVar3.setTitle(2131236238);
                if (be.kS(mallTransactionObject.hMW)) {
                    fVar3.setContent(mallTransactionObject.desc);
                } else {
                    String string = context.getString(2131236233);
                    fVar3.a(mallTransactionObject.desc + " " + string, mallTransactionObject.desc.length() + 1, string.length() + (mallTransactionObject.desc.length() + 1), new OnClickListener(this) {
                        final /* synthetic */ b hPy;

                        public final void onClick(View view) {
                            fVar3.setContent(mallTransactionObject.desc + "\n" + mallTransactionObject.hMW);
                            fVar.notifyDataSetChanged();
                        }
                    });
                }
                arrayList.add(fVar3);
            }
        }
        if (!be.kS(mallTransactionObject.hMV)) {
            fVar3 = new f(context);
            fVar3.setTitle(2131236251);
            fVar3.setContent(mallTransactionObject.hMV);
            arrayList.add(fVar3);
        }
        if (!be.kS(mallTransactionObject.hNa)) {
            fVar3 = new f(context);
            fVar3.setTitle(2131236264);
            fVar3.setContent(mallTransactionObject.hNa);
            if (!be.kS(mallTransactionObject.hNb)) {
                fVar3.xF(mallTransactionObject.hNb);
            }
            arrayList.add(fVar3);
        }
        fVar3 = new f(context);
        fVar3.setTitle(2131236247);
        fVar3.setContent(e.yB(mallTransactionObject.cLB));
        arrayList.add(fVar3);
        if (mallTransactionObject.hNt > 0) {
            fVar3 = new f(context);
            fVar3.setTitle(2131236245);
            fVar3.setContent(e.yB(mallTransactionObject.hNt));
            arrayList.add(fVar3);
        } else if (mallTransactionObject.hNs > 0) {
            fVar3 = new f(context);
            fVar3.setTitle(2131236248);
            fVar3.setContent(e.yB(mallTransactionObject.hNs));
            arrayList.add(fVar3);
        } else {
            v.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
        }
        if (!be.kS(mallTransactionObject.hNe)) {
            fVar2 = new f(context);
            fVar2.setTitle(2131236246);
            String str = mallTransactionObject.hNe;
            if (!be.kS(mallTransactionObject.hNf)) {
                str = str + "(" + mallTransactionObject.hNf + ")";
            }
            fVar2.setContent(str);
            arrayList.add(fVar2);
        }
        if (!be.kS(mallTransactionObject.hNd)) {
            fVar3 = new f(context);
            fVar3.setTitle(2131236249);
            fVar3.setContent(mallTransactionObject.hNd);
            arrayList.add(fVar3);
        }
        h hVar3;
        if (be.kS(mallTransactionObject.hNq) && be.kS(mallTransactionObject.hNh) && be.kS(mallTransactionObject.hMJ)) {
            hVar3 = new h(context);
            hVar3.hPP = true;
            hVar3.hPR = false;
            arrayList.add(hVar3);
        } else {
            hVar3 = new h(context);
            hVar3.hPP = true;
            arrayList.add(hVar3);
            arrayList.add(com.tencent.mm.plugin.order.model.a.a(context, mallTransactionObject));
        }
        return arrayList;
    }
}
