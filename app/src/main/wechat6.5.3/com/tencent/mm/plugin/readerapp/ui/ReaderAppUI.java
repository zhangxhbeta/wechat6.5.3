package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.o;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.readerapp.b.g;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.CustomFitTextView;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class ReaderAppUI extends MMActivity implements com.tencent.mm.platformtools.j.a {
    private static float density;
    private int blO = 0;
    private l eyZ;
    private String gVL = "";
    private View hFT;
    private ListView hkg;
    private MMPullDownView hkk;
    private d hkn = new d(this) {
        final /* synthetic */ ReaderAppUI ilA;

        {
            this.ilA = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            int groupId = menuItem.getGroupId();
            bc bcVar;
            long longValue;
            switch (menuItem.getItemId()) {
                case 0:
                    if (this.ilA.blO == 20) {
                        List c = g.aJg().c(((Long) this.ilA.ilv.getItem(groupId)).longValue(), this.ilA.blO);
                        if (c.size() > 0) {
                            bcVar = (bc) c.get(0);
                            com.tencent.mm.q.a.a aVar = new com.tencent.mm.q.a.a();
                            aVar.title = bcVar.getTitle();
                            aVar.description = bcVar.zL();
                            aVar.bXP = "view";
                            aVar.type = 5;
                            aVar.url = bcVar.getUrl();
                            String b = com.tencent.mm.q.a.a.b(aVar);
                            Intent intent = new Intent();
                            intent.putExtra("Retr_Msg_content", b);
                            intent.putExtra("Retr_Msg_Type", 2);
                            intent.putExtra("Retr_Msg_thumb_path", r.o(bcVar.zK(), bcVar.type, "@T"));
                            intent.putExtra("Retr_Msg_Id", 7377812);
                            b = o.fz(bcVar.cuU);
                            intent.putExtra("reportSessionId", b);
                            com.tencent.mm.model.o.b n = o.yx().n(b, true);
                            n.l("prePublishId", "msg_" + bcVar.cuU);
                            n.l("preUsername", "newsapp");
                            n.l("preChatName", "newsapp");
                            n.l("preMsgIndex", Integer.valueOf(0));
                            n.l("sendAppMsgScene", Integer.valueOf(1));
                            com.tencent.mm.plugin.readerapp.a.a.drp.l(intent, this.ilA);
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    if (this.ilA.blO == 20) {
                        List c2 = g.aJg().c(((Long) this.ilA.ilv.getItem(groupId)).longValue(), this.ilA.blO);
                        if (!c2.isEmpty()) {
                            v.i("MicroMsg.ReaderAppUI", "fav time %d, index %d, size %d", new Object[]{Long.valueOf(longValue), Integer.valueOf(this.ilA.ily), Integer.valueOf(c2.size())});
                            if (this.ilA.ily >= c2.size()) {
                                this.ilA.ily = 0;
                            }
                            bcVar = (bc) c2.get(this.ilA.ily);
                            bp bpVar = new bp();
                            String fz = o.fz(bcVar.cuU);
                            com.tencent.mm.model.o.b n2 = o.yx().n(fz, true);
                            n2.l("prePublishId", "msg_" + bcVar.cuU);
                            n2.l("preUsername", "newsapp");
                            n2.l("preChatName", "newsapp");
                            n2.l("preMsgIndex", Integer.valueOf(0));
                            n2.l("sendAppMsgScene", Integer.valueOf(1));
                            bpVar.aZd.aZj = fz;
                            com.tencent.mm.plugin.readerapp.b.b.a(bpVar, bcVar, this.ilA.ily);
                            bpVar.aZd.aZl = 7;
                            bpVar.aZd.aXH = this.ilA;
                            com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    longValue = ((Long) this.ilA.ilv.getItem(groupId)).longValue();
                    if (longValue != 0) {
                        g.r(longValue, this.ilA.blO);
                        bd aJg = g.aJg();
                        int a = this.ilA.blO;
                        v.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", new Object[]{"delete from " + bd.eP(a) + " where time = " + longValue});
                        if (aJg.cuX.dF(bd.eP(a), "delete from " + bd.eP(a) + " where time = " + longValue)) {
                            aJg.eS(a);
                            aJg.Ls();
                        }
                    }
                    this.ilA.refresh();
                    return;
                default:
                    return;
            }
        }
    };
    private a<Long> ilv;
    private e ilw = null;
    private ac ilx = new ac();
    private int ily = 0;

    class a extends a<Long> {
        private Context context;
        private int eKW;
        private int emv;
        final /* synthetic */ ReaderAppUI ilA;
        private ImageGetter ilD = new ImageGetter(this) {
            final /* synthetic */ a ilH;

            {
                this.ilH = r1;
            }

            public final Drawable getDrawable(String str) {
                Drawable drawable = this.ilH.ilA.getResources().getDrawable(be.getInt(str, 0));
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                return drawable;
            }
        };
        private int ilE = 0;
        private int ilF = 0;
        private int ilG = 0;

        final class a {
            TextView dID;
            final /* synthetic */ a ilH;
            View ilI;
            View ilJ;
            ImageView ilK;
            ImageView ilL;
            ProgressBar ilM;
            View ilN;

            a(a aVar) {
                this.ilH = aVar;
            }
        }

        final class b {
            TextView dID;
            TextView grr;
            TextView hka;
            final /* synthetic */ a ilH;
            ProgressBar ilM;
            View ilN;
            TextView ilO;
            ImageView ilP;
            View ilQ;
            ViewGroup ilR;
            ViewGroup ilS;
            CustomFitTextView ilT;
            LinearLayout ilU;
            List<a> ilV;

            b(a aVar) {
                this.ilH = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            return Long.valueOf(cursor.getLong(0));
        }

        public final /* synthetic */ Object getItem(int i) {
            return oF(i);
        }

        public a(ReaderAppUI readerAppUI, Context context, Long l) {
            this.ilA = readerAppUI;
            super(context, l);
            this.context = context;
            this.eKW = 3;
            this.emv = g.aJg().eQ(readerAppUI.blO);
            this.ilF = context.getResources().getDimensionPixelSize(2131493199);
            this.ilG = context.getResources().getDimensionPixelSize(2131493030);
            this.ilE = context.getResources().getDimensionPixelSize(2131492962);
        }

        protected final void Om() {
            Ol();
        }

        public final boolean abO() {
            return this.eKW >= this.emv;
        }

        public final int aJh() {
            return this.eKW;
        }

        public final int abP() {
            if (abO()) {
                return 0;
            }
            this.eKW += 3;
            if (this.eKW <= this.emv) {
                return 3;
            }
            this.eKW = this.emv;
            return this.emv % 3;
        }

        public final void Ol() {
            this.emv = g.aJg().eQ(20);
            setCursor(g.aJg().aF(this.eKW, 20));
            super.notifyDataSetChanged();
        }

        private Long oF(int i) {
            return (Long) super.getItem(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            int i2;
            v.w("MicroMsg.ReaderAppUI", "ashutest get view position %d", new Object[]{Integer.valueOf(i)});
            if (view == null) {
                bVar = new b(this);
                view = View.inflate(this.context, 2130904227, null);
                bVar.grr = (TextView) view.findViewById(2131758769);
                bVar.ilS = (ViewGroup) view.findViewById(2131758770);
                bVar.dID = (TextView) view.findViewById(2131758771);
                bVar.ilO = (TextView) view.findViewById(2131758772);
                bVar.ilP = (ImageView) view.findViewById(2131758773);
                bVar.hka = (TextView) view.findViewById(2131758775);
                bVar.ilQ = view.findViewById(2131756098);
                bVar.ilR = (ViewGroup) view.findViewById(2131758774);
                bVar.ilT = (CustomFitTextView) view.findViewById(2131756101);
                bVar.ilU = (LinearLayout) view.findViewById(2131756105);
                bVar.ilM = (ProgressBar) view.findViewById(2131756102);
                bVar.ilN = view.findViewById(2131756103);
                bVar.ilV = new ArrayList();
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            for (a aVar : bVar.ilV) {
                bVar.ilS.removeView(aVar.ilI);
            }
            bVar.ilV.clear();
            final List c = g.aJg().c(oF(i).longValue(), 20);
            if (c.size() > 0) {
                int size = c.size();
                bc bcVar = (bc) c.get(0);
                bVar.dID.setText(bcVar.getTitle());
                bVar.hka.setText(bcVar.zL());
                bVar.grr.setText(com.tencent.mm.pluginsdk.j.o.c(this.context, bcVar.time, false));
                bVar.ilO.setText(com.tencent.mm.pluginsdk.j.o.F(this.context.getString(2131232866), bcVar.cuP));
                if (this.ilA.ilw != null) {
                    bVar.grr.setTextColor(this.ilA.ilw.lGe);
                    if (this.ilA.ilw.lGf) {
                        bVar.grr.setShadowLayer(2.0f, 1.2f, 1.2f, this.ilA.ilw.lGg);
                    } else {
                        bVar.grr.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                    }
                    if (this.ilA.ilw.lGh) {
                        bVar.grr.setBackgroundResource(2130837935);
                        bVar.grr.setPadding(this.ilF, this.ilE, this.ilF, this.ilE);
                    } else {
                        bVar.grr.setBackgroundColor(0);
                    }
                }
                boolean z = true;
                bVar.ilM.setVisibility(8);
                bVar.ilN.setVisibility(8);
                if (bcVar.zF()) {
                    bVar.ilT.c(bcVar.getTitle(), 4, true, 2130839025);
                } else {
                    bVar.ilT.c(bcVar.getTitle(), 4, false, -1);
                }
                if (be.kS(bcVar.zK())) {
                    bVar.ilP.setVisibility(8);
                    z = false;
                } else {
                    bVar.ilP.setVisibility(0);
                    bVar.ilP.setImageBitmap(j.a(new r(bcVar.zK(), bcVar.type, "@T", this.fHM)));
                }
                bVar.ilQ.setOnClickListener(this.ilA.a(bcVar, this.ilA.blO, 0));
                if (size > 1) {
                    a(bVar, false, z);
                    for (i2 = 1; i2 < size - 1; i2++) {
                        a(bVar, c, 2130904234, i2);
                    }
                    a(bVar, c, 2130904233, size - 1);
                } else {
                    a(bVar, true, !z);
                }
            }
            OnLongClickListener anonymousClass2 = new OnLongClickListener(this) {
                final /* synthetic */ a ilH;

                public final boolean onLongClick(View view) {
                    this.ilH.ilA.eyZ.b(view, new OnCreateContextMenuListener(this.ilH.ilA, c.size() == 1) {
                        final /* synthetic */ ReaderAppUI ilA;

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            int intValue = ((Integer) view.getTag()).intValue();
                            contextMenu.clear();
                            if (this.ilA.blO == 20) {
                                contextMenu.setHeaderTitle(2131233260);
                            } else {
                                contextMenu.setHeaderTitle(2131233263);
                            }
                            if (20 == this.ilA.blO) {
                                if (r2) {
                                    contextMenu.add(intValue, 0, 1, 2131234316);
                                }
                                if (c.EH("favorite")) {
                                    contextMenu.add(intValue, 1, 2, 2131234180);
                                }
                                this.ilA.ily = ((Integer) view.getTag(2131755066)).intValue();
                            }
                            contextMenu.add(intValue, 2, 3, 2131234315);
                        }
                    }, this.ilH.ilA.hkn);
                    return true;
                }
            };
            bVar.ilQ.setTag(Integer.valueOf(i));
            bVar.ilQ.setTag(2131755066, Integer.valueOf(0));
            bVar.ilQ.setOnLongClickListener(anonymousClass2);
            int i3 = 1;
            for (a aVar2 : bVar.ilV) {
                aVar2.ilI.setTag(Integer.valueOf(i));
                aVar2.ilI.setOnLongClickListener(anonymousClass2);
                View view2 = aVar2.ilI;
                i2 = i3 + 1;
                view2.setTag(2131755066, Integer.valueOf(i3));
                i3 = i2;
            }
            return view;
        }

        private void a(b bVar, List<bc> list, int i, int i2) {
            a aVar = new a(this);
            aVar.ilI = View.inflate(this.context, i, null);
            aVar.dID = (TextView) aVar.ilI.findViewById(2131755226);
            aVar.ilK = (ImageView) aVar.ilI.findViewById(2131756093);
            aVar.ilL = (ImageView) aVar.ilI.findViewById(2131758781);
            aVar.ilJ = aVar.ilI.findViewById(2131756109);
            aVar.ilM = (ProgressBar) aVar.ilI.findViewById(2131756110);
            aVar.ilN = aVar.ilI.findViewById(2131756111);
            if (bVar != null) {
                bVar.ilS.addView(aVar.ilI);
                bVar.ilV.add(aVar);
            }
            bc bcVar = (bc) list.get(i2);
            aVar.dID.setText(bcVar.getTitle());
            aVar.ilM.setVisibility(8);
            aVar.ilN.setVisibility(8);
            if (bcVar.zF()) {
                aVar.dID.setText(Html.fromHtml(bcVar.getTitle() + "<img src='2130839026'/>", this.ilD, null));
            } else {
                aVar.dID.setText(bcVar.getTitle());
            }
            if (be.kS(bcVar.zK())) {
                aVar.ilJ.setVisibility(8);
                aVar.ilL.setVisibility(8);
            } else {
                aVar.ilK.setVisibility(0);
                aVar.ilK.setImageBitmap(j.a(new r(bcVar.zK(), bcVar.type, "@S", this.fHM)));
            }
            aVar.ilI.setOnClickListener(this.ilA.a(bcVar, this.ilA.blO, i2));
        }

        private void a(b bVar, boolean z, boolean z2) {
            int i;
            int i2 = 0;
            bVar.ilU.setVisibility(z ? 0 : 8);
            if (z) {
                bVar.ilQ.setBackgroundResource(2130839022);
                bVar.ilQ.setPadding(this.ilG, this.ilG, this.ilG, this.ilG);
            } else {
                bVar.ilQ.setBackgroundResource(2130839020);
                bVar.ilQ.setPadding(this.ilG, this.ilG, this.ilG, this.ilF);
            }
            TextView textView = bVar.dID;
            if (z || !(z || z2)) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            textView = bVar.ilO;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            textView = bVar.hka;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            ViewGroup viewGroup = bVar.ilR;
            if (z || !z2) {
                i2 = 8;
            }
            viewGroup.setVisibility(i2);
        }
    }

    class b extends a<Long> {
        private Context context;
        private int eKW = 3;
        private int emv = this.eKW;
        final /* synthetic */ ReaderAppUI ilA;
        private int ilE;
        private int ilF;

        class a {
            TextView grr;
            ReaderItemListView ilW;
            final /* synthetic */ b ilX;

            a(b bVar) {
                this.ilX = bVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            return Long.valueOf(cursor.getLong(0));
        }

        public b(ReaderAppUI readerAppUI, Context context, Long l) {
            this.ilA = readerAppUI;
            super(context, l);
            this.context = context;
            this.ilE = context.getResources().getDimensionPixelSize(2131492962);
            this.ilF = context.getResources().getDimensionPixelSize(2131493199);
        }

        protected final void Om() {
            Ol();
        }

        public final boolean abO() {
            return this.eKW >= this.emv;
        }

        public final int aJh() {
            return this.eKW;
        }

        public final int abP() {
            if (abO()) {
                return 0;
            }
            this.eKW += 3;
            if (this.eKW <= this.emv) {
                return 3;
            }
            this.eKW = this.emv;
            return this.emv % 3;
        }

        public final void Ol() {
            this.emv = g.aJg().eQ(this.ilA.blO);
            setCursor(g.aJg().aF(this.eKW, this.ilA.blO));
            super.notifyDataSetChanged();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                aVar = new a(this);
                view = View.inflate(this.context, 2130904228, null);
                aVar.ilW = (ReaderItemListView) view.findViewById(2131758776);
                aVar.grr = (TextView) view.findViewById(2131758769);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.grr.setText(com.tencent.mm.pluginsdk.j.o.c(this.context, ((Long) getItem(i)).longValue(), false));
            ReaderItemListView readerItemListView = aVar.ilW;
            long longValue = ((Long) getItem(i)).longValue();
            OnCreateContextMenuListener a = /* anonymous class already generated */;
            d g = this.ilA.hkn;
            readerItemListView.position = i;
            readerItemListView.ima = a;
            readerItemListView.hkn = g;
            readerItemListView.ilY = g.aJg().c(longValue, readerItemListView.type);
            readerItemListView.ilZ.notifyDataSetChanged();
            if (this.ilA.ilw != null) {
                aVar.grr.setTextColor(this.ilA.ilw.lGe);
                if (this.ilA.ilw.lGf) {
                    aVar.grr.setShadowLayer(2.0f, 1.2f, 1.2f, this.ilA.ilw.lGg);
                } else {
                    aVar.grr.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                }
                if (this.ilA.ilw.lGh) {
                    aVar.grr.setBackgroundResource(2130837935);
                    aVar.grr.setPadding(this.ilF, this.ilE, this.ilF, this.ilE);
                } else {
                    aVar.grr.setBackgroundColor(0);
                }
            }
            return view;
        }
    }

    static /* synthetic */ String a(ReaderAppUI readerAppUI, String str) {
        int i = 1;
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.ReaderAppUI", "appendArgs fail, srcUrl is null");
            return "";
        }
        int i2;
        List linkedList;
        String format;
        PackageInfo ys = readerAppUI.ys("com.tencent.news");
        if (ys == null) {
            v.i("MicroMsg.ReaderAppUI", "isNewsInstallAndSupport false, pkgInfo is null");
        } else if (ys.versionCode >= 220) {
            i2 = 1;
            if (i2 == 0) {
                i = 0;
            }
            v.i("MicroMsg.ReaderAppUI", "appendArgsForNews, isNewsInstallAndSupport = " + i);
            linkedList = new LinkedList();
            linkedList.add(new BasicNameValuePair("isappinstalled", String.valueOf(i)));
            format = URLEncodedUtils.format(linkedList, "utf-8");
            return str.contains("?") ? str + "&" + format : str + "?" + format;
        }
        i2 = 0;
        if (i2 == 0) {
            i = 0;
        }
        v.i("MicroMsg.ReaderAppUI", "appendArgsForNews, isNewsInstallAndSupport = " + i);
        linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("isappinstalled", String.valueOf(i)));
        format = URLEncodedUtils.format(linkedList, "utf-8");
        if (str.contains("?")) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.blO = getIntent().getIntExtra("type", 0);
        density = com.tencent.mm.bd.a.getDensity(this);
        NI();
        this.gVL = bc.eO(this.blO);
    }

    public void onDestroy() {
        if (this.ilv != null) {
            this.ilv.avc();
            this.ilv.nDK = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904222;
    }

    protected void onResume() {
        super.onResume();
        j.b(this);
        if (this.blO == 20) {
            vD(2131233260);
        } else {
            vD(2131233263);
        }
        ak.oH().db(this.gVL);
        ak.oH().cancelNotification(this.gVL);
        ak.yW();
        com.tencent.mm.model.c.wK().Mj(this.gVL);
        g.aJg().c(this.ilv);
        this.ilv.a(null, null);
        refresh();
    }

    protected void onPause() {
        super.onPause();
        ak.oH().db("");
        g.aJg().d(this.ilv);
        j.c(this);
        ak.yW();
        com.tencent.mm.model.c.wK().Mj(this.gVL);
    }

    public final void refresh() {
        TextView textView = (TextView) findViewById(2131756760);
        textView.setText(this.blO == 20 ? 2131234317 : 2131234323);
        if (this.ilv.getCount() == 0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    protected final void NI() {
        try {
            this.ilw = new e(be.e(getAssets().open("chatting/default_chat.xml")));
        } catch (Throwable e) {
            v.a("MicroMsg.ReaderAppUI", e, "", new Object[0]);
        }
        this.hkg = (ListView) findViewById(2131758762);
        this.hkk = (MMPullDownView) findViewById(2131758761);
        this.hFT = getLayoutInflater().inflate(2130904225, null);
        this.hkg.addHeaderView(this.hFT);
        ((TextView) findViewById(2131756760)).setText(2131234313);
        if (this.blO == 20) {
            this.ilv = new a(this, this, Long.valueOf(0));
        } else if (this.blO == 11) {
            this.ilv = new b(this, this, Long.valueOf(0));
        }
        this.hkg.setOnScrollListener(this.ilv);
        this.hkg.setAdapter(this.ilv);
        this.hkg.setTranscriptMode(0);
        registerForContextMenu(this.hkg);
        this.eyZ = new l(this);
        if (this.ilv.getCount() == 0) {
            Intent intent = new Intent(this, ReaderAppIntroUI.class);
            intent.putExtra("type", this.blO);
            startActivity(intent);
            finish();
            return;
        }
        this.hkk.nWT = new MMPullDownView.g(this) {
            final /* synthetic */ ReaderAppUI ilA;

            {
                this.ilA = r1;
            }

            public final boolean azp() {
                if (this.ilA.ilv.abO()) {
                    this.ilA.hkg.setSelectionFromTop(0, this.ilA.hkk.nWV);
                } else {
                    int abP = this.ilA.ilv.abP();
                    v.v("MicroMsg.ReaderAppUI", "onLoadData add count:" + abP);
                    this.ilA.ilv.a(null, null);
                    this.ilA.hkg.setSelectionFromTop(abP, this.ilA.hkk.nWV);
                }
                return true;
            }
        };
        this.hkk.jr(true);
        this.hkk.nXf = new MMPullDownView.c(this) {
            final /* synthetic */ ReaderAppUI ilA;

            {
                this.ilA = r1;
            }

            public final boolean agv() {
                View childAt = this.ilA.hkg.getChildAt(this.ilA.hkg.getChildCount() - 1);
                if (childAt != null && childAt.getBottom() <= this.ilA.hkg.getHeight() && this.ilA.hkg.getLastVisiblePosition() == this.ilA.hkg.getAdapter().getCount() - 1) {
                    return true;
                }
                return false;
            }
        };
        this.hkk.nXg = new MMPullDownView.d(this) {
            final /* synthetic */ ReaderAppUI ilA;

            {
                this.ilA = r1;
            }

            public final boolean agu() {
                View childAt = this.ilA.hkg.getChildAt(this.ilA.hkg.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    return false;
                }
                return true;
            }
        };
        this.hkk.jp(true);
        this.ilv.nDK = new com.tencent.mm.ui.j.a(this) {
            final /* synthetic */ ReaderAppUI ilA;

            {
                this.ilA = r1;
            }

            public final void Oi() {
                this.ilA.hkk.jo(this.ilA.ilv.abO());
            }

            public final void Oj() {
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReaderAppUI ilA;

            {
                this.ilA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ilA.finish();
                return true;
            }
        });
        a(0, 2131230797, 2131165208, new OnMenuItemClickListener(this) {
            final /* synthetic */ ReaderAppUI ilA;

            {
                this.ilA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.readerapp.a.a.drp.d(new Intent().putExtra("Contact_User", this.ilA.gVL), this.ilA);
                return true;
            }
        });
        this.hkg.setSelection((this.ilv.aJh() - 1) + this.hkg.getHeaderViewsCount());
    }

    public final OnClickListener a(final bc bcVar, final int i, final int i2) {
        return new OnClickListener(this) {
            final /* synthetic */ ReaderAppUI ilA;

            public final void onClick(View view) {
                if (20 == i) {
                    Intent intent = new Intent();
                    intent.putExtra("mode", 1);
                    String url = bcVar.getUrl();
                    intent.putExtra("news_svr_id", bcVar.cuU);
                    intent.putExtra("news_svr_tweetid", bcVar.zG());
                    intent.putExtra("rawUrl", ReaderAppUI.a(this.ilA, url));
                    intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, bcVar.getName());
                    intent.putExtra("webpageTitle", bcVar.getTitle());
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    Bundle bundle = new Bundle();
                    bundle.putInt("snsWebSource", 3);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("shortUrl", bcVar.zH());
                    intent.putExtra("type", bcVar.type);
                    intent.putExtra("tweetid", bcVar.zG());
                    intent.putExtra("geta8key_username", "newsapp");
                    intent.putExtra("KPublisherId", "msg_" + Long.toString(bcVar.cuU));
                    intent.putExtra("pre_username", "newsapp");
                    intent.putExtra("prePublishId", "msg_" + Long.toString(bcVar.cuU));
                    intent.putExtra("preUsername", "newsapp");
                    intent.putExtra("preChatName", "newsapp");
                    intent.putExtra("preMsgIndex", i2);
                    com.tencent.mm.plugin.readerapp.a.a.drp.j(intent, this.ilA);
                }
            }
        };
    }

    public final void k(String str, Bitmap bitmap) {
        v.d("MicroMsg.ReaderAppUI", "onUpdate");
        if (this == null || isFinishing() || bitmap == null) {
            v.d("MicroMsg.ReaderAppUI", "readerappui is finish");
        } else {
            this.ilx.post(new Runnable(this) {
                final /* synthetic */ ReaderAppUI ilA;

                {
                    this.ilA = r1;
                }

                public final void run() {
                    if (this.ilA.ilv != null) {
                        this.ilA.ilv.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    private PackageInfo ys(String str) {
        PackageInfo packageInfo = null;
        if (str.length() != 0) {
            try {
                packageInfo = this.nDR.nEl.getPackageManager().getPackageInfo(str, 0);
            } catch (Throwable e) {
                v.a("MicroMsg.ReaderAppUI", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }
}
