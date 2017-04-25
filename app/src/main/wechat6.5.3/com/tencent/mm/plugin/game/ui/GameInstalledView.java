package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.at;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.plugin.game.c.i;
import com.tencent.mm.plugin.game.c.i.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView extends LinearLayout implements OnClickListener {
    private static Map<String, Integer> gun = new HashMap();
    private static int gup = 6;
    private static int guq = 7;
    private int count = 0;
    private int fky = 4;
    LinkedList<f> gjE = new LinkedList();
    LinkedList<c> gjG;
    a gjH;
    int gjl = 0;
    private TextView goz;
    b grE = new b(this) {
        final /* synthetic */ GameInstalledView guu;

        {
            this.guu = r1;
        }

        public final void g(int i, String str, boolean z) {
            switch (i) {
                case 3:
                    au.asi().init(this.guu.mContext);
                    this.guu.cP(false);
                    return;
                default:
                    return;
            }
        }
    };
    private LinearLayout guk;
    private ImageView gul;
    private TextView gum;
    private final DisplayMetrics guo = new DisplayMetrics();
    private int gur = 1;
    private int gus = 999;
    LayoutParams gut = new LayoutParams(-1, -2);
    private Context mContext;

    public static class a {
        public String guw = "";
        public String iconUrl = "";
        public String title = "";
    }

    static /* synthetic */ int b(GameInstalledView gameInstalledView) {
        int i = gameInstalledView.count + 1;
        gameInstalledView.count = i;
        return i;
    }

    public GameInstalledView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.guk = (LinearLayout) findViewById(2131757228);
        i.a(this.grE);
    }

    public final void cP(boolean z) {
        if (be.bP(this.gjG)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        Iterator it;
        if (z) {
            this.gjE = e.arg();
            if (!(be.bP(this.gjG) || be.bP(this.gjE))) {
                it = this.gjG.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (this.gjE.contains(cVar)) {
                        this.gjE.remove(cVar);
                        this.gjE.addFirst(cVar);
                    }
                }
            }
        } else {
            f fVar;
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.gjE);
            LinkedList linkedList2 = new LinkedList();
            linkedList2.addAll(e.arg());
            Collection linkedList3 = new LinkedList();
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                fVar = (f) it2.next();
                if (!(linkedList2.contains(fVar) || linkedList3.contains(fVar))) {
                    linkedList3.add(fVar);
                }
            }
            it2 = linkedList.iterator();
            while (it2.hasNext()) {
                fVar = (f) it2.next();
                if (linkedList2.contains(fVar)) {
                    linkedList2.remove(fVar);
                } else if (!g.a(this.mContext, fVar)) {
                    linkedList3.add(fVar);
                }
            }
            if (linkedList2.size() > 0) {
                Iterator it3 = linkedList2.iterator();
                while (it3.hasNext()) {
                    fVar = (f) it3.next();
                    if (!linkedList.contains(fVar)) {
                        linkedList.addFirst(fVar);
                    }
                }
            }
            if (linkedList3.size() > 0) {
                linkedList.removeAll(linkedList3);
            }
            linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(g.aC(((f) it.next()).field_appId, true));
            }
            this.gjE = linkedList2;
        }
        ast();
    }

    private void ast() {
        if (be.bP(this.gjE)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.guk.removeAllViews();
        this.count = 0;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (this.gjE.size() >= this.fky - 1) {
            guq = 7;
            gup = 6;
            int a = BackwardSupportUtil.b.a(this.mContext, (float) ((gup << 1) + 84));
            ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.guo);
            int i = (int) (((float) (this.guo.widthPixels * 160)) / ((float) this.guo.densityDpi));
            this.fky = ((this.guo.widthPixels - 1) / a) + 1;
            if (this.fky == 3) {
                guq = 3;
            }
            a = (gup << 1) + 84;
            int i2 = (gup + 6) + guq;
            i = (i - 16) % a;
            if (i < i2) {
                gup -= 2;
                BackwardSupportUtil.b.a(this.mContext, (float) ((gup << 1) + 84));
            } else if (i > a - i2) {
                gup = ((i - (a >> 1)) / this.fky) + gup;
                BackwardSupportUtil.b.a(this.mContext, (float) ((gup << 1) + 84));
            }
        }
        this.gut.setMargins(BackwardSupportUtil.b.a(this.mContext, (float) gup), 0, BackwardSupportUtil.b.a(this.mContext, (float) gup), 0);
        Iterator it = this.gjE.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            View inflate = layoutInflater.inflate(2130903806, null);
            this.gul = (ImageView) inflate.findViewById(2131755481);
            this.goz = (TextView) inflate.findViewById(2131755483);
            this.gum = (TextView) inflate.findViewById(2131757501);
            Bitmap b = g.b(fVar.field_appId, 1, com.tencent.mm.bd.a.getDensity(this.mContext));
            if (b != null) {
                this.gul.setImageBitmap(b);
            } else {
                this.gul.setImageResource(2130837663);
            }
            this.goz.setText(g.a(this.mContext, fVar, null));
            if (g.a(this.mContext, fVar)) {
                int ut = com.tencent.mm.plugin.game.e.c.ut(fVar.field_packageName);
                if (gun.containsKey(fVar.field_appId) && ((Integer) gun.get(fVar.field_appId)).intValue() > ut) {
                    com.tencent.mm.pluginsdk.model.downloader.f GN = d.bnK().GN(fVar.field_appId);
                    this.gum.setTextColor(this.mContext.getResources().getColor(2131689742));
                    if (GN.status == 1) {
                        this.gum.setText(2131233060);
                    } else {
                        this.gum.setText(2131233059);
                    }
                } else if (be.kS(fVar.bxs)) {
                    this.gum.setText("");
                } else {
                    this.gum.setText(fVar.bxs);
                    this.gum.setTextColor(this.mContext.getResources().getColor(2131689756));
                }
            } else {
                this.gum.setTextColor(this.mContext.getResources().getColor(2131689742));
                this.gum.setText(2131233093);
            }
            inflate.setTag(fVar);
            inflate.setOnClickListener(this);
            this.guk.addView(inflate, this.gut);
        }
        if (this.gjH != null && this.gjH.iconUrl != null && this.gjH.title != null) {
            final View inflate2 = layoutInflater.inflate(2130903806, null);
            this.gul = (ImageView) inflate2.findViewById(2131755481);
            this.goz = (TextView) inflate2.findViewById(2131755483);
            this.gum = (TextView) inflate2.findViewById(2131757501);
            com.tencent.mm.ae.a.a GL = n.GL();
            String str = this.gjH.iconUrl;
            ImageView imageView = this.gul;
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPr = true;
            GL.a(str, imageView, aVar.GU(), new com.tencent.mm.ae.a.c.g(this) {
                final /* synthetic */ GameInstalledView guu;

                public final void jk(String str) {
                }

                public final void a(String str, View view, com.tencent.mm.ae.a.d.b bVar) {
                    if (bVar.status == 0) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 guv;

                            {
                                this.guv = r1;
                            }

                            public final void run() {
                                if (this.guv.guu.count == 0) {
                                    GameInstalledView.b(this.guv.guu);
                                    this.guv.guu.guk.addView(inflate2, this.guv.guu.gut);
                                }
                            }
                        });
                    }
                }
            });
            this.goz.setText(this.gjH.title);
            this.gum.setVisibility(8);
            inflate2.setTag(this.gjH);
            inflate2.setOnClickListener(this);
        }
    }

    public static void t(Map<String, Integer> map) {
        if (map != null && !map.isEmpty()) {
            gun = map;
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null) {
            if (view.getTag() instanceof f) {
                f fVar = (f) view.getTag();
                if (fVar == null || be.kS(fVar.field_appId)) {
                    v.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
                } else if (g.a(this.mContext, fVar)) {
                    int ut = com.tencent.mm.plugin.game.e.c.ut(fVar.field_packageName);
                    if (!gun.containsKey(fVar.field_appId) || ((Integer) gun.get(fVar.field_appId)).intValue() <= ut) {
                        e.R(this.mContext, fVar.field_appId);
                        af.a(this.mContext, 10, 1002, this.gur, 3, 0, fVar.field_appId, this.gjl, 0, null, null, null);
                        this.gjE.remove(fVar);
                        this.gjE.addFirst(fVar);
                    } else {
                        r0 = d.bnK().GN(fVar.field_appId);
                        if (r0.status == 1) {
                            d.bnK().dm(r0.id);
                        } else {
                            if (r0.status == 3) {
                                if (!com.tencent.mm.a.e.aR(r0.path) || com.tencent.mm.plugin.game.e.c.uu(r0.path) <= ut) {
                                    d.bnK().dm(r0.id);
                                } else {
                                    p.c(this.mContext, Uri.fromFile(new File(r0.path)));
                                }
                            }
                            i.a(fVar.bxo, fVar.bxt, 1002, fVar.field_appId, "");
                            com.tencent.mm.pluginsdk.model.downloader.e.a aVar = new com.tencent.mm.pluginsdk.model.downloader.e.a();
                            aVar.GQ(fVar.bxo);
                            aVar.GR(g.a(this.mContext, fVar, null));
                            aVar.setAppId(fVar.field_appId);
                            aVar.GS(fVar.bxt);
                            aVar.hO(true);
                            aVar.tE(1);
                            d.bnK().a(aVar.lCn);
                        }
                    }
                    cP(false);
                } else {
                    r0 = d.bnK().GN(fVar.field_appId);
                    if (r0 == null || r0.status != 3) {
                        if (e.a(fVar)) {
                            v.i("MicroMsg.GameInstalledView", "has download suceess by yyb, start to install : [%s]", new Object[]{fVar.field_appName});
                            at.arX();
                            at.startToDownloadTaskList(this.mContext);
                            return;
                        }
                        v.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", new Object[]{fVar.field_appName});
                        cP(false);
                    } else if (be.kS(r0.path) || !com.tencent.mm.a.e.aR(r0.path)) {
                        v.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", new Object[]{r0.path});
                        d.bnK().dm(r0.id);
                        cP(false);
                    } else {
                        p.c(this.mContext, Uri.fromFile(new File(r0.path)));
                    }
                }
            } else if (view.getTag() instanceof a) {
                a aVar2 = (a) view.getTag();
                Intent intent = new Intent();
                int i = 6;
                if (be.kS(aVar2.guw)) {
                    intent.setClass(this.mContext, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", 1002);
                    this.mContext.startActivity(intent);
                } else {
                    i = 7;
                    com.tencent.mm.plugin.game.e.c.n(this.mContext, aVar2.guw, "game_center_installed_more");
                }
                af.a(this.mContext, 10, 1002, this.gus, i, 0, null, this.gjl, 0, null, null, null);
            }
        }
    }
}
