package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.mm.plugin.offline.a.b;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.n.f;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.plugin.wallet_core.ui.k.a;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class c {
    Vibrator ewK;
    a hLr;
    k hLs;
    float hLt = 0.0f;
    private int hLu = 20000;
    Activity pP;

    class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ f hLv;
        final /* synthetic */ c hLw;

        AnonymousClass10(c cVar, f fVar) {
            this.hLw = cVar;
            this.hLv = fVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            if (this.hLw.hLr != null) {
                this.hLw.hLr.p(0, this.hLv.id, "");
            }
            v.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
        }
    }

    class AnonymousClass11 implements com.tencent.mm.plugin.wallet_core.ui.k.c {
        final /* synthetic */ f hLv;
        final /* synthetic */ c hLw;

        AnonymousClass11(c cVar, f fVar) {
            this.hLw = cVar;
            this.hLv = fVar;
        }

        public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
            if (this.hLw.pP instanceof MMActivity) {
                ((MMActivity) this.hLw.pP).axg();
            }
            if (this.hLw.hLr != null) {
                this.hLw.hLr.p(1, this.hLv.id, str);
            }
            v.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
        }
    }

    class AnonymousClass13 implements a {
        final /* synthetic */ f hLv;
        final /* synthetic */ c hLw;

        AnonymousClass13(c cVar, f fVar) {
            this.hLw = cVar;
            this.hLv = fVar;
        }

        public final void aEX() {
            if (this.hLw.hLr != null) {
                this.hLw.hLr.p(0, this.hLv.id, "");
            }
            v.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
        }
    }

    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ f hLv;
        final /* synthetic */ c hLw;

        AnonymousClass1(c cVar, f fVar) {
            this.hLw = cVar;
            this.hLv = fVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            if (this.hLw.hLr != null) {
                this.hLw.hLr.p(1, this.hLv.id, "");
            }
            v.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
        }
    }

    static /* synthetic */ void a(c cVar) {
        v.i("MicroMsg.OfflineLogicMgr", "closeOffline");
        if (cVar.hLr != null) {
            cVar.hLr.aET();
        }
    }

    public c(Activity activity, a aVar) {
        this.pP = activity;
        this.hLr = aVar;
    }

    public final void q(int i, String str, String str2) {
        v.i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + i + " msg:" + str);
        aEV();
        if (i == 409) {
            v.i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:" + str);
            g.b(this.pP, str, "", getString(2131236540), getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ c hLw;

                {
                    this.hLw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    e.K(this.hLw.pP, 0);
                    v.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
                }
            }, new OnClickListener(this) {
                final /* synthetic */ c hLw;

                {
                    this.hLw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (i == 410) {
            v.i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:" + str);
            g.b(this.pP, str, "", getString(2131236326), getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ c hLw;

                {
                    this.hLw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    e.K(this.hLw.pP, 0);
                    v.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
                }
            }, new OnClickListener(this) {
                final /* synthetic */ c hLw;

                {
                    this.hLw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (i == 413) {
            v.i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:" + str);
            g.b(this.pP, str, "", getString(2131236522), getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ c hLw;

                {
                    this.hLw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.hLw.hLr.aES();
                    v.i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
                }
            }, new OnClickListener(this) {
                final /* synthetic */ c hLw;

                {
                    this.hLw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (i == 411) {
            com.tencent.mm.plugin.offline.b.a.b(this.pP, str);
            com.tencent.mm.plugin.report.service.g.iuh.a(135, 1, 1, true);
        } else if (!(this.pP instanceof WalletBaseUI)) {
            b.a(this.pP, str);
        } else if (!com.tencent.mm.wallet_core.c.e.a((WalletBaseUI) this.pP, 1000, i, str)) {
            String string;
            Context context = this.pP;
            if (TextUtils.isEmpty(str)) {
                string = context.getString(2131236492);
            } else {
                string = str;
            }
            if (be.kS(str2)) {
                b.a(context, string);
                return;
            }
            v.i("MicroMsg.OfflineErrorHelper", "error_detail_url is not null ");
            g.a(context, string, null, context.getResources().getString(2131236171), context.getResources().getString(2131231107), true, new com.tencent.mm.plugin.offline.ui.b.AnonymousClass2(str2, context), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.OfflineLogicMgr", "errType:" + i + "  errCode" + i2 + " errMsg:" + str + " cgi type:" + kVar.getType());
        if (i == 0 && i2 == 0) {
            if (!(kVar instanceof b)) {
                return false;
            }
            b bVar = (b) kVar;
            Object obj = bVar.hKp;
            aEV();
            if (bVar.hKs != 0 || TextUtils.isEmpty(obj)) {
                if (!(bVar.hKs == 0 || bVar.hKq == 0 || bVar.hKu != 1)) {
                    v.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                    q(bVar.hKs, bVar.hKt, null);
                }
                return true;
            }
            com.tencent.mm.plugin.offline.b.a.a(this.pP, obj, kVar);
            return true;
        } else if (!(kVar instanceof b)) {
            return false;
        } else {
            b bVar2 = (b) kVar;
            aEV();
            if (bVar2.hKu == 1) {
                v.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                q(i2, str, null);
            }
            return true;
        }
    }

    public final void aEV() {
        if (this.hLs != null) {
            this.hLs.dismiss();
            this.hLs = null;
        }
    }

    public final void a(n.b bVar) {
        if (bVar != null) {
            v.i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
            if ("1".equals(bVar.hKY)) {
                g.a(this.pP, false, bVar.hLa, "", getString(2131236532), getString(2131231010), new OnClickListener(this) {
                    final /* synthetic */ c hLw;

                    {
                        this.hLw = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        com.tencent.mm.plugin.offline.b.a.F(this.hLw.pP);
                        v.i("MicroMsg.OfflineLogicMgr", "doFreezeOffline");
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ c hLw;

                    {
                        this.hLw = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.hLw.pP.finish();
                    }
                });
            }
        }
    }

    public static boolean aEW() {
        j.aEM();
        if (j.aEN().hKX != null) {
            return true;
        }
        return false;
    }

    final String getString(int i) {
        return this.pP.getString(i);
    }
}
