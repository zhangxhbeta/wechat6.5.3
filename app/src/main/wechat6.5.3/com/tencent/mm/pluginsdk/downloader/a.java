package com.tencent.mm.pluginsdk.downloader;

import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.pluginsdk.model.downloader.l;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a {
    public List<WeakReference<l>> lyq = Collections.synchronizedList(new ArrayList());
    final l lyr = new l(this) {
        final /* synthetic */ a lys;

        {
            this.lys = r1;
        }

        public final void onTaskStarted(long j, String str) {
            try {
                v.i("MicroMsg.FileDownloader", "[download]onTaskStarted %d, savePath:%s", new Object[]{Long.valueOf(j), str});
                for (WeakReference weakReference : new ArrayList(this.lys.lyq)) {
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((l) weakReference.get()).onTaskStarted(j, str);
                    }
                }
            } catch (Throwable e) {
                v.a("MicroMsg.FileDownloader", e, "", new Object[0]);
            }
        }

        public final void g(long j, String str) {
            try {
                v.i("MicroMsg.FileDownloader", "[download]onTaskFinished %d, path:%s", new Object[]{Long.valueOf(j), str});
                for (WeakReference weakReference : new ArrayList(this.lys.lyq)) {
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((l) weakReference.get()).g(j, str);
                    }
                }
            } catch (Throwable e) {
                v.a("MicroMsg.FileDownloader", e, "", new Object[0]);
            }
        }

        public final void q(long j, int i) {
            try {
                v.e("MicroMsg.FileDownloader", "[download]onTaskFailed %d", new Object[]{Long.valueOf(j)});
                for (WeakReference weakReference : new ArrayList(this.lys.lyq)) {
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((l) weakReference.get()).q(j, i);
                    }
                }
            } catch (Throwable e) {
                v.a("MicroMsg.FileDownloader", e, "", new Object[0]);
            }
        }

        public final void onTaskRemoved(long j) {
            try {
                v.i("MicroMsg.FileDownloader", "[download] onTaskRemoved :%d", new Object[]{Long.valueOf(j)});
                for (WeakReference weakReference : new ArrayList(this.lys.lyq)) {
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((l) weakReference.get()).onTaskRemoved(j);
                    }
                }
            } catch (Throwable e) {
                v.a("MicroMsg.FileDownloader", e, "", new Object[0]);
            }
        }

        public final void onTaskPaused(long j) {
            try {
                v.e("MicroMsg.FileDownloader", "[download] onTaskPaused %d", new Object[]{Long.valueOf(j)});
                for (WeakReference weakReference : new ArrayList(this.lys.lyq)) {
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((l) weakReference.get()).onTaskPaused(j);
                    }
                }
            } catch (Throwable e) {
                v.a("MicroMsg.FileDownloader", e, "", new Object[0]);
            }
        }

        public final void bV(long j) {
        }

        public final void bW(long j) {
        }
    };

    public a() {
        d.bnK();
        com.tencent.mm.pluginsdk.model.downloader.a.a(this.lyr);
    }
}
