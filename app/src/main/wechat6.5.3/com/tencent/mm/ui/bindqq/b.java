package com.tencent.mm.ui.bindqq;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b implements e {
    Context context;
    h iji = null;
    private View ijj = null;
    SecurityImage nFq = null;
    p nIO = null;
    String nJH = SQLiteDatabase.KeyEmpty;
    private String nJJ = SQLiteDatabase.KeyEmpty;
    private String nJK;
    private byte[] nJL = null;
    private a ogH;

    public interface a {
        void bDr();

        boolean q(int i, int i2, String str);
    }

    class b extends com.tencent.mm.ui.applet.SecurityImage.b {
        final /* synthetic */ b ogJ;

        b(b bVar) {
            this.ogJ = bVar;
        }

        public final void bAL() {
            this.ogJ.ws();
            ak.vy().a(new ag(5, this.ogJ.nJH, this.ogJ.nFq.nJJ, this.ogJ.nFq.bBA(), this.ogJ.nFq.nJK, true, 1), 0);
        }
    }

    public b(Context context, a aVar) {
        this.context = context;
        this.ogH = aVar;
    }

    public final void ws() {
        ak.vy().a(384, (e) this);
    }

    public final void onDetach() {
        ak.vy().b(384, (e) this);
        if (this.ogH != null) {
            this.ogH.bDr();
        }
    }

    public final void bDs() {
        this.ijj = View.inflate(this.context, 2130904344, null);
        final EditText editText = (EditText) this.ijj.findViewById(2131759060);
        editText.setHint(2131231851);
        this.iji = g.a(this.context, this.context.getString(2131231852), this.ijj, new OnClickListener(this) {
            final /* synthetic */ b ogJ;

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.ogJ.iji = null;
                b bVar = this.ogJ;
                String trim = editText.getText().toString().trim();
                bVar.ws();
                bVar.nJH = trim;
                Context context = bVar.context;
                bVar.context.getString(2131231164);
                bVar.nIO = g.a(context, bVar.context.getString(2131234922), true, new OnCancelListener(bVar) {
                    final /* synthetic */ b ogJ;

                    {
                        this.ogJ = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.ogJ.onDetach();
                    }
                });
                ak.vy().a(new ag(5, bVar.nJH, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, false, 1), 0);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ b ogJ;

            {
                this.ogJ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.ogJ.iji = null;
                this.ogJ.onDetach();
            }
        });
    }

    @TargetApi(17)
    public final void a(int i, int i2, String str, k kVar) {
        onDetach();
        if (kVar != null && kVar.getType() == 384) {
            byte[] a;
            if (this.nIO != null) {
                this.nIO.dismiss();
                this.nIO = null;
            }
            this.nJJ = m.a(((bdi) ((ag) kVar).cif.czl.czs).mBN);
            ag agVar = (ag) kVar;
            if (((bdi) agVar.cif.czl.czs).mdX == null || ((bdi) agVar.cif.czl.czs).mdX.mQu <= 0) {
                a = m.a(((bdi) agVar.cif.czl.czs).mbY);
            } else {
                a = com.tencent.mm.kernel.g.vu().cjh.Q(agVar.cBd);
            }
            this.nJL = a;
            if (this.ogH == null || !this.ogH.q(i, i2, str)) {
                if (this.context instanceof Activity) {
                    Activity activity = (Activity) this.context;
                    if (!activity.isFinishing()) {
                        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
                            return;
                        }
                    }
                    return;
                }
                com.tencent.mm.f.a dm;
                if (i == 4) {
                    switch (i2) {
                        case -311:
                        case -310:
                        case -6:
                            if (!ak.uz()) {
                                return;
                            }
                            if (this.nFq == null) {
                                this.nFq = com.tencent.mm.ui.applet.SecurityImage.a.a(this.context, 0, this.nJL, this.nJJ, this.nJK, new OnClickListener(this) {
                                    final /* synthetic */ b ogJ;

                                    {
                                        this.ogJ = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        final k agVar = new ag(5, this.ogJ.nJH, this.ogJ.nFq.nJJ, this.ogJ.nFq.bBA(), this.ogJ.nFq.nJK, true, 1);
                                        this.ogJ.ws();
                                        ak.vy().a(agVar, 0);
                                        b bVar = this.ogJ;
                                        Context context = this.ogJ.context;
                                        this.ogJ.context.getString(2131231164);
                                        bVar.nIO = g.a(context, this.ogJ.context.getString(2131233565), true, new OnCancelListener(this) {
                                            final /* synthetic */ AnonymousClass5 ogK;

                                            public final void onCancel(DialogInterface dialogInterface) {
                                                this.ogK.ogJ.onDetach();
                                                ak.vy().c(agVar);
                                            }
                                        });
                                    }
                                }, null, new OnDismissListener(this) {
                                    final /* synthetic */ b ogJ;

                                    {
                                        this.ogJ = r1;
                                    }

                                    public final void onDismiss(DialogInterface dialogInterface) {
                                        this.ogJ.nFq = null;
                                    }
                                }, new b(this));
                                return;
                            } else {
                                this.nFq.a(0, this.nJL, this.nJJ, this.nJK);
                                return;
                            }
                        case -72:
                            this.iji = g.f(this.context, 2131231853, 2131231164);
                            return;
                        case -34:
                            this.iji = g.A(this.context, this.context.getString(2131231474), this.context.getString(2131231164));
                            return;
                        case -3:
                            this.iji = g.a(this.context, this.context.getString(2131231778), this.context.getString(2131231164), new OnClickListener(this) {
                                final /* synthetic */ b ogJ;

                                {
                                    this.ogJ = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.ogJ.iji = null;
                                    this.ogJ.onDetach();
                                    this.ogJ.bDs();
                                }
                            }, null);
                            return;
                        default:
                            dm = com.tencent.mm.f.a.dm(str);
                            if (dm != null) {
                                dm.a(this.context, null, null);
                                return;
                            }
                            return;
                    }
                }
                dm = com.tencent.mm.f.a.dm(str);
                if (dm != null) {
                    dm.a(this.context, null, null);
                }
            }
        }
    }
}
