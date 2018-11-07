package expo.modules.bluetooth;

import android.content.Context;
//import android.support.annotation.RequiresPermission;

import java.util.Collections;
import java.util.List;

import expo.core.BasePackage;
import expo.core.ExportedModule;

public class BluetoothPackage extends BasePackage {

//   @RequiresPermission(
//     allOf = {"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN"}
//   )
   public BluetoothPackage() {
   }

  @Override
  public List<ExportedModule> createExportedModules(Context context) {
    return Collections.<ExportedModule>singletonList(new BluetoothModule(context));
  }
}

