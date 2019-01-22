// Copyright 2018-present 650 Industries. All rights reserved.

#import <EXHaptics/EXHapticsModule.h>

@interface EXHapticsModule ()

@property (nonatomic, weak) EXModuleRegistry *moduleRegistry;

@end

@implementation EXHapticsModule

EX_EXPORT_MODULE(ExpoHaptics);

- (void)setModuleRegistry:(EXModuleRegistry *)moduleRegistry
{
  _moduleRegistry = moduleRegistry;
}

EX_EXPORT_METHOD_AS(someGreatMethodAsync,
                    options:(NSDictionary *)options
                    resolve:(EXPromiseResolveBlock)resolve
                    reject:(EXPromiseRejectBlock)reject)
{
}

@end
