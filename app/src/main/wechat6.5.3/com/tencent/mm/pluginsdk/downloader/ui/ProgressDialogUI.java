package com.tencent.mm.pluginsdk.downloader.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.mm.pluginsdk.downloader.b;
import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.pluginsdk.model.downloader.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class ProgressDialogUI extends MMBaseActivity {
    private h doc;
    private ah dwn;
    public ProgressBar elJ;
    private l lyF;
    public long lyv;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lyv = getIntent().getLongExtra("Intent_task_id", 0);
        a aVar = new a(this);
        aVar.Op(getString(2131234235));
        aVar.wp(2131234233).a(new OnClickListener(this) {
            final /* synthetic */ ProgressDialogUI lyG;

            {
                this.lyG = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.lyG.finish();
            }
        });
        aVar.wq(2131234234).b(new OnClickListener(this) {
            final /* synthetic */ ProgressDialogUI lyG;

            {
                this.lyG = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.pluginsdk.downloader.a aVar = b.bmF().lyu;
                d.bnK().dm(this.lyG.lyv);
                b.bmF().lyw = com.tencent.mm.pluginsdk.downloader.a.a.a.lyy;
                this.lyG.finish();
            }
        });
        aVar.c(new OnCancelListener(this) {
            final /* synthetic */ ProgressDialogUI lyG;

            {
                this.lyG = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.lyG.finish();
            }
        });
        try {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(2130904205, null);
            this.elJ = (ProgressBar) inflate.findViewById(2131758670);
            this.elJ.setMax(100);
            aVar.cC(inflate);
        } catch (Throwable e) {
            v.a("!44@/B4Tb64lLpJ4RAx5Vc4Ilfekj5Ps3ABrS1gn2P55iIs=", e, e.toString(), new Object[0]);
        }
        this.doc = aVar.RX();
        this.doc.show();
        this.lyF = new l(this) {
            final /* synthetic */ ProgressDialogUI lyG;

            {
                this.lyG = r1;
            }

            public final void onTaskStarted(long j, String str) {
                v.i("!44@/B4Tb64lLpJ4RAx5Vc4Ilfekj5Ps3ABrS1gn2P55iIs=", "onTaskStarted");
            }

            public final void g(long j, String str) {
                v.i("!44@/B4Tb64lLpJ4RAx5Vc4Ilfekj5Ps3ABrS1gn2P55iIs=", "onTaskFinished" + j);
                if (j == this.lyG.lyv) {
                    if (this.lyG.elJ != null) {
                        this.lyG.elJ.setProgress(100);
                    }
                    this.lyG.finish();
                }
            }

            public final void q(long j, int i) {
                v.i("!44@/B4Tb64lLpJ4RAx5Vc4Ilfekj5Ps3ABrS1gn2P55iIs=", "onTaskFailed" + j);
                if (j == this.lyG.lyv) {
                    this.lyG.finish();
                }
            }

            public final void onTaskRemoved(long j) {
                v.i("!44@/B4Tb64lLpJ4RAx5Vc4Ilfekj5Ps3ABrS1gn2P55iIs=", "onTaskRemoved" + j);
                if (j == this.lyG.lyv) {
                    this.lyG.finish();
                }
            }

            public final void onTaskPaused(long j) {
                v.i("!44@/B4Tb64lLpJ4RAx5Vc4Ilfekj5Ps3ABrS1gn2P55iIs=", "onTaskPaused" + j);
                if (j == this.lyG.lyv) {
                    this.lyG.finish();
                }
            }

            public final void bV(long j) {
            }

            public final void bW(long j) {
            }
        };
    }

    protected void onStart() {
        super.onStart();
        v.d("!44@/B4Tb64lLpJ4RAx5Vc4Ilfekj5Ps3ABrS1gn2P55iIs=", "onStart");
        com.tencent.mm.pluginsdk.downloader.a aVar = b.bmF().lyu;
        l lVar = this.lyF;
        if (lVar != null) {
            for (WeakReference weakReference : aVar.lyq) {
                if (((l) weakReference.get()) == lVar) {
                    break;
                }
            }
            aVar.lyq.add(new WeakReference(lVar));
        }
        if (this.dwn == null) {
            this.dwn = new ah(new ah.a(this) {
                final /* synthetic */ ProgressDialogUI lyG;

                {
                    this.lyG = r1;
                }

                public final boolean oU() {
                    if (this.lyG.elJ != null && this.lyG.elJ.getProgress() < 90) {
                        this.lyG.elJ.incrementProgressBy(5);
                    }
                    return true;
                }
            }, true);
        }
        this.dwn.ea(400);
    }

    protected void onStop() {
        super.onStop();
        this.doc.dismiss();
        v.d("!44@/B4Tb64lLpJ4RAx5Vc4Ilfekj5Ps3ABrS1gn2P55iIs=", "onStop");
        com.tencent.mm.pluginsdk.downloader.a aVar = b.bmF().lyu;
        l lVar = this.lyF;
        if (lVar != null) {
            Iterator it = aVar.lyq.iterator();
            while (it.hasNext()) {
                l lVar2 = (l) ((WeakReference) it.next()).get();
                if (lVar2 == null) {
                    it.remove();
                } else if (lVar2 == lVar) {
                    it.remove();
                }
            }
        }
        if (this.dwn != null) {
            this.dwn.QI();
        }
    }
}
