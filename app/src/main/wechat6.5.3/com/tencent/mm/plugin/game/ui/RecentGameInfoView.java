package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.c.i;
import com.tencent.mm.plugin.game.c.j;
import com.tencent.mm.plugin.game.d.aj;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.plugin.game.d.bn;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.plugin.game.d.br;
import com.tencent.mm.plugin.game.d.bu;
import com.tencent.mm.plugin.game.d.bw;
import com.tencent.mm.plugin.game.d.by;
import com.tencent.mm.plugin.game.d.f;
import com.tencent.mm.plugin.game.d.g;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class RecentGameInfoView extends LinearLayout {
    static Map<String, View> gzj = new HashMap();
    private TextView dID;
    private LinearLayout fQp;
    int gjl;
    j gpM;
    private int grA = 14;
    com.tencent.mm.plugin.game.c.i.b grE = new com.tencent.mm.plugin.game.c.i.b(this) {
        final /* synthetic */ RecentGameInfoView gzm;

        {
            this.gzm = r1;
        }

        public final void g(int i, String str, boolean z) {
            if (z) {
                String[] strArr = new String[this.gzm.gzh.keySet().size()];
                this.gzm.gzh.keySet().toArray(strArr);
                for (Object obj : strArr) {
                    j jVar = (j) this.gzm.gzh.get(obj);
                    if (!(jVar == null || jVar.ghX == null || (!jVar.ghX.field_appId.equals(str) && !jVar.ghX.field_packageName.equals(str)))) {
                        jVar.bW(this.gzm.mContext);
                        jVar.arm();
                        View view = (View) RecentGameInfoView.gzj.get(jVar.ghX.field_appId);
                        if (view != null) {
                            b bVar = (b) view.getTag();
                            this.gzm.grF.a(bVar.gvo, bVar.gvn, jVar.ghX, (j) this.gzm.gzh.get(jVar.ghX.field_appId));
                        }
                    }
                }
            }
        }
    };
    e grF;
    private OnClickListener gsq = new OnClickListener(this) {
        final /* synthetic */ RecentGameInfoView gzm;

        {
            this.gzm = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                if (this.gzm.gzh.containsKey(cVar.field_appId)) {
                    j jVar = (j) this.gzm.gzh.get(cVar.field_appId);
                    jVar.bW(this.gzm.mContext);
                    this.gzm.grF.a(cVar, jVar);
                    return;
                }
                v.e("MicroMsg.RecentGameInfoView", "No DownloadInfo found");
                return;
            }
            v.e("MicroMsg.RecentGameInfoView", "No button tag retrived, ignore click");
        }
    };
    int gvb;
    private TextView gyT;
    private LinearLayout gyU;
    private View gyV;
    private GameSignGiftView gyW;
    private View gyX;
    private View gyY;
    private View gyZ;
    private View gza;
    private View gzb;
    LinkedList<c> gzc;
    LinkedList<by> gzd;
    br gze;
    ba gzf;
    String gzg;
    Map<String, j> gzh;
    String gzi;
    private OnClickListener gzk = new OnClickListener(this) {
        final /* synthetic */ RecentGameInfoView gzm;

        {
            this.gzm = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                com.tencent.mm.plugin.game.e.c.n(this.gzm.mContext, (String) view.getTag(), "game_center_mygame_more");
                af.a(this.gzm.mContext, 10, 1002, 99, 7, this.gzm.gjl, null);
            }
        }
    };
    private OnClickListener gzl = new OnClickListener(this) {
        final /* synthetic */ RecentGameInfoView gzm;

        {
            this.gzm = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                com.tencent.mm.plugin.game.e.c.n(this.gzm.mContext, (String) view.getTag(), "game_center_privilege");
                af.a(this.gzm.mContext, 10, 1002, (int) UpdateLogConst.ACTION_POP_INSTALL_DIALOG, 7, this.gzm.gjl, null);
            }
        }
    };
    Context mContext;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ LinkedList gve;
        final /* synthetic */ RecentGameInfoView gzm;

        AnonymousClass1(RecentGameInfoView recentGameInfoView, LinkedList linkedList) {
            this.gzm = recentGameInfoView;
            this.gve = linkedList;
        }

        public final void run() {
            try {
                Iterator it = this.gve.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (!this.gzm.gzh.containsKey(cVar.field_appId)) {
                        RecentGameInfoView.a(this.gzm, cVar);
                    }
                }
            } catch (Exception e) {
                v.i("MicroMsg.RecentGameInfoView", e.getMessage());
            }
        }
    }

    public static class a {
        public LinkedList<c> gwV;
        public String gzn;
        public LinkedList<by> gzo;
        public br gzp;
        public ba gzq;
    }

    private static class b {
        public ViewGroup gvj;
        public Button gvn;
        public TextProgressBar gvo;
        public ImageView gzr;
        public TextView gzs;
        public TextView gzt;

        private b() {
        }
    }

    static /* synthetic */ void a(RecentGameInfoView recentGameInfoView, c cVar) {
        if (cVar != null) {
            j jVar = (j) recentGameInfoView.gzh.get(cVar.field_appId);
            if (jVar == null) {
                jVar = new j(cVar);
                recentGameInfoView.gzh.put(cVar.field_appId, jVar);
            }
            jVar.bW(recentGameInfoView.mContext);
            jVar.arm();
        }
    }

    public RecentGameInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.dID = (TextView) findViewById(2131757367);
        this.gyU = (LinearLayout) findViewById(2131757368);
        this.gyT = (TextView) findViewById(2131757369);
        this.fQp = (LinearLayout) findViewById(2131755326);
        this.gpM = new j();
        this.grF = new e(this.mContext);
        this.gzh = new HashMap();
        i.a(this.grE);
        v.i("MicroMsg.RecentGameInfoView", "initView finished");
    }

    final void ast() {
        int i;
        int i2;
        if (be.kS(this.gzi)) {
            this.dID.setVisibility(8);
        } else {
            this.dID.setText(this.gzi);
            this.dID.setVisibility(0);
        }
        if (this.gzf == null || be.kS(this.gzf.aXz)) {
            this.gyU.setVisibility(8);
        } else {
            this.gyT.setText(this.gzf.aXz);
            this.gyU.setTag(this.gzf.gkT);
            this.gyU.setOnClickListener(this.gzl);
            this.gyU.setVisibility(0);
        }
        this.fQp.removeAllViews();
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (!be.bP(this.gzd)) {
            Iterator it = this.gzd.iterator();
            while (it.hasNext()) {
                by byVar = (by) it.next();
                GameIndexGroup gameIndexGroup;
                String ug;
                com.tencent.mm.plugin.game.e.e.a.a aVar;
                String str;
                LayoutParams layoutParams;
                switch (byVar.efm) {
                    case 1:
                        if (byVar.gnY != null) {
                            if (byVar.gnY.gnO == null) {
                                if (byVar.gnY.gnP == null) {
                                    break;
                                }
                                g gVar = byVar.gnY.gnP;
                                if (this.gyY == null) {
                                    this.gyY = layoutInflater.inflate(2130903727, null);
                                } else if (this.gyY.getParent() != null) {
                                    this.gyY = layoutInflater.inflate(2130903727, null);
                                }
                                gameIndexGroup = (GameIndexGroup) this.gyY.findViewById(2131757315);
                                gameIndexGroup.gjl = this.gjl;
                                ug = af.ug(gVar.gkV);
                                gameIndexGroup.l(this.gzg, gVar.gkU, ug);
                                if (gVar == null) {
                                    gameIndexGroup.setVisibility(8);
                                } else {
                                    gameIndexGroup.setVisibility(0);
                                    if (be.kS(gVar.gkW)) {
                                        gameIndexGroup.dID.setVisibility(8);
                                    } else {
                                        gameIndexGroup.dID.setText(gVar.gkW);
                                        gameIndexGroup.dID.setVisibility(0);
                                    }
                                    if (be.kS(gVar.aXz)) {
                                        gameIndexGroup.gtl.setVisibility(8);
                                    } else {
                                        gameIndexGroup.gtl.setText(gVar.aXz);
                                        gameIndexGroup.gtl.setVisibility(0);
                                    }
                                    if (be.kS(gVar.gkC)) {
                                        gameIndexGroup.gtm.setVisibility(8);
                                    } else {
                                        gameIndexGroup.gtm.setText(gVar.gkC);
                                        gameIndexGroup.gtm.setVisibility(0);
                                    }
                                    if (be.kS(gVar.gkX)) {
                                        gameIndexGroup.gtu.setVisibility(8);
                                    } else {
                                        aVar = new com.tencent.mm.plugin.game.e.e.a.a();
                                        aVar.gzR = true;
                                        aVar.gzU = 2130838305;
                                        e.asK().a(gameIndexGroup.gtu, gVar.gkX, aVar.asL());
                                        gameIndexGroup.gtu.setVisibility(0);
                                    }
                                    gameIndexGroup.setTag(gVar.gkT);
                                    gameIndexGroup.setOnClickListener(gameIndexGroup);
                                }
                                this.fQp.addView(this.gyY);
                                if (this.gvb != 2) {
                                    break;
                                }
                                af.a(this.mContext, 1002, gVar.gkU, this.gzg, this.gjl, ug);
                                break;
                            }
                            f fVar = byVar.gnY.gnO;
                            if (this.gyV == null) {
                                this.gyV = layoutInflater.inflate(2130903693, null);
                            } else if (this.gyV.getParent() != null) {
                                this.gyV = layoutInflater.inflate(2130903693, null);
                            }
                            GameIndexBannerView gameIndexBannerView = (GameIndexBannerView) this.gyV.findViewById(2131757190);
                            gameIndexBannerView.gjl = this.gjl;
                            ug = af.ug(fVar.gkV);
                            str = this.gzg;
                            gameIndexBannerView.kB = fVar.gkU;
                            gameIndexBannerView.dzg = str;
                            gameIndexBannerView.gtj = ug;
                            if (fVar == null || be.kS(fVar.gkS)) {
                                gameIndexBannerView.setVisibility(8);
                            } else {
                                gameIndexBannerView.setVisibility(0);
                                gameIndexBannerView.dID.setVisibility(8);
                                aVar = new com.tencent.mm.plugin.game.e.e.a.a();
                                aVar.gzU = 2130838300;
                                e.asK().a(gameIndexBannerView.gtk, fVar.gkS, aVar.asL());
                                layoutParams = (LayoutParams) gameIndexBannerView.gtk.getLayoutParams();
                                layoutParams.height = Math.round((((float) ((com.tencent.mm.plugin.game.e.c.getScreenWidth(gameIndexBannerView.mContext) - gameIndexBannerView.getPaddingLeft()) - gameIndexBannerView.getPaddingRight())) / 690.0f) * 214.0f);
                                gameIndexBannerView.gtk.setLayoutParams(layoutParams);
                                gameIndexBannerView.setTag(fVar.gkT);
                                gameIndexBannerView.setOnClickListener(gameIndexBannerView);
                            }
                            this.fQp.addView(this.gyV);
                            if (this.gvb != 2) {
                                break;
                            }
                            af.a(this.mContext, 1002, fVar.gkU, this.gzg, this.gjl, ug);
                            break;
                        }
                        break;
                    case 2:
                        if (byVar.gnZ == null) {
                            break;
                        }
                        aj ajVar = byVar.gnZ;
                        switch (ajVar.efm) {
                            case 1:
                                if (this.gyW == null) {
                                    this.gyW = (GameSignGiftView) layoutInflater.inflate(2130903765, null);
                                } else if (this.gyW.getParent() != null) {
                                    this.gyW = (GameSignGiftView) layoutInflater.inflate(2130903765, null);
                                }
                                this.gyW.gjl = this.gjl;
                                this.gyW.appId = this.gzg;
                                GameSignGiftView gameSignGiftView = this.gyW;
                                if (ajVar == null || be.bP(ajVar.gmA)) {
                                    gameSignGiftView.setVisibility(8);
                                } else {
                                    bw bwVar;
                                    int i3;
                                    gameSignGiftView.setVisibility(0);
                                    LinkedList linkedList = ajVar.gmA;
                                    if (be.kS(ajVar.aXz)) {
                                        gameSignGiftView.dID.setVisibility(8);
                                    } else {
                                        gameSignGiftView.dID.setText(ajVar.aXz);
                                        gameSignGiftView.dID.setVisibility(0);
                                    }
                                    if (be.kS(ajVar.gkC)) {
                                        gameSignGiftView.gyu.setVisibility(8);
                                    } else {
                                        gameSignGiftView.gyu.setText(ajVar.gkC);
                                        gameSignGiftView.gyu.setVisibility(0);
                                    }
                                    gameSignGiftView.gyE = 0;
                                    gameSignGiftView.gyF = 0;
                                    int screenWidth = com.tencent.mm.plugin.game.e.c.getScreenWidth(gameSignGiftView.mContext);
                                    i = 0;
                                    i2 = 0;
                                    int i4 = 0;
                                    while (i < linkedList.size()) {
                                        bwVar = (bw) linkedList.get(i);
                                        if (bwVar.Width == 40) {
                                            i3 = gameSignGiftView.gys + i4;
                                        } else {
                                            i3 = bwVar.Width;
                                            i3 = gameSignGiftView.gyt + i4;
                                        }
                                        i++;
                                        i2 = (gameSignGiftView.gyA.leftMargin + i2) + gameSignGiftView.gyA.rightMargin;
                                        i4 = i3;
                                    }
                                    i3 = ((screenWidth - gameSignGiftView.gyv.getPaddingLeft()) - gameSignGiftView.gyv.getPaddingRight()) - (i4 + i2);
                                    if (i3 > 0 && linkedList.size() > 1) {
                                        i3 = Math.round((((float) i3) / ((float) linkedList.size())) / 2.0f);
                                        layoutParams = gameSignGiftView.gyz;
                                        layoutParams.rightMargin += i3;
                                        layoutParams = gameSignGiftView.gyB;
                                        layoutParams.leftMargin += i3;
                                        layoutParams = gameSignGiftView.gyA;
                                        layoutParams.leftMargin += i3;
                                        layoutParams = gameSignGiftView.gyA;
                                        layoutParams.rightMargin = i3 + layoutParams.rightMargin;
                                        gameSignGiftView.gyx.setVisibility(8);
                                        gameSignGiftView.gyy.setVisibility(8);
                                        gameSignGiftView.gyG = true;
                                    }
                                    while (gameSignGiftView.gyw.getChildCount() < linkedList.size()) {
                                        gameSignGiftView.gyw.addView(gameSignGiftView.gwU.inflate(2130903764, gameSignGiftView.gyw, false));
                                    }
                                    for (i3 = 0; i3 < gameSignGiftView.gyw.getChildCount(); i3++) {
                                        if (i3 < linkedList.size()) {
                                            gameSignGiftView.gyw.getChildAt(i3).setVisibility(0);
                                        } else {
                                            gameSignGiftView.gyw.getChildAt(i3).setVisibility(8);
                                        }
                                    }
                                    for (i = 0; i < linkedList.size(); i++) {
                                        bwVar = (bw) linkedList.get(i);
                                        View childAt = gameSignGiftView.gyw.getChildAt(i);
                                        ImageView imageView = (ImageView) childAt.findViewById(2131755225);
                                        ImageView imageView2 = (ImageView) childAt.findViewById(2131757389);
                                        imageView.setAdjustViewBounds(true);
                                        Object obj = null;
                                        if (bwVar.Width == 40) {
                                            imageView.setMaxWidth(gameSignGiftView.gys);
                                            obj = 1;
                                        } else {
                                            int i5 = bwVar.Width;
                                            imageView.setMaxWidth(gameSignGiftView.gyt);
                                        }
                                        if (i != 0) {
                                            linkedList.size();
                                        }
                                        imageView.setLayoutParams(gameSignGiftView.gyA);
                                        com.tencent.mm.plugin.game.e.e.a.a aVar2 = new com.tencent.mm.plugin.game.e.e.a.a();
                                        if (obj != null) {
                                            aVar2.gzU = 2130838301;
                                        } else {
                                            aVar2.gzU = 2130838302;
                                        }
                                        e.asK().a(imageView, bwVar.gnp, aVar2.asL());
                                        if (bwVar.gnX == 1) {
                                            imageView2.setImageResource(2130838317);
                                            imageView2.setAdjustViewBounds(true);
                                            imageView2.setMaxWidth(com.tencent.mm.bd.a.fromDPToPix(gameSignGiftView.mContext, 9));
                                            imageView2.setMaxHeight(com.tencent.mm.bd.a.fromDPToPix(gameSignGiftView.mContext, 9));
                                        } else if (bwVar.gnX == 2) {
                                            imageView2.setImageResource(2130838313);
                                            gameSignGiftView.gyE = i + 1;
                                        } else if (bwVar.gnX == 3) {
                                            imageView2.setImageResource(2130838314);
                                            imageView2.setAdjustViewBounds(true);
                                            imageView2.setMaxWidth(com.tencent.mm.bd.a.fromDPToPix(gameSignGiftView.mContext, 9));
                                            imageView2.setMaxHeight(com.tencent.mm.bd.a.fromDPToPix(gameSignGiftView.mContext, 9));
                                            gameSignGiftView.gyF = i + 1;
                                        }
                                    }
                                    gameSignGiftView.gyC.kB = gameSignGiftView.gyE > gameSignGiftView.gyF ? gameSignGiftView.gyE : gameSignGiftView.gyF;
                                    GameSignGiftView.gyH.postDelayed(gameSignGiftView.gyC, 200);
                                    gameSignGiftView.setTag(ajVar);
                                    gameSignGiftView.setOnClickListener(gameSignGiftView);
                                }
                                this.fQp.addView(this.gyW);
                                if (this.gvb != 2) {
                                    break;
                                }
                                af.a(this.mContext, 1002, ajVar.gkU, this.gzg, this.gjl, af.ug(ajVar.gkV));
                                break;
                            default:
                                if (this.gyX == null) {
                                    this.gyX = layoutInflater.inflate(2130903721, null);
                                } else if (this.gyX.getParent() != null) {
                                    this.gyX = layoutInflater.inflate(2130903721, null);
                                }
                                GameGiftBannerView gameGiftBannerView = (GameGiftBannerView) this.gyX.findViewById(2131757304);
                                gameGiftBannerView.gjl = this.gjl;
                                ug = af.ug(ajVar.gkV);
                                str = this.gzg;
                                gameGiftBannerView.kB = ajVar.gkU;
                                gameGiftBannerView.dzg = str;
                                gameGiftBannerView.gtj = ug;
                                if (ajVar == null || be.kS(ajVar.gmz)) {
                                    gameGiftBannerView.setVisibility(8);
                                } else {
                                    gameGiftBannerView.setVisibility(0);
                                    if (be.kS(ajVar.aXz)) {
                                        gameGiftBannerView.gth.setVisibility(8);
                                    } else {
                                        gameGiftBannerView.gth.setText(ajVar.aXz);
                                        gameGiftBannerView.gth.setVisibility(0);
                                    }
                                    if (be.kS(ajVar.gkC)) {
                                        gameGiftBannerView.gti.setVisibility(8);
                                    } else {
                                        gameGiftBannerView.gti.setText(ajVar.gkC);
                                        gameGiftBannerView.gti.setVisibility(0);
                                    }
                                    aVar = new com.tencent.mm.plugin.game.e.e.a.a();
                                    aVar.gzU = 2130838300;
                                    e.asK().a(gameGiftBannerView.fqF, ajVar.gmz, aVar.asL());
                                    layoutParams = (LayoutParams) gameGiftBannerView.fqF.getLayoutParams();
                                    layoutParams.height = Math.round((((float) ((com.tencent.mm.plugin.game.e.c.getScreenWidth(gameGiftBannerView.mContext) - gameGiftBannerView.getPaddingLeft()) - gameGiftBannerView.getPaddingRight())) / 690.0f) * 160.0f);
                                    gameGiftBannerView.fqF.setLayoutParams(layoutParams);
                                    gameGiftBannerView.setTag(ajVar.gkT);
                                    gameGiftBannerView.setOnClickListener(gameGiftBannerView);
                                }
                                this.fQp.addView(this.gyX);
                                if (this.gvb != 2) {
                                    break;
                                }
                                af.a(this.mContext, 1002, ajVar.gkU, this.gzg, this.gjl, ug);
                                break;
                        }
                    case 3:
                        if (byVar.goa == null) {
                            break;
                        }
                        bu buVar = byVar.goa;
                        if (this.gyZ == null) {
                            this.gyZ = layoutInflater.inflate(2130903727, null);
                        } else if (this.gyZ.getParent() != null) {
                            this.gyZ = layoutInflater.inflate(2130903727, null);
                        }
                        gameIndexGroup = (GameIndexGroup) this.gyZ.findViewById(2131757315);
                        gameIndexGroup.gjl = this.gjl;
                        ug = af.ug(buVar.gkV);
                        gameIndexGroup.l(this.gzg, buVar.gkU, ug);
                        if (buVar == null) {
                            gameIndexGroup.setVisibility(8);
                        } else {
                            gameIndexGroup.setVisibility(0);
                            if (be.kS(buVar.gkW)) {
                                gameIndexGroup.dID.setVisibility(8);
                            } else {
                                gameIndexGroup.dID.setText(buVar.gkW);
                                gameIndexGroup.dID.setVisibility(0);
                            }
                            if (be.kS(buVar.aXz)) {
                                gameIndexGroup.gtl.setVisibility(8);
                            } else {
                                gameIndexGroup.gtl.setText(com.tencent.mm.pluginsdk.ui.d.e.a(gameIndexGroup.mContext, buVar.aXz, gameIndexGroup.gtl.getTextSize()));
                                gameIndexGroup.gtl.setVisibility(0);
                            }
                            if (be.kS(buVar.gkC)) {
                                gameIndexGroup.gtm.setVisibility(8);
                            } else {
                                gameIndexGroup.gtm.setText(com.tencent.mm.pluginsdk.ui.d.e.a(gameIndexGroup.mContext, buVar.gkC, gameIndexGroup.gtm.getTextSize()));
                                gameIndexGroup.gtm.setVisibility(0);
                            }
                            if (be.kS(buVar.gkX)) {
                                gameIndexGroup.gtu.setVisibility(8);
                            } else {
                                aVar = new com.tencent.mm.plugin.game.e.e.a.a();
                                aVar.gzR = true;
                                aVar.gzU = 2130838305;
                                e.asK().a(gameIndexGroup.gtu, buVar.gkX, aVar.asL());
                                gameIndexGroup.gtu.setVisibility(0);
                            }
                            gameIndexGroup.setTag(buVar.gkT);
                            gameIndexGroup.setOnClickListener(gameIndexGroup);
                        }
                        this.fQp.addView(this.gyZ);
                        if (this.gvb != 2) {
                            break;
                        }
                        af.a(this.mContext, 1002, buVar.gkU, this.gzg, this.gjl, ug);
                        break;
                    case 4:
                        if (byVar.gob == null) {
                            break;
                        }
                        bn bnVar = byVar.gob;
                        if (this.gza == null) {
                            this.gza = layoutInflater.inflate(2130903728, null);
                        } else if (this.gza.getParent() != null) {
                            this.gza = layoutInflater.inflate(2130903728, null);
                        }
                        GameIndexRankView gameIndexRankView = (GameIndexRankView) this.gza.findViewById(2131757315);
                        gameIndexRankView.gjl = this.gjl;
                        gameIndexRankView.appId = this.gzg;
                        if (bnVar == null) {
                            gameIndexRankView.setVisibility(8);
                        } else {
                            gameIndexRankView.setVisibility(0);
                            if (be.kS(bnVar.aXz)) {
                                gameIndexRankView.dID.setVisibility(8);
                            } else {
                                gameIndexRankView.dID.setText(bnVar.aXz);
                                gameIndexRankView.dID.setVisibility(0);
                            }
                            if (be.kS(bnVar.gkC)) {
                                gameIndexRankView.gtw.setVisibility(8);
                            } else {
                                ak.yW();
                                u LX = com.tencent.mm.model.c.wH().LX(bnVar.gnD);
                                str = "";
                                if (LX != null) {
                                    str = LX.tU();
                                }
                                gameIndexRankView.gtw.setText(com.tencent.mm.pluginsdk.ui.d.e.a(gameIndexRankView.mContext, com.tencent.mm.plugin.game.e.c.bK(bnVar.gkC, str), gameIndexRankView.gtw.getTextSize()));
                                gameIndexRankView.gtw.setVisibility(0);
                            }
                            if (be.kS(bnVar.gnD)) {
                                gameIndexRankView.gtu.setVisibility(8);
                                gameIndexRankView.gtp.setVisibility(8);
                            } else {
                                Bitmap f = e.asK().f(null, bnVar.gnD);
                                if (!(f == null || f.isRecycled())) {
                                    e.asK();
                                    gameIndexRankView.gtu.setImageBitmap(e.n(f));
                                    gameIndexRankView.gtu.setVisibility(0);
                                    gameIndexRankView.gtp.setVisibility(0);
                                }
                            }
                            gameIndexRankView.setTag(bnVar);
                            gameIndexRankView.setOnClickListener(gameIndexRankView);
                        }
                        this.fQp.addView(this.gza);
                        if (this.gvb != 2) {
                            break;
                        }
                        af.a(this.mContext, 1002, bnVar.gkU, this.gzg, this.gjl, af.ug(bnVar.gkV));
                        break;
                    case 5:
                        if (byVar.goc == null) {
                            break;
                        }
                        bo boVar = byVar.goc;
                        if (this.gzb == null) {
                            this.gzb = layoutInflater.inflate(2130903726, null);
                        } else if (this.gzb.getParent() != null) {
                            this.gzb = layoutInflater.inflate(2130903726, null);
                        }
                        GameIndexGeneralView gameIndexGeneralView = (GameIndexGeneralView) this.gzb.findViewById(2131757315);
                        gameIndexGeneralView.gjl = this.gjl;
                        gameIndexGeneralView.appId = this.gzg;
                        if (boVar == null) {
                            gameIndexGeneralView.setVisibility(8);
                        } else {
                            gameIndexGeneralView.setVisibility(0);
                            if (be.kS(boVar.gkW)) {
                                gameIndexGeneralView.dID.setVisibility(8);
                            } else {
                                gameIndexGeneralView.dID.setText(boVar.gkW);
                                gameIndexGeneralView.dID.setVisibility(0);
                            }
                            if (be.kS(boVar.aXz)) {
                                gameIndexGeneralView.gtl.setVisibility(8);
                            } else {
                                gameIndexGeneralView.gtl.setText(com.tencent.mm.pluginsdk.ui.d.e.a(gameIndexGeneralView.mContext, boVar.aXz, gameIndexGeneralView.gtl.getTextSize()));
                                gameIndexGeneralView.gtl.setVisibility(0);
                            }
                            if (be.kS(boVar.gkC)) {
                                gameIndexGeneralView.gtm.setVisibility(8);
                            } else {
                                gameIndexGeneralView.gtm.setText(com.tencent.mm.pluginsdk.ui.d.e.a(gameIndexGeneralView.mContext, boVar.gkC, gameIndexGeneralView.gtm.getTextSize()));
                                gameIndexGeneralView.gtm.setVisibility(0);
                            }
                            gameIndexGeneralView.setPadding(gameIndexGeneralView.fnn, gameIndexGeneralView.fnn, gameIndexGeneralView.fnn, gameIndexGeneralView.fnn);
                            switch (boVar.gnF) {
                                case 1:
                                    gameIndexGeneralView.gts.setVisibility(8);
                                    if (!be.kS(boVar.gmN)) {
                                        gameIndexGeneralView.gtr.setVisibility(0);
                                        if (be.kS(boVar.gnI)) {
                                            gameIndexGeneralView.gtr.setPadding(0, 0, 0, 0);
                                            gameIndexGeneralView.gtq.setVisibility(8);
                                        } else {
                                            gameIndexGeneralView.gtq.setVisibility(0);
                                            aVar = new com.tencent.mm.plugin.game.e.e.a.a();
                                            aVar.gzS = false;
                                            e.asK().a(gameIndexGeneralView.gtq, boVar.gnI, aVar.asL());
                                            gameIndexGeneralView.setPadding(gameIndexGeneralView.fnn, gameIndexGeneralView.fnn, 0, gameIndexGeneralView.fnn);
                                            gameIndexGeneralView.gtr.setPadding(0, 0, gameIndexGeneralView.gtt, 0);
                                        }
                                        aVar = new com.tencent.mm.plugin.game.e.e.a.a();
                                        aVar.gzR = true;
                                        aVar.gzU = 2130838305;
                                        e.asK().a(gameIndexGeneralView.gto, boVar.gmN, aVar.asL());
                                        break;
                                    }
                                    gameIndexGeneralView.gtr.setVisibility(8);
                                    break;
                                case 2:
                                    gameIndexGeneralView.gtr.setVisibility(8);
                                    if (!be.kS(boVar.gmN)) {
                                        gameIndexGeneralView.gts.setVisibility(0);
                                        if (boVar.gnG) {
                                            gameIndexGeneralView.gtp.setVisibility(0);
                                        } else {
                                            gameIndexGeneralView.gtp.setVisibility(8);
                                        }
                                        aVar = new com.tencent.mm.plugin.game.e.e.a.a();
                                        aVar.cPP = true;
                                        aVar.gzU = 2130838304;
                                        e.asK().a(gameIndexGeneralView.gtn, boVar.gmN, aVar.asL());
                                        break;
                                    }
                                    gameIndexGeneralView.gts.setVisibility(8);
                                    break;
                                default:
                                    v.e("MicroMsg.GameIndexGeneralView", "unknown pic style");
                                    gameIndexGeneralView.gtr.setVisibility(8);
                                    gameIndexGeneralView.gts.setVisibility(8);
                                    break;
                            }
                            gameIndexGeneralView.setTag(boVar);
                            gameIndexGeneralView.setOnClickListener(gameIndexGeneralView);
                        }
                        this.fQp.addView(this.gzb);
                        if (this.gvb != 2) {
                            break;
                        }
                        af.a(this.mContext, 1002, boVar.gkU, this.gzg, this.gjl, af.ug(boVar.gkV));
                        break;
                    default:
                        v.e("MicroMsg.RecentGameInfoView", "unknowed type " + byVar.efm);
                        break;
                }
            }
        }
        if (this.gzc.size() > 3) {
            i2 = 3;
        } else {
            i2 = this.gzc.size();
        }
        for (i = 0; i < i2; i++) {
            if (i != 0) {
                this.fQp.addView(layoutInflater.inflate(2130903718, this.fQp, false));
            }
            b bVar = new b();
            View inflate = layoutInflater.inflate(2130903729, this.fQp, false);
            bVar.gvj = (ViewGroup) inflate.findViewById(2131757230);
            bVar.gzr = (ImageView) inflate.findViewById(2131755481);
            bVar.gzs = (TextView) inflate.findViewById(2131755483);
            bVar.gzt = (TextView) inflate.findViewById(2131757234);
            bVar.gvn = (Button) inflate.findViewById(2131757235);
            bVar.gvo = (TextProgressBar) inflate.findViewById(2131757236);
            bVar.gvo.lI(this.grA);
            bVar.gvn.setOnClickListener(this.gsq);
            bVar.gvo.setOnClickListener(this.gsq);
            c cVar = (c) this.gzc.get(i);
            e.asK().a(bVar.gzr, cVar.field_appId, com.tencent.mm.bd.a.getDensity(this.mContext));
            bVar.gzs.setText(cVar.field_appName);
            if (be.kS(cVar.ghn)) {
                bVar.gzt.setVisibility(8);
            } else {
                bVar.gzt.setText(cVar.ghC);
                bVar.gzt.setVisibility(0);
            }
            bVar.gvn.setTag(cVar);
            bVar.gvo.setTag(cVar);
            j jVar = (j) this.gzh.get(cVar.field_appId);
            if (jVar == null) {
                jVar = new j(cVar);
            }
            this.grF.a(bVar.gvo, bVar.gvn, cVar, jVar);
            bVar.gvj.setOnClickListener(this.gpM);
            bVar.gvj.setTag(cVar);
            inflate.setTag(bVar);
            gzj.put(cVar.field_appId, inflate);
            if (i == 0) {
                this.fQp.addView(inflate, 0);
            } else {
                this.fQp.addView(inflate);
            }
        }
        if (!(this.gze == null || be.kS(this.gze.aXz))) {
            this.fQp.addView(layoutInflater.inflate(2130903718, this.fQp, false));
            View inflate2 = layoutInflater.inflate(2130903745, this.fQp, false);
            ((TextView) inflate2.findViewById(2131755098)).setText(this.gze.aXz);
            inflate2.setTag(this.gze.gkT);
            inflate2.setOnClickListener(this.gzk);
            this.fQp.addView(inflate2);
        }
        setVisibility(0);
    }
}
