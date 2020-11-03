package id.putraprima.mvvmlogin.viewmodels;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import id.putraprima.mvvmlogin.models.User;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();

    private MutableLiveData<User> userMutableLiveData;


    public MutableLiveData<User> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public void onClick(View view) {

        User User = new User(EmailAddress.getValue(), Password.getValue());

        userMutableLiveData.setValue(User);

    }

//    private User user;
//
//    private String successMessage = "Login was successful";
//    private String errorMessage = "Email or Password not valid";
//
//    @Bindable
//    private String toastMessage = null;
//
//
//    public String getToastMessage() {
//        return toastMessage;
//    }
//
//
//    private void setToastMessage(String toastMessage) {
//
//        this.toastMessage = toastMessage;
//        notifyPropertyChanged(BR.toastMessage);
//    }
//
//
//    public void setUserEmail(String email) {
//        user.setEmail(email);
//        notifyPropertyChanged(BR.userEmail);
//    }
//
//    @Bindable
//    public String getUserEmail() {
//        return user.getEmail();
//    }
//
//    @Bindable
//    public String getUserPassword() {
//        return user.getPassword();
//    }
//
//    public void setUserPassword(String password) {
//        user.setPassword(password);
//        notifyPropertyChanged(BR.userPassword);
//    }
//
//    public LoginViewModel() {
//        user = new User("","");
//    }
//
//    public void onLoginClicked() {
//        if (isInputDataValid())
//            setToastMessage(successMessage);
//        else
//            setToastMessage(errorMessage);
//    }
//
//    public boolean isInputDataValid() {
//        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
//    }
}
