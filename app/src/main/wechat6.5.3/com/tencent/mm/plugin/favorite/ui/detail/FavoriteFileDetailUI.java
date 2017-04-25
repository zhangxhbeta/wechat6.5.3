package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.favorite.b.ae;
import com.tencent.mm.plugin.favorite.b.b.a;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.o;
import com.tencent.mm.plugin.favorite.b.p;
import com.tencent.mm.plugin.favorite.b.t;
import com.tencent.mm.plugin.favorite.b.t.b;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.c.e;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteFileDetailUI extends MMActivity implements a, g.a {
    private pw bdE;
    private ac cnC;
    private TextView dMQ;
    private com.tencent.mm.pluginsdk.ui.tools.g eJz = null;
    private TextView eVA;
    private ProgressBar elJ;
    private i fLP;
    private o fOv = new o();
    private Button fQD;
    private Button fQE;
    private Button fQF;
    private MMImageView fQG;
    private TextView fQH;
    private View fQI;
    private View fQJ;
    private TextView fQK;
    private boolean fQL = false;
    private boolean fQM = false;
    private String fQN;

    static /* synthetic */ void h(FavoriteFileDetailUI favoriteFileDetailUI) {
        int i = 3;
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        if (favoriteFileDetailUI.getType() == 15) {
            i = 11;
            intent.putExtra("image_path", p.b(favoriteFileDetailUI.bdE));
        } else if (favoriteFileDetailUI.getType() == 4) {
            intent.putExtra("image_path", p.b(favoriteFileDetailUI.bdE));
            i = 1;
        } else {
            intent.putExtra("file_title", favoriteFileDetailUI.bdE.title);
        }
        intent.putExtra("Retr_Msg_Type", i);
        c.a(favoriteFileDetailUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void i(FavoriteFileDetailUI favoriteFileDetailUI) {
        String lq = com.tencent.mm.as.p.lq(v.f(favoriteFileDetailUI.bdE));
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteFileDetailUI", "%d save video now video path %s out path %s", new Object[]{Integer.valueOf(favoriteFileDetailUI.hashCode()), r0, lq});
        if (be.kS(lq)) {
            Toast.makeText(favoriteFileDetailUI, favoriteFileDetailUI.getString(2131235794), 1).show();
            return;
        }
        Toast.makeText(favoriteFileDetailUI, favoriteFileDetailUI.getString(2131235795, new Object[]{lq}), 1).show();
        l.c(lq, favoriteFileDetailUI);
    }

    static /* synthetic */ void m(FavoriteFileDetailUI favoriteFileDetailUI) {
        if (favoriteFileDetailUI.getType() == 8 && v.c(favoriteFileDetailUI.bdE) && v.d(favoriteFileDetailUI.bdE)) {
            e.d(favoriteFileDetailUI.nDR.nEl, favoriteFileDetailUI.fLP);
        }
    }

    protected final int getLayoutId() {
        return 2130903623;
    }

    protected final int NO() {
        return 1;
    }

    private void amX() {
        String stringExtra = getIntent().getStringExtra("key_detail_data_id");
        Iterator it = this.fLP.field_favProto.mtR.iterator();
        while (it.hasNext()) {
            pw pwVar = (pw) it.next();
            if (pwVar.luu.equals(stringExtra)) {
                this.bdE = pwVar;
                break;
            }
        }
        if (this.bdE == null) {
            this.bdE = v.n(this.fLP);
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        this.cnC = new ac();
        long longExtra = getIntent().getLongExtra("key_detail_info_id", -1);
        this.fQM = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        this.fQN = getIntent().getStringExtra("fav_note_xml");
        this.fLP = h.alu().bB(longExtra);
        if (this.fQM) {
            this.fLP = v.tb(this.fQN);
        }
        if (this.fLP == null) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
            finish();
            return;
        }
        String string;
        boolean z2;
        t.j(this.fLP);
        amX();
        this.fQD = (Button) findViewById(2131757001);
        this.fQE = (Button) findViewById(2131757002);
        this.fQF = (Button) findViewById(2131756255);
        this.fQG = (MMImageView) findViewById(2131756771);
        this.eVA = (TextView) findViewById(2131756329);
        this.dMQ = (TextView) findViewById(2131757003);
        this.fQJ = findViewById(2131755473);
        this.fQI = findViewById(2131755471);
        this.elJ = (ProgressBar) findViewById(2131755472);
        this.fQH = (TextView) findViewById(2131757000);
        this.fQK = (TextView) findViewById(2131759210);
        int type = getType();
        if (4 == type) {
            vD(2131232752);
        } else if (15 == type) {
            vD(2131232752);
            findViewById(2131756998).setBackgroundResource(2131689547);
            this.eVA.setVisibility(8);
        } else {
            vD(2131232668);
        }
        if (this.bdE.aKG == 4) {
            this.fQG.setImageResource(2131165244);
        } else {
            this.fQG.setImageResource(com.tencent.mm.pluginsdk.model.p.Gt(this.bdE.msh));
        }
        this.eVA.setText(this.bdE.title);
        pz pzVar = this.bdE.msS;
        if (pzVar == null) {
            this.fQK.setVisibility(8);
        } else if (be.kS(pzVar.cqg)) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
            CharSequence charSequence = pzVar.cqj;
            final String str = pzVar.cqk;
            if (be.kS(charSequence) || be.kS(str)) {
                this.fQK.setVisibility(8);
            } else {
                this.fQK.setText(charSequence);
                this.fQK.setVisibility(0);
                this.fQK.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ FavoriteFileDetailUI fQP;

                    public final void onClick(View view) {
                        final Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("key_snsad_statextstr", this.fQP.bdE.bnY);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("rawUrl", str);
                        intent.putExtra("useJs", true);
                        ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c("", 18, 5, "", 2), 0);
                        new ac(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 fQQ;

                            public final void run() {
                                com.tencent.mm.plugin.sns.b.a.drp.j(intent, this.fQQ.fQP);
                                this.fQQ.fQP.finish();
                            }
                        });
                    }
                });
            }
        } else {
            string = getResources().getString(2131235359);
            if (pzVar.mtD / 60 > 0) {
                string = string + getResources().getString(2131235361, new Object[]{Integer.valueOf(pzVar.mtD / 60)});
            }
            if (pzVar.mtD % 60 > 0) {
                string = string + getResources().getString(2131235362, new Object[]{Integer.valueOf(pzVar.mtD % 60)});
            }
            this.fQK.setText(string + getResources().getString(2131235360));
            this.fQK.setVisibility(0);
            this.fQK.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FavoriteFileDetailUI fQP;

                {
                    this.fQP = r1;
                }

                public final void onClick(View view) {
                    t.a(t.a.EnterCompleteVideo, this.fQP.fLP);
                    pz pzVar = this.fQP.bdE.msS;
                    String g = v.g(this.fQP.bdE);
                    Intent intent = new Intent();
                    intent.putExtra("IsAd", false);
                    intent.putExtra("KStremVideoUrl", pzVar.cqg);
                    intent.putExtra("StreamWording", pzVar.cqj);
                    intent.putExtra("StremWebUrl", pzVar.cqk);
                    intent.putExtra("KBlockFav", true);
                    intent.putExtra("KThumUrl", pzVar.cql);
                    intent.putExtra("KThumbPath", g);
                    intent.putExtra("KMediaId", "fakeid_" + this.fQP.fLP.field_id);
                    intent.putExtra("KMediaVideoTime", pzVar.mtD);
                    intent.putExtra("KMediaTitle", this.fQP.bdE.title);
                    intent.putExtra("KSta_StremVideoAduxInfo", pzVar.cqm);
                    intent.putExtra("KSta_StremVideoPublishId", pzVar.cqn);
                    intent.putExtra("KSta_SourceType", 1);
                    intent.putExtra("KSta_Scene", b.Fav.value);
                    intent.putExtra("KSta_FromUserName", this.fQP.fLP.field_fromUser);
                    intent.putExtra("KSta_FavID", this.fQP.fLP.field_id);
                    intent.putExtra("KSta_SnsStatExtStr", this.fQP.bdE.bnY);
                    c.b(this.fQP, "sns", ".ui.VideoAdPlayerUI", intent);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteFileDetailUI fQP;

            {
                this.fQP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                t.a(t.a.LeavelFullScreen, this.fQP.fLP);
                this.fQP.finish();
                return true;
            }
        });
        this.fQE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavoriteFileDetailUI fQP;

            {
                this.fQP = r1;
            }

            public final void onClick(View view) {
                String f = v.f(this.fQP.bdE);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                if (4 == this.fQP.getType()) {
                    intent.setDataAndType(Uri.fromFile(new File(f)), "video/*");
                    try {
                        this.fQP.startActivity(intent);
                        return;
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteFileDetailUI", "startActivity fail, activity not found");
                        com.tencent.mm.ui.base.g.f(this.fQP.nDR.nEl, 2131232691, 2131232692);
                        return;
                    }
                }
                com.tencent.mm.pluginsdk.ui.tools.a.c(this.fQP, f, this.fQP.bdE.msh, 2);
            }
        });
        string = this.bdE.mrZ;
        if (!be.kS(string)) {
            this.fQD.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FavoriteFileDetailUI fQP;

                public final void onClick(View view) {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", new Object[]{Integer.valueOf(this.fQP.fLP.field_id), Long.valueOf(this.fQP.fLP.field_localId)});
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", string);
                    intent.putExtra("is_favorite_item", true);
                    intent.putExtra("fav_local_id", this.fQP.fLP.field_localId);
                    intent.putExtra("geta8key_scene", 14);
                    com.tencent.mm.plugin.favorite.c.j(intent, this.fQP.nDR.nEl);
                }
            });
        }
        this.fQF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavoriteFileDetailUI fQP;

            {
                this.fQP = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[]{Integer.valueOf(this.fQP.fLP.field_id), Long.valueOf(this.fQP.fLP.field_localId), Integer.valueOf(this.fQP.fLP.field_itemStatus)});
                if (f.sj()) {
                    if (this.fQP.fLP.alB()) {
                        v.l(this.fQP.fLP);
                    } else if (this.fQP.fQM) {
                        this.fQP.fLP.field_itemStatus = 7;
                        v.h(this.fQP.bdE);
                    } else {
                        v.m(this.fQP.fLP);
                    }
                    this.fQP.amZ();
                    return;
                }
                com.tencent.mm.ui.base.g.f(this.fQP.nDR.nEl, 2131232694, 2131232638);
            }
        });
        this.fQJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavoriteFileDetailUI fQP;

            {
                this.fQP = r1;
            }

            public final void onClick(View view) {
                if (this.fQP.fLP.alC()) {
                    v.e(this.fQP.bdE);
                    this.fQP.fQF.setText(2131232681);
                } else {
                    v.o(this.fQP.fLP);
                    this.fQP.fQF.setText(2131232682);
                }
                this.fQP.ana();
            }
        });
        final boolean booleanExtra = getIntent().getBooleanExtra("key_detail_can_delete", true);
        final int type2 = getType();
        if (type2 == 8) {
            z = this.fLP.aly();
        } else if (type2 == 15) {
            z2 = this.fLP.aly() && be.KL(j.sU().getValue("SIGHTCannotTransmitForFav")) == 0;
            if (z2 || booleanExtra) {
                a(0, 2131235683, 2130838681, new OnMenuItemClickListener(this) {
                    final /* synthetic */ FavoriteFileDetailUI fQP;

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(this.fQP.nDR.nEl, com.tencent.mm.ui.widget.f.pbS, false);
                        fVar.jXn = new n.c(this) {
                            final /* synthetic */ AnonymousClass13 fQW;

                            {
                                this.fQW = r1;
                            }

                            /* JADX WARNING: inconsistent code. */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void a(com.tencent.mm.ui.base.l r9) {
                                /*
                                r8 = this;
                                r7 = 2131231838; // 0x7f08045e float:1.8079768E38 double:1.0529684345E-314;
                                r6 = 4;
                                r5 = 2131232731; // 0x7f0807db float:1.808158E38 double:1.0529688757E-314;
                                r1 = 1;
                                r2 = 0;
                                r0 = r8.fQW;
                                r0 = r0;
                                if (r0 == 0) goto L_0x002f;
                            L_0x000f:
                                r0 = r8.fQW;
                                r0 = r0.fQP;
                                r0 = r0.bdE;
                                if (r0 != 0) goto L_0x0058;
                            L_0x0019:
                                r0 = r1;
                            L_0x001a:
                                if (r0 != 0) goto L_0x002f;
                            L_0x001c:
                                r0 = r8.fQW;
                                r0 = r4;
                                r3 = 8;
                                if (r0 != r3) goto L_0x00e0;
                            L_0x0024:
                                r0 = r8.fQW;
                                r0 = r0.fQP;
                                r0 = r0.getString(r5);
                                r9.d(r2, r0);
                            L_0x002f:
                                r0 = r8.fQW;
                                r0 = r3;
                                if (r0 == 0) goto L_0x0057;
                            L_0x0035:
                                r0 = 3;
                                r1 = r8.fQW;
                                r1 = r1.fQP;
                                r2 = 2131232647; // 0x7f080787 float:1.808141E38 double:1.052968834E-314;
                                r1 = r1.getString(r2);
                                r9.d(r0, r1);
                                r0 = 2;
                                r1 = r8.fQW;
                                r1 = r1.fQP;
                                r1 = r1.nDR;
                                r1 = r1.nEl;
                                r2 = 2131231020; // 0x7f08012c float:1.807811E38 double:1.0529680303E-314;
                                r1 = r1.getString(r2);
                                r9.d(r0, r1);
                            L_0x0057:
                                return;
                            L_0x0058:
                                r3 = r0.aKG;
                                switch(r3) {
                                    case 2: goto L_0x005f;
                                    case 3: goto L_0x00dd;
                                    case 4: goto L_0x00a0;
                                    case 5: goto L_0x005d;
                                    case 6: goto L_0x005d;
                                    case 7: goto L_0x00b7;
                                    case 8: goto L_0x005f;
                                    case 9: goto L_0x005d;
                                    case 10: goto L_0x005d;
                                    case 11: goto L_0x005d;
                                    case 12: goto L_0x005d;
                                    case 13: goto L_0x005d;
                                    case 14: goto L_0x005d;
                                    case 15: goto L_0x0072;
                                    default: goto L_0x005d;
                                };
                            L_0x005d:
                                r0 = r2;
                                goto L_0x001a;
                            L_0x005f:
                                r3 = new java.io.File;
                                r0 = com.tencent.mm.plugin.favorite.b.v.f(r0);
                                r3.<init>(r0);
                                r0 = r3.exists();
                                if (r0 != 0) goto L_0x0070;
                            L_0x006e:
                                r0 = r1;
                                goto L_0x001a;
                            L_0x0070:
                                r0 = r2;
                                goto L_0x001a;
                            L_0x0072:
                                r3 = com.tencent.mm.h.j.sU();
                                r4 = "SIGHTCannotTransmitForFav";
                                r3 = r3.getValue(r4);
                                r3 = com.tencent.mm.sdk.platformtools.be.KL(r3);
                                if (r3 == 0) goto L_0x008e;
                            L_0x0083:
                                r0 = "MicroMsg.FavSendFilter";
                                r3 = "can not retransmit short video";
                                com.tencent.mm.sdk.platformtools.v.w(r0, r3);
                                r0 = r1;
                                goto L_0x001a;
                            L_0x008e:
                                r3 = new java.io.File;
                                r0 = com.tencent.mm.plugin.favorite.b.v.f(r0);
                                r3.<init>(r0);
                                r0 = r3.exists();
                                if (r0 != 0) goto L_0x005d;
                            L_0x009d:
                                r0 = r1;
                                goto L_0x001a;
                            L_0x00a0:
                                r3 = new java.io.File;
                                r4 = com.tencent.mm.plugin.favorite.b.v.f(r0);
                                r3.<init>(r4);
                                r3 = r3.exists();
                                if (r3 != 0) goto L_0x005d;
                            L_0x00af:
                                r0 = r0.mrZ;
                                r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
                                goto L_0x001a;
                            L_0x00b7:
                                r3 = r0.mrZ;
                                r3 = com.tencent.mm.sdk.platformtools.be.kS(r3);
                                if (r3 == 0) goto L_0x00da;
                            L_0x00bf:
                                r3 = r0.msb;
                                r3 = com.tencent.mm.sdk.platformtools.be.kS(r3);
                                if (r3 == 0) goto L_0x00da;
                            L_0x00c7:
                                r3 = r0.msd;
                                r3 = com.tencent.mm.sdk.platformtools.be.kS(r3);
                                if (r3 == 0) goto L_0x00da;
                            L_0x00cf:
                                r0 = r0.msd;
                                r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
                                if (r0 == 0) goto L_0x00da;
                            L_0x00d7:
                                r0 = r1;
                                goto L_0x001a;
                            L_0x00da:
                                r0 = r2;
                                goto L_0x001a;
                            L_0x00dd:
                                r0 = r1;
                                goto L_0x001a;
                            L_0x00e0:
                                r0 = r8.fQW;
                                r0 = r4;
                                r3 = 15;
                                if (r0 != r3) goto L_0x0100;
                            L_0x00e8:
                                r0 = r8.fQW;
                                r0 = r0.fQP;
                                r0 = r0.getString(r5);
                                r9.d(r2, r0);
                                r0 = r8.fQW;
                                r0 = r0.fQP;
                                r0 = r0.getString(r7);
                                r9.d(r6, r0);
                                goto L_0x002f;
                            L_0x0100:
                                r0 = r8.fQW;
                                r0 = r4;
                                if (r0 != r6) goto L_0x011e;
                            L_0x0106:
                                r0 = r8.fQW;
                                r0 = r0.fQP;
                                r0 = r0.getString(r5);
                                r9.d(r2, r0);
                                r0 = r8.fQW;
                                r0 = r0.fQP;
                                r0 = r0.getString(r7);
                                r9.d(r6, r0);
                                goto L_0x002f;
                            L_0x011e:
                                r0 = r8.fQW;
                                r0 = r0.fQP;
                                r0 = r0.getString(r5);
                                r9.d(r2, r0);
                                r0 = r8.fQW;
                                r0 = r3;
                                if (r0 == 0) goto L_0x002f;
                            L_0x012f:
                                r0 = r8.fQW;
                                r0 = r0.fQP;
                                r0 = r0.fLP;
                                r0 = r0.alz();
                                if (r0 == 0) goto L_0x002f;
                            L_0x013d:
                                r0 = r8.fQW;
                                r0 = r0.fQP;
                                r2 = 2131232704; // 0x7f0807c0 float:1.8081525E38 double:1.0529688623E-314;
                                r0 = r0.getString(r2);
                                r9.d(r1, r0);
                                goto L_0x002f;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.ui.detail.FavoriteFileDetailUI.13.1.a(com.tencent.mm.ui.base.l):void");
                            }
                        };
                        fVar.jXo = new d(this) {
                            final /* synthetic */ AnonymousClass13 fQW;

                            {
                                this.fQW = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        if (this.fQW.fQP.getType() == 8) {
                                            String f = v.f(this.fQW.fQP.bdE);
                                            if (!com.tencent.mm.a.e.aR(f)) {
                                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
                                                Toast.makeText(this.fQW.fQP, this.fQW.fQP.getString(2131232729), 1).show();
                                                return;
                                            } else if (new File(f).length() > 10485760) {
                                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
                                                Toast.makeText(this.fQW.fQP, this.fQW.fQP.getString(2131232730), 1).show();
                                                return;
                                            }
                                        }
                                        FavoriteFileDetailUI.h(this.fQW.fQP);
                                        return;
                                    case 1:
                                        final com.tencent.mm.ui.base.p a = com.tencent.mm.ui.base.g.a(this.fQW.fQP.nDR.nEl, this.fQW.fQP.getString(2131232670), false, null);
                                        ActionBarActivity actionBarActivity = this.fQW.fQP.nDR.nEl;
                                        i b = this.fQW.fQP.fLP;
                                        Runnable anonymousClass1 = new Runnable(this) {
                                            final /* synthetic */ AnonymousClass2 fQX;

                                            public final void run() {
                                                a.dismiss();
                                            }
                                        };
                                        List linkedList = new LinkedList();
                                        linkedList.add(Integer.valueOf(b.field_id));
                                        ak.vy().a(new ae("", linkedList, new com.tencent.mm.plugin.favorite.b.p.AnonymousClass2(b, actionBarActivity, anonymousClass1)), 0);
                                        return;
                                    case 2:
                                        com.tencent.mm.ui.base.g.a(this.fQW.fQP.nDR.nEl, this.fQW.fQP.getString(2131231021), "", new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass2 fQX;

                                            {
                                                this.fQX = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                final com.tencent.mm.ui.base.p a = com.tencent.mm.ui.base.g.a(this.fQX.fQW.fQP.nDR.nEl, this.fQX.fQW.fQP.getString(2131231021), false, null);
                                                v.a(this.fQX.fQW.fQP.fLP.field_localId, new Runnable(this) {
                                                    final /* synthetic */ AnonymousClass2 fQZ;

                                                    public final void run() {
                                                        a.dismiss();
                                                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteFileDetailUI", "do del fav file, local id %d, fav id %d", new Object[]{Long.valueOf(this.fQZ.fQX.fQW.fQP.fLP.field_localId), Integer.valueOf(this.fQZ.fQX.fQW.fQP.fLP.field_id)});
                                                        this.fQZ.fQX.fQW.fQP.finish();
                                                    }
                                                });
                                            }
                                        }, null);
                                        return;
                                    case 3:
                                        Intent intent = new Intent(this.fQW.fQP.nDR.nEl, FavTagEditUI.class);
                                        intent.putExtra("key_fav_scene", 2);
                                        intent.putExtra("key_fav_item_id", this.fQW.fQP.fLP.field_localId);
                                        this.fQW.fQP.nDR.nEl.startActivity(intent);
                                        return;
                                    case 4:
                                        FavoriteFileDetailUI.i(this.fQW.fQP);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        };
                        fVar.bKh();
                        return true;
                    }
                });
            }
            db(false);
        } else if (!(this.fLP.alz() || this.fLP.aly())) {
            z = false;
        }
        z2 = z;
        a(0, 2131235683, 2130838681, /* anonymous class already generated */);
        db(false);
    }

    private int getType() {
        if (this.bdE.aKG == 0) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteFileDetailUI", "get data tpye, but data item type is 0, info type %d", new Object[]{Integer.valueOf(this.fLP.field_type)});
            if (4 == this.fLP.field_type) {
                return 4;
            }
            if (16 != this.fLP.field_type) {
                return 8;
            }
            if (this.bdE == null || this.bdE.msS == null) {
                return 4;
            }
            if (!be.kS(this.bdE.msS.cqg)) {
                return 15;
            }
            if (be.kS(this.bdE.msS.cqk)) {
                return 4;
            }
            return 15;
        } else if (this.bdE.aKG != 15) {
            return this.bdE.aKG;
        } else {
            if (this.bdE == null || this.bdE.msS == null) {
                return 4;
            }
            if (!be.kS(this.bdE.msS.cqg)) {
                return 15;
            }
            if (be.kS(this.bdE.msS.cqk)) {
                return 4;
            }
            return 15;
        }
    }

    private void db(boolean z) {
        boolean c = v.c(this.bdE);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", new Object[]{Integer.valueOf(this.fLP.field_itemStatus), Boolean.valueOf(c), v.f(this.bdE)});
        int i;
        if (this.fLP.isDone() || c) {
            if (c) {
                if (getType() == 15) {
                    this.fQG.setVisibility(8);
                    this.fQI.setVisibility(8);
                    this.fQF.setVisibility(8);
                    this.fQD.setVisibility(8);
                    this.fQE.setVisibility(8);
                    this.dMQ.setVisibility(8);
                    String f = v.f(this.bdE);
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.sl() + " initView: fullpath:" + f);
                    ViewGroup viewGroup = (ViewGroup) findViewById(2131756998);
                    this.eJz = com.tencent.mm.pluginsdk.ui.tools.o.do(this.nDR.nEl);
                    LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    viewGroup.addView((View) this.eJz, 0, layoutParams);
                    this.eJz.a(new com.tencent.mm.pluginsdk.ui.tools.g.a(this) {
                        final /* synthetic */ FavoriteFileDetailUI fQP;

                        {
                            this.fQP = r1;
                        }

                        public final void abH() {
                            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.sl() + " onPrepared");
                            this.fQP.eJz.fD(true);
                            this.fQP.eJz.start();
                        }

                        public final void bp(int i, int i2) {
                            this.fQP.eJz.stop();
                            if (!this.fQP.fQL) {
                                this.fQP.fQL = true;
                                ad.o(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass14 fRa;

                                    {
                                        this.fRa = r1;
                                    }

                                    public final void run() {
                                        com.tencent.mm.ui.base.g.f(this.fRa.fQP.nDR.nEl, 2131235793, 2131231868);
                                        Bitmap a = com.tencent.mm.plugin.favorite.c.g.a(this.fRa.fQP.bdE, this.fRa.fQP.fLP);
                                        ImageView imageView = (ImageView) this.fRa.fQP.findViewById(2131756999);
                                        if (imageView != null) {
                                            imageView.setImageBitmap(a);
                                            imageView.setVisibility(0);
                                        }
                                    }
                                });
                            }
                        }

                        public final void pa() {
                        }

                        public final int bq(int i, int i2) {
                            return 0;
                        }

                        public final void br(int i, int i2) {
                        }
                    });
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.sl() + " initView :" + f);
                    if (f != null) {
                        this.eJz.stop();
                        this.eJz.setVideoPath(f);
                    }
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.sl() + " initView");
                    if (ak.oJ() != null) {
                        ak.oJ().pU();
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.h(11444, new Object[]{Integer.valueOf(4)});
                } else {
                    i = (v.c(this.bdE) && v.d(this.bdE)) ? 1 : 0;
                    if (i != 0) {
                        this.fQI.setVisibility(8);
                        this.fQF.setVisibility(8);
                        this.fQD.setVisibility(0);
                        this.fQE.setVisibility(8);
                        this.dMQ.setVisibility(8);
                        this.fQD.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ FavoriteFileDetailUI fQP;

                            {
                                this.fQP = r1;
                            }

                            public final void onClick(View view) {
                                FavoriteFileDetailUI.m(this.fQP);
                            }
                        });
                    } else {
                        this.fQI.setVisibility(8);
                        this.fQF.setVisibility(8);
                        if (be.kS(this.bdE.mrZ)) {
                            this.fQD.setVisibility(8);
                        } else {
                            this.fQD.setVisibility(0);
                        }
                        this.fQE.setVisibility(0);
                        this.dMQ.setVisibility(0);
                    }
                }
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ FavoriteFileDetailUI fQP;

                    {
                        this.fQP = r1;
                    }

                    public final void run() {
                        v.t(this.fQP.fLP);
                    }
                });
            } else if (be.kS(this.bdE.mrS)) {
                amY();
            } else {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
                ana();
            }
        } else if (this.fLP.alD()) {
            if (be.kS(this.bdE.mrS)) {
                amY();
                if (z) {
                    i = getType();
                    i = (4 == i || 15 == i) ? 2131232718 : 2131232711;
                    com.tencent.mm.ui.base.g.bf(this.nDR.nEl, getString(i));
                    return;
                }
                return;
            }
            ana();
            if (z) {
                com.tencent.mm.ui.base.g.bf(this.nDR.nEl, getString(2131232297));
            }
        } else if (this.fLP.alB()) {
            ana();
            if (z) {
                com.tencent.mm.ui.base.g.bf(this.nDR.nEl, getString(2131235726));
            }
        } else if (this.fLP.alC() || this.fLP.alA()) {
            amZ();
        } else {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
            ana();
        }
    }

    private void amY() {
        this.fQF.setVisibility(8);
        this.fQD.setVisibility(8);
        this.fQE.setVisibility(8);
        this.fQI.setVisibility(8);
        this.dMQ.setVisibility(0);
        if (this.bdE.aKG == 4) {
            this.dMQ.setGravity(17);
            this.dMQ.setText(2131232699);
            return;
        }
        this.dMQ.setGravity(17);
        this.dMQ.setText(2131232698);
    }

    private void amZ() {
        int progress;
        int i;
        int i2;
        this.fQF.setVisibility(8);
        this.fQD.setVisibility(8);
        this.fQE.setVisibility(8);
        this.dMQ.setVisibility(8);
        this.fQI.setVisibility(0);
        com.tencent.mm.plugin.favorite.b.a sL = h.alp().sL(this.bdE.luu);
        if (sL != null) {
            progress = (int) sL.getProgress();
            i = sL.field_offset;
            i2 = sL.field_totalLen;
        } else {
            progress = 0;
            i2 = (int) this.bdE.msn;
            i = 0;
        }
        if (this.fLP.alA()) {
            a((float) progress, getString(2131232750, new Object[]{v.N((float) i), v.N((float) i2)}));
            return;
        }
        a((float) progress, getString(2131232644, new Object[]{v.N((float) i), v.N((float) i2)}));
    }

    private void ana() {
        this.fQI.setVisibility(8);
        this.fQE.setVisibility(8);
        if (be.kS(this.bdE.mrZ)) {
            this.fQD.setVisibility(8);
        } else {
            this.fQD.setVisibility(0);
        }
        this.fQF.setVisibility(0);
        com.tencent.mm.plugin.favorite.b.a sL = h.alp().sL(this.bdE.luu);
        if (sL == null || sL.field_offset <= 0) {
            this.fQF.setText(this.fLP.alB() ? 2131232683 : 2131232678);
        } else {
            this.fQF.setText(this.fLP.alB() ? 2131232682 : 2131232681);
        }
        this.dMQ.setVisibility(0);
    }

    protected void onDestroy() {
        if (this.eJz != null) {
            this.eJz.a(null);
            this.eJz.stop();
            this.eJz.onDetach();
            if (ak.oJ() != null) {
                ak.oJ().pT();
            }
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        h.alu().c(this);
        h.alp().a((a) this);
        if (this.eJz != null) {
            this.eJz.start();
        }
    }

    protected void onPause() {
        super.onPause();
        h.alu().d(this);
        h.alp().b((a) this);
        if (this.eJz != null) {
            this.eJz.stop();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, 2);
        if (i2 == -1 && i == 1) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final com.tencent.mm.ui.base.p a = com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131232670), false, null);
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", new Object[]{Integer.valueOf(getType())});
            Runnable anonymousClass4 = new Runnable(this) {
                final /* synthetic */ FavoriteFileDetailUI fQP;

                public final void run() {
                    a.dismiss();
                }
            };
            int type = getType();
            if (!be.kS(stringExtra)) {
                for (String str2 : be.g(stringExtra.split(","))) {
                    if (type == 4 || type == 15) {
                        ActionBarActivity actionBarActivity = this.nDR.nEl;
                        pw pwVar = this.bdE;
                        if (actionBarActivity == null) {
                            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
                        } else if (be.kS(str2)) {
                            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
                        } else if (pwVar == null) {
                            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
                        } else {
                            ak.vA().x(new com.tencent.mm.plugin.favorite.b.p.AnonymousClass3(pwVar, actionBarActivity, str2, anonymousClass4));
                        }
                        boolean dE = m.dE(str2);
                        t.a(dE ? t.c.Chatroom : t.c.Chat, this.fLP, t.d.Full, dE ? com.tencent.mm.model.i.el(str2) : 0);
                    } else {
                        p.a(this.nDR.nEl, str2, this.fLP, this.bdE, anonymousClass4);
                    }
                    if (!be.kS(str)) {
                        com.tencent.mm.pluginsdk.j.a.bmt().x(str2, str, m.fp(str2));
                    }
                }
                com.tencent.mm.ui.snackbar.a.f(this, getString(2131232839));
            }
        }
    }

    public final void b(com.tencent.mm.plugin.favorite.b.a aVar) {
        if (aVar == null || aVar.field_dataId == null) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, item is null");
            return;
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[]{this.bdE.luu, aVar.field_dataId});
        if (!aVar.field_dataId.equals(this.bdE.luu)) {
            return;
        }
        if (this.fLP.alA()) {
            a(aVar.getProgress(), getString(2131232750, new Object[]{v.N((float) aVar.field_offset), v.N((float) aVar.field_totalLen)}));
            return;
        }
        a(aVar.getProgress(), getString(2131232644, new Object[]{v.N((float) aVar.field_offset), v.N((float) aVar.field_totalLen)}));
        if (this.fQM && com.tencent.mm.a.e.aR(aVar.field_path)) {
            this.fLP.field_itemStatus = 10;
            a("", null);
        }
    }

    private void a(final float f, final String str) {
        this.cnC.post(new Runnable(this) {
            final /* synthetic */ FavoriteFileDetailUI fQP;

            public final void run() {
                this.fQP.elJ.setProgress((int) f);
                this.fQP.fQH.setText(str);
            }
        });
    }

    public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[]{str, Long.valueOf(this.fLP.field_localId)});
        i bB = h.alu().bB(this.fLP.field_localId);
        if (bB != null || this.fQM) {
            if (!this.fQM) {
                this.fLP = bB;
            }
            amX();
            this.cnC.post(new Runnable(this) {
                final /* synthetic */ FavoriteFileDetailUI fQP;

                {
                    this.fQP = r1;
                }

                public final void run() {
                    this.fQP.db(true);
                }
            });
            return;
        }
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
        finish();
    }
}
