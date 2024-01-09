package com.example.tic_tac_toe;

import android.content.Context;
import android.util.Log;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.tic_tac_toe.databinding.DialogueBoxBinding;

import java.util.Objects;

public class WinnerDialog extends DialogFragment {
    private final Context mContext;
    private final String result;

    public WinnerDialog(Context context, String result) {
        this.mContext = context;
        this.result = result;
    }
    @Override
    public void show(@NonNull FragmentManager manager, @Nullable String tag) {
        try{
            super.show(manager, tag);
        }catch (Exception e){
//            Log.d("ttpl", "show: " + e.getMessage());
            Toast.makeText(mContext, "something went wrong", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void dismiss() {
        try {
            super.dismiss();
        }catch (Exception e){
            super.dismissAllowingStateLoss();
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        if (Objects.requireNonNull(getDialog()).getWindow() != null) {
            getDialog().getWindow().setLayout(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.WRAP_CONTENT
            );
            getDialog().getWindow().setGravity(Gravity.CENTER);
            getDialog().getWindow().setBackgroundDrawableResource(R.color.transparent);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        DialogueBoxBinding binding = DialogueBoxBinding
                .inflate(inflater, container, false);

        binding.winnerText.setText(result);
        return binding.getRoot();
    }
}
