package expo.modules.haptics;

import android.content.Context;
import android.os.Vibrator;

import expo.core.ExportedModule;
import expo.core.ModuleRegistry;
import expo.core.Promise;
import expo.core.interfaces.ExpoMethod;
import expo.core.interfaces.ModuleRegistryConsumer;

public class HapticsModule extends ExportedModule implements ModuleRegistryConsumer {
  private static final String TAG = "ExpoHaptics";
  private final HapticsPerformer mPerformer;

  private ModuleRegistry mModuleRegistry;

  public HapticsModule(Context context) {
    super(context);
    Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    mPerformer = new HapticsPerformer(vibrator);
  }

  @Override
  public String getName() {
    return TAG;
  }

  @Override
  public void setModuleRegistry(ModuleRegistry moduleRegistry) {
    mModuleRegistry = moduleRegistry;
  }

  @ExpoMethod
  public void notification(String type, Promise promise) {
    switch (type) {
      case "error":
        mPerformer.notificationError();
        break;
      case "warning":
        mPerformer.notificationWarning();
        break;
      default:
        mPerformer.notificationSuccess();
        break;
    }
    promise.resolve(null);
  }

  @ExpoMethod
  public void selection(Promise promise) {
    mPerformer.selection();
    promise.resolve(null);
  }

  @ExpoMethod
  public void impact(String type, Promise promise) {
    switch (type) {
      case "light":
        mPerformer.impactLight();
        break;
      case "heavy":
        mPerformer.impactHeavy();
        break;
      default:
        mPerformer.impactMedium();
        break;
    }

    promise.resolve(null);
  }
}
