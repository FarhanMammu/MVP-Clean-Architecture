package test.farhan.cleanarchitecture.components;

import javax.inject.Singleton;

import dagger.Component;
import test.farhan.cleanarchitecture.MainActivity;
import test.farhan.cleanarchitecture.modules.CleanArchInterfaceModule;
import test.farhan.cleanarchitecture.modules.NetModule;

/**
 * Created by Cocoalabs on 02-03-2017.
 */

@Singleton
@Component(modules = {NetModule.class,CleanArchInterfaceModule.class})
public interface ApiInterfaceComponent {

    void inject(MainActivity mainActivity);
}
