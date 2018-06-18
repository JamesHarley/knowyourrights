package com.example.sundr.know_your_rights;
import android.support.v4.app.Fragment;
import android.view.*;
import android.os.Bundle;
public class ScreenToPages extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.const_alltext, container, false);

        return rootView;

    }
}
