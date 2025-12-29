## Android 16m ECU Diagnostic Data Viewer

Android app, used in conjunction with my Bluetooth 16m datalogger to display ECU / AFR values

My logger and software information can be found here:

https://16mecudiagnosticdatalogger.blogspot.com/

---

## 🎉 Recently Modernized (December 2025)

This app has been fully modernized to use the latest Android development tools and best practices:

- ✅ **Android 14 (API 34)** target SDK
- ✅ **Material Design 3** with automatic dark mode
- ✅ **AndroidX** libraries (migrated from deprecated Support Library)
- ✅ **Gradle 8.2** and Android Gradle Plugin 8.2.2
- ✅ **Kotlin** support configured
- ✅ **Modern Bluetooth permissions** for Android 12+
- ✅ **ViewBinding** enabled for type-safe view access
- ✅ **Java 17** support

See [MODERNIZATION_SUMMARY.md](MODERNIZATION_SUMMARY.md) for complete details.

---

### Requirements

- **Android Studio**: Hedgehog (2023.1.1) or later recommended
- **Minimum Android Version**: Android 5.0 (API 21) Lollipop
- **Target Android Version**: Android 14 (API 34)
- **JDK**: Java 17 or later

### Getting Started

1) Fork this repository on Github
2) Clone your forked repository:
   ```bash
   git clone https://github.com/YOUR_USERNAME/16mDataLogger.git
   ```
3) Open Android Studio
4) Select "Open" and navigate to the cloned project directory
5) Wait for Gradle sync to complete
6) Build → Rebuild Project
7) Run on your device or emulator

### First Build

The first build may take a few minutes as Gradle downloads dependencies. Subsequent builds will be much faster.

### Features

- Real-time ECU data monitoring
- AFR (Air-Fuel Ratio) visualization with gauges
- Data graphing and logging
- Actuator testing
- Bluetooth Low Energy (BLE) connectivity
- Material Design 3 UI with light/dark theme support

### Helpful Guides

- [Material Design 3 Quick Reference](MATERIAL_DESIGN_3_GUIDE.md) - Guide for using new Material 3 components
- [Bluetooth Permission Helper](app/src/main/java/io/github/thymythos/diagnosticdataviewer/BluetoothPermissionHelper.java) - Ready-to-use helper for Android 12+ Bluetooth permissions
