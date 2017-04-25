package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c.d;
import com.google.android.gms.wearable.f;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.FutureTask;

public final class bg implements com.google.android.gms.wearable.c {

    public static class a implements com.google.android.gms.wearable.c.a {
        private final Status aDC;
        private final f aGe;

        public a(Status status, f fVar) {
            this.aDC = status;
            this.aGe = fVar;
        }

        public final Status jo() {
            return this.aDC;
        }
    }

    public static class b implements com.google.android.gms.wearable.c.c {
        private final Status aDC;
        private final int aGf;

        public b(Status status, int i) {
            this.aDC = status;
            this.aGf = i;
        }

        public final Status jo() {
            return this.aDC;
        }
    }

    public static class c implements d {
        private final Status aDC;
        private volatile ParcelFileDescriptor aGg;
        private volatile InputStream aGh;
        private volatile boolean mClosed = false;

        public c(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.aDC = status;
            this.aGg = parcelFileDescriptor;
        }

        public final InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.aGg == null) {
                return null;
            } else {
                if (this.aGh == null) {
                    this.aGh = new AutoCloseInputStream(this.aGg);
                }
                return this.aGh;
            }
        }

        public final Status jo() {
            return this.aDC;
        }

        public final void release() {
            if (this.aGg != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.aGh != null) {
                        this.aGh.close();
                    } else {
                        this.aGg.close();
                    }
                    this.mClosed = true;
                    this.aGg = null;
                    this.aGh = null;
                } catch (IOException e) {
                }
            }
        }
    }

    class AnonymousClass2 extends aw<com.google.android.gms.wearable.c.c> {
        final /* synthetic */ bg aGa;
        final /* synthetic */ Uri aGb;
        final /* synthetic */ int aGc = 0;

        AnonymousClass2(bg bgVar, com.google.android.gms.common.api.c cVar, Uri uri, int i) {
            this.aGa = bgVar;
            this.aGb = uri;
            super(cVar);
        }

        protected final /* synthetic */ g b(Status status) {
            return new b(status, 0);
        }

        protected final /* synthetic */ void b(com.google.android.gms.common.api.a.b bVar) {
            ao aoVar = (ao) bVar;
            ((x) aoVar.jT()).b(new b(this), this.aGb, this.aGc);
        }
    }

    public final e<com.google.android.gms.wearable.c.c> a(com.google.android.gms.common.api.c cVar, Uri uri) {
        return cVar.a(new AnonymousClass2(this, cVar, uri, 0));
    }

    public final e<d> a(com.google.android.gms.common.api.c cVar, final Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.aDS == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.aDR == null) {
            return cVar.a(new aw<d>(this, cVar) {
                final /* synthetic */ bg aGa;

                protected final /* synthetic */ g b(Status status) {
                    return new c(status, null);
                }

                protected final /* synthetic */ void b(com.google.android.gms.common.api.a.b bVar) {
                    ao aoVar = (ao) bVar;
                    ((x) aoVar.jT()).a(new d(this), asset);
                }
            });
        } else {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public final e<com.google.android.gms.wearable.c.a> a(com.google.android.gms.common.api.c cVar, final PutDataRequest putDataRequest) {
        return cVar.a(new aw<com.google.android.gms.wearable.c.a>(this, cVar) {
            final /* synthetic */ bg aGa;

            public final /* synthetic */ g b(Status status) {
                return new a(status, null);
            }

            protected final /* synthetic */ void b(com.google.android.gms.common.api.a.b bVar) {
                ao aoVar = (ao) bVar;
                PutDataRequest putDataRequest = putDataRequest;
                for (Entry value : putDataRequest.my().entrySet()) {
                    Asset asset = (Asset) value.getValue();
                    if (asset.aDR == null && asset.aDS == null && asset.aDT == null && asset.uri == null) {
                        throw new IllegalArgumentException("Put for " + putDataRequest.mUri + " contains invalid asset: " + asset);
                    }
                }
                PutDataRequest e = PutDataRequest.e(putDataRequest.mUri);
                e.aDR = putDataRequest.aDR;
                List arrayList = new ArrayList();
                for (Entry value2 : putDataRequest.my().entrySet()) {
                    Asset asset2 = (Asset) value2.getValue();
                    if (asset2.aDR == null) {
                        e.b((String) value2.getKey(), (Asset) value2.getValue());
                    } else {
                        try {
                            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                            if (Log.isLoggable("WearableClient", 3)) {
                                new StringBuilder("processAssets: replacing data with FD in asset: ").append(asset2).append(" read:").append(createPipe[0]).append(" write:").append(createPipe[1]);
                            }
                            e.b((String) value2.getKey(), Asset.a(createPipe[0]));
                            Runnable futureTask = new FutureTask(new com.google.android.gms.wearable.internal.ao.AnonymousClass1(aoVar, createPipe[1], asset2.aDR));
                            arrayList.add(futureTask);
                            aoVar.aFD.submit(futureTask);
                        } catch (Throwable e2) {
                            throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e2);
                        }
                    }
                }
                ((x) aoVar.jT()).a(new f(this, arrayList), e);
            }
        });
    }
}
