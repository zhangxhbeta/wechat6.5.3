package com.tencent.mm.plugin.notification.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.w.d;
import com.tencent.mm.e.a.ip;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.notification.c.e;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification {
    boolean dMT = false;
    private PendingIntent hJA = null;
    public boolean hJB = false;
    public boolean hJC = false;
    public boolean hJD = true;
    public d hJp = null;
    private Intent hJq = null;
    private int hJr = 0;
    public a hJs = null;
    public b hJt = null;
    public c hJu = null;
    public String hJv = null;
    public String hJw = null;
    private PendingIntent hJx = null;
    private PendingIntent hJy = null;
    private PendingIntent hJz = null;
    public Context mContext;
    private boolean mIsInit = false;
    private int mType;
    Notification sf = null;

    public static abstract class FailSendMsgNotificationService extends Service {
        protected c hJE = new c<ip>(this) {
            final /* synthetic */ FailSendMsgNotificationService hJG;

            {
                this.hJG = r2;
                this.nhz = ip.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                if (((ip) bVar).bjc.type != this.hJG.aEF()) {
                    v.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, type mismatch, type:%d, getNotificationType:%d", new Object[]{Integer.valueOf(((ip) bVar).bjc.type), Integer.valueOf(this.hJG.aEF())});
                } else {
                    v.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, stop service and show notificaiton, type:%d", new Object[]{Integer.valueOf(((ip) bVar).bjc.type)});
                    this.hJG.stopForeground(true);
                    if (this.hJG.hJF != null) {
                        this.hJG.hJF.dMT = false;
                        this.hJG.hJF.show();
                    }
                    this.hJG.stopSelf();
                }
                return false;
            }
        };
        protected FailSendMsgNotification hJF = null;

        protected abstract int aEF();

        public void onCreate() {
            super.onCreate();
            v.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
            a.nhr.e(this.hJE);
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        @TargetApi(16)
        public int onStartCommand(Intent intent, int i, int i2) {
            v.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
            if (intent == null || intent.getExtras() == null) {
                v.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
            } else {
                String action = intent.getAction();
                if (be.kS(action)) {
                    v.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
                } else {
                    int i3 = intent.getExtras().getInt("notification_type", -1);
                    v.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", new Object[]{Integer.valueOf(i3)});
                    if (e.nJ(i3) == null) {
                        v.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                    } else {
                        v.d("MicroMsg.FailSendMsgNotification", "action:%s", new Object[]{action});
                        this.hJF = e.nJ(i3);
                        if (action.startsWith("com.tencent.failnotification.omit")) {
                            if (this.hJF.hJs != null) {
                                v.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", new Object[]{Integer.valueOf(i3)});
                                this.hJF.hJs.aEq();
                            }
                        } else if (action.startsWith("com.tencent.failnotificaiton.resend")) {
                            if (this.hJF.hJs != null) {
                                boolean z;
                                String str = "MicroMsg.FailSendMsgNotification";
                                String str2 = "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b";
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(i3);
                                objArr[1] = Boolean.valueOf(this.hJF.sf == null);
                                if (this.hJF.hJp == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                objArr[2] = Boolean.valueOf(z);
                                v.d(str, str2, objArr);
                                if (this.hJF != null) {
                                    this.hJF.dMT = true;
                                }
                                if (this.hJF.sf != null && VERSION.SDK_INT >= 16) {
                                    this.hJF.sf.priority = 0;
                                }
                                if (this.hJF.sf == null) {
                                    this.hJF.show();
                                }
                                startForeground(i3, this.hJF.sf);
                                this.hJF.hJs.aEp();
                                v.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", new Object[]{Integer.valueOf(i3)});
                            }
                        } else if (action.startsWith("com.tencent.failnotification.click")) {
                            if (this.hJF.hJt != null) {
                                v.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", new Object[]{Integer.valueOf(i3)});
                                this.hJF.hJt.aEr();
                            }
                        } else if (action.startsWith("com.tencent.failnotification.dismiss")) {
                            this.hJF.hJB = false;
                            this.hJF.dMT = false;
                            if (this.hJF.hJu != null) {
                                v.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
                                this.hJF.hJu.onDismiss();
                            }
                            stopSelf();
                        }
                    }
                }
            }
            return 2;
        }

        public void onDestroy() {
            super.onDestroy();
            v.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
            a.nhr.f(this.hJE);
        }
    }

    public static class FailSendNormalMsgNotificationService extends FailSendMsgNotificationService {
        protected final int aEF() {
            return 1;
        }
    }

    public static class FailSendSnsMsgNotificationService extends FailSendMsgNotificationService {
        protected final int aEF() {
            return 2;
        }
    }

    public FailSendMsgNotification(int i) {
        boolean z;
        this.mType = i;
        this.mContext = aa.getContext();
        this.hJp = new d(this.mContext);
        this.hJD = true;
        this.hJw = "";
        try {
            if (this.hJD) {
                aEA();
            }
            aEB();
            this.mIsInit = true;
        } catch (Exception e) {
            v.e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", new Object[]{e.getMessage()});
            this.mIsInit = false;
        }
        String str = "MicroMsg.FailSendMsgNotification";
        String str2 = "create FailSendMsgNotification, type:%d, context==null:%b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        if (this.mContext == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        v.d(str, str2, objArr);
        this.hJB = false;
    }

    private void aEA() {
        this.hJp.rZ = true;
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.omit_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.omit_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.hJz = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.hJp.a(2130838805, this.mContext.getString(2131234085), this.hJz);
        intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotificaiton.resend_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotificaiton.resend_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        if (VERSION.SDK_INT >= 16) {
            intent.addFlags(268435456);
        }
        this.hJA = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.hJp.a(2130838806, this.mContext.getString(2131234086), this.hJA);
    }

    public final void aEB() {
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.click_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.click_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.hJx = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.hJp.rI = this.hJx;
        intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.dismiss_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.dismiss_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.hJy = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.hJp.sf.deleteIntent = this.hJy;
    }

    public final void xp(String str) {
        this.hJv = str;
        show();
    }

    public final void aEC() {
        v.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", new Object[]{Boolean.valueOf(false)});
        this.dMT = false;
    }

    @TargetApi(16)
    public final void show() {
        if (this.mIsInit) {
            this.hJp.c(this.hJw);
            this.hJp.a(this.mContext.getText(2131230720));
            this.hJp.L(VERSION.SDK_INT < 19 ? 2130838802 : 2130838803);
            this.hJp.b(this.hJv);
            this.hJp.o(false);
            this.sf = this.hJp.build();
            if (VERSION.SDK_INT >= 16 && !this.dMT) {
                this.sf.priority = 2;
                v.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
            }
            v.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", new Object[]{Boolean.valueOf(this.dMT)});
            ak.oH().a(this.mType, this.sf, false);
            this.hJB = true;
            return;
        }
        v.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
    }

    public final void dismiss() {
        ak.oH().cancel(this.mType);
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
            this.mContext.stopService(intent);
        } else if (this.mType == 2) {
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
            this.mContext.stopService(intent);
        }
        this.dMT = false;
        this.hJB = false;
    }

    public final void aED() {
        this.hJp.j(2, false);
        this.hJC = false;
        show();
        v.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
    }

    public final void aEE() {
        this.hJD = true;
        this.hJp = new d(this.mContext);
        aEA();
        aEB();
    }
}
