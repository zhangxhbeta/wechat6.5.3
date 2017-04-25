package com.tencent.mm.ae;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class c implements e, f {
    public List<b> cLh = new LinkedList();
    private HashSet<b> cLi = new HashSet();
    public b cLj = null;
    private j cLk = null;
    public boolean cLl = false;

    public interface a {
        void a(long j, int i, int i2, Object obj, int i3, int i4, k kVar);

        void a(long j, long j2, int i, Object obj, int i2, int i3);

        void a(long j, Object obj);
    }

    private static class b {
        public long cLm;
        public long cLn;
        public int cLo;
        public int cLp;
        public List<c> cLq;
        private int cLr = 0;

        public b(long j, long j2, int i) {
            this.cLm = j;
            this.cLn = j2;
            this.cLo = i;
            this.cLp = 0;
        }

        public final boolean a(a aVar, Object obj) {
            if (this.cLq == null) {
                this.cLq = new LinkedList();
            }
            c cVar = new c(aVar, obj);
            if (this.cLq.contains(cVar)) {
                v.d("ModelImage.DownloadImgService.Task", "task item already exists");
                return false;
            }
            this.cLq.add(cVar);
            return true;
        }

        public final boolean b(a aVar) {
            c cVar = new c(aVar, null);
            if (!this.cLq.contains(cVar)) {
                return false;
            }
            this.cLq.remove(cVar);
            return true;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar.cLm == this.cLm && bVar.cLn == this.cLn && bVar.cLo == this.cLo) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.cLr == 0) {
                this.cLr = (this.cLm + "_" + this.cLn + "_" + this.cLo).hashCode();
            }
            return this.cLr;
        }
    }

    private static class c {
        a cLs;
        Object cLt;

        public c(a aVar, Object obj) {
            this.cLs = aVar;
            this.cLt = obj;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            if (this.cLs == ((c) obj).cLs) {
                return true;
            }
            return false;
        }
    }

    public c() {
        ak.vy().a((int) MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM, (e) this);
    }

    public final boolean a(long j, long j2, Object obj, int i, a aVar) {
        return a(j, j2, 0, obj, i, aVar, -1) >= 0;
    }

    public final int a(long j, long j2, int i, Object obj, int i2, a aVar, int i3) {
        if (aVar == null) {
            v.e("ModelImage.DownloadImgService", "listener is null");
            return -1;
        }
        b bVar = new b(j, j2, i);
        bVar.cLp = i2;
        if (this.cLi.contains(bVar)) {
            v.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] add failed, task already done");
            return -2;
        } else if (this.cLj != null && bVar.equals(this.cLj)) {
            return this.cLj.a(aVar, obj) ? 0 : -3;
        } else {
            int indexOf = this.cLh.indexOf(bVar);
            if (indexOf >= 0 && indexOf < this.cLh.size()) {
                return ((b) this.cLh.get(indexOf)).a(aVar, obj) ? 0 : -4;
            } else {
                v.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] no found task, create a new task(" + j + " " + j2 + " " + i + ")");
                bVar.a(aVar, obj);
                this.cLh.add(bVar);
                fu(i3);
                return 0;
            }
        }
    }

    public final boolean a(long j, long j2, int i) {
        b bVar = new b(j, j2, i);
        if ((this.cLj == null || !this.cLj.equals(bVar)) && this.cLh.indexOf(bVar) < 0) {
            return false;
        }
        return true;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            v.e("ModelImage.DownloadImgService", "listener is null");
            return;
        }
        v.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] cancel all tasks of listener");
        this.cLl = true;
        if (this.cLj != null) {
            this.cLj.b(aVar);
            a(this.cLj);
        }
        List<b> linkedList = new LinkedList();
        for (b add : this.cLh) {
            linkedList.add(add);
        }
        for (b add2 : linkedList) {
            add2.b(aVar);
            a(add2);
        }
        Gk();
    }

    public final boolean a(b bVar) {
        if (bVar == null || bVar.cLq.size() > 0) {
            return false;
        }
        return b(bVar);
    }

    public final boolean d(long j, long j2) {
        return b(new b(j, j2, 1));
    }

    final boolean b(b bVar) {
        if (bVar == null) {
            v.e("ModelImage.DownloadImgService", "task is null");
            return false;
        }
        v.i("ModelImage.DownloadImgService", "cancel scene, (" + bVar.cLm + ", " + bVar.cLn + ", " + bVar.cLo + ")");
        if (this.cLj != null && this.cLj.equals(bVar)) {
            ak.vy().c(this.cLk);
            this.cLk = null;
            c(this.cLj);
            this.cLj = null;
            fu(-1);
            return true;
        } else if (!this.cLh.contains(bVar)) {
            return false;
        } else {
            b bVar2 = (b) this.cLh.get(this.cLh.indexOf(bVar));
            if (bVar2 != null) {
                this.cLh.remove(bVar2);
                c(bVar2);
            }
            return true;
        }
    }

    private static void c(b bVar) {
        if (bVar == null) {
            v.e("ModelImage.DownloadImgService", "task is null");
        } else if (bVar.cLq == null) {
            v.e("ModelImage.DownloadImgService", "task callback list is null");
        } else {
            for (c cVar : bVar.cLq) {
                if (cVar.cLs != null) {
                    cVar.cLs.a(bVar.cLm, cVar.cLt);
                }
            }
        }
    }

    public final void Gk() {
        this.cLl = false;
        fu(-1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.cLk != kVar) {
            v.d("ModelImage.DownloadImgService", "scene changed");
            return;
        }
        this.cLi.add(new b(this.cLj.cLm, this.cLj.cLn, this.cLj.cLo));
        v.i("ModelImage.DownloadImgService", "scene end, (" + this.cLj.cLm + ", " + this.cLj.cLn + ", " + this.cLj.cLo + ")");
        for (c cVar : this.cLj.cLq) {
            if (cVar.cLs != null) {
                cVar.cLs.a(this.cLj.cLm, this.cLj.cLn, this.cLj.cLo, cVar.cLt, i, i2);
            }
        }
        this.cLj = null;
        this.cLk = null;
        fu(-1);
    }

    public final void a(int i, int i2, k kVar) {
        if (this.cLk != kVar) {
            v.d("ModelImage.DownloadImgService", "scene changed");
            return;
        }
        for (c cVar : this.cLj.cLq) {
            if (cVar.cLs != null) {
                cVar.cLs.a(this.cLj.cLm, this.cLj.cLo, this.cLj.cLp, cVar.cLt, i, i2, kVar);
            }
        }
    }

    private void fu(int i) {
        if (this.cLj == null && this.cLh.size() > 0 && true != this.cLl) {
            this.cLj = (b) this.cLh.get(0);
            this.cLh.remove(0);
            this.cLk = new j(this.cLj.cLm, this.cLj.cLn, this.cLj.cLo, this, i);
            this.cLk.cMY = this.cLj.cLp;
            v.i("ModelImage.DownloadImgService", "do scene, (" + this.cLj.cLm + ", " + this.cLj.cLn + ", " + this.cLj.cLo + ")");
            ak.vy().a(this.cLk, 0);
        }
    }
}
