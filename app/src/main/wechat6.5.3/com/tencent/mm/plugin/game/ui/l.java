package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.c.i;
import com.tencent.mm.plugin.game.c.j;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

abstract class l extends b<c> {
    protected int gjl = 0;
    private a gpN;
    protected int grA = 14;
    private com.tencent.mm.plugin.game.c.i.b grE = new com.tencent.mm.plugin.game.c.i.b(this) {
        final /* synthetic */ l gvf;

        {
            this.gvf = r1;
        }

        public final void g(int i, String str, boolean z) {
            if (z && this.gvf.gvc != null && str != null) {
                try {
                    for (j jVar : this.gvf.gvc.values()) {
                        if (!(jVar == null || jVar.ghX == null)) {
                            if (jVar.ghX.field_appId.equals(str) || jVar.ghX.field_packageName.equals(str)) {
                                jVar.bW(this.gvf.mContext);
                                jVar.arm();
                            }
                        }
                    }
                    int i2 = 0;
                    while (i2 < this.gvf.gjE.size()) {
                        c cVar = (c) this.gvf.gjE.get(i2);
                        if (cVar.type != 0 || (!(cVar.field_appId.equals(str) || cVar.field_packageName.equals(str)) || this.gvf.gpN == null)) {
                            i2++;
                        } else {
                            this.gvf.gpN.lw(i2);
                            return;
                        }
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.GameListAdapter", e.getMessage());
                }
            }
        }
    };
    protected e grF;
    private OnClickListener gsp = new OnClickListener(this) {
        final /* synthetic */ l gvf;

        {
            this.gvf = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.gvf.notifyDataSetChanged();
        }
    };
    protected View.OnClickListener gsq = new View.OnClickListener(this) {
        final /* synthetic */ l gvf;

        {
            this.gvf = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                if (this.gvf.gvc.containsKey(cVar.field_appId)) {
                    j jVar = (j) this.gvf.gvc.get(cVar.field_appId);
                    jVar.bW(this.gvf.mContext);
                    this.gvf.grF.gpa = cVar.ghF;
                    this.gvf.grF.gjl = this.gvf.gjl;
                    this.gvf.grF.a(cVar, jVar);
                    return;
                }
                v.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
                return;
            }
            v.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
        }
    };
    protected int guX;
    protected boolean guY = true;
    protected boolean guZ = false;
    protected boolean gva = false;
    protected int gvb;
    protected ConcurrentHashMap<String, j> gvc;
    protected SparseArray<View> gvd;
    protected Context mContext;

    public interface a {
        void lw(int i);
    }

    protected static class b {
        public ImageView goy;
        public TextView goz;
        public TextView gvi;
        public ViewGroup gvj;
        public TextView gvk;
        public TextView gvl;
        public TextView gvm;
        public Button gvn;
        public TextProgressBar gvo;
        public GameListSocialView gvp;
        public ViewGroup gvq;
        public LinearLayout gvr;

        protected b() {
        }
    }

    abstract void a(c cVar, b bVar);

    abstract void a(c cVar, b bVar, int i);

    static /* synthetic */ void a(l lVar, LinkedList linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!(lVar.gvc.containsKey(cVar.field_appId) || cVar.type == 1 || cVar == null)) {
                j jVar = (j) lVar.gvc.get(cVar.field_appId);
                if (jVar == null) {
                    jVar = new j(cVar);
                    lVar.gvc.put(cVar.field_appId, jVar);
                }
                jVar.bW(lVar.mContext);
                jVar.arm();
            }
        }
    }

    public l(Context context) {
        super(context);
        this.mContext = context;
        this.gvc = new ConcurrentHashMap();
        i.a(this.grE);
        this.gvd = new SparseArray();
        this.grF = new e(context);
        this.grF.gpv = this.gsp;
    }

    public void lu(int i) {
        this.gjl = i;
    }

    public void lx(int i) {
        this.gvb = i;
    }

    public void refresh() {
        notifyDataSetChanged();
    }

    public void H(final LinkedList<c> linkedList) {
        if (linkedList != null) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ l gvf;

                public final void run() {
                    l.a(this.gvf, linkedList);
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 gvg;

                        {
                            this.gvg = r1;
                        }

                        public final void run() {
                            super.H(linkedList);
                            v.i("MicroMsg.GameListAdapter", "add size: %d", new Object[]{Integer.valueOf(linkedList.size())});
                        }
                    });
                }
            });
        }
    }

    public void I(final LinkedList<c> linkedList) {
        if (linkedList != null) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ l gvf;

                public final void run() {
                    l.a(this.gvf, linkedList);
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 gvh;

                        {
                            this.gvh = r1;
                        }

                        public final void run() {
                            super.I(linkedList);
                            v.i("MicroMsg.GameListAdapter", "set size: %d", new Object[]{Integer.valueOf(linkedList.size())});
                        }
                    });
                }
            });
        }
    }

    public int getItemViewType(int i) {
        return ((c) getItem(i)).type;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar = (c) getItem(i);
        if (view == null) {
            int i2;
            Context context = this.mContext;
            switch (cVar.type) {
                case 0:
                    i2 = this.guX;
                    break;
                case 1:
                    i2 = 2130903692;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            b bVar2 = new b();
            bVar2.gvj = (ViewGroup) view.findViewById(2131757230);
            bVar2.gvi = (TextView) view.findViewById(2131757231);
            bVar2.goy = (ImageView) view.findViewById(2131755481);
            bVar2.goz = (TextView) view.findViewById(2131755483);
            bVar2.gvk = (TextView) view.findViewById(2131757233);
            bVar2.gvl = (TextView) view.findViewById(2131757240);
            bVar2.gvm = (TextView) view.findViewById(2131757234);
            bVar2.gvn = (Button) view.findViewById(2131757235);
            bVar2.gvo = (TextProgressBar) view.findViewById(2131757236);
            bVar2.gvr = (LinearLayout) view.findViewById(2131757188);
            bVar2.gvp = (GameListSocialView) view.findViewById(2131757237);
            bVar2.gvq = (ViewGroup) view.findViewById(2131757336);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (cVar.type) {
            case 0:
                a(cVar, bVar, i);
                if (this.gvb == 2 && !cVar.ghH) {
                    af.a(this.mContext, 1004, cVar.position, null, this.gjl, cVar.ghF);
                    cVar.ghH = true;
                    break;
                }
            case 1:
                a(cVar, bVar);
                break;
        }
        return view;
    }

    public void b(SparseArray<View> sparseArray) {
        if (sparseArray != null) {
            this.gvd = sparseArray;
        } else {
            this.gvd = new SparseArray();
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.gpN = aVar;
    }

    public void u(View view, int i) {
        b bVar = (b) view.getTag();
        c cVar = (c) this.gjE.get(i);
        if (bVar != null) {
            this.grF.a(bVar.gvo, bVar.gvn, cVar, (j) this.gvc.get(cVar.field_appId));
            return;
        }
        v.e("MicroMsg.GameListAdapter", "holder should not be null, %d", new Object[]{Integer.valueOf(i)});
    }

    public void clear() {
        super.clear();
        i.b(this.grE);
    }

    public void uq(String str) {
        c cVar;
        for (int i = 0; i < this.gjE.size(); i++) {
            if (((c) this.gjE.get(i)).field_appId.equals(str)) {
                cVar = (c) this.gjE.get(i);
                break;
            }
        }
        cVar = null;
        if (this.gvc.containsKey(cVar.field_appId)) {
            this.grF.a(cVar, (j) this.gvc.get(cVar.field_appId));
            return;
        }
        v.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
    }

    public void up(String str) {
        if (!be.kS(str) && this.gvc.containsKey(str)) {
            j jVar = (j) this.gvc.get(str);
            if (jVar != null) {
                jVar.arm();
            }
        }
    }

    public void uo(String str) {
        if (!be.kS(str) && this.gvc.containsKey(str)) {
            j jVar = (j) this.gvc.get(str);
            if (jVar != null) {
                jVar.arn();
            }
        }
    }
}
