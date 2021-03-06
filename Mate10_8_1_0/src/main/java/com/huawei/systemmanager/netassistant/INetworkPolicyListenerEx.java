package com.huawei.systemmanager.netassistant;

import android.net.INetworkPolicyListener;
import android.net.INetworkPolicyListener.Stub;
import android.os.RemoteException;

public class INetworkPolicyListenerEx {
    private final INetworkPolicyListener mPolicyListener = new Stub() {
        public void onUidRulesChanged(int uid, int uidRules) throws RemoteException {
        }

        public void onUidPoliciesChanged(int uid, int uidPolicies) {
            INetworkPolicyListenerEx.this.onUidPoliciesChanged(uid, uidPolicies);
        }

        public void onMeteredIfacesChanged(String[] strings) throws RemoteException {
        }

        public void onRestrictBackgroundChanged(boolean enable) throws RemoteException {
            INetworkPolicyListenerEx.this.onRestrictBackgroundChanged(enable);
        }
    };

    public INetworkPolicyListener getINetworkPolicyListener() {
        return this.mPolicyListener;
    }

    public void onUidPoliciesChanged(int uid, int uidPolicies) {
    }

    public void onRestrictBackgroundChanged(boolean enable) throws RemoteException {
    }
}
