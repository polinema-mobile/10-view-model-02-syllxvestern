package id.putraprima.mvvmlogin.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.putraprima.mvvmlogin.R;
import id.putraprima.mvvmlogin.databinding.FragmentSplashBinding;
import id.putraprima.mvvmlogin.models.Splash;
import id.putraprima.mvvmlogin.viewmodels.SplashViewModel;
import id.putraprima.mvvmlogin.viewmodels.SplashViewModelFactory;

public class SplashFragment extends Fragment {
    FragmentSplashBinding binding;
    SplashViewModel viewModels;
    Splash splash;

    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false);
        viewModels = new ViewModelProvider(this, new  SplashViewModelFactory(splash)).get(SplashViewModel.class);
        binding.setSplashViewModel(viewModels);
        binding.setLifecycleOwner(this);
        View view = binding.getRoot();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_loginFragment);
            }
        }, 3000);
        return view;
    }

}