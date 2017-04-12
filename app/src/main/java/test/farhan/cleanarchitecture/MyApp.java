package test.farhan.cleanarchitecture;

import android.app.Application;
import test.farhan.cleanarchitecture.components.ApiInterfaceComponent;
import test.farhan.cleanarchitecture.components.DaggerApiInterfaceComponent;



public class MyApp extends Application {

    private ApiInterfaceComponent apiInterfaceComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        apiInterfaceComponent= DaggerApiInterfaceComponent.builder().build();
    }
    public ApiInterfaceComponent getApiInterface() {
        return apiInterfaceComponent;
    }
}
