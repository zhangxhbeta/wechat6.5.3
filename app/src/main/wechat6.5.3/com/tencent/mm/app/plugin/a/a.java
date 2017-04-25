package com.tencent.mm.app.plugin.a;

import com.tencent.mm.e.a.dc;
import com.tencent.mm.e.a.hu;
import com.tencent.mm.e.a.jk;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public com.tencent.mm.ui.chatting.ChattingUI.a aSD;
    public a aSE;
    private String aSF;
    public Map<String, Boolean> aSG;

    class a extends c<jk> {
        final /* synthetic */ a aSI;

        a(a aVar) {
            this.aSI = aVar;
            this.nhz = jk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jk jkVar = (jk) bVar;
            if (this.aSI.aSD != null) {
                if (!this.aSI.aSD.isFinishing()) {
                    int i = jkVar.bjP.op;
                    String str = jkVar.bjP.bhG;
                    v.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "opcode is %d, brand name is %s", Integer.valueOf(i), str);
                    if (this.aSI.aSD.bEn().equals(str)) {
                        switch (i) {
                            case 1:
                                a aVar = this.aSI;
                                v.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "handleConnectFailedReason, reason : %d, brand name : %s", Integer.valueOf(jkVar.bjP.bhB), str);
                                BizInfo hw = e.hw(str);
                                if (a.a(hw)) {
                                    if (hw.aX(false).CR().cCc == 1) {
                                        aVar.aSD.NY(null);
                                        break;
                                    }
                                }
                                v.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", str);
                                break;
                                break;
                            case 2:
                                this.aSI.d(jkVar.bjP.baO, str, jkVar.bjP.aRh);
                                break;
                            case 3:
                                if (this.aSI.aSG != null) {
                                    this.aSI.aSG.clear();
                                    v.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "clear connected device ids successfully.");
                                    break;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    v.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "not current brandname");
                } else {
                    v.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context isFinishing");
                }
            } else {
                v.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context == null");
            }
            return false;
        }
    }

    public a(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        v.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
        this.aSD = aVar;
        if (this.aSE == null) {
            this.aSE = new a(this);
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.aSE);
    }

    final synchronized void d(int i, String str, String str2) {
        v.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", Integer.valueOf(i));
        if (this.aSD != null && !be.kS(str)) {
            BizInfo hw = e.hw(str);
            if (a(hw)) {
                if (this.aSG == null) {
                    this.aSG = new HashMap();
                }
                Map map = this.aSG;
                if (!str.equals(this.aSF)) {
                    this.aSF = str;
                    map.clear();
                }
                if (hw.aX(false).CR().cCc != 1) {
                    v.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", map, str2);
                    switch (i) {
                        case -1:
                            this.aSD.NY(null);
                            break;
                        case 0:
                            if (map.size() == 0) {
                                this.aSD.vE(2131232537);
                                break;
                            }
                            break;
                        case 1:
                            if (map.size() == 0) {
                                this.aSD.vE(2131232536);
                                break;
                            }
                            break;
                        case 2:
                            map.put(str2, Boolean.valueOf(true));
                            this.aSD.NY(this.aSD.getString(2131232535, Integer.valueOf(map.size())));
                            v.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", str2);
                            break;
                        case 4:
                            if (map.remove(str2) != null) {
                                v.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", str2);
                            }
                            this.aSD.NY(this.aSD.getString(2131232535, Integer.valueOf(map.size())));
                            break;
                        default:
                            break;
                    }
                }
                this.aSD.NY(null);
            } else {
                v.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", str);
            }
        } else {
            v.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
        }
    }

    public final void a(final int i, BizInfo bizInfo) {
        if (this.aSD == null) {
            v.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
        } else if (m.eD(this.aSD.bEn()) && a(bizInfo)) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ a aSI;

                public final void run() {
                    b dcVar;
                    if (1 == i) {
                        dcVar = new dc();
                        dcVar.bbb.op = 0;
                        dcVar.bbb.userName = this.aSI.aSD.bEn();
                        dcVar.bbb.context = this.aSI.aSD.nDR.nEl;
                        com.tencent.mm.sdk.c.a.nhr.z(dcVar);
                    }
                    dcVar = new hu();
                    dcVar.bhF.opType = i;
                    dcVar.bhF.bhH = 1;
                    dcVar.bhF.bhG = this.aSI.aSD.bEn();
                    com.tencent.mm.sdk.c.a.nhr.z(dcVar);
                }
            });
        }
    }

    public static boolean a(BizInfo bizInfo) {
        if (bizInfo == null || bizInfo == null) {
            return false;
        }
        ExtInfo aX = bizInfo.aX(false);
        if (aX == null || aX.CR() == null || !aX.CR().Da()) {
            return false;
        }
        return true;
    }
}
