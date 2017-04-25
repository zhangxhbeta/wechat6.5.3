package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class f {
    private static f jBl = new f();
    ConcurrentLinkedQueue<String> jBk = new ConcurrentLinkedQueue();

    public static f aUk() {
        return jBl;
    }

    private f() {
    }

    public final boolean Bn(String str) {
        return this.jBk.contains(str);
    }

    private void a(String str, n nVar) {
        if (nVar.jvH == 101) {
            Iterator it = ((i) nVar).jvw.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((h) it.next()).jvw.iterator();
                while (it2.hasNext()) {
                    a(str, (n) it2.next());
                }
            }
        } else if (nVar.jvH == 41) {
            r0 = (k) nVar;
            if (!Bn(r0.jvA)) {
                this.jBk.add(r0.jvA);
                d.a(str, r0.jvA, true, nVar.jvH, 0, new a(this) {
                    final /* synthetic */ f jBn;

                    public final void aRx() {
                    }

                    public final void aTV() {
                        v.e("AdLandingPagesPreDownloadResHelper", " pre download " + r0.jvA + "is error");
                        this.jBn.jBk.remove(r0.jvA);
                    }

                    public final void Bg(String str) {
                        this.jBn.jBk.remove(r0.jvA);
                    }
                });
            }
        } else if (nVar.jvH == 44) {
            final j jVar = (j) nVar;
            if (!Bn(jVar.jvA)) {
                this.jBk.add(jVar.jvA);
                d.a(str, jVar.jvA, true, nVar.jvH, 0, new a(this) {
                    final /* synthetic */ f jBn;

                    public final void aRx() {
                    }

                    public final void aTV() {
                        v.e("AdLandingPagesPreDownloadResHelper", " pre download " + jVar.jvA + "is error");
                        this.jBn.jBk.remove(jVar.jvA);
                    }

                    public final void Bg(String str) {
                        this.jBn.jBk.remove(jVar.jvA);
                    }
                });
            }
        } else if (nVar.jvH == 45) {
            r0 = (k) nVar;
            if (!Bn(r0.jvA)) {
                this.jBk.add(r0.jvA);
                d.a(str, r0.jvA, true, nVar.jvH, 0, new a(this) {
                    final /* synthetic */ f jBn;

                    public final void aRx() {
                    }

                    public final void aTV() {
                        v.e("AdLandingPagesPreDownloadResHelper", " pre download " + r0.jvA + "is error");
                        this.jBn.jBk.remove(r0.jvA);
                    }

                    public final void Bg(String str) {
                        this.jBn.jBk.remove(r0.jvA);
                    }
                });
            }
        } else if (nVar.jvH == 61) {
            final l lVar = (l) nVar;
            if (!Bn(lVar.jvB)) {
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                c.Eg();
                if (c.a(pInt, pInt2)) {
                    this.jBk.add(lVar.jvB);
                    d.a(str, lVar.jvB, true, new a(this) {
                        final /* synthetic */ f jBn;

                        public final void aRx() {
                        }

                        public final void aTV() {
                            v.e("AdLandingPagesPreDownloadResHelper", " pre download " + lVar.jvB + "is error");
                            this.jBn.jBk.remove(lVar.jvB);
                        }

                        public final void Bg(String str) {
                            this.jBn.jBk.remove(lVar.jvB);
                        }
                    });
                }
            }
            if (!Bn(lVar.jvC)) {
                this.jBk.add(lVar.jvC);
                d.a(str, lVar.jvC, true, 1000000001, 0, new a(this) {
                    final /* synthetic */ f jBn;

                    public final void aRx() {
                    }

                    public final void aTV() {
                        v.e("AdLandingPagesPreDownloadResHelper", " pre download " + lVar.jvC + "is error");
                        this.jBn.jBk.remove(lVar.jvC);
                    }

                    public final void Bg(String str) {
                        this.jBn.jBk.remove(lVar.jvC);
                    }
                });
            }
        } else if (nVar.jvH == 62) {
            boolean z = com.tencent.mm.h.j.sU().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0;
            v.i("AdLandingPagesPreDownloadResHelper", "pre down video value: " + z);
            final r rVar = (r) nVar;
            if (z && !Bn(rVar.jwc)) {
                this.jBk.add(rVar.jwc);
                d.a(str, rVar.jwc, true, nVar.jvH, new b(this) {
                    final /* synthetic */ f jBn;

                    public final void Bi(String str) {
                    }

                    public final void Bj(String str) {
                        v.e("AdLandingPagesPreDownloadResHelper", " pre download " + rVar.jwc + "is error");
                        this.jBn.jBk.remove(rVar.jwc);
                    }

                    public final void Bk(String str) {
                        this.jBn.jBk.remove(rVar.jwc);
                    }
                });
            }
            if (!Bn(rVar.jwd)) {
                this.jBk.add(rVar.jwd);
                d.a("adId", rVar.jwd, true, nVar.jvH, 0, new a(this) {
                    final /* synthetic */ f jBn;

                    public final void aRx() {
                    }

                    public final void aTV() {
                        v.e("AdLandingPagesPreDownloadResHelper", " pre download " + rVar.jwd + "is error");
                        this.jBn.jBk.remove(rVar.jwc);
                    }

                    public final void Bg(String str) {
                        this.jBn.jBk.remove(rVar.jwd);
                    }
                });
            }
        }
    }

    public final void c(final String str, String str2, String str3, int i) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) aa.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        LinkedList j = e.j(str2, str3, "", "");
        int i2;
        int i3;
        Iterator it;
        int i4;
        c cVar;
        Iterator it2;
        final n nVar;
        if (i == 0) {
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                v.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in no wifi");
                i2 = com.tencent.mm.h.j.sU().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
                i3 = com.tencent.mm.h.j.sU().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
                if (j.size() > 0) {
                    it = j.iterator();
                    i4 = i2;
                    while (it.hasNext()) {
                        cVar = (c) it.next();
                        if (i3 > 0 && i4 > 0) {
                            it2 = cVar.jAW.iterator();
                            while (it2.hasNext()) {
                                nVar = (n) it2.next();
                                ad.o(new Runnable(this) {
                                    final /* synthetic */ f jBn;

                                    public final void run() {
                                        this.jBn.a(str, nVar);
                                    }
                                });
                                i2 = i3 - 1;
                                if (i2 <= 0) {
                                    break;
                                }
                                i3 = i2;
                            }
                            i2 = i3;
                            i4--;
                            i3 = i2;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            v.i("AdLandingPagesPreDownloadResHelper", "start pre download all resource in wifi");
            Iterator it3 = j.iterator();
            while (it3.hasNext()) {
                Iterator it4 = ((c) it3.next()).jAW.iterator();
                while (it4.hasNext()) {
                    a(str, (n) it4.next());
                }
            }
        } else if (i == 1) {
            v.i("AdLandingPagesPreDownloadResHelper", "start pre download first pages resource");
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                v.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in no wifi,this can't download everything");
                return;
            }
            v.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in wifi");
            i2 = com.tencent.mm.h.j.sU().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
            i3 = com.tencent.mm.h.j.sU().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
            if (j.size() > 0) {
                it = j.iterator();
                i4 = i2;
                while (it.hasNext()) {
                    cVar = (c) it.next();
                    if (i3 > 0 && i4 > 0) {
                        it2 = cVar.jAW.iterator();
                        while (it2.hasNext()) {
                            nVar = (n) it2.next();
                            ad.o(new Runnable(this) {
                                final /* synthetic */ f jBn;

                                public final void run() {
                                    this.jBn.a(str, nVar);
                                }
                            });
                            i2 = i3 - 1;
                            if (i2 <= 0) {
                                break;
                            }
                            i3 = i2;
                        }
                        i2 = i3;
                        i4--;
                        i3 = i2;
                    } else {
                        return;
                    }
                }
            }
        } else {
            v.e("AdLandingPagesPreDownloadResHelper", "the dwnloadKind is error");
        }
    }
}
