package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.o;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class m {
    private View Hq;
    private OnItemClickListener abT = new OnItemClickListener(this) {
        final /* synthetic */ m lOo;

        {
            this.lOo = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.tencent.mm.storage.a.c jP = this.lOo.lOh == null ? null : this.lOo.lOh.jP(i);
            if (!(jP == null || this.lOo.lOc == null || this.lOo.lMH == null)) {
                this.lOo.lOc.n(jP);
                this.lOo.lMH.clear();
                String str = this.lOo.lOi == null ? SQLiteDatabase.KeyEmpty : this.lOo.lOi.field_expId;
                g.iuh.h(10994, Integer.valueOf(1), this.lOo.lOd, str, Integer.valueOf(i), jP.EB());
            }
            this.lOo.lNZ.dismiss();
        }
    };
    private View eEX;
    ArrayList<com.tencent.mm.storage.a.c> fjj = new ArrayList();
    a lMH;
    private View lNG;
    int lNX;
    int lNY;
    o lNZ;
    private View lOa;
    View lOb;
    k lOc;
    String lOd;
    public String lOe = SQLiteDatabase.KeyEmpty;
    public boolean lOf = true;
    private HorizontalListView lOg;
    b lOh;
    com.tencent.mm.storage.c lOi;
    private int lOj = 1;
    private boolean lOk = false;
    int lOl = 3000;
    private Comparator lOm = new Comparator<com.tencent.mm.storage.a.c>(this) {
        final /* synthetic */ m lOo;

        {
            this.lOo = r1;
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            com.tencent.mm.storage.a.c cVar = (com.tencent.mm.storage.a.c) obj;
            com.tencent.mm.storage.a.c cVar2 = (com.tencent.mm.storage.a.c) obj2;
            if (cVar == null && cVar2 == null) {
                return 0;
            }
            if (cVar != null) {
                if (cVar2 == null) {
                    return 1;
                }
                if (cVar.field_lastUseTime == cVar2.field_lastUseTime) {
                    return 0;
                }
                if (cVar.field_lastUseTime > cVar2.field_lastUseTime) {
                    return 1;
                }
            }
            return -1;
        }
    };
    private com.tencent.mm.ui.base.HorizontalListView.a lOn = new com.tencent.mm.ui.base.HorizontalListView.a(this) {
        final /* synthetic */ m lOo;

        {
            this.lOo = r1;
        }

        public final boolean v(MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.lOo.mHandler.sendEmptyMessage(20002);
                    break;
                case 1:
                case 3:
                    this.lOo.mHandler.sendEmptyMessageDelayed(20001, (long) this.lOo.lOl);
                    break;
            }
            return false;
        }
    };
    Context mContext;
    ac mHandler = new ac(this) {
        final /* synthetic */ m lOo;

        {
            this.lOo = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 20001:
                    this.lOo.hide();
                    return;
                case 20002:
                    removeMessages(20001);
                    return;
                case 20003:
                    m mVar = this.lOo;
                    mVar.mHandler.removeMessages(20001);
                    if (mVar.lOf) {
                        b bVar = mVar.lOh;
                        bVar.mData = mVar.fjj;
                        bVar.notifyDataSetInvalidated();
                        if (mVar.fjj != null && mVar.fjj.size() > 2) {
                            mVar.lNZ.setWidth(((int) (((double) mVar.lNX) * 2.5d)) + (mVar.lNY * 2));
                        } else if (mVar.fjj == null || mVar.fjj.size() != 2) {
                            mVar.lNZ.setWidth(mVar.lNX + (mVar.lNY * 2));
                        } else {
                            mVar.lNZ.setWidth((mVar.lNX * 2) + (mVar.lNY * 2));
                        }
                        mVar.bqt();
                        mVar.mHandler.sendEmptyMessageDelayed(20001, (long) mVar.lOl);
                        String str = mVar.lOi == null ? SQLiteDatabase.KeyEmpty : mVar.lOi.field_expId;
                        g.iuh.h(10994, Integer.valueOf(0), mVar.lOd, str, Integer.valueOf(0), SQLiteDatabase.KeyEmpty);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ String dpn;
        final /* synthetic */ m lOo;

        public AnonymousClass6(m mVar, String str) {
            this.lOo = mVar;
            this.dpn = str;
        }

        public final void run() {
            if (this.lOo.bc(this.dpn)) {
                this.lOo.mHandler.sendEmptyMessage(20003);
            } else {
                v.d("MicroMsg.emoji.SuggestEmoticonBubble", "check false");
            }
        }
    }

    public interface a {
        void clear();
    }

    class b extends BaseAdapter {
        final /* synthetic */ m lOo;
        ArrayList<com.tencent.mm.storage.a.c> mData;

        b(m mVar) {
            this.lOo = mVar;
        }

        public final /* synthetic */ Object getItem(int i) {
            return jP(i);
        }

        public final int getCount() {
            return this.mData == null ? 0 : this.mData.size();
        }

        public final com.tencent.mm.storage.a.c jP(int i) {
            if (this.mData == null || this.mData.size() <= i) {
                return null;
            }
            return (com.tencent.mm.storage.a.c) this.mData.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.lOo.mContext).inflate(2130903292, null);
                cVar = new c(this.lOo, view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            com.tencent.mm.storage.a.c jP = jP(i);
            cVar.ffy.hO = this.lOo.lNX;
            cVar.ffy.setScaleType(ScaleType.CENTER_INSIDE);
            if (jP == null) {
                v.w("MicroMsg.emoji.SuggestEmoticonBubble", "emoji info is null.");
            } else if (jP.bxG()) {
                cVar.ffy.a(com.tencent.mm.storage.a.c.ba(this.lOo.mContext, jP.getName()), jP.getName());
            } else {
                cVar.ffy.a(jP, SQLiteDatabase.KeyEmpty);
            }
            return view;
        }
    }

    class c {
        PreViewEmojiView ffy;
        final /* synthetic */ m lOo;

        public c(m mVar, View view) {
            this.lOo = mVar;
            this.ffy = (PreViewEmojiView) view.findViewById(2131756066);
            this.ffy.hO = mVar.lNX;
        }
    }

    public m(Context context, View view, View view2, View view3) {
        this.mContext = context;
        this.eEX = view;
        this.lNG = view2;
        this.lOa = view3;
        this.Hq = View.inflate(this.mContext, 2130903291, null);
        this.lOg = (HorizontalListView) this.Hq.findViewById(2131756090);
        this.lOh = new b(this);
        this.lOg.setAdapter(this.lOh);
        this.lOg.setOnItemClickListener(this.abT);
        this.lOg.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final /* synthetic */ m lOo;

            {
                this.lOo = r1;
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                v.d("MicroMsg.emoji.SuggestEmoticonBubble", "onItemSelected ...");
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.lOg.lOn = this.lOn;
        this.lNX = com.tencent.mm.bd.a.N(this.mContext, 2131493445);
        this.lNY = com.tencent.mm.bd.a.N(this.mContext, 2131493152);
        this.lNZ = new o(this.Hq, this.lNX + (this.lNY * 2), this.lNX + (this.lNY * 2), true);
        this.lNZ.setBackgroundDrawable(new ColorDrawable(0));
        this.lNZ.setOutsideTouchable(true);
        this.lNZ.setFocusable(false);
        this.lOi = com.tencent.mm.pluginsdk.j.a.bmr().rd("100130");
        if (this.lOi != null) {
            String a = com.tencent.mm.pluginsdk.j.a.bmr().a(this.lOi, "showCount");
            String a2 = com.tencent.mm.pluginsdk.j.a.bmr().a(this.lOi, "lastUseFirst");
            String a3 = com.tencent.mm.pluginsdk.j.a.bmr().a(this.lOi, "showTime");
            if (!be.kS(a)) {
                this.lOj = be.getInt(a, 1);
            }
            if (!be.kS(a2)) {
                boolean z;
                if (be.getInt(a2, 0) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.lOk = z;
            }
            if (!be.kS(a3)) {
                this.lOl = be.getInt(a3, 3000);
            }
        }
        v.i("MicroMsg.emoji.SuggestEmoticonBubble", "show count:%d lastuseFirst:%b", Integer.valueOf(this.lOj), Boolean.valueOf(this.lOk));
    }

    public final void bqt() {
        if (this.lOb != null) {
            int[] iArr = new int[2];
            this.lOb.getLocationOnScreen(iArr);
            this.lNZ.showAtLocation(this.lOb, 0, iArr[0] - ((this.lNZ.getWidth() - this.lOb.getWidth()) / 2), iArr[1] - this.lNZ.getHeight());
        }
    }

    public final void hide() {
        if (this.lNZ != null && this.lNZ.isShowing()) {
            this.lNZ.dismiss();
        }
    }

    public final boolean bc(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.lOd = str;
                ArrayList rm = com.tencent.mm.pluginsdk.j.a.bmr().rm(str);
                if (!(rm == null || rm.isEmpty())) {
                    if (rm != null && !rm.isEmpty()) {
                        com.tencent.mm.storage.a.c rg;
                        ArrayList arrayList = new ArrayList();
                        this.fjj.clear();
                        Iterator it = rm.iterator();
                        while (it.hasNext()) {
                            rg = com.tencent.mm.pluginsdk.j.a.bmr().rg((String) it.next());
                            if (rg != null) {
                                arrayList.add(rg);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            v.i("MicroMsg.emoji.SuggestEmoticonBubble", "sorEmojiList return. empty list.");
                        } else if (this.lOj == 1) {
                            if (this.lOk) {
                                this.fjj.add((com.tencent.mm.storage.a.c) Collections.max(arrayList, this.lOm));
                            } else {
                                this.fjj.add(arrayList.get(0));
                            }
                        } else if (this.lOj == 2) {
                            if (this.lOk) {
                                rg = (com.tencent.mm.storage.a.c) Collections.max(arrayList, this.lOm);
                                this.fjj.add(rg);
                                r4 = arrayList.iterator();
                                while (r4.hasNext()) {
                                    r1 = (com.tencent.mm.storage.a.c) r4.next();
                                    if (!r1.bi(rg) && !this.fjj.contains(r1)) {
                                        this.fjj.add(r1);
                                        break;
                                    }
                                }
                            } else {
                                int i = 0;
                                while (i < 2 && i < arrayList.size()) {
                                    if (!this.fjj.contains((com.tencent.mm.storage.a.c) arrayList.get(i))) {
                                        this.fjj.add(arrayList.get(i));
                                    }
                                    i++;
                                }
                            }
                        } else if (this.lOj <= 2) {
                            this.fjj.add(arrayList.get(0));
                        } else if (this.lOk) {
                            rg = (com.tencent.mm.storage.a.c) Collections.max(arrayList, this.lOm);
                            this.fjj.add(rg);
                            r4 = arrayList.iterator();
                            while (r4.hasNext()) {
                                r1 = (com.tencent.mm.storage.a.c) r4.next();
                                if (!(r1.bi(rg) || this.fjj.contains(r1))) {
                                    this.fjj.add(r1);
                                }
                            }
                        } else {
                            it = arrayList.iterator();
                            while (it.hasNext()) {
                                rg = (com.tencent.mm.storage.a.c) it.next();
                                if (!this.fjj.contains(rg)) {
                                    this.fjj.add(rg);
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        } catch (Throwable e) {
            v.e("MicroMsg.emoji.SuggestEmoticonBubble", be.e(e));
        }
        return false;
    }
}
