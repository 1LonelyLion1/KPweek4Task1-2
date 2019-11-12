package com.example.kpweek4task1_2;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {

    private TextView mSearchText;
    private int id;
    private Button mButtonSearch;
    private SharedPreferencesLogic mSharedPreferences;

    public static SearchFragment newInstance(){
        return new SearchFragment();
    }

    private View.OnClickListener mOnSearchButtonClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (!TextUtils.isEmpty(mSearchText.getText())) {

                String searchSystem;

                switch (id){
                    case R.id.google_search:
                        searchSystem = "https://www.google.com/search?&q=";
                        break;
                    case R.id.yandex_search:
                        searchSystem = "https://www.yandex.ru/search?&q=";
                        break;
                    case R.id.Bing_search:
                        searchSystem = "https://www.bing.com/search?&q=";
                        break;
                        default:
                            searchSystem = "https://www.google.com/search?&q=";
                            break;

                }
                Intent sendIntentToBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse(searchSystem + mSearchText.getText().toString()));
                startActivity(sendIntentToBrowser);
            }
            else {
               Toast.makeText(getActivity(), getText(R.string.empty_search_request), Toast.LENGTH_SHORT).show();
           }

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_fragment, container, false);

        mSharedPreferences = new SharedPreferencesLogic(getActivity());
        mSearchText = v.findViewById(R.id.etSearchText);
        mButtonSearch = v.findViewById(R.id.SearchButton);
        mButtonSearch.setOnClickListener(mOnSearchButtonClickListner);
        id = mSharedPreferences.LoadSearchPrefernces();
        return v;
    }
}
