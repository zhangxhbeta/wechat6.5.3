package android.support.v4.media;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    private final android.support.v4.e.a<IBinder, b> tO = new android.support.v4.e.a();
    private final f tP = new f();
    Token tQ;

    public static final class a {
        final Bundle mExtras;
        final String tW;
    }

    private class b {
        final /* synthetic */ MediaBrowserServiceCompat tU;
        String tX;
        Bundle tY;
        d tZ;
        a ua;
        HashMap<String, List<Bundle>> ub;

        private b(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.tU = mediaBrowserServiceCompat;
            this.ub = new HashMap();
        }
    }

    public static class c<T> {
        int tM;
        Object uc;
        private boolean ud;
        boolean ue;

        c(Object obj) {
            this.uc = obj;
        }

        final boolean isDone() {
            return this.ud || this.ue;
        }

        void b(T t, int i) {
        }
    }

    private interface d {
        void a(String str, Token token, Bundle bundle);

        void a(String str, List<MediaItem> list, Bundle bundle);

        IBinder asBinder();

        void bz();
    }

    private final class f extends Handler {
        final /* synthetic */ MediaBrowserServiceCompat tU;
        private final g ug;

        private f(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.tU = mediaBrowserServiceCompat;
            this.ug = new g();
        }

        public final void handleMessage(Message message) {
            Bundle data = message.getData();
            g gVar;
            g gVar2;
            String string;
            switch (message.what) {
                case 1:
                    gVar = this.ug;
                    String string2 = data.getString("data_package_name");
                    int i = data.getInt("data_calling_uid");
                    Bundle bundle = data.getBundle("data_root_hints");
                    d eVar = new e(this.tU, message.replyTo);
                    if (MediaBrowserServiceCompat.a(gVar.tU, string2, i)) {
                        gVar.tU.tP.b(new AnonymousClass1(gVar, eVar, string2, bundle, i));
                        return;
                    }
                    throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + string2);
                case 2:
                    gVar2 = this.ug;
                    gVar2.tU.tP.b(new AnonymousClass2(gVar2, new e(this.tU, message.replyTo)));
                    return;
                case 3:
                    gVar = this.ug;
                    string = data.getString("data_media_item_id");
                    data = data.getBundle("data_options");
                    gVar.tU.tP.b(new AnonymousClass3(gVar, new e(this.tU, message.replyTo), string, data));
                    return;
                case 4:
                    gVar = this.ug;
                    string = data.getString("data_media_item_id");
                    data = data.getBundle("data_options");
                    gVar.tU.tP.b(new AnonymousClass4(gVar, new e(this.tU, message.replyTo), string, data));
                    return;
                case 5:
                    gVar = this.ug;
                    Object string3 = data.getString("data_media_item_id");
                    ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    if (!TextUtils.isEmpty(string3) && resultReceiver != null) {
                        gVar.tU.tP.b(new AnonymousClass5(gVar, string3, resultReceiver));
                        return;
                    }
                    return;
                case 6:
                    gVar2 = this.ug;
                    gVar2.tU.tP.b(new AnonymousClass6(gVar2, new e(this.tU, message.replyTo)));
                    return;
                case 7:
                    gVar2 = this.ug;
                    gVar2.tU.tP.b(new AnonymousClass7(gVar2, new e(this.tU, message.replyTo)));
                    return;
                default:
                    new StringBuilder("Unhandled message: ").append(message).append("\n  Service version: 1\n  Client version: ").append(message.arg1);
                    return;
            }
        }

        public final boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            return super.sendMessageAtTime(message, j);
        }

        private void b(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    private class g {
        final /* synthetic */ MediaBrowserServiceCompat tU;

        class AnonymousClass1 implements Runnable {
            final /* synthetic */ d uh;
            final /* synthetic */ String ui;
            final /* synthetic */ Bundle uj;
            final /* synthetic */ int uk;
            final /* synthetic */ g ul;

            AnonymousClass1(g gVar, d dVar, String str, Bundle bundle, int i) {
                this.ul = gVar;
                this.uh = dVar;
                this.ui = str;
                this.uj = bundle;
                this.uk = i;
            }

            public final void run() {
                IBinder asBinder = this.uh.asBinder();
                this.ul.tU.tO.remove(asBinder);
                b bVar = new b();
                bVar.tX = this.ui;
                bVar.tY = this.uj;
                bVar.tZ = this.uh;
                bVar.ua = this.ul.tU.by();
                if (bVar.ua == null) {
                    new StringBuilder("No root for client ").append(this.ui).append(" from service ").append(getClass().getName());
                    try {
                        this.uh.bz();
                        return;
                    } catch (RemoteException e) {
                        new StringBuilder("Calling onConnectFailed() failed. Ignoring. pkg=").append(this.ui);
                        return;
                    }
                }
                try {
                    this.ul.tU.tO.put(asBinder, bVar);
                    if (this.ul.tU.tQ != null) {
                        this.uh.a(bVar.ua.tW, this.ul.tU.tQ, bVar.ua.mExtras);
                    }
                } catch (RemoteException e2) {
                    new StringBuilder("Calling onConnect() failed. Dropping client. pkg=").append(this.ui);
                    this.ul.tU.tO.remove(asBinder);
                }
            }
        }

        class AnonymousClass2 implements Runnable {
            final /* synthetic */ d uh;
            final /* synthetic */ g ul;

            AnonymousClass2(g gVar, d dVar) {
                this.ul = gVar;
                this.uh = dVar;
            }

            public final void run() {
                this.ul.tU.tO.remove(this.uh.asBinder());
            }
        }

        class AnonymousClass3 implements Runnable {
            final /* synthetic */ Bundle tT;
            final /* synthetic */ d uh;
            final /* synthetic */ g ul;
            final /* synthetic */ String um;

            AnonymousClass3(g gVar, d dVar, String str, Bundle bundle) {
                this.ul = gVar;
                this.uh = dVar;
                this.um = str;
                this.tT = bundle;
            }

            public final void run() {
                b bVar = (b) this.ul.tU.tO.get(this.uh.asBinder());
                if (bVar == null) {
                    new StringBuilder("addSubscription for callback that isn't registered id=").append(this.um);
                } else {
                    MediaBrowserServiceCompat.a(this.ul.tU, this.um, bVar, this.tT);
                }
            }
        }

        class AnonymousClass4 implements Runnable {
            final /* synthetic */ Bundle tT;
            final /* synthetic */ d uh;
            final /* synthetic */ g ul;
            final /* synthetic */ String um;

            AnonymousClass4(g gVar, d dVar, String str, Bundle bundle) {
                this.ul = gVar;
                this.uh = dVar;
                this.um = str;
                this.tT = bundle;
            }

            public final void run() {
                b bVar = (b) this.ul.tU.tO.get(this.uh.asBinder());
                if (bVar == null) {
                    new StringBuilder("removeSubscription for callback that isn't registered id=").append(this.um);
                } else if (!MediaBrowserServiceCompat.a(this.um, bVar, this.tT)) {
                    new StringBuilder("removeSubscription called for ").append(this.um).append(" which is not subscribed");
                }
            }
        }

        class AnonymousClass5 implements Runnable {
            final /* synthetic */ ResultReceiver tV;
            final /* synthetic */ g ul;
            final /* synthetic */ String un;

            AnonymousClass5(g gVar, String str, ResultReceiver resultReceiver) {
                this.ul = gVar;
                this.un = str;
                this.tV = resultReceiver;
            }

            public final void run() {
                MediaBrowserServiceCompat.a(this.ul.tU, this.un, this.tV);
            }
        }

        class AnonymousClass6 implements Runnable {
            final /* synthetic */ d uh;
            final /* synthetic */ g ul;

            AnonymousClass6(g gVar, d dVar) {
                this.ul = gVar;
                this.uh = dVar;
            }

            public final void run() {
                IBinder asBinder = this.uh.asBinder();
                this.ul.tU.tO.remove(asBinder);
                b bVar = new b();
                bVar.tZ = this.uh;
                this.ul.tU.tO.put(asBinder, bVar);
            }
        }

        class AnonymousClass7 implements Runnable {
            final /* synthetic */ d uh;
            final /* synthetic */ g ul;

            AnonymousClass7(g gVar, d dVar) {
                this.ul = gVar;
                this.uh = dVar;
            }

            public final void run() {
                this.ul.tU.tO.remove(this.uh.asBinder());
            }
        }

        private g(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.tU = mediaBrowserServiceCompat;
        }
    }

    private class h {
    }

    private class e implements d {
        final /* synthetic */ MediaBrowserServiceCompat tU;
        final Messenger uf;

        e(MediaBrowserServiceCompat mediaBrowserServiceCompat, Messenger messenger) {
            this.tU = mediaBrowserServiceCompat;
            this.uf = messenger;
        }

        public final IBinder asBinder() {
            return this.uf.getBinder();
        }

        public final void a(String str, Token token, Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 1);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            a(1, bundle2);
        }

        public final void bz() {
            a(2, null);
        }

        public final void a(String str, List<MediaItem> list, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putBundle("data_options", bundle);
            if (list != null) {
                String str2 = "data_media_item_list";
                if (list instanceof ArrayList) {
                    list = (ArrayList) list;
                } else {
                    Object arrayList = new ArrayList(list);
                }
                bundle2.putParcelableArrayList(str2, list);
            }
            a(3, bundle2);
        }

        private void a(int i, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            this.uf.send(obtain);
        }
    }

    private class i extends h {
    }

    public abstract a by();

    static /* synthetic */ void a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, b bVar, Bundle bundle) {
        List list = (List) bVar.ub.get(str);
        List<Bundle> arrayList = list == null ? new ArrayList() : list;
        for (Bundle a : arrayList) {
            if (a.a(bundle, a)) {
                return;
            }
        }
        arrayList.add(bundle);
        bVar.ub.put(str, arrayList);
        final b bVar2 = bVar;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        c anonymousClass1 = new c<List<MediaItem>>(mediaBrowserServiceCompat, str) {
            final /* synthetic */ MediaBrowserServiceCompat tU;

            final /* synthetic */ void b(Object obj, int i) {
                List list = null;
                if (this.tU.tO.get(bVar2.tZ.asBinder()) == bVar2) {
                    List list2;
                    if ((i & 1) != 0) {
                        Bundle bundle = bundle2;
                        int i2 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                        int i3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                        if (!(i2 == -1 && i3 == -1)) {
                            int i4 = i3 * (i2 - 1);
                            int i5 = i4 + i3;
                            if (i2 <= 0 || i3 <= 0 || i4 >= list.size()) {
                                list2 = list;
                                bVar2.tZ.a(str2, list2, bundle2);
                            }
                            if (i5 > list.size()) {
                                i5 = list.size();
                            }
                            list2 = list.subList(i4, i5);
                            bVar2.tZ.a(str2, list2, bundle2);
                        }
                    }
                    list2 = list;
                    try {
                        bVar2.tZ.a(str2, list2, bundle2);
                    } catch (RemoteException e) {
                        new StringBuilder("Calling onLoadChildren() failed for id=").append(str2).append(" package=").append(bVar2.tX);
                    }
                }
            }
        };
        if (bundle != null) {
            anonymousClass1.tM = 1;
        }
        if (!anonymousClass1.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + bVar.tX + " id=" + str);
        }
    }

    static /* synthetic */ void a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, final ResultReceiver resultReceiver) {
        c anonymousClass2 = new c<MediaItem>(mediaBrowserServiceCompat, str) {
            final /* synthetic */ MediaBrowserServiceCompat tU;

            final /* synthetic */ void b(Object obj, int i) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", null);
                ResultReceiver resultReceiver = resultReceiver;
                if (resultReceiver.uX) {
                    if (resultReceiver.mHandler != null) {
                        resultReceiver.mHandler.post(new android.support.v4.os.ResultReceiver.b(resultReceiver, 0, bundle));
                    } else {
                        resultReceiver.onReceiveResult(0, bundle);
                    }
                } else if (resultReceiver.uY != null) {
                    try {
                        resultReceiver.uY.send(0, bundle);
                    } catch (RemoteException e) {
                    }
                }
            }
        };
        if (anonymousClass2.ue) {
            throw new IllegalStateException("sendResult() called twice for: " + anonymousClass2.uc);
        }
        anonymousClass2.ue = true;
        anonymousClass2.b(null, anonymousClass2.tM);
        if (!anonymousClass2.isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    static /* synthetic */ boolean a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : mediaBrowserServiceCompat.getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean a(String str, b bVar, Bundle bundle) {
        List<Bundle> list = (List) bVar.ub.get(str);
        if (list == null) {
            return false;
        }
        boolean z;
        for (Bundle bundle2 : list) {
            if (a.a(bundle, bundle2)) {
                list.remove(bundle2);
                z = true;
                break;
            }
        }
        z = false;
        if (list.size() != 0) {
            return z;
        }
        bVar.ub.remove(str);
        return z;
    }
}
