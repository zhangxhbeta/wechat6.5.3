package com.tencent.mm.plugin.shake.b;

import android.os.Message;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.List;

public final class j {
    protected static long iOj = 16000;
    protected static int iOk = 54158;
    public int iOl;
    public b iOm;

    public interface a {
        void a(int i, e eVar, long j);

        void d(List<d> list, long j);
    }

    public static abstract class b {
        public a iOn;
        protected boolean iOo = false;
        protected long iOp = j.iOj;
        private ac iOq = new ac(new com.tencent.mm.sdk.platformtools.ac.a(this) {
            final /* synthetic */ b iOr;

            {
                this.iOr = r1;
            }

            public final boolean handleMessage(Message message) {
                if (!(message.what != j.iOk || this.iOr.iOo || this.iOr.iOn == null)) {
                    this.iOr.iOn.d(null, 5);
                }
                return false;
            }
        });

        public abstract void init();

        public abstract void pause();

        public abstract void reset();

        public abstract void resume();

        public abstract void start();

        public b(a aVar) {
            this.iOn = aVar;
        }

        public void aNB() {
            reset();
            this.iOn = null;
        }
    }
}
