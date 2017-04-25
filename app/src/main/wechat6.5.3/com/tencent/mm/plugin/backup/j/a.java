package com.tencent.mm.plugin.backup.j;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.backup.bakpcmodel.c;
import com.tencent.mm.plugin.backup.bakpcmodel.c.d;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.backup.g.m;
import com.tencent.mm.plugin.backup.g.x;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public final class a extends b implements d, m {
    private static String TAG = "MicroMsg.BakChatBanner";
    private static boolean emY = false;
    private View edj;
    private int egj;
    private int emZ;
    private ac handler;

    public final int getLayoutId() {
        return 2130903160;
    }

    boolean bU(boolean z) {
        this.egj = com.tencent.mm.plugin.backup.g.b.UK().egj;
        v.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setCallBack:%b", Integer.valueOf(this.egj), Boolean.valueOf(z));
        if (this.egj < com.tencent.mm.plugin.backup.bakpcmodel.d.egB || this.egj > com.tencent.mm.plugin.backup.bakpcmodel.d.egF) {
            this.edj.setVisibility(8);
            return false;
        }
        this.edj.setVisibility(0);
        if (z && !com.tencent.mm.plugin.backup.g.b.UK().Uv()) {
            com.tencent.mm.plugin.backup.g.b.UK().a((d) this);
        }
        if (com.tencent.mm.plugin.backup.bakpcmodel.d.egB == this.egj) {
            ((ImageView) this.view.findViewById(2131755546)).setImageResource(2131165383);
            ((TextView) this.view.findViewById(2131755547)).setText(aa.getContext().getString(2131231260, new Object[]{Integer.valueOf(this.emZ)}));
        } else if (com.tencent.mm.plugin.backup.bakpcmodel.d.egC == this.egj) {
            ((ImageView) this.view.findViewById(2131755546)).setImageResource(2131165383);
            ((TextView) this.view.findViewById(2131755547)).setText(aa.getContext().getString(2131231265, new Object[]{Integer.valueOf(this.emZ)}));
        } else if (com.tencent.mm.plugin.backup.bakpcmodel.d.egD == this.egj) {
            ((TextView) this.view.findViewById(2131755547)).setText(aa.getContext().getString(2131231264));
            ((ImageView) this.view.findViewById(2131755546)).setImageResource(2131165382);
        } else if (com.tencent.mm.plugin.backup.bakpcmodel.d.egE == this.egj) {
            ((ImageView) this.view.findViewById(2131755546)).setImageResource(2131165383);
            ((TextView) this.view.findViewById(2131755547)).setText(aa.getContext().getString(2131231259, new Object[]{Integer.valueOf(this.emZ)}));
        } else if (com.tencent.mm.plugin.backup.bakpcmodel.d.egF == this.egj) {
            ((TextView) this.view.findViewById(2131755547)).setText(aa.getContext().getString(2131231261));
            ((ImageView) this.view.findViewById(2131755546)).setImageResource(2131165382);
        }
        return true;
    }

    public final boolean Ui() {
        this.emZ = com.tencent.mm.plugin.backup.g.b.UK().Uy();
        v.d(TAG, "refreshForBakpc PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.g.b.UK().egj), Integer.valueOf(this.emZ));
        return bU(false);
    }

    public final void Uj() {
        v.i(TAG, "refreshProgress");
        this.emZ = com.tencent.mm.plugin.backup.g.b.UK().Uy();
        com.tencent.mm.plugin.backup.g.b.UK().a((d) this);
    }

    public final boolean refresh() {
        return bU(true);
    }

    public final void Uk() {
        e Ve = com.tencent.mm.plugin.backup.g.b.Ve();
        if (equals(Ve.ejf)) {
            Ve.ejf = null;
        }
        x Vf = com.tencent.mm.plugin.backup.g.b.Vf();
        if (equals(Vf.ejf)) {
            Vf.ejf = null;
        }
        this.egj = com.tencent.mm.plugin.backup.bakpcmodel.d.egy;
        com.tencent.mm.plugin.backup.g.b.UK().Uw();
    }

    public final void VW() {
        bU(true);
    }

    public final void VX() {
        bU(true);
    }

    public final void VY() {
        bU(true);
    }

    public final void VZ() {
        bU(true);
    }

    public final void onError(int i) {
    }

    public final void ic(int i) {
        v.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.g.b.UK().egj), Integer.valueOf(i));
        this.emZ = i;
        this.handler.post(new Runnable(this) {
            final /* synthetic */ a ena;

            {
                this.ena = r1;
            }

            public final void run() {
                this.ena.bU(true);
            }
        });
    }

    public final void id(int i) {
        v.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.g.b.UK().egj), Integer.valueOf(i));
    }

    public final void UB() {
        v.d(TAG, "onNetFinish PCBannerStatus:%d", Integer.valueOf(com.tencent.mm.plugin.backup.g.b.UK().egj));
        com.tencent.mm.plugin.backup.g.b.UK();
        c.hX(17);
        this.handler.post(new Runnable(this) {
            final /* synthetic */ a ena;

            {
                this.ena = r1;
            }

            public final void run() {
                this.ena.bU(true);
            }
        });
    }

    public final void UC() {
    }

    public final void UD() {
    }

    public final void destroy() {
    }

    public final void ib(int i) {
        v.d(TAG, "onPrepare PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.g.b.UK().egj), Integer.valueOf(i));
        this.emZ = i;
        this.handler.post(new Runnable(this) {
            final /* synthetic */ a ena;

            {
                this.ena = r1;
            }

            public final void run() {
                this.ena.bU(true);
            }
        });
    }
}
