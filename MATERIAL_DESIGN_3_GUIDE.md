# Material Design 3 Quick Reference Guide

## Overview
Your app now uses Material Design 3 (Material You), the latest design system from Google.

## Key Features

### 1. Dynamic Color Theming
Material 3 supports dynamic theming that can adapt to user preferences and system colors.

### 2. Automatic Dark Mode
The app automatically switches between light and dark themes based on system settings.

## Using Material 3 Colors in Your Layouts

### Color Roles
Instead of using hardcoded colors, use semantic color roles:

```xml
<!-- Primary colors -->
android:background="?attr/colorPrimary"
android:background="?attr/colorPrimaryContainer"
android:textColor="?attr/colorOnPrimary"
android:textColor="?attr/colorOnPrimaryContainer"

<!-- Secondary colors -->
android:background="?attr/colorSecondary"
android:background="?attr/colorSecondaryContainer"

<!-- Surface colors -->
android:background="?attr/colorSurface"
android:background="?attr/colorSurfaceVariant"
android:textColor="?attr/colorOnSurface"

<!-- Error colors -->
android:background="?attr/colorError"
android:textColor="?attr/colorOnError"
```

## Material 3 Components

### Buttons

```xml
<!-- Filled Button (Primary) -->
<com.google.android.material.button.MaterialButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Primary Action"
    style="@style/Widget.Material3.Button" />

<!-- Outlined Button -->
<com.google.android.material.button.MaterialButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Secondary Action"
    style="@style/Widget.Material3.Button.OutlinedButton" />

<!-- Text Button -->
<com.google.android.material.button.MaterialButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Tertiary Action"
    style="@style/Widget.Material3.Button.TextButton" />
```

### Cards

```xml
<!-- Filled Card -->
<com.google.android.material.card.MaterialCardView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:cardElevation="0dp"
    app:cardBackgroundColor="?attr/colorSurfaceVariant"
    style="@style/Widget.Material3.CardView.Filled">
    
    <!-- Card content -->
    
</com.google.android.material.card.MaterialCardView>

<!-- Elevated Card -->
<com.google.android.material.card.MaterialCardView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:cardElevation="2dp"
    style="@style/Widget.Material3.CardView.Elevated">
    
    <!-- Card content -->
    
</com.google.android.material.card.MaterialCardView>
```

### Text Fields

```xml
<!-- Filled Text Field -->
<com.google.android.material.textfield.TextInputLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Label"
    style="@style/Widget.Material3.TextInputLayout.FilledBox">
    
    <com.google.android.material.textfield.TextInputEditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
        
</com.google.android.material.textfield.TextInputLayout>

<!-- Outlined Text Field -->
<com.google.android.material.textfield.TextInputLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Label"
    style="@style/Widget.Material3.TextInputLayout.OutlinedBox">
    
    <com.google.android.material.textfield.TextInputEditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
        
</com.google.android.material.textfield.TextInputLayout>
```

### Floating Action Button (FAB)

```xml
<!-- Regular FAB -->
<com.google.android.material.floatingactionbutton.FloatingActionButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:src="@drawable/ic_add"
    app:tint="?attr/colorOnPrimaryContainer"
    style="@style/Widget.Material3.FloatingActionButton.Primary" />

<!-- Extended FAB -->
<com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Add Item"
    app:icon="@drawable/ic_add"
    style="@style/Widget.Material3.ExtendedFloatingActionButton.Primary" />
```

### Chips

```xml
<!-- Filter Chip -->
<com.google.android.material.chip.Chip
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Filter"
    style="@style/Widget.Material3.Chip.Filter" />

<!-- Suggestion Chip -->
<com.google.android.material.chip.Chip
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Suggestion"
    style="@style/Widget.Material3.Chip.Suggestion" />
```

### Progress Indicators

```xml
<!-- Circular Progress -->
<com.google.android.material.progressindicator.CircularProgressIndicator
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:indeterminate="true"
    style="@style/Widget.Material3.CircularProgressIndicator" />

<!-- Linear Progress -->
<com.google.android.material.progressindicator.LinearProgressIndicator
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:indeterminate="true"
    style="@style/Widget.Material3.LinearProgressIndicator" />
```

### Switches

```xml
<com.google.android.material.switchmaterial.SwitchMaterial
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Enable feature"
    style="@style/Widget.Material3.CompoundButton.Switch" />
```

### Sliders

```xml
<com.google.android.material.slider.Slider
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:valueFrom="0.0"
    android:valueTo="100.0"
    android:value="50.0"
    style="@style/Widget.Material3.Slider" />
```

## Shape Customization

Material 3 uses different corner radiuses for different component sizes:

- **Extra Small**: 4dp (Buttons, Chips)
- **Small**: 8dp (Cards)
- **Medium**: 12dp (Dialogs)
- **Large**: 16dp (Bottom Sheets)
- **Extra Large**: 28dp (FABs)

You can customize shapes in your `themes.xml`:

```xml
<style name="AppTheme" parent="Theme.Material3.DayNight.NoActionBar">
    ...
    <item name="shapeAppearanceSmallComponent">@style/ShapeAppearance.Material3.SmallComponent</item>
    <item name="shapeAppearanceMediumComponent">@style/ShapeAppearance.Material3.MediumComponent</item>
    <item name="shapeAppearanceLargeComponent">@style/ShapeAppearance.Material3.LargeComponent</item>
</style>
```

## Typography

Material 3 has predefined text styles:

```xml
<!-- Display styles (largest) -->
android:textAppearance="?attr/textAppearanceDisplayLarge"
android:textAppearance="?attr/textAppearanceDisplayMedium"
android:textAppearance="?attr/textAppearanceDisplaySmall"

<!-- Headline styles -->
android:textAppearance="?attr/textAppearanceHeadlineLarge"
android:textAppearance="?attr/textAppearanceHeadlineMedium"
android:textAppearance="?attr/textAppearanceHeadlineSmall"

<!-- Title styles -->
android:textAppearance="?attr/textAppearanceTitleLarge"
android:textAppearance="?attr/textAppearanceTitleMedium"
android:textAppearance="?attr/textAppearanceTitleSmall"

<!-- Body styles -->
android:textAppearance="?attr/textAppearanceBodyLarge"
android:textAppearance="?attr/textAppearanceBodyMedium"
android:textAppearance="?attr/textAppearanceBodySmall"

<!-- Label styles -->
android:textAppearance="?attr/textAppearanceLabelLarge"
android:textAppearance="?attr/textAppearanceLabelMedium"
android:textAppearance="?attr/textAppearanceLabelSmall"
```

## Migration Tips

### Old AppCompat → New Material 3

```xml
<!-- OLD -->
<Button ... />
<!-- NEW -->
<com.google.android.material.button.MaterialButton ... />

<!-- OLD -->
<EditText ... />
<!-- NEW -->
<com.google.android.material.textfield.TextInputLayout>
    <com.google.android.material.textfield.TextInputEditText ... />
</com.google.android.material.textfield.TextInputLayout>

<!-- OLD -->
<Switch ... />
<!-- NEW -->
<com.google.android.material.switchmaterial.SwitchMaterial ... />
```

## Resources

- [Material Design 3 Guidelines](https://m3.material.io/)
- [Material Components for Android](https://github.com/material-components/material-components-android)
- [Color System](https://m3.material.io/styles/color/overview)
- [Typography](https://m3.material.io/styles/typography/overview)

## Testing Themes

To test dark mode in Android Studio:
1. Run your app
2. Open device settings
3. Navigate to Display → Dark theme
4. Toggle on/off to see theme changes

Or use the quick settings tile on your device.
