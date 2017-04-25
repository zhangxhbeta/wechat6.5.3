package com.tencent.mm.modelbiz;

import android.graphics.Bitmap;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.protocal.c.gr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.d;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.k;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    public interface a {
        void a(boolean z, String str);
    }

    static boolean b(BizInfo bizInfo) {
        if (bizInfo == null) {
            v.i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
            return false;
        } else if (!Cq()) {
            return false;
        } else {
            int i = j.sU().getInt("MMBizAttrSyncFreq", -1);
            if (i == -1) {
                v.i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
                i = 3600;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = bizInfo.field_incrementUpdateTime;
            String str = bizInfo.field_attrSyncVersion;
            v.i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", Long.valueOf(currentTimeMillis), Long.valueOf(j), Integer.valueOf(i), str);
            return currentTimeMillis - j >= ((long) (i * 1000));
        }
    }

    public static boolean Cq() {
        int i;
        ak.yW();
        Object obj = c.vf().get(com.tencent.mm.storage.t.a.USERINFO_BIZ_ATTR_SYNC_OPEN_FLAG_INT, null);
        if (obj == null || !(obj instanceof Integer)) {
            v.i("MicroMsg.BizAttrRenovator", "openFlag is null.");
            i = 1;
        } else {
            i = ((Integer) obj).intValue();
        }
        v.i("MicroMsg.BizAttrRenovator", "openFlag is %d.", Integer.valueOf(i));
        if (i == 1) {
            return true;
        }
        return false;
    }

    public final boolean a(final String str, a aVar) {
        v.d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
        BizInfo ho = u.Dy().ho(str);
        if (b(ho)) {
            final WeakReference weakReference = new WeakReference(aVar);
            ak.vy().a(new m(str, ho.field_attrSyncVersion, new com.tencent.mm.modelbiz.m.a<m>(this) {
                final /* synthetic */ a cBf;

                public final /* synthetic */ void c(int i, int i2, String str, k kVar) {
                    m mVar = (m) kVar;
                    v.i("MicroMsg.BizAttrRenovator", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
                    a aVar = weakReference != null ? (a) weakReference.get() : null;
                    if (mVar == null) {
                        v.e("MicroMsg.BizAttrRenovator", "scene == null");
                        if (aVar != null) {
                            aVar.a(false, str);
                        }
                    } else if (i == 0 && i2 == 0) {
                        gq gqVar = (mVar.cif == null || mVar.cif.czl.czs == null) ? null : (gq) mVar.cif.czl.czs;
                        if (gqVar == null) {
                            v.e("MicroMsg.BizAttrRenovator", "resp is null.");
                            if (aVar != null) {
                                aVar.a(false, str);
                                return;
                            }
                            return;
                        }
                        String str2 = "MicroMsg.BizAttrRenovator";
                        String str3 = "[BizAttr] biz(%s) Attribute LastAttrVersion = %s, UpdateInfoList.size = %s";
                        Object[] objArr = new Object[3];
                        objArr[0] = str;
                        objArr[1] = gqVar.mhA == null ? null : new String(gqVar.mhA.lVU);
                        objArr[2] = Integer.valueOf(gqVar.mhB == null ? 0 : gqVar.mhB.size());
                        v.i(str2, str3, objArr);
                        if (gqVar.mhB == null) {
                            v.e("MicroMsg.BizAttrRenovator", "[BizAttr] resp.UpdateInfoList null");
                            if (aVar != null) {
                                aVar.a(false, str);
                                return;
                            }
                            return;
                        }
                        boolean z;
                        String str4 = str;
                        List list = gqVar.mhB;
                        if (be.kS(str4)) {
                            v.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, username is null.");
                            z = false;
                        } else {
                            BizInfo ho = u.Dy().ho(str4);
                            if (a.b(ho)) {
                                ak.yW();
                                ab LX = c.wH().LX(str4);
                                if (LX == null || ((int) LX.chr) == 0 || !LX.bvm()) {
                                    v.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact do not exist.(username : %s)", str4);
                                    z = false;
                                } else {
                                    if (be.kS(LX.field_username)) {
                                        LX.setUsername(str4);
                                    }
                                    z = a.a(LX, ho, list);
                                }
                            } else {
                                v.i("MicroMsg.BizAttrRenovator", "Do not need to update bizAttrs now.(username : %s)", str4);
                                z = false;
                            }
                        }
                        if (!z) {
                            v.i("MicroMsg.BizAttrRenovator", "notifyDataSetChanged, after updateBizAttributes.");
                            if (aVar != null) {
                                aVar.a(false, str);
                            }
                        }
                        if (gqVar.mhA != null) {
                            z = (be.kS(str) || be.kS(be.bn(gqVar.mhA.lVU))) ? false : u.Dy().dF("BizInfo", String.format("update %s set %s='%s', %s=%d where %s='%s'", new Object[]{"BizInfo", "attrSyncVersion", be.bn(gqVar.mhA.lVU), "incrementUpdateTime", Long.valueOf(System.currentTimeMillis()), "username", str}));
                            v.i("MicroMsg.BizAttrRenovator", "Update attrSyncVersion of bizInfo succ = %b.", Boolean.valueOf(z));
                        }
                        if (aVar != null) {
                            aVar.a(true, str);
                        }
                    } else {
                        v.e("MicroMsg.BizAttrRenovator", "scene.getType() = %s", Integer.valueOf(mVar.getType()));
                        if (aVar != null) {
                            aVar.a(false, str);
                        }
                    }
                }
            }), 0);
            return true;
        }
        v.i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
        return false;
    }

    public static boolean a(u uVar, BizInfo bizInfo, List<gr> list) {
        if (uVar == null || list == null || list.size() == 0) {
            v.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed.");
            return false;
        }
        String str = uVar.field_username;
        if (uVar.bvm()) {
            if (bizInfo == null) {
                bizInfo = u.Dy().ho(str);
            }
            if (bizInfo == null) {
                v.i("MicroMsg.BizAttrRenovator", "BizInfo is null.(username : %s)", str);
                return false;
            }
            JSONObject jSONObject;
            h gQ = n.Bo().gQ(str);
            try {
                if (be.kS(bizInfo.field_extInfo)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(bizInfo.field_extInfo);
                }
            } catch (Exception e) {
                v.e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", e);
                jSONObject = new JSONObject();
            }
            long j = -1;
            long j2 = (long) uVar.field_type;
            int i = 0;
            Object obj = null;
            for (gr grVar : list) {
                if (grVar == null) {
                    v.w("MicroMsg.BizAttrRenovator", "keyValue is null.");
                } else {
                    Object obj2;
                    int i2;
                    String str2 = grVar.mhC;
                    v.i("MicroMsg.BizAttrRenovator", "[BizAttr] UpdateInfoList key = %s, value = %s", str2, grVar.itR);
                    String str3 = grVar.itR;
                    if (!"UserName".equals(str2)) {
                        if ("NickName".equals(str2)) {
                            uVar.bS(str3);
                        } else if ("Alias".equals(str2)) {
                            uVar.bP(str3);
                        } else if ("PYInitial".equals(str2)) {
                            uVar.bT(str3);
                        } else if ("QuanPin".equals(str2)) {
                            uVar.bU(str3);
                        } else if ("VerifyFlag".equals(str2)) {
                            uVar.cR(be.getInt(str3, uVar.field_verifyFlag));
                        } else if ("VerifyInfo".equals(str2)) {
                            uVar.ck(str3);
                        } else if ("Signature".equals(str2)) {
                            uVar.cf(str3);
                        } else {
                            obj2 = null;
                            if (obj2 == null && !c(jSONObject, str2, grVar.itR)) {
                                str3 = grVar.itR;
                                if ("BrandInfo".equals(str2)) {
                                    bizInfo.field_brandInfo = str3;
                                } else if ("BrandIconURL".equals(str2)) {
                                    bizInfo.field_brandIconURL = str3;
                                } else if ("BrandFlag".equals(str2)) {
                                    obj2 = null;
                                    if (obj2 == null) {
                                        str3 = grVar.itR;
                                        if ("BigHeadImgUrl".equals(str2)) {
                                            if (!"SmallHeadImgUrl".equals(str2)) {
                                                obj2 = null;
                                                if (obj2 == null) {
                                                    i++;
                                                    obj = 1;
                                                } else if ("BitMask".equals(str2)) {
                                                    if ("BitVal".equals(str2)) {
                                                        i2 = i;
                                                    } else {
                                                        j2 = be.getLong(grVar.itR, j2);
                                                        i2 = i + 1;
                                                    }
                                                    i = i2;
                                                } else {
                                                    j = be.getLong(grVar.itR, j);
                                                    i++;
                                                }
                                            } else if (gQ != null) {
                                                gQ.cyC = str3;
                                            }
                                        } else if (gQ != null) {
                                            gQ.cyD = str3;
                                        }
                                        obj2 = 1;
                                        if (obj2 == null) {
                                            i++;
                                            obj = 1;
                                        } else if ("BitMask".equals(str2)) {
                                            if ("BitVal".equals(str2)) {
                                                i2 = i;
                                            } else {
                                                j2 = be.getLong(grVar.itR, j2);
                                                i2 = i + 1;
                                            }
                                            i = i2;
                                        } else {
                                            j = be.getLong(grVar.itR, j);
                                            i++;
                                        }
                                    }
                                } else {
                                    bizInfo.field_brandFlag = be.getInt(str3, bizInfo.field_brandFlag);
                                }
                                obj2 = 1;
                                if (obj2 == null) {
                                    str3 = grVar.itR;
                                    if ("BigHeadImgUrl".equals(str2)) {
                                        if (!"SmallHeadImgUrl".equals(str2)) {
                                            obj2 = null;
                                            if (obj2 == null) {
                                                i++;
                                                obj = 1;
                                            } else if ("BitMask".equals(str2)) {
                                                j = be.getLong(grVar.itR, j);
                                                i++;
                                            } else {
                                                if ("BitVal".equals(str2)) {
                                                    j2 = be.getLong(grVar.itR, j2);
                                                    i2 = i + 1;
                                                } else {
                                                    i2 = i;
                                                }
                                                i = i2;
                                            }
                                        } else if (gQ != null) {
                                            gQ.cyC = str3;
                                        }
                                    } else if (gQ != null) {
                                        gQ.cyD = str3;
                                    }
                                    obj2 = 1;
                                    if (obj2 == null) {
                                        i++;
                                        obj = 1;
                                    } else if ("BitMask".equals(str2)) {
                                        if ("BitVal".equals(str2)) {
                                            i2 = i;
                                        } else {
                                            j2 = be.getLong(grVar.itR, j2);
                                            i2 = i + 1;
                                        }
                                        i = i2;
                                    } else {
                                        j = be.getLong(grVar.itR, j);
                                        i++;
                                    }
                                }
                            }
                            i++;
                        }
                    }
                    obj2 = 1;
                    str3 = grVar.itR;
                    if ("BrandInfo".equals(str2)) {
                        bizInfo.field_brandInfo = str3;
                    } else if ("BrandIconURL".equals(str2)) {
                        bizInfo.field_brandIconURL = str3;
                    } else if ("BrandFlag".equals(str2)) {
                        obj2 = null;
                        if (obj2 == null) {
                            str3 = grVar.itR;
                            if ("BigHeadImgUrl".equals(str2)) {
                                if (gQ != null) {
                                    gQ.cyD = str3;
                                }
                            } else if (!"SmallHeadImgUrl".equals(str2)) {
                                obj2 = null;
                                if (obj2 == null) {
                                    i++;
                                    obj = 1;
                                } else if ("BitMask".equals(str2)) {
                                    j = be.getLong(grVar.itR, j);
                                    i++;
                                } else {
                                    if ("BitVal".equals(str2)) {
                                        j2 = be.getLong(grVar.itR, j2);
                                        i2 = i + 1;
                                    } else {
                                        i2 = i;
                                    }
                                    i = i2;
                                }
                            } else if (gQ != null) {
                                gQ.cyC = str3;
                            }
                            obj2 = 1;
                            if (obj2 == null) {
                                i++;
                                obj = 1;
                            } else if ("BitMask".equals(str2)) {
                                if ("BitVal".equals(str2)) {
                                    i2 = i;
                                } else {
                                    j2 = be.getLong(grVar.itR, j2);
                                    i2 = i + 1;
                                }
                                i = i2;
                            } else {
                                j = be.getLong(grVar.itR, j);
                                i++;
                            }
                        }
                        i++;
                    } else {
                        bizInfo.field_brandFlag = be.getInt(str3, bizInfo.field_brandFlag);
                    }
                    obj2 = 1;
                    if (obj2 == null) {
                        str3 = grVar.itR;
                        if ("BigHeadImgUrl".equals(str2)) {
                            if (!"SmallHeadImgUrl".equals(str2)) {
                                obj2 = null;
                                if (obj2 == null) {
                                    i++;
                                    obj = 1;
                                } else if ("BitMask".equals(str2)) {
                                    j = be.getLong(grVar.itR, j);
                                    i++;
                                } else {
                                    if ("BitVal".equals(str2)) {
                                        j2 = be.getLong(grVar.itR, j2);
                                        i2 = i + 1;
                                    } else {
                                        i2 = i;
                                    }
                                    i = i2;
                                }
                            } else if (gQ != null) {
                                gQ.cyC = str3;
                            }
                        } else if (gQ != null) {
                            gQ.cyD = str3;
                        }
                        obj2 = 1;
                        if (obj2 == null) {
                            i++;
                            obj = 1;
                        } else if ("BitMask".equals(str2)) {
                            if ("BitVal".equals(str2)) {
                                i2 = i;
                            } else {
                                j2 = be.getLong(grVar.itR, j2);
                                i2 = i + 1;
                            }
                            i = i2;
                        } else {
                            j = be.getLong(grVar.itR, j);
                            i++;
                        }
                    }
                    i++;
                }
            }
            if (i == 0) {
                v.i("MicroMsg.BizAttrRenovator", "None attribute has been updated.");
                return false;
            }
            bizInfo.field_extInfo = jSONObject.toString();
            u.Dy().e(bizInfo);
            if (!(gQ == null || r4 == null)) {
                n.Bo().a(gQ);
                n.AX();
                d.t(str, false);
                n.AX();
                d.t(str, true);
                n.Bq().gD(str);
                com.tencent.mm.modelbiz.j.a DG = u.DG();
                if (!be.kS(str)) {
                    v.d("MicroMsg.BrandLogic", "remove cache by brandKey : %s", str);
                    WeakReference weakReference = (WeakReference) DG.cDb.remove(str);
                    if (weakReference != null) {
                        Bitmap bitmap = (Bitmap) weakReference.get();
                        if (bitmap != null) {
                            bitmap.isRecycled();
                        }
                    }
                }
            }
            uVar.setType(uVar.field_type | ((int) (j & j2)));
            ak.yW();
            c.wH().a(str, uVar);
            v.i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
            return true;
        }
        v.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact is not a biz contact.(username : %s)", str);
        return false;
    }

    private static boolean c(JSONObject jSONObject, String str, String str2) {
        try {
            if ("IsShowHeadImgInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if ("IsHideInputToolbarInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if (!"IsAgreeProtocol".equals(str)) {
                if ("InteractiveMode".equals(str)) {
                    jSONObject.put(str, be.getInt(str2, jSONObject.optInt(str)));
                } else if ("CanReceiveSpeexVoice".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConnectorMsgType".equals(str)) {
                    jSONObject.put(str, be.getInt(str2, jSONObject.optInt(str)));
                } else if ("ReportLocationType".equals(str)) {
                    jSONObject.put(str, be.getInt(str2, jSONObject.optInt(str)));
                } else if ("AudioPlayType".equals(str)) {
                    jSONObject.put(str, be.getInt(str2, jSONObject.optInt(str)));
                } else if ("IsShowMember".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConferenceContactExpireTime".equals(str)) {
                    jSONObject.put(str, str2);
                } else if (!"VerifyMsg2Remark".equals(str)) {
                    if ("VerifyContactPromptTitle".equals(str)) {
                        jSONObject.put(str, str2);
                    } else if (!"IsSubscribeStat".equals(str)) {
                        if ("ScanQRCodeType".equals(str)) {
                            jSONObject.put(str, be.getInt(str2, jSONObject.optInt(str)));
                        } else if ("ServiceType".equals(str)) {
                            jSONObject.put(str, be.getInt(str2, jSONObject.optInt(str)));
                        } else if (!"NeedShowUserAddrObtaining".equals(str)) {
                            if ("SupportEmoticonLinkPrefix".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("FunctionFlag".equals(str)) {
                                jSONObject.put(str, be.getInt(str2, jSONObject.optInt(str)));
                            } else if ("NotifyManage".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("ServicePhone".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("IsTrademarkProtection".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if (!"CanReceiveLongVideo".equals(str)) {
                                if ("TrademarkUrl".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("TrademarkName".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("MMBizMenu".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("VerifySource".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if (!"MMBizTabbar".equals(str)) {
                                    if ("PayShowInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("HardwareBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("EnterpriseBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if (!"MainPage".equals(str)) {
                                        if ("RegisterSource".equals(str)) {
                                            jSONObject.put(str, str2);
                                        } else if (!"IBeaconBizInfo".equals(str)) {
                                            if ("WxaAppInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WxaAppVersionInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WXAppType".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if (!"BindWxaInfo".equals(str)) {
                                                return false;
                                            } else {
                                                jSONObject.put(str, str2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            v.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", str, str2, e);
        }
        return true;
    }
}
