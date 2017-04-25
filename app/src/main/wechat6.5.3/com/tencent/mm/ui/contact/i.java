package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.modelbiz.d.a.b;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i extends LinearLayout implements com.tencent.mm.modelbiz.d.a {
    private Context context;
    private LinearLayout fQp = null;
    private List<String> oGp;
    private Map<String, View> oGq;
    private a oGr;

    public interface a {
        void xR(int i);
    }

    public i(Context context, a aVar) {
        super(context);
        this.context = context;
        this.oGr = aVar;
        init();
    }

    public final int bHB() {
        if (this.oGp == null) {
            return 0;
        }
        return this.oGp.size();
    }

    private void init() {
        int i = 0;
        d Dy = u.Dy();
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        d.a(stringBuilder);
        d.c(stringBuilder);
        stringBuilder.append(" and bizinfo.type").append(" = 2 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(d.Db());
        v.i("MicroMsg.BizInfoStorage", "getEnterpriseFatherBizLst sql %s", stringBuilder.toString());
        Cursor rawQuery = Dy.rawQuery(r3, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        this.oGp = arrayList;
        if (this.oGp == null || this.oGp.size() <= 0) {
            v.e("MicroMsg.EnterpriseBizView", "bizList is null");
            return;
        }
        v.i("MicroMsg.EnterpriseBizView", "biz list size = %s", Integer.valueOf(this.oGp.size()));
        this.oGq = new HashMap();
        if (this.fQp == null) {
            View.inflate(getContext(), 2130903522, this);
            this.fQp = (LinearLayout) findViewById(2131755326);
        }
        while (i < this.oGp.size()) {
            String str = (String) this.oGp.get(i);
            View jVar = new j(getContext(), str);
            this.fQp.addView(jVar);
            this.oGq.put(str, jVar);
            if (i == this.oGp.size() - 1) {
                jVar.findViewById(2131756762).setBackgroundResource(2130838689);
            }
            i++;
        }
    }

    public final void a(final b bVar) {
        if (bVar.cCM != null) {
            if (bVar.cCM.Cz()) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ i oGt;

                    public final void run() {
                        ak.yW();
                        ab LX = c.wH().LX(bVar.cBj);
                        if (this.oGt.oGp == null || this.oGt.oGp.size() <= 0 || !this.oGt.oGp.contains(bVar.cBj)) {
                            if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
                                if (this.oGt.oGp != null) {
                                    this.oGt.oGp.clear();
                                }
                                if (this.oGt.oGq != null) {
                                    this.oGt.oGq.clear();
                                }
                                if (this.oGt.fQp != null) {
                                    this.oGt.fQp.removeAllViews();
                                }
                                this.oGt.init();
                                if (this.oGt.oGr != null) {
                                    this.oGt.oGr.xR(this.oGt.oGp.size());
                                }
                            }
                        } else if (LX == null || ((int) LX.chr) <= 0 || !com.tencent.mm.i.a.ei(LX.field_type)) {
                            v.i("MicroMsg.EnterpriseBizView", "remove enterprise biz view item, %s", bVar.cBj);
                            this.oGt.oGp.remove(bVar.cBj);
                            if (this.oGt.oGp.size() > 0) {
                                View view = (View) this.oGt.oGq.get(bVar.cBj);
                                if (view != null && this.oGt.fQp != null) {
                                    this.oGt.fQp.removeView(view);
                                    this.oGt.oGq.remove(view);
                                }
                            } else if (this.oGt.oGr != null) {
                                if (this.oGt.oGq != null) {
                                    this.oGt.oGq.clear();
                                }
                                if (this.oGt.fQp != null) {
                                    this.oGt.fQp.removeAllViews();
                                }
                                this.oGt.oGr.xR(this.oGt.oGp.size());
                            }
                        }
                    }
                });
            } else {
                v.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
            }
        }
    }
}
