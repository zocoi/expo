// Copyright 2018-present 650 Industries. All rights reserved.

#import <EXBluetooth/EXBluetooth.h>
#import <EXCore/EXUtilities.h>

@interface EXBluetooth ()

@property (nonatomic, weak) EXModuleRegistry *moduleRegistry;

@end

@implementation EXBluetooth

EX_EXPORT_MODULE(ExpoBluetooth);

EX_EXPORT_METHOD_AS(someMethod,
                    resolver:(EXPromiseResolveBlock)resolve
                    rejecter:(EXPromiseRejectBlock)reject) {
    resolve([NSNull null]);
}

@end
