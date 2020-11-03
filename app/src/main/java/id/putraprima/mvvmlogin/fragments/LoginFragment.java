package id.putraprima.mvvmlogin.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Objects;

import id.putraprima.mvvmlogin.R;
import id.putraprima.mvvmlogin.databinding.FragmentLoginBinding;
import id.putraprima.mvvmlogin.models.User;
import id.putraprima.mvvmlogin.viewmodels.LoginViewModel;

public class LoginFragment extends Fragment {
    FragmentLoginBinding binding;
    LoginViewModel loginViewModel;
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setViewModel(new LoginViewModel());
        binding.executePendingBindings();

        View view = binding.getRoot();

        loginViewModel.getUser().observe(getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(@Nullable User User) {

                if (TextUtils.isEmpty(Objects.requireNonNull(User).getStrEmailAddress())) {
                    binding.editTextEmail.setError("Enter an E-Mail Address");
                    binding.editTextEmail.requestFocus();
                }
                else if (!User.isEmailValid()) {
                    binding.editTextEmail.setError("Enter a Valid E-mail Address");
                    binding.editTextEmail.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(User).getStrPassword())) {
                    binding.editTextEmail.setError("Enter a Password");
                    binding.editTextEmail.requestFocus();
                }
                else if (!User.isPasswordLengthGreaterThan5()) {
                    binding.editTextEmail.setError("Enter at least 6 Digit password");
                    binding.editTextEmail.requestFocus();
                }
                else {
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment);
                }

            }
        });


        // Inflate the layout for this fragment
        return view;
    }

//    @BindingAdapter({"toastMessage"})
//    public static void runMe(View view, String message) {
//        if (message != null)
//            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
//    }
}