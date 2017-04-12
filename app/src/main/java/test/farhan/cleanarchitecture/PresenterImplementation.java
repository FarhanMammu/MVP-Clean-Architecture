package test.farhan.cleanarchitecture;

import android.util.Log;

import test.farhan.cleanarchitecture.interfaces.ApiInterface;
import test.farhan.cleanarchitecture.interfaces.InteractorInterface;
import test.farhan.cleanarchitecture.interfaces.PresenterInterface;
import test.farhan.cleanarchitecture.interfaces.ViewInterface;
import test.farhan.cleanarchitecture.model.ApiResponseModel;


public class PresenterImplementation implements PresenterInterface,InteractorInterface.DatafromServer<ApiResponseModel> {


    private InteractorImplementation interactor;
    private ViewInterface viewInterface;

    public PresenterImplementation(ViewInterface viewInterface, ApiInterface apiInterface) {
        this.viewInterface=viewInterface;
        interactor=new InteractorImplementation(apiInterface);
    }

    @Override
    public void onSetData(ApiResponseModel data) {
        viewInterface.Showitems(data);
    }

    @Override
    public void setError(String message) {
        viewInterface.onerror(message);
    }

    @Override
    public void Nointerneterror() {
        viewInterface.onNointernet();
    }

    @Override
    public void getItems() {
        Log.e("prstr", "getItems: " );
        interactor.getItems(this);
    }
}
