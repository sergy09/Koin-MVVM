package com.sergiy.koinmvvm.injection

import com.sergiy.koinmvvm.business.use_cases.GetChannelListUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single { GetChannelListUseCase(get()) }
    //single { OtherUseCase(get()) }
    //single { OtherUseCase2(get()) }
    //single { OtherUseCase3(get()) }
}