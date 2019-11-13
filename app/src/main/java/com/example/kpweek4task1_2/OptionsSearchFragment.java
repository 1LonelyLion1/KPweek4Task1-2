package com.example.kpweek4task1_2;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OptionsSearchFragment extends Fragment {

    private SharedPreferencesLogic mSharedPreferences;
    private RadioGroup searchGroup;


    public static OptionsSearchFragment newInstance(){
        return new OptionsSearchFragment();
    }
    RadioGroup.OnCheckedChangeListener searchGroupOnCheckedListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            mSharedPreferences.SaveSearchPrefernces(checkedId);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.options_search, container, false);

        searchGroup = v.findViewById(R.id.search_optional_radiogroup);
        searchGroup.setOnCheckedChangeListener(searchGroupOnCheckedListener);
        mSharedPreferences = new SharedPreferencesLogic(getActivity());

        int idSearchSystem = mSharedPreferences.LoadSearchPrefernces();
        if(idSearchSystem != -1){
            RadioButton seachButton = v.findViewById(idSearchSystem);
            seachButton.setChecked(true);
        }

        return v;
    }


}
