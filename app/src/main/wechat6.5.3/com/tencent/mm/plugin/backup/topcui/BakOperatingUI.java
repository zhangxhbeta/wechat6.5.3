package com.tencent.mm.plugin.backup.topcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.backup.a;
import com.tencent.mm.plugin.backup.bakpcmodel.c;
import com.tencent.mm.plugin.backup.bakpcmodel.c.d;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public class BakOperatingUI extends MMWizardActivity implements d {
    private int edl = -1;
    private boolean emH = false;
    private ProgressBar emI = null;
    private TextView emJ = null;
    private TextView emK = null;
    private TextView emL = null;
    private boolean emM = false;
    private int emN = 0;
    private boolean emO = false;
    private ac handler = new ac(Looper.getMainLooper());

    public void onCreate(Bundle bundle) {
        v.i("MicroMsg.BakOperatingUI", "onCreate");
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            v.i("MicroMsg.BakOperatingUI", "onCreate WizardRootKillSelf cmd:%d", new Object[]{Integer.valueOf(this.edl)});
            return;
        }
        b.UK().a(this);
        b.UK().bQ(true);
        this.emM = getIntent().getBooleanExtra("from_bak_banner", false);
        if (this.emM) {
            int i = b.UK().egk;
            if (com.tencent.mm.plugin.backup.bakpcmodel.d.egs == i || b.UK().egj == com.tencent.mm.plugin.backup.bakpcmodel.d.egB) {
                this.edl = 1;
                this.emN = b.UK().Uy();
            } else if (com.tencent.mm.plugin.backup.bakpcmodel.d.egu == i) {
                this.edl = 6;
                this.emN = b.UK().Uy();
            } else if (com.tencent.mm.plugin.backup.bakpcmodel.d.egv == i) {
                this.edl = 6;
                this.emH = true;
                a.drp.oz();
                b.UK().TW();
            }
        } else {
            this.edl = getIntent().getIntExtra("cmd", 6);
        }
        if (this.edl == 6 && b.UK().ege.egK) {
            this.emH = true;
            a.drp.oz();
            b.UK().TW();
        }
        v.i("MicroMsg.BakOperatingUI", "before initView onCreate BakOperatingUI  nowCmd:%d fromBanner:%b status:%d opePercent:%d", new Object[]{Integer.valueOf(this.edl), Boolean.valueOf(this.emM), Integer.valueOf(b.UK().egk), Integer.valueOf(this.emN)});
        NI();
        if (b.UK().egj == com.tencent.mm.plugin.backup.bakpcmodel.d.egB) {
            this.emK.setText(getString(2131231304));
            this.emJ.setText(getString(2131231283) + this.emN + "%");
            this.emL.setText(getString(2131231303));
        } else if (6 == this.edl) {
            if (this.emH) {
                this.emK.setText(getString(2131231302));
                this.emL.setText(getString(2131231301));
                this.emJ.setText(getString(2131231282) + this.emN + "%");
                return;
            }
            this.emK.setText(getString(2131231305));
            this.emJ.setText(getString(2131231284) + this.emN + "%");
            this.emL.setText(getString(2131231303));
        } else if (1 == this.edl) {
            this.emK.setText(getString(2131231298));
            this.emJ.setText(getString(2131231277) + this.emN + "%");
            this.emL.setText(getString(2131231303));
        }
    }

    protected final void NI() {
        vD(2131231310);
        if (!this.emH) {
            if (6 == this.edl) {
                a(0, getString(2131231286), new OnMenuItemClickListener(this) {
                    final /* synthetic */ BakOperatingUI emP;

                    {
                        this.emP = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (!this.emP.emH) {
                            this.emP.emO = true;
                            this.emP.bAv();
                        }
                        return true;
                    }
                });
            } else if (1 == this.edl) {
                a(0, getString(2131231258), new OnMenuItemClickListener(this) {
                    final /* synthetic */ BakOperatingUI emP;

                    {
                        this.emP = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (!this.emP.emH) {
                            this.emP.emO = true;
                            this.emP.bAv();
                        }
                        return true;
                    }
                });
            } else {
                v.e("MicroMsg.BakOperatingUI", "BakOperatingUI operate type is invalid");
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakOperatingUI emP;

            {
                this.emP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.emP.emH) {
                    this.emP.WD();
                    return false;
                }
                this.emP.emO = true;
                this.emP.bAv();
                return true;
            }
        });
        this.emI = (ProgressBar) findViewById(2131755540);
        this.emI.setProgress(this.emN);
        this.emK = (TextView) findViewById(2131755542);
        this.emL = (TextView) findViewById(2131755543);
        this.emJ = (TextView) findViewById(2131755541);
    }

    protected final int getLayoutId() {
        return 2130903158;
    }

    private void WD() {
        b.UK().pause();
        h a = g.a(this, 2131231287, 0, 2131231183, 2131231104, new OnClickListener(this) {
            final /* synthetic */ BakOperatingUI emP;

            {
                this.emP = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                c UK = b.UK();
                UK.egd.cancel();
                UK.ege.cancel();
                if (UK.egh == 1 || UK.egk == com.tencent.mm.plugin.backup.bakpcmodel.d.egs) {
                    c.hX(4);
                } else if (UK.egh == 6 || UK.egk == com.tencent.mm.plugin.backup.bakpcmodel.d.egu || UK.egk == com.tencent.mm.plugin.backup.bakpcmodel.d.egw) {
                    c.hX(7);
                }
                b.UK().egj = com.tencent.mm.plugin.backup.bakpcmodel.d.egy;
                com.tencent.mm.plugin.backup.bakpcmodel.a UO = b.UO();
                UO.efP++;
                this.emP.emO = true;
                this.emP.bAv();
            }
        }, new OnClickListener(this) {
            final /* synthetic */ BakOperatingUI emP;

            {
                this.emP = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                c UK = b.UK();
                if (UK.egh == 1) {
                    UK.egd.resume();
                } else if (UK.egh == 6) {
                    UK.ege.resume();
                } else {
                    v.e("MicroMsg.BakPcProcessMgr", "cancel in error state, %d", new Object[]{Integer.valueOf(UK.egh)});
                }
            }
        });
        a.setCanceledOnTouchOutside(false);
        a.setCancelable(false);
    }

    public void onDestroy() {
        super.onDestroy();
        b.UK().a(null);
        b.UK().bQ(false);
        v.i("MicroMsg.BakOperatingUI", "BakOperatingUI onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.edl)});
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        b.UK().bQ(true);
        b.UK().a(this);
        v.i("MicroMsg.BakOperatingUI", "onResume nowCmd:%d", new Object[]{Integer.valueOf(this.edl)});
        super.onResume();
    }

    protected void onPause() {
        b.UK().bQ(false);
        super.onPause();
        v.i("MicroMsg.BakOperatingUI", "onPause nowCmd:%d", new Object[]{Integer.valueOf(this.edl)});
    }

    public final synchronized void ic(final int i) {
        v.d("MicroMsg.BakOperatingUI", "BakOperatingUI onNetProgress percent:%d, isFinishingWizard:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.emO)});
        if (!this.emO) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BakOperatingUI emP;

                public final void run() {
                    if (this.emP.emI != null) {
                        this.emP.emI.setProgress(i);
                    }
                    if (this.emP.emJ != null) {
                        int i = 2131231277;
                        int i2 = 2131231298;
                        if (6 == this.emP.edl) {
                            i = 2131231284;
                            i2 = 2131231305;
                        }
                        this.emP.emJ.setText(this.emP.getString(i) + i + "%");
                        this.emP.emK.setText(this.emP.getString(i2));
                    }
                }
            });
        }
    }

    public final synchronized void id(final int i) {
        if (!this.emO) {
            v.d("MicroMsg.BakOperatingUI", "BakOperatingUI onMergeProgress percent:%d", new Object[]{Integer.valueOf(i)});
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BakOperatingUI emP;

                public final void run() {
                    if (this.emP.emI != null) {
                        this.emP.emI.setProgress(i);
                    }
                    if (this.emP.emJ != null && this.emP.emK != null) {
                        this.emP.emJ.setText(this.emP.getString(2131231282) + i + "%");
                        this.emP.emK.setText(this.emP.getString(2131231302));
                    }
                }
            });
        }
    }

    public final synchronized void UB() {
        v.d("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", new Object[]{Integer.valueOf(this.edl)});
        if (!this.emO) {
            if (6 == this.edl || com.tencent.mm.plugin.backup.bakpcmodel.d.egv == b.UK().egk) {
                this.edl = 6;
                this.emH = true;
                a.drp.oz();
                b.UK().TW();
            } else {
                v.e("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", new Object[]{Integer.valueOf(this.edl)});
            }
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BakOperatingUI emP;

                {
                    this.emP = r1;
                }

                public final void run() {
                    if (6 == this.emP.edl) {
                        this.emP.handler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass11 emQ;

                            {
                                this.emQ = r1;
                            }

                            public final void run() {
                                this.emQ.emP.iU(false);
                                if (this.emQ.emP.emI != null) {
                                    this.emQ.emP.emI.setProgress(0);
                                }
                                if (this.emQ.emP.emK != null) {
                                    this.emQ.emP.emK.setText(this.emQ.emP.getString(2131231302));
                                }
                                if (this.emQ.emP.emL != null) {
                                    this.emQ.emP.emL.setText(this.emQ.emP.getString(2131231301));
                                }
                                if (this.emQ.emP.emJ != null) {
                                    this.emQ.emP.emJ.setText(this.emQ.emP.getString(2131231282) + "0%");
                                }
                            }
                        });
                    } else if (1 == this.emP.edl) {
                        Intent intent = new Intent(this.emP, BakFinishUI.class);
                        intent.putExtra("cmd", this.emP.edl);
                        MMWizardActivity.w(this.emP, intent);
                    }
                }
            });
        }
    }

    public final synchronized void UC() {
        if (!this.emO) {
            this.emH = false;
            v.d("MicroMsg.BakOperatingUI", "onMergeFinish now cmd:%d", new Object[]{Integer.valueOf(this.edl)});
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BakOperatingUI emP;

                {
                    this.emP = r1;
                }

                public final void run() {
                    Intent intent = new Intent(this.emP, BakFinishUI.class);
                    intent.putExtra("cmd", this.emP.edl);
                    MMWizardActivity.w(this.emP, intent);
                }
            });
        }
    }

    public synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        synchronized (this) {
            if (i != 4) {
                z = super.onKeyDown(i, keyEvent);
            } else if (this.emH) {
                WD();
                b.UK().pause();
            } else {
                v.d("MicroMsg.BakOperatingUI", "onKeyDown keyCode == KeyEvent.KEYCODE_BACK  finishWizard cmd:%d", new Object[]{Integer.valueOf(this.edl)});
                this.emO = true;
                b.UK().bQ(false);
                bAv();
            }
        }
        return z;
    }

    public final void onError(final int i) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakOperatingUI emP;

            public final void run() {
                v.i("MicroMsg.BakOperatingUI", "BakOperatingUI onCloseSocket, %d", new Object[]{Integer.valueOf(i)});
                if (i == 15) {
                    this.emP.bAv();
                    return;
                }
                MMWizardActivity.w(this.emP, new Intent(this.emP, BakConnErrorUI.class));
            }
        });
    }

    public final void UD() {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakOperatingUI emP;

            {
                this.emP = r1;
            }

            public final void run() {
                v.d("MicroMsg.BakOperatingUI", "BakOperatingUI onOperateCancel");
                this.emP.bAv();
            }
        });
    }

    public final void ib(final int i) {
        if (!this.emO) {
            v.d("MicroMsg.BakOperatingUI", "BakOperatingUI onPrepare percent:%d", new Object[]{Integer.valueOf(i)});
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BakOperatingUI emP;

                public final void run() {
                    if (this.emP.emI != null) {
                        this.emP.emI.setProgress(i);
                    }
                    if (this.emP.emJ != null && this.emP.emK != null) {
                        this.emP.emJ.setText(this.emP.getString(2131231283) + i + "%");
                        this.emP.emK.setText(this.emP.getString(2131231304));
                    }
                }
            });
        }
    }
}
