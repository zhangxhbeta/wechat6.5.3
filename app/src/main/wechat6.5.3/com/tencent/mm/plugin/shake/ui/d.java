package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.k;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.j;
import java.util.GregorianCalendar;

final class d extends j<f> {
    private LayoutInflater CE;
    int iRi = 20;
    private Context mContext;

    class a {
        TextView eXB;
        TextView gNg;
        TextView hfA;
        MMImageView iRj;
        final /* synthetic */ d iRk;

        a(d dVar) {
            this.iRk = dVar;
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (f) obj;
        if (obj == null) {
            obj = new f();
        }
        obj.b(cursor);
        return obj;
    }

    public d(Context context) {
        super(context, new f());
        this.mContext = context;
        this.CE = LayoutInflater.from(context);
    }

    public final void pr(int i) {
        avc();
        this.iRi = i;
        Ol();
    }

    protected final void Om() {
        Ol();
    }

    public final void Ol() {
        g aNP = k.aNP();
        setCursor(aNP.cie.rawQuery("SELECT * FROM " + aNP.getTableName() + " ORDER BY rowid DESC LIMIT " + this.iRi, null));
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        if (view == null) {
            view = this.CE.inflate(2130904371, viewGroup, false);
            aVar = new a(this);
            aVar.iRj = (MMImageView) view.findViewById(2131759130);
            aVar.eXB = (TextView) view.findViewById(2131759131);
            aVar.gNg = (TextView) view.findViewById(2131759132);
            aVar.hfA = (TextView) view.findViewById(2131759133);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        f fVar = (f) getItem(i);
        e.a(aVar.iRj, fVar.field_thumburl, 2131165247, false);
        if (be.kS(fVar.field_title)) {
            aVar.eXB.setVisibility(8);
        } else {
            aVar.eXB.setText(e.a(this.mContext, fVar.field_title, aVar.eXB.getTextSize()));
            aVar.eXB.setVisibility(0);
        }
        if (be.kS(fVar.field_desc)) {
            aVar.gNg.setVisibility(8);
        } else {
            aVar.gNg.setText(e.a(this.mContext, fVar.field_desc, aVar.gNg.getTextSize()));
            aVar.gNg.setVisibility(0);
        }
        TextView textView = aVar.hfA;
        Context context = this.mContext;
        long j = fVar.field_createtime * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            charSequence = "";
        } else {
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            int i2;
            if ((timeInMillis - j) / 3600000 == 0) {
                i2 = (int) ((timeInMillis - j) / 60000);
                if (i2 <= 0) {
                    i2 = 1;
                }
                charSequence = context.getResources().getQuantityString(2131361802, i2, new Object[]{Integer.valueOf(i2)});
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                    timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                        i2 = (int) ((timeInMillis - j) / 86400000);
                        if (i2 <= 0) {
                            i2 = 1;
                        }
                        charSequence = context.getResources().getQuantityString(2131361803, i2, new Object[]{Integer.valueOf(i2)});
                    } else {
                        charSequence = context.getString(2131232911);
                    }
                } else {
                    i2 = (int) ((timeInMillis - j) / 3600000);
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    charSequence = context.getResources().getQuantityString(2131361801, i2, new Object[]{Integer.valueOf(i2)});
                }
            }
        }
        textView.setText(charSequence);
        return view;
    }
}
