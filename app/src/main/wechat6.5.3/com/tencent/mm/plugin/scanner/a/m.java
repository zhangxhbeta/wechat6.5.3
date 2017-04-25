package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.e.a.ae;
import com.tencent.mm.e.a.kt;
import com.tencent.mm.e.a.ku;
import com.tencent.mm.e.a.kv;
import com.tencent.mm.plugin.g.a.b.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class m {
    public c iww = new c<kt>(this) {
        final /* synthetic */ m iwz;

        {
            this.iwz = r2;
            this.nhz = kt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return this.iwz.v((kt) bVar);
        }
    };
    public c iwx = new c<ae>(this) {
        final /* synthetic */ m iwz;

        {
            this.iwz = r2;
            this.nhz = ae.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return this.iwz.v((ae) bVar);
        }
    };
    a iwy = new a(this) {
        final /* synthetic */ m iwz;

        {
            this.iwz = r1;
        }

        public final void g(String str, String str2, int i, int i2) {
            v.i("MicroMsg.RecogQBarOfImageFileListener", "result: %s, codeType: %s, codeVersion: %s, filePath:%s", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(i2), str});
            l.iwj.auO();
            kv kvVar = new kv();
            kvVar.bme.filePath = str;
            kvVar.bme.bfz = str2;
            kvVar.bme.aYV = i;
            kvVar.bme.aYW = i2;
            com.tencent.mm.sdk.c.a.nhr.z(kvVar);
        }

        public final void yo(String str) {
            v.i("MicroMsg.RecogQBarOfImageFileListener", "result(failed): %s", new Object[]{str});
            ku kuVar = new ku();
            kuVar.bmd.filePath = str;
            com.tencent.mm.sdk.c.a.nhr.z(kuVar);
        }
    };

    public final boolean v(b bVar) {
        if (bVar != null) {
            if (bVar instanceof kt) {
                l.iwj.reset();
                l.iwj.oW(l.iwi);
                com.tencent.mm.plugin.scanner.b.aKP().ivv.a(((kt) bVar).bmc.filePath, this.iwy);
            } else if (bVar instanceof ae) {
                l.iwj.auO();
                ae aeVar = (ae) bVar;
                com.tencent.mm.plugin.g.a.b bVar2 = com.tencent.mm.plugin.scanner.b.aKP().ivv;
                String str = aeVar.aXI.filePath;
                v.i("MicroMsg.FileScanQueueService", "cancelDecode, fileUri: %s, callback: %x", new Object[]{str, Integer.valueOf(this.iwy.hashCode())});
                if (be.kS(str)) {
                    v.e("MicroMsg.FileScanQueueService", "cancel failed, uri is null or nil");
                } else {
                    bVar2.ihw.post(new com.tencent.mm.plugin.g.a.b.AnonymousClass2(bVar2, str, r2));
                }
            }
        }
        return false;
    }
}
