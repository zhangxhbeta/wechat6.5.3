package com.tencent.tmassistantsdk.openSDK.param;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCCmd;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.util.GlobalUtil;

public class IPCPackageTools {
    protected static final String CHILD_NAME = ".jce.";
    static final String CRYPT_KEY = "ji*9^&43U0X-~./(";
    private static final String TAG = "IPCPackageTools";
    protected static int mReqId = 0;

    public static int getCmdId(JceStruct jceStruct) {
        if (jceStruct == null) {
            return -1;
        }
        String simpleName = jceStruct.getClass().getSimpleName();
        return IPCCmd.convert(simpleName.substring(0, simpleName.length() - 7)).value();
    }

    public static IPCRequest buildIpcRequest(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        IPCRequest iPCRequest = new IPCRequest();
        IPCHead iPCHead = new IPCHead();
        int i = mReqId;
        mReqId = i + 1;
        iPCHead.requestId = i;
        iPCHead.cmdId = getCmdId(jceStruct);
        iPCHead.hostPackageName = GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
        iPCHead.hostVersionCode = String.valueOf(GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext()));
        iPCRequest.head = iPCHead;
        iPCRequest.body = jceStruct2ByteArray(jceStruct);
        return iPCRequest;
    }

    public static byte[] buildPostData(IPCRequest iPCRequest) {
        if (iPCRequest == null) {
            return null;
        }
        iPCRequest.body = ProtocolPackage.encrypt(iPCRequest.body, CRYPT_KEY.getBytes());
        return jceStruct2ByteArray(iPCRequest);
    }

    public static IPCResponse unpackPackage(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return null;
        }
        IPCResponse iPCResponse = new IPCResponse();
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding(ProtocolPackage.ServerEncoding);
            iPCResponse.readFrom(jceInputStream);
            if (TextUtils.isEmpty(iPCResponse.head.hostPackageName)) {
                return iPCResponse;
            }
            iPCResponse.body = ProtocolPackage.decrypt(iPCResponse.body, CRYPT_KEY.getBytes());
            return iPCResponse;
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            return null;
        }
    }

    public static JceStruct unpackBodyStruct(IPCResponse iPCResponse) {
        JceStruct createFromRequest = createFromRequest(IPCCmd.convert(iPCResponse.head.cmdId).toString());
        if (createFromRequest == null || iPCResponse.body.length <= 0) {
            return null;
        }
        try {
            JceInputStream jceInputStream = new JceInputStream(iPCResponse.body);
            jceInputStream.setServerEncoding(ProtocolPackage.ServerEncoding);
            createFromRequest.readFrom(jceInputStream);
            return createFromRequest;
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            return null;
        }
    }

    private static JceStruct createFromRequest(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JceStruct jceStruct;
        try {
            jceStruct = (JceStruct) Class.forName((IPCPackageTools.class.getPackage().getName() + CHILD_NAME + str) + "Response").newInstance();
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            jceStruct = null;
        } catch (Throwable e2) {
            v.a(TAG, e2, "", new Object[0]);
            jceStruct = null;
        } catch (Throwable e22) {
            v.a(TAG, e22, "", new Object[0]);
            jceStruct = null;
        }
        return jceStruct;
    }

    public static byte[] jceStruct2ByteArray(JceStruct jceStruct) {
        return ProtocolPackage.jceStructToUTF8Byte(jceStruct);
    }
}
