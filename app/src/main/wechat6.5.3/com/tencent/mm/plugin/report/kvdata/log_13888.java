package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.ba.a;

public class log_13888 extends a {
    public String aid_;
    public int clientVersion_;
    public int device_;
    public int ds_;
    public int f_;
    public int ff_;
    public int import_ds_;
    public int ps_;
    public String sid_;
    public long time_stamp_;
    public int tsf_;
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
            if (this.aid_ != null) {
                aVar.e(7, this.aid_);
            }
            aVar.dV(8, this.f_);
            aVar.dV(9, this.tsf_);
            aVar.dV(10, this.ff_);
            if (this.sid_ != null) {
                aVar.e(11, this.sid_);
            }
            aVar.dV(12, this.ps_);
            return 0;
        } else if (i == 1) {
            r0 = (((((a.a.a.a.dS(1, this.import_ds_) + 0) + a.a.a.a.dS(2, this.ds_)) + a.a.a.a.B(3, this.uin_)) + a.a.a.a.dS(4, this.device_)) + a.a.a.a.dS(5, this.clientVersion_)) + a.a.a.a.B(6, this.time_stamp_);
            if (this.aid_ != null) {
                r0 += a.a.a.b.b.a.f(7, this.aid_);
            }
            r0 = ((r0 + a.a.a.a.dS(8, this.f_)) + a.a.a.a.dS(9, this.tsf_)) + a.a.a.a.dS(10, this.ff_);
            if (this.sid_ != null) {
                r0 += a.a.a.b.b.a.f(11, this.sid_);
            }
            return r0 + a.a.a.a.dS(12, this.ps_);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            log_13888 com_tencent_mm_plugin_report_kvdata_log_13888 = (log_13888) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_plugin_report_kvdata_log_13888.import_ds_ = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_plugin_report_kvdata_log_13888.ds_ = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_plugin_report_kvdata_log_13888.uin_ = aVar3.pMj.mI();
                    return 0;
                case 4:
                    com_tencent_mm_plugin_report_kvdata_log_13888.device_ = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_plugin_report_kvdata_log_13888.clientVersion_ = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_plugin_report_kvdata_log_13888.time_stamp_ = aVar3.pMj.mI();
                    return 0;
                case 7:
                    com_tencent_mm_plugin_report_kvdata_log_13888.aid_ = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_plugin_report_kvdata_log_13888.f_ = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_plugin_report_kvdata_log_13888.tsf_ = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_plugin_report_kvdata_log_13888.ff_ = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_plugin_report_kvdata_log_13888.sid_ = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_plugin_report_kvdata_log_13888.ps_ = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
