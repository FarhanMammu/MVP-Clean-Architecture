package test.farhan.cleanarchitecture;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import test.farhan.cleanarchitecture.helper.CheckInternet;
import test.farhan.cleanarchitecture.helper.RxFunctions;
import test.farhan.cleanarchitecture.interfaces.ApiInterface;
import test.farhan.cleanarchitecture.interfaces.InteractorInterface;
import test.farhan.cleanarchitecture.model.ApiResponseModel;



public class InteractorImplementation implements InteractorInterface {

    private ApiInterface apiInterface;

    public InteractorImplementation(ApiInterface apiInterface) {
        this.apiInterface=apiInterface;
    }

    @Override
    public void getItems(DatafromServer datafromServer) {
        getObservable().compose(RxFunctions.<ApiResponseModel>applySchedulers())
                .subscribe(getObserver(datafromServer));
    }

    public Observable<ApiResponseModel> getObservable() {
        return apiInterface.get_data();
    }

    public Observer<ApiResponseModel> getObserver(final DatafromServer datafromServer) {
        return new Observer<ApiResponseModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                datafromServer.setError("Something went wrong.");
                e.printStackTrace();
            }

            @Override
            public void onNext(ApiResponseModel apiResponseModel) {
                datafromServer.onSetData(apiResponseModel);
            }
        };
    }
}
