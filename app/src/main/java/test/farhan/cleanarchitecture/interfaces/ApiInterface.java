package test.farhan.cleanarchitecture.interfaces;

import retrofit2.http.GET;
import rx.Observable;
import test.farhan.cleanarchitecture.model.ApiResponseModel;


public interface ApiInterface {

    public String url="https://api.github.com/";

    @GET("repos/vmg/redcarpet")
    Observable<ApiResponseModel> get_data();
}
