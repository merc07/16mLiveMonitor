package io.github.thymythos.diagnosticdataviewer;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for managing Bluetooth permissions on Android 12+
 * 
 * Usage in your Activity:
 * 
 * private BluetoothPermissionHelper permissionHelper;
 * 
 * @Override
 * protected void onCreate(Bundle savedInstanceState) {
 *     super.onCreate(savedInstanceState);
 *     
 *     permissionHelper = new BluetoothPermissionHelper(this, new BluetoothPermissionHelper.PermissionCallback() {
 *         @Override
 *         public void onPermissionsGranted() {
 *             // Start Bluetooth operations
 *             startBluetoothScan();
 *         }
 *         
 *         @Override
 *         public void onPermissionsDenied() {
 *             // Handle denied permissions
 *             Toast.makeText(MainActivity.this, "Bluetooth permissions required", Toast.LENGTH_LONG).show();
 *         }
 *     });
 * }
 * 
 * // When you need to use Bluetooth, request permissions first:
 * permissionHelper.requestBluetoothPermissions();
 */
public class BluetoothPermissionHelper {
    
    private final AppCompatActivity activity;
    private final PermissionCallback callback;
    private final ActivityResultLauncher<String[]> permissionLauncher;
    
    public interface PermissionCallback {
        void onPermissionsGranted();
        void onPermissionsDenied();
    }
    
    public BluetoothPermissionHelper(AppCompatActivity activity, PermissionCallback callback) {
        this.activity = activity;
        this.callback = callback;
        
        // Register permission launcher
        this.permissionLauncher = activity.registerForActivityResult(
            new ActivityResultContracts.RequestMultiplePermissions(),
            result -> {
                boolean allGranted = true;
                for (Boolean granted : result.values()) {
                    if (!granted) {
                        allGranted = false;
                        break;
                    }
                }
                
                if (allGranted) {
                    callback.onPermissionsGranted();
                } else {
                    callback.onPermissionsDenied();
                }
            }
        );
    }
    
    /**
     * Request necessary Bluetooth permissions based on Android version
     */
    public void requestBluetoothPermissions() {
        if (hasBluetoothPermissions()) {
            callback.onPermissionsGranted();
            return;
        }
        
        String[] permissions = getRequiredPermissions();
        permissionLauncher.launch(permissions);
    }
    
    /**
     * Check if all required Bluetooth permissions are granted
     */
    public boolean hasBluetoothPermissions() {
        String[] permissions = getRequiredPermissions();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(activity, permission) 
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Get required permissions based on Android version
     */
    private String[] getRequiredPermissions() {
        List<String> permissions = new ArrayList<>();
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            // Android 12+ (API 31+)
            permissions.add(Manifest.permission.BLUETOOTH_SCAN);
            permissions.add(Manifest.permission.BLUETOOTH_CONNECT);
            // Only add location if you actually need it for location-based features
            // permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        } else {
            // Android 11 and below (API 30 and below)
            permissions.add(Manifest.permission.BLUETOOTH);
            permissions.add(Manifest.permission.BLUETOOTH_ADMIN);
            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        
        return permissions.toArray(new String[0]);
    }
}
