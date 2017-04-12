package test.farhan.cleanarchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import test.farhan.cleanarchitecture.helper.CheckInternet;
import test.farhan.cleanarchitecture.interfaces.ApiInterface;
import test.farhan.cleanarchitecture.interfaces.ViewInterface;
import test.farhan.cleanarchitecture.model.ApiResponseModel;

public class MainActivity extends AppCompatActivity implements ViewInterface<ApiResponseModel>{

    @Inject
    ApiInterface apiInterface;
    private TextView name,fullName,description,type,size,errorText;
    private ImageView errorImage;
    private ProgressBar progressBar;
    private PresenterImplementation presenter;
    private Button button;
    private CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApp)getApplicationContext()).getApiInterface().inject(this);
        init();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CheckInternet.isOnline(MainActivity.this)) {
                    presenter.getItems();
                    showprogress();
                }else {
                    onNointernet();
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter=new PresenterImplementation(this,apiInterface);
    }

    private void init() {
        name= (TextView) findViewById(R.id.name);
        fullName= (TextView) findViewById(R.id.fullName);
        description= (TextView) findViewById(R.id.description);
        type= (TextView) findViewById(R.id.type);
        size= (TextView) findViewById(R.id.size);
        errorText= (TextView) findViewById(R.id.errorText);
        errorImage= (ImageView) findViewById(R.id.errorImage);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        button= (Button) findViewById(R.id.button);
        cardView= (CardView) findViewById(R.id.cardview);
    }

    @Override
    public void showprogress() {
        hideData();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onerror(String type) {
        hideprogress();
        hideData();
        errorImage.setVisibility(View.VISIBLE);
        errorText.setVisibility(View.VISIBLE);
        errorText.setText(type);
    }

    private void hideData() {
        cardView.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
    }

    @Override
    public void Showitems(ApiResponseModel model) {
        hideErrorData();
        button.setVisibility(View.GONE);
        hideprogress();
        cardView.setVisibility(View.VISIBLE);
        name.setText(model.getName());
        fullName.setText(model.getFull_name());
        description.setText(model.getDescription());
        type.setText(model.getOwnerModel().getType());
        size.setText(String.valueOf(model.getSize()));

    }

    private void hideErrorData() {
        errorText.setVisibility(View.GONE);
        errorImage.setVisibility(View.GONE);
    }

    @Override
    public void onServerError(String s) {

    }

    @Override
    public void onNointernet() {
        hideData();
        hideprogress();
        errorImage.setVisibility(View.VISIBLE);
        errorText.setVisibility(View.VISIBLE);
        errorText.setText("Please check your internet connection");
        button.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideprogress() {
        progressBar.setVisibility(View.GONE);
    }
}
