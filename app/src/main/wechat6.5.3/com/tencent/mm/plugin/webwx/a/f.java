package com.tencent.mm.plugin.webwx.a;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.mn;
import com.tencent.mm.model.af;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.c.pk;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;

public final class f implements ag {
    private b eiI = new b(this) {
        final /* synthetic */ f lsO;

        {
            this.lsO = r1;
        }

        public final void a(a aVar) {
            String str = (String) bf.q(m.a(aVar.czu.mbW), "sysmsg").get(".sysmsg.pushloginurl.url");
            if (be.kS(str)) {
                v.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
            }
            mn mnVar = new mn();
            mnVar.bnL.bnM = str;
            mnVar.bnL.type = 1;
            com.tencent.mm.sdk.c.a.nhr.z(mnVar);
            aVar.czu.mca = null;
        }
    };
    private e lsL = new e();
    private af lsM = new af(this) {
        final /* synthetic */ f lsO;

        {
            this.lsO = r1;
        }

        public final void yM() {
            ak.yW();
            if (c.wC()) {
                f.blT();
            }
        }
    };
    private com.tencent.mm.sdk.c.c lsN = new com.tencent.mm.sdk.c.c<mn>(this) {
        final /* synthetic */ f lsO;

        {
            this.lsO = r2;
            this.nhz = mn.class.getName().hashCode();
        }

        private boolean a(final mn mnVar) {
            if (mnVar != null && (mnVar instanceof mn)) {
                final c cVar = new c(mnVar.bnL.bnM);
                ak.vy().a(971, new e(this) {
                    final /* synthetic */ AnonymousClass3 lsR;

                    public final void a(int i, int i2, String str, k kVar) {
                        CharSequence charSequence;
                        Intent intent;
                        ak.vy().b(971, this);
                        pk pkVar = (pk) cVar.cQA.czl.czs;
                        v.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", new Object[]{Integer.valueOf(i2), str});
                        if (i == 0 && i2 == 0) {
                            if (pkVar.mrj != null) {
                                Object obj;
                                Intent intent2 = new Intent();
                                intent2.putExtra("intent.key.login.url", mnVar.bnL.bnM);
                                intent2.putExtra("intent.key.type", 0);
                                intent2.putExtra("intent.key.icon.type", pkVar.mrj.mrf);
                                intent2.putExtra("intent.key.ok.string", pkVar.mrj.mro);
                                intent2.putExtra("intent.key.cancel.string", pkVar.mrj.mrp);
                                intent2.putExtra("intent.key.title.string", pkVar.mrj.mrg);
                                intent2.putExtra("intent.key.content.string", pkVar.mrj.mrt);
                                String str2 = pkVar.mrj.mrg;
                                StringBuilder stringBuilder = new StringBuilder();
                                Cursor cursor = null;
                                try {
                                    ak.yW();
                                    cursor = c.wK().a(com.tencent.mm.model.m.crA, null, com.tencent.mm.j.a.cht, true);
                                    if (cursor != null) {
                                        int count;
                                        if (cursor.getCount() < pkVar.mrj.mrq) {
                                            count = cursor.getCount();
                                        } else {
                                            count = pkVar.mrj.mrq;
                                        }
                                        int columnIndex = cursor.getColumnIndex("username");
                                        for (int i3 = 0; i3 < count; i3++) {
                                            if (cursor.moveToPosition(i3)) {
                                                stringBuilder.append(cursor.getString(columnIndex));
                                                if (i3 < count - 1) {
                                                    stringBuilder.append(",");
                                                }
                                            }
                                        }
                                    }
                                    intent2.putExtra("intent.key.ok.session.list", stringBuilder.toString());
                                    if (cursor != null) {
                                        cursor.close();
                                        charSequence = str2;
                                        intent = intent2;
                                    }
                                } catch (Throwable e) {
                                    v.a("MicroMsg.SubCoreWebWX", e, "[oneliang]get session list error.", new Object[0]);
                                    if (cursor != null) {
                                        cursor.close();
                                        obj = str2;
                                        intent = intent2;
                                    }
                                } catch (Throwable th) {
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                }
                                obj = str2;
                                intent = intent2;
                            }
                            charSequence = null;
                            intent = null;
                        } else if (i2 == -1) {
                            if (pkVar.mrk != null) {
                                intent = new Intent();
                                intent.putExtra("intent.key.login.url", mnVar.bnL.bnM);
                                intent.putExtra("intent.key.type", -1);
                                intent.putExtra("intent.key.title.string", pkVar.mrk.mrh);
                                intent.putExtra("intent.key.icon.type", pkVar.mrk.mrf);
                                intent.putExtra("intent.key.ok.string", pkVar.mrk.mri);
                                intent.putExtra("intent.key.content.string", pkVar.mrk.mrg);
                                charSequence = pkVar.mrk.mrg;
                            }
                            charSequence = null;
                            intent = null;
                        } else {
                            if (i2 == -2 && pkVar.mrl != null) {
                                intent = new Intent();
                                intent.putExtra("intent.key.login.url", mnVar.bnL.bnM);
                                intent.putExtra("intent.key.type", -2);
                                intent.putExtra("intent.key.title.string", pkVar.mrl.mrh);
                                intent.putExtra("intent.key.icon.type", pkVar.mrl.mrf);
                                intent.putExtra("intent.key.ok.string", pkVar.mrl.mri);
                                intent.putExtra("intent.key.content.string", pkVar.mrl.mrg);
                                charSequence = pkVar.mrl.mrg;
                            }
                            charSequence = null;
                            intent = null;
                        }
                        if (intent != null) {
                            intent.setFlags(268435456);
                            intent.setClass(aa.getContext(), ExtDeviceWXLoginUI.class);
                            aa.getContext().startActivity(intent);
                            Intent intent3 = new Intent(intent);
                            intent3.setFlags(67108864);
                            if (mnVar.bnL.type == 1) {
                                Notification notification = new Builder(aa.getContext()).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(aa.getContext().getString(2131230720)).setContentText(charSequence).setContentIntent(PendingIntent.getActivity(aa.getContext(), 0, intent3, 134217728)).getNotification();
                                notification.icon = com.tencent.mm.ax.a.bmo();
                                notification.flags |= 16;
                                notification.sound = RingtoneManager.getDefaultUri(2);
                                ak.oH().notify(38, notification);
                            }
                        }
                    }
                });
                ak.vy().a(cVar, 0);
            }
            return false;
        }
    };

    public final void th() {
        d.c.aw(Integer.valueOf(51));
        ak.yU().b("pushloginurl", this.eiI, true);
        ak.yW();
        c.b(this.lsM);
        com.tencent.mm.sdk.c.a.nhr.f(this.lsN);
        blT();
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        d.c.a(Integer.valueOf(51), this.lsL);
        ak.yU().a("pushloginurl", this.eiI, true);
        ak.yW();
        c.a(this.lsM);
        com.tencent.mm.sdk.c.a.nhr.e(this.lsN);
    }

    public final void aH(boolean z) {
    }

    static void blT() {
        ak.oH().cancel(38);
    }
}
