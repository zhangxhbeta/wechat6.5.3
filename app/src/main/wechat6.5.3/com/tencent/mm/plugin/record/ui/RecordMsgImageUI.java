package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.record.a.s;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RecordMsgImageUI extends MMActivity implements com.tencent.mm.plugin.record.a.i.a {
    private long bao = -1;
    private MMGestureGallery eIS;
    private l eIV;
    private List<pw> eyh = new LinkedList();
    private d fNB = new d(this) {
        final /* synthetic */ RecordMsgImageUI iqG;

        {
            this.iqG = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 0:
                    RecordMsgImageUI.f(this.iqG);
                    return;
                case 1:
                    Object obj = this.iqG;
                    bp bpVar = new bp();
                    com.tencent.mm.pluginsdk.model.d.a(bpVar, obj.getIntent().getIntExtra("key_favorite_source_type", 1), obj.aJT());
                    bpVar.aZd.aZl = 10;
                    bpVar.aZd.aXH = obj;
                    com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                    return;
                case 2:
                    com.tencent.mm.pluginsdk.ui.tools.l.h(this.iqG.aJT(), this.iqG.nDR.nEl);
                    return;
                default:
                    return;
            }
        }
    };
    private Runnable fNf = new Runnable(this) {
        final /* synthetic */ RecordMsgImageUI iqG;

        {
            this.iqG = r1;
        }

        public final void run() {
            this.iqG.iqD.notifyDataSetChanged();
        }
    };
    private a iqD;
    private int iqE = 0;
    private String iqF = null;
    private j iqw;

    private static class a extends BaseAdapter {
        long bao;
        List<pw> eyh;
        j iqw;

        private a() {
            this.eyh = new LinkedList();
            this.bao = -1;
        }

        public final /* synthetic */ Object getItem(int i) {
            return oN(i);
        }

        public final int getCount() {
            return this.eyh.size();
        }

        public final pw oN(int i) {
            return (pw) this.eyh.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            j jVar = this.iqw;
            pw oN = oN(i);
            long j = this.bao;
            Bitmap a = jVar.a(oN, j, false, false);
            if (a == null) {
                v.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[]{Boolean.valueOf(jVar.a(oN, j))});
                m.a(oN, j, r0);
            }
            if (a == null) {
                v.w("MicroMsg.ShowImageUI", "get image fail");
                if (view == null || (view instanceof MultiTouchImageView)) {
                    view = View.inflate(viewGroup.getContext(), 2130904390, null);
                }
                ((ImageView) view.findViewById(2131756901)).setImageResource(2131165477);
                view.setLayoutParams(new LayoutParams(-1, -1));
            } else {
                Context context = viewGroup.getContext();
                if (view == null || !(view instanceof MultiTouchImageView)) {
                    view = new MultiTouchImageView(context, a.getWidth(), a.getHeight());
                } else {
                    MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                    multiTouchImageView.di(a.getWidth(), a.getHeight());
                }
                k.h(view, a.getWidth(), a.getHeight());
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(a);
                view.oad = true;
            }
            return view;
        }
    }

    static /* synthetic */ void d(RecordMsgImageUI recordMsgImageUI) {
        final List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        arrayList.add(Integer.valueOf(0));
        arrayList2.add(recordMsgImageUI.getString(2131234560));
        arrayList.add(Integer.valueOf(1));
        arrayList2.add(recordMsgImageUI.getString(2131234180));
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(recordMsgImageUI.getString(2131234727));
        if (recordMsgImageUI.eIV == null) {
            recordMsgImageUI.eIV = new l(recordMsgImageUI.nDR.nEl);
        }
        recordMsgImageUI.eIV.jXn = new c(recordMsgImageUI) {
            final /* synthetic */ RecordMsgImageUI iqG;

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.setHeaderTitle("");
                for (int i = 0; i < arrayList.size(); i++) {
                    lVar.d(((Integer) arrayList.get(i)).intValue(), (CharSequence) arrayList2.get(i));
                }
            }
        };
        recordMsgImageUI.eIV.jXo = recordMsgImageUI.fNB;
        recordMsgImageUI.eIV.d(new OnCancelListener(recordMsgImageUI) {
            final /* synthetic */ RecordMsgImageUI iqG;

            {
                this.iqG = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.iqG.eIV = null;
            }
        });
        g.a(recordMsgImageUI.nDR.nEl, recordMsgImageUI.eIV.aXZ());
    }

    static /* synthetic */ void f(RecordMsgImageUI recordMsgImageUI) {
        recordMsgImageUI.iqF = recordMsgImageUI.aJT();
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", recordMsgImageUI.iqF);
        com.tencent.mm.ay.c.a(recordMsgImageUI, ".ui.transmit.SelectConversationUI", intent, 1001);
    }

    protected final int getLayoutId() {
        return 2130904389;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(1024, 1024);
        }
        this.iqw = new j();
        this.bao = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        com.tencent.mm.protocal.b.a.c yy = m.yy(getIntent().getStringExtra("record_xml"));
        if (yy == null) {
            v.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
            finish();
            return;
        }
        Iterator it = yy.cqE.iterator();
        while (it.hasNext()) {
            pw pwVar = (pw) it.next();
            if (pwVar.aKG == 2) {
                this.eyh.add(pwVar);
                if (pwVar.luu.equals(stringExtra)) {
                    this.iqE = this.eyh.size() - 1;
                }
            }
        }
        if (this.eyh.isEmpty()) {
            v.w("MicroMsg.ShowImageUI", "get image data error, empty");
            finish();
            return;
        }
        this.eIS = (MMGestureGallery) findViewById(2131755843);
        this.eIS.setVerticalFadingEdgeEnabled(false);
        this.eIS.setHorizontalFadingEdgeEnabled(false);
        this.iqD = new a();
        this.iqD.eyh = this.eyh;
        this.iqD.bao = this.bao;
        this.iqD.iqw = this.iqw;
        this.eIS.setAdapter(this.iqD);
        this.eIS.setSelection(this.iqE);
        this.eIS.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final /* synthetic */ RecordMsgImageUI iqG;

            {
                this.iqG = r1;
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (m.d(this.iqG.iqD.oN(i), this.iqG.bao)) {
                    this.iqG.Fd(String.format("%d/%d", new Object[]{Integer.valueOf(i + 1), Integer.valueOf(this.iqG.eyh.size())}));
                    this.iqG.iT(true);
                    return;
                }
                this.iqG.iT(false);
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.eIS.oTm = new f(this) {
            final /* synthetic */ RecordMsgImageUI iqG;

            {
                this.iqG = r1;
            }

            public final void abF() {
                this.iqG.finish();
            }
        };
        this.eIS.oTn = new MMGestureGallery.c(this) {
            final /* synthetic */ RecordMsgImageUI iqG;

            {
                this.iqG = r1;
            }

            public final void amC() {
                RecordMsgImageUI.d(this.iqG);
            }
        };
        iR(true);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RecordMsgImageUI iqG;

            {
                this.iqG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iqG.finish();
                return true;
            }
        });
        s.aJE().a((com.tencent.mm.plugin.record.a.i.a) this);
    }

    protected void onDestroy() {
        super.onDestroy();
        s.aJE().b((com.tencent.mm.plugin.record.a.i.a) this);
        this.iqw.destory();
    }

    final String aJT() {
        int selectedItemPosition = this.eIS.getSelectedItemPosition();
        if (-1 == selectedItemPosition) {
            v.w("MicroMsg.ShowImageUI", "error position");
            return null;
        }
        v.d("MicroMsg.ShowImageUI", "cur pos %d path %s", new Object[]{Integer.valueOf(selectedItemPosition), m.c(this.iqD.oN(selectedItemPosition), this.bao)});
        return m.c(this.iqD.oN(selectedItemPosition), this.bao);
    }

    protected final void bB(View view) {
        w.c(w.a(getWindow(), null), this.nDR.nDX);
        ((ViewGroup) this.nDR.nDX.getParent()).removeView(this.nDR.nDX);
        ((ViewGroup) getWindow().getDecorView()).addView(this.nDR.nDX, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1001 == i && -1 == i2) {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            final String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (!be.kS(stringExtra)) {
                final List g = be.g(stringExtra.split(","));
                if (be.bP(g)) {
                    v.w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
                    return;
                }
                final p a = g.a(this.nDR.nEl, getString(2131232670), false, null);
                final Runnable anonymousClass9 = new Runnable(this) {
                    final /* synthetic */ RecordMsgImageUI iqG;

                    public final void run() {
                        a.dismiss();
                    }
                };
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ RecordMsgImageUI iqG;

                    public final void run() {
                        for (String str : g) {
                            com.tencent.mm.pluginsdk.j.a.bmt().a(this.iqG.nDR.nEl, str, this.iqG.iqF, 0, "", "");
                            com.tencent.mm.pluginsdk.j.a.bmt().df(stringExtra2, str);
                        }
                        ad.o(anonymousClass9);
                    }

                    public final String toString() {
                        return super.toString() + "|onActivityResult";
                    }
                });
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void a(int i, com.tencent.mm.plugin.record.a.g gVar) {
        for (pw pwVar : this.eyh) {
            if (pwVar.luu.equals(gVar.field_dataId)) {
                ad.o(this.fNf);
                return;
            }
        }
    }
}
