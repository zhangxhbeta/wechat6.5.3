package com.tencent.mm.performance.wxperformancetool;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.performance.c.a;
import com.tencent.mm.performance.c.b.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.h;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public final class d {
    public static HashMap<String, WeakReference<Object>> dol = new HashMap();
    public c dom = new c();

    public d(final Context context) {
        if (this.dom.MN()) {
            this.dom.a(new a());
            if (b.bsI() && this.dom.MO()) {
                this.dom.lO(com.tencent.mm.performance.c.b.TYPE);
                this.dom.a(new c(this) {
                    final /* synthetic */ d don;

                    public final void a(final com.tencent.mm.performance.d.d<Object> dVar, boolean z) {
                        Object obj = dVar.get();
                        if (obj != null) {
                            v.e("MicroMsg.WxPerformace", "memoryleak===" + obj.getClass().toString() + "   " + z);
                            if (!obj.getClass().equals(MemoryLeakActivity.class)) {
                                if (a.isEnabled()) {
                                    com.tencent.mm.bh.a.bym();
                                    if (dVar.get() != null) {
                                        final String str = new SimpleDateFormat("yyMMdd_HHmmss").format(new Date()) + "_" + dVar.dnU.replace('.', '_');
                                        final h RX = new h.a(context).Op("UILeak found!").Oq("Dumping hprof...").jk(false).jl(false).RX();
                                        RX.getWindow().setType(2005);
                                        RX.setOnShowListener(new OnShowListener(this) {
                                            final /* synthetic */ AnonymousClass1 dor;

                                            public final void onShow(DialogInterface dialogInterface) {
                                                ad.o(new Runnable(this) {
                                                    final /* synthetic */ AnonymousClass1 dos;

                                                    {
                                                        this.dos = r1;
                                                    }

                                                    public final void run() {
                                                        String NS = com.tencent.mm.bh.a.NS(str);
                                                        RX.dismiss();
                                                        if (NS == null || NS.length() <= 0) {
                                                            v.e("MicroMsg.WxPerformace", "Failed to dump hprof file, do not wake up analyse app.");
                                                        } else {
                                                            a.h(aa.getContext(), NS, dVar.dnU);
                                                        }
                                                    }
                                                });
                                            }
                                        });
                                        RX.show();
                                        return;
                                    }
                                    return;
                                }
                                Intent intent = new Intent();
                                if (z) {
                                    intent.putExtra("tag", "activity:");
                                } else {
                                    intent.putExtra("tag", "object:");
                                }
                                String valueOf = String.valueOf(System.currentTimeMillis());
                                intent.putExtra("key", valueOf);
                                d.dol.put(valueOf, dVar);
                                intent.putExtra("class", String.format("%s", new Object[]{obj}));
                                intent.setClass(context, MemoryLeakActivity.class);
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                context.startActivity(intent);
                            }
                        }
                    }
                });
            }
        }
        if (this.dom.MP()) {
            this.dom.a(new com.tencent.mm.performance.b.a.a(this) {
                final /* synthetic */ d don;

                {
                    this.don = r1;
                }

                public final void a(long j, long j2, long j3) {
                    v.e("MicroMsg.WxPerformace", "onMemoryDangerLow percentage:" + j + " max:" + j2 + " used:" + j3);
                }

                public final void b(long j, long j2, long j3) {
                    v.e("MicroMsg.WxPerformace", "onMemoryDangerMiddle percentage:" + j + " max:" + j2 + " used:" + j3);
                }

                public final void c(long j, long j2, long j3) {
                    v.e("MicroMsg.WxPerformace", "onMemoryDangerHigh percentage:" + j + " max:" + j2 + " used:" + j3);
                }
            });
        }
        b.dog = 3000;
        c cVar = this.dom;
        if (cVar.dok == null) {
            cVar.dok = new b("MonitorHandlerThread", cVar);
            cVar.dok.start();
            b bVar = cVar.dok;
            Looper looper = cVar.dok.getLooper();
            if (looper == null) {
                throw new IllegalArgumentException("setHandler, threadLooper is null");
            }
            bVar.mHandler = new com.tencent.mm.performance.wxperformancetool.b.AnonymousClass1(bVar, looper);
            bVar.mHandler.sendEmptyMessageDelayed(1, (long) b.dog);
        }
    }
}
