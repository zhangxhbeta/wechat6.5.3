package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;

public final class a extends b implements com.tencent.mm.plugin.backup.backuppcmodel.a.b {
    private static String TAG = "MicroMsg.BackupChatBanner";
    private View edj = null;

    public a(Context context) {
        super(context);
        com.tencent.mm.plugin.backup.g.b.UL();
        com.tencent.mm.plugin.backup.backuppcmodel.a.hO(-100);
        if (this.view != null) {
            this.edj = this.view.findViewById(2131755545);
            this.edj.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a edk;

                {
                    this.edk = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.plugin.backup.g.b.UL();
                    Object[] objArr;
                    switch (com.tencent.mm.plugin.backup.backuppcmodel.a.TD()) {
                        case -1:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                        case 8:
                            objArr = new Object[1];
                            com.tencent.mm.plugin.backup.g.b.UL();
                            objArr[0] = Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.a.TD());
                            v.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState:%d", objArr);
                            this.edk.bO(false);
                            return;
                        case 9:
                        case 13:
                            objArr = new Object[1];
                            com.tencent.mm.plugin.backup.g.b.UL();
                            objArr[0] = Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.a.TD());
                            v.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState:%d", objArr);
                            this.edk.bO(true);
                            return;
                        default:
                            objArr = new Object[1];
                            com.tencent.mm.plugin.backup.g.b.UL();
                            objArr[0] = Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.a.TD());
                            v.i(a.TAG, "click backup banner,BackupPcState:%d", objArr);
                            return;
                    }
                }
            });
        }
        refresh();
        c UM = com.tencent.mm.plugin.backup.g.b.UM();
        UM.ecb = this;
        UM.handler = new ac(Looper.getMainLooper());
        com.tencent.mm.plugin.backup.backuppcmodel.b UN = com.tencent.mm.plugin.backup.g.b.UN();
        UN.ecb = this;
        UN.handler = new ac(Looper.getMainLooper());
        if (com.tencent.mm.plugin.backup.g.b.UN().TT()) {
            com.tencent.mm.plugin.backup.g.b.UL();
            com.tencent.mm.plugin.backup.backuppcmodel.a.hO(9);
        }
    }

    public final int getLayoutId() {
        return 2130903160;
    }

    private void bO(boolean z) {
        Intent intent = new Intent((Context) this.lKT.get(), BackupPcUI.class);
        com.tencent.mm.plugin.backup.g.b.UL();
        intent.putExtra("isRecoverTransferFinishFromBanner", z);
        MMWizardActivity.w((Context) this.lKT.get(), intent);
    }

    public final boolean Ui() {
        return refresh();
    }

    public final void Uj() {
        v.i(TAG, "refreshProgress");
    }

    public final boolean refresh() {
        com.tencent.mm.plugin.backup.g.b.UL();
        v.i(TAG, "refresh backupPcState:%d", Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.a.TD()));
        switch (com.tencent.mm.plugin.backup.backuppcmodel.a.TD()) {
            case -1:
                this.edj.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.g.b.UL().eaT || 3 == com.tencent.mm.plugin.backup.g.b.UL().eaT) {
                    ((ImageView) this.view.findViewById(2131755546)).setImageResource(2131165291);
                    ((TextView) this.view.findViewById(2131755547)).setText(aa.getContext().getString(2131231214));
                } else if (2 == com.tencent.mm.plugin.backup.g.b.UL().eaT || 4 == com.tencent.mm.plugin.backup.g.b.UL().eaT) {
                    ((ImageView) this.view.findViewById(2131755546)).setImageResource(2131165295);
                    ((TextView) this.view.findViewById(2131755547)).setText(aa.getContext().getString(2131231215));
                }
                return true;
            case 3:
            case 7:
                this.edj.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.g.b.UL().eaT || 3 == com.tencent.mm.plugin.backup.g.b.UL().eaT) {
                    ((ImageView) this.view.findViewById(2131755546)).setImageResource(2131165291);
                } else if (2 == com.tencent.mm.plugin.backup.g.b.UL().eaT || 4 == com.tencent.mm.plugin.backup.g.b.UL().eaT) {
                    ((ImageView) this.view.findViewById(2131755546)).setImageResource(2131165295);
                }
                ((TextView) this.view.findViewById(2131755547)).setText(aa.getContext().getString(2131231232));
                return true;
            case 4:
                this.edj.setVisibility(0);
                ((ImageView) this.view.findViewById(2131755546)).setImageResource(2131165291);
                ((TextView) this.view.findViewById(2131755547)).setText(aa.getContext().getString(2131231253, new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.g.b.UL().ebf), Integer.valueOf(com.tencent.mm.plugin.backup.g.b.UL().ebg), com.tencent.mm.plugin.backup.g.b.UL().TG()}));
                return true;
            case 5:
                this.edj.setVisibility(0);
                ((ImageView) this.view.findViewById(2131755546)).setImageResource(2131165291);
                ((TextView) this.view.findViewById(2131755547)).setText(aa.getContext().getString(2131231206));
                return true;
            case 8:
                this.edj.setVisibility(0);
                ((ImageView) this.view.findViewById(2131755546)).setImageResource(2131165295);
                ((TextView) this.view.findViewById(2131755547)).setText(aa.getContext().getString(2131231242, new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.g.b.UL().ebf), Integer.valueOf(com.tencent.mm.plugin.backup.g.b.UL().ebg), com.tencent.mm.plugin.backup.g.b.UL().TG()}));
                return true;
            case 9:
                bO(true);
                return true;
            case 10:
            case 11:
                this.edj.setVisibility(8);
                if (be.bm((Context) this.lKT.get())) {
                    bO(true);
                }
                return true;
            case 13:
                this.edj.setVisibility(0);
                ((ImageView) this.view.findViewById(2131755546)).setImageResource(2131165295);
                ((TextView) this.view.findViewById(2131755547)).setText(aa.getContext().getString(2131231244));
                return true;
            default:
                this.edj.setVisibility(8);
                return false;
        }
    }

    public final void Uk() {
    }

    public final void destroy() {
    }

    public final void TQ() {
        refresh();
    }
}
