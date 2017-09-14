# protobuf-android
根 build.gradle

```groovy
dependencies {
    ...
    classpath 'com.google.protobuf:protobuf-gradle-plugin:0.8.3'
}
```

app build.gradle

```groovy
dependencies {
    ...
    implementation project(':protobuf')
}
```

protobuf里src/main/proto下新建.proto文件，样例：

```protobuf
syntax = "proto2";
option java_package = "com.centling.protobuf";
package bean;
message Entity {
    optional string attrcd = 1;
    optional string cd = 2;
    optional string speccn = 3;
    optional string specen = 4;
    optional string statecd = 5;
    optional string statenm = 6;
    optional string countrycd = 7;
    optional string countrynm = 8;
}

message basecodelist {
    repeated Entity entity = 1;
}
```

make project生成java类