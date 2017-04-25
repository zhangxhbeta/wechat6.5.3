package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.ba.a;

public class log_13532 extends a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public int import_ds_;
    public long time_stamp_;
    public int type;
    public long uin_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.import_ds_);
            aVar.dV(2, this.ds_);
            aVar.C(3, this.uin_);
            aVar.dV(4, this.device_);
            aVar.dV(5, this.clientVersion_);
            aVar.C(6, this.time_stamp_);
            aVar.dV(7, this.type);
            return 0;
        } else if (i == 1) {
            return ((((((a.a.a.a.dS(1, this.import_ds_) + 0) + a.a.a.a.dS(2, this.ds_)) + a.a.a.a.B(3, this.uin_)) + a.a.a.a.dS(4, this.device_)) + a.a.a.a.dS(5, this.clientVersion_)) + a.a.a.a.B(6, this.time_stamp_)) + a.a.a.a.dS(7, this.type);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                log_13532 com_tencent_mm_plugin_report_kvdata_log_13532 = (log_13532) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_plugin_report_kvdata_log_13532.import_ds_ = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        com_tencent_mm_plugin_report_kvdata_log_13532.ds_ = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        com_tencent_mm_plugin_report_kvdata_log_13532.uin_ = aVar3.pMj.mI();
                        return 0;
                    case 4:
                        com_tencent_mm_plugin_report_kvdata_log_13532.device_ = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        com_tencent_mm_plugin_report_kvdata_log_13532.clientVersion_ = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        com_tencent_mm_plugin_report_kvdata_log_13532.time_stamp_ = aVar3.pMj.mI();
                        return 0;
                    case 7:
                        com_tencent_mm_plugin_report_kvdata_log_13532.type = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
