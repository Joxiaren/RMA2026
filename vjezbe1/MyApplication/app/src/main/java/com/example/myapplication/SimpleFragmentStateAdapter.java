package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.zadaci.*;

public class SimpleFragmentStateAdapter  extends FragmentStateAdapter {
    public SimpleFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public SimpleFragmentStateAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public SimpleFragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1: return new zadatak1();
            case 2: return new zadatak2();
            case 3: return new zadatak3();
            default: return new primer1();
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
