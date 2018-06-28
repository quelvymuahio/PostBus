package com.project.quelvymuahio.postbus;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

public class RegistrationActivity extends AppCompatActivity{

    private static final int PICK_IMAGE_REQUEST = 1;

    private Uri imageUri;

    // UI references.
    private AutoCompleteTextView fullNameView, userNameView , birthDateView, contacView;
    private EditText mPasswordView;
    private Button signUpButton;
    private ImageView userImageView;
    private View mProgressView;
    private View mLoginFormView;

    // Date parameters
    private int dpyear, dpmonth, dpday;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Toolbar toolbar = (Toolbar) findViewById(R.id.registration_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Set up the registration form.
        fullNameView = (AutoCompleteTextView) findViewById(R.id.registration_full_name);
        birthDateView = (AutoCompleteTextView) findViewById(R.id.registration_birth_date);
        userNameView = (AutoCompleteTextView) findViewById(R.id.registration_username);
        contacView = (AutoCompleteTextView) findViewById(R.id.registration_contact);
        userImageView = (ImageView) findViewById(R.id.registration_image);
        mPasswordView = (EditText) findViewById(R.id.registration_password);
        signUpButton = (Button) findViewById(R.id.sign_up_button);

        // Leading with Date Picker
        final Calendar calendar = Calendar.getInstance();
        dpyear = calendar.get(Calendar.YEAR);
        dpmonth = calendar.get(Calendar.MONTH);
        dpday = calendar.get(Calendar.DAY_OF_MONTH);

        birthDateView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
        //End of Date Picker

        userImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        signUpButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    // Date Picker stuff

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerListener, dpyear, dpmonth, dpday);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            dpyear = year;
            dpmonth = month + 1;
            dpday = day;

            birthDateView.setText(dpday +"/"+dpmonth+"/"+dpyear);
        }
    };

    // End of Date Picker Stuff

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Reset errors.
        fullNameView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String fullName = fullNameView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        /*if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(fullName)) {
            fullNameView.setError(getString(R.string.error_field_required));
            focusView = fullNameView;
            cancel = true;
        }*/

        if (cancel) {
            focusView.requestFocus();
        } else {
            showProgress(true);

            startActivity(new Intent(RegistrationActivity.this, PostBus.class));
            finish();
        }
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            imageUri = data.getData();

            Picasso.with(getApplicationContext()).load(imageUri).into(userImageView);
        }
    }
}

