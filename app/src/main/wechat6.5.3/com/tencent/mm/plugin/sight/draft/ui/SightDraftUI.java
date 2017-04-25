package com.tencent.mm.plugin.sight.draft.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.as.f;
import com.tencent.mm.as.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import java.util.LinkedList;

public class SightDraftUI extends MMActivity {
    private LinkedList<String> iWA = new LinkedList();
    private int iWy = 1;
    SightDraftContainerView iWz;

    static /* synthetic */ void b(SightDraftUI sightDraftUI) {
        b bVar = sightDraftUI.iWz.iWs;
        f fVar = bVar.iWh == null ? null : bVar.iWh.dgO;
        if (fVar != null) {
            String kV = g.kV(fVar.field_fileName);
            if (!sightDraftUI.iWA.contains(kV)) {
                sightDraftUI.iWA.add(kV);
                String str = e.cgg + String.format("%s%d.%s", new Object[]{"wx_camera_", Long.valueOf(System.currentTimeMillis()), "mp4"});
                v.i("MicroMsg.SightDraftUI", "save src %s dest %s ", kV, str);
                FileOp.p(kV, str);
                d.c(str, sightDraftUI);
                s.makeText(sightDraftUI, sightDraftUI.getString(2131235343, new Object[]{e.cgg}), 1).show();
            }
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131235344);
        cU().cV().setBackgroundDrawable(getResources().getDrawable(2131689547));
        this.iWz = new SightDraftContainerView(this);
        setContentView(this.iWz);
        this.iWz.aPG();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SightDraftUI iWB;

            {
                this.iWB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iWB.finish();
                return false;
            }
        });
        this.iWz.a(new a(this) {
            final /* synthetic */ SightDraftUI iWB;

            {
                this.iWB = r1;
            }

            public final void a(f fVar) {
                this.iWB.a(this.iWB.iWy, this.iWB.getString(2131235333), new OnMenuItemClickListener(this) {
                    final /* synthetic */ AnonymousClass2 iWC;

                    {
                        this.iWC = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        SightDraftUI.b(this.iWC.iWB);
                        return true;
                    }
                });
            }

            public final void a(b.d dVar) {
                this.iWB.vH(this.iWB.iWy);
            }
        });
    }
}
