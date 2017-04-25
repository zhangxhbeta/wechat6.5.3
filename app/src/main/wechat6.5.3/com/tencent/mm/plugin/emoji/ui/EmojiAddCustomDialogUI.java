package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.d.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.ds;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.b;
import com.tencent.mm.ui.tools.a.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.List;

public class EmojiAddCustomDialogUI extends MMBaseActivity implements e {
    private int cVh;
    private ProgressDialog eZg;
    private String fgK;
    private String fgL;
    private c fgM;
    private h fgN;
    private h fgO;
    private Context mContext;
    private ac mHandler = new ac(this) {
        final /* synthetic */ EmojiAddCustomDialogUI fgP;

        {
            this.fgP = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    EmojiAddCustomDialogUI.a(this.fgP, this.fgP.getString(2131232426));
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void a(EmojiAddCustomDialogUI emojiAddCustomDialogUI, String str) {
        emojiAddCustomDialogUI.getString(2131231164);
        emojiAddCustomDialogUI.eZg = g.a(emojiAddCustomDialogUI, str, true, new OnCancelListener(emojiAddCustomDialogUI) {
            final /* synthetic */ EmojiAddCustomDialogUI fgP;

            {
                this.fgP = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
        }
        this.mContext = this;
        this.fgK = getIntent().getStringExtra("extra_id");
        this.cVh = getIntent().getIntExtra("extra_scence", -1);
        this.fgL = getIntent().getStringExtra("extra_username");
        if (be.kS(this.fgK)) {
            v.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
            finish();
        }
        this.fgM = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(this.fgK);
        ak.vy().a(698, this);
        ak.vy().a(423, this);
        ak.vy().a(703, this);
        this.mHandler.sendEmptyMessageDelayed(1001, 300);
        Context context = this.mContext;
        final c cVar = this.fgM;
        if (context == null) {
            v.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
        } else if (cVar == null) {
            v.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
        } else {
            b PE = b.PE(cVar.dR(cVar.field_groupId, cVar.EB()));
            PE.hO = com.tencent.mm.h.b.sH();
            PE.ym(com.tencent.mm.h.b.sI()).a(new a(this) {
                final /* synthetic */ EmojiAddCustomDialogUI fgP;

                public final void a(b bVar) {
                    if (com.tencent.mm.plugin.emoji.model.g.afx().fch.iC(false) >= o.afk()) {
                        v.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
                        this.fgP.agt();
                        this.fgP.agE();
                        com.tencent.mm.plugin.report.service.g.iuh.h(10431, new Object[]{Integer.valueOf(this.fgP.cVh), this.fgP.fgM.EB(), this.fgP.fgM.field_designerID, this.fgP.fgM.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.fgP.fgM.field_size), this.fgP.fgL});
                    } else if (cVar.field_catalog == c.nwR || be.kS(cVar.field_groupId) || (!be.kS(cVar.field_groupId) && j.a.bmr().rl(cVar.field_groupId))) {
                        EmojiAddCustomDialogUI.j(cVar);
                    } else {
                        ak.vy().a(new com.tencent.mm.plugin.emoji.e.g(cVar.field_groupId, (byte) 0), 0);
                    }
                }

                public final void agF() {
                    this.fgP.agt();
                    this.fgP.fgN = g.a(this.fgP.mContext, this.fgP.mContext.getString(2131232335), "", this.fgP.getString(2131233285), new OnClickListener(this.fgP) {
                        final /* synthetic */ EmojiAddCustomDialogUI fgP;

                        {
                            this.fgP = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.fgP.finish();
                        }
                    });
                    com.tencent.mm.plugin.report.service.g.iuh.h(10431, new Object[]{Integer.valueOf(this.fgP.cVh), this.fgP.fgM.EB(), this.fgP.fgM.field_designerID, this.fgP.fgM.field_groupId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(this.fgP.fgM.field_size), this.fgP.fgL});
                }
            });
        }
    }

    protected void onDestroy() {
        ak.vy().b(698, this);
        ak.vy().b(423, this);
        ak.vy().b(703, this);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        if (type == 698) {
            if (i2 == -434) {
                v.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
                agt();
                agE();
                com.tencent.mm.plugin.report.service.g.iuh.h(10431, new Object[]{Integer.valueOf(this.cVh), this.fgM.EB(), this.fgM.field_designerID, this.fgM.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.fgM.field_size), this.fgL});
            } else if (i == 0 && i2 == 0) {
                v.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
                ds dsVar = (ds) ((com.tencent.mm.plugin.emoji.e.c) kVar).cif.czl.czs;
                if (((dsVar != null ? 1 : 0) & (dsVar.meC != null ? 1 : 0)) == 0 || dsVar.meC.size() <= 0) {
                    agD();
                    return;
                }
                v.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", new Object[]{Integer.valueOf(dsVar.meC.size())});
                dsVar.meC.get(0);
                ak.vy().a(new f(this.fgM), 0);
                v.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "start upload emoji");
            } else {
                agC();
            }
        } else if (type == 423) {
            com.tencent.mm.plugin.emoji.e.g gVar = (com.tencent.mm.plugin.emoji.e.g) kVar;
            if (gVar == null || be.kS(gVar.fdU) || this.fgM == null || be.kS(this.fgM.field_groupId) || !this.fgM.field_groupId.equalsIgnoreCase(gVar.fdU)) {
                v.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
            } else if (i == 0 && i2 == 0) {
                j(this.fgM);
            } else if (i2 == 4) {
                agt();
                rI(getString(2131232324));
            } else if (i2 == 8) {
                agt();
                rI(getString(2131232323));
            } else if (i2 == 9) {
                agt();
                rI(getString(2131232322));
            } else if (i2 == -2) {
                agt();
                rI(getString(2131232325));
            } else {
                agt();
                rI(getString(2131232321));
            }
        } else if (type != 703) {
        } else {
            if (i == 0 && i2 == 0) {
                agD();
            } else {
                agC();
            }
        }
    }

    private void agC() {
        v.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error.");
        agt();
        g.bf(this.mContext, aa.getContext().getString(2131232321));
        com.tencent.mm.plugin.report.service.g.iuh.h(10431, new Object[]{Integer.valueOf(this.cVh), this.fgM.EB(), this.fgM.field_designerID, this.fgM.field_groupId, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(this.fgM.field_size), this.fgL});
        finish();
    }

    private void agD() {
        v.d("MicroMsg.emoji.EmojiAddCustomDialogUI", "dealSaveSuccess");
        if (this.fgM.field_catalog != c.nwR) {
            this.fgM.field_catalog = c.nwR;
            int bxS = com.tencent.mm.plugin.emoji.model.g.afx().fch.bxS();
            if (bxS < o.afk()) {
                bxS = o.afk();
            } else {
                bxS++;
            }
            this.fgM.field_reserved3 = bxS;
            com.tencent.mm.plugin.emoji.model.g.afx().fch.r(this.fgM);
            com.tencent.mm.plugin.report.service.g.iuh.h(10431, new Object[]{Integer.valueOf(this.cVh), this.fgM.EB(), this.fgM.field_designerID, this.fgM.field_groupId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.fgM.field_size), this.fgL});
            com.tencent.mm.plugin.emoji.d.f.aeV().c(this.fgM, false);
        }
        String str = this.fgM.dR(this.fgM.field_groupId, this.fgM.EB()) + "_cover";
        if (!(be.kS(this.fgM.field_thumbUrl) || com.tencent.mm.a.e.aR(str))) {
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPu = str;
            aVar.cPs = true;
            aVar.cPq = false;
            n.GL().a(this.fgM.field_thumbUrl, null, aVar.GU());
        }
        com.tencent.mm.storage.a.b bVar = com.tencent.mm.plugin.emoji.model.g.afx().fci;
        if (!com.tencent.mm.storage.a.b.bxt()) {
            com.tencent.mm.plugin.emoji.model.g.afx().fci.bxu();
        }
        agt();
        g.bf(this.mContext, aa.getContext().getString(2131230902));
        finish();
    }

    private static void j(c cVar) {
        v.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate ");
        List arrayList = new ArrayList();
        arrayList.add(cVar.EB());
        ak.vy().a(new com.tencent.mm.plugin.emoji.e.c(1, arrayList), 0);
    }

    private void agE() {
        this.fgN = g.a(this.mContext, 2131232444, 2131231035, 2131232387, 2131231010, new OnClickListener(this) {
            final /* synthetic */ EmojiAddCustomDialogUI fgP;

            {
                this.fgP = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                com.tencent.mm.plugin.report.service.g.iuh.h(11596, new Object[]{Integer.valueOf(3)});
                intent.setClass(this.fgP.mContext, EmojiCustomUI.class);
                this.fgP.startActivity(intent);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ EmojiAddCustomDialogUI fgP;

            {
                this.fgP = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.fgP.finish();
            }
        });
        if (this.fgN != null) {
            this.fgN.setOnDismissListener(new OnDismissListener(this) {
                final /* synthetic */ EmojiAddCustomDialogUI fgP;

                {
                    this.fgP = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    this.fgP.finish();
                }
            });
        }
    }

    private void rI(String str) {
        this.fgO = g.A(this, str, "");
        this.fgO.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ EmojiAddCustomDialogUI fgP;

            {
                this.fgP = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.fgP.finish();
            }
        });
    }

    protected final void agt() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1001);
        }
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
    }
}
