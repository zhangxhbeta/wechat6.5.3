package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.eu;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.h.a.a;
import com.tencent.mm.ui.h.a.b;
import com.tencent.mm.ui.q;
import com.tencent.mm.v.e;

public class SnsUploadConfigView extends LinearLayout implements a, b, e {
    private static String aRm = "com.tencent.mm";
    private Context context;
    private ProgressDialog gNy = null;
    boolean jSz = false;
    ImageView jXT;
    ImageView jXU;
    ImageView jXV;
    private boolean jXW = false;
    boolean jXX = false;
    boolean jXY = false;
    private boolean jXZ = false;
    private boolean jYa = true;
    private boolean jYb = false;
    agp jYc = new agp();
    com.tencent.mm.ui.h.a jYd = new com.tencent.mm.ui.h.a();

    static /* synthetic */ void k(SnsUploadConfigView snsUploadConfigView) {
        v.e("MicroMsg.SnsUploadConfigView", "dealWithRefreshTokenFail");
        if (snsUploadConfigView.jXX) {
            String string = snsUploadConfigView.getContext().getString(2131231164);
            g.a(snsUploadConfigView.getContext(), snsUploadConfigView.getContext().getString(2131232616), string, new OnClickListener(snsUploadConfigView) {
                final /* synthetic */ SnsUploadConfigView jYe;

                {
                    this.jYe = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("is_force_unbind", true);
                    intent.putExtra("shake_music", true);
                    c.a(this.jYe.getContext(), ".ui.account.FacebookAuthUI", intent, 8);
                }
            }, null);
        }
        snsUploadConfigView.jXX = false;
        snsUploadConfigView.gx(false);
    }

    public SnsUploadConfigView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.context = context;
        View inflate = q.em(context).inflate(2130904516, this, true);
        this.jXT = (ImageView) inflate.findViewById(2131759506);
        this.jXU = (ImageView) inflate.findViewById(2131759507);
        this.jXV = (ImageView) inflate.findViewById(2131759505);
        if (!com.tencent.mm.af.b.Hb()) {
            this.jXV.setVisibility(8);
        }
        if (!com.tencent.mm.af.b.He()) {
            this.jXU.setVisibility(8);
        }
        if (!k.yf()) {
            this.jXT.setVisibility(8);
        }
        this.jXV.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ SnsUploadConfigView jYe;

            public final void onClick(View view) {
                if (this.jYe.jXZ || !this.jYe.jSz) {
                    this.jYe.jXZ = !this.jYe.jXZ;
                    this.jYe.aYc();
                    return;
                }
                g.f(context, 2131235535, 2131231164);
            }
        });
        this.jXT.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ SnsUploadConfigView jYe;

            {
                this.jYe = r1;
            }

            public final void onClick(View view) {
                this.jYe.jXX = !this.jYe.jXX;
                if (this.jYe.jXX) {
                    this.jYe.jSz = false;
                }
                this.jYe.gx(false);
            }
        });
        this.jXU.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ SnsUploadConfigView jYe;

            {
                this.jYe = r1;
            }

            public final void onClick(View view) {
                this.jYe.jXY = !this.jYe.jXY;
                if (this.jYe.jXY) {
                    this.jYe.jSz = false;
                }
                this.jYe.aYd();
            }
        });
    }

    public final void aYb() {
        this.jXW = false;
        this.jXX = false;
        this.jXY = false;
        this.jXZ = false;
        this.jXV.setImageResource(2131165953);
        this.jXT.setImageResource(2131165945);
        this.jXU.setImageResource(2131165955);
    }

    final void aYc() {
        if (this.jXZ) {
            boolean z;
            ak.yW();
            int f = be.f((Integer) com.tencent.mm.model.c.vf().get(9, null));
            if (f == 0) {
                g.a(getContext(), 2131235207, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ SnsUploadConfigView jYe;

                    {
                        this.jYe = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.sns.b.a.drp.h(new Intent(), this.jYe.context);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ SnsUploadConfigView jYe;

                    {
                        this.jYe = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (f != 0) {
                z = true;
                if (z) {
                    this.jXZ = false;
                    return;
                } else {
                    this.jXV.setImageResource(2131165954);
                    return;
                }
            }
            z = false;
            if (z) {
                this.jXV.setImageResource(2131165954);
                return;
            } else {
                this.jXZ = false;
                return;
            }
        }
        this.jXV.setImageResource(2131165953);
    }

    final void gx(boolean z) {
        if (this.jXX) {
            boolean z2;
            if (k.yh()) {
                z2 = true;
            } else {
                g.a(getContext(), 2131235011, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ SnsUploadConfigView jYe;

                    {
                        this.jYe = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        c.a(this.jYe.getContext(), ".ui.account.FacebookAuthUI", new Intent().putExtra("shake_music", true));
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ SnsUploadConfigView jYe;

                    {
                        this.jYe = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                z2 = false;
            }
            if (z2) {
                if (!(z || this.jYb || !k.yh())) {
                    final eu euVar = new eu();
                    euVar.bpT = new Runnable(this) {
                        final /* synthetic */ SnsUploadConfigView jYe;

                        public final void run() {
                            if (!euVar.bdA.aYN) {
                                SnsUploadConfigView.k(this.jYe);
                            }
                        }
                    };
                    com.tencent.mm.sdk.c.a.nhr.a(euVar, Looper.myLooper());
                }
                this.jXT.setImageResource(2131165946);
                return;
            }
            this.jXX = false;
            return;
        }
        this.jXT.setImageResource(2131165945);
    }

    final void aYd() {
        if (this.jXY) {
            boolean z;
            if (this.jYd.bJR()) {
                z = true;
            } else {
                g.a(getContext(), 2131235184, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ SnsUploadConfigView jYe;

                    {
                        this.jYe = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SnsUploadConfigView snsUploadConfigView = this.jYe;
                        Context context = this.jYe.getContext();
                        this.jYe.getContext().getString(2131231164);
                        snsUploadConfigView.gNy = g.a(context, this.jYe.getContext().getString(2131235701), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass13 jYg;

                            {
                                this.jYg = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        this.jYe.jYd.a(this.jYe, this.jYe.getContext());
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ SnsUploadConfigView jYe;

                    {
                        this.jYe = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                z = false;
            }
            if (z) {
                this.jXU.setImageResource(2131165956);
                return;
            } else {
                this.jXY = false;
                return;
            }
        }
        this.jXU.setImageResource(2131165955);
    }

    public final int aYe() {
        if (this.jSz) {
            return 1;
        }
        return 0;
    }

    public final void gy(boolean z) {
        this.jSz = z;
        if (z) {
            aYb();
        }
    }

    public final int aYf() {
        int i = 0;
        if (this.jXW) {
            i = 1;
        }
        if (this.jXX) {
            i |= 2;
        }
        if (this.jXY) {
            i |= 8;
        }
        if (this.jXZ) {
            return i | 4;
        }
        return i;
    }

    private void mj(int i) {
        g.a(getContext(), i, 2131231164, new OnClickListener(this) {
            final /* synthetic */ SnsUploadConfigView jYe;

            {
                this.jYe = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }, new OnClickListener(this) {
            final /* synthetic */ SnsUploadConfigView jYe;

            {
                this.jYe = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i != 0 || i2 != 0 || kVar == null) {
        }
    }

    public final void a(com.tencent.mm.ui.h.a.c cVar) {
        if (this.gNy != null) {
            this.gNy.cancel();
        }
        switch (cVar) {
            case Finished:
                this.jXY = true;
                mj(2131235703);
                break;
            case Canceled:
                this.jXY = false;
                break;
            case Failed:
                this.jXY = false;
                mj(2131235702);
                break;
        }
        aYd();
    }

    public final void b(com.tencent.mm.ui.h.a.c cVar) {
        switch (cVar) {
            case Failed:
                this.jXY = false;
                break;
        }
        aYd();
    }
}
