package com.tencent.mm.console;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.e.a.fo;
import com.tencent.mm.e.a.ha;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;

public final class Shell {
    private static HashMap<String, a> chn = new HashMap();
    private static IntentFilter cho = new IntentFilter();
    private static Runnable chp = new Runnable() {
        public final void run() {
            v.d("MicroMsg.Shell", "dkcrash begin tid:%d [%s]", Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
            Object[] objArr = new Object[1];
            String str = null;
            objArr[0] = Integer.valueOf(str.length());
            v.d("MicroMsg.Shell", "%d ", objArr);
        }
    };
    private Receiver chm = null;

    public static class Receiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            a aVar = (a) Shell.chn.get(intent.getAction());
            if (aVar == null) {
                v.e("MicroMsg.Shell", "no action found for %s", r1);
                return;
            }
            v.e("MicroMsg.Shell", "shell action %s", r1);
            aVar.k(intent);
        }
    }

    public interface a {
        void k(Intent intent);
    }

    static /* synthetic */ void tj() {
    }

    static {
        a("wechat.shell.SET_NEXTRET", new a() {
            public final void k(Intent intent) {
                int intExtra = intent.getIntExtra("type", Integer.MAX_VALUE);
                int intExtra2 = intent.getIntExtra("error", 0);
                if (intExtra != Integer.MAX_VALUE && intExtra2 != 0) {
                    v.w("MicroMsg.Shell", "kiro set Test.pushNextErrorRet(type=%d, err=%d)", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                    q.aX(intExtra, intExtra2);
                }
            }
        });
        a("wechat.shell.SET_LOGLEVEL", new a() {
            public final void k(Intent intent) {
                int intExtra = intent.getIntExtra("level", 0);
                v.w("MicroMsg.Shell", "kiro set Log.level=%d", Integer.valueOf(v.getLogLevel()));
                v.uZ(intExtra);
            }
        });
        a("wechat.shell.SET_CDNTRANS", new a() {
            public final void k(Intent intent) {
                q.dqd = intent.getBooleanExtra("value", false);
                v.w("MicroMsg.Shell", "kiro set Test.forceCDNTrans=%b", Boolean.valueOf(q.dqd));
            }
        });
        a("wechat.shell.SET_DKTEST", new a() {
            public final void k(Intent intent) {
                q.dqj = intent.getIntExtra("key", 0);
                q.dqk = intent.getIntExtra("val", 0);
                q.dql = intent.getStringExtra("str");
                v.w("MicroMsg.Shell", "dkshell set [%d %d] [%s]", Integer.valueOf(q.dqj), Integer.valueOf(q.dqk), q.dql);
                if (10009 == q.dqj) {
                    int i = q.dqk;
                    Shell.tj();
                } else if (10014 == q.dqj && aa.bto()) {
                    o.Ho().a(7, 1, SQLiteDatabase.KeyEmpty);
                } else if (10015 == q.dqj && aa.btp()) {
                    b foVar = new fo();
                    foVar.beT.type = 13;
                    com.tencent.mm.sdk.c.a.nhr.z(foVar);
                }
            }
        });
        a("wechat.shell.NET_DNS_TEST", new a() {
            public final void k(Intent intent) {
                q.dqi = intent.getIntExtra("value", 0);
                v.w("MicroMsg.Shell", "dkdnstd set Test.netDnsSimulateFault=%s", Integer.toBinaryString(q.dqi));
            }
        });
        a("wechat.shell.IDC_ERROR", new a() {
            public final void k(Intent intent) {
                q.dqm = intent.getStringExtra("errmsg");
                v.w("MicroMsg.Shell", "tiger set tigerIDCErrMsg =%s", q.dqm);
            }
        });
        a("wechat.shell.SET_DK_WT_TEST", new a() {
            public final void k(Intent intent) {
                q.dqn = intent.getStringExtra("acc");
                q.dqo = intent.getStringExtra("pass");
                v.w("MicroMsg.Shell", "dkwt shell [%s %s]", q.dqn, q.dqo);
            }
        });
        a("wechat.shell.SET_MUTE_ROOM_TEST", new a() {
            public final void k(Intent intent) {
                q.dqQ = intent.getIntExtra("flag", 0);
                v.w("MicroMsg.Shell", "dkwt shell [%d]", Integer.valueOf(q.dqQ));
            }
        });
        a("wechat.shell.HOTPATCH_TEST", new a() {
            public final void k(Intent intent) {
                b haVar = new ha();
                haVar.bgH.bgM = intent.getExtras().getString("path", "/data/local/tmp/test.apk");
                v.w("MicroMsg.Shell", "hotpatch test [%s]", haVar.bgH.bgM);
                com.tencent.mm.sdk.c.a.nhr.z(haVar);
            }
        });
    }

    private static void a(String str, a aVar) {
        cho.addAction(str);
        chn.put(str, aVar);
    }
}
