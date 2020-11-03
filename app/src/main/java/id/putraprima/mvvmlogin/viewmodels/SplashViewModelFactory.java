package id.putraprima.mvvmlogin.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import id.putraprima.mvvmlogin.models.Splash;

public class SplashViewModelFactory implements ViewModelProvider.Factory {
    private Splash splash;
    public SplashViewModelFactory(Splash splash){
        this.splash = splash;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create (@NonNull Class<T> modeClass){
        if(modeClass.isAssignableFrom(SplashViewModel.class)){
            return (T) new SplashViewModel(splash);
        }
        throw  new IllegalArgumentException("Viewmodel Yang Diminta SplashViewModels");
    }

}
