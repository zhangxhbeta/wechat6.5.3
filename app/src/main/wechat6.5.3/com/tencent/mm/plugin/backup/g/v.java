package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class v {
    LinkedList<a> ejM = new LinkedList();
    ac handler = new ac(Looper.getMainLooper());

    class a {
        final /* synthetic */ v ejO;
        public Object obj;
        public int type;

        public a(v vVar, int i, Object obj) {
            this.ejO = vVar;
            this.type = i;
            this.obj = obj;
        }
    }

    public final String Wb() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.ejM.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                stringBuffer.append(aVar.type + " : " + ((String) aVar.obj) + " ,");
            } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                stringBuffer.append(aVar.type + " : " + ((String) aVar.obj) + " ,");
            }
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.RecoverDelayData", "dump delay " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    public final boolean b(final int i, final Object obj) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ v ejO;

            public final void run() {
                this.ejO.ejM.add(new a(this.ejO, i, obj));
            }
        });
        return true;
    }
}
