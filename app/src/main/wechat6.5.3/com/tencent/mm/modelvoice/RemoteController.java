package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Method;

public final class RemoteController {
    private static Method diK;
    private static Method diL;
    private AudioManager diI;
    private ComponentName diJ;

    public static class RemoteControlReceiver extends BroadcastReceiver {
        private static ah aSW;
        private static a diM;

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
                    if (aSW == null && diM != null) {
                        v.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
                        aSW = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
                            final /* synthetic */ RemoteControlReceiver diN;

                            {
                                this.diN = r1;
                            }

                            public final boolean oU() {
                                v.d("MicroMsg.RemoteControlReceiver", "got remote key event up");
                                RemoteControlReceiver.aSW = null;
                                return false;
                            }
                        }, true);
                    }
                    if (aSW != null) {
                        aSW.ea(1000);
                        return;
                    }
                    return;
                }
                v.d("MicroMsg.RemoteControlReceiver", "unknown action, ignore" + intent.getAction());
            }
        }

        public static void Lt() {
            diM = null;
            if (aSW != null) {
                aSW.QI();
                aSW = null;
            }
        }
    }

    public interface a {
    }

    static {
        try {
            if (diK == null) {
                diK = AudioManager.class.getMethod("registerMediaButtonEventReceiver", new Class[]{ComponentName.class});
            }
            if (diL == null) {
                diL = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", new Class[]{ComponentName.class});
            }
        } catch (NoSuchMethodException e) {
        }
    }

    protected final void finalize() {
        try {
            if (diL != null) {
                diL.invoke(this.diI, new Object[]{this.diJ});
                RemoteControlReceiver.Lt();
            }
        } catch (Throwable e) {
            Throwable th = e;
            Throwable e2 = th.getCause();
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else if (e2 instanceof Error) {
                throw ((Error) e2);
            } else {
                throw new RuntimeException(th);
            }
        } catch (IllegalAccessException e3) {
            v.e("MicroMsg.RemoteControlReceiver", "unexpected " + e3);
        }
        super.finalize();
    }
}
