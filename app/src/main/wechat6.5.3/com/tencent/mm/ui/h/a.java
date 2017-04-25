package com.tencent.mm.ui.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import b.a.d.i;
import b.a.d.j;
import b.a.d.k;
import b.a.g.d;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.e.a.e;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"HandlerLeak"})
public final class a implements com.tencent.mm.ui.h.b.a {
    Context context = null;
    ac jDU = new ac(this) {
        final /* synthetic */ a oYl;

        {
            this.oYl = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what == BaseReportManager.MAX_READ_COUNT) {
                String str = (String) message.obj;
                if (str != null) {
                    Context context = this.oYl.context;
                    com.tencent.mm.ui.h.b.a aVar = this.oYl;
                    if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
                        e.B(context, "Error", "Application requires permission to access the Internet");
                    } else {
                        new b(context, str, aVar).show();
                    }
                } else {
                    this.oYl.c(c.Failed);
                }
            }
            if (message.what == 1010) {
                c cVar = (c) message.obj;
                a aVar2 = this.oYl;
                aVar2.oYi = false;
                if (cVar == c.Failed) {
                    aVar2.oYg = null;
                    a.a(null);
                }
                if (aVar2.oYk != null) {
                    aVar2.oYk.b(cVar);
                }
            }
        }
    };
    b.a.e.b oYe = null;
    public i oYf = null;
    i oYg = null;
    private boolean oYh = false;
    boolean oYi = false;
    public b oYj = null;
    public a oYk = null;

    public interface a {
        void b(c cVar);
    }

    public interface b {
        void a(c cVar);
    }

    public enum c {
        Finished,
        Failed,
        Canceled
    }

    public a() {
        i iVar;
        b.a.a.a aVar = new b.a.a.a();
        aVar.pOT = b.a.a.a.y(b.a.a.a.c.a.class);
        String str = "XMr2y8FEVEqZBcZ1TU3gLA";
        d.es(str, "Invalid Api key");
        aVar.pOQ = str;
        str = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
        d.es(str, "Invalid Api secret");
        aVar.pOR = str;
        str = "wechatapp://sign-in-twitter.wechatapp.com/";
        d.c(str, "Callback can't be null");
        aVar.pOS = str;
        d.c(aVar.pOT, "You must specify a valid api through the provider() method");
        d.es(aVar.pOQ, "You must provide an api key");
        d.es(aVar.pOR, "You must provide an api secret");
        this.oYe = aVar.pOT.a(new b.a.d.a(aVar.pOQ, aVar.pOR, aVar.pOS, aVar.pOU, aVar.mEw, aVar.pOV));
        if (ak.uz()) {
            ak.yW();
            str = (String) com.tencent.mm.model.c.vf().get(69377, null);
            ak.yW();
            String str2 = (String) com.tencent.mm.model.c.vf().get(69378, null);
            iVar = (be.kS(str) || be.kS(str2)) ? null : new i(str, str2);
        } else {
            v.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
            iVar = null;
        }
        this.oYf = iVar;
    }

    public final void a(b bVar, Context context) {
        if (!this.oYh) {
            this.oYj = bVar;
            this.context = context;
            this.oYh = true;
            com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                final /* synthetic */ a oYl;

                {
                    this.oYl = r1;
                }

                public final void run() {
                    Object b;
                    try {
                        this.oYl.oYg = this.oYl.oYe.bRt();
                        b = this.oYl.oYe.b(this.oYl.oYg);
                    } catch (b.a.b.a e) {
                        b = null;
                    }
                    this.oYl.jDU.sendMessage(this.oYl.jDU.obtainMessage(BaseReportManager.MAX_READ_COUNT, b));
                }
            }, "Twitter_doOAuth");
        }
    }

    public final boolean bJR() {
        return this.oYf != null;
    }

    public final void a(a aVar) {
        if (!this.oYi) {
            this.oYk = aVar;
            this.oYi = true;
            com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                final /* synthetic */ a oYl;

                {
                    this.oYl = r1;
                }

                public final void run() {
                    Object obj = c.Finished;
                    if (this.oYl.oYf == null) {
                        obj = c.Failed;
                    } else {
                        b.a.d.c cVar = new b.a.d.c(j.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
                        this.oYl.oYe.a(this.oYl.oYf, cVar);
                        try {
                            if (cVar.bRo().aJW != 200) {
                                obj = c.Failed;
                            }
                        } catch (Throwable e) {
                            v.a("MicroMsg.Twitter", e, "request error.", new Object[0]);
                            obj = c.Failed;
                        }
                    }
                    this.oYl.jDU.sendMessage(this.oYl.jDU.obtainMessage(1010, obj));
                }
            }, "Twitter_validationAccessToken");
        }
    }

    static void a(i iVar) {
        aa.getContext().getSharedPreferences(aa.bti(), 0);
        if (iVar == null) {
            ak.yW();
            com.tencent.mm.model.c.vf().set(69377, "");
            ak.yW();
            com.tencent.mm.model.c.vf().set(69378, "");
            return;
        }
        ak.yW();
        com.tencent.mm.model.c.vf().set(69377, iVar.token);
        ak.yW();
        com.tencent.mm.model.c.vf().set(69378, iVar.mIu);
    }

    final void c(c cVar) {
        this.oYh = false;
        this.oYg = null;
        if (this.oYj != null) {
            this.oYj.a(cVar);
        }
    }

    public final void k(final Bundle bundle) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ a oYl;

            public final void run() {
                i iVar = null;
                if (this.oYl.oYg != null) {
                    a.km(true);
                    String string = bundle.getString("oauth_verifier");
                    if (string != null) {
                        try {
                            iVar = this.oYl.oYe.a(this.oYl.oYg, new k(string));
                        } catch (b.a.b.a e) {
                        }
                    }
                    if (iVar != null) {
                        this.oYl.oYf = iVar;
                        a.a(this.oYl.oYf);
                        new ac(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 oYn;

                            {
                                this.oYn = r1;
                            }

                            public final void run() {
                                this.oYn.oYl.c(c.Finished);
                            }
                        });
                        return;
                    }
                    new ac(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 oYn;

                        {
                            this.oYn = r1;
                        }

                        public final void run() {
                            this.oYn.oYl.c(c.Failed);
                        }
                    });
                }
            }

            public final String toString() {
                return super.toString() + "|onComplete";
            }
        });
    }

    public final void bJS() {
        km(false);
        c(c.Failed);
    }

    public final void onCancel() {
        km(false);
        c(c.Canceled);
    }

    static void km(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.ak.i.a(10251, z ? "1" : "2"));
        ak.yW();
        com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.i(arrayList));
    }
}
