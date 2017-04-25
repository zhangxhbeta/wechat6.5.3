package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.at;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.c.i;
import com.tencent.mm.plugin.game.c.j;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.plugin.game.c.q;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.ui.l.a;
import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GameCenterUI2 extends MMActivity implements e {
    private ac gjC;
    private int gjl = 0;
    j gpM = new j();
    private a gpN = new a(this) {
        final /* synthetic */ GameCenterUI2 gqJ;

        {
            this.gqJ = r1;
        }

        public final void lw(int i) {
            int headerViewsCount = this.gqJ.gqi.getHeaderViewsCount();
            int firstVisiblePosition = this.gqJ.gqi.getFirstVisiblePosition() - headerViewsCount;
            headerViewsCount = this.gqJ.gqi.getLastVisiblePosition() - headerViewsCount;
            if (i >= firstVisiblePosition && i <= headerViewsCount) {
                this.gqJ.gqj.u(this.gqJ.gqi.getChildAt(i - firstVisiblePosition), i);
            }
        }
    };
    private boolean gqA = false;
    private boolean gqB = false;
    private String gqC = "";
    private String gqD = "";
    private n gqE;
    private n gqF;
    private n gqG;
    private OnClickListener gqH = new OnClickListener(this) {
        final /* synthetic */ GameCenterUI2 gqJ;

        {
            this.gqJ = r1;
        }

        public final void onClick(View view) {
            int i = 7;
            com.tencent.mm.plugin.game.c.a.a arb = com.tencent.mm.plugin.game.c.a.arb();
            if (arb.bkU == 2) {
                c.n(this.gqJ.nDR.nEl, arb.url, "game_center_library");
            } else {
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof String) || be.kS((String) tag)) {
                    Intent intent = new Intent(this.gqJ, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", 1005);
                    this.gqJ.startActivity(intent);
                    i = 6;
                } else {
                    c.n(this.gqJ, (String) tag, "game_center_library");
                }
            }
            af.a(this.gqJ.nDR.nEl, 10, 1005, 1, i, this.gqJ.gjl, null);
        }
    };
    private OnClickListener gqI = new OnClickListener(this) {
        final /* synthetic */ GameCenterUI2 gqJ;

        {
            this.gqJ = r1;
        }

        public final void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof String) && !be.kS((String) tag)) {
                c.n(this.gqJ.nDR.nEl, (String) view.getTag(), "game_center_feedback");
                af.a(this.gqJ.nDR.nEl, 10, 1010, 1, 7, this.gqJ.gjl, null);
            }
        }
    };
    private boolean gqg = false;
    private GameCenterListView gqi;
    private f gqj;
    private GameInfoView gqk;
    private GameMessageBubbleView gql;
    private GameTopRecommendView gqm;
    private RecentGameInfoView gqn;
    private GameRecommendView gqo;
    private GameInstalledView gqp;
    private View gqq;
    private TextView gqr;
    private View gqs;
    private TextView gqt;
    private View gqu;
    private TextView gqv;
    private ImageView gqw;
    private View gqx;
    private Dialog gqy;
    private boolean gqz = true;

    static /* synthetic */ void a(GameCenterUI2 gameCenterUI2, com.tencent.mm.plugin.game.c.ac acVar, int i) {
        String str = null;
        if (gameCenterUI2.isFinishing()) {
            v.w("MicroMsg.GameCenterUI2", "GameCenterUI2 hasFinished");
        } else if (acVar == null) {
            v.e("MicroMsg.GameCenterUI2", "Null data");
        } else {
            gameCenterUI2.gqC = acVar.gjC.gmi != null ? acVar.gjC.gmi.gkT : "";
            gameCenterUI2.gqD = acVar.gjC.glV;
            au.ul(acVar.gjC.glU);
            if (be.kS(au.asa())) {
                if (gameCenterUI2.gqA) {
                    gameCenterUI2.vH(0);
                    gameCenterUI2.gqA = false;
                } else if (!gameCenterUI2.gqB) {
                    gameCenterUI2.a(1, 2130838681, new OnMenuItemClickListener(gameCenterUI2) {
                        final /* synthetic */ GameCenterUI2 gqJ;

                        {
                            this.gqJ = r1;
                        }

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            GameCenterUI2.q(this.gqJ);
                            return true;
                        }
                    });
                    gameCenterUI2.gqB = true;
                }
            } else if (!gameCenterUI2.gqA) {
                gameCenterUI2.nDR.bAi();
                gameCenterUI2.a(0, 2131235684, 2131165207, new OnMenuItemClickListener(gameCenterUI2) {
                    final /* synthetic */ GameCenterUI2 gqJ;

                    {
                        this.gqJ = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        Intent intent = new Intent(this.gqJ, GameSearchUI.class);
                        intent.putExtra("game_report_from_scene", 1009);
                        this.gqJ.startActivity(intent);
                        return true;
                    }
                });
                gameCenterUI2.a(1, 2130838681, new OnMenuItemClickListener(gameCenterUI2) {
                    final /* synthetic */ GameCenterUI2 gqJ;

                    {
                        this.gqJ = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        GameCenterUI2.q(this.gqJ);
                        return true;
                    }
                });
                gameCenterUI2.gqB = true;
                gameCenterUI2.gqA = true;
            }
            an anVar = acVar.gjC.gmm;
            if (anVar != null) {
                if (gameCenterUI2.gqx instanceof ViewStub) {
                    gameCenterUI2.gqx = ((ViewStub) gameCenterUI2.gqx).inflate();
                }
                gameCenterUI2.gqx.setVisibility(0);
                TextView textView = (TextView) gameCenterUI2.gqx.findViewById(2131757310);
                TextView textView2 = (TextView) gameCenterUI2.gqx.findViewById(2131757311);
                TextView textView3 = (TextView) gameCenterUI2.gqx.findViewById(2131757312);
                if (be.kS(anVar.gmG)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(anVar.gmG);
                    textView.setVisibility(0);
                }
                if (be.kS(anVar.gmH)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(anVar.gmH);
                    textView2.setVisibility(0);
                }
                if (be.kS(anVar.gmI)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(anVar.gmI);
                    textView3.setVisibility(0);
                }
                gameCenterUI2.gqi.setVisibility(8);
            } else {
                if (!(gameCenterUI2.gqx instanceof ViewStub)) {
                    gameCenterUI2.gqx.setVisibility(8);
                    gameCenterUI2.gqi.setVisibility(0);
                }
                gameCenterUI2.gqk.gtN = be.ah(gameCenterUI2.gqC, "");
                GameInfoView gameInfoView = gameCenterUI2.gqk;
                GameInfoView.a aVar = new GameInfoView.a();
                if (acVar.gjC.glX != null) {
                    aVar.gtZ = acVar.gjC.glX.gmP;
                    aVar.gua = acVar.gjC.glX.gmO;
                    aVar.gub = acVar.gjC.glX.gkA;
                }
                if (acVar.gjC.glW != null) {
                    aVar.guc = acVar.gjC.glW.gmP;
                    aVar.gud = acVar.gjC.glW.gmO;
                    aVar.gue = acVar.gjC.glW.gkA;
                }
                if (acVar.gjC.gmh != null) {
                    aVar.guf = acVar.gjC.gmh.gmR;
                    aVar.gug = acVar.gjC.gmh.gmS;
                }
                if (acVar.gjC.gml != null) {
                    aVar.guh = acVar.gjC.gml.gmP;
                    aVar.gui = acVar.gjC.gml.gkA;
                    aVar.guj = acVar.gjC.gml.gmO;
                    aVar.gjj = acVar.gjC.gml.gmQ;
                }
                gameInfoView.setVisibility(0);
                ((ViewGroup) gameInfoView.getParent()).setPadding(0, 0, 0, 0);
                if (be.kS(aVar.guj)) {
                    v.e("MicroMsg.GameInfoView", "profileIcon = %s, profileName = %s, profileUrl = %s", new Object[]{aVar.gui, aVar.guh, aVar.guj});
                    gameInfoView.gtI.setVisibility(8);
                    gameInfoView.gtM.setVisibility(8);
                } else {
                    if (be.kS(aVar.gui)) {
                        b.a(gameInfoView.gtJ, k.xF(), 0.5f, false);
                    } else {
                        com.tencent.mm.plugin.game.e.e.a.a aVar2 = new com.tencent.mm.plugin.game.e.e.a.a();
                        aVar2.cPP = true;
                        com.tencent.mm.plugin.game.e.e.asK().a(gameInfoView.gtJ, aVar.gui, aVar2.asL());
                    }
                    gameInfoView.gtK.setText(aVar.guh);
                    Map hashMap = new HashMap();
                    if (be.kS(aVar.gjj)) {
                        gameInfoView.gtL.setVisibility(8);
                        hashMap.put("badge_icon", "0");
                    } else {
                        com.tencent.mm.plugin.game.e.e.asK().e(gameInfoView.gtL, aVar.gjj);
                        gameInfoView.gtL.setVisibility(0);
                        hashMap.put("badge_icon", "1");
                    }
                    gameInfoView.gtS = af.s(hashMap);
                    gameInfoView.gtI.setTag(aVar.guj);
                    gameInfoView.gtI.setVisibility(0);
                    gameInfoView.gtM.setVisibility(0);
                    if (i == 2) {
                        af.a(gameInfoView.mContext, 1001, gameInfoView.gtR, null, gameInfoView.gjl, gameInfoView.gtS);
                    }
                }
                if (be.kS(aVar.gua)) {
                    gameInfoView.gtA.setVisibility(8);
                    gameInfoView.gtD.setVisibility(8);
                } else {
                    com.tencent.mm.plugin.game.e.e.asK().e(gameInfoView.gtC, aVar.gub);
                    if (aVar.gtZ != null) {
                        gameInfoView.gtB.setText(aVar.gtZ);
                    }
                    gameInfoView.gtA.setTag(aVar.gua);
                    gameInfoView.gtA.setVisibility(0);
                    gameInfoView.gtD.setVisibility(0);
                }
                if (be.kS(aVar.guc) || be.kS(aVar.gue)) {
                    v.e("MicroMsg.GameInfoView", "msgText = %s, msgIcon = %s", new Object[]{aVar.guc, aVar.gue});
                    gameInfoView.gtx.setVisibility(8);
                    gameInfoView.gtD.setVisibility(8);
                } else {
                    gameInfoView.gty.setText(aVar.guc);
                    if (!be.kS(aVar.gud)) {
                        gameInfoView.gtx.setTag(aVar.gud);
                    }
                    com.tencent.mm.plugin.game.e.e.asK().e(gameInfoView.gtz, aVar.gue);
                    gameInfoView.gtx.setVisibility(0);
                    gameInfoView.gtD.setVisibility(0);
                }
                if (aVar.gug == null || be.kS(aVar.gug.glm)) {
                    gameInfoView.gtH.setVisibility(8);
                    gameInfoView.gtG.setVisibility(8);
                } else {
                    com.tencent.mm.plugin.game.e.e.asK().e(gameInfoView.gtH, aVar.gug.glm);
                    gameInfoView.gtT = gameInfoView.b(gameInfoView.gtH, gameInfoView.mContext.getResources().getDimensionPixelSize(2131493121), gameInfoView.mContext.getResources().getDimensionPixelSize(2131493120));
                    if (gameInfoView.gtT > 0) {
                        gameInfoView.gtH.setVisibility(0);
                    } else {
                        gameInfoView.gtH.setVisibility(8);
                    }
                    if (gameInfoView.gtT <= 0 || aVar.guf == null || be.kS(aVar.guf.gmN)) {
                        gameInfoView.gtG.setVisibility(8);
                    } else {
                        com.tencent.mm.plugin.game.e.e.asK().e(gameInfoView.gtG, aVar.guf.gmN);
                        gameInfoView.gtU = gameInfoView.b(gameInfoView.gtG, gameInfoView.mContext.getResources().getDimensionPixelSize(2131493118), gameInfoView.mContext.getResources().getDimensionPixelSize(2131493120));
                        if (gameInfoView.gtU > 0) {
                            gameInfoView.gtG.setVisibility(0);
                            gameInfoView.gtG.setTag(aVar.guf.gkT);
                            gameInfoView.gtG.setOnClickListener(gameInfoView);
                        } else {
                            gameInfoView.gtG.setVisibility(8);
                        }
                    }
                }
                if (gameInfoView.gtG.getVisibility() == 0) {
                    if (aVar.guf.gof == gameInfoView.mContext.getSharedPreferences("game_center_pref", 0).getInt("game_top_banner_id", 0)) {
                        ((ViewGroup) gameInfoView.getParent()).setPadding(0, gameInfoView.gtT - gameInfoView.gtU, 0, 0);
                        gameInfoView.gtG.setClickable(false);
                    } else {
                        gameInfoView.gtH.setAlpha(0);
                        gameInfoView.gtG.setClickable(true);
                    }
                    gameInfoView.mContext.getSharedPreferences("game_center_pref", 0).edit().putInt("game_top_banner_id", aVar.guf.gof).apply();
                    GameCenterListView.dp(true);
                    GameCenterListView.ly(gameInfoView.gtT - gameInfoView.gtU);
                } else {
                    GameCenterListView.dp(false);
                }
                gameInfoView.ass();
                gameInfoView.asr();
                gameCenterUI2.gqk.gjl = gameCenterUI2.gjl;
                RecentGameInfoView.a aVar3 = acVar.gjI;
                RecentGameInfoView recentGameInfoView = gameCenterUI2.gqn;
                recentGameInfoView.gjl = gameCenterUI2.gjl;
                recentGameInfoView.gpM.lu(recentGameInfoView.gjl);
                gameCenterUI2.gqn.gvb = i;
                RecentGameInfoView recentGameInfoView2 = gameCenterUI2.gqn;
                RecentGameInfoView.a aVar4 = acVar.gjI;
                if (aVar4 == null || be.bP(aVar4.gwV)) {
                    recentGameInfoView2.setVisibility(8);
                    v.w("MicroMsg.RecentGameInfoView", "RecentGameInfo is null");
                } else {
                    recentGameInfoView2.setVisibility(0);
                    if (recentGameInfoView2.gvb == 2) {
                        af.a(recentGameInfoView2.mContext, 1002, 0, null, recentGameInfoView2.gjl, null);
                    }
                    recentGameInfoView2.gzc = aVar4.gwV;
                    recentGameInfoView2.gzg = ((com.tencent.mm.plugin.game.c.c) recentGameInfoView2.gzc.get(0)).field_appId;
                    recentGameInfoView2.gzd = aVar4.gzo;
                    recentGameInfoView2.gze = aVar4.gzp;
                    recentGameInfoView2.gzi = aVar4.gzn;
                    recentGameInfoView2.gzf = aVar4.gzq;
                    ak.vA().x(new com.tencent.mm.plugin.game.ui.RecentGameInfoView.AnonymousClass1(recentGameInfoView2, recentGameInfoView2.gzc));
                    recentGameInfoView2.ast();
                }
                if (aVar3 == null || be.bP(aVar3.gwV)) {
                    GameTopRecommendView gameTopRecommendView = gameCenterUI2.gqm;
                    gameTopRecommendView.gjl = gameCenterUI2.gjl;
                    gameTopRecommendView.gpM.lu(gameTopRecommendView.gjl);
                    gameCenterUI2.gqm.gvb = i;
                    gameCenterUI2.gqm.a(acVar.gjK);
                } else {
                    gameCenterUI2.gqm.a(null);
                }
                GameRecommendView gameRecommendView = gameCenterUI2.gqo;
                GameRecommendView.a aVar5 = acVar.gjJ;
                if (aVar5 == null || be.bP(aVar5.gwV)) {
                    gameRecommendView.setVisibility(8);
                } else {
                    gameRecommendView.setVisibility(0);
                    gameRecommendView.a(aVar5);
                }
                gameRecommendView = gameCenterUI2.gqo;
                gameRecommendView.gjl = gameCenterUI2.gjl;
                gameRecommendView.gpM.lu(gameRecommendView.gjl);
                gameCenterUI2.gqp.gjl = gameCenterUI2.gjl;
                GameInstalledView.t(acVar.gjF);
                gameCenterUI2.gqp.gjH = acVar.gjH;
                gameCenterUI2.gqp.gjG = acVar.gjG;
                gameCenterUI2.gqp.cP(true);
                if (gameCenterUI2.gqg) {
                    gameCenterUI2.gql.asx();
                }
                CharSequence charSequence = acVar.gjC.gmc != null ? acVar.gjC.gmc.aXz : null;
                if (be.kS(charSequence)) {
                    gameCenterUI2.gqq.setVisibility(8);
                } else {
                    gameCenterUI2.gqq.setVisibility(0);
                    gameCenterUI2.gqr.setText(charSequence);
                }
                LinkedList linkedList = acVar.gjE;
                if (linkedList.isEmpty()) {
                    gameCenterUI2.gqq.setVisibility(8);
                } else {
                    gameCenterUI2.gqq.setVisibility(0);
                }
                gameCenterUI2.gqj.lx(i);
                gameCenterUI2.gqj.I(linkedList);
                gameCenterUI2.gqs.setTag(acVar.gjC.gmd != null ? acVar.gjC.gmd.gkv : "");
                boolean z = acVar.gjC.gmd != null ? acVar.gjC.gmd.gne : false;
                CharSequence charSequence2 = acVar.gjC.gmd != null ? acVar.gjC.gmd.gnf : "";
                if (z) {
                    gameCenterUI2.gqs.setVisibility(0);
                    if (!be.kS(charSequence2)) {
                        gameCenterUI2.gqt.setText(charSequence2);
                    }
                } else {
                    gameCenterUI2.gqs.setVisibility(8);
                }
                com.tencent.mm.plugin.game.c.ac.a aVar6 = new com.tencent.mm.plugin.game.c.ac.a();
                if (acVar.gjC.gme != null) {
                    aVar6.text = acVar.gjC.gme.aXz;
                    aVar6.url = acVar.gjC.gme.gkv;
                }
                if (aVar6.text == null || aVar6.url == null) {
                    gameCenterUI2.gqu.setVisibility(8);
                } else {
                    gameCenterUI2.gqv.setTag(aVar6.url);
                    gameCenterUI2.gqv.setText(aVar6.text);
                    gameCenterUI2.gqu.setVisibility(0);
                }
                if (!(acVar.gjC.gmh == null || acVar.gjC.gmh.gmT == null)) {
                    str = acVar.gjC.gmh.gmT.glm;
                }
                if (be.kS(str)) {
                    gameCenterUI2.gqw.setVisibility(8);
                } else {
                    com.tencent.mm.ae.a.a GL = com.tencent.mm.ae.n.GL();
                    ImageView imageView = gameCenterUI2.gqw;
                    com.tencent.mm.ae.a.a.c.a aVar7 = new com.tencent.mm.ae.a.a.c.a();
                    aVar7.cPr = true;
                    GL.a(str, imageView, aVar7.GU());
                    LayoutParams layoutParams = gameCenterUI2.gqw.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = (int) (((float) c.getScreenWidth(gameCenterUI2)) * (((float) gameCenterUI2.getResources().getDimensionPixelSize(2131493119)) / ((float) gameCenterUI2.getResources().getDimensionPixelSize(2131493120))));
                        gameCenterUI2.gqw.setLayoutParams(layoutParams);
                        gameCenterUI2.gqw.setVisibility(0);
                        gameCenterUI2.gqu.setVisibility(8);
                    } else {
                        gameCenterUI2.gqw.setVisibility(8);
                    }
                }
            }
            if (i == 2) {
                ak.vA().x(new Runnable(gameCenterUI2) {
                    final /* synthetic */ GameCenterUI2 gqJ;

                    {
                        this.gqJ = r1;
                    }

                    public final void run() {
                        au.asg().a("new_pb_index", this.gqJ.gjC);
                    }
                });
            }
        }
    }

    static /* synthetic */ void i(GameCenterUI2 gameCenterUI2) {
        if (gameCenterUI2.gqg) {
            au.asd();
            gameCenterUI2.gqE = q.arq();
            if (gameCenterUI2.gqE != null) {
                gameCenterUI2.gqE.arp();
            }
            au.asd();
            gameCenterUI2.gqF = q.ars();
            if (gameCenterUI2.gqF != null) {
                gameCenterUI2.gqF.arp();
            }
        }
        au.asd();
        gameCenterUI2.gqG = q.aru();
        if (gameCenterUI2.gqG != null) {
            gameCenterUI2.gqG.arp();
        }
    }

    static /* synthetic */ void k(GameCenterUI2 gameCenterUI2) {
        if (gameCenterUI2.gqE == null || gameCenterUI2.gqE.field_isHidden) {
            af.a((Context) gameCenterUI2, 9, 901, 1, 6, 0, af.bH("resource", "0"));
            return;
        }
        int i = gameCenterUI2.gqE.field_msgType;
        if (gameCenterUI2.gqE.field_msgType == 100) {
            i = gameCenterUI2.gqE.giT;
        }
        af.a(gameCenterUI2, 9, 901, 1, 6, 0, gameCenterUI2.gqE.field_appId, 0, i, gameCenterUI2.gqE.field_gameMsgId, gameCenterUI2.gqE.giU, af.bH("resource", String.valueOf(gameCenterUI2.gqE.gin.gja)));
    }

    static /* synthetic */ void l(GameCenterUI2 gameCenterUI2) {
        if (gameCenterUI2.gqF != null && !gameCenterUI2.gqF.field_isHidden && !be.kS(gameCenterUI2.gqF.giC)) {
            n nVar = gameCenterUI2.gqF;
            c.o(gameCenterUI2.getBaseContext(), nVar.giC, "game_center_h5_floatlayer");
            int i = nVar.field_msgType;
            if (nVar.field_msgType == 100) {
                i = nVar.giT;
            }
            af.a(gameCenterUI2, 10, 1006, 1, 1, 0, nVar.field_appId, 0, i, nVar.field_gameMsgId, nVar.giU, null);
            gameCenterUI2.gqF.field_isRead = true;
            au.asc().a(gameCenterUI2.gqF, new String[0]);
        }
    }

    static /* synthetic */ void q(GameCenterUI2 gameCenterUI2) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(gameCenterUI2.getString(2131233102));
        if (!be.kS(gameCenterUI2.gqD)) {
            linkedList.add(gameCenterUI2.getString(2131233090));
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        g.a(gameCenterUI2, "", strArr, "", false, new g.c(gameCenterUI2) {
            final /* synthetic */ GameCenterUI2 gqJ;

            {
                this.gqJ = r1;
            }

            public final void gT(int i) {
                int i2 = 7;
                switch (i) {
                    case 0:
                        if (be.kS(this.gqJ.gqC)) {
                            Intent intent = new Intent(this.gqJ, AuthorizedGameListUI.class);
                            intent.putExtra("game_report_from_scene", this.gqJ.gjl);
                            this.gqJ.startActivity(intent);
                            i2 = 6;
                        } else {
                            c.W(this.gqJ.nDR.nEl, this.gqJ.gqC);
                        }
                        af.a(this.gqJ, 10, 1008, AuthorizedGameListUI.goF, i2, this.gqJ.gjl, null);
                        return;
                    case 1:
                        c.n(this.gqJ.nDR.nEl, this.gqJ.gqD, "game_center_classify");
                        af.a(this.gqJ, 10, 1014, 1, 7, this.gqJ.gjl, null);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        if (ak.uz()) {
            this.gjl = getIntent().getIntExtra("game_report_from_scene", 0);
            this.gqg = getIntent().getBooleanExtra("from_find_more_friend", false);
            ak.vy().a(1297, this);
            NI();
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ GameCenterUI2 gqJ;

                {
                    this.gqJ = r1;
                }

                public final void run() {
                    byte[] uf = au.asg().uf("new_pb_index");
                    if (uf == null) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass9 gqN;

                            {
                                this.gqN = r1;
                            }

                            public final void run() {
                                if (!this.gqN.gqJ.isFinishing()) {
                                    this.gqN.gqJ.gqy = c.ca(this.gqN.gqJ);
                                    this.gqN.gqJ.gqy.show();
                                }
                            }
                        });
                    } else {
                        final com.tencent.mm.plugin.game.c.ac acVar = new com.tencent.mm.plugin.game.c.ac(uf);
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass9 gqN;

                            public final void run() {
                                try {
                                    GameCenterUI2.a(this.gqN.gqJ, acVar, 1);
                                } catch (Exception e) {
                                    v.e("MicroMsg.GameCenterUI2", "GameCenter crash, %s", new Object[]{e.getMessage()});
                                    this.gqN.gqJ.finish();
                                }
                            }
                        });
                    }
                    au.asi().init(this.gqJ);
                    c.M(com.tencent.mm.plugin.game.c.e.arh());
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass9 gqN;

                        {
                            this.gqN = r1;
                        }

                        public final void run() {
                            this.gqN.gqJ.gqp.cP(true);
                        }
                    });
                    GameCenterUI2.i(this.gqJ);
                    if (this.gqJ.gqg) {
                        GameCenterUI2.k(this.gqJ);
                        GameCenterUI2.l(this.gqJ);
                        au.asd();
                        q.arr();
                        au.asd();
                        q.art();
                    }
                    ak.vy().a(new com.tencent.mm.plugin.game.c.an(u.bsY(), com.tencent.mm.plugin.game.c.e.arh(), this.gqJ.gqE, this.gqJ.gqF, this.gqJ.gqG, this.gqJ.gqg), 0);
                    ActionBarActivity actionBarActivity = this.gqJ.nDR.nEl;
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    SharedPreferences sharedPreferences = actionBarActivity.getSharedPreferences("game_center_pref", 0);
                    String string = sharedPreferences.getString("download_app_id_time_map", "");
                    if (!be.kS(string)) {
                        String[] split = string.split(",");
                        String str = new String();
                        string = str;
                        for (String str2 : split) {
                            String[] split2 = str2.split("-");
                            String str3 = split2[0];
                            if (!(be.kS(str3) || com.tencent.mm.pluginsdk.model.app.g.o(actionBarActivity, str3))) {
                                if (currentTimeMillis - be.getLong(split2[1], 0) < 86400) {
                                    string = string + str2 + ",";
                                } else {
                                    d.bnK().dm(d.bnK().GN(str3).id);
                                }
                            }
                        }
                        if (!be.kS(string)) {
                            if (string.charAt(string.length() - 1) == ',') {
                                string = string.substring(0, string.length() - 1);
                            }
                            sharedPreferences.edit().putString("download_app_id_time_map", string.toString()).apply();
                        }
                    }
                    aa.getContext().getSharedPreferences("game_center_pref", 0).edit().putString("game_center_pref_lang", u.bsY()).commit();
                    a.gzB.asG();
                }
            });
            af.a(this, 10, BaseReportManager.MAX_READ_COUNT, 0, 1, 0, null, this.gjl, 0, null, null, null);
            v.i("MicroMsg.GameCenterUI2", "[onCreate] time:" + (System.currentTimeMillis() - currentTimeMillis));
            v.i("MicroMsg.GameCenterUI2", "fromScene = %d", new Object[]{Integer.valueOf(this.gjl)});
            return;
        }
        v.e("MicroMsg.GameCenterUI2", "account not ready");
        finish();
    }

    protected void onResume() {
        super.onResume();
        if (ak.uz()) {
            if (!this.gqz) {
                this.gqk.asr();
                au.asi().init(this);
                this.gqp.cP(false);
                this.gqj.refresh();
                if (this.gqn != null) {
                    RecentGameInfoView recentGameInfoView = this.gqn;
                    String[] strArr = new String[RecentGameInfoView.gzj.keySet().size()];
                    RecentGameInfoView.gzj.keySet().toArray(strArr);
                    for (Object obj : strArr) {
                        View view = (View) RecentGameInfoView.gzj.get(obj);
                        if (view != null) {
                            b bVar = (b) view.getTag();
                            j jVar = (j) recentGameInfoView.gzh.get(obj);
                            if (!(jVar == null || jVar.ghX == null)) {
                                recentGameInfoView.grF.a(bVar.gvo, bVar.gvn, jVar.ghX, (j) recentGameInfoView.gzh.get(jVar.ghX.field_appId));
                            }
                        }
                    }
                }
                GameMessageBubbleView gameMessageBubbleView = this.gql;
                gameMessageBubbleView.gvS.setOnClickListener(null);
                gameMessageBubbleView.setVisibility(8);
                if (this.gqg) {
                    this.gql.asx();
                }
                if (a.gzB.gzA) {
                    a.gzB.gzA = false;
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ GameCenterUI2 gqJ;

                        {
                            this.gqJ = r1;
                        }

                        public final void run() {
                            ak.vy().a(new com.tencent.mm.plugin.game.c.an(u.bsY(), com.tencent.mm.plugin.game.c.e.arh(), this.gqJ.gqE, this.gqJ.gqF, this.gqJ.gqG, this.gqJ.gqg), 0);
                        }
                    });
                }
            }
            this.gqz = false;
            return;
        }
        v.e("MicroMsg.GameCenterUI2", "account not ready");
    }

    private void goBack() {
        String stringExtra = getIntent().getStringExtra("jump_find_more_friends");
        if (!be.kS(stringExtra) && stringExtra.equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            com.tencent.mm.ay.c.a(this, ".ui.LauncherUI", intent);
        }
        finish();
    }

    protected void onDestroy() {
        v.i("MicroMsg.GameCenterUI2", "onDestroy");
        super.onDestroy();
        if (ak.uz()) {
            if (this.gqj != null) {
                this.gqj.clear();
            }
            if (this.gqp != null) {
                GameInstalledView gameInstalledView = this.gqp;
                if (gameInstalledView.gjE != null) {
                    gameInstalledView.gjE.clear();
                }
                if (gameInstalledView.grE != null) {
                    i.b(gameInstalledView.grE);
                }
            }
            if (this.gqn != null) {
                RecentGameInfoView recentGameInfoView = this.gqn;
                if (recentGameInfoView.gzc != null) {
                    recentGameInfoView.gzc.clear();
                }
                if (recentGameInfoView.gzd != null) {
                    recentGameInfoView.gzd.clear();
                }
                if (recentGameInfoView.grE != null) {
                    i.b(recentGameInfoView.grE);
                }
                if (RecentGameInfoView.gzj != null) {
                    RecentGameInfoView.gzj.clear();
                }
            }
            a.gzB.clearCache();
            ak.vy().b(1297, this);
            com.tencent.mm.plugin.game.c.b asi = au.asi();
            v.i("MicroMsg.GameAppCacheService", "clear cached apppinfos");
            if (asi.ghl != null) {
                asi.ghl.clear();
            }
            if (asi.ghk != null) {
                asi.ghk.clear();
            }
            at.arZ();
            return;
        }
        v.e("MicroMsg.GameCenterUI2", "account not ready");
    }

    protected final int getLayoutId() {
        return 2130903699;
    }

    protected final int NO() {
        return 1;
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameCenterUI2 gqJ;

            {
                this.gqJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gqJ.goBack();
                return true;
            }
        });
        vD(2131233139);
        this.gqi = (GameCenterListView) findViewById(2131757201);
        this.gqi.setOnItemClickListener(this.gpM);
        this.gpM.lu(this.gjl);
        this.gqj = new f(this);
        this.gqj.lu(this.gjl);
        this.gqj.a(this.gpN);
        LayoutInflater layoutInflater = (LayoutInflater) this.nDR.nEl.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(2130903701, this.gqi, false);
        this.gqk = (GameInfoView) inflate.findViewById(2131757206);
        this.gqi.addHeaderView(inflate);
        inflate = layoutInflater.inflate(2130903697, this.gqi, false);
        this.gql = (GameMessageBubbleView) inflate.findViewById(2131757195);
        this.gqi.addHeaderView(inflate);
        inflate = layoutInflater.inflate(2130903766, this.gqi, false);
        this.gqm = (GameTopRecommendView) inflate.findViewById(2131757394);
        this.gqi.addHeaderView(inflate);
        inflate = layoutInflater.inflate(2130903752, this.gqi, false);
        this.gqn = (RecentGameInfoView) inflate.findViewById(2131757366);
        this.gqi.addHeaderView(inflate);
        inflate = layoutInflater.inflate(2130903754, this.gqi, false);
        this.gqo = (GameRecommendView) inflate.findViewById(2131757370);
        this.gqi.addHeaderView(inflate);
        inflate = layoutInflater.inflate(2130903702, this.gqi, false);
        this.gqp = (GameInstalledView) inflate.findViewById(2131757226);
        this.gqi.addHeaderView(inflate);
        this.gqq = layoutInflater.inflate(2130903703, this.gqi, false);
        this.gqr = (TextView) this.gqq.findViewById(2131757229);
        this.gqi.addHeaderView(this.gqq);
        View inflate2 = layoutInflater.inflate(2130903700, this.gqi, false);
        this.gqi.addFooterView(inflate2);
        this.gqs = inflate2.findViewById(2131757204);
        this.gqs.setOnClickListener(this.gqH);
        this.gqt = (TextView) inflate2.findViewById(2131757205);
        inflate2 = layoutInflater.inflate(2130903698, null);
        this.gqi.addFooterView(inflate2);
        this.gqu = inflate2.findViewById(2131757199);
        this.gqv = (TextView) inflate2.findViewById(2131757200);
        this.gqv.setOnClickListener(this.gqI);
        View inflate3 = layoutInflater.inflate(2130903725, this.gqi, false);
        this.gqi.addFooterView(inflate3);
        this.gqw = (ImageView) inflate3.findViewById(2131757314);
        this.gqi.setAdapter(this.gqj);
        this.gqx = findViewById(2131757203);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.GameCenterUI2", "errType: %d errCode: %d, scene: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.hashCode())});
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 1297:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final com.tencent.mm.ba.a aVar = ((com.tencent.mm.plugin.game.c.an) kVar).fut.czl.czs;
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ GameCenterUI2 gqJ;

                        public final void run() {
                            if (aVar == null) {
                                this.gqJ.gjC = new ac();
                            } else {
                                this.gqJ.gjC = (ac) aVar;
                            }
                            final com.tencent.mm.plugin.game.c.ac acVar = new com.tencent.mm.plugin.game.c.ac(aVar);
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass4 gqM;

                                public final void run() {
                                    try {
                                        GameCenterUI2.a(this.gqM.gqJ, acVar, 2);
                                    } catch (Exception e) {
                                        v.e("MicroMsg.GameCenterUI2", "GameCenter crash, %s", new Object[]{e.getMessage()});
                                        this.gqM.gqJ.finish();
                                    }
                                    if (this.gqM.gqJ.gqy != null) {
                                        this.gqM.gqJ.gqy.dismiss();
                                    }
                                    v.i("MicroMsg.GameCenterUI2", "Server data parsing time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
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

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.i("MicroMsg.GameCenterUI2", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }
}
