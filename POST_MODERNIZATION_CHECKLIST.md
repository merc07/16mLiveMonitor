# Post-Modernization Checklist

After modernizing the Android app, follow this checklist to ensure everything works correctly.

## ✅ Build Verification

### 1. Gradle Sync
- [ ] Open project in Android Studio Hedgehog or later
- [ ] File → Sync Project with Gradle Files
- [ ] Verify no sync errors

### 2. Dependencies Check
- [ ] Check Build output for any deprecation warnings
- [ ] Verify all dependencies downloaded successfully
- [ ] No red underlines in build.gradle files

### 3. Code Compilation
- [ ] Build → Clean Project
- [ ] Build → Rebuild Project
- [ ] Verify no compilation errors
- [ ] Check for any warnings in the Build output

## ✅ Runtime Testing

### 4. App Launch
- [ ] Run app on emulator (API 21+)
- [ ] Run app on physical device (if available)
- [ ] App launches without crashes
- [ ] Splash screen displays correctly (if any)

### 5. UI Verification
- [ ] Navigation drawer opens/closes smoothly
- [ ] All menu items accessible
- [ ] Toolbar displays correctly
- [ ] Fragments load properly
- [ ] No layout issues or overlapping elements

### 6. Theme Testing
- [ ] Test app in light mode
- [ ] Test app in dark mode (Settings → Display → Dark theme)
- [ ] Verify color scheme looks correct in both modes
- [ ] Check text readability in both themes

### 7. Bluetooth Functionality
- [ ] Request Bluetooth permissions (Android 12+)
- [ ] Scan for BLE devices
- [ ] Connect to device
- [ ] Verify data reception
- [ ] Test disconnect functionality

## ✅ Code Quality Checks

### 8. Import Statements
- [ ] No red imports in MainActivity.java
- [ ] No red imports in DeviceScanActivity.java
- [ ] No red imports in BluetoothLeService.java
- [ ] All fragments import correctly

### 9. Layout Files
- [ ] activity_main.xml previews correctly
- [ ] app_bar_main.xml previews correctly
- [ ] All fragment layouts preview correctly
- [ ] No XML parsing errors

## ⚠️ Known Migrations Needed

### Java Code Updates (If you encounter issues)

If you see import errors in your Java files, you may need to manually fix:

```java
// OLD Support Library imports - REMOVE these:
import android.support.v7.app.AppCompatActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.NavigationView;

// NEW AndroidX imports - USE these:
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
```

Common replacements:
- `android.support.v7.app.*` → `androidx.appcompat.app.*`
- `android.support.v4.app.*` → `androidx.core.app.*` or `androidx.fragment.app.*`
- `android.support.v4.widget.*` → `androidx.*` (specific package varies)
- `android.support.design.widget.*` → `com.google.android.material.*`

### Fragment Migration

Note: The app currently uses `android.app.Fragment` (deprecated). For best practices, consider migrating to `androidx.fragment.app.Fragment`:

```java
// OLD
import android.app.Fragment;
import android.app.FragmentManager;

// NEW
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
```

## 🔧 Troubleshooting

### Problem: Gradle sync fails with "Could not find" errors
**Solution**: 
- Check internet connection
- File → Invalidate Caches → Invalidate and Restart
- Try syncing again

### Problem: "Cannot resolve symbol 'R'"
**Solution**:
- Build → Clean Project
- Build → Rebuild Project
- File → Sync Project with Gradle Files

### Problem: Import errors in Java files
**Solution**:
- Check that AndroidX migration completed for that file
- Manually replace support library imports with AndroidX equivalents
- See "Known Migrations Needed" section above

### Problem: Layout preview not working
**Solution**:
- Check XML for errors
- Verify namespace declarations are correct
- Try refreshing preview (R icon in preview panel)

### Problem: App crashes on Android 12+ when using Bluetooth
**Solution**:
- Implement runtime permission requests
- Use the provided `BluetoothPermissionHelper.java`
- See example usage in the helper file comments

### Problem: Dark theme colors look wrong
**Solution**:
- Check that `values-night/styles.xml` exists
- Verify color references use theme attributes (`?attr/colorPrimary`)
- Avoid hardcoded colors in layouts

## 📝 Optional Next Steps

Once basic functionality is verified:

1. **Add Runtime Permissions**
   - Integrate BluetoothPermissionHelper into DeviceScanActivity
   - Test permission flow on Android 12+ device

2. **Convert to Kotlin** (Optional but recommended)
   - Android Studio: Code → Convert Java File to Kotlin File
   - Start with smaller utility classes
   - Gradually migrate fragments and activities

3. **Implement ViewBinding**
   - Replace findViewById calls with ViewBinding
   - Safer and faster than traditional view access
   - Already enabled in build.gradle

4. **Add Navigation Component** (Optional)
   - Replace manual fragment transactions
   - Better back stack management
   - Dependencies already included

5. **Update Fragments**
   - Migrate from deprecated `android.app.Fragment`
   - Use `androidx.fragment.app.Fragment`
   - Update FragmentManager calls

## ✅ Success Criteria

Your modernization is complete when:
- ✅ App builds without errors
- ✅ App runs on Android 5.0+ devices
- ✅ All fragments display correctly
- ✅ Bluetooth functionality works
- ✅ Light and dark themes work properly
- ✅ Navigation drawer functions correctly
- ✅ No AndroidX import errors

## 📞 Need Help?

If you encounter issues:
1. Check Android Studio Build output for specific errors
2. Review [MODERNIZATION_SUMMARY.md](MODERNIZATION_SUMMARY.md)
3. Check [MATERIAL_DESIGN_3_GUIDE.md](MATERIAL_DESIGN_3_GUIDE.md) for UI component help
4. Search for specific error messages online
5. Check Android Developer documentation at developer.android.com

---

**Last Updated**: December 29, 2025
**Modernization Version**: 2.0
