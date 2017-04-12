package test.farhan.cleanarchitecture.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import test.farhan.cleanarchitecture.interfaces.ApiInterface;

/**
 * Created by Cocoalabs on 02-03-2017.
 */

@Module
public class CleanArchInterfaceModule {

    @Provides
    @Singleton
    public ApiInterface providesGitHubInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }
}
