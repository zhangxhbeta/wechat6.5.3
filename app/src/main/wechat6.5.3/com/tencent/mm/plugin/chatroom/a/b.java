package com.tencent.mm.plugin.chatroom.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.mm.sdk.platformtools.v;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;

public final class b extends android.support.v7.widget.RecyclerView.a<b> implements com.tencent.mm.plugin.chatroom.ui.b.a {
    private final Calendar calendar = Calendar.getInstance();
    private final TypedArray eOB;
    private final a eOC;
    private final a<com.tencent.mm.plugin.chatroom.c.a> eOD;
    private final Collection<com.tencent.mm.plugin.chatroom.c.a> eOE;
    private final Integer eOF;
    private final Integer eOG;
    private final boolean eOH;
    private final Context mContext;

    public static class a<K> implements Serializable {
        K eOI;
        K first;
    }

    public static class b extends s {
        final com.tencent.mm.plugin.chatroom.ui.b eOJ;

        public b(View view, com.tencent.mm.plugin.chatroom.ui.b.a aVar) {
            super(view);
            this.eOJ = (com.tencent.mm.plugin.chatroom.ui.b) view;
            this.eOJ.setLayoutParams(new LayoutParams(-1, -1));
            this.eOJ.setClickable(true);
            this.eOJ.eUj = aVar;
        }
    }

    public final /* synthetic */ s a(ViewGroup viewGroup, int i) {
        return new b(new com.tencent.mm.plugin.chatroom.ui.b(this.mContext, this.eOB), this);
    }

    public final /* synthetic */ void a(s sVar, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = -1;
        com.tencent.mm.plugin.chatroom.ui.b bVar = ((b) sVar).eOJ;
        HashMap hashMap = new HashMap();
        int intValue = (this.eOF.intValue() + (i % 12)) % 12;
        int intValue2 = ((i / 12) + this.calendar.get(1)) + ((this.eOF.intValue() + (i % 12)) / 12);
        if (this.eOD.first != null) {
            i2 = ((com.tencent.mm.plugin.chatroom.c.a) this.eOD.first).evg;
            i3 = i2;
            i2 = ((com.tencent.mm.plugin.chatroom.c.a) this.eOD.first).month;
            i4 = ((com.tencent.mm.plugin.chatroom.c.a) this.eOD.first).year;
        } else {
            i4 = -1;
            i2 = -1;
            i3 = -1;
        }
        if (this.eOD.eOI != null) {
            int i8 = ((com.tencent.mm.plugin.chatroom.c.a) this.eOD.eOI).evg;
            i5 = ((com.tencent.mm.plugin.chatroom.c.a) this.eOD.eOI).month;
            i7 = ((com.tencent.mm.plugin.chatroom.c.a) this.eOD.eOI).year;
            i6 = i5;
            i5 = i8;
        } else {
            i6 = -1;
            i5 = -1;
        }
        bVar.eUh = 6;
        bVar.requestLayout();
        hashMap.put("selected_begin_year", Integer.valueOf(i4));
        hashMap.put("selected_last_year", Integer.valueOf(i7));
        hashMap.put("selected_begin_month", Integer.valueOf(i2));
        hashMap.put("selected_last_month", Integer.valueOf(i6));
        hashMap.put("selected_begin_day", Integer.valueOf(i3));
        hashMap.put("selected_last_day", Integer.valueOf(i5));
        hashMap.put("year", Integer.valueOf(intValue2));
        hashMap.put("month", Integer.valueOf(intValue));
        hashMap.put("week_start", Integer.valueOf(this.calendar.getFirstDayOfWeek()));
        Collection collection = this.eOE;
        if (collection != null) {
            bVar.eQh = collection;
        } else {
            v.e("MicroMsg.SimpleMonthView", "markDateList is null");
        }
        bVar.c(hashMap);
        bVar.invalidate();
    }

    public b(Context context, a aVar, TypedArray typedArray, long j, Collection<com.tencent.mm.plugin.chatroom.c.a> collection) {
        this.eOB = typedArray;
        this.eOG = Integer.valueOf(typedArray.getInt(20, this.calendar.get(2) % 12));
        if (-1 != j) {
            this.calendar.setTimeInMillis(j);
        }
        this.eOF = Integer.valueOf(typedArray.getInt(19, this.calendar.get(2)));
        this.eOH = typedArray.getBoolean(18, false);
        this.eOD = new a();
        this.eOE = collection;
        this.mContext = context;
        this.eOC = aVar;
        if (this.eOB.getBoolean(16, false)) {
            c(new com.tencent.mm.plugin.chatroom.c.a(System.currentTimeMillis()));
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemCount() {
        int i = ((new com.tencent.mm.plugin.chatroom.c.a(this.eOC.acZ()).year - this.calendar.get(1)) + 1) * 12;
        if (this.eOF.intValue() != -1) {
            i -= this.eOF.intValue();
        }
        if (this.eOG.intValue() != -1) {
            return i - ((12 - this.eOG.intValue()) - 1);
        }
        return i;
    }

    public final void b(com.tencent.mm.plugin.chatroom.c.a aVar) {
        if (aVar != null) {
            c(aVar);
        }
    }

    private void c(com.tencent.mm.plugin.chatroom.c.a aVar) {
        this.eOC.a(aVar);
        if (!this.eOH) {
            this.eOD.first = aVar;
        } else if (this.eOD.first != null && this.eOD.eOI == null) {
            this.eOD.eOI = aVar;
            if (((com.tencent.mm.plugin.chatroom.c.a) this.eOD.first).month < aVar.month) {
                for (int i = 0; i < (((com.tencent.mm.plugin.chatroom.c.a) this.eOD.first).month - aVar.month) - 1; i++) {
                    this.eOC.a(aVar);
                }
            }
        } else if (this.eOD.eOI != null) {
            this.eOD.first = aVar;
            this.eOD.eOI = null;
        } else {
            this.eOD.first = aVar;
        }
        this.Zi.notifyChanged();
    }
}
