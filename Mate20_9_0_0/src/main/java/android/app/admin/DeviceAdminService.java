package android.app.admin;

import android.app.Service;
import android.app.admin.IDeviceAdminService.Stub;
import android.content.Intent;
import android.os.IBinder;

public class DeviceAdminService extends Service {
    private final IDeviceAdminServiceImpl mImpl = new IDeviceAdminServiceImpl();

    private class IDeviceAdminServiceImpl extends Stub {
        private IDeviceAdminServiceImpl() {
        }
    }

    public final IBinder onBind(Intent intent) {
        return this.mImpl.asBinder();
    }
}
