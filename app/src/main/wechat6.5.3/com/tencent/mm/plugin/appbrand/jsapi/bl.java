package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.widget.input.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bl extends a {
    private static final int CTRL_INDEX = 107;
    private static final String NAME = "showActionSheet";

    private class a extends BaseAdapter {
        private List<String> dIB;
        private int dIC;
        final /* synthetic */ bl dIy;

        private class a {
            TextView dID;
            final /* synthetic */ a dIE;

            private a(a aVar) {
                this.dIE = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return hd(i);
        }

        public a(bl blVar, List list, int i) {
            this.dIy = blVar;
            this.dIB = list;
            this.dIC = i;
        }

        public final int getCount() {
            return this.dIB.size();
        }

        private String hd(int i) {
            return (String) this.dIB.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(viewGroup.getContext(), 2130903115, null);
                a aVar2 = new a();
                aVar2.dID = (TextView) view.findViewById(2131755226);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.dID.setText(hd(i));
            aVar.dID.setTextColor(this.dIC);
            return view;
        }
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        h a = d.a(fVar);
        if (a == null) {
            v.w("MicroMsg.JsApiShowActionSheet", "invoke JsApi JsApiShowActionSheet failed, current page view is null.");
            fVar.y(i, c("fail", null));
            return;
        }
        e.m(a);
        String optString = jSONObject.optString("itemList");
        final List arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add((String) jSONArray.get(i2));
            }
            final f fVar2 = fVar;
            final JSONObject jSONObject2 = jSONObject;
            final int i3 = i;
            ad.o(new Runnable(this) {
                final /* synthetic */ bl dIy;

                public final void run() {
                    final k kVar = new k(d.nt(fVar2.dzg));
                    kVar.eGK = new a(this.dIy, arrayList, d.ac(jSONObject2.optString("itemColor", ""), Color.parseColor("#000000")));
                    kVar.lSE = new OnItemClickListener(this) {
                        final /* synthetic */ AnonymousClass1 dIA;

                        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            Map hashMap = new HashMap();
                            hashMap.put("tapIndex", Integer.valueOf(i));
                            fVar2.y(i3, this.dIA.dIy.c("ok", hashMap));
                            kVar.dismiss();
                        }
                    };
                    kVar.setOnCancelListener(new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass1 dIA;

                        {
                            this.dIA = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            fVar2.y(i3, this.dIA.dIy.c("cancel", null));
                        }
                    });
                    kVar.show();
                }
            });
        } catch (Exception e) {
            v.e("MicroMsg.JsApiShowActionSheet", e.getMessage());
            fVar.y(i, c("fail", null));
        }
    }
}
