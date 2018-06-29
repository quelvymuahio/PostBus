package com.project.quelvymuahio.postbus;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.net.Uri;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.project.quelvymuahio.postbus.Upload.UserUpload;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity{

    private static final int PICK_IMAGE_REQUEST = 1;

    private Uri imageUri;

    private StorageReference storageReference;
    private DatabaseReference databaseReference;

    // UI references.
    private AutoCompleteTextView fullNameView, userNameView , birthDateView, contactView;
    private EditText mPasswordView;
    private Button signUpButton;
    private ImageView userImageView;
    private View progressView;
    private ProgressBar progressBar;
    private View mLoginFormView;

    private String fullName, password, username, contact, birthDate;

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
        contactView = (AutoCompleteTextView) findViewById(R.id.registration_contact);
        userImageView = (ImageView) findViewById(R.id.registration_image);
        mPasswordView = (EditText) findViewById(R.id.registration_password);
        signUpButton = (Button) findViewById(R.id.sign_up_button);
        progressBar = (ProgressBar) findViewById(R.id.registration_progress);

        storageReference = FirebaseStorage.getInstance().getReference("users");
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

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
                fullName = fullNameView.getText().toString();
                password = mPasswordView.getText().toString();
                username = userNameView.getText().toString();
                contact = contactView.getText().toString();
                birthDate = birthDateView.getText().toString();

                //attemptLogin();
                uploadUserData();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        progressView = findViewById(R.id.login_progress);
    }

    private String getFileExtension(Uri uri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    private void uploadUserData() {
        if (imageUri != null){
            StorageReference fileReference = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(imageUri));

            fileReference.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(0);
                                }
                            }, 5000);
                            UserUpload userUpload = new UserUpload(fullName, username, password , contact, birthDate, taskSnapshot.getDownloadUrl().toString());
                            String uploadID = databaseReference.push().getKey();
                            databaseReference.child(uploadID).setValue(userUpload);

                            Toast.makeText(getApplicationContext(), "Salvo com sucesso!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(getApplicationContext(), "Indo gravar", Toast.LENGTH_SHORT).show();
                            /*double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            progressBar.setProgress((int) progress);*/
                        }
                    });

        }else{
            Toast.makeText(getApplicationContext(), "Nenhum ficheiro seleccionado.", Toast.LENGTH_SHORT).show();
        }
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
        userNameView.setError(null);
        contactView.setError(null);
        birthDateView.setError(null);

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            cancel = true;
        }

        if (TextUtils.isEmpty(fullName) ) {
            fullNameView.setError(getString(R.string.error_field_required));
            focusView = fullNameView;
            cancel = true;
        }
        if (TextUtils.isEmpty(username)) {
            userNameView.setError(getString(R.string.error_field_required));
            focusView = userNameView;
            cancel = true;
        }

        if (TextUtils.isEmpty(contact) ) {
            contactView.setError(getString(R.string.error_field_required));
            focusView = contactView;
            cancel = true;
        }
        if (TextUtils.isEmpty(birthDate)) {
            birthDateView.setError(getString(R.string.error_field_required));
            focusView = birthDateView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            showProgress(true);

            //startActivity(new Intent(RegistrationActivity.this, PostBus.class));
            //finish();
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

            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            progressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {

            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
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

