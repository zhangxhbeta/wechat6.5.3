package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.backup.backuppcmodel.a.c;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mmdb.database.SQLiteDatabase;

@a(3)
public class BackupPcUI extends MMWizardActivity implements c {
    private static boolean edL = false;
    private TextView edF;
    private TextView edG;
    private TextView edH;
    private TextView edI;
    private TextView edJ;
    private ImageView edK;
    private boolean edM = false;

    static /* synthetic */ void h(BackupPcUI backupPcUI) {
        Intent intent = new Intent();
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, backupPcUI.getString(2131231230));
        intent.putExtra("rawUrl", backupPcUI.getString(2131236706, new Object[]{u.bsY()}));
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        com.tencent.mm.ay.c.b((Context) backupPcUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            v.i("MicroMsg.BackupPcUI", "onCreate.");
            cU().cV().hide();
            com.tencent.mm.plugin.backup.a.drp.oz();
            NI();
        }
    }

    public void onResume() {
        super.onResume();
        b.UM().a((c) this);
        b.US().a((c) this);
        b.UN().a(this);
        Intent intent = getIntent();
        b.UL();
        boolean booleanExtra = intent.getBooleanExtra("isRecoverTransferFinishFromBanner", false);
        edL = booleanExtra;
        if (booleanExtra) {
            g.iuh.h(13735, Integer.valueOf(190));
        }
        TS();
    }

    public final void TS() {
        while (true) {
            b.UL();
            v.i("MicroMsg.BackupPcUI", "onResume backupPcState:%d", Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.a.TD()));
            switch (com.tencent.mm.plugin.backup.backuppcmodel.a.TD()) {
                case -100:
                    bAv();
                    return;
                case -13:
                    Ul();
                    this.edH.setText(2131231218);
                    b.UP().stop();
                    this.edI.setVisibility(4);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(4);
                    Um();
                    return;
                case -12:
                    Ul();
                    this.edH.setText(2131231219);
                    b.UP().stop();
                    this.edI.setVisibility(4);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(4);
                    Um();
                    return;
                case -10:
                    Ul();
                    this.edH.setText(2131231223);
                    b.UP().stop();
                    this.edI.setVisibility(4);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(4);
                    Um();
                    return;
                case -9:
                    Ul();
                    this.edH.setText(2131231222);
                    PLong pLong = new PLong();
                    PLong pLong2 = new PLong();
                    com.tencent.mm.plugin.backup.backuppcmodel.a UL = b.UL();
                    pLong.value = UL.ebh;
                    pLong2.value = UL.ebi;
                    this.edI.setText(getString(2131231221, new Object[]{be.aw(pLong.value), be.aw(pLong2.value)}));
                    this.edI.setTextColor(getResources().getColor(2131689543));
                    this.edI.setVisibility(0);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(4);
                    Um();
                    return;
                case -8:
                    Ul();
                    this.edH.setText(2131231217);
                    this.edI.setVisibility(4);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(4);
                    Um();
                    return;
                case -7:
                    Ul();
                    this.edH.setText(2131231226);
                    this.edI.setVisibility(4);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(4);
                    Um();
                    return;
                case -5:
                    Ul();
                    this.edH.setText(2131231216);
                    this.edG.setText(2131231228);
                    this.edI.setVisibility(4);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(0);
                    this.edG.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupPcUI edN;

                        {
                            this.edN = r1;
                        }

                        public final void onClick(View view) {
                            BackupPcUI.h(this.edN);
                        }
                    });
                    Um();
                    return;
                case -4:
                case -3:
                    Ul();
                    this.edH.setText(2131231224);
                    String bw = com.tencent.mm.plugin.backup.g.g.bw(this);
                    if (bw == null || bw.equals(SQLiteDatabase.KeyEmpty)) {
                        this.edI.setText(getString(2131231225, new Object[]{b.UL().eaW, "移动网络"}));
                    } else {
                        this.edI.setText(getString(2131231225, new Object[]{b.UL().eaW, bw}));
                    }
                    this.edI.setTextColor(getResources().getColor(2131689543));
                    this.edG.setText(2131231228);
                    this.edI.setVisibility(0);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(0);
                    this.edG.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupPcUI edN;

                        {
                            this.edN = r1;
                        }

                        public final void onClick(View view) {
                            g.iuh.h(13735, Integer.valueOf(191));
                            BackupPcUI.h(this.edN);
                        }
                    });
                    Um();
                    return;
                case -1:
                    if (1 == b.UL().eaT || 3 == b.UL().eaT) {
                        this.edK.setImageResource(2131165292);
                        this.edH.setText(getString(2131231253, new Object[]{Integer.valueOf(b.UL().ebf), Integer.valueOf(b.UL().ebg), "0M"}));
                        this.edI.setText(2131231220);
                        this.edG.setText(2131231250);
                        this.edG.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ BackupPcUI edN;

                            {
                                this.edN = r1;
                            }

                            public final void onClick(View view) {
                                com.tencent.mm.ui.base.g.a(this.edN, 2131231211, 2131231210, 2131231250, 2131231202, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass2 edP;

                                    {
                                        this.edP = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        v.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                                        g.iuh.a(400, 10, 1, false);
                                        g.iuh.h(13735, Integer.valueOf(MMGIFException.D_GIF_ERR_NO_SCRN_DSCR));
                                        b.UP().stop();
                                        b.UM().bl(true);
                                        b.UL();
                                        com.tencent.mm.plugin.backup.backuppcmodel.a.hO(-100);
                                        this.edP.edN.bAv();
                                    }
                                }, null, 2131689543);
                            }
                        });
                    } else if (2 == b.UL().eaT || 4 == b.UL().eaT) {
                        this.edK.setImageResource(2131165296);
                        this.edH.setText(getString(2131231242, new Object[]{Integer.valueOf(b.UL().ebf), Integer.valueOf(b.UL().ebg), "0M"}));
                        this.edI.setText(2131231227);
                        this.edG.setText(2131231252);
                        this.edG.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ BackupPcUI edN;

                            {
                                this.edN = r1;
                            }

                            public final void onClick(View view) {
                                com.tencent.mm.ui.base.g.a(this.edN, 2131231213, 2131231212, 2131231251, 2131231202, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass3 edQ;

                                    {
                                        this.edQ = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        v.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                                        g.iuh.a(400, 18, 1, false);
                                        g.iuh.h(13735, Integer.valueOf(164));
                                        b.UP().stop();
                                        b.UN().bl(true);
                                        b.UL();
                                        com.tencent.mm.plugin.backup.backuppcmodel.a.hO(-100);
                                        this.edQ.edN.bAv();
                                    }
                                }, null, 2131689543);
                            }
                        });
                    }
                    this.edI.setTextColor(getResources().getColor(2131689543));
                    this.edI.setVisibility(0);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(0);
                    Up();
                    return;
                case 1:
                    this.edK.setImageResource(2131165294);
                    this.edH.setText(2131231208);
                    this.edI.setVisibility(4);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(4);
                    Um();
                    return;
                case 2:
                    this.edK.setImageResource(2131165294);
                    this.edH.setText(2131231249);
                    this.edI.setText(2131231248);
                    this.edI.setTextColor(getResources().getColor(2131689544));
                    this.edF.setText(2131231246);
                    this.edG.setText(2131231247);
                    this.edI.setVisibility(0);
                    this.edF.setVisibility(0);
                    this.edG.setVisibility(0);
                    Um();
                    this.edF.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupPcUI edN;

                        {
                            this.edN = r1;
                        }

                        public final void onClick(View view) {
                            ak.yW();
                            v.i("MicroMsg.BackupPcUI", "summerbak startbackup backup all, hasMove:%s", Boolean.valueOf(((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()));
                            if (((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                                com.tencent.mm.ui.base.g.a(this.edN, 2131231229, 0, 2131231255, 0, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 edO;

                                    {
                                        this.edO = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        b.UL();
                                        com.tencent.mm.plugin.backup.backuppcmodel.a.hP(2);
                                        b.UL();
                                        com.tencent.mm.plugin.backup.backuppcmodel.a.hO(3);
                                        this.edO.edN.TS();
                                        b.US();
                                        com.tencent.mm.plugin.backup.backupmodel.c.Tv();
                                        b.US().bK(true);
                                        g.iuh.a(400, 7, 1, false);
                                        g.iuh.h(13735, Integer.valueOf(MMGIFException.D_GIF_ERR_OPEN_FAILED));
                                    }
                                }, null, 2131689542);
                                return;
                            }
                            b.UL();
                            com.tencent.mm.plugin.backup.backuppcmodel.a.hP(2);
                            b.UL();
                            com.tencent.mm.plugin.backup.backuppcmodel.a.hO(3);
                            this.edN.TS();
                            b.US().cancel();
                            b.US();
                            com.tencent.mm.plugin.backup.backupmodel.c.Tv();
                            b.US().bK(true);
                            g.iuh.a(400, 7, 1, false);
                            g.iuh.h(13735, Integer.valueOf(MMGIFException.D_GIF_ERR_OPEN_FAILED));
                        }
                    });
                    this.edG.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupPcUI edN;

                        {
                            this.edN = r1;
                        }

                        public final void onClick(View view) {
                            g.iuh.h(13735, Integer.valueOf(MMGIFException.D_GIF_ERR_READ_FAILED));
                            MMWizardActivity.w(this.edN, new Intent(this.edN, BackupPcChooseUI.class));
                            b.US().cancel();
                            b.US();
                            com.tencent.mm.plugin.backup.backupmodel.c.Tv();
                            b.US().bK(false);
                        }
                    });
                    return;
                case 3:
                    this.edK.setImageResource(2131165294);
                    this.edH.setText(2131231232);
                    this.edI.setText(2131231233);
                    this.edI.setTextColor(getResources().getColor(2131689544));
                    this.edI.setVisibility(0);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(4);
                    Up();
                    return;
                case 4:
                    this.edK.setImageResource(2131165294);
                    this.edH.setText(getString(2131231253, new Object[]{Integer.valueOf(b.UL().ebf), Integer.valueOf(b.UL().ebg), b.UL().TG()}));
                    this.edI.setText(2131231233);
                    this.edI.setTextColor(getResources().getColor(2131689544));
                    this.edI.setVisibility(0);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(4);
                    Up();
                    return;
                case 5:
                    this.edK.setImageResource(2131165293);
                    this.edH.setText(2131231206);
                    this.edI.setText(getString(2131231207, new Object[]{Integer.valueOf(b.UL().ebf), Integer.valueOf(b.UL().ebg)}));
                    this.edI.setTextColor(getResources().getColor(2131689544));
                    this.edF.setText(2131231204);
                    this.edI.setVisibility(0);
                    this.edF.setVisibility(0);
                    this.edG.setVisibility(4);
                    this.edF.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupPcUI edN;

                        {
                            this.edN = r1;
                        }

                        public final void onClick(View view) {
                            g.iuh.h(13735, Integer.valueOf(121));
                            b.UP().stop();
                            b.UM().bl(true);
                            b.UL();
                            com.tencent.mm.plugin.backup.backuppcmodel.a.hO(-100);
                            this.edN.bAv();
                        }
                    });
                    Um();
                    return;
                case 6:
                    this.edK.setImageResource(2131165298);
                    this.edH.setText(2131231240);
                    this.edF.setText(2131231239);
                    this.edI.setVisibility(4);
                    this.edF.setVisibility(0);
                    this.edG.setVisibility(4);
                    this.edF.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupPcUI edN;

                        {
                            this.edN = r1;
                        }

                        public final void onClick(View view) {
                            g.iuh.h(13735, Integer.valueOf(161));
                            b.UL();
                            com.tencent.mm.plugin.backup.backuppcmodel.a.hP(4);
                            b.UL();
                            com.tencent.mm.plugin.backup.backuppcmodel.a.hO(7);
                            this.edN.TS();
                            g.iuh.a(400, 16, 1, false);
                        }
                    });
                    Um();
                    return;
                case 7:
                    this.edK.setImageResource(2131165298);
                    this.edH.setText(2131231232);
                    this.edI.setText(2131231233);
                    this.edI.setTextColor(getResources().getColor(2131689544));
                    this.edI.setVisibility(0);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(4);
                    Up();
                    return;
                case 8:
                    this.edK.setImageResource(2131165298);
                    this.edH.setText(getString(2131231242, new Object[]{Integer.valueOf(b.UL().ebf), Integer.valueOf(b.UL().ebg), b.UL().TG()}));
                    this.edI.setText(2131231233);
                    this.edI.setTextColor(getResources().getColor(2131689544));
                    this.edI.setVisibility(0);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(4);
                    Up();
                    return;
                case 9:
                    if (edL) {
                        this.edK.setImageResource(2131165298);
                        this.edH.setText(2131231243);
                        this.edI.setText(2131231245);
                        this.edI.setTextColor(getResources().getColor(2131689544));
                        this.edF.setText(2131231238);
                        this.edG.setText(2131231241);
                        this.edJ.setText(2131231254);
                        this.edI.setVisibility(0);
                        this.edF.setVisibility(0);
                        this.edG.setVisibility(0);
                        this.edF.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ BackupPcUI edN;

                            {
                                this.edN = r1;
                            }

                            public final void onClick(View view) {
                                if (b.UN().TT() || b.UN().TU()) {
                                    g.iuh.h(13735, Integer.valueOf(163));
                                    b.UN().TW();
                                    return;
                                }
                                b.UL();
                                com.tencent.mm.plugin.backup.backuppcmodel.a.hO(-12);
                                this.edN.TS();
                                g.iuh.a(400, 64, 1, false);
                            }
                        });
                        this.edG.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ BackupPcUI edN;

                            {
                                this.edN = r1;
                            }

                            public final void onClick(View view) {
                                com.tencent.mm.ui.base.g.a(this.edN, 2131231213, 2131231212, 2131231251, 2131231202, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass13 edR;

                                    {
                                        this.edR = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        v.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                                        g.iuh.a(400, 26, 1, false);
                                        g.iuh.h(13735, Integer.valueOf(167));
                                        b.UP().stop();
                                        b.UN().bl(true);
                                        b.UL();
                                        com.tencent.mm.plugin.backup.backuppcmodel.a.hO(-100);
                                        this.edR.edN.bAv();
                                    }
                                }, null, 2131689543);
                            }
                        });
                        this.edJ.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ BackupPcUI edN;

                            {
                                this.edN = r1;
                            }

                            public final void onClick(View view) {
                                g.iuh.h(13735, Integer.valueOf(165));
                                b.UL();
                                com.tencent.mm.plugin.backup.backuppcmodel.a.hO(13);
                                this.edN.bAv();
                            }
                        });
                        return;
                    } else if (!be.bm((Context) this)) {
                        return;
                    } else {
                        if (b.UN().TT() || b.UN().TU()) {
                            b.UN().TW();
                            return;
                        }
                        b.UL();
                        com.tencent.mm.plugin.backup.backuppcmodel.a.hO(-12);
                        TS();
                        g.iuh.a(400, 64, 1, false);
                        return;
                    }
                case 10:
                    this.edK.setImageResource(2131165298);
                    this.edH.setText(getString(2131231234, new Object[]{Integer.valueOf(b.UL().ebf), Integer.valueOf(b.UL().ebg)}));
                    this.edI.setText(2131231237);
                    this.edI.setTextColor(getResources().getColor(2131689544));
                    this.edJ.setText(2131231241);
                    this.edI.setVisibility(0);
                    this.edF.setVisibility(4);
                    this.edG.setVisibility(4);
                    this.edJ.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupPcUI edN;

                        {
                            this.edN = r1;
                        }

                        public final void onClick(View view) {
                            com.tencent.mm.ui.base.g.a(this.edN, 2131231213, 2131231212, 2131231251, 2131231202, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass15 edS;

                                {
                                    this.edS = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    v.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                                    g.iuh.a(400, 26, 1, false);
                                    g.iuh.h(13735, Integer.valueOf(167));
                                    b.UP().stop();
                                    b.UN().bl(true);
                                    b.UL();
                                    com.tencent.mm.plugin.backup.backuppcmodel.a.hO(-100);
                                    this.edS.edN.bAv();
                                }
                            }, null, 2131689543);
                        }
                    });
                    return;
                case 11:
                    this.edK.setImageResource(2131165297);
                    this.edH.setText(2131231235);
                    this.edI.setText(getString(2131231236, new Object[]{Integer.valueOf(b.UL().ebf), Integer.valueOf(b.UL().ebg)}));
                    this.edI.setTextColor(getResources().getColor(2131689544));
                    this.edF.setText(2131231204);
                    this.edI.setVisibility(0);
                    this.edF.setVisibility(0);
                    this.edG.setVisibility(4);
                    this.edF.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupPcUI edN;

                        {
                            this.edN = r1;
                        }

                        public final void onClick(View view) {
                            g.iuh.h(13735, Integer.valueOf(162));
                            b.UN().bl(true);
                            b.UP().stop();
                            b.UL();
                            com.tencent.mm.plugin.backup.backuppcmodel.a.hO(-100);
                            this.edN.bAv();
                        }
                    });
                    Um();
                    return;
                case 13:
                    if (be.bm((Context) this)) {
                        b.UL();
                        com.tencent.mm.plugin.backup.backuppcmodel.a.hO(9);
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public final void NI() {
        this.edJ = (TextView) findViewById(2131755502);
        this.edK = (ImageView) findViewById(2131755503);
        this.edH = (TextView) findViewById(2131755504);
        this.edI = (TextView) findViewById(2131755505);
        this.edF = (TextView) findViewById(2131755507);
        this.edG = (TextView) findViewById(2131755506);
    }

    protected final int getLayoutId() {
        return 2130903146;
    }

    public void onDestroy() {
        v.i("MicroMsg.BackupPcUI", "onDestroy.");
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        Un();
        return true;
    }

    public final void TR() {
        v.i("MicroMsg.BackupPcUI", "summerbak onBackupPcStart.");
        switch (b.UL().eaT) {
            case 1:
                b.UM().a((c) this);
                b.US().a((c) this);
                b.UL();
                com.tencent.mm.plugin.backup.backuppcmodel.a.hO(2);
                TS();
                return;
            case 2:
                b.UN().a(this);
                b.UL();
                com.tencent.mm.plugin.backup.backuppcmodel.a.hO(6);
                TS();
                return;
            case 3:
                b.UM().a((c) this);
                b.US().a((c) this);
                b.UL();
                com.tencent.mm.plugin.backup.backuppcmodel.a.hO(3);
                TS();
                return;
            case 4:
                b.UN().a(this);
                b.UL();
                com.tencent.mm.plugin.backup.backuppcmodel.a.hO(7);
                TS();
                return;
            default:
                return;
        }
    }

    private void Ul() {
        if (1 == b.UL().eaT || 3 == b.UL().eaT) {
            this.edK.setImageResource(2131165292);
        } else if (2 == b.UL().eaT || 4 == b.UL().eaT) {
            this.edK.setImageResource(2131165296);
        }
    }

    public final void bM(boolean z) {
        this.edM = z;
        if (z) {
            this.edJ.setEnabled(false);
        } else {
            this.edJ.setEnabled(true);
        }
    }

    private void Um() {
        this.edJ.setText(2131231203);
        this.edJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackupPcUI edN;

            {
                this.edN = r1;
            }

            public final void onClick(View view) {
                this.edN.Un();
            }
        });
    }

    private void Un() {
        b.UL();
        v.i("MicroMsg.BackupPcUI", "close btn, backupPcState:%d, disableButton:%b", Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.a.TD()), Boolean.valueOf(this.edM));
        g.iuh.h(13735, Integer.valueOf(MMGIFException.D_GIF_ERR_NOT_GIF_FILE));
        if (!this.edM) {
            switch (r0) {
                case -12:
                case -10:
                case -9:
                case -8:
                case -7:
                case -5:
                case -4:
                case -3:
                case 1:
                case 2:
                case 6:
                    if (1 == b.UL().eaT || 3 == b.UL().eaT) {
                        b.UM().bl(false);
                    } else if (2 == b.UL().eaT || 4 == b.UL().eaT) {
                        b.UN().bl(false);
                    }
                    b.UL();
                    com.tencent.mm.plugin.backup.backuppcmodel.a.hO(-100);
                    break;
                case 5:
                    v.i("MicroMsg.BackupPcUI", "backup finish, user click close.");
                    Uo();
                    return;
                case 9:
                    b.UL();
                    com.tencent.mm.plugin.backup.backuppcmodel.a.hO(13);
                    break;
                case 10:
                    com.tencent.mm.ui.base.g.a((Context) this, 2131231213, 2131231212, 2131231251, 2131231202, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BackupPcUI edN;

                        {
                            this.edN = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            v.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                            g.iuh.a(400, 26, 1, false);
                            g.iuh.h(13735, Integer.valueOf(167));
                            b.UP().stop();
                            b.UN().bl(true);
                            b.UL();
                            com.tencent.mm.plugin.backup.backuppcmodel.a.hO(-100);
                            this.edN.bAv();
                        }
                    }, null, 2131689543);
                    return;
                case 11:
                    v.i("MicroMsg.BackupPcUI", "recover finish, user click close.");
                    Uo();
                    return;
            }
            bAv();
        }
    }

    private void Uo() {
        if (1 == b.UL().eaT || 3 == b.UL().eaT) {
            b.US().cancel();
            b.US();
            com.tencent.mm.plugin.backup.backupmodel.c.Tv();
            b.UM().bl(true);
            b.UP().stop();
        } else if (2 == b.UL().eaT || 4 == b.UL().eaT) {
            b.UN().bl(true);
            b.UP().stop();
        }
        b.UL();
        com.tencent.mm.plugin.backup.backuppcmodel.a.hO(-100);
        bAv();
    }

    private void Up() {
        this.edJ.setText(2131231205);
        this.edJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackupPcUI edN;

            {
                this.edN = r1;
            }

            public final void onClick(View view) {
                this.edN.bAv();
            }
        });
    }
}
