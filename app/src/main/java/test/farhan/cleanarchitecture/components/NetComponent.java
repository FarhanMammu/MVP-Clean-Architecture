package test.farhan.cleanarchitecture.components;

import javax.inject.Singleton;

import dagger.Component;
import test.farhan.cleanarchitecture.modules.NetModule;

/**
 * Created by Cocoalabs on 02-03-2017.
 */


@Singleton
@Component(modules= {NetModule.class})
public interface NetComponent {
}
