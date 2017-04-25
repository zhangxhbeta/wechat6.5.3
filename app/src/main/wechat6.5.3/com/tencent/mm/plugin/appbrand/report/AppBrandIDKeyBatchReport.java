package com.tencent.mm.plugin.appbrand.report;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.aqk;
import com.tencent.mm.protocal.c.bjb;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class AppBrandIDKeyBatchReport {
    private static IDKeyBatchReportTask dPw;

    public static class IDKeyBatchReportTask extends MainProcessTask {
        public static final Creator<IDKeyBatchReportTask> CREATOR = new Creator<IDKeyBatchReportTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new IDKeyBatchReportTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IDKeyBatchReportTask[i];
            }
        };
        private static ReentrantReadWriteLock cXO = new ReentrantReadWriteLock();
        private static ah dPx = null;
        private static ah dPy = null;
        String aWP;
        String aZh;
        String aZj;
        String appId;
        int dJB;
        int dLp;
        int dPA;
        String dPB;
        int dPC;
        public int dPz;
        String id;
        int key;
        int type;
        int value;

        public interface a {
            void hm(int i);

            void r(LinkedList<bje> linkedList);
        }

        public IDKeyBatchReportTask(Parcel parcel) {
            f(parcel);
        }

        public final void OL() {
            a anonymousClass1 = new a(this) {
                final /* synthetic */ IDKeyBatchReportTask dPD;

                {
                    this.dPD = r1;
                }

                public final void hm(int i) {
                    this.dPD.dPA = i;
                    this.dPD.a(i, (a) this);
                    v.d("MicroMsg.AppBrandIDKeyBatchReport", "onSuccess !");
                }

                public final void r(LinkedList<bje> linkedList) {
                    if (!be.bP(linkedList)) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            this.dPD.a((bje) it.next());
                        }
                    }
                    v.e("MicroMsg.AppBrandIDKeyBatchReport", "onFailure !");
                }
            };
            if (1 == this.dPz) {
                a(0, anonymousClass1);
                a(anonymousClass1);
            } else if (2 == this.dPz) {
                RE();
            } else if (3 == this.dPz) {
                v.d("MicroMsg.AppBrandIDKeyBatchReport", "write type %s, appId %s, id %s, key %s, value %s, ext %s, appState %s, sceneNote %s", new Object[]{Integer.valueOf(this.type), this.appId, this.id, Integer.valueOf(this.key), Integer.valueOf(this.value), this.aZh, Integer.valueOf(this.dJB), this.aWP});
                bje com_tencent_mm_protocal_c_bje = new bje();
                com_tencent_mm_protocal_c_bje.efm = this.type;
                com_tencent_mm_protocal_c_bje.glj = this.appId;
                com_tencent_mm_protocal_c_bje.ndB = this.id;
                com_tencent_mm_protocal_c_bje.itH = this.key;
                com_tencent_mm_protocal_c_bje.fvO = (int) be.Nh();
                com_tencent_mm_protocal_c_bje.itI = this.value;
                com_tencent_mm_protocal_c_bje.ndC = this.aZh;
                com_tencent_mm_protocal_c_bje.ndt = this.dJB;
                com_tencent_mm_protocal_c_bje.ndD = this.aZj;
                com_tencent_mm_protocal_c_bje.ndE = this.dPB;
                com_tencent_mm_protocal_c_bje.ndF = this.dLp;
                com_tencent_mm_protocal_c_bje.ndG = this.dPC;
                com_tencent_mm_protocal_c_bje.ndH = this.aWP;
                a(com_tencent_mm_protocal_c_bje);
            }
        }

        public final void f(Parcel parcel) {
            this.dPz = parcel.readInt();
            this.dPA = parcel.readInt();
            this.type = parcel.readInt();
            this.appId = parcel.readString();
            this.id = parcel.readString();
            this.key = parcel.readInt();
            this.value = parcel.readInt();
            this.aZh = parcel.readString();
            this.dJB = parcel.readInt();
            this.aZj = parcel.readString();
            this.dPB = parcel.readString();
            this.dLp = parcel.readInt();
            this.dPC = parcel.readInt();
            this.aWP = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dPz);
            parcel.writeInt(this.dPA);
            parcel.writeInt(this.type);
            parcel.writeString(this.appId);
            parcel.writeString(this.id);
            parcel.writeInt(this.key);
            parcel.writeInt(this.value);
            parcel.writeString(this.aZh);
            parcel.writeInt(this.dJB);
            parcel.writeString(this.aZj);
            parcel.writeString(this.dPB);
            parcel.writeInt(this.dLp);
            parcel.writeInt(this.dPC);
            parcel.writeString(this.aWP);
        }

        private static void RE() {
            if (dPx != null) {
                dPx.QI();
                dPx = null;
            }
        }

        private void a(int i, final a aVar) {
            int i2 = 60000;
            if (i > 0) {
                i2 = 60000 * i;
            }
            RE();
            ah ahVar = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ IDKeyBatchReportTask dPD;

                public final boolean oU() {
                    v.d("MicroMsg.AppBrandIDKeyBatchReport", "startReport run in TimerTask!");
                    this.dPD.a(aVar);
                    return true;
                }
            }, true);
            dPx = ahVar;
            ahVar.ea((long) i2);
        }

        private void a(final a aVar) {
            final LinkedList RF = RF();
            if (!be.bP(RF)) {
                aqk com_tencent_mm_protocal_c_aqk = new aqk();
                com_tencent_mm_protocal_c_aqk.efb = Build.MANUFACTURER;
                com_tencent_mm_protocal_c_aqk.mPI = 2;
                com_tencent_mm_protocal_c_aqk.mio = d.lWb;
                com_tencent_mm_protocal_c_aqk.mip = d.lWa;
                com_tencent_mm_protocal_c_aqk.iZX = aa.getResources().getDisplayMetrics().widthPixels;
                com_tencent_mm_protocal_c_aqk.mPJ = aa.getResources().getDisplayMetrics().heightPixels;
                com_tencent_mm_protocal_c_aqk.miq = d.lWd;
                com_tencent_mm_protocal_c_aqk.mir = d.lWe;
                com_tencent_mm_protocal_c_aqk.mPK = aa.getResources().getConfiguration().locale.getLanguage();
                ak.vy().a(new com.tencent.mm.plugin.appbrand.netscene.a(RF, com_tencent_mm_protocal_c_aqk, new com.tencent.mm.plugin.appbrand.netscene.a.a<com.tencent.mm.plugin.appbrand.netscene.a>(this) {
                    final /* synthetic */ IDKeyBatchReportTask dPD;

                    public final /* synthetic */ void c(int i, int i2, String str, k kVar) {
                        com.tencent.mm.plugin.appbrand.netscene.a aVar = (com.tencent.mm.plugin.appbrand.netscene.a) kVar;
                        v.d("MicroMsg.AppBrandIDKeyBatchReport", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i != 0 || i2 != 0) {
                            aVar.r(RF);
                        } else if (aVar instanceof com.tencent.mm.plugin.appbrand.netscene.a) {
                            v.d("MicroMsg.AppBrandIDKeyBatchReport", "resp reportFreq %d", new Object[]{Integer.valueOf((aVar.cif == null ? null : (bjb) aVar.cif.czl.czs).nds)});
                            aVar.hm(r0);
                        }
                    }
                }), 0);
                int i = this.dPA;
                i = i <= 0 ? 300000 : (i + 5) * 60000;
                if (dPy != null) {
                    dPy.QI();
                    dPy = null;
                }
                ah ahVar = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
                    final /* synthetic */ IDKeyBatchReportTask dPD;

                    {
                        this.dPD = r1;
                    }

                    public final boolean oU() {
                        IDKeyBatchReportTask.RE();
                        v.d("MicroMsg.AppBrandIDKeyBatchReport", "on timer expired in monitor timer!");
                        return true;
                    }
                }, false);
                dPy = ahVar;
                ahVar.ea((long) i);
            }
        }

        private synchronized LinkedList<bje> RF() {
            LinkedList<bje> linkedList;
            int i = 0;
            synchronized (this) {
                File file = new File(RH());
                if (file.exists()) {
                    LinkedList<bje> linkedList2 = new LinkedList();
                    long length = file.length();
                    cXO.readLock().lock();
                    do {
                        int i2 = i;
                        try {
                            int readInt = new DataInputStream(new ByteArrayInputStream(e.c(RH(), i2, 4))).readInt();
                            linkedList2.add((bje) new bje().az(e.c(RH(), i2 + 4, readInt)));
                            i = (readInt + 4) + i2;
                        } catch (Throwable e) {
                            v.e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", new Object[]{e.getMessage()});
                            v.a("MicroMsg.AppBrandIDKeyBatchReport", e, "", new Object[0]);
                            RG();
                            cXO.readLock().unlock();
                        } catch (Throwable th) {
                            RG();
                            cXO.readLock().unlock();
                        }
                    } while (((long) i) < length);
                    RG();
                    cXO.readLock().unlock();
                    linkedList = linkedList2;
                } else {
                    v.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
                    linkedList = null;
                }
            }
            return linkedList;
        }

        private static void RG() {
            File file = new File(RH());
            if (file.exists()) {
                v.d("MicroMsg.AppBrandIDKeyBatchReport", "delete file!");
                file.delete();
            }
        }

        public final synchronized void a(bje com_tencent_mm_protocal_c_bje) {
            cXO.writeLock().lock();
            try {
                byte[] toByteArray = com_tencent_mm_protocal_c_bje.toByteArray();
                File file = new File(RI());
                if (!file.exists()) {
                    file.mkdir();
                }
                file = new File(RH());
                if (!file.exists()) {
                    file.createNewFile();
                }
                int length = toByteArray.length;
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new DataOutputStream(byteArrayOutputStream).writeInt(length);
                e.e(RH(), byteArrayOutputStream.toByteArray());
                e.e(RH(), toByteArray);
                cXO.writeLock().unlock();
            } catch (Throwable e) {
                v.e("MicroMsg.AppBrandIDKeyBatchReport", "appendToFile exception:%s", new Object[]{e.getMessage()});
                v.a("MicroMsg.AppBrandIDKeyBatchReport", e, "", new Object[0]);
                cXO.writeLock().unlock();
            } catch (Throwable th) {
                cXO.writeLock().unlock();
            }
        }

        private static String RH() {
            return RI() + "WxaAppRecord";
        }

        private static String RI() {
            ak.yW();
            String xp = c.xp();
            if (!xp.endsWith("/")) {
                xp = xp + "/";
            }
            xp = xp + "appbrand/report/";
            h.JX(xp);
            return xp;
        }
    }

    public static IDKeyBatchReportTask RD() {
        if (dPw == null) {
            dPw = new IDKeyBatchReportTask();
        }
        return dPw;
    }

    public static void a(int i, String str, String str2, int i2, String str3, String str4) {
        String str5 = "";
        if (!be.kS(str2) && str2.contains(".html")) {
            str5 = str2.substring(0, str2.lastIndexOf(".html") + 5);
        }
        RD().type = i;
        RD().appId = be.ma(str);
        RD().id = str5;
        RD().key = 0;
        RD().value = i2;
        RD().aZh = be.ma(str3);
        RD().aWP = str4;
        AppBrandStatObject ms = a.ms(str);
        if (ms != null) {
            RD().aZj = ms.aZj;
            RD().dPB = ms.dPB;
            RD().dLp = ms.scene;
            RD().dPC = ms.dPC;
        }
        AppBrandSysConfig mr = a.mr(str);
        if (mr != null) {
            RD().dJB = mr.dDB.dBr + 1;
        }
        RD().dPz = 3;
        AppBrandMainProcessService.a(RD());
    }
}
