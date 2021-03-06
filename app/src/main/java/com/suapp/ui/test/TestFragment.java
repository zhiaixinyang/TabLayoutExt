package com.suapp.ui.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.suapp.ui.tablayout.HomeActivity;
import com.suapp.ui.tablayout.R;
import com.gerenvip.ui.tablayout.TabLayoutExt;

/**
 * @author wangwei on 2018/4/4.
 *         wangwei@jiandaola.com
 */
public class TestFragment extends Fragment {

    private TextView mText;

    private static final String PAGE_KEY = "PAGE_KEY";

    public static TestFragment instance(String page) {
        TestFragment fragment = new TestFragment();
        Bundle arg = new Bundle();
        arg.putString(PAGE_KEY, page);
        fragment.setArguments(arg);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mText = view.findViewById(R.id.text);

        Bundle arguments = getArguments();
        String page = arguments.getString(PAGE_KEY);
        mText.setText(page);
        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity activity = getActivity();
                if (activity != null && activity instanceof HomeActivity) {
                    ((HomeActivity) activity).update();
                }

            }
        });
        TabLayoutExt ext = new TabLayoutExt(this.getContext());
    }

    public String getPage() {
        Bundle arguments = getArguments();
        String page = arguments.getString(PAGE_KEY);
        return page;
    }

}
