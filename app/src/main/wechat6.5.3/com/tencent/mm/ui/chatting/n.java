package com.tencent.mm.ui.chatting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.e.a.mw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.r;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.s;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.protocal.c.ahf;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.o;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class n implements OnClickListener, s, e {
    private a aSD;
    private ProgressDialog dwR;

    static /* synthetic */ void a(n nVar, final k kVar) {
        ak.vy().a(kVar, 0);
        Context bzo = nVar.aSD.bzo();
        nVar.aSD.getString(2131231164);
        nVar.dwR = g.a(bzo, nVar.aSD.getString(2131231182), true, new OnCancelListener(nVar) {
            final /* synthetic */ n olj;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(kVar);
                am.ash().b(2, this.olj);
            }
        });
    }

    public n(a aVar) {
        this.aSD = aVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        boolean z2 = false;
        if (view.getTag() == null) {
            v.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
        } else if (view.getTag() instanceof dl) {
            dl dlVar = (dl) view.getTag();
            if (dlVar == null) {
                v.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
                return;
            }
            r1 = dlVar.osd.appId;
            if (be.kS(r1)) {
                v.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
            } else if (com.tencent.mm.pluginsdk.model.app.g.aC(r1, false) == null) {
                v.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = " + r1);
            } else {
                z2 = true;
            }
            if (z2) {
                int i;
                String fL;
                am.ash().a(2, (s) this);
                if (this.aSD.onl) {
                    i = 2;
                } else {
                    i = 1;
                }
                r1 = this.aSD.bEn();
                if (m.dE(r1)) {
                    fL = aw.fL(dlVar.bmk.field_content);
                } else {
                    fL = r1;
                }
                final com.tencent.mm.q.a.a aVar = dlVar.osd;
                g.b(this.aSD.bzo(), this.aSD.getString(2131231089), this.aSD.getString(2131231090), this.aSD.getString(2131230787), this.aSD.getString(2131234372), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ n olj;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        n.a(this.olj, new w(2, new ai(aVar.appId, 0, "1")));
                        r rVar = j.a.lxN;
                        if (rVar != null) {
                            this.olj.aSD.bzo();
                            rVar.a(fL, aVar.appId, aVar.type, i, aVar.mediaTagName, 1);
                        }
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ n olj;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        n.a(this.olj, new w(2, new ai(aVar.appId, 0, "0")));
                        r rVar = j.a.lxN;
                        if (rVar != null) {
                            this.olj.aSD.bzo();
                            rVar.a(fL, aVar.appId, aVar.type, i, aVar.mediaTagName, 2);
                        }
                    }
                });
            }
        } else if (view.getTag() instanceof ec) {
            final ec ecVar = (ec) view.getTag();
            if (ecVar == null) {
                v.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
            } else if (ecVar == null || be.kS(ecVar.eHB) || ecVar.bmk == null) {
                String str = "MicroMsg.AppSpamClickListener";
                r1 = "wrong args, tag is null ? ";
                Object[] objArr = new Object[1];
                if (ecVar != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                v.e(str, r1, objArr);
            } else {
                String[] strArr = new String[]{this.aSD.bzo().getString(2131235649), this.aSD.bzo().getString(2131235650), this.aSD.bzo().getString(2131231010)};
                g.a(this.aSD.bzo(), null, strArr, null, true, new c(this) {
                    final /* synthetic */ n olj;

                    public final void gT(int i) {
                        switch (i) {
                            case 0:
                                Intent intent = new Intent();
                                try {
                                    intent.putExtra("rawUrl", String.format("http://mp.weixin.qq.com/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect", new Object[]{URLEncoder.encode(ecVar.lct, "UTF-8"), URLEncoder.encode(ecVar.eHB, "UTF-8"), Long.valueOf(ecVar.bmk.field_msgSvrId), Integer.valueOf((int) (ecVar.bmk.field_createTime / 1000)), Integer.valueOf(42)}));
                                    intent.putExtra("show_bottom", false);
                                    intent.putExtra("showShare", false);
                                    com.tencent.mm.ay.c.b(this.olj.aSD.bzo(), "webview", ".ui.tools.WebViewUI", intent);
                                    return;
                                } catch (UnsupportedEncodingException e) {
                                    v.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", e.getMessage());
                                    return;
                                }
                            case 1:
                                v.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", ecVar.lct, ecVar.eHB);
                                ak.vy().a(1030, this.olj);
                                ahf com_tencent_mm_protocal_c_ahf = new ahf();
                                com_tencent_mm_protocal_c_ahf.mbK = 1;
                                com_tencent_mm_protocal_c_ahf.mGT = ecVar.eHB;
                                com_tencent_mm_protocal_c_ahf.aXz = SQLiteDatabase.KeyEmpty;
                                LinkedList linkedList = new LinkedList();
                                linkedList.add(com_tencent_mm_protocal_c_ahf);
                                b mwVar = new mw();
                                mwVar.boh.bmE = ecVar.lct;
                                mwVar.boh.boi = linkedList;
                                if (com.tencent.mm.sdk.c.a.nhr.z(mwVar)) {
                                    n nVar = this.olj;
                                    Context bzo = this.olj.aSD.bzo();
                                    this.olj.aSD.getString(2131231164);
                                    nVar.dwR = g.a(bzo, this.olj.aSD.getString(2131231182), true, new OnCancelListener(this) {
                                        final /* synthetic */ AnonymousClass1 olk;

                                        {
                                            this.olk = r1;
                                        }

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            ak.vy().b(1030, this.olk.olj);
                                        }
                                    });
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.pluginsdk.model.app.v vVar) {
        v.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + i + ", errCode = " + i2);
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        am.ash().b(2, this);
        if (i == 0 && i2 == 0) {
            g.bf(this.aSD.bzo(), this.aSD.getString(2131233121));
        } else if (!o.a.a(this.aSD.bzo(), i, i2, str, 4)) {
            Toast.makeText(this.aSD.bzo(), this.aSD.getString(2131233092, Integer.valueOf(i), Integer.valueOf(i2)), 0).show();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        ak.vy().b(1030, (e) this);
        if (i == 0 && i2 == 0) {
            g.bf(this.aSD.bzo(), this.aSD.getString(2131233121));
            return;
        }
        Toast.makeText(this.aSD.bzo(), this.aSD.getString(2131235651, Integer.valueOf(i), Integer.valueOf(i2)), 0).show();
    }
}
