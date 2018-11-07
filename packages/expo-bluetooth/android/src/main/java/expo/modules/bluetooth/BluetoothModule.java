package expo.modules.bluetooth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;

import java.util.Map;

import expo.core.ExportedModule;
import expo.core.ModuleRegistry;
import expo.core.Promise;
import expo.core.interfaces.ActivityProvider;
import expo.core.interfaces.ExpoMethod;
import expo.core.interfaces.ModuleRegistryConsumer;
import expo.core.interfaces.services.UIManager;

@SuppressLint("MissingPermission")
public class BluetoothModule extends ExportedModule implements ModuleRegistryConsumer {

  private static final String TAG = BluetoothModule.class.getCanonicalName();

  private ModuleRegistry mModuleRegistry;

  public BluetoothModule(Context context) {
    super(context);
  }

  @Override
  public String getName() {
    return "ExpoBluetooth";
  }

  @Override
  public void setModuleRegistry(ModuleRegistry moduleRegistry) {
    mModuleRegistry = moduleRegistry;
  }

  private final Context getApplicationContext() {
    Activity activity = getCurrentActivity();
    if (activity != null) {
      return activity.getApplicationContext();
    }
    return null;
  }

  private final UIManager getUIManager() {
    if (mModuleRegistry != null && mModuleRegistry.getModule(UIManager.class) != null) {
      UIManager mUIManager = mModuleRegistry.getModule(UIManager.class);
      return mUIManager;
    }
    return null;
  }

  private final Activity getCurrentActivity() {
    if (mModuleRegistry != null && mModuleRegistry.getModule(ActivityProvider.class) != null) {
      ActivityProvider activityProvider = mModuleRegistry.getModule(ActivityProvider.class);
      return activityProvider.getCurrentActivity();
    }
    return null;
  }

  private Context getApplicationContextOrReject(Promise promise) {
    Context context = getApplicationContext();
    if (context == null) {
      promise.reject("ERR_EXPO_BLUETOOTH", "Module registry is not initialized, or ActivityProvider is not available.");
    }
    return context;
  }

  @ExpoMethod
  public void someMethod(Promise promise) {
    Context context = getApplicationContextOrReject(promise);
    if (context == null) {
      return;
    } 

    promise.resolve(null);
  }
}
