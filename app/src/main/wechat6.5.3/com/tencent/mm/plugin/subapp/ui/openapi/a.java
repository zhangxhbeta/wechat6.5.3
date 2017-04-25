package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class a extends BaseAdapter implements com.tencent.mm.sdk.h.g.a {
    private Context context;
    boolean kgB = false;
    private int kgC = 0;
    private List<f> kgD;

    public a(Context context, int i) {
        this.context = context;
        this.kgC = i;
        init();
    }

    private void init() {
        int i = 0;
        this.kgD = new ArrayList();
        Cursor rawQuery = am.bnB().rawQuery("select * from AppInfo where status = " + this.kgC + " and (appType is null or appType not like ',1,')", new String[0]);
        if (rawQuery == null) {
            v.e("MicroMsg.AppInfoStorage", "getAppByStatusExcludeByType: curosr is null");
            rawQuery = null;
        }
        if (rawQuery != null) {
            int count = rawQuery.getCount();
            while (i < count) {
                rawQuery.moveToPosition(i);
                f fVar = new f();
                fVar.b(rawQuery);
                if (g.o(this.context, fVar.field_appId)) {
                    this.kgD.add(fVar);
                }
                i++;
            }
            rawQuery.close();
        }
    }

    public final void gC(boolean z) {
        this.kgB = z;
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        if (view == null) {
            dVar = new d();
            view = View.inflate(this.context, 2130903123, null);
            dVar.hEP = (ImageView) view.findViewById(2131755429);
            dVar.kgY = (TextView) view.findViewById(2131755430);
            dVar.dyN = (TextView) view.findViewById(2131755432);
            dVar.kgZ = view.findViewById(2131755431);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        dVar.kgZ.setVisibility(4);
        if (lB(i)) {
            dVar.hEP.setVisibility(4);
            dVar.kgY.setVisibility(4);
            dVar.dyN.setVisibility(4);
        } else {
            f fVar = (f) getItem(i);
            dVar.hEP.setVisibility(0);
            Bitmap b = g.b(fVar.field_appId, 1, com.tencent.mm.bd.a.getDensity(this.context));
            if (b == null) {
                dVar.hEP.setBackgroundResource(2130837663);
            } else {
                dVar.hEP.setBackgroundDrawable(new BitmapDrawable(b));
            }
            dVar.dyN.setVisibility(0);
            dVar.dyN.setText(g.a(this.context, fVar, null));
            if (this.kgB) {
                dVar.kgY.setVisibility(0);
            } else {
                dVar.kgY.setVisibility(8);
            }
        }
        return view;
    }

    public final int getCount() {
        return aij() + asv();
    }

    public final boolean lB(int i) {
        int size = this.kgD.size();
        return i >= size && i < size + asv();
    }

    public final Object getItem(int i) {
        if (lB(i)) {
            return null;
        }
        return this.kgD.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int aij() {
        return this.kgD.size();
    }

    private int asv() {
        return (4 - (aij() % 4)) % 4;
    }

    public final void a(String str, i iVar) {
        init();
        super.notifyDataSetChanged();
    }
}
