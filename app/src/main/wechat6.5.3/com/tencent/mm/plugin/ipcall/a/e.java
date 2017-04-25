package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.e.a.ar;
import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Map;

public final class e {
    private static e gEG = null;
    public ArrayList<f> gEH = null;
    c gEI = new c<ar>(this) {
        final /* synthetic */ e gEJ;

        {
            this.gEJ = r2;
            this.nhz = ar.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ar arVar = (ar) bVar;
            if (arVar.aYn.aYo == 39) {
                v.i("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener callback");
                byte[] d = com.tencent.mm.a.e.d(arVar.aYn.filePath, 0, -1);
                if (d != null) {
                    this.gEJ.at(d);
                } else {
                    v.e("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener file not exist");
                }
            }
            return false;
        }
    };

    private e() {
    }

    public static e auf() {
        if (gEG == null) {
            gEG = new e();
        }
        return gEG;
    }

    public final boolean at(byte[] bArr) {
        try {
            try {
                Map q = bf.q(new String(bArr), "feedbackconfig");
                if (q != null) {
                    String str = ".feedbackconfig.resourceslist.resources";
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        String str2 = str + (i == 0 ? "" : Integer.valueOf(i));
                        String str3 = (String) q.get(str2 + ".$langid");
                        if (str3 != null) {
                            int i2 = i + 1;
                            f fVar = new f();
                            fVar.gIF = str3;
                            fVar.gIG = new ArrayList();
                            String str4 = str2 + ".string";
                            int i3 = 0;
                            while (true) {
                                com.tencent.mm.plugin.ipcall.a.g.e eVar = new com.tencent.mm.plugin.ipcall.a.g.e();
                                String str5 = str4 + (i3 == 0 ? "" : Integer.valueOf(i3));
                                str3 = (String) q.get(str5);
                                if (str3 == null) {
                                    break;
                                }
                                str5 = (String) q.get(str5 + ".$id");
                                if (str5 == null) {
                                    break;
                                }
                                i3++;
                                eVar.gID = str5;
                                eVar.gIE = str3;
                                fVar.gIG.add(eVar);
                            }
                            v.d("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse id:%s,wording count:%d", new Object[]{fVar.gIF, Integer.valueOf(fVar.gIG.size())});
                            arrayList.add(fVar);
                            i = i2;
                        } else {
                            v.i("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse finished count:%d", new Object[]{Integer.valueOf(arrayList.size())});
                            this.gEH = arrayList;
                            return true;
                        }
                    }
                }
                v.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse xml feedbackconfig error");
                return false;
            } catch (Throwable e) {
                v.a("MicroMsg.IPCallFeedbackConfigUpdater", e, "", new Object[0]);
                v.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config error: %s", new Object[]{e.getMessage()});
                return false;
            }
        } catch (Throwable e2) {
            v.a("MicroMsg.IPCallFeedbackConfigUpdater", e2, "", new Object[0]);
            v.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config new string error: %s", new Object[]{e2.getMessage()});
            return false;
        }
    }
}
