package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.game.c.aa;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.c.i;
import com.tencent.mm.plugin.game.c.i.b;
import com.tencent.mm.plugin.game.c.j;
import com.tencent.mm.plugin.game.c.z;
import com.tencent.mm.plugin.game.d.aq;
import com.tencent.mm.plugin.game.d.bv;
import com.tencent.mm.plugin.game.ui.GameDetailRankUI.a;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2 extends MMActivity implements e {
    private String appId = null;
    private c ghX = null;
    private int gjl = 0;
    private Dialog gqy;
    private int grA = 18;
    private boolean grB;
    private boolean grC;
    private String grD = null;
    private b grE = null;
    private e grF = null;
    private j grG = null;
    private ViewGroup grH;
    private ImageView grI;
    private ImageView grJ;
    private TextView grK;
    private Button grL;
    private TextProgressBar grM;
    private TextView grN;
    private LinearLayout grO;
    private GameDetailAutoScrollView grP;
    private LinearLayout grQ;
    private TextView grR;
    private LinearLayout grS;
    private TextView grT;
    private LinearLayout grU;
    private ImageView grV;
    private View grW;
    private TextView grX;
    private TextView grY;
    private View grZ;
    private String grx = null;
    private String gry = null;
    private TextView gsa;
    private ImageView gsb;
    private TextView gsc;
    private TextView gsd;
    private LinearLayout gse;
    private GameMediaList gsf;
    private TextView gsg;
    private TextView gsh;
    private TextView gsi;
    private boolean gsj = false;
    private LinearLayout gsk;
    private TextView gsl;
    private LinearLayout gsm;
    private TextView gsn;
    private bv gso;
    private OnClickListener gsp = new OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 gsw;

        {
            this.gsw = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.gsw.grG.arm();
            this.gsw.grF.a(this.gsw.grM, this.gsw.grL, this.gsw.ghX, this.gsw.grG);
        }
    };
    private View.OnClickListener gsq = new View.OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 gsw;

        {
            this.gsw = r1;
        }

        public final void onClick(View view) {
            if (this.gsw.ghX == null) {
                v.e("MicroMsg.GameDetailUI2", "Null appInfo");
            } else if (this.gsw.grG == null) {
                v.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
            } else {
                this.gsw.grG.bW(this.gsw.nDR.nEl);
                this.gsw.grF.a(this.gsw.ghX, this.gsw.grG);
            }
        }
    };
    private View.OnClickListener gsr = new View.OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 gsw;

        {
            this.gsw = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof String) {
                com.tencent.mm.plugin.game.e.c.a(view, this.gsw);
                af.a(this.gsw.nDR.nEl, 12, 1203, 999, 7, this.gsw.appId, this.gsw.gjl, null);
                return;
            }
            a aVar = new a();
            aVar.grx = this.gsw.grx;
            aVar.gry = this.gsw.gry;
            aVar.grz = this.gsw.ghX;
            String fz = o.fz("rankData");
            o.yx().n(fz, true).l(GameDetailRankUI.grv, aVar);
            Intent intent = new Intent(this.gsw.nDR.nEl, GameDetailRankUI.class);
            intent.putExtra(GameDetailRankUI.EXTRA_SESSION_ID, fz);
            this.gsw.startActivity(intent);
            af.a(this.gsw.nDR.nEl, 12, 1203, 999, 6, this.gsw.appId, this.gsw.gjl, null);
        }
    };
    private View.OnClickListener gss = new View.OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 gsw;

        {
            this.gsw = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.game.e.c.a(view, this.gsw);
            af.a(this.gsw.nDR.nEl, 12, 1204, 999, 7, this.gsw.appId, this.gsw.gjl, null);
        }
    };
    private View.OnClickListener gst = new View.OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 gsw;

        {
            this.gsw = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.game.e.c.a(view, this.gsw);
            af.a(this.gsw.nDR.nEl, 12, 1205, 1, 7, this.gsw.appId, this.gsw.gjl, null);
        }
    };
    private View.OnClickListener gsu = new View.OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 gsw;

        {
            this.gsw = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.game.e.c.a(view, this.gsw);
            af.a(this.gsw.nDR.nEl, 12, 1205, 999, 7, this.gsw.appId, this.gsw.gjl, null);
        }
    };
    private View.OnClickListener gsv = new View.OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 gsw;

        {
            this.gsw = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.game.e.c.a(view, this.gsw);
            af.a(this.gsw.nDR.nEl, 12, 1206, 1, 7, this.gsw.appId, this.gsw.gjl, null);
        }
    };

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, z zVar) {
        if (gameDetailUI2.isFinishing()) {
            v.w("MicroMsg.GameDetailUI2", "GameDetailUI2 hasFinished");
        } else if (zVar == null) {
            v.e("MicroMsg.GameDetailUI2", "Null data");
        } else {
            gameDetailUI2.ghX = zVar.gjs;
            String str = zVar.gjq.glL == null ? null : be.kS(zVar.gjq.glL.gnv) ? null : zVar.gjq.glL.gnv;
            gameDetailUI2.grx = str;
            str = zVar.gjq.glL == null ? null : be.kS(zVar.gjq.glL.gnw) ? null : zVar.gjq.glL.gnw;
            gameDetailUI2.gry = str;
            if (!gameDetailUI2.grC) {
                gameDetailUI2.grC = true;
                af.a(gameDetailUI2, 12, 1200, 0, 1, gameDetailUI2.appId, gameDetailUI2.gjl, null);
            }
            c cVar = zVar.gjs;
            com.tencent.mm.ae.a.a GL = n.GL();
            String str2 = zVar.gjq.glG;
            ImageView imageView = gameDetailUI2.grI;
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPr = true;
            GL.a(str2, imageView, aVar.GU());
            ImageView imageView2 = gameDetailUI2.grJ;
            str2 = gameDetailUI2.appId;
            float density = com.tencent.mm.bd.a.getDensity(gameDetailUI2);
            if (!(imageView2 == null || be.kS(str2))) {
                Bitmap b = g.b(str2, 1, density);
                if (b == null || b.isRecycled()) {
                    imageView2.setImageResource(2130838303);
                    am.bnB().c(new com.tencent.mm.plugin.game.ui.i.a.AnonymousClass1(str2, density, imageView2));
                } else {
                    imageView2.setImageBitmap(b);
                }
            }
            gameDetailUI2.grK.setText(cVar != null ? cVar.field_appName : "");
            if (cVar == null || be.kS(cVar.ghm)) {
                gameDetailUI2.grN.setVisibility(8);
            } else {
                gameDetailUI2.grN.setText(cVar.ghm);
                gameDetailUI2.grN.setVisibility(0);
            }
            if (gameDetailUI2.ghX == null) {
                gameDetailUI2.grL.setVisibility(8);
            } else {
                gameDetailUI2.grL.setVisibility(0);
                if (gameDetailUI2.grF == null) {
                    gameDetailUI2.grF = new e(gameDetailUI2);
                    gameDetailUI2.grF.gpv = gameDetailUI2.gsp;
                    gameDetailUI2.grF.gjl = gameDetailUI2.gjl;
                    gameDetailUI2.grF.gpa = gameDetailUI2.grD;
                }
                gameDetailUI2.grL.setOnClickListener(gameDetailUI2.gsq);
                gameDetailUI2.grM.setOnClickListener(gameDetailUI2.gsq);
                gameDetailUI2.grG = new j(gameDetailUI2.ghX);
                gameDetailUI2.grG.bW(gameDetailUI2);
                gameDetailUI2.grG.arm();
                gameDetailUI2.grF.a(gameDetailUI2.grM, gameDetailUI2.grL, gameDetailUI2.ghX, gameDetailUI2.grG);
                v.i("MicroMsg.GameDetailUI2", "App Status: %d, Download Mode: %d, Download Status: %d", new Object[]{Integer.valueOf(gameDetailUI2.ghX.status), Integer.valueOf(gameDetailUI2.grG.mode), Integer.valueOf(gameDetailUI2.grG.status)});
                if (!be.kS(gameDetailUI2.appId)) {
                    if (gameDetailUI2.grE != null) {
                        i.a(gameDetailUI2.grE);
                    } else {
                        gameDetailUI2.grE = new b(gameDetailUI2) {
                            final /* synthetic */ GameDetailUI2 gsw;

                            {
                                this.gsw = r1;
                            }

                            public final void g(int i, String str, boolean z) {
                                if (this.gsw.ghX != null) {
                                    this.gsw.grG.bW(this.gsw);
                                    this.gsw.grG.arm();
                                    if (z) {
                                        this.gsw.grF.a(this.gsw.grM, this.gsw.grL, this.gsw.ghX, this.gsw.grG);
                                    }
                                }
                            }
                        };
                        i.a(gameDetailUI2.grE);
                    }
                }
            }
            Collection arrayList = new ArrayList();
            if (zVar.gjq.glM != null) {
                Iterator it = zVar.gjq.glM.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.game.d.o oVar = (com.tencent.mm.plugin.game.d.o) it.next();
                    if (be.kS(oVar.gln)) {
                        arrayList.add("");
                    } else {
                        ak.yW();
                        u LX = com.tencent.mm.model.c.wH().LX(oVar.gln);
                        if (LX == null || LX.chr == 0) {
                            arrayList.add(oVar.gln + " ");
                        } else {
                            arrayList.add(LX.tU() + " ");
                        }
                    }
                    arrayList.add(oVar.glo);
                }
            }
            if (arrayList.size() != 0) {
                gameDetailUI2.grP.setVisibility(0);
                GameDetailAutoScrollView gameDetailAutoScrollView = gameDetailUI2.grP;
                gameDetailAutoScrollView.gqO.clear();
                gameDetailAutoScrollView.gpC.QI();
                if (arrayList.size() == 0 || arrayList.size() % 2 != 0) {
                    gameDetailAutoScrollView.gqP.setVisibility(8);
                    gameDetailAutoScrollView.gqS.setVisibility(8);
                } else {
                    gameDetailAutoScrollView.gqO.addAll(arrayList);
                    gameDetailAutoScrollView.fqz = 0;
                    gameDetailAutoScrollView.gqQ.setText(com.tencent.mm.pluginsdk.ui.d.e.a(gameDetailAutoScrollView.getContext(), (CharSequence) gameDetailAutoScrollView.gqO.get(0), gameDetailAutoScrollView.gqQ.getTextSize()));
                    gameDetailAutoScrollView.gqR.setText((CharSequence) gameDetailAutoScrollView.gqO.get(1));
                    gameDetailAutoScrollView.gqP.setVisibility(0);
                    gameDetailAutoScrollView.gqS.setVisibility(8);
                    if (gameDetailAutoScrollView.gqO.size() / 2 != 1) {
                        gameDetailAutoScrollView.gpC.ea(5000);
                    }
                }
            } else {
                gameDetailUI2.grP.setVisibility(8);
            }
            gameDetailUI2.b(zVar.gjt);
            CharSequence charSequence = zVar.gjq.glL == null ? null : be.kS(zVar.gjq.glL.gmD) ? null : zVar.gjq.glL.gmD;
            String str3 = zVar.gjq.glL == null ? null : be.kS(zVar.gjq.glL.gmE) ? null : zVar.gjq.glL.gmE;
            if (be.kS(charSequence)) {
                gameDetailUI2.grR.setVisibility(8);
            } else {
                gameDetailUI2.grR.setText(charSequence);
                if (be.kS(str3)) {
                    gameDetailUI2.grR.setTag(null);
                } else {
                    gameDetailUI2.grR.setTag(str3);
                }
                gameDetailUI2.grR.setOnClickListener(gameDetailUI2.gsr);
            }
            gameDetailUI2.a(zVar);
            gameDetailUI2.b(zVar);
            if (be.kS(zVar.arF()) || be.kS(zVar.arG())) {
                gameDetailUI2.gse.setVisibility(8);
            } else {
                gameDetailUI2.gse.setVisibility(0);
                gameDetailUI2.gsf.K(zVar.VK());
                gameDetailUI2.gsg.setText(zVar.arF());
                gameDetailUI2.gsh.setText(zVar.arG());
            }
            if (zVar.gjq.glO == null) {
                gameDetailUI2.grZ.setVisibility(8);
            } else {
                gameDetailUI2.grZ.setVisibility(0);
                gameDetailUI2.gsa.setText(zVar.gjq.glO.title);
                n.GL().a(zVar.gjq.glO.cZo, gameDetailUI2.gsb);
                gameDetailUI2.gsc.setText(zVar.gjq.glO.gmJ);
                gameDetailUI2.gsd.setText(zVar.gjq.glO.desc);
                ((ViewGroup) gameDetailUI2.gsc.getParent().getParent()).setTag(zVar.gjq.glO.gmK);
                ((ViewGroup) gameDetailUI2.gsc.getParent().getParent()).setOnClickListener(gameDetailUI2.gsv);
            }
            gameDetailUI2.c(zVar);
            gameDetailUI2.gso = zVar.gjq.glN;
            if (gameDetailUI2.gso == null || !(gameDetailUI2.gso.gnV || gameDetailUI2.gso.gnW)) {
                gameDetailUI2.nDR.bAi();
            } else {
                super.a(0, 2130838681, new OnMenuItemClickListener(gameDetailUI2) {
                    final /* synthetic */ GameDetailUI2 gsw;

                    {
                        this.gsw = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        GameDetailUI2.a(this.gsw, this.gsw.gso);
                        af.a(this.gsw.nDR.nEl, 12, 1207, 1, 2, this.gsw.appId, this.gsw.gjl, null);
                        return false;
                    }
                });
            }
            gameDetailUI2.grH.removeView(gameDetailUI2.gse);
            gameDetailUI2.grH.removeView(gameDetailUI2.grZ);
            gameDetailUI2.grH.removeView(gameDetailUI2.gsk);
            if (zVar.gjs.status == 1) {
                gameDetailUI2.grH.addView(gameDetailUI2.grZ);
                gameDetailUI2.grH.addView(gameDetailUI2.gse);
            } else {
                gameDetailUI2.grH.addView(gameDetailUI2.gse);
                gameDetailUI2.grH.addView(gameDetailUI2.grZ);
            }
            gameDetailUI2.grH.addView(gameDetailUI2.gsk);
        }
    }

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, final bv bvVar) {
        f fVar = new f(gameDetailUI2.nDR.nEl, f.pbS, false);
        fVar.jXn = new com.tencent.mm.ui.base.n.c(gameDetailUI2) {
            final /* synthetic */ GameDetailUI2 gsw;

            public final void a(l lVar) {
                if (bvVar.gnV) {
                    lVar.a(0, this.gsw.getString(2131236667), 2131165344);
                }
                if (bvVar.gnW) {
                    lVar.a(1, this.gsw.getString(2131236668), 2131165334);
                }
            }
        };
        fVar.jXo = new d(gameDetailUI2) {
            final /* synthetic */ GameDetailUI2 gsw;

            {
                this.gsw = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        GameDetailUI2.p(this.gsw);
                        return;
                    case 1:
                        GameDetailUI2.q(this.gsw);
                        return;
                    default:
                        return;
                }
            }
        };
        fVar.bKh();
    }

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, String str, String str2) {
        com.tencent.mm.q.a.a aVar = new com.tencent.mm.q.a.a();
        aVar.title = gameDetailUI2.gso.gnS;
        aVar.description = gameDetailUI2.gso.gnT;
        aVar.type = 5;
        if (be.kS(gameDetailUI2.gso.gkA)) {
            aVar.thumburl = gameDetailUI2.ghX.field_appIconUrl;
        } else {
            aVar.thumburl = gameDetailUI2.gso.gkA;
        }
        aVar.url = gameDetailUI2.gso.gkv;
        com.tencent.mm.pluginsdk.model.app.l.a(aVar, gameDetailUI2.appId, gameDetailUI2.ghX.field_appName, str, null, null, null);
        if (!be.kS(str2)) {
            mr mrVar = new mr();
            mrVar.boa.bob = str;
            mrVar.boa.content = str2;
            mrVar.boa.type = m.fp(str);
            mrVar.boa.flags = 0;
            com.tencent.mm.sdk.c.a.nhr.z(mrVar);
        }
    }

    static /* synthetic */ void p(GameDetailUI2 gameDetailUI2) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("MMActivity.OverrideEnterAnimation", 2130968622);
        intent.putExtra("MMActivity.OverrideExitAnimation", 2130968644);
        com.tencent.mm.ay.c.a(gameDetailUI2, ".ui.transmit.SelectConversationUI", intent, 2);
        gameDetailUI2.nDR.nEl.overridePendingTransition(2130968646, 2130968623);
    }

    static /* synthetic */ void q(GameDetailUI2 gameDetailUI2) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", gameDetailUI2.gso.gnU);
        String str = gameDetailUI2.gso.gkA;
        if (be.kS(str)) {
            str = gameDetailUI2.ghX.field_appIconUrl;
        }
        intent.putExtra("Ksnsupload_imgurl", str);
        intent.putExtra("Ksnsupload_link", gameDetailUI2.gso.gkv);
        intent.putExtra("Ksnsupload_type", 1);
        intent.putExtra("need_result", true);
        str = o.fz("game_center");
        o.yx().n(str, true).l("prePublishId", "game_center");
        intent.putExtra("reportSessionId", str);
        com.tencent.mm.ay.c.b(gameDetailUI2.nDR.nEl, "sns", ".ui.SnsUploadUI", intent, 3);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        if (ak.uz()) {
            this.grB = true;
            this.grC = false;
            this.appId = getIntent().getStringExtra("game_app_id");
            if (be.kS(this.appId)) {
                v.e("MicroMsg.GameDetailUI2", "appid is null or nill");
                finish();
            } else {
                this.gjl = getIntent().getIntExtra("game_report_from_scene", 0);
            }
            NI();
            ak.vy().a(1217, this);
            final byte[] uf = au.asg().uf(this.appId);
            if (uf == null || uf.length == 0) {
                v.i("MicroMsg.GameDetailUI2", "No cache found");
                z = false;
            } else {
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ GameDetailUI2 gsw;

                    public final void run() {
                        final z zVar = new z(uf);
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass12 gsA;

                            public final void run() {
                                GameDetailUI2.a(this.gsA.gsw, zVar);
                            }
                        });
                    }
                });
            }
            if (!z) {
                this.gqy = com.tencent.mm.plugin.game.e.c.ca(this);
                this.gqy.show();
            }
            ak.vy().a(new com.tencent.mm.plugin.game.c.am(com.tencent.mm.sdk.platformtools.u.bsY(), this.appId, g.o(this, this.appId)), 0);
            return;
        }
        v.e("MicroMsg.GameDetailUI2", "account not ready");
        finish();
    }

    protected final int getLayoutId() {
        return 2130903705;
    }

    protected final int NO() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (!(this.ghX == null || this.grG == null)) {
            this.grG.arm();
            this.grF.a(this.grM, this.grL, this.ghX, this.grG);
        }
        if (this.grB) {
            this.grB = false;
        } else {
            b(new aa(this.appId));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(1217, this);
        if (this.grE != null) {
            i.b(this.grE);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        String stringExtra = getIntent().getStringExtra("jump_game_center");
        if (!be.kS(stringExtra) && stringExtra.equals("jump_game_center")) {
            Intent intent = new Intent(this, GameCenterUI.class);
            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
            startActivity(intent);
        }
        finish();
    }

    protected final void NI() {
        vD(2131233075);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameDetailUI2 gsw;

            {
                this.gsw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gsw.goBack();
                return true;
            }
        });
        this.grH = (ViewGroup) findViewById(2131757238);
        this.grI = (ImageView) findViewById(2131757239);
        this.grJ = (ImageView) findViewById(2131755481);
        this.grK = (TextView) findViewById(2131755483);
        this.grN = (TextView) findViewById(2131757240);
        this.grL = (Button) findViewById(2131757266);
        this.grM = (TextProgressBar) findViewById(2131757267);
        this.grM.lI(this.grA);
        this.grO = (LinearLayout) findViewById(2131757242);
        this.grP = (GameDetailAutoScrollView) findViewById(2131757241);
        this.grQ = (LinearLayout) findViewById(2131757243);
        this.grR = (TextView) findViewById(2131757244);
        this.grS = (LinearLayout) findViewById(2131757245);
        this.grT = (TextView) findViewById(2131757246);
        this.grU = (LinearLayout) findViewById(2131757247);
        this.grV = (ImageView) findViewById(2131757248);
        this.grW = findViewById(2131757249);
        this.grX = (TextView) findViewById(2131757250);
        this.grY = (TextView) findViewById(2131757251);
        this.grZ = findViewById(2131757257);
        this.gsa = (TextView) findViewById(2131757258);
        this.gsb = (ImageView) findViewById(2131757259);
        this.gsc = (TextView) findViewById(2131757260);
        this.gsd = (TextView) findViewById(2131757261);
        this.gse = (LinearLayout) findViewById(2131757252);
        this.gsf = (GameMediaList) findViewById(2131757254);
        GameMediaList gameMediaList = this.gsf;
        String str = this.appId;
        int i = this.gjl;
        gameMediaList.appId = str;
        gameMediaList.dzy = 12;
        gameMediaList.gsN = i;
        gameMediaList.mContext = this;
        this.gsf.gvs = 2130903742;
        this.gsg = (TextView) findViewById(2131757253);
        this.gsh = (TextView) findViewById(2131757255);
        this.gsh.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ GameDetailUI2 gsw;

            {
                this.gsw = r1;
            }

            public final void onGlobalLayout() {
                if (this.gsw.gsh.getLineCount() > 3) {
                    this.gsw.gsi.setVisibility(0);
                } else {
                    this.gsw.gsi.setVisibility(8);
                }
            }
        });
        this.gsi = (TextView) findViewById(2131757256);
        this.gsi.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ GameDetailUI2 gsw;

            {
                this.gsw = r1;
            }

            public final void onClick(View view) {
                if (this.gsw.gsj) {
                    this.gsw.gsh.setMaxLines(3);
                    this.gsw.gsi.setText(this.gsw.getResources().getText(2131233066));
                    this.gsw.gsj = false;
                    return;
                }
                this.gsw.gsh.setMaxLines(100);
                this.gsw.gsi.setText(this.gsw.getResources().getText(2131233067));
                this.gsw.gsj = true;
            }
        });
        this.gsk = (LinearLayout) findViewById(2131757262);
        this.gsl = (TextView) findViewById(2131757263);
        this.gsm = (LinearLayout) findViewById(2131757264);
        this.gsn = (TextView) findViewById(2131757265);
    }

    private void b(aa aaVar) {
        int i = 0;
        List list = aaVar.gju;
        if (list == null || list.size() == 0) {
            this.grQ.setVisibility(8);
            this.grR.setVisibility(8);
            return;
        }
        this.grQ.setVisibility(0);
        if (list.size() > 3) {
            this.grR.setVisibility(0);
        } else {
            this.grR.setVisibility(8);
        }
        this.grQ.removeAllViews();
        h hVar = new h(this.nDR.nEl);
        hVar.CC = 2130903713;
        hVar.a(aaVar);
        hVar.gjl = this.gjl;
        while (i < list.size() && i < 3) {
            this.grQ.addView(hVar.getView(i, null, this.grO));
            i++;
        }
    }

    private void a(z zVar) {
        LinkedList linkedList = null;
        if (zVar.gjt.gju == null || zVar.gjt.gju.size() == 0) {
            linkedList = zVar.gjq.glH;
        }
        if (linkedList == null || linkedList.size() == 0) {
            this.grO.setVisibility(8);
            return;
        }
        this.grO.setVisibility(0);
        this.grO.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.game.d.n nVar = (com.tencent.mm.plugin.game.d.n) it.next();
            View inflate = LayoutInflater.from(this.nDR.nEl).inflate(2130903716, this.grO, false);
            ImageView imageView = (ImageView) inflate.findViewById(2131757290);
            TextView textView = (TextView) inflate.findViewById(2131757291);
            TextView textView2 = (TextView) inflate.findViewById(2131757292);
            if (be.kS(nVar.gln)) {
                com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
                aVar.cPP = true;
                n.GL().a(nVar.gkA, imageView, aVar.GU());
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, nVar.gln, 0.5f, false);
            }
            textView.setText(nVar.aXz);
            textView2.setText(nVar.glo);
            this.grO.addView(inflate);
        }
    }

    private void b(z zVar) {
        if (zVar.arD() == null || zVar.arD().isEmpty()) {
            this.grS.setVisibility(8);
            return;
        }
        int i;
        z.a aVar;
        this.grS.setVisibility(0);
        if (be.kS(zVar.arC())) {
            this.grT.setVisibility(8);
        } else {
            this.grT.setVisibility(0);
            this.grT.setText(zVar.arC());
        }
        this.grU.removeAllViews();
        if (zVar.arE() == 1) {
            this.grU.setOrientation(1);
            this.grV.setVisibility(8);
            i = 2130903708;
        } else {
            this.grU.setOrientation(0);
            this.grV.setVisibility(0);
            i = 2130903707;
        }
        Iterator it = zVar.arD().iterator();
        while (it.hasNext()) {
            z.b bVar = (z.b) it.next();
            View inflate = LayoutInflater.from(this.nDR.nEl).inflate(i, this.grU, false);
            n.GL().a(bVar.bll, (ImageView) inflate.findViewById(2131757270));
            if (zVar.arE() == 1) {
                ((TextView) inflate.findViewById(2131757272)).setText(bVar.title);
            }
            ((TextView) inflate.findViewById(2131757271)).setText(bVar.desc);
            if (zVar.arE() == 1) {
                inflate.setTag(bVar.url);
                inflate.setOnClickListener(this.gss);
            }
            this.grU.addView(inflate);
        }
        if (zVar.gjq.glP != null) {
            aVar = new z.a();
            aVar.title = zVar.gjq.glP.gmB;
            aVar.desc = zVar.gjq.glP.desc;
            aVar.url = zVar.gjq.glP.url;
        } else if (zVar.gjq.glK == null || be.kS(zVar.gjq.glK.gmD) || be.kS(zVar.gjq.glK.gmE)) {
            aVar = null;
        } else {
            aVar = new z.a();
            aVar.title = zVar.gjq.glK.gmD;
            aVar.url = zVar.gjq.glK.gmE;
        }
        if (aVar != null) {
            this.grW.setVisibility(0);
            this.grX.setText(aVar.title);
            if (be.kS(aVar.desc)) {
                this.grY.setVisibility(8);
            } else {
                this.grY.setVisibility(0);
                this.grY.setText(aVar.desc);
            }
            this.grW.setTag(aVar.url);
            this.grW.setOnClickListener(this.gss);
            return;
        }
        this.grW.setVisibility(8);
    }

    private void c(z zVar) {
        if (zVar.arI() == null || zVar.arI().isEmpty()) {
            this.gsk.setVisibility(8);
            return;
        }
        this.gsk.setVisibility(0);
        if (be.kS(zVar.arH())) {
            this.gsl.setVisibility(8);
        } else {
            this.gsl.setVisibility(0);
            this.gsl.setText(zVar.arH());
        }
        this.gsm.removeAllViews();
        this.gsm.setOnClickListener(null);
        Iterator it = zVar.arI().iterator();
        while (it.hasNext()) {
            aq aqVar = (aq) it.next();
            View inflate = LayoutInflater.from(this.nDR.nEl).inflate(2130903709, this.gsm, false);
            TextView textView = (TextView) inflate.findViewById(2131757274);
            TextView textView2 = (TextView) inflate.findViewById(2131757275);
            ImageView imageView = (ImageView) inflate.findViewById(2131757276);
            ((TextView) inflate.findViewById(2131757273)).setText(aqVar.gmM);
            textView.setText(aqVar.aXz);
            textView2.setText(aqVar.glo);
            n.GL().a(aqVar.gmF, imageView);
            inflate.setTag(aqVar.gkv);
            inflate.setOnClickListener(this.gst);
            this.gsm.addView(inflate);
        }
        Pair pair = zVar.gjq.glK == null ? null : (be.kS(zVar.gjq.glJ.aXz) || be.kS(zVar.gjq.glJ.gmE)) ? null : new Pair(zVar.gjq.glJ.gmD, zVar.gjq.glJ.gmE);
        if (pair != null) {
            this.gsn.setVisibility(0);
            this.gsn.setText((CharSequence) pair.first);
            this.gsn.setTag(pair.second);
            this.gsn.setOnClickListener(this.gsu);
            return;
        }
        this.gsn.setVisibility(8);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 1217:
                    final com.tencent.mm.ba.a aVar = ((com.tencent.mm.plugin.game.c.am) kVar).fut.czl.czs;
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ GameDetailUI2 gsw;

                        public final void run() {
                            final z zVar = new z(aVar);
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass14 gsB;

                                public final void run() {
                                    GameDetailUI2.a(this.gsB.gsw, zVar);
                                    if (this.gsB.gsw.gqy != null) {
                                        this.gsB.gsw.gqy.dismiss();
                                    }
                                }
                            });
                        }
                    });
                    return;
                default:
                    return;
            }
        }
        if (!com.tencent.mm.plugin.game.a.a.drq.a(this, i, i2, str)) {
            Toast.makeText(this, getString(2131233099, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.gqy != null) {
            this.gqy.cancel();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                switch (i2) {
                    case 0:
                        return;
                    case 2:
                        if (this.ghX != null && this.grG != null) {
                            this.grG.arn();
                            this.grF.a(this.ghX, this.grG);
                            return;
                        }
                        return;
                    case 3:
                        if (this.grG != null) {
                            this.grG.arm();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            case 2:
                if (i2 == -1) {
                    final String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!be.kS(stringExtra)) {
                        String str = this.gso.gkA;
                        if (be.kS(str)) {
                            str = this.ghX.field_appIconUrl;
                        }
                        com.tencent.mm.pluginsdk.ui.applet.c.a(this.nDR, this.gso.gnS, str, this.gso.gnT, null, getResources().getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                            final /* synthetic */ GameDetailUI2 gsw;

                            public final void a(boolean z, String str, int i) {
                                if (z) {
                                    GameDetailUI2.a(this.gsw, stringExtra, str);
                                    com.tencent.mm.ui.base.g.bf(this.gsw, this.gsw.getResources().getString(2131231978));
                                    af.a(this.gsw.nDR.nEl, 12, 1207, 2, 14, this.gsw.appId, this.gsw.gjl, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (i2 == -1) {
                    af.a(this.nDR.nEl, 12, 1207, 2, 15, this.appId, this.gjl, null);
                    return;
                }
                return;
            default:
                v.e("MicroMsg.GameDetailUI2", "error request code");
                return;
        }
    }
}
