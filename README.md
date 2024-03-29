# Microservice ms-product

Microservice responsible for providing all the information regarding the products managed by selfcare. It is needed for identify which product is valid for onboarding, which roles is enabled on product and if this one is delegable for a technology partner

## Required Configuration Properties

Before running you must set these properties as environment variables.


| **Property**                                  | **Environment Variable**                 | **Default** | **Required** |
|-----------------------------------------------|------------------------------------------|-------------|:------------:|
| spring.data.mongodb.uri<br/>                  | MONGODB_CONNECTION_URI                   |             |     yes      |
| jwt.signingKey<br/>                           | JWT_TOKEN_PUBLIC_KEY                     |             |     yes      |

## Running the application

You can run your application using:
```shell script
./mvnw install
./mvnw spring-boot:run -pl app
```

Application will respond to the url http://localhost:8080

## All Configuration Properties

| **Application properties** |
|:--------------------------:|

| **Property** | **Enviroment Variable** | **Default** | **Required** |
|--------------|-------------------------|-------------|:------------:|
|server.port|MS_PRODUCT_SERVER_PORT|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/app/src/main/resources/config/application.yml)| yes |
|spring.application.name| n/a |<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/app/src/main/resources/config/application.yml)| yes |
|spring.application.version| n/a |<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/app/src/main/resources/config/application.yml)| yes |
|spring.profiles.include| n/a |<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/app/src/main/resources/config/application.yml)| yes |
|spring.zipkin.enabled| n/a |<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/app/src/main/resources/config/application.yml)| yes |
|spring.sleuth.baggage.remote-fields| n/a |<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/app/src/main/resources/config/application.yml)| yes |
|spring.sleuth.baggage.correlation-fields| n/a |<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/app/src/main/resources/config/application.yml)| yes |
|info.build.artifact| n/a |<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/app/src/main/resources/config/application.yml)| yes |
|info.build.name| n/a |<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/app/src/main/resources/config/application.yml)| yes |
|info.build.description| n/a |<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/app/src/main/resources/config/application.yml)| yes |
|info.build.version| n/a |<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/app/src/main/resources/config/application.yml)| yes |
|logging.level.it.pagopa.selfcare| MS_PRODUCT_LOG_LEVEL |<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/app/src/main/resources/config/application.yml)| yes |
|logging.pattern.level| n/a |<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/app/src/main/resources/config/application.yml)| yes |


| **Azure Storage Configurations** |
|:--------------------------:|

| **Property** | **Enviroment Variable** | **Default** | **Required** |
|--------------|-------------------------|-------------|:------------:|
|blobStorage.connectionString|BLOB_STORAGE_CONN_STRING|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/connector/azure-storage/src/main/resources/config/azure-storage-config.properties)| yes |
|blobStorage.product.img.containerReference|BLOB_CONTAINER_REF|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/connector/azure-storage/src/main/resources/config/azure-storage-config.properties)| yes |
|blobStorage.product.upload.host|BLOBSTORAGE_PUBLIC_HOST|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/connector/azure-storage/src/main/resources/config/azure-storage-config.properties)| yes |


| **Dao Configurations** |
|:--------------------------:|

| **Property** | **Enviroment Variable** | **Default** | **Required** |
|--------------|-------------------------|-------------|:------------:|
|spring.data.mongodb.uri|MONGODB_CONNECTION_URI|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/connector/dao/src/main/resources/config/dao-config.properties)| yes |
|spring.data.mongodb.database|MONGODB_NAME|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/connector/dao/src/main/resources/config/dao-config.properties)| yes |


| **Core Configurations** |
|:--------------------------:|

| **Property**                             | **Enviroment Variable** | **Default** | **Required** |
|------------------------------------------|-------------------------|-------------|:------------:|
| product.img.logo.allowed-mime-types      |PRODUCT_LOGO_ALLOWED_MIME_TYPES|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/core/src/main/resources/config/core-config.properties)| yes |
| product.img.logo.allowed-extensions      |PRODUCT_LOGO_ALLOWED_EXTENSIONS|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/core/src/main/resources/config/core-config.properties)| yes |
| product.img.logo.default-url             |LOGO_STORAGE_URL|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/core/src/main/resources/config/core-config.properties)| yes |
| product.img.logo.default-url             |PUBLIC_FILE_STORAGE_BASE_URL|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/core/src/main/resources/config/core-config.properties)| yes |
| product.img.depiction.allowed-mime-types |PRODUCT_DEPICT_ALLOWED_MIME_TYPES|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/core/src/main/resources/config/core-config.properties)| yes |
| product.img.depiction.allowed-extensions |PRODUCT_DEPICT_ALLOWED_EXTENSIONS|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/core/src/main/resources/config/core-config.properties)| yes |
| product.img.logo.default-url             |DEPICT_IMAGE_URL|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/core/src/main/resources/config/core-config.properties)| yes |
| product.img.logo.default-url             |PUBLIC_FILE_STORAGE_BASE_URL|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/core/src/main/resources/config/core-config.properties)| yes |

| **Web Configurations** |
|:--------------------------:|

| **Property** | **Enviroment Variable** | **Default** | **Required** |
|--------------|-------------------------|-------------|:------------:|
|spring.servlet.multipart.max-file-size|MULTIPART_MAX_FILE_SIZE|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/web/src/main/resources/config/web-config.properties)| yes |
|spring.servlet.multipart.resolve-lazily| n/a |<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/web/src/main/resources/config/web-config.properties)| yes |
|spring.servlet.multipart.file-size-threshold|MULTIPART_MAX_FILE_SIZE|<a name= "default property"></a>[default_property](https://github.com/pagopa/selfcare-ms-product/blob/release-dev/web/src/main/resources/config/web-config.properties)| yes |
