package io.github.thymythos.diagnosticdataviewer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;

public class SettingsFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        
        RadioGroup themeGroup = view.findViewById(R.id.theme_radio_group);
        
        // Set current theme selection
        int currentTheme = ThemeHelper.getSavedTheme(requireContext());
        switch (currentTheme) {
            case ThemeHelper.MODE_LIGHT:
                themeGroup.check(R.id.radio_light);
                break;
            case ThemeHelper.MODE_DARK:
                themeGroup.check(R.id.radio_dark);
                break;
            case ThemeHelper.MODE_SYSTEM:
            default:
                themeGroup.check(R.id.radio_system);
                break;
        }
        
        // Handle theme changes
        themeGroup.setOnCheckedChangeListener((group, checkedId) -> {
            int themeMode = ThemeHelper.MODE_SYSTEM;
            if (checkedId == R.id.radio_light) {
                themeMode = ThemeHelper.MODE_LIGHT;
            } else if (checkedId == R.id.radio_dark) {
                themeMode = ThemeHelper.MODE_DARK;
            }
            ThemeHelper.saveTheme(requireContext(), themeMode);
        });
        
        return view;
    }
}
