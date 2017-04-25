package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.util.ArrayList;
import java.util.Iterator;

public final class g {
    boolean oBv;
    ArrayList<b> oBw;
    ArrayList<at> ozS;

    private static final class a {
        private static final g oBx = new g();
    }

    public interface b {
        void bGC();

        void clear();
    }

    private g() {
        this.ozS = new ArrayList();
        this.oBv = false;
        this.oBw = new ArrayList();
    }

    public final void aX(at atVar) {
        if (atVar != null) {
            v.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", Long.valueOf(atVar.field_msgId));
            this.ozS.remove(atVar);
            this.ozS.remove(eC(atVar.field_msgId));
            this.ozS.add(atVar);
            bGD();
        }
    }

    private at eC(long j) {
        Iterator it = this.ozS.iterator();
        while (it.hasNext()) {
            at atVar = (at) it.next();
            if (atVar.field_msgId == j) {
                return atVar;
            }
        }
        return null;
    }

    public final void aY(at atVar) {
        if (atVar != null) {
            v.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", Long.valueOf(atVar.field_msgId));
            this.ozS.remove(atVar);
            this.ozS.remove(eC(atVar.field_msgId));
            bGD();
        }
    }

    public final void clear() {
        v.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
        this.ozS.clear();
        Iterator it = this.oBw.iterator();
        while (it.hasNext()) {
            ((b) it.next()).clear();
        }
    }

    public final void detach() {
        this.oBw.clear();
        clear();
        this.oBv = false;
    }

    public final boolean aZ(at atVar) {
        if (atVar == null) {
            return false;
        }
        Iterator it = this.ozS.iterator();
        while (it.hasNext()) {
            if (((at) it.next()).field_msgId == atVar.field_msgId) {
                return true;
            }
        }
        return false;
    }

    private void bGD() {
        Iterator it = this.oBw.iterator();
        while (it.hasNext()) {
            ((b) it.next()).bGC();
        }
    }
}
