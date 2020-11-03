package id.putraprima.mvvmlogin.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import id.putraprima.mvvmlogin.models.Splash;
import id.putraprima.mvvmlogin.models.User;

public class LoginViewModelFactory implements ViewModelProvider.Factory {
    private User user;
    public LoginViewModelFactory(User user){
        this.user = user;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create (@NonNull Class<T> modeClass){
        if(modeClass.isAssignableFrom(LoginViewModel.class)){
            return (T) new LoginViewModel();
        }
        throw  new IllegalArgumentException("Viewmodel Yang Diminta LoginViewModel");
    }
}
