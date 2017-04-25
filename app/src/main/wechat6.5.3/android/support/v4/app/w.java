package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RemoteViews;
import com.tencent.mmdb.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class w {
    private static final i rz;

    public static class d {
        public Context mContext;
        Bundle mExtras;
        int mPriority;
        public CharSequence rG;
        public CharSequence rH;
        public PendingIntent rI;
        PendingIntent rJ;
        RemoteViews rK;
        public Bitmap rL;
        public CharSequence rM;
        public int rN;
        boolean rO = true;
        public boolean rP;
        public r rQ;
        public CharSequence rR;
        int rS;
        int rT;
        boolean rU;
        String rV;
        boolean rW;
        String rX;
        public ArrayList<a> rY = new ArrayList();
        public boolean rZ = false;
        public String sa;
        int sc = 0;
        int sd = 0;
        Notification se;
        public Notification sf = new Notification();
        public ArrayList<String> sg;

        public d(Context context) {
            this.mContext = context;
            this.sf.when = System.currentTimeMillis();
            this.sf.audioStreamType = -1;
            this.mPriority = 0;
            this.sg = new ArrayList();
        }

        public final d b(long j) {
            this.sf.when = j;
            return this;
        }

        public final d L(int i) {
            this.sf.icon = i;
            return this;
        }

        public final d a(CharSequence charSequence) {
            this.rG = d(charSequence);
            return this;
        }

        public final d b(CharSequence charSequence) {
            this.rH = d(charSequence);
            return this;
        }

        public final d b(int i, int i2, boolean z) {
            this.rS = i;
            this.rT = i2;
            this.rU = z;
            return this;
        }

        public final d c(CharSequence charSequence) {
            this.sf.tickerText = d(charSequence);
            return this;
        }

        public final d o(boolean z) {
            j(16, z);
            return this;
        }

        public final void j(int i, boolean z) {
            if (z) {
                Notification notification = this.sf;
                notification.flags |= i;
                return;
            }
            notification = this.sf;
            notification.flags &= i ^ -1;
        }

        public final d a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.rY.add(new a(i, charSequence, pendingIntent));
            return this;
        }

        @Deprecated
        public final Notification getNotification() {
            return build();
        }

        public final Notification build() {
            i bl = w.rz;
            e eVar = new e();
            return bl.b(this);
        }

        protected static CharSequence d(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    protected static class e {
        protected e() {
        }
    }

    public interface g {
        d a(d dVar);
    }

    interface i {
        Bundle a(Notification notification);

        Bundle a(android.support.v4.app.z.b bVar);

        Notification b(d dVar);
    }

    public static abstract class r {
        CharSequence ss;
        CharSequence st;
        boolean su = false;
    }

    public static class a extends android.support.v4.app.z.a {
        public static final android.support.v4.app.z.a.a rB = new android.support.v4.app.z.a.a() {
        };
        public PendingIntent actionIntent;
        public int icon;
        private final Bundle mExtras;
        private final ae[] rA;
        public CharSequence title;

        public final /* bridge */ /* synthetic */ android.support.v4.app.ag.a[] bn() {
            return this.rA;
        }

        public a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle());
        }

        private a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
            this.icon = i;
            this.title = d.d(charSequence);
            this.actionIntent = pendingIntent;
            this.mExtras = bundle;
            this.rA = null;
        }

        public final int getIcon() {
            return this.icon;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final PendingIntent bm() {
            return this.actionIntent;
        }

        public final Bundle getExtras() {
            return this.mExtras;
        }
    }

    public static class b extends r {
        Bitmap rC;
        Bitmap rD;
        boolean rE;
    }

    public static class c extends r {
        CharSequence rF;
    }

    public static final class f implements g {
        private Bitmap rL;
        private int sc = 0;
        public a sh;

        public static class a extends android.support.v4.app.z.b {
            static final android.support.v4.app.z.b.a so = new android.support.v4.app.z.b.a() {
            };
            private final String[] si;
            private final ae sj;
            private final PendingIntent sk;
            private final PendingIntent sl;
            private final String[] sm;
            private final long sn;

            public static class a {
                public ae sj;
                public PendingIntent sk;
                public PendingIntent sl;
                public long sn;
                public final List<String> sp = new ArrayList();
                public final String sq;

                public a(String str) {
                    this.sq = str;
                }
            }

            public final /* bridge */ /* synthetic */ android.support.v4.app.ag.a bo() {
                return this.sj;
            }

            public a(String[] strArr, ae aeVar, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                this.si = strArr;
                this.sj = aeVar;
                this.sl = pendingIntent2;
                this.sk = pendingIntent;
                this.sm = strArr2;
                this.sn = j;
            }

            public final String[] getMessages() {
                return this.si;
            }

            public final PendingIntent getReplyPendingIntent() {
                return this.sk;
            }

            public final PendingIntent getReadPendingIntent() {
                return this.sl;
            }

            public final String[] getParticipants() {
                return this.sm;
            }

            public final long getLatestTimestamp() {
                return this.sn;
            }
        }

        public final d a(d dVar) {
            if (VERSION.SDK_INT >= 21) {
                Bundle bundle = new Bundle();
                if (this.rL != null) {
                    bundle.putParcelable("large_icon", this.rL);
                }
                if (this.sc != 0) {
                    bundle.putInt("app_color", this.sc);
                }
                if (this.sh != null) {
                    bundle.putBundle("car_conversation", w.rz.a(this.sh));
                }
                if (dVar.mExtras == null) {
                    dVar.mExtras = new Bundle();
                }
                dVar.mExtras.putBundle("android.car.EXTENSIONS", bundle);
            }
            return dVar;
        }
    }

    public static class h extends r {
        ArrayList<CharSequence> sr = new ArrayList();
    }

    static class l implements i {
        l() {
        }

        public Notification b(d dVar) {
            Notification notification = dVar.sf;
            notification.setLatestEventInfo(dVar.mContext, dVar.rG, dVar.rH, dVar.rI);
            if (dVar.mPriority > 0) {
                notification.flags |= FileUtils.S_IWUSR;
            }
            return notification;
        }

        public Bundle a(Notification notification) {
            return null;
        }

        public Bundle a(android.support.v4.app.z.b bVar) {
            return null;
        }
    }

    static class m extends l {
        m() {
        }

        public final Notification b(d dVar) {
            Notification notification = dVar.sf;
            Context context = dVar.mContext;
            CharSequence charSequence = dVar.rG;
            CharSequence charSequence2 = dVar.rH;
            PendingIntent pendingIntent = dVar.rI;
            PendingIntent pendingIntent2 = dVar.rJ;
            notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
            notification.fullScreenIntent = pendingIntent2;
            if (dVar.mPriority > 0) {
                notification.flags |= FileUtils.S_IWUSR;
            }
            return notification;
        }
    }

    static class n extends l {
        n() {
        }

        public final Notification b(d dVar) {
            Context context = dVar.mContext;
            Notification notification = dVar.sf;
            CharSequence charSequence = dVar.rG;
            CharSequence charSequence2 = dVar.rH;
            CharSequence charSequence3 = dVar.rM;
            RemoteViews remoteViews = dVar.rK;
            int i = dVar.rN;
            PendingIntent pendingIntent = dVar.rI;
            return new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.rJ, (notification.flags & FileUtils.S_IWUSR) != 0).setLargeIcon(dVar.rL).setNumber(i).getNotification();
        }
    }

    static class o extends l {
        o() {
        }

        public final Notification b(d dVar) {
            return new android.support.v4.app.aa.a(dVar.mContext, dVar.sf, dVar.rG, dVar.rH, dVar.rM, dVar.rK, dVar.rN, dVar.rI, dVar.rJ, dVar.rL, dVar.rS, dVar.rT, dVar.rU).build();
        }
    }

    static class p extends l {
        p() {
        }

        public Notification b(d dVar) {
            v aVar = new android.support.v4.app.ab.a(dVar.mContext, dVar.sf, dVar.rG, dVar.rH, dVar.rM, dVar.rK, dVar.rN, dVar.rI, dVar.rJ, dVar.rL, dVar.rS, dVar.rT, dVar.rU, dVar.rP, dVar.mPriority, dVar.rR, dVar.rZ, dVar.mExtras, dVar.rV, dVar.rW, dVar.rX);
            w.a((u) aVar, dVar.rY);
            w.a(aVar, dVar.rQ);
            return aVar.build();
        }

        public Bundle a(Notification notification) {
            return ab.a(notification);
        }
    }

    static class q extends p {
        q() {
        }

        public Notification b(d dVar) {
            v aVar = new android.support.v4.app.ac.a(dVar.mContext, dVar.sf, dVar.rG, dVar.rH, dVar.rM, dVar.rK, dVar.rN, dVar.rI, dVar.rJ, dVar.rL, dVar.rS, dVar.rT, dVar.rU, dVar.rO, dVar.rP, dVar.mPriority, dVar.rR, dVar.rZ, dVar.sg, dVar.mExtras, dVar.rV, dVar.rW, dVar.rX);
            w.a((u) aVar, dVar.rY);
            w.a(aVar, dVar.rQ);
            return aVar.build();
        }

        public final Bundle a(Notification notification) {
            return notification.extras;
        }
    }

    static class j extends q {
        j() {
        }

        public Notification b(d dVar) {
            v aVar = new android.support.v4.app.x.a(dVar.mContext, dVar.sf, dVar.rG, dVar.rH, dVar.rM, dVar.rK, dVar.rN, dVar.rI, dVar.rJ, dVar.rL, dVar.rS, dVar.rT, dVar.rU, dVar.rO, dVar.rP, dVar.mPriority, dVar.rR, dVar.rZ, dVar.sg, dVar.mExtras, dVar.rV, dVar.rW, dVar.rX);
            w.a((u) aVar, dVar.rY);
            w.a(aVar, dVar.rQ);
            return aVar.build();
        }
    }

    static class k extends j {
        k() {
        }

        public final Notification b(d dVar) {
            v aVar = new android.support.v4.app.y.a(dVar.mContext, dVar.sf, dVar.rG, dVar.rH, dVar.rM, dVar.rK, dVar.rN, dVar.rI, dVar.rJ, dVar.rL, dVar.rS, dVar.rT, dVar.rU, dVar.rO, dVar.rP, dVar.mPriority, dVar.rR, dVar.rZ, dVar.sa, dVar.sg, dVar.mExtras, dVar.sc, dVar.sd, dVar.se, dVar.rV, dVar.rW, dVar.rX);
            w.a((u) aVar, dVar.rY);
            w.a(aVar, dVar.rQ);
            return aVar.build();
        }

        public final Bundle a(android.support.v4.app.z.b bVar) {
            String str = null;
            int i = 0;
            if (bVar == null) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (bVar.getParticipants() != null && bVar.getParticipants().length > 1) {
                str = bVar.getParticipants()[0];
            }
            Parcelable[] parcelableArr = new Parcelable[bVar.getMessages().length];
            while (i < parcelableArr.length) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", bVar.getMessages()[i]);
                bundle2.putString("author", str);
                parcelableArr[i] = bundle2;
                i++;
            }
            bundle.putParcelableArray("messages", parcelableArr);
            android.support.v4.app.ag.a bo = bVar.bo();
            if (bo != null) {
                bundle.putParcelable("remote_input", y.a(bo));
            }
            bundle.putParcelable("on_reply", bVar.getReplyPendingIntent());
            bundle.putParcelable("on_read", bVar.getReadPendingIntent());
            bundle.putStringArray("participants", bVar.getParticipants());
            bundle.putLong("timestamp", bVar.getLatestTimestamp());
            return bundle;
        }
    }

    static /* synthetic */ void a(u uVar, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            uVar.a((a) it.next());
        }
    }

    static /* synthetic */ void a(v vVar, r rVar) {
        if (rVar == null) {
            return;
        }
        if (rVar instanceof c) {
            c cVar = (c) rVar;
            ab.a(vVar, cVar.ss, cVar.su, cVar.st, cVar.rF);
        } else if (rVar instanceof h) {
            h hVar = (h) rVar;
            ab.a(vVar, hVar.ss, hVar.su, hVar.st, hVar.sr);
        } else if (rVar instanceof b) {
            b bVar = (b) rVar;
            ab.a(vVar, bVar.ss, bVar.su, bVar.st, bVar.rC, bVar.rD, bVar.rE);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            rz = new k();
        } else if (VERSION.SDK_INT >= 20) {
            rz = new j();
        } else if (VERSION.SDK_INT >= 19) {
            rz = new q();
        } else if (VERSION.SDK_INT >= 16) {
            rz = new p();
        } else if (VERSION.SDK_INT >= 14) {
            rz = new o();
        } else if (VERSION.SDK_INT >= 11) {
            rz = new n();
        } else if (VERSION.SDK_INT >= 9) {
            rz = new m();
        } else {
            rz = new l();
        }
    }

    public static Bundle a(Notification notification) {
        return rz.a(notification);
    }
}
